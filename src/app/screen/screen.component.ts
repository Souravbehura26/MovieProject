import { Component, OnInit } from '@angular/core';
import { Screen } from './Screen';
import { ActivatedRoute, Router } from '@angular/router';
import { MovieService } from '../movie.service';
import { Theatre } from '../theatre/Theatre';

@Component({
  selector: 'app-screen',
  templateUrl: './screen.component.html',
  styleUrls: ['./screen.component.css']
})
export class ScreenComponent implements OnInit {

  screen: Screen = new Screen();
  screens: Screen[] = [];
  haserror: boolean = false;
  errormsg: string = "";
  viewlist:boolean=false;

  theatre: Theatre = new Theatre();
  theatres: Theatre[] = [];
  constructor(private sservice: MovieService, private route: ActivatedRoute, private router: Router) {

  }
  ngOnInit(){
    
  }

  AddScreen(): void {
    this.sservice.addscreen(this.screen).subscribe((sc) => {
      this.screen = sc, alert('screen added')
    },
      (error: any) => {
        if (error['error'].errormsg != 'undefined') {
          alert(error['error'].errormsg);
        }
      }
    );
  }

  DeleteScreen(): void {
    this.sservice.deletescreen(this.screen.screenId).subscribe((sc) => { this.screen = sc, alert('screen deleted') },
      (error: any) => {
        if (error['error'].errormsg != 'undefined') {
          alert(error['error'].errormsg);
        }
      }
    );
  }

  UpdateScreen(): void {
    this.sservice.updatescreen(this.screen).subscribe((sc) => { this.screen = sc, alert('screen updated') },
      (error: any) => {
        if (error['error'].errormsg != 'undefined') {
          alert(error['error'].errormsg);
        }
      }
    );
  }

  ViewScreenList(): void {
    this.sservice.viewscreenlist().subscribe((sc) => {this.screens = sc,this.viewlist=true},
      (error: any) => {
        if (error['error'].errormsg != 'undefined') {
          alert(error['error'].errormsg);
        }
      }
    )
  }

  ViewScreen(): void {
    this.sservice.viewscreen(this.screen.screenId).subscribe(
      (sc) => this.screen = sc,
      (error: any) => {
        if (error['error'].errormsg != 'undefined') {
          alert(error['error'].errormsg);
        }
      }
    );
  }
}