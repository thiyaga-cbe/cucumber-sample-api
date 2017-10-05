Feature: To get the client id 

	#Getting the Cliend ID
	Scenario: To get the client id 
	Given the API are up and running 
	When a user perform the get request 
	Then the response code should be 200 
	And I see the json response includes in any order 
	| clientID  |1|
		
	#Generate the Session for the user by sending the Client ID and Security Token in the Header (Session ID in Encrypted)	 
	Scenario: Generate session for user
	Given the Generate Session for user API
	When a user perform the post request with user
	Then the response code should be 200
	And I see the json response for Generate session for user
	|responseCode|1|
	|responseDescription|Success|
	
	#Check the session for the user by passing Session ID in the parameter
	Scenario: Check the session for user
	Given check the session for user
	When a user perform to get the check session for user
	Then the response code should be 200
	And I see the json response for check the session for user
	|responseCode|1|
	
	#Checking the Client ID by passing Client ID and Security Token, output will be Boolean
	Scenario: Check the Client ID
	When a user perform to check the cilent ID
	Then the response code should be 200
	And I see the json response as true
	
	#Expiring the Session ID by passing the Client ID, Security ID and Session ID after decrypting
	Scenario: Expire Session
	When a user perform to post expire the session
	And I see the json response for expire the session
	|responseCode|1|
	|responseDescription|Success|
	
	
		
		
		
		
		
