import { Component, OnInit } from '@angular/core';

import { Kurban } from '../kurban';
import { KurbanService } from '../kurban.service';

@Component({
  selector: 'app-kurbanlar',
  templateUrl: './kurbanlar.component.html',
  styleUrls: ['./kurbanlar.component.css']
})
export class KurbanlarComponent implements OnInit {
  kurbanlar: Kurban[] = [];

  constructor(private kurbanService: KurbanService) { }

  ngOnInit(): void {
    this.getKurbanlar();
  }

  getKurbanlar(): void {
    this.kurbanService.getKurbanlar()
    .subscribe(kurbanlar => this.kurbanlar = kurbanlar);
  }

  add(name: string): void {
    name = name.trim();
    if (!name) { return; }
    this.kurbanService.addKurban({ name } as Kurban)
      .subscribe(kurban => {
        this.kurbanlar.push(kurban);
      });
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