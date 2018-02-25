package compiler.intermediate;

import java.util.HashMap;

import compiler.semantic.symbol.SymbolParameter;
import compiler.semantic.symbol.SymbolVariable;
import es.uned.lsi.compiler.intermediate.VariableIF;
import es.uned.lsi.compiler.semantic.ScopeIF;

/**
 * Class for variables in intermediate code.
 */

public class Variable
    implements VariableIF 
{
    private String  name     = null;
    private ScopeIF scope    = null;
      
    // Nuevo
    private ScopeIF ambito;
	private SymbolVariable  _simboloVariable;
	private SymbolParameter _simboloParametro;
	private boolean         _isParameter;
    
	private HashMap _tablaDesplazamiento = new HashMap();
    private int _desplazamientoCampo;   // Utilizada unicamente para registros
    

    
    // fin nuevo
        
    /**
     * Constructor for Variable.
     * @param name The name.
     * @param scope The scope index.
     */
    public Variable (String name, ScopeIF scope)
    {
        super ();
        this.name = name;
        this.scope = scope;
    }

        
    // Nuevo constructor (recoge símbolo de una variable)
    public Variable(SymbolVariable simbolo) {
        this(simbolo.getName(), simbolo.getScope());
        this._isParameter = false;
        this._simboloVariable = simbolo;  
		// TODO Auto-generated constructor stub
	}

    // Nuevo constructor (recoge el símbolo de un parámetro)
	public Variable(SymbolParameter simbolo) {
        this(simbolo.getName(), simbolo.getScope());
        this._isParameter = true;
        this._simboloParametro = simbolo;  
		// TODO Auto-generated constructor stub
	}
    
    
    
    /**
     * Returns the name.
     * @return Returns the name.
     */
    @Override
    public final String getName ()
    {
        return name;
    }

    /**
     * Returns the scope.
     * @return Returns the scope.
     */
    @Override
    public final ScopeIF getScope ()
    {
        return scope;
    }

    /**
     * Returns the address.
     * @return Returns the address.
     */
    @Override
    public final int getAddress ()
    {
        // TODO : Student Work -- Diego Diaz
        if(_isParameter)
        {
        	return this._simboloParametro.getAddress();
        }
        else
        {
        	 return this._simboloVariable.getAddress();
        }
    }

    /**
     * Indicates whether the address is a global address.
     * @return true if the address is a global address.
     */
    @Override
    public final boolean isGlobal ()
    {
        // TODO : Student Work -- Diego Diaz
        return  (scope.getLevel() == 0);
    }
    

    public final boolean isLocal ()
    {
        // TODO : Student Work -- Diego Diaz
        return  (scope.getLevel() == 1);
    }

    /**
     * Compares this object with another one.
     * @param other the other object.
     * @return true if both objects has the same properties.
     */
    @Override
    public final boolean equals (Object other)
    {
        if (other == null) 
        {
            return false;
        }
        if (this == other)
        {
            return true;
        }
        if (!(other instanceof Variable))
        {
            return false;
        }
        
        final Variable aVariable = (Variable) other;
        return ((scope   == null) ? (aVariable.scope == null) : (aVariable.scope.equals (scope))) && 
               ((name    == null) ? (aVariable.name  == null) : (aVariable.name.equals (name)));
    }

    /**
     * Returns a hash code for the object.
     */
    @Override
    public final int hashCode ()
    {
        return 31 * scope.hashCode() +
                  ((name == null)? 0 : name.hashCode ());
    } 

    /**
     * Return a string representing the object.
     * @return a string representing the object.
     */
    @Override
    public final String toString ()
    {    
        return name;
    }
    
    
    // Nuevos métodos
    
    public final boolean isNotLocal(int level) 
    {	
    	return (level != scope.getLevel());
	}

	public SymbolVariable getSymbolVariable() 
	{
		return _simboloVariable;
	}

	public SymbolParameter getSymbolParameter() 
	{
		return _simboloParametro;
	}

	public boolean isParameter() 
	{
		return _isParameter;
	}


    public ScopeIF getAmbito() {
        return ambito;
    }
    
    // Desplazamiento de los campos de los registros
    
    public HashMap getTablaDesplazamiento() {
		return _tablaDesplazamiento;
	}

	public void setTablaDesplazamiento(HashMap tablaDesplazamiento) {
		this._tablaDesplazamiento = tablaDesplazamiento;
	}

	public int getDesplazamientoCampo() {
		return _desplazamientoCampo;
	}

	public void setDesplazamientoCampo(int desplCampo) {
		this._desplazamientoCampo = desplCampo;
	}

    public void setAmbito(ScopeIF ambito) {
        this.ambito = ambito;
        
    }
	
	
    
	// fin nuevos
}
