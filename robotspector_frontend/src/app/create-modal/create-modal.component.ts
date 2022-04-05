import { Component, Input, OnInit } from '@angular/core';
import { DataService } from '../services/data-service.service';
import {
  trigger,
  state,
  style,
  animate,
  transition,
  // ...
} from '@angular/animations';
@Component({
  selector: 'app-create-modal',
  templateUrl: './create-modal.component.html',
  styleUrls: ['./create-modal.component.css'],
  animations: [
    trigger('fade', [
      transition('* => show', [ // using status here for transition
        style({ opacity: 0 }),
        animate(250, style({ opacity: 1 }))
      ]),
      transition('* => void', [
        animate(100, style({ opacity: 0 }))
      ])
    ])
  ]
})
export class CreateModalComponent implements OnInit {

 

  @Input()
  createModalState:Boolean = false;

  constructor(private dataSharing: DataService) {}

  ngOnInit(): void {
    this.dataSharing.currentCreateModalState.subscribe((res:any) =>{
      console.log("The current modal state is", res);
      this.createModalState = res;
    })
  }
  toggleCreateModalState(){
    this.dataSharing.changeCurrentCreateModalState(false);
  }
}
