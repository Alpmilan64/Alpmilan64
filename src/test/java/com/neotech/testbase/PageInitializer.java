package com.neotech.testbase;


import com.neotech.pages.*;



public class PageInitializer extends BaseClass {

	public static LoginPageElements login;
	public static DashboardPageElements dashboard;
	public static AddEmployeePageElements addEmployee;
	public static PersonalDetailsPageElements personalDetails;
	public static EmployeeListPageElements employeeList;


	public static void initialize() {
		login = new LoginPageElements();
		dashboard = new DashboardPageElements();
		addEmployee = new AddEmployeePageElements();
		personalDetails = new PersonalDetailsPageElements();
		employeeList = new EmployeeListPageElements();
		
	}

}
