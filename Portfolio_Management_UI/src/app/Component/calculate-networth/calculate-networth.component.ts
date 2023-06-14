import { Component, OnChanges, OnInit } from '@angular/core';
import { portfolio } from '../../ModelClass/calculate-networth';
import { CalculateNetworthService } from '../../service/calculate-networth.service';
import { SellAssetsService } from '../../service/sell-assets.service';

@Component({
  selector: 'app-calculate-networth',
  templateUrl: './calculate-networth.component.html',
  styleUrls: ['./calculate-networth.component.css']
})
export class CalculateNetworthComponent implements OnInit {

  public networth:any='';
  constructor(
    private calculateNetworth:CalculateNetworthService
    ) { }

  ngOnInit(): void {

        this.calculateNetworth.getNetworth().subscribe(data =>
          this.networth=data)
          console.log(this.networth)
       }
  }

