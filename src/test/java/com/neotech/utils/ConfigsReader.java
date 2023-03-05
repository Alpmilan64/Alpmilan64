package com.neotech.utils;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {

	// STEP 2   orange HRM
	// i will have 2 methods here

	private  static  Properties prop;

	/** so now this is Class variable it can see in whole class' than ad static
	* now i can use it inside whole static method in whole CLASS
	*if i want this Variable seeing by everyone
	* i will write  PUBLIC if i want only in this class no where else i will do PRIVATE. 
	*and i will do it private
    *or saying in captulation */

	public static void readProperties(String filePath) {
		
		// This one says give me to filePath so i can read the file
	    // first thing i need to read  than i need to load file. copy and paste from OrangeHRM 

		try {
			FileInputStream  fis = new FileInputStream(filePath); // import FileInputStream 
			                                                                      // throw exception or sorround catch();
	   /** Either i throw Exception or take care of it  sorround-Catch.. so i will do that catch();
	    * give me the filePath
	     *I will do surronded try catch if something goes wrong i can handle i  t*/

			 prop  = new Properties();
			
          /**Properties class has Properties hashtable map which is carry   Key- Value 
			* it has beautiful method  load(); method
			 * I will read it...second thing i like to read properties 
             */
			prop.load(fis);
			
            // method overloading and overriding we have polymorphism.
			// i will load it to properties

			fis.close(); 

			/** I will close it... always close the file 
			* if don't  built up in memory and cosume in memory
			* so this is the  first method will shortly explanation  read properties file.
			 */
		}

		catch (FileNotFoundException e){// if something goes wrong on FileInputStream
			//  i will catch it here
			e.printStackTrace();
			System.out.println(" The File path was wrong");
		} 
		catch (IOException e) {   // if something goes wrong prop.load(); i will catch it here
			e.printStackTrace();
			System.out.println(" I coldn't read the file");
		}

	}
	/**
	 * This method will return value for  specific  key.
	 * @param String  key  it is a map - Hashtable. key and value
	 * @return  String value
	 */
	public static String getProperty(String key) {

		return  prop.getProperty(key); // we will make Properties prop variable 
		/** from method variable to
		 *Class Variable. so it can be seen in whole class
		 *now if i want  to this class Variable in my static method
		 *i will make it static Variable
		 *doing only this.   static properties prop on top i did
          */




	}

}
