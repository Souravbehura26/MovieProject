import { Component, OnInit } from '@angular/core';
import { User } from './User';
import { MovieService } from '../movie.service';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  user:User=new User();
  users:User[]=[];

  constructor(private uservice: MovieService, private route: ActivatedRoute, private router: Router) { }

  addUser():void{
    this.uservice.addNewUser(this.user).subscribe(
      (u)=>{this.user=u,alert('User Added Successfuly'),this.router.navigate(['login'])},
      (err: any) => {
        if (err['error'].errormsg != 'undefined') {
          console.log(err);
          alert(err['error'].errormsg);
        }
      }
    )
  }
  
  ngOnInit() {
  }

}
