export class VerificationDetails{
    verifiedBy? :string;
    inspectionResult?:{
        name?:string;
        severity?:number;
    }
    engineerComment?:string;
}