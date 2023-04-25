package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class ComandoPrendiTest {
	private Partita partita;
	private ComandoPrendi prendi;
	private Stanza bagno;
	private Attrezzo scopa;
	private Labirinto labirinto;

	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
		this.prendi = new ComandoPrendi();
		this.bagno = new Stanza("Bagno");
		this.scopa = new Attrezzo("Scopa", 5);
		this.labirinto = new Labirinto();
		partita.setLabirinto(labirinto);
	}

	@Test
	public void testEsegui() {
		labirinto.setStanzaCorrente(bagno);
		bagno.addAttrezzo(scopa);
		prendi.setParametro("Scopa");
		prendi.esegui(partita);
		assertSame(true ,partita.getGiocatore().getBorsa().hasAttrezzo("Scopa"));
	}

}