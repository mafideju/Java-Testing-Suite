import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/User';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})

export class UsersComponent implements OnInit {
  users: User[];
  showExtended: boolean = true;

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
	active: true,
	contact: {
		email: 'mafideju@outlook.com',
		phone: '954984696'
	}
      },
      {
        name: 'Silva',
        lastName: 'Junior',
        age: 48,
	active: true,
	contact: {
		email: 'silva-junior@outlook.com',
		phone: '654987512'
	} 
      },
      {
        name: 'Marina',
        lastName: 'Ferrari',
        age: 38,
	active: true,
	contact: {
		email: 'ferrari-marina@outlook.com',
		phone: '987654321'
	}
      }
    ];

    this.addUser({
      name: 'Guilherme',
      lastName: 'Arantes',
      age: 60,
      active: true,
      contact: {
	email: 'arantes@guilherme.com',
	phone: '987654321'
      }  
    });
  }
  
  addUser(user: User) {
    this.users.push(user)
  }

}
