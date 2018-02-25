package compiler.intermediate.Factory;

import compiler.CompilerContext;
import compiler.intermediate.Value;
import compiler.semantic.symbol.SymbolReturn;
import compiler.syntax.nonTerminal.Expresion;
import compiler.syntax.nonTerminal.SentenciaReturn;
import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
import es.uned.lsi.compiler.intermediate.TemporalIF;
import es.uned.lsi.compiler.semantic.ScopeIF;

public class IntermedioSentenciaRETURN extends SentenciaReturn{
	
	private Expresion _expresion;
	private SymbolReturn _simbolo;

	public IntermedioSentenciaRETURN() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IntermedioSentenciaRETURN(Expresion expresion) {
		super(expresion);
		// TODO Auto-generated constructor stub
	}
	
	public IntermedioSentenciaRETURN(Expresion _expresion, SymbolReturn _simbolo) {
		super(_expresion);
		this._expresion = _expresion;
		this._simbolo = _simbolo;
	}

	public Expresion get_expresion() {
		return _expresion;
	}

	public void set_expresion(Expresion _expresion) {
		this._expresion = _expresion;
	}
	
	public void codigoIntermedio(){
		
		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();
		IntermediateCodeBuilder iCB = new IntermediateCodeBuilder(scope);
		iCB.addQuadruples(_expresion.getIntermediateCode());
		

		TemporalIF expFirstTemp = _expresion.getTemporal();		
		
		// Algo tengo que hacer con la expresión que recibo
		 iCB.addQuadruples(_expresion.getIntermediateCode());
		
		nullTemporalManagement(_expresion, iCB);
		
		iCB.addQuadruple("RET", expFirstTemp, new Value(scope.getLevel()));
		
		this.setIntermediateCode(iCB.create());
		
		
		
	}

}
