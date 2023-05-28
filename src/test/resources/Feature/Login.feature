Feature: Test login functionality of ecommerce app
@LoginValidCred
Scenario Outline: user should be login with valid data
Given user is at the login page
When user provide <username> and <password>
And click on Login button
Then user should be navigated to Account page
 |selenium user|

Examples:
|username         |password  |
|"cbatest7@gmail.com"|"cba@test"|

@LoginInValidCred
Scenario Outline: user should be login with invalid data
Given user is at the login page
When user provide <username> and <password>
And click on Login button


Examples:
|username         |password  |
|"ABC@.com"|"cba@test"|
|"la@.com"|"cba@test"|
|"cbatest7@gmail.com"|""|

@CreateAccount
Scenario: Account Creation and share wishlist to other people using mail
Given user is at the login page
Then Account Registration done and wishlist shared succesfully
And Wishlist shared succefully





