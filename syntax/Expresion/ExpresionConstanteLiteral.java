package compiler.syntax.Expresion;

import compiler.syntax.nonTerminal.Expresion;
import es.uned.lsi.compiler.semantic.type.TypeIF;

public class ExpresionConstanteLiteral extends Expresion {

	// Variables
	private Integer _constante_entera;
	private Boolean _constante_booleana;

	
	
	// Constructores
	
	public ExpresionConstanteLiteral() {
		super();
	}
	public ExpresionConstanteLiteral(TypeIF expresion, Integer constValue) {
		super(expresion);
		this._constante_entera = constValue;
	}

	public ExpresionConstanteLiteral(TypeIF expresion, Boolean constValue) {
		super(expresion);
		this._constante_booleana = constValue;
	}
	
	
	// Metodos
	public Integer get_constante_entera() {
		return _constante_entera;
	}
	public void set_constante_entera(Integer _constante_entera) {
		this._constante_entera = _constante_entera;
	}
	public Boolean get_constante_booleana() {
		return _constante_booleana;
	}
	public void set_constante_booleana(Boolean _constante_booleana) {
		this._constante_booleana = _constante_booleana;
	}
	
	
	
}
