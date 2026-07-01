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
- **Skill Level:** The skill level a customer selected for themseleves to filter what activites meet their level, ranging from begineer, intermediate, and expert.

**Primary Users / Roles.**
- **Customer** — Find and register for outdoor activities that match their preferences and skill level. 
- **Provider** — Manage offerings and promote themselves to potetinal customers

**Scope (this semester).**
- <capability 1> Search and filter for results
- <capability 2> Profiles for customers and providers
- <capability 3> Reviews from customers and responses from providers
- <capability 4> Register for offerings

**Out of scope (deferred).**
- <deferred 1> Social networking feature between customers
- <deferred 2> Display to users what is the most registered event
- <deferred 3> Process payments

> This document is **requirements‑level** and solution‑neutral; design decisions (UI layouts, API endpoints, schemas) are documented separately.

---

## 2. Functional Requirements (User Stories)
Write each story as: **As a `<role>`, I want `<capability>`, so that `<benefit>`.** Each story includes at least one **Given/When/Then** scenario. Take this out when done!!!!

### 2.1 Customer Stories
- **US‑1 — <short title>**  
  _Story:_ As a customer, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

- **US‑2 — <short title>**  
  _Story:_ As a customer, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
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
  _Story:_ As a provider, I want to be able to see how many people registered/unregistered for an activity and see who registered for said activity so I can see who we are providing services for 
  _Acceptance:_
  ```gherkin
  Scenario: Viewing registration on offering
    Given The offering already exists. 
    When  I am viewing the offering
    Then  I should be successful in seeing how many people have registered and unregistered
    And   See the profile of the people who have registered 
  ```
---

## 3. Non‑Functional Requirements (make them measurable)
- **Performance:** description 
- **Availability/Reliability:** description
- **Security/Privacy:** description
- **Usability:** description

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