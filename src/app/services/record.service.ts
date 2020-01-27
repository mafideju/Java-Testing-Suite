import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs'
import { Record } from '../models/Record';

@Injectable({
  providedIn: 'root'
})
export class RecordService {
  recordURL: string = `https://jsonplaceholder.typicode.com/users`


  constructor(private _http: HttpClient) { }

  getRecords(): Observable<Record[]> {
    return this._http.get<Record[]>(this.recordURL);
  }
}
