import {template} from "./dataContainer.html";
class dataContainer extends HTMLElement {
    constructor() {
        super();
        const shadow = this.attachShadow({ 'mode': 'open' });
        shadow.append(template.content.cloneNode(true));
    }
}

customElements.define("data-container", dataContainer)