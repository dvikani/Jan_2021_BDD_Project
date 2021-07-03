@otherFeature 
Feature: Other validate Techfios login functionality 


Background: 
#Given  user is on the Techfios login page 
	Given  user is on the "Techfios" login page 
	
	
@other1 @smoke
Scenario: 1 User should be able to login with the valid credentials 
	When user enters username "demo@techfios.com" 
	When user enters password "abc123" 
	And user clicks singin button 
	Then user will land on the Dashboard page 
	
@other2 @smoke
Scenario: 2 User should be able to login with the valid credentials 
	When user enters username "demo@techfios.com" 
	When user enters password "abc1234" 
	And user clicks singin button 
	Then user will land on the Dashboard page 
	
@other3 
Scenario: 3 User should be able to login with the valid credentials 
	When user enters username "demo2@techfios.com" 
	When user enters password "abc123" 
	And user clicks singin button 
	Then user will land on the Dashboard page 
	
@other4
Scenario: 4 User should be able to login with the valid credentials 
	When user enters username "demo2@techfios.com" 
	When user enters password "abc1234" 
	And user clicks singin button 
	Then user will land on the Dashboard page