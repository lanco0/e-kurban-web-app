import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {FormControl, Validators} from "@angular/forms";

@Component({
    selector: 'app-giris',
    templateUrl: './giris.component.html',
    styleUrls: ['./giris.component.css']
})

export class GirisComponent {

    constructor(private router: Router) {
    }

    eposta = new FormControl('', [Validators.required, Validators.email]);
    hide = true;

    getErrorMessage() {
        if (this.eposta.hasError('required')) {
            return 'Bir değer girmek zorundasın.';
        }

        return this.eposta.hasError('email') ? 'Geçerli bir eposta değil.' : '';
    }


    // onSubmit(): void {
    //     this.router.navigate(['/anasayfa']);
    // }
}