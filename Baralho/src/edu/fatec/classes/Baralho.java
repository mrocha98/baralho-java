package edu.fatec.classes;

public class Baralho {
	
	public final static int totalDeCartas = 4 * 13 + 4;
	private Carta[] cartas = new Carta[totalDeCartas];
	private int topoBaralho;

	public Baralho() { 
		int contador = 0;
		for(int naipe = 0; naipe < Carta.naipesValidos.length; naipe++) {
			for(int nome = 0; nome < Carta.nomesValidos.length; nome++) {
				this.getCartas()[contador] = new Carta(Carta.nomesValidos[nome], Carta.naipesValidos[naipe]);
				contador++;
			}
		}
		while(contador < Baralho.totalDeCartas) {
			this.getCartas()[contador] = new Carta("coringa", "coringa");
			contador++;
		}
		this.topoBaralho = Baralho.totalDeCartas - 1;
	}

	public Carta[] getCartas() {
		return cartas;
	}
	
	public int getTopoBaralho() {
		return topoBaralho;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < this.getTopoBaralho(); i++) {
			builder.append(this.getCartas()[i].toString());
		}
		return builder.toString();
	}	
	
	public void embaralhar() {
		int a, b; 
		Carta aux;
		for(int i = 1; i <= 500; i++) {
			a = (int) (Math.random() * (this.getTopoBaralho() + 1));
			b = (int) (Math.random() * (this.getTopoBaralho() + 1));
			aux = this.getCartas()[a];
			this.getCartas()[a] = this.getCartas()[b];
			this.getCartas()[b] = aux;
		}
	}
	
	public void imprimirBaralho() {
		System.out.println(this.toString());
	}
	
	public boolean hasCarta() {
		return (this.getTopoBaralho() >= 0);
	}
	
	public Carta distribuirCarta() throws CloneNotSupportedException {
		if(this.hasCarta()) {
			Carta cartaTopo = this.getCartas()[this.getTopoBaralho()].clonarCarta();
			
			this.topoBaralho -= 1;
			return cartaTopo;
		}
		return null;
	}
}
