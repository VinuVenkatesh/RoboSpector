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

  constructor(private dataSharing: DataService) { }

  ngOnInit(): void {
    this.dataSharing.detailedEquipmentData.subscribe((res:any) =>{
      this.title = res.name;
    })
  }
  
  onKeyUp(){
    console.log("key down clicked");
    this.dataSharing.changeDashboardInputText(this.dashboardSearchText);
  }
}
