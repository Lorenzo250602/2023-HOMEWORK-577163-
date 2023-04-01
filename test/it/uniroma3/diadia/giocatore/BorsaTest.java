package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {

	
	private Attrezzo temperino;
	private Attrezzo telefono;
	private Attrezzo spada;
	
	private Borsa borsa1;
	private Borsa borsa2;
	private Borsa borsa3;
	private Borsa borsaVuota;
	
	@BeforeEach
	void setUp() {
		
		temperino = new Attrezzo("Temperino", 1);
		telefono = new Attrezzo("Telefono", 4);
		spada = new Attrezzo("Spada", 3);
		
		borsa1 = new Borsa(20);
		borsa2 = new Borsa(10);
		borsa3 = new Borsa(15);
		borsaVuota= new Borsa(10);}
	

	@Test
	public void testAddAttrezzo()
	{
		assertTrue(borsa1.addAttrezzo(spada));
		assertTrue(borsa1.addAttrezzo(telefono));
		assertTrue(borsa2.addAttrezzo(temperino));
		assertTrue(borsa2.addAttrezzo(telefono));
		assertTrue(borsa3.addAttrezzo(spada));
		
        assertEquals(telefono , borsa1.getAttrezzo("Telefono"));	
        assertEquals(spada , borsa1.getAttrezzo("Spada"));	
        assertEquals(spada , borsa3.getAttrezzo("Spada"));	
        assertEquals(temperino , borsa2.getAttrezzo("Temperino"));	
        assertEquals(telefono , borsa1.getAttrezzo("Telefono"));	
    }
	
	@Test
	public void testGetPesoMax() {
		assertEquals(20, borsa1.getPesoMax());
		assertEquals(10, borsa2.getPesoMax());
		assertEquals(15, borsa3.getPesoMax());
	}
	
	@Test
	public void testRemoveAttrezzo()
	{
		assertTrue(borsaVuota.isEmpty());
		
		borsa1.addAttrezzo(spada);
		borsa1.addAttrezzo(telefono);
		
		assertFalse(borsa1.isEmpty());
		
		assertTrue(borsa1.removeAttrezzo("Spada"));
		assertFalse(borsa1.removeAttrezzo("Spada"));
		assertTrue(borsa1.removeAttrezzo("Telefono"));

	}
	
	
	
	
	
	
	
	
	

}
