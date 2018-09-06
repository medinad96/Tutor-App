import React, { Component } from 'react';
//import logo from '../assets/logo.svg';
import axios from 'axios'
import StarRating from 'react-star-rating';

import '../css/App.css';

class ReviewList extends Component {

  constructor(props) {
  super(props);
  this.state = {reviews: []};
  this.ping = this.ping.bind(this);
  }

  ping() {
  axios.get("http://review-tutor4.apps.18.207.166.134.nip.io/reviews").then(res => {

    console.log(res);
    alert("Received Successful response from server!");
    const reviews = res.data.map(rev => ({ReviewId: rev.reviewId, ReviewAuthor: rev.reviewAuthor, ReviewTitle: rev.reviewTitle, ReviewDescription: rev.reviewDescription, ReviewRating: rev.reviewRating}));
    this.setState({reviews});//[0].firstName+" "+res.data[0].lastName});
  }, err => {
    alert("Server rejected response with: " + err);
  });
  }



  render() {


  return (
    <div className="Main">
      <header className="App-header">
        <h1 className="App-title">Review List from Microservice on Openshift</h1>
      </header>
      <div className="App-intro">
        <div>
          <button className="btn btn-primary"  onClick={this.ping}>PRINT REVIEWS!</button>
          <div>


          <div>
          <ul className="user-list">
          {
            this.state.reviews.map(
              (rev,index) =>
                <ul className="user-item" key={index} >

                  <h4 className="user-headline">{rev.ReviewTitle.charAt(0).toUpperCase()+rev.ReviewTitle.slice(1)}</h4>
                  <p>Author: {rev.ReviewAuthor.charAt(0).toUpperCase()+rev.ReviewAuthor.slice(1)} </p>
                  <p>Rating: <StarRating rating={rev.ReviewRating} totalStars={10} /> </p>
                  <p>Description: {rev.ReviewDescription} </p>
                </ul>
            )}
            </ul>
            </div>
          </div>
         </div>
      </div>
    </div>
  );
  }

}

export default ReviewList;
