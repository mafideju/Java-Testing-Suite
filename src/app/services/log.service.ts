import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, of, combineLatest } from 'rxjs';
import { Logs } from '../models/Logs';

@Injectable({
  providedIn: 'root'
})
export class LogService {
  logs: Logs[];

  private logSource = new BehaviorSubject<Logs>({id: null, text: null, date: null});
  private stateSource = new BehaviorSubject<boolean>(true);

  stateClear = this.stateSource.asObservable();
  selectedLog = this.logSource.asObservable();

  constructor() {
    this.logs = [];
  }

  getLogs(): Observable<Logs[]> {
    if (localStorage.getItem('logs') === null) {
      this.logs = [];
    } else {
      this.logs = JSON.parse(localStorage.getItem('logs'));
    }
    return of(this.logs);
  }

  setFormLog(logs: Logs) {
    this.logSource.next(logs);
  }

  setNewLog(logs: Logs) {
    this.logs.unshift(logs);
    localStorage.setItem('logs', JSON.stringify(logs));
  }

  updatedLog(logs: Logs) {
    this.logs.forEach((el, i) => {
      if (logs.id === el.id) {
        this.logs.splice(i, 1);
      }
    });
    this.logs.unshift(logs);
    localStorage.setItem('logs', JSON.stringify(this.logs));
  }

  deleteLog(log: Logs) {
    this.logs.forEach((el, i) => {
      if (log.id === el.id) {
        this.logs.splice(i, 1);
      }
    });
    localStorage.setItem('logs', JSON.stringify(this.logs));
  }

  clearStateService() {
    this.stateSource.next(true);
  }
}
