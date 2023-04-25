package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando{
	
	IO console = new IOConsole();
	
	@Override
	public void esegui(Partita partita)
	{
		console.mostraMessaggio("Sei nella stanza: "+ partita.getLabirinto().getStanzaCorrente().getDescrizione());
	}
	
	@Override
	public void setParametro(String parametro)
	{
		
	}

}
