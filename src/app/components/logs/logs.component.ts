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

  constructor(private logService: LogService) { }

  ngOnInit() {
    this.logs = this.logService.getLogs();
  }

  onSelect(logs: Logs) {
    this.logService.setFormLog(logs);
  }
}
