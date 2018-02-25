package compiler.semantic.type;

import java.util.HashMap;

import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.symbol.SymbolIF;
import es.uned.lsi.compiler.semantic.type.TypeBase;
import es.uned.lsi.compiler.semantic.type.TypeIF;

/**
 * Class for TypeRecord.
 */

// TODO: Student work
//       Diego Díaz Alvarellos

public class TypeRecord
    extends TypeBase
{   
       
	private HashMap<String, SymbolIF> camposTabla = new HashMap<String, SymbolIF>();
	private int totales;
	
	// Constructores de la clase Registro
    /**
     * Constructor for TypeRecord.
     * @param scope The declaration scope.
     */
    public TypeRecord (ScopeIF scope)
    {
        super (scope);
    }

    /**
     * Constructor for TypeRecord.
     * @param scope The declaration scope.
     * @param name The name of the type.
     */
    public TypeRecord (ScopeIF scope, String name)
    {   
        super (scope, name);
    }
   
    /**
     * Constructor for TypeRecord.
     * @param record The record to copy.
     */
    public TypeRecord (TypeRecord record)
    {
        super (record.getScope (), record.getName ());
    } 
    
    // Métodos
    
    // Getters and Setters
    
    /**
     * Returns the size of the type.
     * @return the size of the type.
     */
    @Override
    public int getSize ()
    {
        // TODO: Student work
    	// Diego Diaz
        return this.totales;
    }
    
    public void setSize (int totales)
    {
        this.totales=totales;
    }

	public HashMap<String, SymbolIF> getCamposTabla() {
		return camposTabla;
	}

	public void setCamposTabla(HashMap<String, SymbolIF> camposTabla) {
		this.camposTabla = camposTabla;
	}

	public int getTotales() {
		return totales;
	}

	public void setTotales(int totales) {
		this.totales = totales;
	}
    
    // fin getters and setters
	
	// Recuperar tipo campo registro
    public TypeIF getTypeCampo(String nombre){
        SymbolIF simbolo= (SymbolIF) this.getCamposTabla().get(nombre);
        
        // Debe existir simbolo
        if (simbolo != null) {
            TypeIF tipo = simbolo.getType();
            //  Debe ser de tipo valido (entero o registro)
            if (tipo != null && tipo instanceof TypeIF) {
                   return (TypeIF) tipo;
            } else
                return null;
        }else
                return null;
        
    }
	
    
    
    public boolean contieneCampo (String nombre)
    {
        return this.getCamposTabla().containsKey(nombre);
    }
    
    public void addCampos (String nombre, SymbolIF simbolo)
    {
        this.getCamposTabla().put(nombre, simbolo);
    
    }


	public boolean is_vacio() {
		return false;
	}
    
   
    
    
}
