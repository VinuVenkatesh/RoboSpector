import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard-button',
  templateUrl: './dashboard-button.component.html',
  styleUrls: ['./dashboard-button.component.css']
})
export class DashboardButtonComponent implements OnInit {


  @Input()
  title?:String;
  @Input()
  image?:String;

  constructor() { }

  ngOnInit(): void {
  }

}
