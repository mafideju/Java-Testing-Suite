import { Component, OnInit, ViewChild } from '@angular/core';
import { User } from 'src/app/models/User';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})

export class UsersComponent implements OnInit {
  user: User = {
    name: '',
    lastName: '',
    age: null,
    mainLanguage: '',
    active: false,
    contact: {
      email: '',
      phone: '',
    },
    image: `http://lorempixel.com/600/600/people/${Math.floor(Math.random() * 10 + 1)}`,
    hide: true,
    joinedAt: new Date()
  }
  users: User[];
  showExtended: boolean = true;
  showUserForm: boolean = false;

  // @ViewChild('userForm') form: any;

  constructor() {
    this.users = [];
  }

  ngOnInit() { }

  showUserInfo(user: User) {
    user.hide = !user.hide;
  }

  onSubmit() {
    this.users.unshift(this.user);
    this.user.joinedAt = new Date();

    setTimeout(() => {
      this.user = {
        name: '',
        lastName: '',
        age: null,
        mainLanguage: '',
        contact: {
          email: '',
          phone: '',
        },
      }
    }, 666);
  }
}
