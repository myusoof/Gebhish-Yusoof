Feature: I want to test all the fields using selenium

  Background: I want to navigate to the internet applicatoin
    Given I navigate to the internet application

    Scenario Outline: I click on button button
      Given I click on <link> link
      Then I should see the <page> page

      Examples:
      |link       | page  |
      |A/B Testing| abtest|


#    Scenario: I am login with username and password
#      Given I click on Basic Auth link
#      Then I enter the username and password in the authentication page

    Scenario: I click on checkbox
      Given I click on Checkboxes link
      Then I should see the checkboxes page
      Then I verify the checkboxes in the page

#    Scenario: I verify the drag and drop option
#      Given I click on Drag and Drop link
#      Then I should see the drag_and_drop page
#      Then I drag A and drop into B box


    Scenario: I verify I am able to select the option from the dropdown
      Given I click on Dropdown link
      Then I should see the dropdown page
      Then I should be able to select item in the dropdown

    Scenario: I verify I am able to verify dynamic loading
      Given I click on Dynamic Loading link
      Then I should see the dynamic_loading page
      Then I click on element containing href
        |/dynamic_loading/1 |
        |/dynamic_loading/2 |


    Scenario: I verify I am able to download the file
      Given I click on File Download link
      Then I should see the download page
      Then I should be able to download a file