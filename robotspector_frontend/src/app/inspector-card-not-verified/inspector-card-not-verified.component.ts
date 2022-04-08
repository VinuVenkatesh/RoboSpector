import { Component, Input, OnInit } from '@angular/core';
import { Equipment } from '../equipment-single-view/Equipment';
import { DataService } from '../services/data-service.service';

@Component({
  selector: 'app-inspector-card-not-verified',
  templateUrl: './inspector-card-not-verified.component.html',
  styleUrls: ['./inspector-card-not-verified.component.css']
})
export class InspectorCardNotVerifiedComponent implements OnInit {

  @Input()
  currentVerifyModalState:boolean = false;

  @Input()
  equipmentName?:string;

  @Input()
  date?:string;

  @Input()
  collectingTime?:number;

  @Input()
  currentInspectionId?:string;
  

  constructor(private dataSharing:DataService) { }

  ngOnInit(): void {
    this.dataSharing.currentVerifyModalState.subscribe((data:boolean) =>{
      this.currentVerifyModalState = data;
    })
    this.dataSharing.curentSelectedEquipment.subscribe((data:any) =>{
      this.equipmentName = data.name;
    })
  }


  onClickVerify(){
    console.log("Verify clicked",this.currentInspectionId);
    this.currentVerifyModalState = !this.currentVerifyModalState;
    this.dataSharing.changeCurrentVerifyModalState(this.currentVerifyModalState);
    this.dataSharing.changeCurrentInspectionId(this.currentInspectionId == undefined ? "":this.currentInspectionId);
  }
}
