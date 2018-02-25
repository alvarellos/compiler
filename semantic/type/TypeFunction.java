package compiler.semantic.type;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

import compiler.syntax.nonTerminal.DeclaracionListaParametros;
import compiler.syntax.nonTerminal.ListaParametros;
import es.uned.lsi.compiler.semantic.ScopeIF;

/**
 * Class for TypeFunction.
 */

// TODO: Student work
//       Include properties to characterize function declarations

public class TypeFunction
    extends TypeProcedure
{   
    
    private TreeMap tablaParametros = new TreeMap();
    private DeclaracionListaParametros _listaParametros;
    
	/**
     * Constructor for TypeFunction.
     * @param scope The declaration scope.
     */
    public TypeFunction (ScopeIF scope)
    {
        super (scope);
        _listaParametros = new DeclaracionListaParametros();
    }

    /**
     * Constructor for TypeFunction.
     * @param scope The declaration scope
     * @param name The name of the function.
     */
    public TypeFunction (ScopeIF scope, String name)
    {
        super (scope, name);
        _listaParametros = new DeclaracionListaParametros();
    }
    public void setParametros(DeclaracionListaParametros dlp){
    	_listaParametros = dlp;
    }
    public DeclaracionListaParametros getParametros(){return _listaParametros;}
    
    
    public TypeFunction(ScopeIF scope, String name, DeclaracionListaParametros listaParametros){
    	super (scope, name);
    	_listaParametros = listaParametros;
    }
    
    /**
     * Returns the size of the type.
     * @return the size of the type.
     */
    @Override
    public int getSize ()
    {
        // TODO: Student work
        return 1;
    }
    
    // Verifica si tiene parametros
    public boolean tieneParametros(){
    	if (_listaParametros == null)
    		return false;
    	
    	return (_listaParametros.getParametros().size() > 0);
    }
    
    // Compara Parametros
    public boolean comparaParametros(ListaParametros listaPar){
		// comprobar el numero de parametros

    	if (listaPar == null)
    		return (_listaParametros == null || _listaParametros.getParametros().size() == 0);
    	if (_listaParametros == null)
    		return (listaPar.getParametros().size() == 0);
    	
        if (listaPar.size()!=_listaParametros.getParametros().size())  return false;
           						
        return true;
    }
    
    
    public static ArrayList mapeadoLista(TreeMap tree) {
        ArrayList list = new ArrayList();
        Iterator it = tree.values().iterator();
        while (it.hasNext()) {
            list.add(it.next());
        }
        return list;
    }
    
}
