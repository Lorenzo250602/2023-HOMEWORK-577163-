package it.uniroma3.diadia;



import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.IOConsole;
/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {
	static final private String MESSAGGIO_BENVENUTO = 
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
			
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	private Attrezzo attrezzo;
	private static IOConsole console;



	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 

		console.mostraMessaggio(MESSAGGIO_BENVENUTO);		
		do		
			istruzione = console.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if(comandoDaEseguire.getNome().equals("prendi"))
		{
			if(partita.getLabirinto().getStanzaCorrente().isEmpty())
				console.mostraMessaggio("LA STANZA NON HA OGGETTI");
			else {
				console.mostraMessaggio("inserisci il nome dell'attrezzo da prendere nella stanza: ");
				this.prendi(console.leggiRiga());
			}
		}
		else if(comandoDaEseguire.getNome().equals("posa"))
		{
			if(partita.getGiocatore().getBorsa().isEmpty())
				console.mostraMessaggio("LA BORSA E' VUOTA");
			else  {
				console.mostraMessaggio("inserisci il nome dell'attrezzo da posare nella stanza: ");
				this.posa(console.leggiRiga());
			}
		}
		else
			console.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			console.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			console.mostraMessaggio(elencoComandi[i]+" ");
		console.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
		{
			System.out.println("Dove vuoi andare ?");
			Scanner scanner_direzione=new Scanner(System.in);
			direzione=scanner_direzione.next();
		}
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			console.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		console.mostraMessaggio("SOSOSOSO "+partita.getLabirinto().getStanzaCorrente().getDescrizione());
		//System.out.println("PROVVAAA"+partita.getLabirinto().getStanzaCorrente().getAttrezzo("osso"));
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		console.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}
	
	private void prendi(String nomeAttrezzo)
	{
		
		this.attrezzo=partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		
		if(this.attrezzo!=null)
		{
			if(partita.getGiocatore().getBorsa().getPesoMax() > 
			  (this.attrezzo.getPeso() + partita.getGiocatore().getBorsa().getPeso()))
			   {			
				   partita.getGiocatore().getBorsa().addAttrezzo(this.attrezzo);
								
					partita.getLabirinto().getStanzaCorrente().removeAttrezzo(this.attrezzo);
						
					console.mostraMessaggio("ATTREZZO "+partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo).getNome()+" PRESO!");
										
				}
			  else
				  console.mostraMessaggio("L'ATTREZZO PESA TROPPO");
			}
		  else
			  console.mostraMessaggio("LA STANZA NON CONTIENE L'ATTREZZO");
		}
	
	
	private void posa(String nomeAttrezzo)
	{
		if(partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo))
		{
			this.attrezzo=partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
			
			if(partita.getLabirinto().getStanzaCorrente().numeroAttrezziStanza() < 10)
			{
				partita.getLabirinto().getStanzaCorrente().addAttrezzo(this.attrezzo);
					
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

	
	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		console=new IOConsole();
		gioco.gioca();
	}
	
	
	
}