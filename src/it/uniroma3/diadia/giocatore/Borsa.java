package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.IOConsole;
/**
 * 
 * @author Uni
 *
 */
public class Borsa {
   
   public final static int DEFAULT_PESO_MAX_BORSA = 10;
   private Attrezzo[] attrezzi;
   private int numeroAttrezzi;
   private int pesoMax;
   private IOConsole console;
 

   public Borsa() {
      this(DEFAULT_PESO_MAX_BORSA);
   }
   
   public Borsa(int pesoMax) {
     this.pesoMax = pesoMax;
     this.attrezzi = new Attrezzo[10]; // speriamo bastino...
     this.numeroAttrezzi = 0;
     this.console=new IOConsole();
   }
   
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
		   return false;
	    if (this.numeroAttrezzi==10)
	       return false;
	    
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
       }
	
	public int getPesoMax() {
	   return pesoMax;
	}
		
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
		if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
		a = attrezzi[i];
				
		return a;
	}
	
	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
		peso += this.attrezzi[i].getPeso();

		return peso;
		}
	
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
		
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	public boolean removeAttrezzo(String nomeAttrezzo) {
		// ---> TODO (implementare questo metodo) <---
   
		boolean trovato=false;
		if(isEmpty())
			console.mostraMessaggio("LA BORSA E' VUOTA");
		else
		{
			for(int i=0;i<this.numeroAttrezzi && !(trovato) ;i++) {
				
				if(this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
					trovato=true;
					numeroAttrezzi--;
				}
				
				if(trovato) {
					for(int e=i; e<this.numeroAttrezzi ;e++)
						this.attrezzi[e] = this.attrezzi[e+1];
					this.attrezzi[this.numeroAttrezzi] = null;
				}
		     }
			if(!(trovato))
				 console.mostraMessaggio("L'ATTREZZO " + nomeAttrezzo + " NON SI TROVA NELLA BORSA");
	    }
		
		return trovato;
	}
	
	
	public String toString() {
		
		StringBuilder s = new StringBuilder();
        
        if(isEmpty())
        	s.append("LA BORSA E' VUOTA");
        else
        {
	        for(int i=0;i<this.attrezzi.length;i++)
	        	if(attrezzi[i]!=null)
	        		s.append(this.getPeso()+"kg/"+this.getPesoMax()+"kg)  ");
        }
        
		return s.toString();
		
	}
}