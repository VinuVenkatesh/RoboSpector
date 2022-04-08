import { Component, OnInit} from '@angular/core';


@Component({
  selector: 'app-dashboard-sidebar',
  templateUrl: './dashboard-sidebar.component.html',
  styleUrls: ['./dashboard-sidebar.component.css']
})
export class DashboardSidebarComponent implements OnInit {

  constructor() { }

  dashboardButtonTitles:String[] = ["overview","inspection"];
  dashboardButtonImages:String[] = ["comments_icon","inspection_icon"];
  ngOnInit(): void {
  }
  changeCurrentView(e:Event){
    console.log("Chanage view from dashboard");
  }
}
