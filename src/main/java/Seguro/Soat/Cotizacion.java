package Seguro.Soat;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Cotizacion {
	String url ="https://web.segurosfalabella.com/co/", placa ="DNR327";
	WebDriver driver;
	WebElement click;
	
	
	
	@Before
	public void iniciar () throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe" );
		driver = new ChromeDriver();
		driver.get(url);
		Thread.sleep(100);	
	}
	
	public void clk(String path, int sec) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		click = driver.findElement(By.xpath(path));
		click.click();
		Thread.sleep(sec);
	}
	
	@Test
	public void cotizar() throws InterruptedException {
	driver.manage().window().maximize();	
	clk("//*[@id=\"col-select-SOAT\"]/div/div/div",500);
	clk("//*[@id=\"licence-plate\"]",0);
	click.sendKeys(placa);
	Thread.sleep(1000);
	clk("//*[@id=\"material-group-habeas_data\"]/div/div",0);
	WebElement cedula = driver.findElement(By.xpath("//*[@id='step1Data-identificationNumber']"));
	cedula.sendKeys("1022998201");
	Select seleccion = new Select(driver.findElement(By.xpath("//*[@id=\"typeVehicles\"]")));
	seleccion.selectByVisibleText("AUTOMOVILES FAMILIARES");
	clk("//*[@id=\"Step0Button\"]",5000);
	clk("//*[@id=\"CheckoutStep_1\"]/div/div/form/div[7]/div/button",0);
	clk("//*[@id=\"CheckoutStep_3\"]/div/div/form/ul/li[1]/label/ul",0);
	
	
	}
	
	@After
	public void cerrar() {
		
	}

}
