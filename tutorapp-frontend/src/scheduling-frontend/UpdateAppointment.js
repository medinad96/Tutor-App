import React, { Component } from 'react';
//import logo from '../assets/logo.svg';
import axios from 'axios'
import '../css/App.css';

class UpdateAppointment extends Component {

  constructor(props) {
  super(props);
  this.state = {
    appointmentId: '',
    appointmentAuthor: '',
    appointmentRecipient: '',
    appointmentTitle: '',
    appointmentTime: '',
    appointmentDate: '',
    appointmentDescription: '',
    appointmentStatus: '',
  };
  this.ping = this.ping.bind(this);
  this.deleteAppointment = this.deleteAppointment.bind(this);
  //this.updateStudent = this.updateStudent.bind(this);
  //this.currentState = this.currentState.bind(this);
  }

  ping() {

  axios.get("http://appointments-tutor4.apps.18.207.166.134.nip.io/appointments/2").then(res => {

    console.log(res);
    //alert("Received Successful response from server!");
    const app = res.data;
    const appointment =
    {appointmentId: app.appointmentId,  appointmentAuthor: app.appointmentAuthor, appointmentRecipient: app.appointmentRecipient, appointmentTitle: app.appointmentTitle, appointmentTime: app.appointmentTime, appointmentDate: app.appointmentDate, appointmentDescription: app.appointmentDescription, appointmentStatus: app.appointmentStatus };
    this.setState(appointment);//[0].firstName+" "+res.data[0].lastName});
  }, err => {
    alert("Server rejected response with: " + err);
  });

  }

  deleteAppointment(){
    const uid = this.state.appointmentId;

    console.log("AID "+uid);
    //console.log("USER ID: "+uid);
    axios.delete("http://appointments-tutor4.apps.18.207.166.134.nip.io/appointments/"+uid)
      .then(res => {

        console.log(res);
        console.log(res.data);
    })
    //this.resetState();

  }


  resetState(){
    this.setState({
      appointmentId: '',
      appointmentAuthor: '',
      appointmentRecipient: '',
      appointmentTitle: '',
      appointmentTime: '',
      appointmentDate: '',
      appointmentDescription: '',
      appointmentStatus: '',
    });

  }

  onChange = (e) => {
    // Because we named the inputs to match their corresponding values in state, it's
    // super easy to update the state
    this.setState({ [e.target.name]: e.target.value });
  }


  onSubmit = (e) => {
    e.preventDefault();
    // get our form data out of state

    const { appointmentId, appointmentAuthor, appointmentRecipient, appointmentTitle, appointmentTime, appointmentDate, appointmentDescription, appointmentStatus } = this.state;
    const sendJson = { appointmentId, appointmentAuthor, appointmentRecipient, appointmentTitle, appointmentTime, appointmentDate, appointmentDescription, appointmentStatus };

    axios.post('http://appointments-tutor4.apps.18.207.166.134.nip.io/appointments/'+appointmentId, sendJson)
      .then((result) => {
        //access the results here....
        console.log(result);
    });

    this.resetState();

  }


  componentDidMount(){
    this.ping();

  }


  render() {

  const { appointmentId, appointmentAuthor, appointmentRecipient, appointmentTitle, appointmentTime, appointmentDate, appointmentDescription, appointmentStatus } = this.state;


  const app = this.state;

  return (
    <div className="Main">
      <header className="App-header">
        <h1 className="App-title">Update Appointment from Microservice on Openshift</h1>
      </header>
      <div className="App-intro">

          <div>
          <ul className="user-list">

              <ul className="user-item"  >

                <h4 className="user-headline">{app.appointmentTitle.charAt(0).toUpperCase()+app.appointmentTitle.slice(1)}</h4>
                <p>Author: {app.appointmentAuthor.charAt(0).toUpperCase()+app.appointmentAuthor.slice(1)} </p>
                <p>Time: {app.appointmentTime}  Date: {app.appointmentDate}  </p>
                <p>Status: {app.appointmentStatus} </p>
                <p>Description: {app.appointmentDescription} </p>

              </ul>


              <ul className="studentForm-item">
                  <form onSubmit={this.onSubmit}>
                    <p>Appointment Id: <input type="text" name="appointmentId" value={appointmentId} onChange={this.onChange} /></p>
                    <p>Title: <input type="text" name="appointmentTitle" value={appointmentTitle} onChange={this.onChange} /></p>
                    <p>Author: <input type="text" name="appointmentAuthor" value={appointmentAuthor} onChange={this.onChange} /></p>
                    <p>Recipient: <input type="text" name="appointmentRecipient" value={appointmentRecipient} onChange={this.onChange} /></p>
                    <p>Time: <input type="text" name="appointmentTime" value={appointmentTime} onChange={this.onChange} />   Date: <input type="text" name="appointmentDate" value={appointmentDate} onChange={this.onChange} />  </p>
                    <p>Status: <input type="text" name="appointmentStatus" value={appointmentStatus} onChange={this.onChange} /></p>
                    <p>Description: <input type="text" name="appointmentDescription" value={appointmentDescription} onChange={this.onChange} /></p>
                    <button className="btn btn-success" type="submit">Submit</button>
                  </form>
              </ul>


            <button className="btn btn-danger" onClick={this.deleteAppointment}>DELETE!</button>

            </ul>

            </div>
          </div>


    </div>
  );
  }

}

export default UpdateAppointment;
