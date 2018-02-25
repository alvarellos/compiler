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
	
	// M�todos
	
	// Verifica si simbolo est� registrado
	public boolean containsSymbol(String sName)
	{
		// Comprobaci�n de la unicidad del s�mbolo.		
		return _scopeManager.containsSymbol(sName);
	}
	
	// Devuelve s�mbolo si registrado
	public SymbolIF searchSymbol(String nombre)
	{	
		return _scopeManager.searchSymbol(nombre);
	}	
	
	// A�adir S�mbolo
	public boolean addSymbol(SymbolIF symbol)
	{	
		// Recuperaci�n del �mbito.
		ScopeIF scope;
		
		if((symbol instanceof SymbolProcedure) || (symbol instanceof SymbolFunction))
		{
			scope = _scopeManager.getParentScope();
		}
		else
		{
			scope = _scopeManager.getCurrentScope();			
		}
		
		// Comprobaci�n de la unicidad del s�mbolo.
		SymbolTableIF sTable = scope.getSymbolTable();
		
		if(sTable.containsSymbol(symbol.getName()))
		{
			// S�mbolo duplicado.
			return false;
		}
		
		// Registro del s�mbolo
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
