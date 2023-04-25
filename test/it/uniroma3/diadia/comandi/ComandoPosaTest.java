package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class ComandoPosaTest {
	private Partita partita;
	private ComandoPosa posa;
	private Stanza cortile;
	private Attrezzo spada;
	private Labirinto labirinto;

	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
		this.posa = new ComandoPosa();
		this.cortile = new Stanza("cortile");
		this.spada = new Attrezzo("spada", 4);
		this.labirinto = new Labirinto();
		partita.setLabirinto(labirinto);

	}

	@Test
	public void testEsegui() {
		labirinto.setStanzaCorrente(cortile);
		this.partita.getGiocatore().getBorsa().addAttrezzo(spada);
		posa.setParametro("spada");
		posa.esegui(partita);
		assertSame(true, cortile.hasAttrezzo("spada"));
	}

}