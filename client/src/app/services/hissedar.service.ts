import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import { Hissedar } from '../models/hissedar';
import { LogService } from './log.service';

@Injectable({ providedIn: 'root' })
export class HissedarService {

    private apiUrl = 'api/v1/hissedarlar';  // URL to web api

    httpOptions = {
        headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };

    constructor(
        private http: HttpClient,
        private logService: LogService) { }

    /** GET hissedarlar from the server */
    getHissedarlar(): Observable<Hissedar[]> {
        return this.http.get<Hissedar[]>(this.apiUrl)
            .pipe(
                tap(_ => this.log('fetched hissedarlar')),
                catchError(this.handleError<Hissedar[]>('getHissedarlar', []))
            );
    }

    /** GET hissedar by id. Return `undefined` when id not found */
    getHissedarNo404<Data>(id: number): Observable<Hissedar> {
        const url = `${this.apiUrl}/?id=${id}`;
        return this.http.get<Hissedar[]>(url)
            .pipe(
                map(hissedarlar => hissedarlar[0]), // returns a {0|1} element array
                tap(h => {
                    const outcome = h ? 'fetched' : 'did not find';
                    this.log(`${outcome} hissedar id=${id}`);
                }),
                catchError(this.handleError<Hissedar>(`getHissedar id=${id}`))
            );
    }

    /** GET hissedar by id. Will 404 if id not found */
    getHissedar(id: number): Observable<Hissedar> {
        const url = `${this.apiUrl}/${id}`;
        return this.http.get<Hissedar>(url).pipe(
            tap(_ => this.log(`fetched hissedar id=${id}`)),
            catchError(this.handleError<Hissedar>(`getHissedar id=${id}`))
        );
    }

    /* GET hissedarlar whose name contains search term */
    hissedarAra(term: string): Observable<Hissedar[]> {
        if (!term.trim()) {
            // if not search term, return empty hissedar array.
            return of([]);
        }
        return this.http.get<Hissedar[]>(`${this.apiUrl}/?name=${term}`).pipe(
            tap(x => x.length ?
                this.log(`found hissedarlar matching "${term}"`) :
                this.log(`no hissedarlar matching "${term}"`)),
            catchError(this.handleError<Hissedar[]>('hissedarAra', []))
        );
    }

    //////// Save methods //////////

    /** POST: add a new hissedar to the server */
    addHissedar(hissedar: Hissedar): Observable<Hissedar> {
        return this.http.post<Hissedar>(this.apiUrl, hissedar, this.httpOptions).pipe(
            tap((newHissedar: Hissedar) => this.log(`added hissedar w/ id=${newHissedar.id}`)),
            catchError(this.handleError<Hissedar>('addHissedar'))
        );
    }

    /** DELETE: delete the hissedar from the server */
    deleteHissedar(id: number): Observable<Hissedar> {
        const url = `${this.apiUrl}/${id}`;

        return this.http.delete<Hissedar>(url, this.httpOptions).pipe(
            tap(_ => this.log(`deleted hissedar id=${id}`)),
            catchError(this.handleError<Hissedar>('deleteHissedar'))
        );
    }

    /** PUT: update the hissedar on the server */
    updateHissedar(hissedar: Hissedar): Observable<any> {
        return this.http.put(this.apiUrl, hissedar, this.httpOptions).pipe(
            tap(_ => this.log(`updated hissedar id=${hissedar.id}`)),
            catchError(this.handleError<any>('updateHissedar'))
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
            this.log(`${operation} failed: ${error.log}`);

            // Let the app keep running by returning an empty result.
            return of(result as T);
        };
    }

    /** Log a HissedarService log with the LogService */
    private log(log: string) {
        this.logService.add(`HissedarService: ${log}`);
    }
}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at https://angular.io/license
*/