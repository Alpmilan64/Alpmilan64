package com.neotech.steps;

import java.util.List;


import org.openqa.selenium.WebElement;

import com.neotech.utils.CommonMethods;

import io.cucumber.java.en.Then;

public class PersonalDetailsSteps extends CommonMethods {

	@Then("I am able to modify Employee Details {string}, {string}, {string}, {string}, {string}")
	public void i_am_able_to_modify_employee_details(String driverLic, String expDate, String smoker, String gender,
			String nation) {

		waitForVisibility(personalDetails.personalDetailsForm);

		sendText(personalDetails.driverLicense, driverLic);

		if (smoker.equals("Yes")) {
			click(personalDetails.smokerBox);
		}
		wait(2);

		click(personalDetails.genderInput);

		// 1st way. Locating the WebElement dynamically
		// click(driver.findElement(By.xpath("//span[text()='" + gender + "']")));

		// 2nd way. Iterating all the options until I find the one that I need
		clickOnElement(personalDetails.genderOptions, gender);

		click(personalDetails.nationInput);
		clickOnElement(personalDetails.nationOptions, nation);

		wait(2);

		click(personalDetails.licExpDate); // Will show the calendar

		String[] parts = expDate.split("-"); // 2023-05-08

		// Select the year
		click(personalDetails.licExpYearInput); // Will show the years
		clickOnElement(personalDetails.licExpYearOptions, parts[0]);

		// Select the month
		click(personalDetails.licExpMonthInput); // Will show the months
		int m = Integer.parseInt(parts[1]); // Converting 05 to integer 5
		click(personalDetails.licExpMonthOptions.get(m - 1)); // Because May is index 5-1

		// Select the day
		int d = Integer.parseInt(parts[2]); // Converting 08 to integer 8
		selectCalendarDate(personalDetails.licExpDays, d + ""); // Converting int 8 to a String

		wait(1);
	}

	public void clickOnElement(List<WebElement> list, String value) {
		wait(1);
		for (WebElement option : list) {
			// System.out.println(option.getText());
			if (option.getText().equals(value)) {
				click(option);
				break;
			}
		}
	}

	@Then("I click on Personal Details Save")
	public void i_click_on_personal_details_save() {
		jsClick(personalDetails.detailsSaveBtn);
		wait(3);
	}

}
