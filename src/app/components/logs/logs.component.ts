import { Component, OnInit } from '@angular/core';
import { Logs } from 'src/app/models/Logs';
import { LogService } from 'src/app/services/log.service';


@Component({
  selector: 'app-logs',
  templateUrl: './logs.component.html',
  styleUrls: ['./logs.component.css']
})
export class LogsComponent implements OnInit {
  logs: Logs[];
  selectedLog: Logs;
  loaded = false;

  constructor(private logService: LogService) { }

  ngOnInit() {
    this.logService.stateClear.subscribe(clear => {
      if (clear) {
        this.selectedLog = {id: '', text: '', date: ''};
      }
    });

    this.logService.getLogs().subscribe(logs => {
      this.logs = logs;
      this.loaded = true;
    });

    // SEM OBSERVABLE SERIA ASSIM =>
    // this.logs = this.logService.getLogs();
  }

  onSelect(logs: Logs) {
    this.selectedLog = logs;
    this.logService.setFormLog(logs);
  }

  onDelete(log: Logs) {
    this.logService.deleteLog(log);
  }
}
