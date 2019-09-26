package edu.fatec.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.fatec.classes.*;

public class BaralhoTest {

	private Baralho cut;
	
	@Test
	public void validarEmbaralhar() {
		cut = new Baralho();
		String antes = cut.toString();
		cut.embaralhar();
		
		assertNotEquals(antes, cut.toString());

		int totalCoringas = 0;
		for(int i = 0; i < cut.getTopoBaralho(); i++) {
			if(cut.getCartas()[i].getNome() == "coringa")
				totalCoringas++;
		}
		
		assertEquals(4, totalCoringas);
	}

	@Test
	public void validarHasCarta() throws CloneNotSupportedException {
		cut = new Baralho();
		while(cut.hasCarta()) {
			assertTrue(cut.hasCarta());
			cut.distribuirCarta();
		}
		assertFalse(cut.hasCarta());
	}
	
	@Test
	public void validarDistribuirCarta() throws CloneNotSupportedException {
		cut = new Baralho();
		Carta mao = new Carta();
		
		mao = cut.distribuirCarta();
		assertEquals("coringa", mao.getNome());
		
		cut.distribuirCarta();
		cut.distribuirCarta();
		cut.distribuirCarta();
		mao = cut.distribuirCarta();
		assertEquals("K", mao.getNome());
		
		cut.distribuirCarta();
		cut.distribuirCarta();
		mao = cut.distribuirCarta();
		assertEquals("10", mao.getNome());
		
		while(cut.hasCarta())
			cut.distribuirCarta();
		
		assertNull(cut.distribuirCarta());
		
	}
}
