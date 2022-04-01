import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-table-row',
  templateUrl: './table-row.component.html',
  styleUrls: ['./table-row.component.css']
})
export class TableRowComponent implements OnInit {
  @Input()
  level:String = '';
  @Input()
  age:String = '';
  constructor() { }

  ngOnInit(): void {
  }

  getColor(){
    
    switch(this.level){
      case "1":
        return "86E05C";
      case "2":
        return "DDE05C";
      case "3":
        return "E99363";
      case "4":
        return "E05C5C";
      case "5":
        return "A91212";
      default:
        return "86E05C";
    }
  }
  getAgeColor(){
    switch(this.age){
      case "1":
      case "20":
        return "3BF0CF";
      case "30":
      case "40":
        return "23B5D3";
      case "40":
      case "50":
        return "279AF1";
      case "60":
      case "70":
        return "473BF0";
      case "80":
      case "90":
      case "100":
        return "EA526F";
      default:
        return "86E05C";
    }
  }
}
