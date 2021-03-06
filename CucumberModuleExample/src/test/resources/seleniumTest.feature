Feature: I want to test all the fields using selenium

  Background: I want to navigate to the internet application
    Given I navigate to the internet application

  Scenario Outline: I click on button
    Given I click on <link> link
    Then I should see the <page> page

  Examples:
    | link        | page   |
    | A/B Testing | abtest |
    | test1 | test1 |

  Scenario: I am login with username and password
    Given I navigate to the internet application with admin and password admin
    Given I click on Basic Auth link
    Then I validate whether user able to see the authenticated page

  Scenario: I click on checkbox
    Given I click on Checkboxes link
    Then I should see the checkboxes page
    Then I verify the checkboxes in the page

  Scenario: I verify the drag and drop option
    Given I click on Drag and Drop link
    Then I should see the drag_and_drop page
    Then I drag A and drop into B box

  Scenario: I verify I am able to select the option from the dropdown
    Given I click on Dropdown link
    Then I should see the dropdown page
    Then I should be able to select item in the dropdown

  Scenario: I verify I am able to verify dynamic loading
    Given I click on Dynamic Loading link
    Then I should see the dynamic_loading page
    Then I click on element containing href
      | /dynamic_loading/1 |
      | /dynamic_loading/2 |

  Scenario: I verify I am able to download the file
    Given I click on File Download link
    Then I should see the download page
    Then I should be able to download a file avatar
    Then I should be able to download a file hello-world

  Scenario: I verify I am able to upload the file
    Given I click on File Upload link
    Then I should see the upload page
    Then I should be able to upload the file

  Scenario: I verify forgot password
    Given I click on Forgot Password link
    Then I should see the forgot_password page
    Then I should be able reset the password

  Scenario: I verify form authentication
    Given I click on Form Authentication link
    Then I should see the login page
    Then I should be to login in the page

  Scenario: I verify form frame
    Given I click on Frames link
    Then I should see the frames page
    Then I should be able to switch the frame

  Scenario: I verify the geolocation for the page
    Given I click on Geolocation link
    Then I should see the geolocation page
    Then I should be able to look at google page

  Scenario: I verify whether the hover mouse
    Given I click on Hovers link
    Then I should see the hovers page
    Then I should be able to verify whether mouse hover

  Scenario: I verify the JQuery UI Menus
    Given I click on JQuery UI Menus link
    Then I should see the jqueryui page
    Then I should be able to work with jquery
    Then I should see the jqueryui page

  Scenario: I verify the javascript alert for the page
    Given I click on JavaScript Alerts link
    Then I should see the javascript_alerts page
    Then I should be able to validate javascript

  Scenario: I verify the javaScript onload event error for the page
    Given I click on JavaScript onload event error link
    Then I should see the javascript_error page
    Then I validate whether page is loaded with error

  Scenario: I verify the Low and Deep Dom
    Given I click on Deep DOM link
    Then I should see the large page

  Scenario: I verify the Multiple windows
    Given I click on Multiple Windows link
    Then I should see the windows page
    Then I should be able to handle multiple windows

  Scenario: I verify the notification message
    Given I click on Notification Messages link
    Then I should see the notification_message_rendered page
    Then I should see the notification message

  Scenario: I verify the redirection page
    Given I click on Redirect Link link
    Then I should see the redirector page
    Then I click on redirected page

  Scenario: I verify the status code
    Given I click on Status Code link
    Then I should see the status_codes page
    Then I verify the status code

  Scenario: I verify the sorting of the table
    Given I click on Sortable Data Tables link
    Then I should see the table page
    Then the table table1 looks like
      | Last Name | First Name | Email                 | Due     | Web Site                 | Action |
      | Smith     | John       | jsmith@gmail.com      | $50.00  | http://www.jsmith.com    |        |
      | Bach      | Frank      | fbach@yahoo.com       | $51.00  | http://www.frank.com     |        |
      | Doe       | Jason      | jdoe@hotmail.com      | $100.00 | http://www.jdoe.com      |        |
      | Conway    | Tim        | tconway@earthlink.net | $50.00  | http://www.timconway.com |        |


    Scenario: I should be able to perform context click
      Then I context click on Status Code link

  @end
  Scenario: I verify the TinyMCE editor
    Given I click on WYSIWYG Editor link
    Then I should see the tinymce page
    Then I verify whether I am able to access the editor
