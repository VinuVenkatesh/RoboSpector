import { Component } from '@angular/core';
import { FormControl,FormBuilder,Validators } from '@angular/forms';
import { AuthenticationService } from '../services/authentication.service';
import { RouterService } from '../services/router.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
    username = new FormControl();
    password = new FormControl();
    form: any;
    submitMessage:any;
    
    constructor(private formBuilder:FormBuilder,private service:AuthenticationService, private router:RouterService) {}
    //one space between methods
    ngOnInit() {
      this.form = this.formBuilder.group({
     
        "username": this.username,
        "password": this.password,
        
     })
    }

    loginSubmit() {
      
      if (this.form.valid == false ){
        
        this.submitMessage = "Title and Description should not be empty!!! Please verify details"
        return;
      }
     
      this.service.authenticateUser(this.form.value).subscribe( (data:any) =>{
        
        if (data!=null){
        
         this.service.setBearerToken(data['token']);
        }
      },
      (error:Error) =>{
        if (error!= null){
          if (error.message.includes("403")){
            this.submitMessage = "Unauthorized";
            return;
          }
          this.submitMessage = error.message;
        }
      }
      
      )
    }
}
