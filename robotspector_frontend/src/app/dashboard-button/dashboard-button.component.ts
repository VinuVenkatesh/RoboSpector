import { i18nMetaToJSDoc } from '@angular/compiler/src/render3/view/i18n/meta';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-dashboard-button',
  templateUrl: './dashboard-button.component.html',
  styleUrls: ['./dashboard-button.component.css']
})
export class DashboardButtonComponent implements OnInit {


  @Input()
  title:String = "";
  @Input()
  image?:String;
  @Output() 
  public dashBoardButtonClicked;

  constructor() {
    this.dashBoardButtonClicked = new EventEmitter<string>();
   }

  ngOnInit(): void {
  }
  onDashBoardButtonClicked(){
    console.log("Dash board button clicked");
    this.dashBoardButtonClicked.emit(this.title.valueOf());
  }
  
}
