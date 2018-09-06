import React, { Component } from 'react';
//import logo from '../assets/logo.svg';
import axios from 'axios'
import '../css/App.css';

class StudentProfile extends Component {

  constructor(props) {
  super(props);
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
  this.ping = this.ping.bind(this);
  this.deleteStudent = this.deleteStudent.bind(this);
  //this.updateStudent = this.updateStudent.bind(this);
  //this.currentState = this.currentState.bind(this);
  }

  ping() {

  axios.get("http://profile-tutor4.apps.18.207.166.134.nip.io/students/1").then(res => {

    console.log(res);
    //alert("Received Successful response from server!");
    const stu = res.data;
    const student =
    {userType: stu.userType,  userId: stu.userId, placeToMeet: stu.placeToMeet, phoneNumber: stu.phoneNumber, lastName: stu.lastName, firstName: stu.firstName, email: stu.email, description: stu.description, classHelp: stu.classHelp };
    this.setState(student);//[0].firstName+" "+res.data[0].lastName});
  }, err => {
    alert("Server rejected response with: " + err);
  });



  }

  deleteStudent(){
    const uid = this.state.userId;

    console.log("UID "+uid);
    //console.log("USER ID: "+uid);
    axios.delete("http://profile-tutor4.apps.18.207.166.134.nip.io/students/"+uid)
      .then(res => {

        console.log(res);
        console.log(res.data);
    })
    //this.resetState();

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

  onChange = (e) => {
    // Because we named the inputs to match their corresponding values in state, it's
    // super easy to update the state
    this.setState({ [e.target.name]: e.target.value });
  }


  onSubmit = (e) => {
    e.preventDefault();
    // get form data out of state

    const { userType, userId, placeToMeet, phoneNumber, lastName, firstName, email, description, classHelp } = this.state;
    const sendJson = {classHelp, description, email, firstName, lastName, phoneNumber, placeToMeet, userId, userType};

    axios.post('http://profile-tutor4.apps.18.207.166.134.nip.io/students/'+userId, sendJson)
      .then((result) => {
        //access the results here....
        console.log(result);
    });

    this.ping();

  }


  componentDidMount(){
    this.ping();

  }


  render() {

  const {classHelp, description, email, firstName, lastName, phoneNumber, placeToMeet, userId, userType} = this.state;


  const stu = this.state;

  return (
    <div className="Main">
      <header className="App-header">
        <h1 className="App-title">Student Profile from Microservice on Openshift</h1>
      </header>
      <div className="App-intro">

          <div>
          <ul className="user-list">

                <ul className="user-item2"  >

                  <h4 className="user-headline">{stu.userType.charAt(0).toUpperCase()+stu.userType.slice(1)}: {stu.firstName} {stu.lastName}</h4>
                  <p>Email: {stu.email} </p>
                  <p>Phone: {stu.phoneNumber} </p>
                  <p>Classes: {stu.classHelp}</p>
                  <p>I prefer to meet at: {stu.placeToMeet}</p>
                  <p>Description: </p>
                  <p>{stu.description}</p>
                </ul>

            </ul>

            <h4 className="user-headline">Update Student Form: </h4>
            <ul className="studentForm-item" >

              <form onSubmit={this.onSubmit}>
                <p>User Id: <input type="text" name="userId" value={userId} onChange={this.onChange} /></p>
                <p>First Name: <input type="text" name="firstName" value={firstName} onChange={this.onChange} /></p>
                <p>Last Name: <input type="text" name="lastName" value={lastName} onChange={this.onChange} /></p>
                <p>Email: <input type="text" name="email" value={email} onChange={this.onChange} /></p>
                <p>Phone #: <input type="text" name="phoneNumber" value={phoneNumber} onChange={this.onChange} /></p>
                <p>Classes I need help with: <input type="text" name="classHelp" value={classHelp} onChange={this.onChange} /></p>
                <p>Prefer to meet at: <input type="text" name="placeToMeet" value={placeToMeet} onChange={this.onChange} /></p>
                <p>Description: <input type="text" name="description" value={description} onChange={this.onChange} /></p>
                <button className="btn btn-success" type="submit">UPDATE!</button>
              </form>
            </ul>

            <button className="btn btn-danger" onClick={this.deleteStudent}>DELETE!</button>

            </div>
          </div>


    </div>
  );
  }

}

export default StudentProfile;
