package compiler.semantic.symbol;

import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

public class SymbolReturn extends SymbolVariable {

	public SymbolReturn(ScopeIF scope, String name, TypeIF type, int desplazamiento) {
		super(scope, name, type, desplazamiento);
	}

	public SymbolReturn(ScopeIF scope, String name, TypeIF type) {
		super(scope, name, type);
	}

	public SymbolReturn(ScopeIF scope, String name) {
		super(scope, name);
	}

}
