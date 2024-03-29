package com.neotech.practice;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFuncionalitySteps {
	
	/*
	  * This steps will run for everyone  in Data driven feature file. Each steps 
	  * will be the same. but username and passwords will changes.
	  * for data driven setup check   <<scenarioOutline>> feature file
	  * Similar  to parameter difference is adding <> Angle brackets.
	  */

	public class ScenarioOutlineSteps {  //*
		@When("Login with {string} and {string}")
		public void login_with_and(String username, String password) {
			System.out.println("Login with " + username + " and " + password);
		   
		}
		@When("Click on the login button")
		public void click_on_the_login_button() {
			System.out.println("Clicking on login button");
		 
		}
		@Then("Validate that {string} is displayed")
		public void validate_that_is_displayed(String username) {
		System.out.println("Validate the welcome " +username+" is showing ");
		  
		}
		@Then("We want to say Bye {string}")
		public void we_want_to_say_bye(String fullname) {
			System.out.println("Bye bye " + fullname);
		
		}

	
	}
}
