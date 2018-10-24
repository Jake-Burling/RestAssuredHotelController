Feature: Testing Hotel API

Scenario: Testing a hotel site
Given a hotel list exists that returns a status code 200
  When a hotel is created and posted to the site
  And the same hotel is then updated
  And the same hotel is then deleted
  Then searching for that hotel will return status code 404