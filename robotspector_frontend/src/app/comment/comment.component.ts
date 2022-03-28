import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit {

  constructor() { }

  @Input() author?:String;
  @Input() image?:String;
  @Input() comment?:String;
  @Input() role?:String;
  @Input() date?:String
  ngOnInit(): void {

  }
  getBorderColor(){
    console.log("the role is" + this.role);
    if ( this.role == "admin"){
      return "#5C5CE0";
    }else if (this.role == "engineer"){
      return "#E05C5C";
    }else {
      return "#FEC601";
    }
  }
}
