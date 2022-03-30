import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-commenter-list',
  templateUrl: './commenter-list.component.html',
  styleUrls: ['./commenter-list.component.css']
})
export class CommenterListComponent implements OnInit {

  constructor() { }

  slider:any;
  isDown:any = false;
  startX:any;
  scrollLeft:any;

  ngOnInit(): void {
    this.slider = document.querySelector('#commenters');
  }
  onMouseDown(e:MouseEvent){
    console.log("Mouse has been clicked down");
    
    this.isDown = true;
    this.slider.classList.add('active');
    this.startX = e.pageX - this.slider.offsetLeft;
    this.scrollLeft = this.slider.scrollLeft;
  }
  onMouseLeave(e:MouseEvent){
    this.isDown = false;
    this.slider.classList.remove('active');
  }
  onMouseUp(e:MouseEvent){
    this.isDown = false;
    this.slider.classList.remove('active');
  }
  onMouseMove(e:MouseEvent){
    if(!this.isDown) return;
    e.preventDefault();
    const x = e.pageX - this.slider.offsetLeft;
    const walk = (x - this.startX) * 3; //scroll-fast
    this.slider.scrollLeft = this.scrollLeft - walk;
  }

}
