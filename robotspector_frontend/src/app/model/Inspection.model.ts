import { InspectionResult } from "../equipment-single-view/InspectionResult";
import { VerificationDetails } from "./VerificationDetails.model";

export class Inspection{
    id? : string;
    equipmentId? : number;
    dateTime?: {
        date? : string;
        time? : string;
    }
    collectingTime? : number;
    verificationDetails?: VerificationDetails;
    inpsectionresult?:InspectionResult;
}