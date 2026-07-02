
# Requirements – Starter Template

**Project Name:** TrailBuddy \
**Team:** Bryan (Customer), Sarah (Provider) \
**Course:** CSC 340\
**Version:** 1.0\
**Date:** 2026-06-25

---

## 1. Overview
**Vision.** One or two sentences: who this is for, the core problem, and the outcome.

**Glossary** Terms used in the project
- **Term 1:** description.
- **Term 2:** description

**Primary Users / Roles.**
- **Customer (e.g., Student/Patient/Pet Owner/etc. )** — 1 line goal statement.
- **Provider (e.g., Teacher/Doctor/Pet Sitter/etc. )** — 1 line goal statement.
- **SysAdmin (optional)** — 1 line goal statement.

**Scope (this semester).**
- <capability 1>
- <capability 2>
- <capability 3>

**Out of scope (deferred).**
- <deferred 1>
- <deferred 2>

> This document is **requirements‑level** and solution‑neutral; design decisions (UI layouts, API endpoints, schemas) are documented separately.

---

## 2. Functional Requirements (User Stories)
Write each story as: **As a `<role>`, I want `<capability>`, so that `<benefit>`.** Each story includes at least one **Given/When/Then** scenario.

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
  _Story:_ As a customer, I want to be able to register an unregister for an activity 
  _Acceptance:_
  ```gherkin
  Scenario: Find an activity and register for it
    Given I found an activity I like
    When  I click to view it and register
    Then  I should be registered for the activity or be able to unregister for it
  ```

### 2.2 Provider Stories
- **US-20 — <short title>**  
  _Story:_ As a provider, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

- **US-21 — <short title>**  
  _Story:_ As a provider, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

### 2.3 SysAdmin Stories
- **US‑30 — <short title>**  
  _Story:_ As a sysadmin, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

- **US‑31 — <short title>**  
  _Story:_ As a sysadmin, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

---

## 3. Non‑Functional Requirements (make them measurable)
- **Performance:** description 
- **Availability/Reliability:** description
- **Security/Privacy:** description
- **Usability:** description

---

## 4. Assumptions, Constraints, and Policies
- list any rules, policies, assumptions, etc.

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