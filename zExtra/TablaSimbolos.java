package compiler.zExtra;

import compiler.semantic.symbol.SymbolConstantBoolean;
import compiler.semantic.symbol.SymbolConstantInteger;
import compiler.semantic.symbol.SymbolFunction;
import compiler.semantic.symbol.SymbolProcedure;
import compiler.semantic.type.TypeBoolean;
import compiler.semantic.type.TypeInteger;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.ScopeManagerIF;
import es.uned.lsi.compiler.semantic.symbol.SymbolIF;
import es.uned.lsi.compiler.semantic.symbol.SymbolTableIF;

public class TablaSimbolos {

	// Variables
	private ScopeManagerIF _scopeManager;
	
	// Constructores
	public TablaSimbolos(ScopeManagerIF scopeManager)
	{	
		this._scopeManager = scopeManager;
	}
	
	// Métodos
	
	// Verifica si simbolo está registrado
	public boolean containsSymbol(String sName)
	{
		// Comprobación de la unicidad del símbolo.		
		return _scopeManager.containsSymbol(sName);
	}
	
	// Devuelve símbolo si registrado
	public SymbolIF searchSymbol(String nombre)
	{	
		return _scopeManager.searchSymbol(nombre);
	}	
	
	// Añadir Símbolo
	public boolean addSymbol(SymbolIF symbol)
	{	
		// Recuperación del ámbito.
		ScopeIF scope;
		
		if((symbol instanceof SymbolProcedure) || (symbol instanceof SymbolFunction))
		{
			scope = _scopeManager.getParentScope();
		}
		else
		{
			scope = _scopeManager.getCurrentScope();			
		}
		
		// Comprobación de la unicidad del símbolo.
		SymbolTableIF sTable = scope.getSymbolTable();
		
		if(sTable.containsSymbol(symbol.getName()))
		{
			// Símbolo duplicado.
			return false;
		}
		
		// Registro del símbolo
		if(symbol instanceof SymbolConstantInteger)
		{		
			symbol.setType(new TypeInteger());
		}
		else if(symbol instanceof SymbolConstantBoolean)
		{	
			symbol.setType(new TypeBoolean());
		}
		
		symbol.setScope(scope);
		sTable.addSymbol(symbol.getName(), symbol);
		
		return true;
	}	
	
	
}
