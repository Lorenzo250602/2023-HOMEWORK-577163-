package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {
	
	private String nomeProva;
	private String nome1;
	private String nome2;
	
	Stanza stanzaProva;
	Stanza stanza1;
	Stanza stanza2;
	Stanza stanzaVuota;
	
	Attrezzo attrezzoProva;
	Attrezzo spada;
	Attrezzo forbici;
	
	@BeforeEach
	void setUp()
	{
		this.nome1="atrio";
		this.nome2="biblioteca";
		this.nomeProva="cucina";
		this.stanzaProva=new Stanza(nomeProva);
		this.attrezzoProva=new Attrezzo("cuffie",7);
		
		this.stanza1= new Stanza(nome1);
		this.stanza2=new Stanza(nome2);
		
		this.spada=new Attrezzo("spada",5);
		this.forbici=new Attrezzo("forbici",10);
		
		assertNotNull(stanzaProva);
		assertNull(stanzaVuota);
		assertNotNull(attrezzoProva);
	}
	
	@Test
	void testNome()
	{
		assertEquals(stanza1.getNome(), this.nome1);
		assertEquals(stanza2.getNome(), "biblioteca");
        
	}
	
	@Test
	void testStanzaAdiacente() {
		
		stanza1.impostaStanzaAdiacente("nord",stanza2);
		
		assertEquals(stanza2, stanza1.getStanzaAdiacente("nord"));
		assertNotEquals(stanza1, stanza1.getStanzaAdiacente("nord"));
		
	}
	
	@Test
	void testAttrezzo()
	{
		//aggiungi attrezzi
		assertTrue(stanza1.addAttrezzo(this.spada));
		assertTrue(stanza1.addAttrezzo(this.forbici));
		
		//verifica aggiunta
		assertNotNull(stanza1.getAttrezzo("spada"));
		assertNotNull(stanza1.getAttrezzo("forbici"));
		
		//verifica aggiunto attrezzo corretto
		assertEquals(stanza1.getAttrezzo("spada") , this.spada);
		assertEquals(stanza1.getAttrezzo("forbici") , this.forbici);
		assertEquals(stanza1.getAttrezzo("spada").getNome() , this.spada.getNome());
		assertEquals(stanza1.getAttrezzo("forbici").getPeso() , this.forbici.getPeso());
		
		//rimuovi attrezzi
		assertTrue(stanza1.removeAttrezzo(this.spada));
		assertTrue(stanza1.removeAttrezzo(this.forbici));
		
		//verifica rimozione
		assertNull(stanza1.getAttrezzo("spada"));
		assertNull(stanza1.getAttrezzo("forbici"));

		
		
	}
	

}
