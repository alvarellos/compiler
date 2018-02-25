package compiler.syntax.nonTerminal;

import java.util.ArrayList;

public class Subprogramas extends Axiom {

	
	private Subprogramas _subprogramas;
	private ArrayList<Subprograma> _listaSubprogramas; 
	

	// Constructores
	
	public Subprogramas() {
		super();
		this._listaSubprogramas = new ArrayList<Subprograma>();
	}
	
	
	// Metodos
	public Subprogramas get_subprogramas() {
		return _subprogramas;
	}

	public void set_subprogramas(Subprogramas _subprogramas) {
		this._subprogramas = _subprogramas;
	}


	public ArrayList<Subprograma> getListaSubprogramas() 
	{
		return _listaSubprogramas;
	}


	public void addSubprograma(Subprograma funcion)
	{
		this._listaSubprogramas.add(funcion);
		this.getIntermediateCode().addAll(funcion.getIntermediateCode());
	}	
	
	public void addSubprograma(Subprogramas funcion)
	{
		this.getIntermediateCode().addAll(funcion.getIntermediateCode());
	}
	
	public void addSubprogramas(ArrayList<Subprograma> list)
	{
		int i=0;
		for(Subprograma s:list){
			this._listaSubprogramas.add(s);
			this.getIntermediateCode().addAll(s.getIntermediateCode());
			i++;
		}
	}
	
	
	
	
}
