package compiler.zExtra;

import compiler.semantic.type.TypeProcedure;
import compiler.semantic.type.TypeFunction;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.ScopeManagerIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;
import es.uned.lsi.compiler.semantic.type.TypeTableIF;

public class TablaTipos {

	// Variables
	ScopeManagerIF _scopeManager;	
	
	// Constructores
	public TablaTipos(ScopeManagerIF scopeManager)
	{	
		this._scopeManager = scopeManager;
	}
	
	// METODOS

	// Contiene tipo
	public boolean containsType(String sName){
		ScopeIF scope = _scopeManager.getCurrentScope();
		return containsType(sName, scope, false);
	}
	public boolean containsType(String sName, boolean soloLocal){
		ScopeIF scope = _scopeManager.getCurrentScope();
		return containsType(sName, scope, soloLocal);
	}
	public boolean containsType(String sName, ScopeIF scope, boolean soloLocal)
	{
		boolean encontrado = false;
		TypeTableIF tTable = scope.getTypeTable();
		encontrado = tTable.containsType(sName);

		if (!soloLocal){
			while (!encontrado && scope.getLevel() > 0){
				scope = _scopeManager.getParentScope();
				tTable = scope.getTypeTable();
				encontrado = tTable.containsType(sName);
			}
		}
		
		return encontrado; 
	}
	

	// Añadir tipo
	public boolean addType(TypeIF type)
	{
		// Se comprueba la unicidad del Tipo
		ScopeIF scope;
		
		if((type instanceof TypeProcedure) || (type instanceof TypeFunction))
		{
			scope = _scopeManager.getParentScope();
		}
		else
		{			
			scope = _scopeManager.getCurrentScope();
		}		
		
		TypeTableIF tTable = scope.getTypeTable();
		
		if (this.containsType(type.getName(), scope, true))
		{
			// Tipo duplicado
			return false;
		}	
		
		type.setScope(scope);
		tTable.addType(type);
		return true;			
	}	
	
	// Devuelve tipo si existe
	public TypeIF getType(String sName)
	{
		TypeIF type = _scopeManager.searchType(sName);
		
		return type;
	}	
	
}
