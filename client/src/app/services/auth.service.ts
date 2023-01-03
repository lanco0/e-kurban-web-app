import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import {Observable, of} from 'rxjs';
import {catchError, map, tap} from 'rxjs/operators';

import {User} from '../models/user';
import {LogService} from './log.service';
import {UserLogin} from "../models/userLogin";
import {FormControl} from "@angular/forms";

@Injectable({providedIn: 'root'})
export class AuthService {

    private apiUrl = 'api/v1/';  // URL to web api

    httpOptions = {
        headers: new HttpHeaders({'Content-Type': 'application/json'})
    };

    constructor(
        private http: HttpClient,
        private logService: LogService) {
    }

    giris(userLoginDto: { eposta: string | null; sifre: string | null }): Observable<User> {
        // console.log(userLoginDto);
        return this.http.post<User>(this.apiUrl + "giris", userLoginDto, this.httpOptions).pipe(
            tap((currentUser: User) => this.log(`logged in user w/ id=${currentUser.id}`)),
            catchError(this.handleError<User>('loginUser'))
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

    /** Log a UserService log with the LogService */
    private log(log: string) {
        this.logService.add(`UserService: ${log}`);
    }
}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at https://angular.io/license
*/