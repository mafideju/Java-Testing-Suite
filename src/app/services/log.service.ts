import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, of, combineLatest } from 'rxjs';
import { Logs } from '../models/Logs';

@Injectable({
  providedIn: 'root'
})
export class LogService {
  logs: Logs[];

  private logSource = new BehaviorSubject<Logs>({
    id: null,
    text: null,
    date: null
  });
  selectedLog = this.logSource.asObservable();

  constructor() {
    this.logs = [];
  }

  getLogs(): Observable<Logs[]> {
    return of(this.logs);
  }

  setFormLog(logs: Logs) {
    this.logSource.next(logs);
  }

  setNewLog(logs: Logs) {
    this.logs.unshift(logs);
  }

  updatedLog(logs: Logs) {
    this.logs.forEach((el, i) => {
      if (logs.id === el.id) {
        this.logs.splice(i, 1);
      }
    });
    this.logs.unshift(logs);
  }

  deleteLog(log: Logs) {
    console.log(log);

    this.logs.forEach((el, i) => {
      if (log.id === el.id) {
        this.logs.splice(i, 1);
      }
    });
  }
}
