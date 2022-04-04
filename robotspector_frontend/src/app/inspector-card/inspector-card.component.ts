import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-inspector-card',
  templateUrl: './inspector-card.component.html',
  styleUrls: ['./inspector-card.component.css']
})
export class InspectorCardComponent implements OnInit {

  @Input()
  severityLevel?:number;

  @Input()
  collectingTime?: number;

  @Input()
  date? : string;
  
  @Input()
  engineerName? : string;

  @Input()
  verificationDate?: string;
  
  @Input()
  verificationComment? : string;

  constructor() { }

  ngOnInit(): void {
  }

  getColor(){

    switch(this.severityLevel){
      
      case 1:
        return "#86E05C";
      case 2:
        return "#DDE05C";
      case 3:
        return "#E99363";
      case 4:
        return "#E05C5C";
      case 5:
        return "#A91212";
      default:
        return "#DDE05C";
    }
   
  }
}
