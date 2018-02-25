package compiler.syntax.nonTerminal;

import java.util.ArrayList;

public class Sentencias extends NonTerminal{
	
	private ArrayList<Sentencia> _listaSentencias; 
	
	public Sentencias() {
		super();
		this._listaSentencias = new ArrayList<Sentencia>();
	}

	public ArrayList<Sentencia> getListaSentencias() 
	{
		return _listaSentencias;
	}

	public void addSentencia(Sentencia statement)
	{
		this._listaSentencias.add(statement);
		this.getIntermediateCode().addAll(statement.getIntermediateCode());
	}	
	
	public void addSentencias(ArrayList<Sentencia> list)
	{
		for(Sentencia s:list){
			this._listaSentencias.add(s);
			this.getIntermediateCode().addAll(s.getIntermediateCode());
		}
	}
}
