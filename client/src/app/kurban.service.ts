import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import { Kurban } from './kurban';
import { MessageService } from './message.service';


@Injectable({ providedIn: 'root' })
export class KurbanService {

  private kurbanlarUrl = 'api/kurbanlar';  // URL to web api

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(
    private http: HttpClient,
    private messageService: MessageService) { }

  /** GET kurbanlar from the server */
  getKurbanlar(): Observable<Kurban[]> {
    return this.http.get<Kurban[]>(this.kurbanlarUrl)
      .pipe(
        tap(_ => this.log('fetched kurbanlar')),
        catchError(this.handleError<Kurban[]>('getKurbanlar', []))
      );
  }

  /** GET kurban by id. Return `undefined` when id not found */
  getKurbanNo404<Data>(id: number): Observable<Kurban> {
    const url = `${this.kurbanlarUrl}/?id=${id}`;
    return this.http.get<Kurban[]>(url)
      .pipe(
        map(kurbanlar => kurbanlar[0]), // returns a {0|1} element array
        tap(h => {
          const outcome = h ? 'fetched' : 'did not find';
          this.log(`${outcome} kurban id=${id}`);
        }),
        catchError(this.handleError<Kurban>(`getKurban id=${id}`))
      );
  }

  /** GET kurban by id. Will 404 if id not found */
  getKurban(id: number): Observable<Kurban> {
    const url = `${this.kurbanlarUrl}/${id}`;
    return this.http.get<Kurban>(url).pipe(
      tap(_ => this.log(`fetched kurban id=${id}`)),
      catchError(this.handleError<Kurban>(`getKurban id=${id}`))
    );
  }

  /* GET kurbanlar whose name contains search term */
  searchKurbanlar(term: string): Observable<Kurban[]> {
    if (!term.trim()) {
      // if not search term, return empty kurban array.
      return of([]);
    }
    return this.http.get<Kurban[]>(`${this.kurbanlarUrl}/?name=${term}`).pipe(
      tap(x => x.length ?
         this.log(`found kurbanlar matching "${term}"`) :
         this.log(`no kurbanlar matching "${term}"`)),
      catchError(this.handleError<Kurban[]>('searchKurbanlar', []))
    );
  }

  //////// Save methods //////////

  /** POST: add a new kurban to the server */
  addKurban(kurban: Kurban): Observable<Kurban> {
    return this.http.post<Kurban>(this.kurbanlarUrl, kurban, this.httpOptions).pipe(
      tap((newKurban: Kurban) => this.log(`added kurban w/ id=${newKurban.id}`)),
      catchError(this.handleError<Kurban>('addKurban'))
    );
  }

  /** DELETE: delete the kurban from the server */
  deleteKurban(id: number): Observable<Kurban> {
    const url = `${this.kurbanlarUrl}/${id}`;

    return this.http.delete<Kurban>(url, this.httpOptions).pipe(
      tap(_ => this.log(`deleted kurban id=${id}`)),
      catchError(this.handleError<Kurban>('deleteKurban'))
    );
  }

  /** PUT: update the kurban on the server */
  updateKurban(kurban: Kurban): Observable<any> {
    return this.http.put(this.kurbanlarUrl, kurban, this.httpOptions).pipe(
      tap(_ => this.log(`updated kurban id=${kurban.id}`)),
      catchError(this.handleError<any>('updateKurban'))
    );
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   *
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  /** Log a KurbanService message with the MessageService */
  private log(message: string) {
    this.messageService.add(`KurbanService: ${message}`);
  }
}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at https://angular.io/license
*/