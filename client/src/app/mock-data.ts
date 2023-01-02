import {Kurban} from './models/kurban';
import {Hisse} from "./models/hisse";
import {Cins} from "./enums/cins";
import {KunyeKucukbas} from "./enums/kunye";
import {KunyeBuyukbas} from "./enums/kunye";
import {Durum} from "./enums/durum";
import {Hissedar} from "./models/hissedar";

export const KURBAN: Kurban =
  { id: 1, cins: Cins.KUCUKBAS, kunye: KunyeKucukbas.KOYUN, kupeNo: "AB123", kilo: 50, yas: 2, fiyat: 1500, durum: Durum.SATISTA, kesimSirasi: 1, hisse: undefined }
  ;

export const KURBANLAR: Kurban[] = [
  { id: 1, cins: Cins.KUCUKBAS, kunye: KunyeKucukbas.KOYUN, kupeNo: "AB123", kilo: 50, yas: 2, fiyat: 1500, durum: Durum.SATISTA, kesimSirasi: 1, hisse: undefined },
  { id: 2, cins: Cins.KUCUKBAS, kunye: KunyeKucukbas.KUZU, kupeNo: "AB124", kilo: 60, yas: 1, fiyat: 1200, durum: Durum.SATILDI, kesimSirasi: 2, hisse: undefined },
  { id: 3, cins: Cins.BUYUKBAS, kunye: KunyeBuyukbas.BOGA, kupeNo: "AB125", kilo: 400, yas: 2, fiyat: 6200, durum: Durum.SATISTA, kesimSirasi: 3, hisse: undefined },
];

export const HISSEDARLAR: Hissedar[] = [
  { id: 1, adSoyad: "Ahmet Çelik", tel: 5321234567 },
  { id: 2, adSoyad: "Ayşe Doğan", tel: 5331245621 },
  { id: 3, adSoyad: "Mehmet Kaya", tel: 5551234567 },
];


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at https://angular.io/license
*/