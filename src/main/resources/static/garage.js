'use strict'

import * as DOM from './dom.js';

// List item function
const writeItem = item => {
  const child = document.createElement(`li`);
  child.id = item.id;
  child.innerHTML = `<b>ID: ${item.id}</b> &nbsp &nbsp &nbsp Registration: ${item.registration} &nbsp &nbsp &nbsp Type: ${item.type} &nbsp &nbsp &nbsp Job: ${item.job} <br><br>`;
  DOM.listOutput.appendChild(child);
}

const writeItem2 = item => {
  const child = document.createElement(`li`);
  child.id = item.id;
  child.innerHTML = `<b>ID: ${item.id}</b> &nbsp &nbsp &nbsp Registration: ${item.registration} &nbsp &nbsp &nbsp Type: ${item.type} &nbsp &nbsp &nbsp Job: ${item.job} <br><br>`;
  DOM.listOutput2.appendChild(child);
}

// GET ALL function
const get = () => {
  DOM.listOutput.innerHTML = ``;

  axios.get(`http://localhost:8080/getAll`)
    .then((response) => {
      if (!Array.isArray(response.data)) {
        writeItem(response.data);
      } else {
        for (let item of response.data) {
          writeItem(item);
        }
      }
    }).catch((err) => {
      console.log(err);
    });
}

get();

// GET by ID function
const getById = (id) => {
  DOM.listOutput2.innerHTML = ``;

  axios.get(`http://localhost:8080/get/${id}`)
    .then((response) => {
      if (!Array.isArray(response.data)) {
        writeItem2(response.data);
      } else {
        for (let item of response.data) {
          writeItem2(item);
        }
      }
    }).catch((err) => {
      console.log(err);
    });
}
DOM.buttonRead.onclick = () => getById(DOM.inputId.value);

// GET by Registration function
const getByReg = (registration) => {
  DOM.listOutput2.innerHTML = ``;

  axios.get(`http://localhost:8080/getByRegistration/${registration}`)
    .then((response) => {
      if (!Array.isArray(response.data)) {
        writeItem2(response.data);
      } else {
        for (let item of response.data) {
          writeItem2(item);
        }
      }
    }).catch((err) => {
      console.log(err);
    });
}
DOM.buttonReadByReg.onclick = () => getByReg(DOM.inputId.value);

// GET by Type function
const getByType = (type) => {
  DOM.listOutput2.innerHTML = ``;

  axios.get(`http://localhost:8080/getByType/${type}`)
    .then((response) => {
      if (!Array.isArray(response.data)) {
        writeItem2(response.data);
      } else {
        for (let item of response.data) {
          writeItem2(item);
        }
      }
    }).catch((err) => {
      console.log(err);
    });
}
DOM.buttonReadByType.onclick = () => getByType(DOM.inputId.value);

// GET by Job function
const getByJob = (job) => {
  DOM.listOutput2.innerHTML = ``;

  axios.get(`http://localhost:8080/getByJob/${job}`)
    .then((response) => {
      if (!Array.isArray(response.data)) {
        writeItem2(response.data);
      } else {
        for (let item of response.data) {
          writeItem2(item);
        }
      }
    }).catch((err) => {
      console.log(err);
    });
}
DOM.buttonReadByJob.onclick = () => getByJob(DOM.inputId.value);

// DELETE ALL