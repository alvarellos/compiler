package compiler.intermediate.Factory;

import compiler.CompilerContext;
import compiler.syntax.Expresion.ExpresionIGUAL;
import compiler.syntax.nonTerminal.Expresion;
import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
import es.uned.lsi.compiler.intermediate.TemporalFactory;
import es.uned.lsi.compiler.intermediate.TemporalIF;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

public class IntermedioExpresionIGUAL extends ExpresionIGUAL{
	
	// Constructores
	public IntermedioExpresionIGUAL() {
		super();
	}

	public IntermedioExpresionIGUAL(TypeIF expresion) {
		super(expresion);
	}

	// Métodos
	public void codigoIntermedio(Expresion exp1, Expresion exp2)
	{
		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();
		
		IntermediateCodeBuilder iCB = new IntermediateCodeBuilder(scope);
		TemporalFactory tF = new TemporalFactory(scope);
		TemporalIF temp = tF.create();

		iCB.addQuadruples(exp1.getIntermediateCode());
		nullTemporalManagement(exp1, iCB);
		TemporalIF temp1 = exp1.getTemporal();

		iCB.addQuadruples(exp2.getIntermediateCode());
		nullTemporalManagement(exp2, iCB);
		TemporalIF temp2 = exp2.getTemporal();

		iCB.addQuadruple("IGUAL", temp, temp1, temp2);

		this.setTemporal(temp);
		this.setIntermediateCode(iCB.create());
	}

}
