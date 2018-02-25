package compiler.syntax.nonTerminal;

import es.uned.lsi.compiler.semantic.type.TypeIF;

public class Sentencia extends Sentencias{

	// Variables
	private TypeIF _sentencia;
	
	// Constructores
	public Sentencia() {
		super();
	}
	
	public Sentencia(TypeIF sentencia) {
		this._sentencia = sentencia;
	}
	
}
