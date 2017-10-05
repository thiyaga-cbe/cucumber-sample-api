package plc_api_test;

import static io.restassured.RestAssured.given;





import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;


import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import org.junit.Assert;

public class plcApi extends StateHolder{
	
	 
	  private Response response;
	  private ValidatableResponse json;
	  private RequestSpecification request;
	  private String getClientId = "http://plc-api-dev.app.plc-preprod.plcpreprod.com/api/LearningBoards/GetClientID?ClientUrl=winlb-fe.plcpreprod.com";
	  private String generateSession = "http://plc-api-dev.app.plc-preprod.plcpreprod.com/api/LearningBoards/GenerateSessionForUser?userId=36";
	  private String checkSessionForUser = "http://plc-api-dev.app.plc-preprod.plcpreprod.com/api/LearningBoards/CheckSessionForUser?UserId=36&SessionId=";
	  private String checkClientId = "http://plc-api-dev.app.plc-preprod.plcpreprod.com/api/LearningBoards/CheckClientID";
	  private String expireSession = "http://plc-api-dev.app.plc-preprod.plcpreprod.com/api/LearningBoards/ExpireSession?UserId=36";
	  
	 
	  
	  
	//GetClientID

	@Given("^the API are up and running$")
	public void the_API_are_up_and_running() throws Throwable {
	   
		request = given()
    		    .contentType(ContentType.JSON)
    		    .baseUri(getClientId);
		   		  		    		
    }
		    
		
	@When("^a user perform the get request$")
	public void a_user_perform_the_get_request() throws Throwable {
		
			response = request.when().get(getClientId);
		   
       
    }
	

	@Then("^the response code should be (\\d+)$")
	public void the_response_code_should_be(int statusCode) throws Throwable {
		json = response.then().statusCode(statusCode);
		System.out.println("status code =" + statusCode);
	}
	
	@Then("^I see the json response includes in any order$")
	public void i_see_the_json_response_includes_in_any_order(Map<String,Object> responseFields) throws Throwable {
	 String responseString=response.getBody().asString();
	 Map<String,Object> responseMap=response.getBody().as(Map.class);
	
    Assert.assertEquals(responseMap.get("clientID").toString() , responseFields.get("clientID"));
    
		
    	}

	//Generate Session for User
	@Given("^the Generate Session for user API$")
	public void the_Generate_Session_for_user_API() throws Throwable {
		
		String ClientId = "1";
		String SecurityToken = "lfDI/2av1NFO5rNIBuXdupPkDOhrFS9kWZWwNkxJDOII5rkgXSxczJY4RN3Wd8GOC+W5CPRspOBU7SutWITG+1BZkpLwR8H4bsZNiTQL/XvUIjJKlnrvVmMXESMqtdmiX0YbwmJKjsjzU7kSZ7cA7/5rsE2X+AMab3f1/bZ3ej0=";
		Map<String, Object> map  = new HashMap<String, Object>();	
		map.put("SecurityToken", SecurityToken);
		map.put("ClientId", ClientId);
		request = given()
    		    .contentType(ContentType.JSON)
    		    .with().header("ClientId", 1) 		   
    		    .baseUri(generateSession);
    	plcApi.clientId=ClientId;
		plcApi.securityToken=SecurityToken;
		
	    
	}

	@When("^a user perform the post request with user$")
	public void a_user_perform_the_post_request_with_user() throws Throwable {
		response = given().contentType(ContentType.JSON).with().header("ClientId", 1).when().post(this.generateSession);
	    System.out.println("response: " + response.prettyPrint());
	}

	
	@Then("^I see the json response for Generate session for user$")
	public void i_see_the_json_response_for_Generate_session_for_user(Map<String,Object> responseFields) throws Throwable {
		 String responseString=response.getBody().asString();
		 Map<String,Object> responseMap=response.getBody().as(Map.class);
	    //Assert.assertEquals(responseMap.get("responseCode").toString() , responseFields.get("responseCode"));
	    //Assert.assertEquals(responseMap.get("responseDescription").toString() , responseFields.get("responseDescription"));
	    String sessionId = (String)responseMap.get("sessionId");
		System.out.println("sessionId ="+sessionId);
		String decSessionId = 	RSAUtility.RSAEncrypt(sessionId, plcApi.clientId);
		System.out.println("afterEncryptsessionId = "+decSessionId);
		String encSessionId = RSAUtility.RSADecrypt(decSessionId, plcApi.clientId);
		System.out.println("afterDecryptsessionId = "+encSessionId);
		plcApi.decSessionId=decSessionId;
		plcApi.encSessionId=encSessionId;
		System.out.println(plcApi.clientId);
		System.out.println(plcApi.securityToken);
		System.out.println(plcApi.decSessionId);
		plcApi.sessionId=(String)responseMap.get("sessionId");
		plcApi.clientId=clientId;
		}

