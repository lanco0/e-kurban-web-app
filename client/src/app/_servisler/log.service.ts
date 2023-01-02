import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class LogService {
  loglar: string[] = [];

  add(log: string) {
    this.loglar.push(log);
  }

  clear() {
    this.loglar = [];
  }
}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at https://angular.io/license
*/