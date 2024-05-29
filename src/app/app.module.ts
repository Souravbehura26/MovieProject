import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookingComponent } from './booking/booking.component';
import { HomeComponent } from './home/home.component';
import { TicketComponent } from './ticket/ticket.component';
import { SeatComponent } from './seat/seat.component';
import { ScreenComponent } from './screen/screen.component';
import { ShowComponent } from './show/show.component';
import { TheatreComponent } from './theatre/theatre.component';
import { MovieComponent } from './movie/movie.component';
import { CustomerComponent } from './customer/customer.component';
import { AboutComponent } from './about/about.component';
import { UserComponent } from './user/user.component';
import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    BookingComponent,
    HomeComponent,
    TicketComponent,
    SeatComponent,
    ScreenComponent,
    ShowComponent,
    TheatreComponent,
    MovieComponent,
    CustomerComponent,
    AboutComponent,
    UserComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
