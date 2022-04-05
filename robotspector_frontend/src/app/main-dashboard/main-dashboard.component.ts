import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { DataServiceService } from '../services/data-service.service';

@Component({
  selector: 'app-main-dashboard',
  templateUrl: './main-dashboard.component.html',
  styleUrls: ['./main-dashboard.component.css']
})
export class MainDashboardComponent implements OnInit {

  currentRole?:string;
  subscription?: Subscription;

  constructor(private data : DataServiceService) { }

  ngOnInit(): void {
    this.subscription = this.data.currentRole.subscribe(data => {
      this.currentRole = data;
      console.log(this.currentRole);
    })
  }
  ngOnDestroy(){
    this.subscription?.unsubscribe();
  }
}
