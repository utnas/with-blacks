import {ComponentMetadata as Component, ViewMetadata as View} from 'angular2/angular2';

@Component({
  selector: 'ui-frontend'
})

@View({
  templateUrl: 'ui-frontend.html'
})

export class UiFrontend {

  constructor() {
    console.info('UiFrontend Component Mounted Successfully');
  }

}