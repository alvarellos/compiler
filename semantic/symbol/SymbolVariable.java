package compiler.semantic.symbol;

import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.symbol.SymbolBase;
import es.uned.lsi.compiler.semantic.type.TypeIF;

/**
 * Class for SymbolVariable.
 */

// TODO: Student work
//       Diego Díaz Alvarellos

public class SymbolVariable
    extends SymbolBase
{  
	
	private int desplazamiento, anidamientoReg;
	private Integer _direccion;
	private int entera;
	private boolean inicializada=false;
	private TypeIF tipo;

	public TypeIF getTipo() {
	return tipo;
}


public void setTipo(TypeIF tipo) {
	this.tipo = tipo;
}


	public boolean isInicializada() {
	return inicializada;
}


public void setInicializada(boolean inicializada) {
	this.inicializada = inicializada;
}


	public int getEntera() {
	return entera;
}


public void setEntera(int entera) {
	this.entera = entera;
}


	// Constructores
    /**
     * Constructor for SymbolVariable.
     * @param scope The declaration scope.
     * @param name The symbol name.
     * @param type The symbol type.
     */
    public SymbolVariable (ScopeIF scope, 
                           String name,
                           TypeIF type)
    {
        super (scope, name, type);
    } 
    
    
    // Nuevos
    
    

    
    
    
    public SymbolVariable (String name, TypeIF type)
    {
        super (null, name, type);
    }
    
    public SymbolVariable(ScopeIF scope, String name, TypeIF type, int entera) {
		super(scope, name, type);
		this.entera = entera;
	}

    public SymbolVariable(ScopeIF scope, String name, TypeIF type, int entera, boolean ini) {
		super(scope, name, type);
		this.entera = entera;
		this.inicializada = ini;
	}

	public SymbolVariable (ScopeIF scope, 
            String name)
    {
    	super (scope, name, null);
    } 
    
    
    
    // Métodos
    
    
	public Integer getAddress() {
		return _direccion;
	}

	public void setAddress(Integer _direccion) {
		this._direccion = _direccion;
	} 
    
    // Getters and setters
    
	public int getDesplazamiento() {
		return desplazamiento;
	}


	public void setDesplazamiento(int desplazamiento) {
		this.desplazamiento = desplazamiento;
	}



	
	public int getAnidamientoReg() {
		return anidamientoReg;
	}


	public void setAnidamientoReg(int anidamientoReg) {
		this.anidamientoReg = anidamientoReg;
	}


	public Integer get_direccion() {
		return _direccion;
	}


	public void set_direccion(Integer _direccion) {
		this._direccion = _direccion;
	}
	
	// fin getters and setters
    
    
}
