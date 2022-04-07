import { Component, Input, OnInit } from '@angular/core';
import { EquipmentService } from '../services/EquipmentService';
import { Subscription } from 'rxjs';
import { DataService } from '../services/data-service.service';

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

  currentRole?:string;
  subscription?: Subscription;

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
    this.subscription = this.dataSharing.currentRole.subscribe(data => {
      this.currentRole = data;
      console.log(this.currentRole);
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
    this.dataSharing.changeCurrentAlertState(true);
    // this.equipmentService.deleteEquipment(this.currentRowId).subscribe((data:any) =>{
    //     if (data != null){
    //       this.equipmentService.getAllEquipment().subscribe((data:any) =>{
    //         this.dataSharing.changeCurrentEquipmentList(data);
    //       })
    //     }
    // });
  
  }
  ngOnDestroy(){
    this.subscription?.unsubscribe();
  }
}
