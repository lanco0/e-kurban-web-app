import {Hisse} from "./hisse";
import {Cins} from "../_enumlar/cins";
import {KunyeKucukbas} from "../_enumlar/kunye";
import {KunyeBuyukbas} from "../_enumlar/kunye";
import {Durum} from "../_enumlar/durum";

export interface Kurban {
  id: number;
  cins: Cins;
  kunye: KunyeKucukbas | KunyeBuyukbas;
  kupeNo: string;
  kilo: number;
  yas: number;
  fiyat: number;
  durum: Durum;
  kesimSirasi: number;
  hisse: Hisse;
}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at https://angular.io/license
*/