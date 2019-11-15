package Seguro.Soat;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Alternativa {
	String url ="https://compratusoat.com.co/?utm_source=CorporateWebSite&utm_medium=Referral";
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
	clk("//input[@placeholder='Ingresa la placa de tu vehículo']",500);
	click.sendKeys("YPU69E");
	clk("//input[@id='mail']",0);
	click.sendKeys("jns-01@hotmail.com");
	clk("//input[@id='name']",0);
	click.sendKeys("Michael");
	clk("//input[@id='apellidos']",0);
	click.sendKeys("Nino");
	clk("//input[@id='phone']",0);
	click.sendKeys("3103571354");
	clk("//input[@id='accept']",2000);
	clk("//*[@id=\"modalTerminos\"]/div/div/div[3]/button[2]",2000);
	clk("//*[@id=\"btsubmit\"]",1000);
	clk("//input[@name='Clase']",0);
	WebElement btn = driver.findElement(By.xpath("//*[@id=\"paso1\"]/div[5]/div/div[2]/input[1]"));
	btn.submit();
	/*WebElement cc = driver.findElement(By.xpath("//input[@id='cedula']"));
	cc.clear();
	cc.sendKeys("1023929389");*/
	clk("//input[@id='inputSelect']",2000);
	click.sendKeys("Bogota D.C.");
	WebElement adress = driver.findElement(By.xpath("//input[@id='addres']"));
	adress.clear();
	Thread.sleep(1000);
	adress.sendKeys("calle 31 sur # 3 61");
	WebElement btn2 = driver.findElement(By.xpath("//input[@class='btn btn-primary btn-green btn-interno fw-700']"));
	btn2.submit();
	WebElement price = driver.findElement(By.xpath("//span[@id='text_tot']"));
	String precio = price.getText();
	assertEquals("553,100", precio);

	

	}
	
	@After
	public void cerrar() {
		driver.quit();
	}

}
