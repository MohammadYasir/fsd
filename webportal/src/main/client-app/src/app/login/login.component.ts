import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-form',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form;

  constructor() { }

  ngOnInit() {
    this.form = new FormGroup({
      title : new FormControl(),
      description : new FormControl(),
      status : new FormControl('PENDING')
    });
  }

  add(task){
    console.log("Done")
  }

}
