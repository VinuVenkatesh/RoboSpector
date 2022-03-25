import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-equipment-single-view',
  templateUrl: './equipment-single-view.component.html',
  styleUrls: ['./equipment-single-view.component.css']
})
export class EquipmentSingleViewComponent implements OnInit {

  constructor() { }

  @Input()
  title?:String;

  ngOnInit(): void {
  }

}
