package org;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestBase {
	public static WebDriver driver;
	public static Properties prps;
		
	public TestBase() {		
			try {
				prps = new Properties();
				FileInputStream ip = new FileInputStream("E:\\JAVA_PROGRAMS\\Sprint2\\src\\test\\java\\config\\propertyFile.properties");
				prps.load(ip);
			} catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}	
	}	
}
