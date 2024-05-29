import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MovieService } from '../movie.service';
import { Booking } from './Booking';
import { Show } from '../show/Show';
import { Customer } from '../customer/Customer';
import { Ticket } from '../ticket/Ticket';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

  booking: Booking = new Booking();
  bookings: Booking[] = [];

  searchedbooking: Booking = new Booking();
  searchedbookings: Booking[] = [];
  spid: any;
  checkdate: boolean = false;

  errorMsg: string="";
  hasError: boolean = false;

  showbookings: boolean = false;

  show: Show = new Show();
  shows: Show[] = [];

  customer: Customer=new Customer();
  customers:Customer[]=[];

  ticket:Ticket=new Ticket();
  tickets:Ticket[]=[];

  
  constructor(private bservice: MovieService, private route: ActivatedRoute, private router: Router) {

  }

  addBooking():void{
    this.bservice.addBooking(this.booking).subscribe(
      (b)=>{this.booking=b,alert('Booking added')},
      (error: any) => {
        if (error['error'].errormsg != 'undefined') {
          alert(error['error'].errormsg);
        }
      }
    );
  }

  cancelBooking():void{
    this.bservice.cancelBooking(this.booking.transactionId).subscribe(
      (b)=>{this.booking=b,alert('Booking Cancelled')},
      (error: any) => {
        if (error['error'].errormsg != 'undefined') {
          alert(error['error'].errormsg);
        }
      }
    );
  }

  modifyBooking():void{
    this.bservice.modifyBooking(this.booking).subscribe(
      (b)=>{this.booking=b,alert('Booking modified')},
      (error: any) => {
        if (error['error'].errormsg != 'undefined') {
          alert(error['error'].errormsg);
        }
      }
    );
  }

  viewBooking():void{
    this.bservice.viewbooking(this.booking.transactionId).subscribe(
      (b)=>(this.booking=b),
      (error: any) => {
        if (error['error'].errormsg != 'undefined') {
          alert(error['error'].errormsg);
        }
      }
    );
  }

  viewAllBookings():void{
    this.bservice.getAllBookings().subscribe(
      (b)=>{this.bookings=b,this.showbookings=true},
      (error: any) => {
        if (error['error'].errormsg != 'undefined') {
          alert(error['error'].errormsg);
        }
      }
    );
  }

  searchBooking():void{
    this.bservice.searchBookingbydate(this.booking.bookingDate).subscribe(
      (b)=>{this.bookings=b,this.checkdate=true},
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

