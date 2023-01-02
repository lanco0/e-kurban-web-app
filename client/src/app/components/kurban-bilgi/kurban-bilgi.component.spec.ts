import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KurbanBilgiComponent } from './kurban-bilgi.component';

describe('KurbanBilgiComponent', () => {
    let component: KurbanBilgiComponent;
    let fixture: ComponentFixture<KurbanBilgiComponent>;

    beforeEach(async () => {
        await TestBed.configureTestingModule({
            declarations: [ KurbanBilgiComponent ]
        })
            .compileComponents();

        fixture = TestBed.createComponent(KurbanBilgiComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});