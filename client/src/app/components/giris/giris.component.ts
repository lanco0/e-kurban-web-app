import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {FormControl, Validators} from "@angular/forms";
import {AppComponent} from "../../app.component";
import {AuthService} from "../../services/auth.service";
import {User} from "../../models/user";

@Component({
    selector: 'app-giris',
    templateUrl: './giris.component.html',
    styleUrls: ['./giris.component.css']
})

export class GirisComponent {

    constructor(private authService: AuthService, private router: Router, private appComponent: AppComponent) {
    }

    eposta = new FormControl('', [Validators.required, Validators.email]);
    sifre = new FormControl('', [Validators.required]);
    passwordHide = true;

    getEpostaErrorMessage() {
        if (this.eposta.hasError('required')) {
            return 'Eposta girmek zorundasın.';
        }

        return this.eposta.hasError('email') ? 'Geçerli bir eposta değil.' : '';
    }

    getSifreErrorMessage() {

        if (this.sifre.hasError('required')) {
            return 'Şifre girmek zorundasın.';
        }

        return this.sifre.hasError('password') ? 'Geçerli bir şifre değil.' : '';
    }

    public giris(): void {
        this.authService.giris({"eposta": this.eposta.value, "sifre": this.sifre.value})
            .pipe().subscribe({
            next: user => {
                this.appComponent.currentUser = user;
                this.router.navigate(['/anasayfa']);
            },
            error: error => {
                alert("Kullanıcı adı veya şifre yanlış !")
            }
        });

        this.appComponent.isAuthenticated = true;

    }
}