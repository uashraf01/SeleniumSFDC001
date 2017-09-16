@current @regression @automation
Feature: Log In function
Scenario: Varify Logging into the Sales Force
Given user opens a browser 
And User navigates to "https://login.salesforce.com/"
When user enters user name as "USER_ULFAT" and password as "PASSWORD_ULFAT" 
##parameters in double quote above 
And user click on LogIn
And user sees the below objects
|Home|
|Chatter|
|Campaigns|
|Leads|
|Accounts|
|Contacts|
#|Opportunities|
#|Forecasts|
#|Contracts|
#|Orders|
|Cases|
#|Solutions|
#|Products|
|Reports|
|Dashboards|
Then user logs out of the current application
