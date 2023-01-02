import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KurbanAraComponent } from './kurban-ara.component';

describe('KurbanAraComponent', () => {
    let component: KurbanAraComponent;
    let fixture: ComponentFixture<KurbanAraComponent>;

    beforeEach(async () => {
        await TestBed.configureTestingModule({
            declarations: [ KurbanAraComponent ]
        })
            .compileComponents();

        fixture = TestBed.createComponent(KurbanAraComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});