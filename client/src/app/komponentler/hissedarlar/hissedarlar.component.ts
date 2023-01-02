import { Component } from '@angular/core';
import {Kurban} from "../../modeller/kurban";
import {HISSEDARLAR} from "../../mock-data";
import {Hissedar} from "../../modeller/hissedar";

@Component({
  selector: 'app-hissedarlar',
  templateUrl: './hissedarlar.component.html',
  styleUrls: ['./hissedarlar.component.css']
})
export class HissedarlarComponent {
  hissedarlar: Hissedar[] = HISSEDARLAR;
  dataSource = this.hissedarlar;
  displayedColumns: string[] = ['adSoyad', 'tel'];
}
