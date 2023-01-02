import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';
import { InMemoryDataService } from './_servisler/in-memory-data.service';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { AnasayfaComponent } from './anasayfa/anasayfa.component';
import { KurbanBilgiComponent } from './kurban-bilgi/kurban-bilgi.component';
import { KurbanlarComponent } from './kurbanlar/kurbanlar.component';
import { KurbanAraComponent } from './kurban-ara/kurban-ara.component';
import { LoglarComponent } from './loglar/loglar.component';
import { GirisComponent } from './giris/giris.component';
import { KurbanEkleComponent } from './kurban-ekle/kurban-ekle.component';
import { HissedarlarComponent } from './hissedarlar/hissedarlar.component';
import { HissedarEkleComponent } from './hissedar-ekle/hissedar-ekle.component';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,

    // The HttpClientInMemoryWebApiModule module intercepts HTTP requests
    // and returns simulated server responses.
    // Remove it when a real server is ready to receive requests.
    HttpClientInMemoryWebApiModule.forRoot(
      InMemoryDataService, { dataEncapsulation: false }
    )
  ],
  declarations: [
    AppComponent,
    AnasayfaComponent,
    KurbanlarComponent,
    KurbanBilgiComponent,
    LoglarComponent,
    KurbanAraComponent,
    GirisComponent,
    KurbanEkleComponent,
    HissedarlarComponent,
    HissedarEkleComponent
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at https://angular.io/license
*/