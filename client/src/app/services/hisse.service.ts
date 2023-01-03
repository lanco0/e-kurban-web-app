import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import { Hisse } from '../models/hisse';
import { LogService } from './log.service';

@Injectable({ providedIn: 'root' })
export class HisseService {

    private apiUrl = 'api/v1/hisseler';  // URL to web api

    httpOptions = {
        headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };

    constructor(
        private http: HttpClient,
        private logService: LogService) { }

    /** GET hisseler from the server */
    getHisseler(): Observable<Hisse[]> {
        return this.http.get<Hisse[]>(this.apiUrl)
            .pipe(
                tap(_ => this.log('fetched hisseler')),
                catchError(this.handleError<Hisse[]>('getHisseler', []))
            );
    }

    /** GET hisse by id. Return `undefined` when id not found */
    getHisseNo404<Data>(id: number): Observable<Hisse> {
        const url = `${this.apiUrl}/?id=${id}`;
        return this.http.get<Hisse[]>(url)
            .pipe(
                map(hisseler => hisseler[0]), // returns a {0|1} element array
                tap(h => {
                    const outcome = h ? 'fetched' : 'did not find';
                    this.log(`${outcome} hisse id=${id}`);
                }),
                catchError(this.handleError<Hisse>(`getHisse id=${id}`))
            );
    }

    /** GET hisse by id. Will 404 if id not found */
    getHisse(id: number): Observable<Hisse> {
        const url = `${this.apiUrl}/${id}`;
        return this.http.get<Hisse>(url).pipe(
            tap(_ => this.log(`fetched hisse id=${id}`)),
            catchError(this.handleError<Hisse>(`getHisse id=${id}`))
        );
    }

    /* GET hisseler whose name contains search term */
    hisseAra(term: string): Observable<Hisse[]> {
        if (!term.trim()) {
            // if not search term, return empty hisse array.
            return of([]);
        }
        return this.http.get<Hisse[]>(`${this.apiUrl}/?name=${term}`).pipe(
            tap(x => x.length ?
                this.log(`found hisseler matching "${term}"`) :
                this.log(`no hisseler matching "${term}"`)),
            catchError(this.handleError<Hisse[]>('hisseAra', []))
        );
    }

    //////// Save methods //////////

    /** POST: add a new hisse to the server */
    addHisse(hisse: Hisse): Observable<Hisse> {
        return this.http.post<Hisse>(this.apiUrl, hisse, this.httpOptions).pipe(
            tap((newHisse: Hisse) => this.log(`added hisse w/ id=${newHisse.id}`)),
            catchError(this.handleError<Hisse>('addHisse'))
        );
    }

    /** DELETE: delete the hisse from the server */
    deleteHisse(id: number): Observable<Hisse> {
        const url = `${this.apiUrl}/${id}`;

        return this.http.delete<Hisse>(url, this.httpOptions).pipe(
            tap(_ => this.log(`deleted hisse id=${id}`)),
            catchError(this.handleError<Hisse>('deleteHisse'))
        );
    }

    /** PUT: update the hisse on the server */
    updateHisse(hisse: Hisse): Observable<any> {
        return this.http.put(this.apiUrl, hisse, this.httpOptions).pipe(
            tap(_ => this.log(`updated hisse id=${hisse.id}`)),
            catchError(this.handleError<any>('updateHisse'))
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

    /** Log a HisseService log with the LogService */
    private log(log: string) {
        this.logService.add(`HisseService: ${log}`);
    }
}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at https://angular.io/license
*/