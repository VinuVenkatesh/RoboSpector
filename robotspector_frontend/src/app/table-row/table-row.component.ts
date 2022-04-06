import { Component, Input, OnInit } from '@angular/core';
import { Equipment } from '../equipment-single-view/equipment';

import { DataService } from '../services/data-service.service';

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
  constructor(private dataSharing: DataService) { }

  ngOnInit(): void {
    this.dataSharing.currentSelectedRowData.subscribe((data:any) =>{
      console.log("The data is", data);
      this.isSelected = this.equipment?.id == data ;
    })
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
    switch(this.age){
      case 1:
      case 20:
        return "3BF0CF";
      case 30:
        return "23B5D3";
      case 40:
      case 50:
        return "279AF1";
      case 60:
      case 70:
        return "473BF0";
      case 80:
      case 90:
      case 100:
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
