package compiler.syntax.nonTerminal;

public class SentenciaRepeticion extends Sentencia {
	
	// Variables de clase
	private Expresion _expresion;
	private Sentencias _sentencia;

	// Constructores
	public SentenciaRepeticion() {
		super();
	}

	public SentenciaRepeticion(Expresion expresion, Sentencias sentencia)
	{
		super();
		this._expresion = expresion;
		this._sentencia = sentencia;
	}

	// Métodos
	
	public Expresion getExpresion() 
	{
		return _expresion;
	}
	

	public Sentencias getSentencia() 
	{
		return _sentencia;
	}
	

}
