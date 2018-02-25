package compiler.syntax.nonTerminal;

import java.util.ArrayList;

import compiler.intermediate.Reference;

public class ListaParametros extends NonTerminal {
	
	ArrayList<Expresion> parametros = null;
	
	
	// Cambiar por ArrayList<Value>
	private ArrayList<Reference> _lista_parametros_actuales;

    public ListaParametros() {
        this.parametros = new ArrayList<Expresion>();
    }
    
	public ListaParametros(ArrayList<Expresion> parametros) {
		super();
		this.parametros = parametros;
	}
	

    public ListaParametros(ListaParametros lista) {
        this.parametros = new ArrayList<Expresion>();
            for (int i = 0; i < lista.size(); i++) {
            parametros.add(lista.get(i));
        }
    }
    
	
    public boolean add(Expresion objeto) {
        return parametros.add(objeto);
    }
	
	private Expresion get(int i) {
		return parametros.get(i);
	}

	public int size() {
		return parametros.size();
	}

	public ArrayList<Expresion> getParametros() {
		return parametros;
	}

	public void setParametros(ArrayList<Expresion> parametros) {
		this.parametros = parametros;
	}
	
	public ArrayList<Reference> getactualParametersReferenceList()
	{
		return _lista_parametros_actuales;
	}
	

}
