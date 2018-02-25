package compiler.semantic.symbol;

import java.util.ArrayList;

import compiler.syntax.nonTerminal.Expresion;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.symbol.SymbolBase;
import es.uned.lsi.compiler.semantic.type.TypeIF;

/**
 * Class for SymbolProcedure.
 */

// TODO: Student work
//       Include properties to characterize procedure calls

public class SymbolProcedure
    extends SymbolBase
{
   
	// Variables
	private TypeIF _devuelve_tipo;
	private ArrayList<SymbolParameter> _lista_parametros_formales;

	
	// Constructores
	public SymbolProcedure(ScopeIF scope, String name, TypeIF type) {
		super(scope, name, type);
	}
   
    public SymbolProcedure (ScopeIF scope, String name, TypeIF type, ArrayList<SymbolParameter> symbolParameters)
    {
        super (null, name, type);
        this._lista_parametros_formales = symbolParameters;
    }
    
 

    // Métodos
    
	public TypeIF get_devuelve_tipo() {
		return _devuelve_tipo;
	}
	
	public void set_devuelve_tipo(TypeIF devuelve_tipo) {
		this._devuelve_tipo = devuelve_tipo;
	}
	
	public ArrayList<SymbolParameter> get_lista_parametros_formales() {
		return _lista_parametros_formales;
	}

	public void set_lista_parametros_formales(ArrayList<SymbolParameter> _lista_parametros_formales) {
		this._lista_parametros_formales = _lista_parametros_formales;
	} 



	// Asignar parametros actuales a formales 
	
	public void asignarActualesAFormales(ArrayList<Expresion> actualParametersReferenceList)
	{
		for (int i = 0; i < this._lista_parametros_formales.size(); i++)
		{	
			this._lista_parametros_formales.get(i).set_temporal(actualParametersReferenceList.get(i).getTemporal());
		}
	}  	
}
