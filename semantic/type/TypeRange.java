package compiler.semantic.type;

import compiler.syntax.nonTerminal.Expresion;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.type.TypeBase;
import es.uned.lsi.compiler.semantic.type.TypeIF;

public class TypeRange extends TypeBase {

	//Variables
	private Expresion _valor_inicio;
	private Expresion _valor_final;
	private boolean _vacio;
	
	
	// Constructores
	public TypeRange(ScopeIF scope, String name) {
		super(scope, name);
	}
	public TypeRange(ScopeIF scope) {
		super(scope);
		_vacio = true;
	}
	public TypeRange(TypeIF type) {
		super(type);
	}

	public TypeRange(ScopeIF scope, Expresion initVal, Expresion endVal) 
	{
		super(scope);
		this._valor_inicio = initVal;
		this._valor_final  = endVal;
		_vacio = false;
	}
	
	// Métodos
	public Expresion get_valor_inicio() {
		return _valor_inicio;
	}
	public void set_valor_inicio(Expresion _valor_inicio) {
		this._valor_inicio = _valor_inicio;
	}
	public Expresion get_valor_final() {
		return _valor_final;
	}
	public void set_valor_final(Expresion _valor_final) {
		this._valor_final = _valor_final;
	}
	public boolean is_vacio() {
		return _vacio;
	}
	public void set_vacio(boolean _vacio) {
		this._vacio = _vacio;
	}


	/**
     * Returns the size of the type.
     * @return the size of the type.
     */
    @Override
    public int getSize ()
    {
        // TODO: Student work
        return 1;
    }
	  
}
