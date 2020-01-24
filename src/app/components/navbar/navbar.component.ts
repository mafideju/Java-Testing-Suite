import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/User';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  enableAdd = true;
  today: number = Date.now();
  users: any;

  constructor() { }

  ngOnInit() {
    // this.enableAdd = false;
  }

  addUser(user: User) {
    console.log(user);
    // this.users.push(user);
  }
}
