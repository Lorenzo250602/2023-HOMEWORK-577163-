package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando{

	String direzione;
	
	public ComandoVai(String direzione)
	{
		this.direzione=direzione;
	}
	
	@Override
	public void esegui(Partita partita)
	{
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza stanzaAdiacente = null;
		
		if(direzione==null)
		{
			System.out.println("Dove vuoi andare?, devi specificare una direzione");
			return;
		}
		
		stanzaAdiacente = stanzaCorrente.getStanzaAdiacente(direzione);
		
		if(stanzaCorrente.getStanzaAdiacente(direzione) == null)
			System.out.println("direzione inesistente");
		else
		{
			partita.getLabirinto().setStanzaCorrente(stanzaAdiacente);
			System.out.println("SEI ANDATO IN: " + partita.getStanzaCorrente());
			partita.getGiocatore().setCfu( partita.getGiocatore().getCfu()-1 );
		}
		
		
	}
	
	@Override
	public void setParametro(String parametro)
	{
		this.direzione = parametro;
	}
	
	public String getParametro()
	{
		return this.direzione;
	}
}
