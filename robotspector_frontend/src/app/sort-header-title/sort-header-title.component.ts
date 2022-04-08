import { animate, state, style, transition, trigger } from '@angular/animations';
import { Component, Input, OnInit } from '@angular/core';
import { DataService } from '../services/data-service.service';

@Component({
  selector: 'app-sort-header-title',
  templateUrl: './sort-header-title.component.html',
  styleUrls: ['./sort-header-title.component.css'],
  animations: [
    trigger('changeSortSorder', [
      state('asc', style({
        transform: "scaleY(-1)",
      })),
      state('dsc', style({
        transform: "scaleY(1)",
      })),
      transition('asc => dsc', [
        animate('0.1s')
      ]),
      transition('dsc => asc', [
        animate('0.1s')
      ]),
    ]),
  ],
})
export class SortHeaderTitleComponent implements OnInit {

  
  @Input()
  title?:String;
  @Input()
  asc?:Boolean;
  constructor(private dataSharing: DataService) { }
  ngOnInit(): void {}

  onClickSort(){
    this.asc = !this.asc;
    this.dataSharing.changeSortOrder({column:this.title,order: this.asc == true ? 'asc':'dsc'});
  }

}
