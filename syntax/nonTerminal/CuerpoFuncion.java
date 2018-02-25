package compiler.syntax.nonTerminal;

import java.util.ArrayList;

public class CuerpoFuncion extends NonTerminal {
	
	private BloqueInstrucciones _bloqueSentencias;
	private Sentencias _listaSentencias;
	
	public CuerpoFuncion(){
		_listaSentencias = new Sentencias();
	}
	public CuerpoFuncion(Sentencias listaSentencias){
		_listaSentencias = listaSentencias;
	}
	
	public Sentencias getListaSentencias(){
		return _listaSentencias;
	}
	public void setListaSentencias(Sentencias listaSentencias){
		_listaSentencias = listaSentencias;
	}
	
	public BloqueInstrucciones getBloqueSentencias()
	{
		return _bloqueSentencias;
	}
	
	public boolean tieneRetorno(){
		if (_listaSentencias == null)

			return false;

		ArrayList<Sentencia> lista = _listaSentencias.getListaSentencias(); 
		
		if (lista == null || lista.size()==0)
			return false;

		for(Sentencia sent : lista){
			if (sent instanceof SentenciaReturn){
				
				return true;
			}
			else if (sent instanceof BloqueInstrucciones){
/*				ArrayList<Sentencia> listaInterna = _listaSentencias.getListaSentencias(); 
				if (listaInterna == null || listaInterna.size()==0)
					return false;
				//System.out.println("hola");
				for (Sentencia sentInterna : lista){
					if (sentInterna instanceof SentenciaReturn){
						return true;
					}
					
				}*/
				
				return true;
			}
			else if (sent instanceof SentenciaSeleccion){
/*				ArrayList<Sentencia> listaInterna = _listaSentencias.getListaSentencias(); 
				if (listaInterna == null || listaInterna.size()==0)
					return false;
				System.out.println("hola");
				for (Sentencia sentInterna : lista){
					if (sentInterna instanceof SentenciaReturn){
						return true;
					}
					
				}*/
				
			    // Verificar que la siguiente sentencia es un bloque
				
				return true;
			}
			
			else if (sent instanceof SentenciaRepeticion){
/*				ArrayList<Sentencia> listaInterna = _listaSentencias.getListaSentencias(); 
				if (listaInterna == null || listaInterna.size()==0)
					return false;
				System.out.println("hola");
				for (Sentencia sentInterna : lista){
					if (sentInterna instanceof SentenciaReturn){
						return true;
					}
					
				}*/
				return true;
			} else {
				return false;
			}
			
			
		}
		
		return false;
	}
}