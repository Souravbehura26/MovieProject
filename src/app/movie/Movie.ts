import { Theatre } from "../theatre/Theatre";

export class Movie{
    
	public movieId:number;
	
	public movieName:string;
	
	public movieGenre:string;
	
	public movieHours:string;

	public language:string;

	public description:string;

	theatre:Theatre=new Theatre();

}