import React, { Component } from 'react';
//import logo from '../assets/logo.svg';
import axios from 'axios'
import '../css/App.css';

class StudentProfile extends Component {

  constructor(props) {
  super(props);
  this.state = {student: []};
  this.ping = this.ping.bind(this);
  }

  ping() {
  axios.get("http://profile-tutor4.apps.18.207.166.134.nip.io/students/1").then(res => {

    console.log(res);
    //alert("Received Successful response from server!");
    const stu = res.data;
    const student = [
    {FirstName: stu.firstName, LastName: stu.lastName,Email: stu.email,PhoneNumber: stu.phoneNumber, UserType: stu.userType , ClassHelp: stu.classHelp, Description: stu.description, PlaceToMeet: stu.placeToMeet }];
    this.setState({student});//[0].firstName+" "+res.data[0].lastName});
  }, err => {
    alert("Server rejected response with: " + err);
  });
  }

  componentDidMount(){
    this.ping();
  }


  render() {

  //const {students} = this.state.ponged;
  return (
    <div className="Main">
      <header className="App-header">
        <h1 className="App-title">Student Profile from Microservice on Openshift</h1>
      </header>
      <div className="App-intro">



          <div>
          <ul className="user-list">
          {
            this.state.student.map(
              (stu,index) =>
                <ul className="user-item2" key={index} >

                  <h4 className="user-headline">{stu.UserType.charAt(0).toUpperCase()+stu.UserType.slice(1)}: {stu.FirstName} {stu.LastName}</h4>
                  <p>Email: {stu.Email} </p>
                  <p>Phone: {stu.PhoneNumber} </p>
                  <p>Classes: {stu.ClassHelp}</p>
                  <p>I prefer to meet at: {stu.PlaceToMeet}</p>
                  <p>Description: </p>
                  <p>{stu.Description}</p>
                </ul>
            )}
            </ul>
            </div>
          </div>


    </div>
  );
  }

}

export default StudentProfile;
