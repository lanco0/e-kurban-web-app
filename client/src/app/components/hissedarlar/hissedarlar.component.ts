import { Component } from '@angular/core';
import {HISSEDARLAR} from "../../mock-data";
import {Hissedar} from "../../models/hissedar";
import {HissedarService} from "../../services/hissedar.service";

@Component({
  selector: 'app-hissedarlar',
  templateUrl: './hissedarlar.component.html',
  styleUrls: ['./hissedarlar.component.css']
})
export class HissedarlarComponent {
  hissedarlar: Hissedar[] = HISSEDARLAR;
  dataSource = this.hissedarlar;
  displayedColumns: string[] = ['adSoyad', 'tel', 'islemler'];

  constructor(private hissedarService: HissedarService) {
  }

  delete(hissedar: Hissedar): void {
    this.hissedarlar = this.hissedarlar.filter(h => h !== hissedar);
    this.hissedarService.deleteHissedar(hissedar.id).subscribe();
  }

}
