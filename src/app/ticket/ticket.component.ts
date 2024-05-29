import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MovieService } from '../movie.service';
import { Ticket } from './Ticket';

@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.css']
})
export class TicketComponent implements OnInit {

  ticket: Ticket = new Ticket();
  tickets: Ticket[] = [];
  viewtickets: boolean = false;
  errorMsg: string;
  hasError: boolean = false;

  constructor(private tservice: MovieService, private route: ActivatedRoute, private router: Router) {

  }


  viewTickets(): void {
    this.tservice.getAllTickets().subscribe(
      (t) =>{ this.tickets = t,this.viewtickets = true},
      (error: any) => {
        if (error['error'].errormsg != 'undefined') {
          alert(error['error'].errormsg);
        }
      }
    );
  }

  addTicket(): void {
    this.tservice.addTicket(this.ticket).subscribe((ti) => {
      this.ticket= ti, alert('Ticket added')
    },
      (error: any) => {
        if (error['error'].errormsg != 'undefined') {
          alert(error['error'].errormsg);
        }
      }
    );
  }

  cancelTicket(): void {
    this.tservice.cancelTicket(this.ticket.ticketId).subscribe(
      (t) => { this.ticket = t, alert('Ticket details deleted') },
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


