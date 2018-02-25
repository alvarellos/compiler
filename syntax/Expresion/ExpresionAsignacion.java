package compiler.syntax.Expresion;

import compiler.lexical.Token;
import compiler.syntax.nonTerminal.Expresion;
import es.uned.lsi.compiler.semantic.symbol.SymbolIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

public class ExpresionAsignacion extends Expresion{

	
	// Variables
	private Token _id;
	private SymbolIF _simbolo;
	private Expresion _expresion;
	
	
	public ExpresionAsignacion() {
		super();
	}

	public ExpresionAsignacion(TypeIF expresion) {
		super(expresion);
	}

	public ExpresionAsignacion(Token _id) {
		super();
		this._id = _id;
	}

	public ExpresionAsignacion(SymbolIF simbolo, Expresion expresion)
	{
		this._simbolo = simbolo;
		this._expresion = expresion;
	}

	// Métodos de la clase

	public SymbolIF getSimbolo()
	{
		return _simbolo;
	}
	
	public Expresion getExpresion()
	{
		return _expresion;
	}
	
	public Token getId()
	{
		return _id;
	}


	
}
