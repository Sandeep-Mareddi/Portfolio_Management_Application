import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CalculateNetworthComponent } from './Component/calculate-networth/calculate-networth.component';
import { HomeComponent } from './Component/home/home.component';
import { LoginComponent } from './Component/login/login.component';
import { MutualDetailsComponent } from './Component/mutual-details/mutual-details.component';
import { SellAssetsComponent } from './Component/sell-assets/sell-assets.component';
import { ShareDetailsComponent } from './Component/share-details/share-details.component';
import { RouteGuardService } from './service/route-guard.service';
const routes: Routes = [

  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'home', component: HomeComponent, canActivate:[RouteGuardService] },
  { path: 'login', component: LoginComponent },
  { path: 'ShareDetails', component: ShareDetailsComponent, canActivate: [RouteGuardService] },
  { path: 'calculateNetworth', component: CalculateNetworthComponent, canActivate: [RouteGuardService] },
  { path: 'sellAssets', component: SellAssetsComponent, canActivate: [RouteGuardService] },
  { path: 'mutualDetails', component: MutualDetailsComponent, canActivate: [RouteGuardService] },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
