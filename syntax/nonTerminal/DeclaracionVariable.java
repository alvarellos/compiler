package compiler.syntax.nonTerminal;

import java.util.ArrayList;

import es.uned.lsi.compiler.semantic.type.TypeIF;

public class DeclaracionVariable extends NonTerminal{

	// Variables de clase
	private ListaVariables _lista_identificadores;
	private TypeIF _tipo;
	
	// Constructores
	public DeclaracionVariable() {
		super();
	}
	
	public DeclaracionVariable(ListaVariables lista_ident, TypeIF tipo)
	{
		this._lista_identificadores = lista_ident;
		this._tipo = tipo;
	}
	
	
	// Métodos públicos de la clase
	public ArrayList<TokenVar> getListaVariables()
	{
		return this._lista_identificadores.getListaVariables();
	}
	
	public TypeIF getType()
	{
		return this._tipo;
	}
	
	
	
}