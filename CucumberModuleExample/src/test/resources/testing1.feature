Feature: I am learning the
         cucumber test script

Scenario: I would like to create my test script with cucumber
  Given I have a test to print the normal text


Scenario: I would like to verify the two number addition
  Given I enter 1 in the calculator
  And I enter another 1 in the calculator
  Then I should see total of 2 in the result


Scenario Outline: I would like to use the with datatable in my script
  Given I have a test user
  When I login with different <username>
  Examples:
    | username  |
    | yusoof    |
    | azeez     |
    | mumtaz    |


  Scenario: This is to test the with datatable property
    Given I have a with property
    Then I should see the property with:
      |yusooftest | delhi     |
      |ceo        | testingof |
    And I enter another 1 in the calculator