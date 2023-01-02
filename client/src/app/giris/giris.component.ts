import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-giris',
  templateUrl: './giris.component.html',
  styleUrls: ['./giris.component.css']
})
export class GirisComponent{

  constructor(private router: Router) { }

  onSubmit(): void {
      this.router.navigate(['/dashboard']);
  }
}