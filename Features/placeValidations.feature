 Feature: Validating place API's
 
 @sanity
  Scenario: verify if place is being successfully added using AddPlace API's
    Given 	Add place Payload
    When 		The user calls "AddPlaceApi" with Post http request
    Then 		The API call get success with Status code 200
    And  		"status" in response body is "OK"
    And  		"scope" in response body is "APP"
    
   Examples:
   			|name						|language		|Address  					|
   			|justin's house	|Tamil			|paachalur-kodaikanal|
   