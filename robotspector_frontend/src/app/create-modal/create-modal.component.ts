import { Component, Input, OnInit } from '@angular/core';
import { DataService } from '../services/data-service.service';
import {
  trigger,
  state,
  style,
  animate,
  transition,
  // ...
} from '@angular/animations';
import { EquipmentService } from '../services/EquipmentService';
import { FormBuilder, FormControl } from '@angular/forms';
import { Equipment } from '../equipment-single-view/equipment';
import { Location } from '../equipment-single-view/location';
@Component({
  selector: 'app-create-modal',
  templateUrl: './create-modal.component.html',
  styleUrls: ['./create-modal.component.css'],
  animations: [
    trigger('fade', [
      transition('* => show', [ // using status here for transition
        style({ opacity: 0 }),
        animate(250, style({ opacity: 1 }))
      ]),
      transition('* => void', [
        animate(100, style({ opacity: 0 }))
      ])
    ])
  ]
})
export class CreateModalComponent implements OnInit {

 

  @Input()
  createModalState:Boolean = false;

  name = new FormControl();
  locationurl = new FormControl();
  long = new FormControl();
  lat = new FormControl();
  age = new FormControl();
  comment = new FormControl();
  equipmentLength?:string;
  equipmentList:any;
  equipmentForm: any;
  @Input()
  ageSliderValue:any = 50;
  constructor(private formBuilder:FormBuilder,private dataSharing: DataService, private equipmentService:EquipmentService) {}
  
  
  ngOnInit(): void {
    this.dataSharing.currentCreateModalState.subscribe((res:any) =>{
      console.log("The current modal state is", res);
      this.createModalState = res;
    })
    this.dataSharing.currentEquipmentLength.subscribe((data:string) =>{
      
      this.equipmentLength = data;
      
    })
    this.dataSharing.currentEquipmentList.subscribe((data:any) =>{
      this.equipmentList = data;
      console.log("log from current equipment");
    })
    this.equipmentForm = this.formBuilder.group({
      name: "",
      locationurl: "",
      long:"",
      lat:"",
      age:"",
      comment:"",
   })
  }
  AfterViewInit():void{
    this.dataSharing.currentEquipmentList.subscribe((data:any) =>{
      this.equipmentList = data;
      console.log("log from current equipment");
    })
  }
  toggleCreateModalState(){
    this.dataSharing.changeCurrentCreateModalState(false);
  }

  onCreateEquipmentSubmit(){
    const equipmentToSend = new Equipment();
    const location = new Location();
    const maxId = this.equipmentList.sort((a:any,b:any) => b.id - a.id)[0];
    equipmentToSend.id = (maxId).toString();
    const formValues = this.equipmentForm.value;
    location.localtionurl = formValues.locationurl;
    location.longitude = formValues.long;
    location.latitude = formValues.lat;
    equipmentToSend.location = location;

    equipmentToSend.name = formValues.name;
    equipmentToSend.comment = formValues.comment;
    equipmentToSend.aging = formValues.age;
    
    this.equipmentService.createEquipment(equipmentToSend).subscribe((createData:any) =>{
      if (createData != null){
        this.equipmentService.getAllEquipment().subscribe((data:any) =>{
          this.dataSharing.changeCurrentEquipmentList(data);
        })
      }
    });
    
    this.dataSharing.changeCurrentCreateModalState(false);
  }
  convertToEquipmentList(data:any):any{
    let listOfEquipment = [];
    for (let index = 0; index < data.length; index++) {
      const element = data[index];
      let equipment = new Equipment();
      let location = new Location();
      location.localtionurl = data.location.locationurl;
      location.longitude = data.location.longitude;
      location.latitude = data.location.latitude;
      equipment.location = location;
      equipment.name = data.name;
      equipment.comment = data.comment;
      equipment.aging = data.aging;
      listOfEquipment.push(element);
    }
    return listOfEquipment;
  }
  setSliderValue(event:any){
    this.ageSliderValue = parseInt(event.target.value);
  }
}
