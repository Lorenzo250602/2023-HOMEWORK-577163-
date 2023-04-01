package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class LabirintoTest {

	Labirinto lab =new Labirinto();
	
	private Stanza stanzaVincente;
	private Stanza stanzaCorrente;
	
	private Attrezzo lanterna;
	private Attrezzo osso;
	
	private Stanza atrio;
	private Stanza biblioteca;
	private Stanza aulaN11;
	
	@BeforeEach
	public void setUp() {
		
		this.lanterna = new Attrezzo("lanterna",3);
		this.osso = new Attrezzo("osso",1);
		
		this.atrio = new Stanza("Atrio");
		this.biblioteca = new Stanza("Biblioteca");
		this.aulaN11 = new Stanza("Aula N11");
		
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);
		
		aulaN11.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		
		stanzaCorrente=atrio;
		stanzaVincente=biblioteca;
	}
	
	
	@Test
	public void testStanzaVincente()
	{
		assertEquals(lab.getStanzaVincente().getNome(), biblioteca.getNome());
	}
	
	@Test
	public void testStanzaCorrente()
	{
		assertEquals(lab.getStanzaCorrente().getNome(), atrio.getNome());
	}
	
	@Test
	public void testStanzaAdiacente()
	{
		assertEquals(atrio.getStanzaAdiacente("nord"), biblioteca);
		assertEquals(atrio.getStanzaAdiacente("est"), aulaN11);
		assertEquals(biblioteca.getStanzaAdiacente("sud").getNome(), lab.getStanzaCorrente().getNome());
	}
	
	
	
	
	
	

}
