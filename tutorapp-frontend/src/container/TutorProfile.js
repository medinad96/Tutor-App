import React, { Component } from 'react';
//import logo from '../assets/logo.svg';
import axios from 'axios'
import '../css/App.css';

class TutorProfile extends Component {

  constructor(props) {
  super(props);
  this.state = {tutor: []};
  this.ping = this.ping.bind(this);
  this.deleteTutor = this.deleteTutor.bind(this);
  }

  ping() {
  axios.get("http://profile-tutor4.apps.18.207.166.134.nip.io/tutors/2").then(res => {

    console.log(res);
    //alert("Received Successful response from server!");
    const tu = res.data;
    const tutor = [
    {TutorId: tu.userId, FirstName: tu.firstName, LastName: tu.lastName,Email: tu.email,PhoneNumber: tu.phoneNumber, UserType: tu.userType , ClassesToHelp: tu.classesToHelp, Description: tu.description, PlaceToMeet: tu.placeToMeet }];
    this.setState({tutor});//[0].firstName+" "+res.data[0].lastName});
  }, err => {
    alert("Server rejected response with: " + err);
  });
  }

  componentDidMount(){
    this.ping();
  }

  deleteTutor(){
    const uid = this.state.tutor[0].TutorId;
    //console.log("USER ID: "+uid);
    axios.delete("http://profile-tutor4.apps.18.207.166.134.nip.io/tutors/"+uid)
      .then(res => {

        console.log(res);
        console.log(res.data);
    })
  }


  render() {

  //const {students} = this.state.ponged;
  return (
    <div className="Main">
      <header className="App-header">
        <h1 className="App-title">Tutor Profile from Microservice on Openshift</h1>
      </header>
      <div className="App-intro">

          <div>
          <ul className="user-list">
          {
            this.state.tutor.map(
              (tu,index) =>
                <ul className="user-item2" key={index} >

                  <h4 className="user-headline">{tu.UserType.charAt(0).toUpperCase()+tu.UserType.slice(1)}: {tu.FirstName} {tu.LastName}</h4>
                  <p>Email: {tu.Email} </p>
                  <p>Phone: {tu.PhoneNumber} </p>
                  <p>Classes: {tu.ClassesToHelp}</p>
                  <p>I prefer to meet at: {tu.PlaceToMeet}</p>
                  <p>Description: </p>
                  <p>{tu.Description}</p>
                </ul>
            )}
            </ul>
            <button className="btn btn-danger" onClick={this.deleteTutor}>DELETE!</button>

            </div>
          </div>

    </div>
  );
  }

}

export default TutorProfile;
