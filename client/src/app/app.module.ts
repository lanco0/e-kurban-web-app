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
import {AnasayfaComponent} from './komponentler/anasayfa/anasayfa.component';
import {KurbanBilgiComponent} from './komponentler/kurban-bilgi/kurban-bilgi.component';
import {KurbanlarComponent} from './komponentler/kurbanlar/kurbanlar.component';
import {KurbanAraComponent} from './komponentler/kurban-ara/kurban-ara.component';
import {LoglarComponent} from './komponentler/loglar/loglar.component';
import {GirisComponent} from './komponentler/giris/giris.component';
import {KurbanEkleComponent} from './komponentler/kurban-ekle/kurban-ekle.component';
import {HissedarlarComponent} from './komponentler/hissedarlar/hissedarlar.component';
import {HissedarEkleComponent} from './komponentler/hissedar-ekle/hissedar-ekle.component';
import {MatInputModule} from "@angular/material/input";
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatTableModule} from "@angular/material/table";
import {MatRadioModule} from "@angular/material/radio";
import {MatSelectModule} from "@angular/material/select";

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