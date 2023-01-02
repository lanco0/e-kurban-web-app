import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';
import { Kurban } from '../modeller/kurban';
import {Cins} from "../enumlar/cins";
import {KunyeBuyukbas, KunyeKucukbas} from "../enumlar/kunye";
import {Durum} from "../enumlar/durum";

@Injectable({
  providedIn: 'root',
})
export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const kurbanlar = [
      { id: 1, cins: Cins.KUCUKBAS, kunye: KunyeKucukbas.KOYUN, kupeNo: "AB123", kilo: 50, yas: 2, fiyat: 1500, durum: Durum.SATISTA, kesimSirasi: 1, hisse: undefined, name: "kucukbas1" },
      { id: 2, cins: Cins.KUCUKBAS, kunye: KunyeKucukbas.KOYUN, kupeNo: "AB124", kilo: 60, yas: 1, fiyat: 1200, durum: Durum.SATISTA, kesimSirasi: 2, hisse: undefined, name: "kucukbas2" },
      { id: 3, cins: Cins.BUYUKBAS, kunye: KunyeBuyukbas.BOGA, kupeNo: "AB125", kilo: 400, yas: 2, fiyat: 6200, durum: Durum.SATISTA, kesimSirasi: 3, hisse: undefined, name: "buyukbas1" }
    ];
    return {kurbanlar};
  }

  // Overrides the genId method to ensure that a kurban always has an id.
  // If the kurbanlar array is empty,
  // the method below returns the initial number (11).
  // if the kurbanlar array is not empty, the method below returns the highest
  // kurban id + 1.
  genId(kurbanlar: Kurban[]): number {
    return kurbanlar.length > 0 ? Math.max(...kurbanlar.map(kurban => kurban.id)) + 1 : 11;
  }
}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at https://angular.io/license
*/