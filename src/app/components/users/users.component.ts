import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/User';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})

export class UsersComponent implements OnInit {
  users: User[];
  showExtended = true;

  constructor() {
    console.log('constructor');
  }

  ngOnInit() {
    console.log('ngOnInit');
    this.users = [
      {
        name: 'Marcio',
        lastName: 'Rodrigues',
        age: 36,
        active: false,
        contact: {
          email: 'mafideju@outlook.com',
          phone: '954984696'
        },
        image: 'http://lorempixel.com/600/600/people/5',
        hide: true
      },
      {
        name: 'Silva',
        lastName: 'Junior',
        age: 48,
        active: false,
        contact: {
          email: 'silva-junior@outlook.com',
          phone: '654987512'
        },
        image: 'http://lorempixel.com/600/600/people/3',
        hide: true
      },
      {
        name: 'Marina',
        lastName: 'Ferrari',
        age: 38,
        active: false,
        contact: {
          email: 'ferrari-marina@outlook.com',
          phone: '987654321'
        },
        image: 'http://lorempixel.com/600/600/people/6',
        hide: true
      }
    ];
  }
  addUser(user: User) {
    this.users.unshift({
      name: 'Ariel',
      lastName: 'Chauca',
      age: 26,
      active: true,
      contact: {
        email: 'andinas@outlook.com',
        phone: '987654321'
      },
      image: 'http://lorempixel.com/600/600/people/8',
      hide: true
    });
  }
}
