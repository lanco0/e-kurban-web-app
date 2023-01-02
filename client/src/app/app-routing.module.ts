import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { GirisComponent } from "./giris/giris.component";
import { AnasayfaComponent } from './anasayfa/anasayfa.component';
import { KurbanlarComponent } from './kurbanlar/kurbanlar.component';
import { KurbanBilgiComponent } from './kurban-bilgi/kurban-bilgi.component';

const routes: Routes = [
  { path: '', redirectTo: '/anasayfa', pathMatch: 'full' },
  { path: 'giris', component: GirisComponent },
  { path: 'anasayfa', component: AnasayfaComponent },
  { path: 'bilgi/:id', component: KurbanBilgiComponent },
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