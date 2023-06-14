import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Asset } from '../../ModelClass/sell-assets';
import { SellAssetsService } from '../../service/sell-assets.service';

@Component({
  selector: 'app-sell-assets',
  templateUrl: './sell-assets.component.html',
  styleUrls: ['./sell-assets.component.css']
})
export class SellAssetsComponent implements OnInit {

  sellAssets: Asset[]=[];
  constructor(private sellAssetsService:SellAssetsService,private _router: Router ){ }

  max:any;

  stocks = '';
  inputVal = '';
  valuesObj:any = [];
  arr:any = [];
  stockIdList:any={};
  mfAssetList:any={};

  ngOnInit() {this.sellAssetsService.getSellAssetsList().subscribe((response) => {
    //  console.log(response);
      this.sellAssets=response;
      for(let i of this.sellAssets)
      {
        if(i.assetid)
        this.arr.push(i.assetid)
      }

   }, (err) => {
     console.log('error', err);
   });
  }

  addValue() {
    this.valuesObj.push({
     name: this.stocks,
      value: this.inputVal
    });

    this.arr = this.arr.filter((data:any) => data !== this.stocks);

    this.stocks = '';
    // console.log('Values Obj ', this.valuesObj);
  }

  removeValue(name:string) {
    this.valuesObj = this.valuesObj.filter((data:any) => data.name !== name);
    this.arr.push(name);

    console.log('Values Obj ', this.valuesObj);
  }

  calculate()
  {
      for(let i of this.valuesObj)
      {
        for(let j of this.sellAssets)
        {
          // console.log(i)
          // console.log(j)
          if (i.name===j.assetid)
          {
            if(j.type==="Share")
            this.stockIdList[i.name]=i.value
            else{
              this.mfAssetList[i.name]=i.value
            }
          }

        }
      }
      console.log(this.stockIdList,this.mfAssetList)
      this.sellAssetsService.sellAssets(this.stockIdList,this.mfAssetList).subscribe((response) => {

         console.log(response);
         this.sellAssetsService.setNetworth(response);

         this.redirectToNext();
       }, (err) => {
         console.log('error', err);

       });
  }
  redirectToNext() {
    this._router.navigate(['/calculateNetworth'])
  }
  getMax()
  {
    // console.log("this.getMax()")
        for(let i of this.sellAssets)
        {
            if(i.assetid===this.stocks)
            {
              this.max=i.units
            }
        }
        console.log(this.max)
  }
}
