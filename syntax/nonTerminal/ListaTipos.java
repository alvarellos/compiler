package compiler.syntax.nonTerminal;

import java.util.ArrayList;
import java.util.List;

public class ListaTipos extends NonTerminal{
	
    List<Object> variables = null;

    public ListaTipos() {
        this.variables = new ArrayList<Object>();
    }

    public ListaTipos(String item) {
        this.variables = new ArrayList<Object>();
        variables.add(item);
    }

    public ListaTipos(ListaTipos lista) {
        this.variables = new ArrayList<Object>();
            for (int i = 0; i < lista.size(); i++) {
            variables.add(lista.get(i));
        }
    }

    public boolean add(Object objeto) {
        return variables.add(objeto);
    }
    
    public boolean addLista(ListaTipos lista){
    	List<Object> variables_backup = variables;
    	for(int i=0; i<lista.size(); i++){
    		if (!variables.add(lista.get(i))){
    			variables = variables_backup;
    			return false;
    		}
    	}
    	
    	return true;
    }

    public int size() {
        return variables.size();
    }

    public Object get(int indice) {
        return variables.get(indice);
    }


    @Override
    public String toString() {
        return "" + variables.toString();
    }
    
    public List<Object> getVariables(){
    	return this.variables;
    }

}
