package com.neotech.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchingSteps {               //     *
	
	@Given("I navigated to Google.")
	public void i_navigated_to_google() {
		System.out.println("I go to google page");
	   
	}
	@When("I type something on the search box")
	public void i_type_something_on_the_search_box() {
		System.out.println("I search on puppy image");
	    
	}
	@When("I click on the search button")
	public void i_click_on_the_search_button() {
		System.out.println("I click on search");
	  
	}
	@Then("I can see the results of my search")
	public void i_can_see_the_results_of_my_search() {
		System.out.println("validate if results is showing");
		
		
	}
	@Then("I can count the number of the results")
	public void i_can_count_the_number_of_the_results() {
		System.out.println("Count of number of results");
		System.out.println("Test passed!!");
		
	}
		
		
		
		
		
	 

	
	
	

}
