import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KurbanEkleComponent } from './kurban-ekle.component';

describe('KurbanEkleComponent', () => {
  let component: KurbanEkleComponent;
  let fixture: ComponentFixture<KurbanEkleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KurbanEkleComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(KurbanEkleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
