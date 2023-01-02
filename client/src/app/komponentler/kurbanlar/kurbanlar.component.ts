import {Component, OnInit} from '@angular/core';

import {Kurban} from '../../modeller/kurban';
import {KurbanService} from '../../servisler/kurban.service';
import {KURBANLAR} from "../../mock-data";

@Component({
    selector: 'app-kurbanlar',
    templateUrl: './kurbanlar.component.html',
    styleUrls: ['./kurbanlar.component.css']
})
export class KurbanlarComponent implements OnInit {
    kurbanlar: Kurban[] = KURBANLAR;
    dataSource = this.kurbanlar;
    displayedColumns: string[] = ['kesimSira', 'kupeNo', 'cins', 'kunye', 'kilo', 'yas', 'fiyat', 'durum'];

    constructor(private kurbanService: KurbanService) {
    }

    ngOnInit(): void {
        this.getKurbanlar();
    }

    getKurbanlar(): void {
        this.kurbanService.getKurbanlar()
            .subscribe(kurbanlar => this.kurbanlar = kurbanlar);
    }



    delete(kurban: Kurban): void {
        this.kurbanlar = this.kurbanlar.filter(h => h !== kurban);
        this.kurbanService.deleteKurban(kurban.id).subscribe();
    }

}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at https://angular.io/license
*/