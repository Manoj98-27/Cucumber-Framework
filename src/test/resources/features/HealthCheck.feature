 
 	@ui @healthcheck
		Feature: E-commerce Project Web Site Health Check
		 Background: Navigation to the URL
    Given User navigated to the home application url
 	@t
 		Scenario: User is able to Open the browser, navigate to the URL and Search for Product
    When User Search for product "Laptop"
    Then Search Result page is displayed
    
  @NewOne
  Scenario: User is able to Open the browser, navigate to the URL and Search for Product
  And User Search for product "mobile"
  When User Click On Any Product 
  Then Add to Cart Result Page is Displayed
  

#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
