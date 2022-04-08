import { Pipe, PipeTransform } from '@angular/core';
import { Equipment } from './equipment-single-view/Equipment';

@Pipe({
  name: 'dashboardPipe'
})
export class DashboardPipePipe implements PipeTransform {

  transform(allEquipment?:Equipment[], searchText?: string) {
  if (allEquipment === undefined) return;
    if (searchText === undefined || searchText == '' || searchText.length === 0) return allEquipment;
    let equipmentFound = [];
    let currentSearchText = searchText == undefined ? '': searchText; 
    const noName = (element:any) => element.name ==  undefined || element.name == '';
    if (allEquipment.some(noName)) return allEquipment; 
    for (let index = 0; index < allEquipment.length; index++) {
      const equipment = allEquipment[index];
      if (equipment.name == undefined) return allEquipment; 
      if (equipment.name?.toLowerCase().includes(currentSearchText.toLocaleLowerCase()) || equipment.location?.localtionurl?.toLowerCase().includes(currentSearchText.toLowerCase())){
        equipmentFound.push(equipment);
      }
    }
    return equipmentFound;
  }

}
