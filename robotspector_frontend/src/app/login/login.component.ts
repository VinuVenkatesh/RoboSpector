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
    
    constructor(private formBuilder:FormBuilder,private service:AuthenticationService, private router:RouterService) {}
    //one space between methods
    ngOnInit() {
      console.log("working");
      this.form = this.formBuilder.group({
     
       
        "username": ['', [Validators.required,Validators.minLength(8)]],
        "password": ['', [Validators.required, Validators.minLength(8), Validators.pattern(/(?=[A-Za-z0-9@#$%^&+!=]+$)^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+!=])(?=.{8,}).*$/)]]
        
     })
    }

    loginSubmit() {
      console.log(`log in clicked ${this.form.valid}}`);
      console.log(this.form.value     );
      if (this.form.valid == false ){
        
        this.submitMessage = "Username or password invalid"
        return;
      }else{
        this.submitMessage = "";
      }
     
    }
}
