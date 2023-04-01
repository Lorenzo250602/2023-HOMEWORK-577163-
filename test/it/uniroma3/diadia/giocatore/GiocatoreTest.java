package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;

class GiocatoreTest {

	static private final int CFU_INIZIALI=20;
	private Borsa borsa;
	
	private Giocatore giocatore;
	
	
	@BeforeEach
	public void setUp() {
		
		borsa= new Borsa();
		giocatore = new Giocatore();
		
		assertNotNull(giocatore);
        assertEquals(CFU_INIZIALI , giocatore.getCfu());

	}
	
	@Test
	public void testSetCfu()
	{
		giocatore.setCfu(5);
        assertEquals(5 , giocatore.getCfu());

	}
	
	@Test
	public void testSetBorsa()
	{
	     giocatore.setBorsa(borsa);
	     assertEquals(this.borsa , giocatore.getBorsa());
	}
	
	

}
