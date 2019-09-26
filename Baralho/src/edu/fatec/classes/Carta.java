package edu.fatec.classes;

import java.security.InvalidParameterException;

public class Carta extends Object implements Cloneable {

	private String nome;
	private String naipe;
	public final static String naipesValidos[] = {
			Naipes.COPAS.getNaipe(),
			Naipes.ESPADAS.getNaipe(),
			Naipes.OUROS.getNaipe(),
			Naipes.PAUS.getNaipe()
	};
	public final static String nomesValidos[] = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	
	public Carta() {}
	
	public Carta(String nome, String naipe) {
		this.setNome(nome);
		this.setNaipe(naipe);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome == "coringa") {
			this.nome = nome;
			return;
		}else {
			for(String n : Carta.nomesValidos) {
				if(n.equals(nome)) {
					this.nome = nome;
					return;
				}
			}
		}
		throw new InvalidParameterException("Nome inválido!");
	}

	public String getNaipe() {
		return naipe;
	}

	public void setNaipe(String naipe) {
		if(naipe == "coringa") {
			this.naipe = naipe;
			return;
		}else {
			for(String n : Carta.naipesValidos) {
				if(n.equals(naipe)) {
					this.naipe = naipe;
					return;
				}
			}
		}
		throw new InvalidParameterException("Naipe inválido!");
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("---------\n");
		if(this.getNome() == "coringa") {
			builder.append("|JOKER  |\n");
			builder.append("|       |\n");
			builder.append("|       |\n");
			builder.append("|       |\n");
			builder.append("|  JOKER|\n");
		}else if(this.getNome() == "10") {
			builder.append("|").append(this.getNome()).append("     |\n");
			builder.append("|").append(this.getNaipe()).append("      |\n");
			builder.append("|       |\n");
			builder.append("|      ").append(this.getNaipe()).append("|\n");
			builder.append("|     ").append(this.getNome()).append("|\n");
		}else {
			builder.append("|").append(this.getNome()).append("      |\n");
			builder.append("|").append(this.getNaipe()).append("      |\n");
			builder.append("|       |\n");
			builder.append("|      ").append(this.getNaipe()).append("|\n");
			builder.append("|      ").append(this.getNome()).append("|\n");
		}
		builder.append("---------\n");
		return builder.toString();	
	}
	
	public Carta clonarCarta() throws CloneNotSupportedException {
		return (Carta) this.clone();
	}
	
}
