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
          <button onClick={this.pingt}>PRINT TUTORS!</button>
          <div>

          <h2>Tutor List</h2>
          <div>{
            this.state.tutors.map(
              (tu,index) =>
                <div key={index} >
                  <ul>{tu.UserType}: {tu.FirstName} {tu.LastName}</ul>
                  <ul>Email: {tu.Email} </ul>
                  <ul>Phone: {tu.PhoneNumber} </ul>
                </div>
            )}
            </div>
          </div>
         </div>
      </div>
    </div>
  );
  }

}

export default Tutor;
