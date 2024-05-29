import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MovieService } from '../movie.service';
import { Show } from './Show';
import { Movie } from '../movie/Movie';
import { Theatre } from '../theatre/Theatre';
import { Screen } from '../screen/Screen';

@Component({
  selector: 'app-show',
  templateUrl: './show.component.html',
  styleUrls: ['./show.component.css']
})

export class ShowComponent implements OnInit {

  show: Show = new Show();
  shows: Show[] = [];
  haserror: boolean = false;
  errormsg: string = '';
  viewlist:boolean=false;

  movie: Movie = new Movie();
  movies: Movie[] = [];

  screen: Screen = new Screen();
  screens: Screen[] = [];

  theatre:Theatre=new Theatre();
  theatres:Theatre[]=[];

  constructor(private sservice: MovieService, private route: ActivatedRoute, private router: Router) {

  }

  ngOnInit(){
  }

  AddShow(): void {
    this.sservice.addshow(this.show).subscribe((s) => {
      this.show = s, alert('Show Added')
    },
      (error: any) => {
        if (error['error'].errormsg != 'undefined') {
          alert(error['error'].errormsg);
        }
      }
    );
  }

  UpdateShow(): void {
    this.sservice.updateshow(this.show).subscribe((s) => {
      this.show = s, alert('Show Updated')
    },
      (error: any) => {
        if (error['error'].errormsg != 'undefined') {
          alert(error['error'].errormsg);
        }
      }
    );
  }


  ViewAllShow(): void {
    this.sservice.viewshowlist().subscribe((s) => {this.shows = s,this.viewlist=true},
      (error: any) => {
        if (error['error'].errormsg != 'undefined') {
          alert(error['error'].errormsg);
        }
      }
    );
  }

  RemoveShow(): void {
    this.sservice.removeshow(this.show.showId).subscribe((s) => {
      this.show = s, alert('Show deleted')
    },
      (error: any) => {
        if (error['error'].errormsg != 'undefined') {
          alert(error['error'].errormsg);
        }
      }
    );
  }

  ViewShow(): void {
    this.sservice.viewshow(this.show.showId).subscribe((s) => (this.show = s),
      (error: any) => {
        if (error['error'].errormsg != 'undefined') {
          alert(error['error'].errormsg);
        }
      }
    );
  }

}