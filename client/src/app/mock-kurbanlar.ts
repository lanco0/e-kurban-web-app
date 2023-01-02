import {Kurban} from './_modeller/kurban';
import {Hisse} from "./_modeller/hisse";
import {Cins} from "./_enumlar/cins";
import {KunyeKucukbas} from "./_enumlar/kunye";
import {KunyeBuyukbas} from "./_enumlar/kunye";
import {Durum} from "./_enumlar/durum";

export const KURBANLAR: Kurban[] = [
  { id: 1, cins: Cins.KUCUKBAS, kunye: KunyeKucukbas.KOYUN, kupeNo: "AB123", kilo: 50, yas: 2, fiyat: 1500, durum: Durum.SATISTA, kesimSirasi: 1, hisse: undefined, name: "kucukbas1" },
  { id: 2, cins: Cins.KUCUKBAS, kunye: KunyeKucukbas.KOYUN, kupeNo: "AB124", kilo: 60, yas: 1, fiyat: 1200, durum: Durum.SATISTA, kesimSirasi: 2, hisse: undefined, name: "kucukbas2" },
  { id: 3, cins: Cins.BUYUKBAS, kunye: KunyeBuyukbas.BOGA, kupeNo: "AB125", kilo: 400, yas: 2, fiyat: 6200, durum: Durum.SATISTA, kesimSirasi: 3, hisse: undefined, name: "buyukbas1" },
];


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at https://angular.io/license
*/