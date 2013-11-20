/**
 * @author lucas
 * 
 * */

package com.desenvolvo.travessura;

import java.util.ArrayList;
import java.util.UUID;

public class GeradorDeAssinantes {

	private Assinante assinante = new Assinante();
	private ArrayList<String> nomes = new ArrayList<String>();
	private ArrayList<String> sobrenomes = new ArrayList<String>();
	private ArrayList<String> paises = new ArrayList<String>();
	private ArrayList<String> emails = new ArrayList<String>();
	private int numero;
	private String nome = "";
	private String sobrenome = "";

	public Assinante geraAssinante() {

		this.assinante.setNome(this.geraNome());
		this.assinante.setEmail(this.geraEmail());
		this.assinante.setPais(this.geraPais());
		this.assinante.setCep(this.geraCep());
		this.assinante.setTelefone(this.geraTelefone());
		return this.assinante;
	}

	private String geraNome() {
		String nomeFinal;

		numero = (int) (Math.random() * 25);
		nome = this.getNomes().get(numero);
		numero = (int) (Math.random() * 25);
		sobrenome = this.getSobrenomes().get(numero);

		nomeFinal = nome + " " + sobrenome;

		return nomeFinal;
	}

	private String geraEmail() {
		numero = (int) (Math.random() * 5);
		String email = this.nome + this.sobrenome;

		UUID uuid = UUID.randomUUID();
		String myRandom = uuid.toString();

		return email.toLowerCase() + "_" + myRandom.substring(0, 3)
				+ this.getEmails().get(numero);
	}

	private String geraPais() {
		numero = (int) (Math.random() * 10);
		return this.getPaises().get(numero);
	}

	private String geraCep() {
		String cep = "";
		for (int i = 0; i < 5; i++) {
			numero = (int) (Math.random() * 10);
			cep = cep + numero;
		}

		cep = cep + "-";
		for (int i = 0; i < 3; i++) {
			numero = (int) (Math.random() * 10);
			cep = cep + numero;
		}
		
		return cep;
	}
	
	private String geraTelefone() {
		String telefone = "";
		
		for(int i = 0; i < 4; i++) {
			numero = (int) (Math.random() * 10);
			telefone = telefone + numero;
		}
		
		telefone = telefone + "-";
		
		for(int i = 0; i < 4; i++) {
			numero = (int) (Math.random() * 10);
			telefone = telefone + numero;
		}
		
		return telefone;
	}

	/* Lista com 25 nomes diferentes */
	public ArrayList<String> getNomes() {
		this.nomes.add("Joao");
		this.nomes.add("Maria");
		this.nomes.add("Jose");
		this.nomes.add("Lucas");
		this.nomes.add("Adriane");
		this.nomes.add("Raul");
		this.nomes.add("Mario");
		this.nomes.add("Dilma");
		this.nomes.add("Wellington");
		this.nomes.add("Jonatan");
		this.nomes.add("Adrielle");
		this.nomes.add("Erik");
		this.nomes.add("Luis");
		this.nomes.add("Caio");
		this.nomes.add("Tiago");
		this.nomes.add("Marcos");
		this.nomes.add("Pedro");
		this.nomes.add("Timoteo");
		this.nomes.add("Leandro");
		this.nomes.add("Carlos");
		this.nomes.add("Paulo");
		this.nomes.add("Isabel");
		this.nomes.add("Inacio");
		this.nomes.add("Benedito");
		this.nomes.add("Ivone");
		return this.nomes;
	}

	/* Lista com 25 sobrenomes diferentes */
	public ArrayList<String> getSobrenomes() {
		this.sobrenomes.add("Santos");
		this.sobrenomes.add("Silva");
		this.sobrenomes.add("Souza");
		this.sobrenomes.add("Sa");
		this.sobrenomes.add("Torres");
		this.sobrenomes.add("Marques");
		this.sobrenomes.add("Fernandes");
		this.sobrenomes.add("Moreira");
		this.sobrenomes.add("Salgado");
		this.sobrenomes.add("Bueno");
		this.sobrenomes.add("Gomes");
		this.sobrenomes.add("Lima");
		this.sobrenomes.add("Andrade");
		this.sobrenomes.add("Abreu");
		this.sobrenomes.add("Abravanel");
		this.sobrenomes.add("Rousseff");
		this.sobrenomes.add("Maluf");
		this.sobrenomes.add("Calheiros");
		this.sobrenomes.add("Coelho");
		this.sobrenomes.add("Martinez");
		this.sobrenomes.add("Nakamura");
		this.sobrenomes.add("Uzumaki");
		this.sobrenomes.add("Omiyo");
		this.sobrenomes.add("Ohara");
		this.sobrenomes.add("Takeshi");
		return this.sobrenomes;
	}

	/* Lista com 10 países diferentes */
	public ArrayList<String> getPaises() {
		this.paises.add("Brasil");
		this.paises.add("Argentina");
		this.paises.add("Angola");
		this.paises.add("Noruega");
		this.paises.add("Guatemala");
		this.paises.add("China");
		this.paises.add("Egito");
		this.paises.add("Equador");
		this.paises.add("Israel");
		this.paises.add("Palestina");
		return this.paises;
	}

	/* Lista com 5 terminações diferentes para emails */
	public ArrayList<String> getEmails() {
		this.emails.add("@gmail.com");
		this.emails.add("@yahoo.com");
		this.emails.add("@hotmail.com");
		this.emails.add("@outlook.com");
		this.emails.add("@uol.com");
		return this.emails;
	}

}
