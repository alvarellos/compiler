package compiler.intermediate.Factory;

import compiler.CompilerContext;
import compiler.intermediate.Reference;
import compiler.intermediate.Temporal;
import compiler.intermediate.Value;
import compiler.semantic.symbol.SymbolVariable;
import compiler.syntax.nonTerminal.DeclaracionVariables;
import compiler.syntax.nonTerminal.TokenVar;
import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
import es.uned.lsi.compiler.intermediate.TemporalFactory;
import es.uned.lsi.compiler.intermediate.TemporalIF;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.symbol.SymbolIF;

public class IntermedioDeclaracionVariables extends DeclaracionVariables{
	
	// Variables
	private SymbolIF _simbolo;
	private TokenVar _token;
	

	
	
	// Constructores
	
	public IntermedioDeclaracionVariables() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Variable entera
	public IntermedioDeclaracionVariables(SymbolIF simbolo, TokenVar token) {
		super();
		this._simbolo = simbolo;
		this._token = token;
		// TODO Auto-generated constructor stub
	}



	
	// ----------

	public void codigoIntermedio()
	{
		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();
		IntermediateCodeBuilder iCB = new IntermediateCodeBuilder(scope);
		
		TemporalFactory tF = new TemporalFactory(scope);
		Temporal temp = (Temporal) tF.create();
	
		TemporalIF expFirstTemp = _token.getTemporal();		
		
		iCB.addQuadruples(_token.getIntermediateCode());
		
		
		nullTemporalManagementToken(_token, iCB);
		
		SymbolVariable sV = (SymbolVariable) _simbolo;
		iCB.addQuadruple("MOVE", temp, new Value(sV.getEntera()));	
		
		Reference ref = new Reference(_simbolo);
		
		
		
		TemporalIF rTemp = ref.get_temporal();
		
		
		TemporalIF expSecondTemp = _token.getSecondTemporal();

		
		iCB.addQuadruples(ref.getICB().create());	
		
		
		iCB.addQuadruple("STP", rTemp, temp, expSecondTemp);
		
		this.setIntermediateCode(iCB.create());
	
   System.out.println(iCB);
		
		
	}


}
