package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;

class PartitaTest {
	
	Partita partita;
	
	@BeforeEach
	public void setUp() {
		partita=new Partita();
		assertNotNull(partita.getLabirinto());
		assertNotNull(partita.getGiocatore());
	
	}

	
	@Test
	void testVinta()
	{
	  assertNotNull(this.partita.getLabirinto().getStanzaCorrente());
	  assertNotNull(this.partita.getLabirinto().getStanzaVincente());
	}

}
