import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MutualDetailsComponent } from './mutual-details.component';

describe('MutualDetailsComponent', () => {
  let component: MutualDetailsComponent;
  let fixture: ComponentFixture<MutualDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MutualDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MutualDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
