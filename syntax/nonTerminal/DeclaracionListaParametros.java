package compiler.syntax.nonTerminal;

import compiler.semantic.symbol.SymbolParameter;
import java.util.ArrayList;


public class DeclaracionListaParametros extends NonTerminal {
	private ArrayList<SymbolParameter> _listaParametros;

	public DeclaracionListaParametros(){
		_listaParametros = new ArrayList<SymbolParameter>();
	}
	public DeclaracionListaParametros(ArrayList<SymbolParameter> listaParametros){
		_listaParametros = listaParametros;
	}
	
	public ArrayList<SymbolParameter> getParametros(){
		return _listaParametros;
	}
	public void addParameter(SymbolParameter parametro){
		_listaParametros.add(parametro);
	}
	
	
}
