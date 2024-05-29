import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { BookingComponent } from './booking/booking.component';
import { HomeComponent } from './home/home.component';
import { ScreenComponent } from './screen/screen.component';
import { SeatComponent } from './seat/seat.component';
import { ShowComponent } from './show/show.component';
import { TicketComponent } from './ticket/ticket.component';
import { MovieComponent } from './movie/movie.component';
import { CustomerComponent } from './customer/customer.component';
import { TheatreComponent } from './theatre/theatre.component';
import { UserComponent } from './user/user.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  { path: 'booking', component: BookingComponent },
  { path: 'home', component: HomeComponent },
  { path: 'ticket', component: TicketComponent },
  { path: 'seat', component: SeatComponent },
  { path: 'screen', component: ScreenComponent },
  { path: 'show', component: ShowComponent },
  {path:'about',component:AboutComponent},
  {path:"movie",component:MovieComponent},
  {path:"theatre",component:TheatreComponent},
  {path :'customer',component : CustomerComponent},
  {path:'user',component:UserComponent},
  {path:'login',component:LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