	//Check session for the user
	
	@Given("^check the session for user$")
	public void check_the_session_for_user() throws Throwable {
		
		/*request = given()
    		    .contentType(ContentType.JSON)
    		   .with().header("ClientId",Integer.parseInt(StateHolder.clientId))
    		   .with().header("SecurityToken",StateHolder.securityToken)
    		    .baseUri(checkSessionForUser+this.sessionId);*/
		}
	
	@When("^a user perform to get the check session for user$")
	public void a_user_perform_to_get_the_check_session_for_user() throws Throwable {
		
		request = given()
    		    .contentType(ContentType.JSON)
    		   .with().header("ClientId",Integer.parseInt(plcApi.clientId))
    		   .with().header("SecurityToken",plcApi.securityToken)
    		    .baseUri(checkSessionForUser+this.sessionId);
		response = request.when().get(checkSessionForUser+plcApi.sessionId);
	    System.out.println("response: " + response.prettyPrint());
	    	
}
	
	@Then("^I see the json response for check the session for user$")
	public void i_see_the_json_response_for_check_the_session_for_user(Map<String,Object> responseFields) throws Throwable {
	
	
		String responseString=response.getBody().asString();
		Map<String,Object> responseMap=response.getBody().as(Map.class);
		
	    Assert.assertEquals(responseMap.get("responseCode").toString() , responseFields.get("responseCode"));

	    }  
	 //check the client_ID
    @When("^a user perform to check the cilent ID$")
    public void a_user_perform_to_check_the_cilent_ID() throws Throwable {
    	request = given()
    		    .contentType(ContentType.JSON)
    		   .with().header("ClientId",Integer.parseInt(clientId))
    		   .with().header("SecurityToken",securityToken)
    		    .baseUri(checkClientId);
		response = request.when().get(checkClientId);
	    System.out.println("response: " + response.prettyPrint());
    	
	}

    @Then("^I see the json response as true$")
    public void i_see_the_json_response_as_true() throws Throwable {
       Assert.assertEquals(response.prettyPrint(), "true");
    }
    
    //Expire the session
    @When("^a user perform to post expire the session$")
    public void a_user_perform_to_post_expire_the_session() throws Throwable {
    	
    	response = given().contentType(ContentType.JSON)
    			.with().header("ClientId",Integer.parseInt(plcApi.clientId))
    			.with().header("SecurityToken",plcApi.securityToken)
    			.with().header("SessionId", plcApi.decSessionId)
    			.when().post(this.expireSession);
	    System.out.println("response: " + response.prettyPrint());
    	
    	
    }
    
    @SuppressWarnings("deprecation")
	@When("^I see the json response for expire the session$")
    public void i_see_the_json_response_for_expire_the_session(Map<String,Object> responseFields) throws Throwable {
    
    	 String responseString=response.getBody().asString();
		 Map<String,Object> responseMap=response.getBody().as(Map.class);
		 System.out.println("Response "+ response.getBody().as(Map.class));
		 Map<String,Object> parent = (Map<String, Object>) responseMap.get("apistatus");
		Assert.assertEquals(parent.get("sessionId") , encSessionId);
		//Assert.assertEquals(parent.get("ResponseCode") , responseFields.get("ResponseCode"));
		Assert.assertEquals(parent.get("responseDescription") , responseFields.get("responseDescription"));
		Assert.assertEquals(parent.get("responseCode") , 300);
    }
    
}
	
	
	
