import {Hisse} from "./hisse";
import {Cins} from "../enums/cins";
import {KunyeKucukbas} from "../enums/kunye";
import {KunyeBuyukbas} from "../enums/kunye";
import {Durum} from "../enums/durum";

export interface Kurban {
  id: number;
  cins: Cins;
  kunye: KunyeKucukbas | KunyeBuyukbas;
  kupeNo: string;
  kilo: number;
  yas: number;
  fiyat: number;
  durum: Durum;
  kesimSirasi?: number;
  hisse?: Hisse;
}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at https://angular.io/license
*/