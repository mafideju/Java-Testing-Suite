import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, of } from 'rxjs';
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
    this.logs = [
      {
        id: '1',
        text: 'Componente Dois',
        date: new Date()
      },
      {
        id: '2',
        text: 'Componente Terceiro',
        date: new Date()
      },
      {
        id: '3',
        text: 'Quarto Componente',
        date: new Date()
      },
    ];
  }

  getLogs() {
    return this.logs;
  }

  setFormLog(logs: Logs) {
    this.logSource.next(logs);
  }
}
