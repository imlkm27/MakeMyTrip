Feature: MakeMyTrip Functionality

Background:
Given User is on Landing Page

#SCENARIO FOR REGISTER (EMAIL/MOBILE NUMBER)

@Test1
Scenario Outline: Register with invalid Mobile Number
#Given User is on Landing Page
When User enters invalid mobile number"<Mobile Number>" and clicks on Continue button
Then User gets an Error message for invalid mobile number
Examples:
|Mobile Number	|
|86600			|
#|866001656		|

@Test2
Scenario Outline: Register with invalid Email
#Given User is on Landing Page
When User enters invalid email "<Email>" and clicks on text for pop message to appear
Then User gets an Error message for invalid email
Examples:
|Email					|
|likith					|
#|@#$%$					|

@Test3
Scenario Outline: Register with New Mobile Number and invalid OTP
#Given User is on Landing Page
When User enters new mobile number "<Mobile Number>" and clicks on Continue button
And User enters invalid OTP and clicks on Verify and Create Account button
Then User gets an Error message for invalid OTP for new mobile number
Examples:
|Mobile Number	|
|8660016562		|
#|9632042152		|

@Test4
Scenario Outline: Register with New Email and invalid OTP
#Given User is on Landing Page
When User enters new email "<Email>" and clicks on Continue button
And User enters invalid OTP and clicks on Verify and Create Account button
Then User gets an Error message for invalid OTP for new Email
Examples:
|Email			|
|a123456@c.c	|
#|^%$#@z.z		|

#SCENARIO FOR LOGIN (EMAIL/MOBILE NUMBER)

@Test5
Scenario Outline: Login with Registered Mobile Number and invalid OTP
#Given User is on Landing Page
When User enters registered mobile number "<Mobile Number>" and clicks on Continue button
And User enters invalid OTP and clicks on Login button
Then User gets an Error message for invalid OTP for registered mobile number
Examples:
|Mobile Number	|
|8660016560		|
#|9632042158		|

@Test6
Scenario Outline: Login with Registered Email and invalid password
#Given User is on Landing Page
When User enters registered email "<Email>" and clicks on Continue button
And User enters invalid Password and clicks on Login button
Then User gets an Error message for invalid password for registered email
Examples:
|Email					|
|likithliki8@gmail.com	|
#|likithlkm1718@gmail.com|