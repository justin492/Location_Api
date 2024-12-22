 Feature: Validating place API's
 
 @sanity
  Scenario Outline: verify if place is being successfully added using AddPlace API's
    Given 	Add place Payload with "<name>" "<language>" "<Address>"
    When 		The user calls "AddPlaceAPI" with "Post" http request
    Then 		The API call get success with Status code 200
    And  		"status" in response body is "OK"
    And  		"scope" in response body is "APP"
    And			verify the place_Id created maps to "<name>" using "getPlaceAPI"
    
   Examples:
   			|name						|language		|Address  					 |
   			|justin house		|Tamil			|paachalur-kodaikanal|
   			|mary house			|Tamil			|paachalur-kodaikanal|
   