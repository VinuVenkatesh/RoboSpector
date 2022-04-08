import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { DataService } from '../services/data-service.service';

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
  

  constructor(private dataSharing: DataService) {
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
