import { Component, Input, OnInit } from '@angular/core';
import { DataService } from '../services/data-service.service';
import { RouterService } from '../services/router.service';
import { DetailedEquipmentOverview } from './detailedEquipmentOverview';
@Component({
  selector: 'app-detailed-equipment-overview',
  templateUrl: './detailed-equipment-overview.component.html',
  styleUrls: ['./detailed-equipment-overview.component.css']
})
export class DetailedEquipmentOverviewComponent implements OnInit {

  constructor(private dataSharing: DataService, private router:RouterService) { }

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
  goToEquipmentSingleView(){
    this.router.routeToEquipmentSingleView();
  }
  getSeverityName(){
    return this.currentEquipment?.inspection?.verificationDetails?.severity != undefined ? this.currentEquipment?.inspection?.verificationDetails?.severity: 'Inspection TBA'
  }
  getColor(){
    switch(this.currentEquipment?.inspection?.verificationDetails?.severity){
      case undefined:
        return "#F05365";
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
    switch(this.detailedEquipmentOverview?.age){
      case 0:
        return "#f05365";
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
