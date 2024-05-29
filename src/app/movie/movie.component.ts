import { Component, OnInit } from '@angular/core';
import { MovieService } from '../movie.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Movie } from './Movie';
import { Theatre } from '../theatre/Theatre';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent implements OnInit {

  movie: Movie = new Movie();
  movies: Movie[] = [];
  haserror: boolean = false;
  errormsg: string = '';
  viewList:boolean=false;

  theatre: Theatre = new Theatre();
  theatres: Theatre[] = [];
  
  constructor(private mservice: MovieService, private route: ActivatedRoute, private router: Router) {

  }

  ngOnInit(): void {
  }
  //image: string = "assets\mason-kimbarovsky-E5bGCHzjpr8-unsplash.jpg";

  AddMovie(): void {
    this.mservice.addmovie(this.movie).subscribe(
      (am) => { this.movie = am, alert('Movie Added') },
      (error: any) => {
        if (error['error'].errormsg != 'undefined') {
          alert(error['error'].errormsg);
        }
      }

    );
  }
  ViewMovieList(): void {
    this.mservice.viewmovielist().subscribe(
      (am) => {this.movies = am,this.viewList=true},
      (error: any) => {
        if (error['error'].errormsg != 'undefined') {
          alert(error['error'].errormsg);
        }
      }
    );
  }
  DeleteMovie(): void {
    this.mservice.deletemovie(this.movie.movieId).subscribe(
      (am) => { this.movie = am, alert('Movie Deleted') },
      (error: any) => {
        if (error['error'].errormsg != 'undefined') {
          alert(error['error'].errormsg);
        }
      }
    );
  }
  UpdateMovie(): void {
    this.mservice.updatemovie(this.movie).subscribe(
      (am) => { this.movie = am, alert('Movie Updated') },
      (error: any) => {
        if (error['error'].errormsg != 'undefined') {
          alert(error['error'].errormsg);
        }
      }
    );
  }
  ViewMovie(): void {
    this.mservice.viewmovie(this.movie.movieId).subscribe(
      (am) => (this.movie = am), (error: any) => {
        if (error['error'].errormsg != 'undefined') {
          alert(error['error'].errormsg);
        }
      }
    );
  }

}