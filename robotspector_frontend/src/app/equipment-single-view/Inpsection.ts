import { InspectionResult } from "./InspectionResult";

export class Inspection{

    id? : string;

    equipmentId? : number;

    dateTime?: {

        date? : string;

        time? : string;

    }

    collectingTime? : number;

    verificationDetails?: {

        id? : number;

        verifiedBy?:number;
        
        name? : string;

        severity? : number;

        verifiedDate?: {

            date? : string;
    
            time? : string;
    
        }

        engineerComment?:string;

        InspectionResult? : InspectionResult;

        
    }

}
