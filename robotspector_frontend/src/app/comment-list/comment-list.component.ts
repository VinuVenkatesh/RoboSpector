import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-comment-list',
  templateUrl: './comment-list.component.html',
  styleUrls: ['./comment-list.component.css']
})
export class CommentListComponent implements OnInit {

  constructor() { }
  slider:any;
  isDown:any = false;
  startY:any;
  scrollTop:any;
  comments:String[] = [
    "Is simply dummy text of the printing and typesetting industry.",
    "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
    "It was popularised in the 1960s with the release of Letraset sheets containing Lorem",
    "Here are many variations of passages of Lorem Ipsum available",
    "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested."
  ];

  ngOnInit(): void {
    this.slider = document.querySelector('#comments');
  }

  onMouseDown(e:MouseEvent){
    this.isDown = true;
    this.slider.classList.add('active');
    this.startY = e.pageY - this.slider.offsetHeight;
    this.scrollTop = this.slider.scrollTop ;
  }
  onMouseLeave(e:MouseEvent){
    this.isDown = false;
    this.slider.classList.remove('active');
  }
  onMouseUp(e:MouseEvent){
    console.log("Mouse UP",this.slider);
    this.isDown = false;
    this.slider.classList.remove('active');
  }
  onMouseMove(e:MouseEvent){
    if(!this.isDown) return;
    e.preventDefault();
    const y = e.pageY - this.slider.offsetHeight;
    const walk = (y - this.startY) * 3; //scroll-fast
    this.slider.scrollTop = this.scrollTop - walk;
  }


}
