export class Equipment{
    id?: number;
    name?: string;
    location?: {
        localtionurl: string;
        latitude: string;
        longitude: string;
    }
    aging?: number;
    comment?: string;
    archived?: boolean;
}