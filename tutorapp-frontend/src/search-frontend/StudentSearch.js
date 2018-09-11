import React, { Component } from 'react'
import axios from 'axios'
import Suggestions from './Suggestions'
import '../css/App.css';


const API_URL = 'http://profile-tutor4.apps.18.207.166.134.nip.io/student-search'

class StudentSearch extends Component {

  constructor(props) {
  super(props);

  this.state = {
    query: '',
    results: []
  };

  this.getInfo = this.getInfo.bind(this);
  this.handleInputChange = this.handleInputChange.bind(this);


  }

  //`${API_URL}?api_key=${API_KEY}&prefix=${this.state.query}&limit=7`)

  getInfo = () => {

    let qry = this.state.query;

    axios.get( API_URL+"?q="+qry )
      .then( res  => {

        var data = res.data;

        var results = {results: data};

        this.setState(results)
      })
  }

  handleInputChange = () => {
    this.setState({
      query: this.search.value
    }, () => {
      if (this.state.query && this.state.query.length > 1) {
        if (this.state.query.length % 2 === 0) {
          this.getInfo()
        }
      } else if (!this.state.query) {
      }
    })
  }

  render() {
    return (

      <div className="Main">
        <header className="App-header">
          <h1 className="App-title">Student Profile from Microservice on Openshift</h1>
        </header>
        <div className="App-intro">

            <div>
      <ul className="studentForm-item">
      <form>
        <input
          placeholder="Search for students..."
          ref={input => this.search = input}
          onChange={this.handleInputChange}
        />
        <Suggestions results={this.state.results} />
      </form>
      </ul>



      </div>
      </div>
      </div>

    )
  }
}

export default StudentSearch
