@stories
Feature: UTest
  As a user
  I want to register at utest.com, and create my account
  @scenario1
  Scenario Outline: SignUp on the utest page
    Given that Kim get the utest page
    When he registers
      |strFirstName|strLastName|strEmail|month|day|year|languages|strCity|strPostalCode|strCountry|strComputer|strVersion|strLanguage|strDevice|strModel|strOp|strPassword|
      |<strFirstName>|<strLastName>|<strEmail>|<month>|<day>|<year>|<languages>|<strCity>|<strPostalCode>|<strCountry>|<strComputer>|<strVersion>|<strLanguage>|<strDevice>|<strModel>|<strOp>|<strPassword>|
    Then he has registered
      |strWelcomeMessage|
      |<strWelcomeMessage>|
    Examples:
      | strFirstName | strLastName | strEmail            | month    | day | year | languages | strCity  | strPostalCode | strCountry | strComputer | strVersion | strLanguage | strDevice | strModel      | strOp      | strPassword   | strWelcomeMessage                                                       |
      | kimberly     | Garces      | sami889w0e823@gmail.com | December | 5   | 1994 | spanish   | Medellín | 398502        | colombia   | Windows     | 2000       | Spanish     | Xiaomi    | Redmi Note 9s | Android 11 | Kab34*.**$%gb | Welcome to the world's largest community of freelance software testers! |
