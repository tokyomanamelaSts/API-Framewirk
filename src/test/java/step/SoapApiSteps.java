package step;

import com.PartyVerification.Soap.Request.ScreenAndVerifyPartyPerson;

import io.cucumber.java.en.Given;

public class SoapApiSteps {
	
	ScreenAndVerifyPartyPerson screenAndVerifyPartyPerson;
	
	public SoapApiSteps(){
		
		screenAndVerifyPartyPerson=new ScreenAndVerifyPartyPerson();
	}
	
	 @Given("^The user hits the end point to screen and check if the person exist$")
	    public void the_user_hits_the_end_point_to_screen_and_check_if_the_person_exist() throws Throwable {
		 
		// screenAndVerifyPartyPerson.validatStatusCode();
	    }
	

}
