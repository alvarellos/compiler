	package compiler.semantic.symbol;

import java.util.ArrayList;

import compiler.syntax.nonTerminal.Expresion;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

/**
 * Class for SymbolFunction.
 */

// TODO: Student work
//       Include properties to characterize function calls

public class SymbolFunction
    extends SymbolProcedure
{
      
	// Variables
	private TypeIF _devuelve_tipo;
	private ArrayList<SymbolParameter> _lista_parametros_formales = null;
	
	// private ArrayList<Expresion> _parametros_funcion;

	// Constructores
	public SymbolFunction(ScopeIF scope, String name, TypeIF type) {
		super(scope, name, type);
	}
	
    public SymbolFunction (ScopeIF scope, String name, TypeIF type, ArrayList<SymbolParameter> symbolParameters, TypeIF returnType)
    {
    	super(null,name,type);
        this._devuelve_tipo = returnType;
        this._lista_parametros_formales = symbolParameters;
    }

    // Métodos
	public TypeIF get_devuelve_tipo() {
		return _devuelve_tipo;
	}

	public void set_devuelve_tipo(TypeIF devuelve_tipo) {
		this._devuelve_tipo = devuelve_tipo;
	}
	
//------
	public ArrayList<SymbolParameter> get_lista_parametros_formales() {
		return _lista_parametros_formales;
	}
    
	public void set_lista_parametros_formales(ArrayList<SymbolParameter> _lista_parametros_formales) {
		this._lista_parametros_formales = _lista_parametros_formales;
	} 


	// Asignar parametros actuales a formales
	
	public void asignarActualesAFormales(ArrayList<Expresion> actualParameters)
	{
		for (int i = 0; i < this._lista_parametros_formales.size(); i++)
		{	
			this._lista_parametros_formales.get(i).set_temporal(actualParameters.get(i).getTemporal());
		}
	}  	
}
