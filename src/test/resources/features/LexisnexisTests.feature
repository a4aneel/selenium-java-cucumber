Feature: LexisNexis search jobs tests
  As a Customer, I want to access the homepage and using careers link to search ofr jobs

  Background: Home page of lexisnexis.com

  @lexisnexis
  Scenario: Verify that user can search for all jobs
    Given I am on Homepage and clicks on About us link
    And I click on Careers link
    When I click search all jobs link and search for "automation tester" keyword
    Then I am presented with correct results
