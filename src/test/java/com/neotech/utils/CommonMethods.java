package com.neotech.utils;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.neotech.testbase.PageInitializer;


public class CommonMethods  extends PageInitializer {



	/**
	 *   For Reading this methods       ctrl + o
	 * This method first clears the textbox and sends some text
	 * 
	 * @param element
	 * @param text
	 */
	// Sending Name 
	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * This method checks if radio/checkbox is enabled and then clicks on the
	 * element that has the value that we are looking for
	 * 
	 * @param elementList
	 * @param value
	 */
	public static void clickRadioOrCheckbox(List<WebElement> elementList, String value) {
		for (WebElement el : elementList) {
			String actualValue = el.getAttribute("value").trim();

			if (actualValue.equals(value) && el.isEnabled()) {
				el.click();
				break;
			}
		}
	}

	/**
	 * This method allows us to call Thread.sleep() for any amount of seconds
	 * specified.
	 * 
	 * @param seconds
	 */
	public static void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method checks whether a visible text is found in a drop-down and selects
	 * it.
	 * 
	 * @param element
	 * @param visibleText
	 */
	public static void selectDropdown(WebElement element, String visibleText) {
		/*
		 * The reason i like to use <try> and <catch>
		 *  if  Exception  Happens
		 * in here, Select sel = new Select(element);  
		 * and  here, sel.selectByVisibleText(visibleText); 
		 * I will catch that Exception  
		 * e.printStackTrace();  This is for  this method  tell me,
		 * where and why Exception happened.
		 */
		try {
			Select sel = new Select(element);
			sel.selectByVisibleText(visibleText);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method checks if a given index is valid for the WebElement and only then
	 * it select on option by using the index
	 * 
	 * @param element
	 * @param index
	 */
	public static void selectDropdown(WebElement element, int index) {
		try {
			Select sel = new Select(element);
			int size = sel.getOptions().size();
			if (size > index) {
				sel.selectByIndex(index);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will switch to an alert and will accept the alert. It will handle
	 * a NoAlertPresentException
	 * 4 Alert Methods 
	 */
	// 1th  Accept The Alert
	public static void acceptAlert() {  
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will dismiss an alert if it is present
	 */
	// 2nd  dissmiss Alert
	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will return the alert text. If no alert is present the method
	 * will return null
	 * 
	 * @return alertText
	 */
	// 3rd Returns the Alert
	public static String getAlertText() {
		String alertText = null;
		// No void here because we must return AlertText. we get the text 
		// And return it.
		try {
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

		return alertText;
	}

	/**
	 * This method sends text to the alert if it is present.
	 * 
	 * @param text
	 */
	// 4th will send text to Alert
	public static void sendAlertText(String text) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(text);
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method switches to a frame using name or Id
	 * 
	 * @param nameOrId
	 */
	public static void switchToFrame(String nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method switches to a frame using an index
	 * 
	 * @param nameOrId
	 */
	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method switches to a frame using a WebElement
	 * kjfasdkj:Okdnfkhnkh;fdsnm,dkjldlmfdmdlk
	 * @param nameOrId
	 */
	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method switches to the child window
	 */
	public static void switchToChildWindow() {
		String mainWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();

		for (String handle : handles) {
			if (!mainWindow.equals(handle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
	}

	/**
	 * This method creates WebDriverWait object and returns it.
	 * 
	 * @return wait
	 */
	public static WebDriverWait getWaitObject() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
		return wait;
	}

	/**
	 * This method will wait for an element to be clickable.
	 * 
	 * @param element
	 * @return
	 */
	public static WebElement waitForClickability(WebElement element) {
		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method will wait for an element to be visible.
	 * 
	 * @param element
	 * @return
	 */
	public static WebElement waitForVisibility(WebElement element) {
		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method waits for an element to be clickable and then clicks on it.
	 * 
	 * @param element
	 */
	public static void click(WebElement element) {
		waitForClickability(element);
		element.click();
	}


	/**
	 * This method will cast the driver to a JavascriptExecutor and return it.
	 * 
	 * @return
	 */
	public static JavascriptExecutor getJSObject()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;
		//in one line
		//		return (JavascriptExecutor) driver;
	}


	/**
	 * This method will click on an element  
	 * using JavascriptExecutor
	 * 
	 * 
	 * @param element
	 */
	public static void jsClick(WebElement element)
	{
		getJSObject().executeScript("arguments[0].click();", element);
	}




	/**
	 * This method will scroll the page until a specific element is in view.
	 * 
	 * @param element
	 */
	public static void scrollToElement(WebElement element)
	{
		getJSObject().executeScript("arguments[0].scrollIntoView(true)", element);
	}



	/**
	 * This method will scroll the page down based on the pixel parameter.
	 * 
	 * 
	 * @param pixel
	 */
	public static void scrollDown(int pixel)
	{

		getJSObject().executeScript("window.scrollBy(0,"+pixel+")");
	}


	/**
	 * This method will scroll the page up based on the pixel parameter.
	 * 
	 * @param pixel
	 */
	public static void scrollUp(int pixel)
	{
		getJSObject().executeScript("window.scrollBy(0,-"+pixel+")");
	}


	/**
	 * This method selects a date from a calendar.
	 * 
	 * 
	 * @param elements
	 * @param date
	 */
	public static void selectCalendarDate(List<WebElement> elements, String date)
	{
		for(WebElement day : elements)
		{
			if(day.isEnabled())
			{
				if(day.getText().equals(date))
				{
					day.click();
					break;
				}
			}
			else
			{
				System.out.println("This day is not enabled!");
				break;
			}
		}
	}

	/**
	 * This method takes a screenshot and saves it with the provided file name
	 * 
	 * @param filename
	 */
	public static String  takeScreenshot(String filename) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String destination = Constants.SCREENSHOT_FILEPATH + filename 
				                                                                   + getTimeStamp() + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return destination;
	
	}

	/**
	 * This method returns the timestamp in a String format
	 * 
	 * 
	 * @return
	 */
	public static String getTimeStamp() {
		Date date = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");

		return sdf.format(date);
	}




}
