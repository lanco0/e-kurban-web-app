import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HissedarlarComponent } from './hissedarlar.component';

describe('HissedarlarComponent', () => {
  let component: HissedarlarComponent;
  let fixture: ComponentFixture<HissedarlarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HissedarlarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HissedarlarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
