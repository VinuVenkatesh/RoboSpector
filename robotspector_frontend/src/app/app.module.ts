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
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, 
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
