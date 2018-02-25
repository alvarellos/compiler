package compiler.syntax.nonTerminal;

import compiler.lexical.Token;

public class SentenciaSalidaCadena extends Sentencia {
	
	// Variables

	private Token _cadena = null;
	private String _texto;
	
	public SentenciaSalidaCadena() {
		super();
	}

	public SentenciaSalidaCadena(Token cadena)
	{
		super();
		this._cadena = cadena;	
	}

	public SentenciaSalidaCadena(String texto)
	{
		this._texto = texto;
	}

}
