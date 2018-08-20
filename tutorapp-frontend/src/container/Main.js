import React, { Component } from 'react';
import logo from '../assets/logo.svg';
import axios from 'axios'
import '../css/App.css';

class Main extends Component {

  constructor(props) {
  super(props);
  this.state = {ponged: 'Not Ponged'}
  this.ping = this.ping.bind(this);
  }

  ping() {
  axios.get("http://profile-tutor4.apps.18.207.166.134.nip.io/students").then(res => {

    console.log(res);
    alert("Received Successful response from server!");
    this.setState({ponged: res.data[0].firstName+" "+res.data[0].lastName});
  }, err => {
    alert("Server rejected response with: " + err);
  });
  }


  render() {
  return (
    <div className="Main">
      <header className="App-header">
        <h1 className="App-title">Ping</h1>
      </header>
      <p className="App-intro">
        <div>
          <button onClick={this.ping}>Ping!</button>
          <div>Ponged: {this.state.ponged}</div>
        </div>
      </p>
    </div>
  );
  }

}

export default Main;
