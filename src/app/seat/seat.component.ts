import { Component, OnInit } from '@angular/core';
import { Seat } from './Seat';
import { ActivatedRoute, Router } from '@angular/router';
import { MovieService } from '../movie.service';
import { Ticket } from '../ticket/Ticket';

@Component({
  selector: 'app-seat',
  templateUrl: './seat.component.html',
  styleUrls: ['./seat.component.css']
})
export class SeatComponent implements OnInit {

  seat: Seat = new Seat();
  seats: Seat[] = [];
  viewseats: boolean = false;
  errorMsg: string;
  ticket: Ticket = new Ticket();
  tickets: Ticket[] = [];

  constructor(private sservice: MovieService, private route: ActivatedRoute, private router: Router) { }

  addSeat(): void {
    this.sservice.addSeat(this.seat).subscribe((se) => {
      this.seat = se, alert('Seat added')
    },
      (error: any) => {
        if (error['error'].errormsg != 'undefined') {
          alert(error['error'].errormsg);
        }
      }
    );
  }


  cancelSeat(): void {
    this.sservice.cancelSeat(this.seat.seatId).subscribe(
      (s) => { this.seat = s, alert('Seat details deleted') },
      (error: any) => {
        if (error['error'].errormsg != 'undefined') {
          alert(error['error'].errormsg);
        }
      }
    );
  }

  viewAllSeat(): void {
    
    this.sservice.getAllSeats().subscribe(
      (s) =>{ this.seats = s,this.viewseats = true},
      (error: any) => {
        if (error['error'].errormsg != 'undefined') {
          alert(error['error'].errormsg);
        }
      }
    );
  }

  ngOnInit() {
  }

}




