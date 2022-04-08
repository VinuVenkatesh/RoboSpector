import { Component, Input, OnInit } from '@angular/core';
import { Equipment } from '../equipment-single-view/Equipment';
import { Inspection } from '../model/Inspection.model';
import { DataService } from '../services/data-service.service';
import { EquipmentSingleViewService } from '../services/equipment-single-view.service';

@Component({
  selector: 'app-table-row',
  templateUrl: './table-row.component.html',
  styleUrls: ['./table-row.component.css']
})
export class TableRowComponent implements OnInit {
  @Input()
  level?:Number;
  @Input()
  age?:Number;
  @Input()
  name?:String;
  @Input()
  location?:String;
  @Input()
  collection?:number;
  @Input()
  isSelected:Boolean = false;
  @Input()
  equipment?:Equipment;
  @Input()
  severityName?:string;
  @Input()
  inspectionList?:any;

  @Input()
  listOfSeverityNames?:any;
  constructor(private dataSharing: DataService, private equipmentSingleViewService:EquipmentSingleViewService) { }

  ngOnInit(): void {
    this.dataSharing.currentSelectedRowData.subscribe((data:any) =>{
      console.log("The data is", data);
      this.dataSharing.changeEquipmentId(data);
      this.isSelected = this.equipment?.id == data ;
      
    })
    
      this.equipmentSingleViewService.getAllInspections(this.equipment?.id).subscribe(data =>{
        this.inspectionList = data;
        console.log("The inspection list is",this.inspectionList);
        let withNames = this.inspectionList.filter((a:Inspection) => a.verificationDetails?.inspectionResult?.name != undefined || a.verificationDetails?.inspectionResult?.name != null );
        let inspectionNames = withNames.map((a:Inspection) => a.verificationDetails?.inspectionResult?.severity);
        console.log("das dasd asdadad asd",inspectionNames[this.getRandomInt(inspectionNames.length - 1)]);
        this.level = inspectionNames[this.getRandomInt(inspectionNames.length - 1)];
        console.log("the number is ",this.getRandomInt(inspectionNames.length - 1));
        
      })
    
  }
   getRandomInt(max:any) {
    return Math.floor(Math.random() * 10);
  }

  getColor(){
  
    switch(this.level){
      case null:
        return "F05365";
      case 1:
        return "86E05C";
      case 2:
        return "DDE05C";
      case 3:
        return "E99363";
      case 4:
        return "E05C5C";
      case 5:
        return "A91212";
      default:
        return "86E05C";
    }
  }
  getAgeColor(){
    let colorAge = this.age== undefined?0:this.age;
    switch(true){
      case colorAge < 20:
        return "3BF0CF";
      case colorAge < 30:
        return "23B5D3";
      case colorAge < 50:
        return "279AF1";
      case colorAge <70:
        return "473BF0";
      case colorAge <100:
        return "EA526F";
      default:
        return "86E05C";
    }
  }
  getSelectionStatus(){
    
    return this.isSelected ? '0E3C4E':'F7F7FF';
  }
  getTextColor(){
    return this.isSelected ? 'FFFFFF':'000000';
  }
  getFontSize(){
    return this.isSelected ? '500': '400';
  }
  changeDetailedEquipmentOverview(){
    console.log("The detailed view has been clicked");
    this.dataSharing.changeCurrentSelectedRowData(this.equipment?.id);
    this.dataSharing.changeCurentSelectedEquipment(this.equipment);
    this.dataSharing.changedetailedEquipmentData({age:this.age,name:this.name,collectionTime:this.collection});
    console.log("Selection status is", this.isSelected);
  }
}
