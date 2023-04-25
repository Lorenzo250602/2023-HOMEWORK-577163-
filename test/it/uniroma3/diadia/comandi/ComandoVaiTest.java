package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

import org.junit.Before;
import org.junit.Test;

public class ComandoVaiTest {
	private Partita partita;
	private ComandoVai vai;
	private Stanza atrio;
	private Stanza n10;
	private Labirinto labirinto;
	private String direzione;

	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
		this.vai= new ComandoVai(direzione);
		this.labirinto = new Labirinto();
		this.atrio = new Stanza("Atrio");
		this.n10 = new Stanza("n10");
		atrio.impostaStanzaAdiacente("nord", n10);
		partita.setLabirinto(labirinto);
	}
	
	@Test
	public void testEsegui() {
		labirinto.setStanzaCorrente(atrio);
		vai.setParametro("nord");
		vai.esegui(partita);
		assertSame(n10, labirinto.getStanzaCorrente());
		}
	
	@Test
	public void testSetParametro() {
	    assertSame(null, vai.getParametro());
	    vai.setParametro("nord");
	    assertSame("nord", vai.getParametro());
	}

}
