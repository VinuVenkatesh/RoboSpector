import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { DataServiceService } from '../services/data-service.service';

@Component({
  selector: 'app-dashboard-button',
  templateUrl: './dashboard-button.component.html',
  styleUrls: ['./dashboard-button.component.css']
})
export class DashboardButtonComponent implements OnInit {


  @Input()
  title:String = "ddsada";
  @Input()
  image?:String;
  

  constructor(private dataSharing: DataServiceService) {
    // this.dataSharing.SharingData.subscribe((res:any) =>{
    //   this.title = res;
    // })
   }

  ngOnInit(): void {
    
  }
  onDashBoardButtonClicked(){
    this.dataSharing.changeDataSubject(this.title);
  }
  
}
