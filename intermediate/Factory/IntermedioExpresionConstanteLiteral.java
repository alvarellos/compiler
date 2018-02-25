package compiler.intermediate.Factory;

import compiler.CompilerContext;
import compiler.intermediate.Value;
import compiler.syntax.Expresion.ExpresionConstanteLiteral;
import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
import es.uned.lsi.compiler.intermediate.TemporalFactory;
import es.uned.lsi.compiler.intermediate.TemporalIF;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

public class IntermedioExpresionConstanteLiteral extends ExpresionConstanteLiteral {

	// Constructores
	public IntermedioExpresionConstanteLiteral() {
		super();
	}

	public IntermedioExpresionConstanteLiteral(TypeIF expresion, Boolean constValue) {
		super(expresion, constValue);
	}

	public IntermedioExpresionConstanteLiteral(TypeIF expresion, Integer constValue) {
		super(expresion, constValue);
	}

	// Métodos
	
	public void codigoIntermedio(Value val)
	{
		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();
		TemporalFactory tF = new TemporalFactory(scope);
		TemporalIF temp = tF.create();
		IntermediateCodeBuilder iCB = new IntermediateCodeBuilder(scope);
		
		iCB.addQuadruple("MOVE", temp, new Value(val));
		
		this.setTemporal(temp);
		this.setIntermediateCode(iCB.create());
	}
}
