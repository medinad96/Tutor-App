import React, { Component } from 'react';
//import logo from '../assets/logo.svg';
import axios from 'axios'
import '../css/App.css';

class Tutor extends Component {

  constructor(props) {
  super(props);
  this.state = {tutors: []};
  this.pingt = this.pingt.bind(this);
  }

  pingt() {
  axios.get("http://profile-tutor4.apps.18.207.166.134.nip.io/tutors").then(res => {

    console.log(res);
    alert("Received Successful response from server!");
    const tutors = res.data.map(tu => ({FirstName: tu.firstName, LastName: tu.lastName,Email: tu.email,PhoneNumber: tu.phoneNumber, UserType: tu.userType }));
    this.setState({tutors});//[0].firstName+" "+res.data[0].lastName});
  }, err => {
    alert("Server rejected response with: " + err);
  });
  }


  render() {

  //const {students} = this.state.ponged;
  return (
    <div className="Tutor">
      <header className="App-header">
        <h1 className="App-title">Tutor List from Microservice on Openshift</h1>
      </header>
      <div className="App-intro">
        <div>
          <button className="btn btn-primary" onClick={this.pingt}>PRINT TUTORS!</button>
        <div>


          <div>
          <ul className="user-list">

          {
            this.state.tutors.map(
              (tu,index) =>
                <ul className="user-item" key={index} >
                  <h4 className="user-headline">{tu.UserType.charAt(0).toUpperCase()+tu.UserType.slice(1)}: {tu.FirstName} {tu.LastName}</h4>
                  <p>Email: {tu.Email} </p>
                  <p>Phone: {tu.PhoneNumber} </p>
                </ul>
            )}

            </ul>
            </div>
          </div>
         </div>
      </div>
    </div>
  );
  }

}

export default Tutor;
