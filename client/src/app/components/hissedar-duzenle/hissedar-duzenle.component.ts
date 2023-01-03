import {Component, OnInit} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {KurbanService} from "../../services/kurban.service";
import {Location} from "@angular/common";
import {HissedarService} from "../../services/hissedar.service";
import {Kurban} from "../../models/kurban";
import {HISSEDAR, KURBAN} from "../../mock-data";
import {Hissedar} from "../../models/hissedar";

@Component({
  selector: 'app-hissedar-duzenle',
  templateUrl: './hissedar-duzenle.component.html',
  styleUrls: ['./hissedar-duzenle.component.css']
})
export class HissedarDuzenleComponent implements OnInit{

  hissedar: Hissedar = HISSEDAR;

  constructor(
      private route: ActivatedRoute,
      private hissedarService: HissedarService,
  ) {}

  ngOnInit(): void {
    this.getHissedar();
  }

  getHissedar(): void {
    const id = parseInt(this.route.snapshot.paramMap.get('id')!, 10);
    // this.hissedarService.getHissedar(id)
    //     .subscribe(hissedar => this.hissedar = hissedar);
  }
}
