import { Movie } from "../movie/Movie";
import { Theatre } from "../theatre/Theatre";
import { Screen } from "../screen/Screen";

export class Show{

    public  showId:number;
    private  showStartTime:Date;
    private  showEndTime:Date;
    private  showName:String;
    
    movie:Movie=new Movie();
    screen:Screen=new Screen();
    theatre:Theatre= new Theatre();    

}