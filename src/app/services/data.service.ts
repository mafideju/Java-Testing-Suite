import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { of } from 'rxjs';
import { User } from '../models/User';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  users: User[];
  data: Observable<any>;

  constructor() {
    this.users = []; 
  }

  getUsers(): Observable<User[]> {
    return of(this.users);
  }

  addUser(user:User) {
    return this.users.unshift(user);
  }

  getData() {
    this.data = new Observable(observer => {
      observer.next()
    });
    return this.data;
  }
}
