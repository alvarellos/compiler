package compiler.syntax.nonTerminal;

import compiler.lexical.Token;

public class SentenciaSalidaValor extends Sentencia {
	
	// Variables
	private Expresion _expresion = null;
	private Token _cadena = null;

	
	public SentenciaSalidaValor() {
		super();
	}
	
	public SentenciaSalidaValor(Expresion expresion)
	{
		super();
		this._expresion = expresion;
	}
	
	public SentenciaSalidaValor(Token cadena)
	{
		super();
		this._cadena = cadena;	
	}
	
}
