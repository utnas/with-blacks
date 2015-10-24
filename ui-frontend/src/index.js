import {ComponentMetadata as Component, ViewMetadata as View, bootstrap} from 'angular2/angular2';
import {UiFrontend} from 'ui-frontend';

@Component({
  selector: 'main'
})

@View({
  directives: [UiFrontend],
  template: `
    <ui-frontend></ui-frontend>
  `
})

class Main {

}

bootstrap(Main);
