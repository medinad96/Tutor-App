import React, { Component } from 'react';
//import logo from '../assets/logo.svg';
import axios from 'axios'
import '../css/App.css';

class Main extends Component {

  constructor(props) {
  super(props);
  this.state = {students: []};
  this.ping = this.ping.bind(this);
  }

  ping() {
  axios.get("http://profile-tutor4.apps.18.207.166.134.nip.io/students").then(res => {

    console.log(res);
    alert("Received Successful response from server!");
    const students = res.data.map(stu => ({FirstName: stu.firstName, LastName: stu.lastName,Email: stu.email,PhoneNumber: stu.phoneNumber, UserType: stu.userType }));
    this.setState({students});//[0].firstName+" "+res.data[0].lastName});
  }, err => {
    alert("Server rejected response with: " + err);
  });
  }


  render() {

  //const {students} = this.state.ponged;
  return (
    <div className="Main">
      <header className="App-header">
        <h1 className="App-title">Student List from Microservice on Openshift</h1>
      </header>
      <div className="App-intro">
        <div>
          <button onClick={this.ping}>PRINT STUDENTS!</button>
          <div>

          <h2>Student List</h2>
          <div>{
            this.state.students.map(
              (stu,index) =>
                <div key={index} >
                  <ul>{stu.UserType}: {stu.FirstName} {stu.LastName}</ul>
                  <ul>Email: {stu.Email} </ul>
                  <ul>Phone: {stu.PhoneNumber} </ul>
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

export default Main;
