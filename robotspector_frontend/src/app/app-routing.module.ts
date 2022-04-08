import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EquipmentSingleViewComponent } from "./equipment-single-view/equipment-single-view.component";
import { LoginComponent } from './login/login.component';
import { MainDashboardComponent } from './main-dashboard/main-dashboard.component';
// Implement the routes for all components
// Add route where base path has to be redirected to 'addissue'
const routes:Routes = [
    {path:"dashboard", component:MainDashboardComponent},
    {path:"EquipmentSingleViewComponent",component:EquipmentSingleViewComponent},
    {path:"",component:LoginComponent},
    
  ];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

// AppRoutingModule is responsible for routing to all the components
export class AppRoutingModule { }