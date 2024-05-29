import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MovieService } from '../movie.service';
import { Customer } from './Customer';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  customer: Customer = new Customer();
  customers: Customer[] = [];
  viewList:boolean=false;
  constructor(private cservice: MovieService, private route: ActivatedRoute, private router: Router) {

  }

  ngOnInit(): void {
    
  }

  addCustomer(): void {
    this.cservice.addCustomer(this.customer).subscribe(
      (c) => { this.customer = c, alert('Customer added successfully') },
      (err: any) => {
        if (err['error'].errormsg != 'undefined') {
          console.log(err);
          alert(err['error'].errormsg);
        }

      }
    );
  }

  updateCustomer(): void {
    this.cservice.updateCustomer(this.customer).subscribe(
      (c) => {this.customer = c,alert('Customer Updated successfully')},
      (err: any) => {
        if (err['error'].errormsg != 'undefined') {
          console.log(err);
          alert(err['error'].errormsg);
        }
       
      }
    );
  }

  deleteCustomer(): void {
    this.cservice.deleteCustomer(this.customer.customerId).subscribe(
      (c) =>{this.customer = c,alert('Customer deleted successfully')},
      (err: any) => {
        if (err['error'].errormsg != 'undefined') {
          console.log(err);
          alert(err['error'].errormsg);
        }
       
      }
    );
  }

  viewCustomer(): void {
    this.cservice.viewCustomer(this.customer.customerId).subscribe(
      (c) => this.customer = c,
      (err: any) => {
        if (err['error'].errormsg != 'undefined') {
          console.log(err);
          alert(err['error'].errormsg);
        }
      }
    );
  }
  viewallcustomer(): void {
    this.cservice.viewallcustomer().subscribe(
      (c) =>{ this.customers = c,this.viewList=true},
      (err: any) => {
        if (err['error'].errormsg != 'undefined') {
          console.log(err);
          alert(err['error'].errormsg);
        }
      }
    );
  }
}