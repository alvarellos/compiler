package compiler.syntax.nonTerminal;

public class Subprograma extends Axiom {

	// Variables de clase
	private CuerpoFuncion bloque;
	
	// Constructores
	public Subprograma() {
		super();
	}
	
	public Subprograma(CuerpoFuncion block) {
		this.bloque = block;
	}

	public CuerpoFuncion getBloque() {
		return bloque;
	}

	public void setBloque(CuerpoFuncion bloque) {
		this.bloque = bloque;
	}

	
	
}
