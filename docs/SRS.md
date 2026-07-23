
# Requirements – Starter Template

**Project Name:** TrailBuddy \
**Team:** Bryan (Customer), Sarah (Provider) \
**Project Name:** TrailBuddy \
**Team:** Team 4; Bryan Palma (customer) Sarah Hyatt (provider) \
**Course:** CSC 340\
**Version:** 1.0\
**Date:** 2026-06-25

---

## 1. Overview
**Vision.** TrailBuddy helps people find outdoor activites based on their skills/preferences and helps providers promote the activities they're offering to users.

**Glossary** Terms used in the project
- **Provider:** Professional individual or organization that provides outdoor services to customers.
- **Customer:** A person seeking outdoor activites to do, used interchangebly with users.
- **Services:** What providers are offering to customers. Used interchangebly with offerings and listings.
- **Profile:** Where all collected information (including personal information) about a customer or provider is stored for said individual to see and edit as needed.
- **Skill Level:** The skill level a customer selected for themseleves to filter what activites meet their level, ranging from begineer, intermediate, and advanced.

**Primary Users / Roles.**
- **Customer** — Find and register for outdoor activities that match their preferences and skill level. 
- **Provider** — Manage offerings and promote themselves to potetinal customers

**Scope (this semester).**
- Filter for results
- Profiles for customers and providers
- Reviews from customers and responses from providers
- Register for offerings

**Out of scope (deferred).**
- Social networking feature between customers
- Display to users what is the most registered event
- Process payments

> This document is **requirements‑level** and solution‑neutral; design decisions (UI layouts, API endpoints, schemas) are documented separately.

---

## 2. Functional Requirements (User Stories)

### 2.1 Customer Stories
- **US‑1 — Login**  
  _Story:_ As a customer, I want to login so that I can have access to my account  
  _Acceptance:_
  ```gherkin
  Scenario: Be able to see account and offerings
    Given I have logged into the account
    When  I am on the login page
    Then  I should be able to see my account and offerings
  ```

- **US‑2 — Customer Review**  
  _Story:_ As a customer, I want write a review so that I can share my experience 
  _Acceptance:_
  ```gherkin
  Scenario: Write a review about experience
    Given I am on the page of the activity
    When  I click the review button
    Then  I should be able to write and post the review
  ```

  **US‑4 — Filter**  
  _Story:_ As a customer, I want see what is there to my preference so that I can find them easily 
  _Acceptance:_
  ```gherkin
  Scenario: Filter by Level
    Given I am on the search bar
    When  I press filter and select the level
    Then  I should be able view any thing within that level
  ```

  **US‑8 — Register/Unregister for activity**  
  _Story:_ As a customer, I want to be able to register and unregister for an activity 
  _Acceptance:_
  ```gherkin
  Scenario: Find an activity and register for it
    Given I found an activity I like
    When  I click to view it and register
    Then  I should be registered for the activity or be able to unregister for it
  ```

### 2.2 Provider Stories
- **US-3 — Upload & remove listing**  
  _Story:_ As a provider, I want to upload/remove my listing to accurately show what I'm providing  
  _Acceptance:_
  ```gherkin
  Scenario: Upload to or delete an offering
    Given I have filled out all the necessary fields or the listing is already made
    When  I am on my profile page or viewing the listing if removing
    Then  I should be successful in creating a new listing or removing one
  ```

- **US-5 — Update an existing service**  
  _Story:_ As a provider, I want to update our listing so that changes can be reflected  
  _Acceptance:_
  ```gherkin
  Scenario: Update a listing
    Given I have already created a listing
    When  I am on my profile page and viewing the listing
    Then  I should be successful in making changes to the exisiting service
  ```
  
- **US-6 — Responding to Reviews**  
  _Story:_ As a provider, I want to be able to respond to customers' reviews so we can better communicate on experiences  
  _Acceptance:_
  ```gherkin
  Scenario: Writing a response to customer Review
    Given A review already exist on a current service I provided
    When  I am viewing said service
    Then  I should be successful in replying to the customer about their experience
  ```

- **US-7 — Creating account**  
  _Story:_ As a provider, I want to be able to make an account so we can promote our offerings  
  _Acceptance:_
  ```gherkin
  Scenario: Creating a new account
    Given I have not created an account
    When  I provide all the necessary information
    Then  I should be successful in creating an account
    And   Customers should be able to see my profile 
  ```

  - **US-9 — Registration statistics**  
  _Story:_ As a provider, I want to be able to see who registered for said activity so I can see who we are providing services for 
  _Acceptance:_
  ```gherkin
  Scenario: Viewing registration on offering
    Given The offering already exists. 
    When  I am viewing the offering
    Then  I should be successful in seeing who have registered 
  ```
---

## 3. Non‑Functional Requirements (make them measurable)
- **Performance:** At least 90% of search responses should be returned in < 3 seconds under average load.
- **Availability/Reliability:** The system should be available 99% of the time, with planned maintenance windows communicated in advance.
- **Security/Privacy:** All credentials are to be autheticated and authorized. Sensitive data should be encrypted and stored securely.
- **Usability:** There should be no need of external assistance to navigate the website and users and providers alike should be able to register and make their first registertation for event and upload for event respectively in the first 5 minutes

---

## 4. Assumptions, Constraints, and Policies
- Course timeline as an applied constraint
- For viewing in modern browsers
- Stable internet connection
- Course content and objective as an applied constraint 

---

## 5. Milestones (course‑aligned)
- **M1 Requirements** — this file + stories opened as issues. 
- **M2 High‑fidelity prototype** — core customer/provider flows fully interactive. 
- **M3 Design** — architecture, schema, API outline. 
- **M4 Backend API** — key endpoints + tests. 
- **M5 Increment** — ≥2 use cases end‑to‑end. 
- **M6 Final** — complete system & documentation. 

---

## 6. Change Management
- Stories are living artifacts; changes are tracked via repository issues and linked pull requests.  
- Major changes should update this SRS.