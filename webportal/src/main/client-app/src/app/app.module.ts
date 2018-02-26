import { NgModule } from '@angular/core';
import { ConsolidatedModule } from './consolidated/consolidated.module';

import { LoginComponent } from './login/login.component';
import { AppComponent } from './app/app.component';

@NgModule({
  declarations: [
    LoginComponent,
    AppComponent
  ],
  imports: [
    ConsolidatedModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
