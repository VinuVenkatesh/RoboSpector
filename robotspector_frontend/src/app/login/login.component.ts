import { Component } from '@angular/core';
import { FormControl,FormBuilder,Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';
import { DataService } from '../services/data-service.service';
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
    
    constructor(private formBuilder:FormBuilder,private service:AuthenticationService, private router:RouterService,private data : DataService) {}
    ngOnInit() {

      this.form = this.formBuilder.group({


        "username": ['', [Validators.required,Validators.minLength(8)]],
        "password": ['', [Validators.required, Validators.minLength(8), Validators.pattern(/(?=[A-Za-z0-9@#$%^&+!=]+$)^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+!=])(?=.{8,}).*$/)]]

     })
    }
    
    loginSubmit() {
      // this.router.routeToDashboard();
      
      this.service.authenticateUser(this.form.value).subscribe((data:any) =>{

        if (this.form.valid == false ){
        
          this.submitMessage = "Username or password invalid"
          
        }else{
          if (data!= null){
            console.log("There is data");
            this.service.setToken(data);
            this.router.routeToDashboard();
            this.data.changeRole("guest");
            this.data.changeUser_Name("Kyle");
          }
          
        }
      })
     
    }

    goToDashboard(){
      this.router.routeToDashboard();
      this.data.changeRole("guest");
      this.data.changeUser_Name("Kyle");
    }
   
}
