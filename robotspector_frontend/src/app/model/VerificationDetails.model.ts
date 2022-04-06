export class VerificationDetails{
    verifiedBy? :number;
    inspectionResult?:{
        name?:string;
        severity?:number;
    }
    engineerComment?:string;
}