'use strict'

import * as DOM from './dom.js';

// POST function
const post = () => {
  axios.post(`http://localhost:8080/create`, { 
      registration : DOM.inputRegistration.value,
      type : DOM.inputType.value, 
      job : DOM.inputJob.value
      // contactNumber : DOM.inputContactNumber.value
    })
    .then((response) => {
      console.log(response);
      get();
    }).catch((err) => {
      console.log(err);
    });
}

DOM.buttonCreate.onclick = () => post();