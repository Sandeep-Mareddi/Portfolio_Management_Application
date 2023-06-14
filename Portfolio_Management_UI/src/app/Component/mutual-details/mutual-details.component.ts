import { Component, OnInit } from '@angular/core';
import { MutualFundService } from 'src/app/service/mutualfundservice';
import { MutualFund } from 'src/app/ModelClass/mutualfund';

@Component({
  selector: 'app-mutual-details',
  templateUrl: './mutual-details.component.html',
  styleUrls: ['./mutual-details.component.css']
})
export class MutualDetailsComponent implements OnInit {

  Price!: MutualFund[];
  constructor(private MutualFund: MutualFundService) { }

  ngOnInit(): void {
    this.getMutualFund();
  }
  private getMutualFund() {
    this.MutualFund.getMutualDetailsList().subscribe(data => {
      this.Price = data;
    });
  }

}
