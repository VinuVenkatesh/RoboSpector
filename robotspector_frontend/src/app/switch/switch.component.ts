import { Component, Input, OnInit } from '@angular/core';
import { DataService } from '../services/data-service.service';

@Component({
  selector: 'app-switch',
  templateUrl: './switch.component.html',
  styleUrls: ['./switch.component.css']
})
export class SwitchComponent implements OnInit {


  @Input()
  switchActive:boolean = false;
  clickCount:number = 0;
  constructor(private dataSharing:DataService) { 
    this.dataSharing.showVerified.subscribe((data:boolean) =>{
      this.switchActive = data;
    })
  }

  ngOnInit(): void {}

  onClickSwitch(){
    this.clickCount+= 1;
    this.switchActive = !this.switchActive;
    this.dataSharing.changeShowVerifiedStatus(this.switchActive);
  }
}
