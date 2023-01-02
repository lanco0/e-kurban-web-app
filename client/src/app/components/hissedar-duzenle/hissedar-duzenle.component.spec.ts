import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HissedarDuzenleComponent } from './hissedar-duzenle.component';

describe('HissedarDuzenleComponent', () => {
  let component: HissedarDuzenleComponent;
  let fixture: ComponentFixture<HissedarDuzenleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HissedarDuzenleComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HissedarDuzenleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
