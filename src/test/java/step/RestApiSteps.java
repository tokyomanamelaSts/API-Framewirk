package step;

import java.net.URISyntaxException;

import com.exergyRestApi.TC01PolicyByReferenceNumber;
import com.exergyRestApi.TC02CreateCollectionPost;

//import com.exergyRestApi.TC01PolicyByReferenceNumber;
//import com.exergyRestApi.TC02CreateCollectionPost;

import io.cucumber.java.en.Given;

public class RestApiSteps {
	
	TC01PolicyByReferenceNumber policyByReferenceNumber;
	TC02CreateCollectionPost createCollectionPost;
	
	public RestApiSteps() {
		policyByReferenceNumber=new TC01PolicyByReferenceNumber();
		createCollectionPost=new TC02CreateCollectionPost();
		
	}
	

	@Given("The user hits the end point to create a collection")
	public void The_user_hits_the_end_point_to_create_a_collection() {
	    // Write code here that turns the phrase above into concrete actions
		//createCollectionPost.postRequest();
		
	}
	
	@Given("The user hits the end point to get existing policy using reference number")
	public void The_user_hits_the_end_point_to_get_existing_policy_using_reference_number() throws URISyntaxException {
	    // Write code here that turns the phrase above into concrete actions
		//policyByReferenceNumber.test0001();
		
	}

}
