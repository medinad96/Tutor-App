import React, { Component } from 'react';
import axios from 'axios';
import '../css/App.css';


    class NewStudent extends Component {
      constructor() {
        super();
        this.state = {
          userType: 'student',
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
          userType: 'student',
          userId: '',
          placeToMeet: '',
          phoneNumber: '',
          lastName: '',
          firstName: '',
          email: '',
          description: '',
          classHelp: '',
        });

      }

      onSubmit = (e) => {
        e.preventDefault();
        // get our form data out of state

        const { userType, userId, placeToMeet, phoneNumber, lastName, firstName, email, description, classHelp } = this.state;
        const sendJson = {classHelp, description, email, firstName, lastName, phoneNumber, placeToMeet, userId, userType};

        axios.post('http://profile-tutor4.apps.18.207.166.134.nip.io/students/'+userId, sendJson)
          .then((result) => {
            //access the results here....
            console.log(result);
        });

        this.resetState();

      }

      render() {
        const { userType, userId, placeToMeet, phoneNumber, lastName, firstName, email, description, classHelp } = this.state;
        return (

          <div className="Main">
            <header className="App-header">
              <h1 className="App-title">New Student Form:</h1>
            </header>

            <div className="App-intro">
            <ul className="studentForm-item">
            <form onSubmit={this.onSubmit}>
              <p>User Id: <input type="text" name="userId" value={userId} onChange={this.onChange} /></p>
              <p>First Name: <input type="text" name="firstName" value={firstName} onChange={this.onChange} /></p>
              <p>Last Name: <input type="text" name="lastName" value={lastName} onChange={this.onChange} /></p>
              <p>Email: <input type="text" name="email" value={email} onChange={this.onChange} /></p>
              <p>Phone #: <input type="text" name="phoneNumber" value={phoneNumber} onChange={this.onChange} /></p>
              <p>Classes I need help with: <input type="text" name="classHelp" value={classHelp} onChange={this.onChange} /></p>
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

export default NewStudent;
