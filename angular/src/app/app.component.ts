import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  public date = new Date();
  public x = Math.floor(Math.random()*101);
  public buttonDisabled:boolean=true;
  public val:string = "";

  public f():string {
      return "hello";
    }
    public f2():void{
        this.buttonDisabled = !this.buttonDisabled;
    //   alert("Hello");
  }

  public clear(){
      this.val = "";
  }
}
