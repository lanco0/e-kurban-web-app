import { Component, OnInit } from '@angular/core';

import { Observable, Subject } from 'rxjs';

import {
   debounceTime, distinctUntilChanged, switchMap
 } from 'rxjs/operators';

import { Kurban } from '../_models/kurban';
import { KurbanService } from '../_services/kurban.service';

@Component({
  selector: 'app-kurban-search',
  templateUrl: './kurban-search.component.html',
  styleUrls: [ './kurban-search.component.css' ]
})
export class KurbanSearchComponent implements OnInit {
  kurbanlar$!: Observable<Kurban[]>;
  private searchTerms = new Subject<string>();

  constructor(private kurbanService: KurbanService) {}

  // Push a search term into the observable stream.
  search(term: string): void {
    this.searchTerms.next(term);
  }

  ngOnInit(): void {
    this.kurbanlar$ = this.searchTerms.pipe(
      // wait 300ms after each keystroke before considering the term
      debounceTime(300),

      // ignore new term if same as previous term
      distinctUntilChanged(),

      // switch to new search observable each time the term changes
      switchMap((term: string) => this.kurbanService.searchKurbanlar(term)),
    );
  }
}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at https://angular.io/license
*/