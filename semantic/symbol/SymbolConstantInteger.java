package compiler.semantic.symbol;

public class SymbolConstantInteger extends SymbolConstant {
	
	
	// Variables
	private int entera;
	
	// Constructor
	
	public SymbolConstantInteger(String nombre, int entera)
	{
		super(null, nombre, null);
		this.entera = entera;
	}

	// Métodos
	public int getEntera() {
		return entera;
	}

	public void setEntera(int entera) {
		this.entera = entera;
	}

}
