import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  name: string = 'Marcio';
  lastName: string = 'Rodrigues';
  age: number = 36;

  constructor() { }

  ngOnInit() {
  }

}
