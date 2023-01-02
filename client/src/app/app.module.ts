import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';
import { InMemoryDataService } from './servisler/in-memory-data.service';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { AnasayfaComponent } from './komponentler/anasayfa/anasayfa.component';
import { KurbanBilgiComponent } from './komponentler/kurban-bilgi/kurban-bilgi.component';
import { KurbanlarComponent } from './komponentler/kurbanlar/kurbanlar.component';
import { KurbanAraComponent } from './komponentler/kurban-ara/kurban-ara.component';
import { LoglarComponent } from './komponentler/loglar/loglar.component';
import { GirisComponent } from './komponentler/giris/giris.component';
import { KurbanEkleComponent } from './komponentler/kurban-ekle/kurban-ekle.component';
import { HissedarlarComponent } from './komponentler/hissedarlar/hissedarlar.component';
import { HissedarEkleComponent } from './komponentler/hissedar-ekle/hissedar-ekle.component';

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
    GirisComponent,
    AnasayfaComponent,
    KurbanlarComponent,
    KurbanEkleComponent,
    KurbanBilgiComponent,
    HissedarlarComponent,
    HissedarEkleComponent,
    KurbanAraComponent,
    LoglarComponent,
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at https://angular.io/license
*/