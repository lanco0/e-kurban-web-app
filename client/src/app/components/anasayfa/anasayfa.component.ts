import {Component, OnInit} from '@angular/core';
import {Kurban} from '../../models/kurban';
import {KurbanService} from '../../services/kurban.service';
import {KURBANLAR} from "../../mock-data";

@Component({
    selector: 'app-anasayfa',
    templateUrl: './anasayfa.component.html',
    styleUrls: ['./anasayfa.component.css']
})
export class AnasayfaComponent implements OnInit {
    kurbanlar: Kurban[] = KURBANLAR;
    dataSource = this.kurbanlar;
    displayedColumns: string[] = ['kesimSira', 'cins', 'kunye', 'fiyat', 'kalanHisse'];

    constructor(private kurbanService: KurbanService) {
    }
    
    ngOnInit(): void {
        this.getKurbanlar();
    }

    getKurbanlar(): void {
        this.kurbanService.getKurbanlar()
            .subscribe(kurbanlar => this.kurbanlar = kurbanlar.slice(1, 5));
    }
}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at https://angular.io/license
*/