import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';
import { Kurban } from '../_modeller/kurban';

@Injectable({
  providedIn: 'root',
})
export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const kurbanlar = [
      { id: 12, name: 'Dr. Nice' },
      { id: 13, name: 'Bombasto' },
      { id: 14, name: 'Celeritas' },
      { id: 15, name: 'Magneta' },
      { id: 16, name: 'RubberMan' },
      { id: 17, name: 'Dynama' },
      { id: 18, name: 'Dr. IQ' },
      { id: 19, name: 'Magma' },
      { id: 20, name: 'Tornado' }
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