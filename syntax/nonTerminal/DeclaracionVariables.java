package compiler.syntax.nonTerminal;

import java.util.ArrayList;

public class DeclaracionVariables extends NonTerminal{
	
	// Variables
	private ArrayList<DeclaracionVariable> _variables_declaracion; 

	// Constructores
	public DeclaracionVariables()
	{
		super();
		this._variables_declaracion = new ArrayList<DeclaracionVariable>();
	}

	// Métodos
	

	public void addVariable(DeclaracionVariable variable)
	{
		this._variables_declaracion.add(0, variable);
	}
	

	public ArrayList<DeclaracionVariable> getVariable_Lista_Declaraciones()
	{
		return this._variables_declaracion;
	}
}
