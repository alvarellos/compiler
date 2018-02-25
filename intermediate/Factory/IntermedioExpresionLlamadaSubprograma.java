package compiler.intermediate.Factory;

import java.util.ArrayList;

import compiler.CompilerContext;
import compiler.intermediate.Procedure;
import compiler.intermediate.Temporal;
import compiler.intermediate.Variable;
import compiler.semantic.symbol.SymbolFunction;
import compiler.semantic.symbol.SymbolProcedure;
import compiler.semantic.symbol.SymbolVariable;
import compiler.syntax.Expresion.ExpresionLlamadaSubprograma;
import compiler.syntax.nonTerminal.Expresion;
import compiler.syntax.nonTerminal.LlamadaSubprograma;
import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
import es.uned.lsi.compiler.intermediate.TemporalFactory;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.symbol.SymbolIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

public class IntermedioExpresionLlamadaSubprograma extends ExpresionLlamadaSubprograma{

	private LlamadaSubprograma _llamadaSubprograma;
	private SymbolIF _simbolo;
	
	// Constructores
	public IntermedioExpresionLlamadaSubprograma() {
		super();
	}

	public IntermedioExpresionLlamadaSubprograma(TypeIF expresion) {
		super(expresion);
	}
	
	public IntermedioExpresionLlamadaSubprograma(LlamadaSubprograma llamadaSubprograma) {

		this._llamadaSubprograma = llamadaSubprograma;
	}
	
	public IntermedioExpresionLlamadaSubprograma(SymbolFunction symbol, LlamadaSubprograma llamadaSubprograma) {

		super(symbol.get_devuelve_tipo());
		this._llamadaSubprograma = llamadaSubprograma;
	}
	
	
	@SuppressWarnings("null")
	public void codigoIntermedio()
	{
		String nameSubprogram = _llamadaSubprograma.getId().getLexema();
		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();
		IntermediateCodeBuilder iCB = new IntermediateCodeBuilder(scope);
		SymbolProcedure sProcedure = (SymbolProcedure)CompilerContext.getScopeManager().searchSymbol(nameSubprogram);
		ScopeIF sPScope = sProcedure.getScope();										
		
		ArrayList<Expresion> actualParametersReferenceList = _llamadaSubprograma.getParametrosSubprograma().getParametros();					

		
		Procedure procedure = new Procedure(nameSubprogram, sPScope);

		int actualParamsSize;
		
		if (actualParametersReferenceList == null){
			actualParamsSize = 0;
		}
		
		else { 
			actualParamsSize = actualParametersReferenceList.size();
		}
		

		if(actualParamsSize != 0)
		{
			
			// Se asignan los parámetros actuales a los formales.
			sProcedure.asignarActualesAFormales(actualParametersReferenceList);
			procedure.set_formalParametersList(sProcedure.get_lista_parametros_formales());
			
			for (int i = 0; i < actualParamsSize; i++)
			{

				Expresion expresion = (Expresion)actualParametersReferenceList.get(i);

				expresion.get_id();
				SymbolIF simbolo = scope.getScopeManager().searchSymbol(expresion.get_id());
				this._simbolo = simbolo;
	
				Variable var = null;
				var = new Variable((SymbolVariable) _simbolo);

				iCB.addQuadruple("MVA", expresion.getTemporal(), var);		
				iCB.addQuadruple("PARAM", expresion.getTemporal(), i);

				// Para el paso por valor --
				// Si nombre de parámetro formal = nombre de parámetro actual entonces :
				// 
				// 1. Se añaden el siguiente código.
				// 2. Comentar la cuádrupla "PARAM" de arriba
				// ----------------------------------------------------------
				// TemporalFactory tF = new TemporalFactory(scope);		
				// Temporal temp = (Temporal) tF.create();
				// temp.setContainRefenceAddress(false);
				// iCB.addQuadruple("MVP", temp, expresion.getTemporal());
				// iCB.addQuadruple("PARAM", temp, i);				
				// ----------------------------------------------------------
				
			}
		}					

		iCB.addQuadruple("CALL", procedure);
		
		TemporalFactory tF = new TemporalFactory(scope);		
		Temporal temp1 = (Temporal) tF.create();
		iCB.addQuadruple("GETR1", temp1);
		this.setTemporal(temp1);
		
		this.setIntermediateCode(iCB.create());
	}
	

}
