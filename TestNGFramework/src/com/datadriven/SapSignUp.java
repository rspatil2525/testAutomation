package com.datadriven;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;

public class SapSignUp {
	Logger log = Logger.getLogger(SapSignUp.class);

	public static void main(String[] args) {
		WebDriver driver;
		
		//Get the test data from excel
		Xls_Reader reader = new Xls_Reader("D:\\JavaPrograms\\SamplePrograms\\TestNGFramework\\src\\com\\testdata\\Register.xlsx");
		String firstName = reader.getCellData("RegTestData", "firstName", 2);
		System.out.println(firstName);
		
		String lastName= reader.getCellData("RegTestData", "lastName", 2);
		System.out.println(lastName);
		
		String email = reader.getCellData("RegTestData", "email", 2);
		System.out.println(email);
		
		String password = reader.getCellData("RegTestData", "password", 2);
		System.out.println(password);
		
		String re_enterpasswors = reader.getCellData("RegTestData", "re_enterpasswors", 2);
		System.out.println(re_enterpasswors);
		
	
		
		
		//Webdriver code
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\renewedcart.com\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver(); // launch chrome
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("https://cai.tools.sap/"); // enter url
		
		driver.findElement(By.xpath("//div[contains(text(),\"Sign up\")]")).click();
		
	
		driver.switchTo().frame("IDS_UI_Window");
		driver.findElement(By.xpath("//*[@id='firstName']")).clear();
		driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys(firstName);
		
		driver.findElement(By.xpath("//*[@id='lastName']")).clear();
		driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys(lastName);
		
		driver.findElement(By.xpath("//*[@id='mail']")).clear();
		driver.findElement(By.xpath("//*[@id='mail']")).sendKeys(email);
		
		driver.findElement(By.xpath("//*[@id='newPasswordInput']")).clear();
		driver.findElement(By.xpath("//*[@id='newPasswordInput']")).sendKeys(password);
		
		driver.findElement(By.xpath("//*[@id='retypeNewPasswordInput']")).clear();
		driver.findElement(By.xpath("//*[@id='retypeNewPasswordInput']")).sendKeys(re_enterpasswors);
		
		driver.findElement(By.xpath("//*[@id='pdAccept']")).click();
		
		driver.findElement(By.xpath("//*[@id='touAccept']")).click();
		
		driver.findElement(By.xpath("//*[@id='sapStoreRegisterFormSubmit']")).click();


	}


}
