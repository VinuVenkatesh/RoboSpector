import { Component, Input, OnInit } from '@angular/core';
import { DataService } from '../services/data-service.service';
import { DetailedEquipmentOverview } from './detailedEquipmentOverview';
@Component({
  selector: 'app-detailed-equipment-overview',
  templateUrl: './detailed-equipment-overview.component.html',
  styleUrls: ['./detailed-equipment-overview.component.css']
})
export class DetailedEquipmentOverviewComponent implements OnInit {

  constructor(private dataSharing: DataService) { }

  @Input()
  detailedEquipmentOverview?:DetailedEquipmentOverview;

  @Input()
  currentEquipment:any;

  @Input()
  age?:number;

  ngOnInit(): void {
    this.dataSharing.detailedEquipmentData.subscribe((res:any) =>{
      this.detailedEquipmentOverview = res;
    })
    this.dataSharing.curentSelectedEquipment.subscribe((res:any) =>{
      this.currentEquipment = res;
    })
  }
  getAgeColor(){
    switch(this.detailedEquipmentOverview?.age){
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
}
