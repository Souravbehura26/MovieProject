import { Theatre } from "../theatre/Theatre";

export class Screen {
    public screenId: number;
    private screenName: string;
    private rows: number;
    private columns: number;
    
    theatre:Theatre=new Theatre();
}