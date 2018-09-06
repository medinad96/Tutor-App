import React, { Component } from 'react';
//import logo from '../assets/logo.svg';
import axios from 'axios'
//import StarRating from 'react-star-rating';

import '../css/App.css';

class AppointmentList extends Component {

  constructor(props) {
  super(props);
  this.state = {appointments: []};
  this.ping = this.ping.bind(this);
  }

  ping() {
  axios.get("http://appointments-tutor4.apps.18.207.166.134.nip.io/appointments").then(res => {

    console.log(res);
    alert("Received Successful response from server!");
    const appointments = res.data.map(app => ({AppointmentId: app.appointmentId, AppointmentAuthor: app.appointmentAuthor, AppointmentRecipient: app.appointmentRecipient, AppointmentTitle: app.appointmentTitle, AppointmentTime: app.appointmentTime, AppointmentDate: app.appointmentDate, AppointmentDescription: app.appointmentDescription, AppointmentStatus: app.appointmentStatus }));
    this.setState({appointments});
  }, err => {
    alert("Server rejected response with: " + err);
  });
  }



  render() {


  return (
    <div className="Main">
      <header className="App-header">
        <h1 className="App-title">Appointment List from Microservice on Openshift</h1>
      </header>
      <div className="App-intro">
        <div>
          <button className="btn btn-primary"  onClick={this.ping}>PRINT APPOINTMENTS!</button>
          <div>

          <div>
          <ul className="user-list">
          {
            this.state.appointments.map(
              (ap,index) =>
                <ul className="user-item" key={index} >

                  <h4 className="user-headline">{ap.AppointmentTitle.charAt(0).toUpperCase()+ap.AppointmentTitle.slice(1)}</h4>
                  <p>Author: {ap.AppointmentAuthor.charAt(0).toUpperCase()+ap.AppointmentAuthor.slice(1)} </p>
                  <p>Time: {ap.AppointmentTime}  Date: {ap.AppointmentDate}  </p>
                  <p>Status: {ap.AppointmentStatus} </p>
                  <p>Description: {ap.AppointmentDescription} </p>
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

export default AppointmentList;
