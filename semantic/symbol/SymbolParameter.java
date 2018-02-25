package compiler.semantic.symbol;

import es.uned.lsi.compiler.intermediate.TemporalIF;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

/**
 * Class for SymbolVariable.
 */

// TODO: Student work
//       Include properties to characterize parameters

public class SymbolParameter
    extends SymbolVariable
{  
   
    // Variables
	private TemporalIF _temporal;
	private Integer _direccion;
	
	// Constructor
	public SymbolParameter(ScopeIF scope, String name, TypeIF type) {
		super(scope, name, type);
	}
	
    public SymbolParameter (String name, TypeIF type)
    {
        super (null, name, type);
    } 
	
	// Métodos
	public TemporalIF get_temporal() {
		return _temporal;
	}
	public void set_temporal(TemporalIF _temporal) {
		this._temporal = _temporal;
	}
	public Integer getAddress() {
		return _direccion;
	}
	public void setAddress(Integer _direccion) {
		this._direccion = _direccion;
	}
}
