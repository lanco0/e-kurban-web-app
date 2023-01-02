import { Component, OnInit } from '@angular/core';
import { LogService } from '../../servisler/log.service';

@Component({
  selector: 'app-loglar',
  templateUrl: './loglar.component.html',
  styleUrls: ['./loglar.component.css']
})
export class LoglarComponent implements OnInit {

  constructor(public logService: LogService) {}

  ngOnInit() {
  }

}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at https://angular.io/license
*/