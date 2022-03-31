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
    submitMessage: any;
    
    constructor(private formBuilder:FormBuilder,private service:AuthenticationService) {}
    //one space between methods
    ngOnInit() {
    
      this.form = this.formBuilder.group({
     
       
        "username": ['', [Validators.required,Validators.minLength(8)]],
        "password": ['', [Validators.required, Validators.minLength(8), Validators.pattern(/(?=[A-Za-z0-9@#$%^&+!=]+$)^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+!=])(?=.{8,}).*$/)]]
        
     })
    }
    
    loginSubmit() {
      console.log("=====");
      console.log(this.form.value);
      console.log("=====");

      this.service.authenticateUser(this.form.value).subscribe( (data:any) =>{
        
        if (data!=null){
        
         this.service.setBearerToken(data['token']);
        }
      },
      (error) =>{
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
    //   if (this.form.valid == false ){
        
    //     this.submitMessage = "Username or password invalid"
        
    //   }else{
    //     this.submitMessage = "Suceess";
        
    //   }
     
    // }
}
