import { Component, OnInit } from '@angular/core';
import { Logs } from 'src/app/models/Logs';
import { LogService } from 'src/app/services/log.service';
import uuid from 'uuid';

@Component({
  selector: 'app-log-form',
  templateUrl: './log-form.component.html',
  styleUrls: ['./log-form.component.css']
})
export class LogFormComponent implements OnInit {
  logs: Logs[];
  id: string;
  text: string;
  date: string;
  isNew = true;


  constructor(private logService: LogService) { }

  ngOnInit() {
    this.logService.selectedLog.subscribe(log => {
      if (log.id !== null) {
        this.isNew = false;
        this.id = log.id;
        this.text = log.text;
        this.date = log.date;
      }
    });
  }

  onSubmit() {
    if (this.isNew) {
      const newLog = {
        id: uuid(),
        text: this.text,
        date: new Date()
      };
      this.logService.setNewLog(newLog);
    } else {
      const updatedLog = {
        id: this.id,
        text: this.text,
        date: new Date()
      };
      this.logService.updatedLog(updatedLog);
    }
  }
}
