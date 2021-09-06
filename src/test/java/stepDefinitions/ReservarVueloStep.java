package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReservarVueloStep {
	
	WebDriver driver = null;

	@Given("el usuario desea reservar un vuelo")
	public void el_usuario_desea_reservar_un_vuelo() {
		
	  System.out.println("agregar paso-estoy en el Given");
	  
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\OSCAR LOPEZ\\eclipse-workspace\\com.viajes.despegar\\chromedriver.exe");
	  
	  driver = new ChromeDriver();
	  
	  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS); 
	  driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	  
	  driver.manage().window().maximize();
	  
	  driver.navigate().to("https://www.despegar.com.co/");
	  
	}

	@When("ingresa la ciudad de origen")
	public void ingresa_la_ciudad_de_origen() {
		System.out.println("agregar paso-seccion ingresar ciudad de origen");
		
		driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")).click();
		driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("Med");
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[1]/ul[1]/li[1]")).click();
		
		
	}

	@When("ingresa el destino")
	public void ingresa_el_destino() throws InterruptedException {
		System.out.println("agregar paso-seccion ingresar el destino");
		
		driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")).sendKeys("Bog");
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[1]/ul[1]/li[1]")).click();
		
		
	}

	@When("selecciona la fecha")
	public void selecciona_la_fecha() throws InterruptedException {
		System.out.println("agregar paso-seleccionar fecha");
		
		//dar click fecha ida
		driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")).click();
		
		Thread.sleep(2000);
		
		//seleccionar numero 13
		driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[3]/div[13]")).click();
		
		//dar click fecha regreso 22
		driver.findElement(By.xpath("//body/div[@id='component-modals']/div[1]/div[1]/div[2]/div[1]/div[3]/div[22]")).click();
		
		//dar click en aplicar
		driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[2]/div[1]/button[1]")).click();
		
	}

	@When("da click en buscar")
	public void da_click_en_buscar() {
		System.out.println("agregar paso-click en bucar");
		
		//dar click en buscar
		driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/div[2]/div[3]/button[1]")).click();
		
	}

	@When("selecciona el primer vuelo de la pagina")
	public void selecciona_el_primer_vuelo_de_la_pagina() {
		System.out.println("agregar paso-seleccoinar vuelo");
		
		//dar click en seleccionar
		driver.findElement(By.xpath("/html[1]/body[1]/div[12]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[4]/app-root[1]/app-common[1]/items[1]/div[1]/span[1]/div[1]/span[1]/cluster[1]/div[1]/div[1]/div[2]/fare[1]/span[1]/span[1]/div[2]/buy-button[1]/a[1]")).click();
	}

	@When("da click en continuar en la panlla de suma de equipaje")
	public void da_click_en_continuar_en_la_panlla_de_suma_de_equipaje() throws InterruptedException {
		System.out.println("agregar paso-suma de equipaje");
		
		Thread.sleep(5000);
		//dar click en continuar
		//driver.findElement(By.xpath("//body/span[@id='upselling-popup-position']/upselling-popup[1]/div[1]/div[3]/div[1]/div[1]/button[1]")).click();
		System.out.println("no encontre la pagina de agregar equipaje");
	}

	@Then("el usuario visualiza el mensaje Falta poco Completa tus datos y finaliza tu compra")
	public void el_usuario_visualiza_el_mensaje_Falta_poco_Completa_tus_datos_y_finaliza_tu_compra() {
		System.out.println("agregar paso-final");
		
		String texto = driver.findElement(By.xpath("//h2[contains(text(),'¡Falta poco! Completa tus datos y finaliza tu comp')]")).getText();
		assertEquals("¡Falta poco! Completa tus datos y finaliza tu compra", texto);
	}
}
