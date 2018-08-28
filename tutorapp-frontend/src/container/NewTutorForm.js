import React, { Component } from 'react';
import axios from 'axios';
import '../css/App.css';


    class NewTutor extends Component {
      constructor() {
        super();
        this.state = {
          userType: 'tutor',
          userId: '',
          placeToMeet: '',
          phoneNumber: '',
          lastName: '',
          firstName: '',
          email: '',
          description: '',
          classHelp: '',
        };
      }

      onChange = (e) => {
        // Because we named the inputs to match their corresponding values in state, it's
        // super easy to update the state
        this.setState({ [e.target.name]: e.target.value });
      }

      resetState(){
        this.setState({
          userType: 'tutor',
          userId: '',
          placeToMeet: '',
          phoneNumber: '',
          lastName: '',
          firstName: '',
          email: '',
          description: '',
          classesToHelp: '',
        });

      }

      onSubmit = (e) => {
        e.preventDefault();
        // get our form data out of state

        const { userType, userId, placeToMeet, phoneNumber, lastName, firstName, email, description, classesToHelp } = this.state;
        const sendJson = {classesToHelp, description, email, firstName, lastName, phoneNumber, placeToMeet, userId, userType};

        axios.post('http://profile-tutor4.apps.18.207.166.134.nip.io/tutors/'+userId, sendJson)
          .then((result) => {
            //access the results here....
            console.log(result);
        });

        this.resetState();

      }

      render() {
        const { userType, userId, placeToMeet, phoneNumber, lastName, firstName, email, description, classesToHelp } = this.state;
        return (

          <div className="Main">
            <header className="App-header">
              <h1 className="App-title">New Tutor Form:</h1>
            </header>

            <div className="App-intro">
              <ul className="studentForm-item">
                <form onSubmit={this.onSubmit}>
                  <p>User Id: <input type="text" name="userId" value={userId} onChange={this.onChange} /></p>
                  <p>First Name: <input type="text" name="firstName" value={firstName} onChange={this.onChange} /></p>
                  <p>Last Name: <input type="text" name="lastName" value={lastName} onChange={this.onChange} /></p>
                  <p>Email: <input type="text" name="email" value={email} onChange={this.onChange} /></p>
                  <p>Phone #: <input type="text" name="phoneNumber" value={phoneNumber} onChange={this.onChange} /></p>
                  <p>Classes I need help with: <input type="text" name="classesToHelp" value={classesToHelp} onChange={this.onChange} /></p>
                  <p>Prefer to meet at: <input type="text" name="placeToMeet" value={placeToMeet} onChange={this.onChange} /></p>
                  <p>Description: <input type="text" name="description" value={description} onChange={this.onChange} /></p>
                  <button className="btn btn-success" type="submit">Submit</button>
                </form>
              </ul>
            </div>

          </div>
        );
      }
    }

export default NewTutor;
