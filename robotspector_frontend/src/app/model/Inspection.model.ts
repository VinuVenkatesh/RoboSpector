export class Inspection{
    id? : string;
    equipmentId? : number;
    dateTime?: {
        date? : string;
        time? : string;
    }
    collectingTime? : number;
    verificationDetails?: {
        verifiedBy? : string;
        inspectionResult: {
            name? : string;
            severity? : number;
        } 
        verifiedDate?: {
            date? : string;
            time? : string;
        }
        engineerComment?: string;
    }
}