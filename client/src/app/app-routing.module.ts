import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { GirisComponent } from "./giris/giris.component";
import { DashboardComponent } from './dashboard/dashboard.component';
import { KurbanlarComponent } from './kurbanlar/kurbanlar.component';
import { KurbanDetailComponent } from './kurban-detail/kurban-detail.component';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'giris', component: GirisComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'detail/:id', component: KurbanDetailComponent },
  { path: 'kurbanlar', component: KurbanlarComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at https://angular.io/license
*/