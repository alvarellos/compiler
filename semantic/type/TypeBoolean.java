package compiler.semantic.type;

import es.uned.lsi.compiler.semantic.ScopeIF;

public class TypeBoolean extends TypeSimple{

	public TypeBoolean(ScopeIF scope, String nameType) {
		super(scope, "Boolean");
	}
	
	public TypeBoolean() {
		super(null, "Boolean");
	}

	public TypeBoolean(ScopeIF scope) 
	{
		super(scope, "Boolean");		
	}
}
