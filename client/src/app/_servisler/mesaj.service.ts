import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class MesajService {
  mesajlar: string[] = [];

  add(mesaj: string) {
    this.mesajlar.push(mesaj);
  }

  clear() {
    this.mesajlar = [];
  }
}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at https://angular.io/license
*/