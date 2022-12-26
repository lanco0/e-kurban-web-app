import { Component, OnInit } from '@angular/core';
import { Kurban } from '../kurban';
import { KurbanService } from '../kurban.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: [ './dashboard.component.css' ]
})
export class DashboardComponent implements OnInit {
  kurbanlar: Kurban[] = [];

  constructor(private kurbanService: KurbanService) { }

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