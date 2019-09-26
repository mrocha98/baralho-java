package edu.fatec.tests;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.junit.Test;

import edu.fatec.classes.Carta;
import edu.fatec.classes.Naipes;

public class CartaTest {

	private Carta cut;
	
	@Test
	public void validarCartaCoringa() {
		cut = new Carta("coringa", "coringa");
		
		assertEquals("coringa", cut.getNaipe());
		assertEquals("coringa", cut.getNome());
		
		StringBuilder strCarta = new StringBuilder();
		strCarta.append("---------\n");
		strCarta.append("|JOKER  |\n");
		strCarta.append("|       |\n");
		strCarta.append("|       |\n");
		strCarta.append("|       |\n");
		strCarta.append("|  JOKER|\n");
		strCarta.append("---------\n");
		assertEquals(strCarta.toString(), cut.toString());
	}
	
	@Test
	public void validarCarta10() {
		cut = new Carta("10", Naipes.ESPADAS.getNaipe());
		
		assertEquals("10", cut.getNome());
		assertEquals(Character.toString('\u2660'), cut.getNaipe());
		
		StringBuilder strCarta = new StringBuilder();
		strCarta.append("---------\n");
		strCarta.append("|").append(cut.getNome()).append("     |\n");
		strCarta.append("|").append(cut.getNaipe()).append("      |\n");
		strCarta.append("|       |\n");
		strCarta.append("|      ").append(cut.getNaipe()).append("|\n");
		strCarta.append("|     ").append(cut.getNome()).append("|\n");
		strCarta.append("---------\n");
		assertEquals(strCarta.toString(), cut.toString());
	}
	
	@Test
	public void validarCartaValete() {
		cut = new Carta("J", Naipes.OUROS.getNaipe());
		
		assertEquals("J", cut.getNome());
		assertEquals(Character.toString('\u2666'), cut.getNaipe());
		
		StringBuilder strCarta = new StringBuilder();
		strCarta.append("---------\n");
		strCarta.append("|").append(cut.getNome()).append("      |\n");
		strCarta.append("|").append(cut.getNaipe()).append("      |\n");
		strCarta.append("|       |\n");
		strCarta.append("|      ").append(cut.getNaipe()).append("|\n");
		strCarta.append("|      ").append(cut.getNome()).append("|\n");
		strCarta.append("---------\n");
		assertEquals(strCarta.toString(), cut.toString());
	}
	
	@Test(expected = InvalidParameterException.class)
	public void validarNomeInvalido() {
		cut = new Carta("Z", Naipes.COPAS.getNaipe());
	}
	
	@Test(expected = InvalidParameterException.class)
	public void validarNaipeInvalido() {
		cut = new Carta("Z", "a");
	}
}
