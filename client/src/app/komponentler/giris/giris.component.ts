import {Component, NgModule} from '@angular/core';
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

    email = new FormControl('', [Validators.required, Validators.email]);

    getErrorMessage() {
        if (this.email.hasError('required')) {
            return 'You must enter a value';
        }

        return this.email.hasError('email') ? 'Not a valid email' : '';
    }

    onSubmit(): void {
        this.router.navigate(['/anasayfa']);
    }
}