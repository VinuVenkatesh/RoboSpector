import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table-row',
  templateUrl: './table-row.component.html',
  styleUrls: ['./table-row.component.css']
})
export class TableRowComponent implements OnInit {

  severity?:String;
  constructor() { }

  ngOnInit(): void {
  }

  getColor(){
    switch(this.severity){
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
}
