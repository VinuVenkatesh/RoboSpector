import { Component, Input, OnInit } from '@angular/core';
import { DataService } from '../services/data-service.service';

@Component({
  selector: 'app-severity-button',
  templateUrl: './severity-button.component.html',
  styleUrls: ['./severity-button.component.css']
})
export class SeverityButtonComponent implements OnInit {
  @Input()
  currentSeverity?:string;

  constructor(private dataSharing:DataService) { }

  ngOnInit(): void {
    this.dataSharing.selectedSeverity.subscribe((data:string) =>{
      this.currentSeverity = data;
    })
  }
  @Input()
  title:string = ""; 

  @Input()
  isActive:boolean = false;

  
  onClickSeverity(){
    console.log("severity clicked", this.isActive);
    this.isActive = !this.isActive;
    this.dataSharing.changeSelectedSeverity(this.title);
  }
  getButtonColor(){
    return   this.title == this.currentSeverity  ? '#0E3C4E':'#fff';
  }
  getFontColor(){
    return  this.title == this.currentSeverity? '#fff':'#000';
  }
  getFontWeight(){
    return  this.title == this.currentSeverity ? 'bold':'';
  }
}
