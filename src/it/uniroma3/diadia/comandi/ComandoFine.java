package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando{
	
	IO console = new IOConsole();
	@Override
	public void esegui(Partita partita)
	{
		console.mostraMessaggio("Grazie di aver giocato!");
	}
	
	public void setParametro(String parametro)
	{
		
	}

}
