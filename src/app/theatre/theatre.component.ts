import { Component, OnInit } from '@angular/core';
import { MovieService } from '../movie.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Theatre } from './Theatre';

@Component({
  selector: 'app-theatre',
  templateUrl: './theatre.component.html',
  styleUrls: ['./theatre.component.css']
})
export class TheatreComponent implements OnInit {

  theatre: Theatre = new Theatre();
  theatres: Theatre[] = [];
  haserror: boolean = false;
  errormsg: string = '';
  viewList:boolean=false;
  constructor(private mservice: MovieService, private route: ActivatedRoute, private router: Router) {

  }

  ngOnInit(): void {
  }


  AddTheatre(): void {
    this.mservice.addtheatre(this.theatre).subscribe(
      (t) => { this.theatre = t, alert('Theatre Added') },
      (error: any) => {
        if (error['error'].errormsg != 'undefined') {
          alert(error['error'].errormsg);
        }
      }

    );
  }
  DeleteTheatre(): void {
    this.mservice.deletetheatre(this.theatre.theatreId).subscribe(
      (t) => { this.theatre = t, alert('Theatre Deleted') },
      (error: any) => {
        if (error['error'].errormsg != 'undefined') {
          alert(error['error'].errormsg);
        }
      }

    )
  }
  UpdateTheatre(): void {
    this.mservice.updatetheatre(this.theatre).subscribe(
      (t) => { this.theatre = t, alert('Theatre Updated') },
      (error: any) => {
        if (error['error'].errormsg != 'undefined') {
          alert(error['error'].errormsg);
        }
      }

    );
  }
  ViewAllTheatre(): void {
    this.mservice.viewalltheatre().subscribe(
      (t) => {this.theatres = t,this.viewList=true},
      (error: any) => {
        if (error['error'].errormsg != 'undefined') {
          alert(error['error'].errormsg);
        }
      }

    )
  }

  ViewTheatre(): void {
    this.mservice.viewtheatre(this.theatre.theatreId).subscribe(
      (t) => this.theatre = t,
      (error: any) => {
        if (error['error'].errormsg != 'undefined') {
          alert(error['error'].errormsg);
        }
      }
    );
  }
}