package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {
	
	private Stanza stanzaVincente;
	private Stanza stanzaCorrente;
	
	private Attrezzo lanterna;
	private Attrezzo osso;
	
	private Stanza atrio;
	private Stanza biblioteca;
	private Stanza aulaN11;
	private Stanza aulaN10;
	private Stanza laboratorio;


	
	public Labirinto()
	{
		creaLabirinto();
	
	}
	
	public void creaLabirinto()
	{
		
		/* collega le stanze */
		
		this.lanterna = new Attrezzo("lanterna",3);
		this.osso = new Attrezzo("osso",1);
		
		this.atrio=new Stanza("Atrio");
		this.biblioteca=new Stanza("Biblioteca");
		this.aulaN11 = new Stanza("Aula N11");
		this.aulaN10 = new Stanza("Aula N10");
		this.laboratorio = new Stanza("Laboratorio Campus");
		
	    atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);
		
		/* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		
		stanzaCorrente=atrio;
		stanzaVincente=biblioteca;
		
	}
	
	public void setStanzaVincente(Stanza stanzaVincente)
	{
		this.stanzaVincente=stanzaVincente;
	}
	
	
	public void setStanzaCorrente(Stanza stanzaCorrente)
	{
		this.stanzaCorrente=stanzaCorrente;
		
	}
	
	
	public Stanza getStanzaVincente()
	{
		return this.stanzaVincente;
	}
	
	
	public Stanza getStanzaCorrente()
	{
		return this.stanzaCorrente;
	}
	
	
	
	
	
	
	
	
	
}
	
