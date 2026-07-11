# TrailBuddy Backend API

**Version:** 1.0
**Last Updated:** July 11, 2026

**Base URL:**

- local: http://localhost:8080
- production: https://trailbuddy-z728.onrender.com

## Table of Contents

1. [Overview](#1-overview)
2. [UML Class Diagram](#2-uml-class-diagram)
3. [API Endpoints](#3-api-endpoints)
   - [Customer Endpoints](#31-customer-endpoints)
   - [Provider Endpoints](#32-provider-endpoints)
   - [Outdoor Service Endpoints](#33-outdoor-service-endpoints)
   - [RSVP Endpoints](#34-rsvp-endpoints)
   - [Review Endpoints](#35-review-endpoints)
4. [Use Case Mapping](#4-use-case-mapping)

---

## 1. Overview

The TrailBuddy backend exposes a RESTful API for the outdoor activity searching platform described in the SRS. It supports customer registration and profile management, services discovery and lookup, and review management.

---

## 2. UML Class Diagram

![UML Class Diagram](../docs/UML%20class%20diagram.png)

---

## 3. API Endpoints

### 3.1 Customer Endpoints

#### Create a customer

```http
POST /api/customers
```

Request body:

```json
{
  "name": "John Doe",
  "email": "johndoe@demo.com",
  "password": "password123",
  "skillLevel": "Begineer",
  "preference": "Scared of water"
}
```

Example response:

```json
{
  "name": "John Doe",
  "email": "johndoe@demo.com",
  "password": "password123",
  "skillLevel": "Begineer",
  "preference": "Scared of water",
  "rsvps": [],
  "reviews": []
}
```

#### Get all customers

```http
GET /api/customers
```

#### Get a customer by id

```http
GET /api/customers/{id}
```

#### Get a customer by email

```http
GET /api/customers/email/{email}
```
#### Get a customer by skill-level

```http
GET /api/customers/skill-level?skillLevel=Intermediate
```

#### Update customer personal information

```http
PUT /api/customers/{id}
```

Example request body:

```json
{
  "name": "Jane Doe",
  "email": "janedoe347@demo.com",
}
```

#### Update customer personal information

```http
PUT /api/customers/{id}/personal-info
```

Example request body:

```json
{
  "skillLevel": "Advanced",
  "preference": "I love to swim"
}
```

#### Delete a customer

```http
DELETE /api/customers/{id}
```

---

### 3.2 Provider Endpoints

#### Create a provider

```http
POST /api/providers
```

Request body:

```json
{
  "name": "Alice Provides III",
  "email": "alice@demo.com",
  "password": "providerpass",
  "location": "NC",
  "description": "Love to help people overcome their fears of water"
}
```

#### Get all provider

```http
GET /api/providers
```

#### Get a provider by id

```http
GET /api/providers/{id}
```

#### Get a provider by email

```http
GET /api/providers/email/{email}
```

#### Search provider by name

```http
GET /api/providers/name?query=alice
```

Example response:

```json
[
  {
    "id": 1,
    "name": "Alice Provides III",
    "email": "alice@demo.com",
    "location": "NC",
    "description": "Love to help people overcome their fears of water",
    "reviews": [],
    "offerings": []
  },
  {
    "id": 2,
    "name": "Alice Fake",
    "email": "fakeA@demo.com",
    "location": "NY",
    "description": "Love to help people get over their fear of heights",
    "reviews": [],
    "offerings": []
  }
]
```

#### Update provider information

```http
PUT /api/providers/{id}
```

Example request body:

```json
{
  "name": "Alice Provider III Updated",
  "email": "alice@demo.com",
  "password": "newpassword"
}
```

#### Delete a provider

```http
DELETE /api/provider/{id}
```

---

### 3.3 Outdoor Service Endpoints

#### Create an outdoor service

```http
POST /api/outdoor-services
```

Request body:

```json
{
  "provider": {
    "id": 1
  },
  "name": "Kayaking at Lake Michigan",
  "description": "A beginner-friendly kayaking program.",
  "skillLevel": "Begineer",
  "location": "MI",
  "gearList": "Closed toe shoes",
  "date": "08/11/2026"
}
```

#### Get all outdoor services

```http
GET /api/outdoor-services
```

#### Get an outdoor service by id

```http
GET /api/outdoor-services/{id}
```

#### Get outdoor services by provider

```http
GET /api/outdoor-services/provider/{providerId}
```

##### Search outdoor services by skill level

```http
GET /api/outdoor-services/skill-level/{skillLevel}
```

##### Search outdoor services by name

```http
GET /api/outdoor-services/search?query=Scubadiving
```

#### Update an outdoor service

```http
PUT /api/outdoor-services/{id}
```

Example request body:

```json
{
  "name": "Scudadiving at Hawaii now"
}
```

#### Delete an outdoor service

```http
DELETE /api/outdoor-services/{id}
```

---

### 3.5 RSVP Endpoints

#### Register for an offering

```http
POST /api/rsvp
```

Request body:

```json
{
  "customer": {
    "id": 1
  },
  "outdoorService": {
    "id": 7
  },
  "status": {
    "id": 10
  },
  "status": "Scheduled",
}

```

#### Get registration for a customer

```http
GET /api/rsvp/customer/{customerId}
```

Example response:

```json
[
  {
    "id": 3,
    "customer": {
      "id": 1
    },
    "outdoorService": {
      "id": 3
    },
    "status": "Scheduled"
  }
]

```

#### Get registration by id

```http
GET /api/rsvp/{id}
```

---

### 3.6 Review Endpoints

#### Get reviews by customer

```http
GET /api/reviews/customer/{customerId}
```

#### Get reviews by trainer

```http
GET /api/reviews/trainer/{trainerId}
```

#### Create a review

```http
POST /api/reviews
```

Request body:

```json
{
  "customer": {
    "id": 1
  },
  "trainer": {
    "id": 2
  },
  "rating": 5,
  "comments": "Great coaching and clear instructions."
}
```

#### Update a review

```http
PUT /api/reviews/{id}
```

Request body:

```json
{
  "id": 1,
  "replyText": "Thank you for your feedback! Glad you enjoyed the session."
}
```

---

## 4. Use Case Mapping

The API endpoints support the following SRS user stories and acceptance flows described in the requirements document.

### Customer use cases

| SRS use case                          | Related Endpoints                                                                                         |
| ------------------------------------- | --------------------------------------------------------------------------------------------------------- |
| US-1 Register and manage profile      | `POST /api/customers`, `GET /api/customers/{id}`, `PUT /api/customers/{id}`, `DELETE /api/customers/{id}` |
| US-2 Browse trainers by goal category | `GET /api/trainers` , `GET /api/trainers/specialty?query={goal}`                                          |
| US-3 Book a training session          | `POST /api/training-sessions`                                                                             |
| US-4 Write a review after a session   | `POST /api/reviews`                                                                                       |

### Provider use cases

| SRS use case                           | Related Endpoints                                                                                      |
| -------------------------------------- | ------------------------------------------------------------------------------------------------------ |
| US-3 Update/remove offering | `GET /api/outdoor-services/{id}`, `PUT /api/outdoor-services/{id}`, `DELETE /api/outdoor-services/{id}`  |
| US-5 Upload offering       | `POST /api/outdoor-services` |
| US-6 Respond to reviews     | `PUT /api/reviews/{id}`|
| US-7 Create profile          | `POST /api provider`,                                                               |
| US-9 View registration | |