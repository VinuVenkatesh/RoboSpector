import { Pipe, PipeTransform } from '@angular/core';
import { Inspection } from './model/Inspection.model';


@Pipe({
  name: 'filterInspectionsUnverified'
})
export class FilterInspectionsUnverifiedPipe implements PipeTransform {

  transform(allEquipment?:Inspection[], searchText?: string) {
    if (allEquipment === undefined) return;

    return allEquipment.filter(a => a.verificationDetails == null);

  }

}
