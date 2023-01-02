import { Component, OnInit } from '@angular/core';
import { MesajService } from '../_servisler/mesaj.service';

@Component({
  selector: 'app-mesajlar',
  templateUrl: './mesajlar.component.html',
  styleUrls: ['./mesajlar.component.css']
})
export class MesajlarComponent implements OnInit {

  constructor(public mesajService: MesajService) {}

  ngOnInit() {
  }

}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at https://angular.io/license
*/