import { Component } from '@angular/core';
import {Kurban} from '../../modeller/kurban';
import {KurbanService} from '../../servisler/kurban.service';
import {KURBANLAR} from "../../mock-data";

@Component({
  selector: 'app-kurban-ekle',
  templateUrl: './kurban-ekle.component.html',
  styleUrls: ['./kurban-ekle.component.css']
})
export class KurbanEkleComponent {

  constructor(private kurbanService: KurbanService) {
  }

  kurbanlar: Kurban[] = KURBANLAR;

  add(name: string): void {
    name = name.trim();
    if (!name) {
      return;
    }
    this.kurbanService.addKurban({name} as Kurban)
        .subscribe(kurban => {
          this.kurbanlar.push(kurban);
        });
  }

}
