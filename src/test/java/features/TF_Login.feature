@loginFeature 
Feature: validate Techfios login functionality 


Background: 
#Given  user is on the Techfios login page 
	Given  user is on the "Techfios" login page 
	
@scenario1 @smoke
Scenario: 1 User should be able to login with the valid credentials 
	When user enters username "demo@techfios.com" 
	When user enters password "abc123" 
	And user clicks singin button 
	Then user will land on the Dashboard page 
	
@scenario2 @smoke
Scenario: 2 User should be able to login with the valid credentials 
	When user enters username "demo@techfios.com" 
	When user enters password "abc1234" 
	And user clicks singin button 
	Then user will land on the Dashboard page 
	
@scenario3 
Scenario: 3 User should be able to login with the valid credentials 
	When user enters username "demo2@techfios.com" 
	When user enters password "abc123" 
	And user clicks singin button 
	Then user will land on the Dashboard page 
	
@scenario4 
Scenario: 4 User should be able to login with the valid credentials 
	When user enters username "demo2@techfios.com" 
	When user enters password "abc1234" 
	And user clicks singin button 
	Then user will land on the Dashboard page