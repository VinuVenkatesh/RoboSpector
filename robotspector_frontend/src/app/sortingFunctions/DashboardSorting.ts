import { Equipment } from "../equipment-single-view/equipment";

export function sortNamesDsc( a:Equipment, b:Equipment ) {
    if (a.name == undefined || b.name == undefined) return -1;
    if ( a.name[0].toLowerCase() > b.name[0].toLowerCase() ){
      return -1;
    }
    if ( a.name[0].toLowerCase() < b.name[0].toLowerCase() ){
      return 1;
    }
   
    return 0;
  }
export function sortNamesAsc( a:Equipment, b:Equipment ) {
    if (a.name == undefined || b.name == undefined) return -1;
    if ( a.name[0].toLowerCase() > b.name[0].toLowerCase() ){
      return 1;
    }
    if ( a.name[0].toLowerCase() < b.name[0].toLowerCase() ){
      return -1;
    }
    return 0;
  }
export function sortByAgeDsc( a:Equipment, b:Equipment ) {
    if (a.aging == undefined || b.aging == undefined) return -1;
    return b.aging - a.aging;
  }
export function sortByAgeAsc( a:Equipment, b:Equipment ) {
    if (a.aging == undefined || b.aging == undefined) return -1;
    return a.aging - b.aging;
  }
export function sortLocationDsc( a:Equipment, b:Equipment ) {
    if (a.name == undefined || b.name == undefined) return -1;
    const locationA =  a.location?.localtionurl;
    const locationB =  b.location?.localtionurl;
    if (locationA == undefined || locationB == undefined) return -1;
    if ( locationA > locationB  ){
      return -1;
    }
    if ( locationA < locationB){
      return 1;
    }
    return 0;
  }
export function sortLocationAsc( a:Equipment, b:Equipment ) {
    if (a.name == undefined || b.name == undefined) return -1;
    const locationA =  a.location?.localtionurl;
    const locationB =  b.location?.localtionurl;
    if (locationA == undefined || locationB == undefined) return -1;
    if ( locationA > locationB  ){
      return 1;
    }
    if ( locationA < locationB){
      return -1;
    }
    return 0;
  }
export function sortSevrityAsc( a:Equipment, b:Equipment ) {
    const severityA = a.inspection?.verificationDetails?.severity;
    const severityB = b.inspection?.verificationDetails?.severity;
    if (severityA == undefined || severityB == undefined) return -1;
    return severityA - severityB;
  }
export function sortSevrityDsc( a:Equipment, b:Equipment ) {
    const severityA = a.inspection?.verificationDetails?.severity;
    const severityB = b.inspection?.verificationDetails?.severity;
    if (severityA == undefined || severityB == undefined) return -1;
    return severityB - severityA;
  }