import { Ticket } from "../ticket/Ticket";

export class Seat{

    public seatId:number;
    public seatNumber:string;
    public type:string;
    public price:number;
    ticket:Ticket=new Ticket();
    
}
