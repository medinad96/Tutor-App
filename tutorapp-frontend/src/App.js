import React, { Component } from 'react';
import Main from './container/Main';
import Tutor from './container/Tutor';
import './css/App.css';

class App extends Component {

  render() {
    return (
      <div className="App">
        <Main />
        <div><Tutor /></div>
      </div>
    );
  }
}

export default App;
