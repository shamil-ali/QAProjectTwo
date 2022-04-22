'use strict'

import * as DOM from './dom.js';

// PUT by ID function
const updateById = (id) => {
  axios.put(`http://localhost:8080/replace/${id}`, {
    id: DOM.inputId2.value,
    registration: DOM.inputRegistration2.value,
    type: DOM.inputType2.value,
    job: DOM.inputJob2.value,
    // contactNumber: DOM.inputContactNumber2.value
  }).then((response) => {
    console.log(response);

  }).catch((err) => {
    console.log(err);
  });
}
DOM.buttonUpdate.onclick = () => updateById(DOM.inputId2.value);