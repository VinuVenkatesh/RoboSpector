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
  comment:String = `
  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Viverra nam libero justo laoreet sit. Lacus viverra vitae congue eu. Amet venenatis urna cursus eget nunc scelerisque viverra mauris. Risus nullam eget felis eget nunc lobortis mattis. Varius sit amet mattis vulputate enim nulla aliquet porttitor lacus. Consectetur purus ut faucibus pulvinar elementum integer enim. Enim ut tellus elementum sagittis vitae et leo duis. A pellentesque sit amet porttitor eget dolor morbi non. Eros in cursus turpis massa tincidunt. Enim nunc faucibus a pellentesque sit amet porttitor eget dolor. Vitae suscipit tellus mauris a diam maecenas sed enim ut. Fringilla ut morbi tincidunt augue interdum velit. Ac turpis egestas integer eget. Feugiat pretium nibh ipsum consequat nisl vel pretium. Eu turpis egestas pretium aenean. Tempus egestas sed sed risus pretium quam vulputate. Nascetur ridiculus mus mauris vitae. Adipiscing tristique risus nec feugiat.
Tempor commodo ullamcorper a lacus vestibulum sed. Porttitor lacus luctus accumsan tortor posuere ac. Sollicitudin ac orci phasellus egestas tellus rutrum. Nibh praesent tristique magna sit amet. Nunc sed augue lacus viverra. Varius quam quisque id diam vel quam elementum pulvinar etiam. Sed viverra tellus in hac habitasse platea. Ultricies mi quis hendrerit dolor magna eget. Orci nulla pellentesque dignissim enim sit amet venenatis urna cursus. Felis bibendum ut tristique et egestas quis. Pretium viverra suspendisse potenti nullam ac tortor vitae purus faucibus. Augue neque gravida in fermentum. Rhoncus est pellentesque elit ullamcorper dignissim cras tincidunt lobortis. Dui sapien eget mi proin. Malesuada pellentesque elit eget gravida cum sociis. In cursus turpis massa tincidunt dui ut ornare lectus. Rutrum tellus pellentesque eu tincidunt tortor. Cras semper auctor neque vitae tempus quam pellentesque nec. Purus viverra accumsan in nisl nisi scelerisque eu ultrices vitae. Senectus et netus et malesuada fames ac.
Neque gravida in fermentum et sollicitudin ac orci. Imperdiet proin fermentum leo vel orci. Aliquam sem fringilla ut morbi tincidunt augue interdum. Quis blandit turpis cursus in hac habitasse platea dictumst. Nulla facilisi morbi tempus iaculis. Commodo quis imperdiet massa tincidunt nunc pulvinar sapien. Aliquam id diam maecenas ultricies mi eget mauris. Consectetur lorem donec massa sapien. Eget magna fermentum iaculis eu non diam phasellus vestibulum lorem. Fermentum leo vel orci porta non pulvinar. Id porta nibh venenatis cras sed felis eget velit aliquet. Dolor sit amet consectetur adipiscing elit pellentesque habitant morbi tristique. Euismod lacinia at quis risus sed vulputate. Accumsan tortor posuere ac ut consequat semper.
Quis vel eros donec ac odio tempor. Lobortis feugiat vivamus at augue eget arcu dictum varius duis. Turpis egestas sed tempus urna et pharetra pharetra massa. Molestie nunc non blandit massa enim nec dui nunc mattis. Facilisis gravida neque convallis a cras semper. Venenatis lectus magna fringilla urna. Eget mauris pharetra et ultrices. Amet venenatis urna cursus eget. Lectus quam id leo in vitae turpis. Ornare aenean euismod elementum nisi quis eleifend quam adipiscing. Ac auctor augue mauris augue neque gravida in fermentum et. Diam maecenas sed enim ut sem viverra aliquet eget. Enim sit amet venenatis urna cursus eget nunc. Consectetur adipiscing elit duis tristique sollicitudin nibh sit amet. Pellentesque dignissim enim sit amet venenatis. Amet est placerat in egestas erat. Tortor at auctor urna nunc id cursus metus. Nulla pharetra diam sit amet nisl suscipit adipiscing bibendum. Tortor id aliquet lectus proin nibh nisl condimentum.
Tristique et egestas quis ipsum. Rutrum quisque non tellus orci ac auctor augue. Orci porta non pulvinar neque laoreet suspendisse interdum consectetur libero. Nunc aliquet bibendum enim facilisis gravida neque convallis a cras. Lacinia quis vel eros donec ac odio tempor orci dapibus. Diam sollicitudin tempor id eu nisl nunc mi ipsum. Elit duis tristique sollicitudin nibh sit. Aenean et tortor at risus viverra adipiscing. Pharetra et ultrices neque ornare aenean euismod elementum nisi. Turpis in eu mi bibendum neque egestas congue. Cursus euismod quis viverra nibh. Et ligula ullamcorper malesuada proin libero nunc consequat interdum varius. Maecenas pharetra convallis posuere morbi leo urna molestie at. Eu volutpat odio facilisis mauris sit amet massa vitae tortor. At imperdiet dui accumsan sit amet nulla facilisi morbi. Cras sed felis eget velit. Amet porttitor eget dolor morbi non arcu risus quis varius. Feugiat in ante metus dictum at tempor.
Dapibus ultrices in iaculis nunc. Leo vel fringilla est ullamcorper eget. Pharetra massa massa ultricies mi quis hendrerit dolor. Est ante in nibh mauris cursus. Mauris pharetra et ultrices neque ornare aenean euismod elementum. In arcu cursus euismod quis viverra nibh cras pulvinar mattis. Pellentesque habitant morbi tristique senectus et netus. In cursus turpis massa tincidunt dui. Nisl nunc mi ipsum faucibus vitae aliquet nec ullamcorper sit. Eget magna fermentum iaculis eu non diam phasellus vestibulum. Sit amet est placerat in egestas erat. Gravida cum sociis natoque penatibus et magnis.
Montes nascetur ridiculus mus mauris vitae ultricies. Id faucibus nisl tincidunt eget nullam non. Tincidunt eget nullam non nisi est sit. Mauris pharetra et ultrices neque ornare. Enim diam vulputate ut pharetra sit amet. Venenatis tellus in metus vulputate eu. Feugiat nisl pretium fusce id velit ut tortor. Fermentum odio eu feugiat pretium nibh. Est pellentesque elit ullamcorper dignissim. Et ligula ullamcorper malesuada proin libero nunc consequat. Amet nulla facilisi morbi tempus iaculis urna. Cum sociis natoque penatibus et magnis dis parturient montes. Purus sit amet volutpat consequat mauris nunc. Scelerisque viverra mauris in aliquam sem fringilla ut morbi. Tristique et egestas quis ipsum suspendisse ultrices gravida. Phasellus vestibulum lorem sed risus ultricies tristique.
Gravida quis blandit turpis cursus in hac habitasse platea dictumst. Ultricies integer quis auctor elit sed vulputate. Nibh ipsum consequat nisl vel pretium lectus quam id. Amet commodo nulla facilisi nullam vehicula ipsum a arcu. Orci sagittis eu volutpat odio facilisis mauris. At varius vel pharetra vel turpis nunc eget lorem dolor. Ultricies tristique nulla aliquet enim tortor at. Eget aliquet nibh praesent tristique. Et molestie ac feugiat sed lectus. Felis eget velit aliquet sagittis id. Erat imperdiet sed euismod nisi porta lorem mollis aliquam. Consequat ac felis donec et odio pellentesque.

`
  ;

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
