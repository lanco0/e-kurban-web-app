import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HissedarEkleComponent } from './hissedar-ekle.component';

describe('HissedarEkleComponent', () => {
  let component: HissedarEkleComponent;
  let fixture: ComponentFixture<HissedarEkleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HissedarEkleComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HissedarEkleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
