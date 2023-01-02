import { Component } from '@angular/core';
import {Kurban} from '../../models/kurban';
import {KurbanService} from '../../services/kurban.service';
import {KURBANLAR} from "../../mock-data";
import {Cins} from "../../enums/cins";
import {KunyeBuyukbas, KunyeKucukbas} from "../../enums/kunye";
import {MatLegacySelect} from "@angular/material/legacy-select";
import {MatSelect} from "@angular/material/select";

@Component({
  selector: 'app-kurban-ekle',
  templateUrl: './kurban-ekle.component.html',
  styleUrls: ['./kurban-ekle.component.css']
})
export class KurbanEkleComponent {

  constructor(private kurbanService: KurbanService) {
  }

  kurbanlar: Kurban[] = KURBANLAR;
  cinsler = Object.values(Cins);
  kunyeler: string [] = [];

  onCinsChange(secilenCins: { value: any; }) {
    if (secilenCins.value === Cins.KUCUKBAS){
      this.kunyeler = Object.values(KunyeKucukbas);
    }else if (secilenCins.value === Cins.BUYUKBAS){
      this.kunyeler = Object.values(KunyeBuyukbas);
    }
  }

  add(cins: MatSelect, kunye: MatSelect, kupeNo: HTMLInputElement, kilo: HTMLInputElement, yas: HTMLInputElement, fiyat: HTMLInputElement): void {
    this.kurbanService.addKurban({cins, kunye, kupeNo, kilo, yas, fiyat} as unknown as Kurban)
        .subscribe(kurban => {
          this.kurbanlar.push(kurban);
        });
  }

}
