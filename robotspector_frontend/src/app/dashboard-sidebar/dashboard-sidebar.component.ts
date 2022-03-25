import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard-sidebar',
  templateUrl: './dashboard-sidebar.component.html',
  styleUrls: ['./dashboard-sidebar.component.css']
})
export class DashboardSidebarComponent implements OnInit {

  constructor() { }

  dashboardButtonTitles:String[] = ["comments","clock","inspection","location"];
  dashboardButtonImages:String[] = ["comments_icon","clock_icon","inspection_icon","location_icon"];

  ngOnInit(): void {
  }

}
