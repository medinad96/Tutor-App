# Tutor-App

A demo application showcasing various cloud native technologies that implement a system for Students and Tutors to connect.

# Models

## Student

* Name
* Phone Number
* Email
* School
* Short description of the help they need
* Classes they need help with
* Places they prefer to meet
* Schedule of times they want to receive help

## Tutor

* Name
* Phone Number
* Email
* Place they prefer to meet
* Classes or subjects they can provide help for
* Schedule of times available
* List of students who have looked at profile

## Location

* Description
* Address

## Review

* Student
* Tutor
* Rating (1-5)
* Comments

## Session

* Student
* Tutor
* Time
* Location

## Message

* Sender
* Time
* Content
* Read (true/false)

# Services

## Profile Service (requires authentication)

* GET a profile
* PUT a profile
* DELETE a profile

## Review Service

* GET a review
* POST a review
* DELETE a review

## Scheduling Service

* GET a session by date range
* POST a session
* DELETE a session

## Chat Service

* GET all messages by time
* GET all unread by time

## Search Service

* GET a Tutor by subject,availability,location
* GET a Tutor by name
* GET a Student by name
* GET a Student by subject

# Functional Requirements

## For Students

* Able to search for any tutor on the application
* Required to have an account to be able to search
* Able to open a chat with a tutor from their profile, and from their reviews page
* Able to request an appointment from any tutor at an available time
* Able to see review average rating of tutor and page with all of their reviews
* Able to create a review about a tutor they met with


## For Tutors

* Able to search for any student on the application
* Able to open a chat with a tutor from their profile, and from their reviews page
* Must be signed in to search for students
* Search by subject name or info for students needing help
* Request to tutor student at an available time
* Able to see review average rating of student and page with all of their reviews
* Able to post a review about a student they met with before
