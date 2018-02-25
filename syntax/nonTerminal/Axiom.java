package compiler.syntax.nonTerminal;


/**
 * Abstract Class for Axiom non terminal.
 */
public abstract class Axiom
    extends NonTerminal
{
	
	private Subprogramas _listaSubprogramas;
	
    public Subprogramas get_listaSubprogramas() {
		return _listaSubprogramas;
	}

	public void set_listaSubprogramas(Subprogramas _listaSubprogramas) {
		this._listaSubprogramas = _listaSubprogramas;
	}

	/**
     * Constructor for Axiom.
     */
    public Axiom ()
    {
        super (); 
    }
}
