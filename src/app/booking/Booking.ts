import { Customer } from "../customer/Customer";
import { Show } from "../show/Show";
import { Ticket } from "../ticket/Ticket";

export class Booking {

    public transactionId: number;
    public bookingDate: Date;
    public transactionMode: string;
    public transactionStatus: string;
    public totalCost: number;

    show:Show=new Show();

    customer:Customer=new Customer();

    ticket:Ticket=new Ticket();
}
