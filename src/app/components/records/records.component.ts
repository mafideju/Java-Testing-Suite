import { Component, OnInit } from '@angular/core';
import { RecordService } from '../../services/record.service'
import { Record } from 'src/app/models/Record';
// import { userInfo } from 'os';

@Component({
  selector: 'app-records',
  templateUrl: './records.component.html',
  styleUrls: ['./records.component.css']
})
export class RecordsComponent implements OnInit {
  records: Record[];
  record: Record[];
  hide = false;


  constructor(private recordService: RecordService) { }

  ngOnInit() {
  }

  showInfo() {
    this.hide = !this.hide
  }

  moreInfo(id) {
    console.log('teste', id)
  }

  getRecords() {
    this.recordService.getRecords().subscribe(records => {
        this.records = records;
      }
    )
  }
}
