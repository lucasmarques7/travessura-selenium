/**
 * @author lucas
 * 
 * */

package com.desenvolvo.travessura;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestaTravessura {

	public static void main(String[] args) {

		// Cria um driver para usar o navegador firefox
		WebDriver firefox = new FirefoxDriver();
		
		/* Cria um objeto para forçar o firefox a esperar 10 segundos
		 * até a próxima requisição */
		WebDriverWait wait = new WebDriverWait(firefox, 10);
		GeradorDeAssinantes gerador = new GeradorDeAssinantes();

		// Quero assinar apenas 5 vezes
		for (int i = 0; i < 5; i++) {
			// Gera um assinante aleatório
			Assinante assinante = gerador.geraAssinante();
			
			// abre o endereço http://www.avaaz.org/po/ficha_limpa_no_senado_renan_nao/
			firefox.get("http://www.avaaz.org/po/ficha_limpa_no_senado_renan_nao/");

			/* Neste trecho de código estou criando objetos para acessarem 
			 * elementos da página. O Selenium me deixa escolher os elementos
			 * que quero pelos atributos css: nome, id, classe, etc */
			WebElement nome = firefox.findElement(By.name("Name"));
			WebElement email = firefox.findElement(By
					.id("simple-petition-form-Email"));
			Select pais = new Select(firefox.findElement(By.name("CountryID")));
			WebElement cep = firefox.findElement(By.name("Postcode"));
			WebElement tel = firefox.findElement(By.name("Cell"));

			/* Neste trecho de código estou atribuindo valor aos elementos
			 * da página */
			nome.sendKeys(assinante.getNome());
			email.sendKeys(assinante.getEmail());
			pais.selectByVisibleText(assinante.getPais());
			cep.sendKeys(assinante.getCep());
			tel.sendKeys(assinante.getTelefone());
			
			// Apenas escolhi um campo qualquer para dar o submit
			tel.submit();

			/* Estou forçando o navegador vai esperar por 10 segundos até encontrar o campo com 
			 * a classe css "postaction_thankyou" (que se encontra na página de sucesso).
			 * Isso foi necessário para que o loop funcione corretamente, pois o navegador
			 * não esperava a página completar a requisição para iterar. */
			wait.until(ExpectedConditions.presenceOfElementLocated(By
					.className("postaction_thankyou")));
		}

	}

}
