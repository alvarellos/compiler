package compiler.syntax.nonTerminal;


import es.uned.lsi.compiler.intermediate.OperandIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

public class Expresion extends Sentencia{
	
	// Variables
	private String _id;
	private TypeIF _expresion;
    private OperandIF resultado;

	
	// Constructores
	public Expresion() {
		super();
	}
	
	public Expresion(TypeIF expresion) {
		this._expresion = expresion;
	}

	// Métodos

	public TypeIF getTipoExpresion()
	{
		return this._expresion;
	}

    public OperandIF getResultado() {
        return resultado;
    }

	public String get_id() {
		return _id;	
	}
	
}
