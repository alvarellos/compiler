package compiler.syntax.Expresion;

import compiler.syntax.nonTerminal.Expresion;
import es.uned.lsi.compiler.semantic.symbol.SymbolIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

public class ExpresionID extends Expresion{
	
	private String _id;
	private SymbolIF _simbolo;

	public ExpresionID() {
		super();
	}

	public ExpresionID(TypeIF expresion) {
		super(expresion);
	}
	
	public ExpresionID(TypeIF expresion, String id) {
		super(expresion);
		_id = id;
	}

	public ExpresionID(SymbolIF _simbolo, TypeIF expresion, String _id) {
		super(expresion);
		this._id = _id;
		this._simbolo = _simbolo;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public SymbolIF get_simbolo() {
		return _simbolo;
	}

	public void set_simbolo(SymbolIF _simbolo) {
		this._simbolo = _simbolo;
	}

	
	
}
