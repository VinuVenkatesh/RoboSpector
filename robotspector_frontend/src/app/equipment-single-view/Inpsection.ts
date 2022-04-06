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

        name? : string;

        severity? : number;

    }

}
