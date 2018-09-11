import React from 'react'
import '../css/App.css';

const Suggestions = (props) => {
  const options = props.results.map(r => (

    <ul className="user-item" key={r.userId} >

      <h4 className="user-headline">{r.userType.charAt(0).toUpperCase()+r.userType.slice(1)}: {r.firstName} {r.lastName}</h4>
      <p>Email: {r.email} </p>
      <p>Phone: {r.phoneNumber} </p>
    </ul>

  ))
  return <ul>{options}</ul>
}

export default Suggestions
