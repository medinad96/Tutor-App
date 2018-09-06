import React, { Component } from 'react';
import axios from 'axios';
import '../css/App.css';


    class ReviewForm extends Component {
      constructor() {
        super();
        this.state = {
          reviewId: '',
          reviewAuthor: '',
          reviewTitle: '',
          reviewDescription: '',
          reviewRating: '',
        };
      }

      onChange = (e) => {
        // Because we named the inputs to match their corresponding values in state, it's
        // super easy to update the state
        this.setState({ [e.target.name]: e.target.value });
      }

      resetState(){
        this.setState({
          reviewId: '',
          reviewAuthor: '',
          reviewTitle: '',
          reviewDescription: '',
          reviewRating: '',
        });

      }

      onSubmit = (e) => {
        e.preventDefault();
        // get our form data out of state

        const { reviewId, reviewTitle, reviewAuthor, reviewDescription, reviewRating } = this.state;
        const sendJson = { reviewId, reviewTitle, reviewAuthor, reviewDescription, reviewRating } ;

        axios.post('http://review-tutor4.apps.18.207.166.134.nip.io/reviews/'+reviewId, sendJson)
          .then((result) => {
            //access the results here....
            console.log(result);
        });

        this.resetState();

      }


      render() {
        const { reviewId, reviewTitle, reviewAuthor, reviewDescription, reviewRating } = this.state;
        return (

          <div className="Main">
            <header className="App-header">
              <h1 className="App-title">New Review Form:</h1>
            </header>

            <div className="App-intro">
              <ul className="studentForm-item">
                <form onSubmit={this.onSubmit}>
                  <p>Review Id: <input type="text" name="reviewId" value={reviewId} onChange={this.onChange} /></p>
                  <p>Title: <input type="text" name="reviewTitle" value={reviewTitle} onChange={this.onChange} /></p>
                  <p>Author: <input type="text" name="reviewAuthor" value={reviewAuthor} onChange={this.onChange} /></p>
                  <p>Rating: <input type="text" name="reviewRating" value={reviewRating} onChange={this.onChange} /></p>
                  <p>Description: <input type="text" name="reviewDescription" value={reviewDescription} onChange={this.onChange} /></p>
                  <button className="btn btn-success" type="submit">Submit</button>
                </form>
              </ul>
            </div>

          </div>
        );
      }
    }

export default ReviewForm;
