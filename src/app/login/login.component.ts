import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { MovieService } from '../movie.service';
import { User } from '../user/User';
import { Login } from './Login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm:FormGroup;
  errormsg:string;
  hasError:boolean=false;
  login:Login=new Login();
  user:User=new User();
  constructor(private lservice:MovieService ,private fb:FormBuilder,private router:Router) { }

  ngOnInit(){
    this.loginForm=this.fb.group({userid:['',Validators.required],password:['',Validators.required]});
  }
  
  doLogin():void{
    this.lservice.login(this.loginForm.value.userid,this.loginForm.value.password).
    subscribe((res:any)=>{
      this.router.navigate(['home']);
    },
    (error:any)=>{
      this.errormsg=error.error.errormsg;
      this.hasError=true;
    }
    );
  }

}
