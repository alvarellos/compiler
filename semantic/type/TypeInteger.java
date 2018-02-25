package compiler.semantic.type;

import es.uned.lsi.compiler.semantic.ScopeIF;

public class TypeInteger extends TypeSimple{

	public static final int MINVALUE = -32728;
	public static final int MAXVALUE = 32727;
	
	
	// Constructores
	public TypeInteger(ScopeIF scope, String nameType) {
		super(scope, "Integer");
	}
	
	public TypeInteger() {
		super(null, "Integer");
	}

	public TypeInteger(ScopeIF scope) 
	{
		super(scope, "Integer");
	}
	
	
	public static boolean EsEntero(String valor, boolean negativos){
		try{
			int i = Integer.parseInt(valor);
			int min = MINVALUE;
			if (negativos){
				min = 0;
			}
			return (i>= min && i<=MAXVALUE);
		}catch(Exception e){
			return false;
		}
	}
	
}
