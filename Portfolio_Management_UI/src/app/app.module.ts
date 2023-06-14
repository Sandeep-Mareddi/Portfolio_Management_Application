import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from "@angular/common/http";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './Component/login/login.component';
import { ShareDetailsComponent } from './Component/share-details/share-details.component';
import { SellAssetsComponent } from './Component/sell-assets/sell-assets.component';
import { CalculateNetworthComponent } from './Component/calculate-networth/calculate-networth.component';
import { HomeComponent } from './Component/home/home.component';
import { MutualDetailsComponent } from './Component/mutual-details/mutual-details.component';
import { NavigationbarComponent } from './navigationbar/navigationbar.component';
import { FooterComponent } from './Component/footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ShareDetailsComponent,
    SellAssetsComponent,
    CalculateNetworthComponent,
    HomeComponent,
    MutualDetailsComponent,
    NavigationbarComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
