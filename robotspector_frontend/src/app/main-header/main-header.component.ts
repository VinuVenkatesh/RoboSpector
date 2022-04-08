import { Component, Input, OnInit } from '@angular/core';
import { DataService } from '../services/data-service.service';

@Component({
  selector: 'app-main-header',
  templateUrl: './main-header.component.html',
  styleUrls: ['./main-header.component.css']
})
export class MainHeaderComponent implements OnInit {

  @Input()
  title?:String;
  @Input()
  equipmentName?:string;
  constructor(private dataSharing:DataService) { }

  ngOnInit(): void {
    this.dataSharing.curentSelectedEquipment.subscribe((data:any) =>{
      this.equipmentName = data.name;
    })
  }

}
