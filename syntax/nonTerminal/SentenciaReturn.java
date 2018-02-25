package compiler.syntax.nonTerminal;

public class SentenciaReturn extends Expresion {
	
	private Expresion _expresion;
	
	public SentenciaReturn(){
		super();
	}
	public SentenciaReturn(Expresion expresion){
		super();
		_expresion = expresion;
	}
	
	public Expresion getExpresion(){
		return _expresion;
	}
}
