import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/User';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  users: User[];

  constructor() {
    console.log('constructor')
  }

  ngOnInit() {
    console.log('ngOnInit')
    this.users = [
      {
        name: 'Marcio',
        lastName: 'Rodrigues',
        age: 36,
        active: true
      },
      {
        name: 'Silva',
        lastName: 'Junior',
        age: 48,
        active: true
      },
      {
        name: 'Marina',
        lastName: 'Ferrari',
        age: 38,
        active: true
      }
    ]
  }

}
