package compiler.syntax.nonTerminal;

import compiler.lexical.Token;

public class TokenVar extends NonTerminal {
	
	private Token id;
	private Token valor_asignado;
	
	// Constructores
	public TokenVar(Token _id){
		super();
		id = _id;
		valor_asignado = null;
	}
	public TokenVar(Token _id, Token _valor_asignado){
		super();
		id = _id;
		valor_asignado = _valor_asignado;
	}
	
	// Metodos
	public Token getToken(){
		return id;
	}
	
	public Token getValorAsignado(){
		return valor_asignado;
	}
}
