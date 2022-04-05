import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { EquipmentSingleViewComponent } from './equipment-single-view/equipment-single-view.component';
import { InspectorProfileComponent } from './inspector-profile/inspector-profile.component';
import { DashboardSidebarComponent } from './dashboard-sidebar/dashboard-sidebar.component';
import { DashboardButtonComponent } from './dashboard-button/dashboard-button.component';
import { CommentViewComponent } from './comment-view/comment-view.component';
import { PersonCardComponent } from './person-card/person-card.component';
import { LocationViewComponent } from './location-view/location-view.component';
import { CommentComponent } from './comment/comment.component';
import { CommentListComponent } from './comment-list/comment-list.component';
import { CommenterListComponent } from './commenter-list/commenter-list.component';
import { InspectorCardComponent } from './inspector-card/inspector-card.component';
import { InspectorListComponent } from './inspector-list/inspector-list.component';
import { PersonProfileComponent } from './person-profile/person-profile.component';
import { ImageListComponent } from './image-list/image-list.component';
import { MainDashboardComponent } from './main-dashboard/main-dashboard.component';
import { TableRowComponent } from './table-row/table-row.component';
import { SortHeaderComponent } from './sort-header/sort-header.component';
import { TableComponent } from './table/table.component';
import { DetailedEquipmentOverviewComponent } from './detailed-equipment-overview/detailed-equipment-overview.component';
import { DashboardPipePipe } from './dashboard-pipe.pipe';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SortHeaderTitleComponent } from './sort-header-title/sort-header-title.component';
import { DashboardOrderByPipePipe } from './dashboard-order-by-pipe.pipe';
import { CreateModalComponent } from './create-modal/create-modal.component';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    EquipmentSingleViewComponent,
    InspectorProfileComponent,
    DashboardSidebarComponent,
    DashboardButtonComponent,
    CommentViewComponent,
    PersonCardComponent,
    LocationViewComponent,
    CommentComponent,
    CommentListComponent,
    CommenterListComponent,
    InspectorCardComponent,
    InspectorListComponent,
    PersonProfileComponent,
    ImageListComponent,
    MainDashboardComponent,
    TableRowComponent,
    SortHeaderComponent,
    TableComponent,
    DetailedEquipmentOverviewComponent,
    DashboardPipePipe,
    SortHeaderTitleComponent,
    DashboardOrderByPipePipe,
    CreateModalComponent,
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, 
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
