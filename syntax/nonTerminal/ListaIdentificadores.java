package compiler.syntax.nonTerminal;

import java.util.ArrayList;

import compiler.lexical.Token;



public class ListaIdentificadores extends NonTerminal{

	// Variables
	private ArrayList<Token> _token_lista;
	
	// Constructores
	public ListaIdentificadores() {
		super();
		this._token_lista = new ArrayList<Token>();
	}
    
	// Métodos
	public ArrayList<Token> getListaTokens() {
		return this._token_lista;
	}
	
	public void addToken(Token id) 
	{
		this._token_lista.add(0, id);
	}
	
	public void addLista(ListaIdentificadores lista){
		for(Token id : lista.getListaTokens()){
			this._token_lista.add(0, id);
		}
	}
}
