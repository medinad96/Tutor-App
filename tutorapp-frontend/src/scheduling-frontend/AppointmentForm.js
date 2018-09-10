import React, { Component } from 'react';
import axios from 'axios';
import '../css/App.css';


    class AppointmentForm extends Component {
      constructor() {
        super();
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
      }

      onChange = (e) => {
        this.setState({ [e.target.name]: e.target.value });
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


      render() {

        const { appointmentId, appointmentAuthor, appointmentRecipient, appointmentTitle, appointmentTime, appointmentDate, appointmentDescription, appointmentStatus } = this.state;

        return (

          <div className="Main">
            <header className="App-header">
              <h1 className="App-title">New Appointment Form:</h1>
            </header>

            <div className="App-intro">
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
            </div>

          </div>
        );
      }
    }

export default AppointmentForm;
