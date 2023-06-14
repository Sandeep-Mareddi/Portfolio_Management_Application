import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CalculateNetworthComponent } from './calculate-networth.component';

describe('CalculateNetworthComponent', () => {
  let component: CalculateNetworthComponent;
  let fixture: ComponentFixture<CalculateNetworthComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CalculateNetworthComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CalculateNetworthComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
