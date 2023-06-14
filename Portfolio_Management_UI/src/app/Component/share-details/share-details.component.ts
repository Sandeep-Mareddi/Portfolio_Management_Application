import { Component, OnInit } from '@angular/core';
import {ShareDetailsService} from '../../service/share-details.service';
import { ShareDetails} from '../../ModelClass/share-details';

@Component({
  selector: 'app-share-details',
  templateUrl: './share-details.component.html',
  styleUrls: ['./share-details.component.css']
})
export class ShareDetailsComponent implements OnInit {

  Price!: ShareDetails[];
  route: any;
  constructor(private shareDetails:ShareDetailsService) { }

  ngOnInit(): void {
    this.shareDetails.getShareDetailsList().subscribe(data =>{
      this.Price=data;
    });
  }

}
