package compiler.syntax.nonTerminal;

public class SentenciaSeleccion extends Sentencia{

	// Variables de clase
	protected Expresion _exp;
	protected Sentencias _if_sentencia;
	protected Sentencias _else_sentencia;	
	
	// Constructor con sentencia else
	
	public SentenciaSeleccion(Expresion exp, Sentencias if_sentencia, Sentencias else_sentencia) 
	{
		super();
		this._exp = exp;
		this._if_sentencia = if_sentencia;
		this._else_sentencia = else_sentencia;
	}
	
	// Constructor sin sentencia else
	public SentenciaSeleccion(Expresion exp, Sentencias if_sentencia)
	{
		super();
		this._exp = exp;
		this._if_sentencia = if_sentencia;
		this._else_sentencia = null;
	}


	// Métodos
	
	public Expresion getExpresion() 
	{
		return _exp;
	}

	public Sentencias getIf() 
	{
		return _if_sentencia;
	}

	public Sentencias getElse() 
	{
		return _else_sentencia;
	}	
	
	
	
}
