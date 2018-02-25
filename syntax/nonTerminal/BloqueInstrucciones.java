package compiler.syntax.nonTerminal;

import java.util.ArrayList;

public class BloqueInstrucciones extends Sentencia {
	
	
	private ArrayList<Sentencia> _listaInstrucciones; 
	
	public BloqueInstrucciones() {
		super();
		this._listaInstrucciones = new ArrayList<Sentencia>();
	}

	public ArrayList<Sentencia> getListaSentencias() 
	{
		return _listaInstrucciones;
	}

	public void addInstruccion(Sentencia statement)
	{
		this._listaInstrucciones.add(statement);
		this.getIntermediateCode().addAll(statement.getIntermediateCode());
	}	
	public void addInstrucciones(ArrayList<Sentencia> list)
	{
		for(Sentencia s:list){
			this._listaInstrucciones.add(s);
			this.getIntermediateCode().addAll(s.getIntermediateCode());
		}
	}
	
	
}
