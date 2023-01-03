import {Component, OnInit} from '@angular/core';
import {Kurban} from '../../models/kurban';
import {KurbanService} from '../../services/kurban.service';
import {KURBANLAR} from "../../mock-data";
import {Cins} from "../../enums/cins";

@Component({
    selector: 'app-anasayfa',
    templateUrl: './anasayfa.component.html',
    styleUrls: ['./anasayfa.component.css']
})
export class AnasayfaComponent implements OnInit {
    kurbanBayraminaKalanGun: number = 0;
    kurbanlar: Kurban[] = KURBANLAR;
    dataSource = this.kurbanlar;
    displayedColumns: string[] = ['kesimSira', 'cins', 'kunye', 'fiyat', 'kalanHisse'];

    constructor(private kurbanService: KurbanService) {
    }
    
    ngOnInit(): void {
        this.getKurbanlar();
    }

    getKurbanlar(): void {
        this.kurbanlar = KURBANLAR;
        // this.kurbanService.getKurbanlar()
        //     .subscribe(kurbanlar => this.kurbanlar = kurbanlar.slice(1, 5));
    }

    getKurbanBayraminaKalanGun(): void {
        this.kurbanService.getKurbanBayraminaKalanGun()
            .subscribe(kurbanBayraminaKalanGun => this.kurbanBayraminaKalanGun = kurbanBayraminaKalanGun);
    }

    selectTumu(): void {
        this.getKurbanlar();
        this.dataSource = this.kurbanlar;
    }

    selectKucukbas(): void {
        this.getKurbanlar();
        console.log(this.kurbanlar);
        this.kurbanlar = this.kurbanlar.filter(h => h.cins == Cins.KUCUKBAS);
        console.log(this.kurbanlar);
        this.dataSource = this.kurbanlar;
    }

    selectBuyukbas(): void {
        this.getKurbanlar();
        console.log(this.kurbanlar);
        this.kurbanlar = this.kurbanlar.filter(h => h.cins == Cins.BUYUKBAS);
        console.log(this.kurbanlar);
        this.dataSource = this.kurbanlar;
    }
}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at https://angular.io/license
*/