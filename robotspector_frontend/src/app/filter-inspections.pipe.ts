import { Pipe, PipeTransform } from '@angular/core';
import { Equipment } from './equipment-single-view/Equipment';
import { Inspection } from './model/Inspection.model';


@Pipe({
  name: 'filterInspections'
})
export class FilterInspectionsPipe implements PipeTransform {

  transform(allInspection:Inspection[], searchText?: string) {
    if (allInspection === undefined) return ;

    return allInspection.filter(a => a.verificationDetails != null);

  }

}
