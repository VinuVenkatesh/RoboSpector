import { Pipe, PipeTransform } from '@angular/core';
import { Equipment } from './equipment-single-view/equipment';
import { sortByAgeAsc, sortByAgeDsc, sortLocationAsc, sortLocationDsc, sortNamesAsc, sortNamesDsc, sortSevrityAsc, sortSevrityDsc } from './sortingFunctions/DashboardSorting';

@Pipe({
  name: 'dashboardOrderByPipe'
})
export class DashboardOrderByPipePipe implements PipeTransform {

  transform(allEquipment?:Equipment[], column?:string , sortOrder?:string) {
    if (allEquipment === undefined || column === undefined || sortOrder === undefined) return;
    if ( column == '' || sortOrder.length === 0) return allEquipment;
    switch(column.toLowerCase()){
      case "name":
        if (sortOrder == 'dsc'){
          return allEquipment.sort(sortNamesDsc);
        }else if (sortOrder == 'asc'){
          return allEquipment.sort(sortNamesAsc);
        }
        break;
      case "age":
        if (sortOrder == 'dsc'){
          return allEquipment.sort(sortByAgeDsc);
        }else if (sortOrder == 'asc'){
          return allEquipment.sort(sortByAgeAsc);
        }
        break;
      case "location":
        if (sortOrder == 'dsc'){
          return allEquipment.sort(sortLocationDsc);
        }else if (sortOrder == 'asc'){
          return allEquipment.sort(sortLocationAsc);
        }
        break;
      case "inspection":
        if (sortOrder == 'dsc'){
          return allEquipment.sort(sortSevrityDsc);
        }else if (sortOrder == 'asc'){
          return allEquipment.sort(sortSevrityAsc);
        }
        break;
    }
    return allEquipment;
  }

}

