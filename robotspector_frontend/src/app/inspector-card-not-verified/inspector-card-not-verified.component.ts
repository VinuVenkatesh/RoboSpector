import { Component, Input, OnInit } from '@angular/core';
import { DataService } from '../services/data-service.service';

@Component({
  selector: 'app-inspector-card-not-verified',
  templateUrl: './inspector-card-not-verified.component.html',
  styleUrls: ['./inspector-card-not-verified.component.css']
})
export class InspectorCardNotVerifiedComponent implements OnInit {

  @Input()
  currentVerifyModalState:boolean = false;

  constructor(private dataSharing:DataService) { }

  ngOnInit(): void {
    this.dataSharing.currentVerifyModalState.subscribe((data:boolean) =>{
      this.currentVerifyModalState = data;
    })
  }


  onClickVerify(){
    console.log("Verify clicked");
    this.currentVerifyModalState = !this.currentVerifyModalState;
    this.dataSharing.changeCurrentVerifyModalState(this.currentVerifyModalState);
  }
}
