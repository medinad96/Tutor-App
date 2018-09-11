import React, { Component } from 'react';
import Main from './container/Main';
import Tutor from './container/Tutor';
import StudentProfile from './container/StudentProfile';
import TutorProfile from './container/TutorProfile';
import NewStudent from './container/NewStudentForm';
import NewTutor from './container/NewTutorForm';
import ReviewList from './review-frontend/ReviewList';
import ReviewForm from './review-frontend/ReviewForm';
import AppointmentList from './scheduling-frontend/AppointmentList';
import AppointmentForm from './scheduling-frontend/AppointmentForm';
import UpdateAppointment from './scheduling-frontend/UpdateAppointment';
import StudentSearch from './search-frontend/StudentSearch';
import TutorSearch from './search-frontend/TutorSearch';

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
        <div><ReviewList/></div>
        <div><ReviewForm/></div>
        <div><AppointmentList/></div>
        <div><AppointmentForm/></div>
        <div><UpdateAppointment/></div>
        <div><StudentSearch/></div>
        <div><TutorSearch/></div>
      </div>
    );
  }
}

export default App;
