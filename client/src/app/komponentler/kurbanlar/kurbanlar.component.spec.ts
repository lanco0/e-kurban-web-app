import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KurbanlarComponent } from './kurbanlar.component';

describe('KurbanlarComponent', () => {
    let component: KurbanlarComponent;
    let fixture: ComponentFixture<KurbanlarComponent>;

    beforeEach(async () => {
        await TestBed.configureTestingModule({
            declarations: [ KurbanlarComponent ]
        })
            .compileComponents();

        fixture = TestBed.createComponent(KurbanlarComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});