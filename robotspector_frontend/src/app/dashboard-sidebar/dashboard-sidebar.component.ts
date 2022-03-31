import { Component, OnInit} from '@angular/core';


@Component({
  selector: 'app-dashboard-sidebar',
  templateUrl: './dashboard-sidebar.component.html',
  styleUrls: ['./dashboard-sidebar.component.css']
})
export class DashboardSidebarComponent implements OnInit {

  constructor() { }

  dashboardButtonTitles:String[] = ["comments","inspection","location"];
  dashboardButtonImages:String[] = ["comments_icon","inspection_icon","location_icon"];
  ngOnInit(): void {
  }
  changeCurrentView(e:Event){
    console.log("Chanage view from dashboard");
  }
}
