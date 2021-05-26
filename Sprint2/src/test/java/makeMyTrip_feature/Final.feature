Feature: MakeMyTrip Functionality

Background:
Given User is on Landing Page

#SCENARIO FOR REGISTER (EMAIL/MOBILE NUMBER)

@Test1
Scenario: Register with invalid Mobile Number
#Given User is on Landing Page
When User enters invalid mobile number"<Mobile Number>" and clicks on Continue button
Then User gets an Error message for invalid mobile number

@Test2
Scenario: Register with invalid Email
#Given User is on Landing Page
When User enters invalid email "<Email>" and clicks on text for pop message to appear
Then User gets an Error message for invalid email

@Test3
Scenario: Register with New Mobile Number and invalid OTP
#Given User is on Landing Page
When User enters new mobile number "<Mobile Number>" and clicks on Continue button
And User enters invalid OTP and clicks on Verify and Create Account button
Then User gets an Error message for invalid OTP for new mobile number

@Test4
Scenario: Register with New Email and invalid OTP
#Given User is on Landing Page
When User enters new email "<Email>" and clicks on Continue button
And User enters invalid OTP and clicks on Verify and Create Account button
Then User gets an Error message for invalid OTP for new Email

#SCENARIO FOR LOGIN (EMAIL/MOBILE NUMBER)

@Test5
Scenario: Login with Registered Mobile Number and invalid OTP
#Given User is on Landing Page
When User enters registered mobile number "<Mobile Number>" and clicks on Continue button
And User enters invalid OTP and clicks on Login button
Then User gets an Error message for invalid OTP for registered mobile number

@Test6
Scenario: Login with Registered Email and invalid password
#Given User is on Landing Page
When User enters registered email "<Email>" and clicks on Continue button
And User enters invalid Password and clicks on Login button
Then User gets an Error message for invalid password for registered email
