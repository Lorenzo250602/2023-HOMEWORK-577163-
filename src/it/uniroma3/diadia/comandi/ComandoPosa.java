package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando{
	
	private IO console = new IOConsole();
	private String nomeAttrezzo;
	
	@Override
	public void esegui(Partita partita)
	{
		if(partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo))
		{
			Attrezzo attrezzo=partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
			
			if(partita.getLabirinto().getStanzaCorrente().numeroAttrezziStanza() < 10)
			{
				partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
					
				partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
					
				console.mostraMessaggio(("Attrezzo " + nomeAttrezzo + " posato nella stanza " 
						+ partita.getLabirinto().getStanzaCorrente().getNome()));
					
				console.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
				
			}
			else
				console.mostraMessaggio("LA STANZA NON PUO CONTENERE PIU DI 10 ATTREZZI");
		}
		else
			console.mostraMessaggio("L'ATTREZZO NON E' NELLA BORSA");
	}
	
	@Override
	public void setParametro(String parametro)
	{
		this.nomeAttrezzo = parametro;
	}

}
