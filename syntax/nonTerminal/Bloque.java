package compiler.syntax.nonTerminal;

public class Bloque extends NonTerminal{
	
	// Variables de clase
	private BloqueInstrucciones _bloqueSentencias;
	private Sentencias _sentencias;
	

	// Constructores

	public Bloque(Sentencias sentencias)
	{
		super();
		this._sentencias = sentencias;
	}
	
	public Bloque(BloqueInstrucciones bloqueSent, Sentencias sentencias)
	{
		super();
		this._bloqueSentencias = bloqueSent;
		this._sentencias = sentencias;
	}

	
	// Métodos
	
	public Sentencias getSentencias()
	{
		return _sentencias;
	}

	public BloqueInstrucciones getBloqueSentencias()
	{
		return _bloqueSentencias;
	}

}
