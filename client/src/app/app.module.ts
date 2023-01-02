import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {AppRoutingModule} from './app-routing.module';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {MatToolbarModule} from "@angular/material/toolbar";
import {MatIconModule} from "@angular/material/icon";
import {MatButtonModule} from "@angular/material/button";

import {AppComponent} from './app.component';
import {AnasayfaComponent} from './components/anasayfa/anasayfa.component';
import {KurbanBilgiComponent} from './components/kurban-bilgi/kurban-bilgi.component';
import {KurbanlarComponent} from './components/kurbanlar/kurbanlar.component';
import {KurbanAraComponent} from './components/kurban-ara/kurban-ara.component';
import {LoglarComponent} from './components/loglar/loglar.component';
import {GirisComponent} from './components/giris/giris.component';
import {KurbanEkleComponent} from './components/kurban-ekle/kurban-ekle.component';
import {HissedarlarComponent} from './components/hissedarlar/hissedarlar.component';
import {HissedarEkleComponent} from './components/hissedar-ekle/hissedar-ekle.component';
import {MatInputModule} from "@angular/material/input";
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatTableModule} from "@angular/material/table";
import {MatRadioModule} from "@angular/material/radio";
import {MatSelectModule} from "@angular/material/select";
import { HissedarDuzenleComponent } from './components/hissedar-duzenle/hissedar-duzenle.component';

@NgModule({
    imports: [
        BrowserModule,
        ReactiveFormsModule,
        AppRoutingModule,
        HttpClientModule,
        BrowserAnimationsModule,
        FormsModule,
        MatToolbarModule,
        MatIconModule,
        MatButtonModule,
        MatInputModule,
        MatSidenavModule,
        MatTableModule,
        MatRadioModule,
        MatSelectModule,
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
        HissedarDuzenleComponent,
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at https://angular.io/license
*/