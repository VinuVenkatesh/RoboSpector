import { VerificationDetails } from "../model/VerificationDetails.model";

export class Inspection{

    id? : string;

    equipmentId? : number;

    dateTime?: {

        date? : string;

        time? : string;

    }

    collectingTime? : number;

    verificationDetails?: VerificationDetails;
        
}
