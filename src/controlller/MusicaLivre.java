package controlller;

import java.io.*;

public class MusicaLivre {
	
	private char[] atualmusica;

	public MusicaLivre() {
		// TODO Auto-generated constructor stub
	

	//	private ArrayList<char> atualmusica;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("teste");

	}
	public void LeEntrada(String CaminhoArquivo) throws Exception{    
	          FileReader fr=new FileReader(CaminhoArquivo);    
	          BufferedReader br=new BufferedReader(fr);    
	  
	          int i;    
	          while((i=br.read())!=-1){  
	          System.out.print((char)i);  
	          }  
	          br.close();    
	          fr.close();    
	        
	}

}
