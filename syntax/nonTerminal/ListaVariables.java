package compiler.syntax.nonTerminal;

import java.util.ArrayList;
import compiler.lexical.Token;

public class ListaVariables extends NonTerminal {
	// Variables
	private ArrayList<TokenVar> _variable_lista;
	
	// Constructores
	public ListaVariables() {
		super();
		this._variable_lista = new ArrayList<TokenVar>();
	}
    
	// Métodos
	public ArrayList<TokenVar> getListaVariables() {
		return this._variable_lista;
	}
	
	public void addToken(Token id){
		TokenVar var = new TokenVar(id);
		_variable_lista.add(var);
	}
	public void addVariable(TokenVar id) 
	{
		this._variable_lista.add(0, id);
	}
	
	public void addLista(ListaVariables lista){
		for(TokenVar id : lista.getListaVariables()){
			this._variable_lista.add(0, id);
		}
	}
}
