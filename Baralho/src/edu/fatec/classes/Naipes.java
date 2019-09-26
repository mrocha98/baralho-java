package edu.fatec.classes;

public enum Naipes {
	COPAS(Character.toString('\u2665')),
	ESPADAS(Character.toString('\u2660')),
	OUROS(Character.toString('\u2666')),
	PAUS(Character.toString('\u2663'));
	
	private final String naipe;
	
	private Naipes(String naipe) {
		this.naipe = naipe;
	}
	
	public String getNaipe() {
		return naipe;
	}
}
