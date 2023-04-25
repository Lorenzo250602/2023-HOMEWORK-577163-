package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando{
	
	String nomeAttrezzo;
	IO console = new IOConsole();
	Attrezzo attrezzo;
	
	@Override
	public void esegui(Partita partita)
	{	
		if(partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo))
		{
			this.attrezzo = partita.getLabirinto().getStanzaCorrente().getAttrezzo(this.nomeAttrezzo);
			
			if(partita.getGiocatore().getBorsa().getPesoMax() > 
			  (attrezzo.getPeso() + partita.getGiocatore().getBorsa().getPeso()))
			   {			
				    partita.getGiocatore().getBorsa().addAttrezzo(this.attrezzo);
								
					partita.getLabirinto().getStanzaCorrente().removeAttrezzo(nomeAttrezzo);
						
					console.mostraMessaggio("ATTREZZO "+this.attrezzo.getNome()+" PRESO!");
										
				}
			 else
				 console.mostraMessaggio("L'ATTREZZO PESA TROPPO");
			}
		 else
			  console.mostraMessaggio("LA STANZA NON CONTIENE L'ATTREZZO");
	}
	
	
	@Override
	public void setParametro(String parametro)
	{
		this.nomeAttrezzo = parametro;
	}

}
