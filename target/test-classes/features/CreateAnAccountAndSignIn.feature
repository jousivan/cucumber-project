Feature: Create an account
  I want to create a account to sign in on application

  @CreateAnAccount
  Scenario: Create an account
    Given I want to access the application
    When I click in Sign In option
    And I type a valid email address that not yet was registered and click in Create an account 
    And I type all personal information and click in Register button
    Then I validate the outcomes

  @Logoff
  Scenario: Do Sign Out
    Given I want do Sign Out
    When I click in Sign out option
    Then I validate Sign Out
    
  @LogIn
  Scenario: Do Log In
    Given I want to access the application
    When I click in Sign In option
    And I type email and password and click in Log In
    |sonny.gaylord@example.com|123456|
    Then I validate the outcomes
    And I click in Sign out option
  
  @LoginWithPasswordWrong
  Scenario: Login With Password Wrong
    Given I want to access the application
    When I click in Sign In option
    And I type email and password and click in Log In
    |sonny.gaylord@example.com|999999|
    Then I check the exception
    
  @LoginWithEmailNotRegistered
  Scenario: Login With Email Not Registered
    Given I want to access the application
    When I click in Sign In option
    And I type email and password and click in Log In
    |emailnotregistered@example.com|123456|
    Then I check the exception