import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  users = [
    {
      name: 'Marcio',
      lastName: 'Rodrigues',
      age: 36,
    },
    {
      name: 'Silva',
      lastName: 'Junior',
      age: 48,
    },
    {
      name: 'Marina',
      lastName: 'Ferrari',
      age: 38,
    }
  ]

  constructor() {
    console.log('constructor')
  }

  ngOnInit() {
    console.log('ngOnInit')
  }

}
