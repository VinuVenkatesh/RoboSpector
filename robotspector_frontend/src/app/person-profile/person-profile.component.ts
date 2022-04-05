import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataServiceService } from '../services/data-service.service';

@Component({
  selector: 'app-person-profile',
  templateUrl: './person-profile.component.html',
  styleUrls: ['./person-profile.component.css']
})
export class PersonProfileComponent implements OnInit {

  logoutButton:any;
  logoutName:any;
  display:String = "none";
  backgroundColor:String = "transparent"
  showShadow:Boolean = false;
  userName?: string;
  constructor(private router:Router, private dataServiceService : DataServiceService) {}

  ngOnInit(): void {
    this.logoutButton = document.querySelector("#logout-button");
    this.logoutName = document.querySelector("#logout-name");
    this.dataServiceService.currentUserName.subscribe(data =>{
      this.userName = data;
    })
  }

  onMouseOver(e:MouseEvent){
    this.backgroundColor = "white";
    this.display = "block";
    this.showShadow = true
    
  }
  onMouseLeave(e:MouseEvent){
    this.backgroundColor = "transparent";
    this.display = "none";
    this.showShadow = false;
  }
  getDisplay(){
    return this.display;
  }
  getBackgroundColor(){
    return this.backgroundColor;
  }
  getBoxShadow(){
  
    return this.showShadow ? "0px 10px 2px -3px rgba(0,0,0,0.1)" : '';
  }
  logout(){
    this.router.navigate(['']);
  }
}
