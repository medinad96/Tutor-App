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
//import {Router, IndexRoute, browserHistory} from 'react-router';
import {BrowserRouter, Route} from 'react-router-dom';


class App extends Component {

  // <div className="App">
  //   <Main />
  //   <div><Tutor /></div>
  //   <div><StudentProfile/></div>
  //   <div><TutorProfile/></div>
  //   <div><NewStudent/></div>
  //   <div><NewTutor/></div>
  //   <div><ReviewList/></div>
  //   <div><ReviewForm/></div>
  //   <div><AppointmentList/></div>
  //   <div><AppointmentForm/></div>
  //   <div><UpdateAppointment/></div>
  //   <div><StudentSearch/></div>
  //   <div><TutorSearch/></div>
  // </div>

  render() {
    return (
      <BrowserRouter>
            <div className="App">
            <Route path="/" component={Main} />
            <Route path="/tutor" component={Tutor}/>
            <Route path="/student-profile" component={StudentProfile}/>
            <Route path="/tutor-profile" component={TutorProfile}/>
            <Route path="/new-student" component={NewStudent}/>
            <Route path="/new-tutor" component={NewTutor}/>
            <Route path="/review-list" component={ReviewList}/>
            <Route path="/review-form" component={ReviewForm}/>
            <Route path="/review-list" component={ReviewList}/>
            <Route path="/appointment-list" component={AppointmentList}/>
            <Route path="/update-appointment" component={UpdateAppointment}/>
            <Route path="/student-search" component={StudentSearch}/>
            <Route path="/tutor-search" component={TutorSearch}/>
            </div>
      </BrowserRouter>
      
    );
  }
}

export default App;
