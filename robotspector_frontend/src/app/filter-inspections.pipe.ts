import { Pipe, PipeTransform } from '@angular/core';
import { Equipment } from './equipment-single-view/Equipment';
import { Inspection } from './equipment-single-view/Inpsection';

@Pipe({
  name: 'filterInspections'
})
export class FilterInspectionsPipe implements PipeTransform {

  transform(allEquipment?:Inspection[], searchText?: string) {
    if (allEquipment === undefined) return;

    return allEquipment.filter(a => a.verificationDetails != null);

  }

}
