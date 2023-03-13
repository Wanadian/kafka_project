const template = document.createElement('template');

template.innerHTML = `
    <style>
        @import "./dataContainer.css";
    </style>
    <span class="container">
        <slot class="title" name='title'></slot>
        <slot name='value'></slot>
    </span>
`
export {template}