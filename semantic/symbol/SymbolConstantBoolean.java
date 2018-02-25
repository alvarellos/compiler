package compiler.semantic.symbol;

public class SymbolConstantBoolean extends SymbolConstant{
	
	// Variables
	private boolean resultado;
	
	// Constructor
	public SymbolConstantBoolean(String nombre, boolean resultado)
	{
		super(null, nombre, null);
		this.resultado = resultado;
	}

	// Métodos
	public boolean getResultado() {
		return resultado;
	}

	public void setResultado(boolean resultado) {
		this.resultado = resultado;
	}

}
