package com.neotech.steps;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginHRMSteps  extends CommonMethods{


	@Given("I navigated to the HRM website")
	public void i_navigated_to_the_hrm_website() {
		System.out.println("I navigate to HRM website");
	}

	@Given("user is logged in with valid credentials")
	public void user_is_logged_in_with_valid_credentials() {
		// This is done in the Hooks
		//setUp();
		System.out.println(" Is it working?");
		login.adminLogin();
	}

	@When("I enter a valid username")
	public void i_enter_a_valid_username() {
		sendText(login.password, ConfigsReader.getProperty("username"));
	}

	@When("I enter a valid password")
	public void i_enter_a_valid_password() {
		sendText(login.password,ConfigsReader.getProperty("password"));

	}

	@When("I click on the login button")
	public void i_click_on_the_login_button() {
		click(login.logInButton);
		wait(2);
	}
	@Then("I validate that i am logged in")
	public void i_validate_that_i_am_logged_in() {
		String expected = "Jakie White";
		String actual= dashboard.accountName.getText();

		if (actual.equals(expected)) {
			System.out.println("Test pased!!");
		}
		else {
			System.out.println("Test Failed.");
		}
	}

	@Given("user enter valid username")
	public void user_enter_valid_username() {
		sendText(login.username,ConfigsReader.getProperty("username"));

	}
	@Given("user enter invalid password")
	public void user_enter_invalid_password() {
		sendText(login.password,ConfigsReader.getProperty("password"));


	}
	@Given("user click login button")
	public void user_click_login_button() {
	
	click(login.logInButton);
	
 wait(2);

	}
	@Then("I validate that invalid credential is displayed")
	public void i_validate_that_invalid_credential_is_displayed() {
		System.out.println("Invalid password and test failed");


	}



}
