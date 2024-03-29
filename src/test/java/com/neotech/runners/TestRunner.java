package com.neotech.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		
		// we can specify which feature/features to run 
				features = "src/test/resources/features", 

				// we can specify where the code for the above feature files is located
				glue = "com.neotech.steps",

				// if true, it does not run the java classes. Only checks the feature files
				// if they are glued to some java code
				dryRun = false,

				// tags can  the same thing groups on TestNG do
				tags = "@smoke",   //~@smoke   ~  makes smoke tag exclude 

				monochrome = true
		    )
	


public class TestRunner {



}












