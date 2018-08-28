import React, { Component } from 'react';
import Main from './container/Main';
import Tutor from './container/Tutor';
import StudentProfile from './container/StudentProfile';
import TutorProfile from './container/TutorProfile';
import NewStudent from './container/NewStudentForm';
import NewTutor from './container/NewTutorForm';
import './css/App.css';

class App extends Component {

  render() {
    return (
      <div className="App">
        <Main />
        <div><Tutor /></div>
        <div><StudentProfile/></div>
        <div><TutorProfile/></div>
        <div><NewStudent/></div>
        <div><NewTutor/></div>
      </div>
    );
  }
}

export default App;
