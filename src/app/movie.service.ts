import { Injectable } from '@angular/core';
import { HttpClient,HttpErrorResponse,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Booking } from './booking/Booking';
import { Ticket } from './ticket/Ticket';
import { Seat } from './seat/Seat';
import { Screen } from './screen/Screen';
import { Show } from './show/Show';
import { Customer } from './customer/Customer';
import { Movie } from './movie/Movie';
import { Theatre } from './theatre/Theatre';
import { User } from './user/User';
import { Login } from './login/Login';



@Injectable({
  providedIn: 'root'
})
export class MovieService {

  movieURL: string = "http://localhost:9094/";

  bookings: Booking[] = [];
  tickets: Ticket[] = [];
  seats: Seat[] = [];
  shows:Show[]=[];
  screens:Screen[]=[];
  movies:Movie[]=[];
  theatre:Theatre[]=[];
  customers:Customer[]=[];
  users:User[]=[];
  httpOptions={
    headers:new HttpHeaders({
      'Content-Type':'application/json'
    })
  };

  constructor(private h: HttpClient) { }

  addNewUser(u:User):Observable<any>{
    return this.h.post<any>(this.movieURL+"user/addnewuser",u);
  }

  login(userid:any,password:any):Observable<any>{
    return this.h.post<any>(this.movieURL+'user/signin/'+userid+'/'+password,this.httpOptions);
  }
  
  getAllBookings(): Observable<any[]> {
    return this.h.get<any[]>(this.movieURL + "booking/viewbookinglist");
  }

  addBooking(b: Booking): Observable<any> {
    return this.h.post(this.movieURL + "booking/add", b);
  }

  modifyBooking(b: Booking): Observable<any> {
    return this.h.put(this.movieURL + "booking/update", b);
  }

  cancelBooking(id: number): Observable<any> {
    return this.h.delete(this.movieURL + "booking/cancel/" + id);
  }

  searchBookingbydate(date: Date): Observable<any[]> {
    return this.h.get<any[]>(this.movieURL + "booking/showbooking/" + date);
  }

  viewbooking(id: number): Observable<any> {
    return this.h.get<any>(this.movieURL + "booking/viewbooking/" + id);
  }

  getAllTickets(): Observable<any[]> {
    return this.h.get<any[]>(this.movieURL + "ticket/viewallticket");
  }

  addTicket(t: Ticket): Observable<any> {
    return this.h.post(this.movieURL + "ticket/add", t);
  }

  cancelTicket(id: number): Observable<any> {
    return this.h.delete(this.movieURL + "ticket/cancel/" + id);
  }

  addSeat(s: Seat): Observable<any> {
    return this.h.post(this.movieURL + "seat/add", s);
  }

  cancelSeat(id: number): Observable<any> {
    return this.h.delete(this.movieURL + "seat/cancel/" + id);
  }

  getAllSeats(): Observable<any[]> {
    return this.h.get<any[]>(this.movieURL + "seat/viewseatlist");
  }

  addscreen(screen: Screen): Observable<any> {

    return this.h.post<any>(this.movieURL + "screen/add", screen);
  }
  deletescreen(id: number): Observable<any> {
    return this.h.delete<any>(this.movieURL + "screen/delete/" + id);
  }
  updatescreen(screen: Screen): Observable<any> {
    return this.h.put<any>(this.movieURL + "screen/update", screen)
  }

  viewscreenlist(): Observable<any[]> {
    return this.h.get<any[]>(this.movieURL + "screen/viewscreenlist")
  }

  viewscreen(id: number): Observable<any> {
    return this.h.get<any>(this.movieURL + "screen/viewscreen/" + id);
  }

  addshow(show: Show): Observable<any> {
    return this.h.post<any>(this.movieURL + "show/addshow", show);
  }
  updateshow(show: Show): Observable<any> {
    return this.h.put<any>(this.movieURL + "show/updateshow", show);
  }
  removeshow(id: number): Observable<any> {
    return this.h.delete<any>(this.movieURL + "show/removeshow/" + id);
  }
  viewshow(id: number): Observable<any> {
    return this.h.get<any>(this.movieURL + "show/viewshow/" + id);
  }
  viewshowlist(): Observable<any[]> {
    return this.h.get<any[]>(this.movieURL + "show/viewallshow")
  }
  
  addtheatre(theatre: Theatre): Observable<any> {
    return this.h.post<any>(this.movieURL + "theatre/add", theatre);
  }
  updatetheatre(theatre: Theatre): Observable<any> {
    return this.h.put<any>(this.movieURL + "theatre/update", theatre)
  }
  deletetheatre(id: number): Observable<any> {
    return this.h.delete<any>(this.movieURL + "theatre/delete/" + id)
  }
  viewalltheatre(): Observable<any[]> {
    return this.h.get<any[]>(this.movieURL + "theatre/viewalltheatre")
  }
  viewtheatre(id: number): Observable<any> {
    return this.h.get<any>(this.movieURL + "theatre/viewtheatre/" + id);
  }
  
  addmovie(movie: Movie): Observable<any> {

    return this.h.post<any>(this.movieURL + "movie/add", movie);
  }
  updatemovie(movie: Movie): Observable<any> {
    return this.h.put<any>(this.movieURL + "movie/update", movie)
  }
  deletemovie(id: number): Observable<any> {
    return this.h.delete<any>(this.movieURL + "movie/delete/" + id)
  }
  viewmovie(id: number): Observable<any> {
    return this.h.get<any>(this.movieURL + "movie/viewmovie/" + id);
  }
  viewmovielist(): Observable<any[]> {
    return this.h.get<any[]>(this.movieURL + "movie/viewmovielist")
  }
  addCustomer(customer: Customer): Observable<any> {
    return this.h.post<any>(this.movieURL + "customer/add", customer)
  }

  updateCustomer(customer: Customer): Observable<any> {
    return this.h.put<any>(this.movieURL + "customer/update", customer)
  }

  deleteCustomer(id: number): Observable<any> {
    return this.h.delete<any>(this.movieURL + "customer/delete/" + id)
  }

  viewCustomer(id: number): Observable<any> {
    return this.h.get<any>(this.movieURL + "customer/view/" + id)
  }

  viewallcustomer(): Observable<any[]> {
    return this.h.get<any[]>(this.movieURL + "customer/viewallcustomer");
  }


}
