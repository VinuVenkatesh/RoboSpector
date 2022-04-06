import { Component, Input, OnInit } from '@angular/core';
import { DataService } from '../services/data-service.service';
import { EquipmentService } from '../services/EquipmentService';

@Component({
  selector: 'app-main-dashboard',
  templateUrl: './main-dashboard.component.html',
  styleUrls: ['./main-dashboard.component.css'],
  animations: [
    // animation triggers go here
  ]
})
export class MainDashboardComponent implements OnInit {


  @Input()
  title?:String;

  @Input()
  dashboardSearchText?:String;

  @Input()
  createModalState:Boolean = false;

  @Input()
  currentRowId:any;

  constructor(private dataSharing: DataService, private equipmentService:EquipmentService) { }

  ngOnInit(): void {
    this.dataSharing.detailedEquipmentData.subscribe((res:any) =>{
      this.title = res.name;
    })
    this.dataSharing.currentCreateModalState.subscribe((res:any) =>{
      this.createModalState = res;
    })
    this.dataSharing.currentSelectedRowData.subscribe((res:any) =>{
      this.currentRowId = res;
    })
  }
  
  onKeyUp(){
    console.log("key down clicked");
    this.dataSharing.changeDashboardInputText(this.dashboardSearchText);
  }
  onClickAddButton(){
    this.dataSharing.changeCurrentCreateModalState(true);
  }
  onClickDeleteButton(){
    this.equipmentService.deleteEquipment(this.currentRowId).subscribe((data:any) =>{
      console.log("=============");
      console.log("delete request sent", data);
      console.log("=============");
    });
  }
}
