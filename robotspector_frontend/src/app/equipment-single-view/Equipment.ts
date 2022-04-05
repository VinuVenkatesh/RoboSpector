import { Inspection } from "./Inpsection";
import { Location } from "./location";

export class Equipment {
    id?: string;   
    name?: String
    aging?: number;
    comment?: string;
    createdBy?: string;
    inspection ?: Inspection;
    location ? : Location;
}
