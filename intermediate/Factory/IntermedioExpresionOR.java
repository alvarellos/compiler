package compiler.intermediate.Factory;

import compiler.CompilerContext;
import compiler.syntax.Expresion.ExpresionOR;
import compiler.syntax.nonTerminal.Expresion;
import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
import es.uned.lsi.compiler.intermediate.TemporalFactory;
import es.uned.lsi.compiler.intermediate.TemporalIF;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

public class IntermedioExpresionOR extends ExpresionOR{

	
	public IntermedioExpresionOR() {
		super();
	}

	public IntermedioExpresionOR(TypeIF expresion) {
		super(expresion);
	}

	public void codigoIntermedio(Expresion exp1, Expresion exp2)
	{
		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();
		
		IntermediateCodeBuilder iCb = new IntermediateCodeBuilder(scope);
		TemporalFactory tF = new TemporalFactory(scope);
		TemporalIF temp = tF.create();

		iCb.addQuadruples(exp1.getIntermediateCode());
		nullTemporalManagement(exp1, iCb);
		TemporalIF temp1 = exp1.getTemporal();

		iCb.addQuadruples(exp2.getIntermediateCode());
		nullTemporalManagement(exp2, iCb);
		TemporalIF temp2 = exp2.getTemporal();

		// Operación lógica OR
		iCb.addQuadruple("OR", temp, temp1, temp2);

		this.setTemporal(temp);
		this.setIntermediateCode(iCb.create());
	}
}
