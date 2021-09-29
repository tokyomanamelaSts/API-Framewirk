@rest
Feature: RestApi
Run all rest api requests

Scenario: As a user, I would like to get policy by reference 
	Given The user hits the end point to get existing policy using reference number
	
Scenario: As a user, I would like to create a collection 
	Given The user hits the end point to create a collection
	