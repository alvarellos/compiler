package compiler.intermediate.Factory;

import compiler.CompilerContext;
import compiler.intermediate.Reference;
import compiler.intermediate.Value;
import compiler.semantic.symbol.SymbolReturn;
import compiler.semantic.type.TypeRecord;
import compiler.syntax.Expresion.ExpresionAsignacion;
import compiler.syntax.nonTerminal.Expresion;
import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
import es.uned.lsi.compiler.intermediate.TemporalFactory;
import es.uned.lsi.compiler.intermediate.TemporalIF;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.symbol.SymbolIF;

public class IntermedioExpresionAsignacion extends ExpresionAsignacion{
	
	// Variables
	private SymbolIF _simbolo;
	private SymbolIF _simbolo2;
	private SymbolIF _simbolo3;
	private Expresion _expresion;
	
	
	// Constructores
	
	public IntermedioExpresionAsignacion() {
		super();
	}

	// Variable entera
	public IntermedioExpresionAsignacion(SymbolIF simbolo, Expresion expresion) {
		super();
		this._simbolo = simbolo;
		this._expresion = expresion;
	}

	// Registros
	public IntermedioExpresionAsignacion(SymbolIF simbolo, SymbolIF simbolo2, Expresion expresion) {
		super();
		this._simbolo = simbolo;
		this._simbolo2 = simbolo2;
		this._expresion = expresion;
	}
	
	
	// Registros con anidamiento
	public IntermedioExpresionAsignacion(SymbolIF simbolo, SymbolIF simbolo2, SymbolIF simbolo3, Expresion expresion) {
		super();
		this._simbolo = simbolo;
		this._simbolo2 = simbolo2;
		this._simbolo3 = simbolo3;
		this._expresion = expresion;
	}
	

	// Métodos


	public void codigoIntermedio()
	{
		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();
		IntermediateCodeBuilder iCB = new IntermediateCodeBuilder(scope);
		

		TemporalIF expFirstTemp = _expresion.getTemporal();		
		
		iCB.addQuadruples(_expresion.getIntermediateCode());
		nullTemporalManagement(_expresion, iCB);

		if(_simbolo instanceof SymbolReturn)
		{
			// Se trata de una sentencia return.
			iCB.addQuadruple("RET", expFirstTemp, new Value(scope.getLevel()));
		}
		else
		{						
			Reference ref = new Reference(_simbolo);
			TemporalIF rTemp = ref.get_temporal();
			TemporalIF expSecondTemp = _expresion.getSecondTemporal();

			
			// En este punto, se determina si la refenecia a asignar es un 
			// Registro
			if(_simbolo.getType() instanceof TypeRecord)
			{
				
				//String campoRegistro = (String) _simbolo2;
				
				//	Variable var2 = new Variable(campoRegistro, scope);
				// iCB.addQuadruple("ASIG_REGISTRO", var, var2, exp.getResultado());
				
				TemporalFactory tF = new TemporalFactory(scope);
				TemporalIF iSetTemp = tF.create();    	// Init Set Value Temporal
				TemporalIF eSetTemp = tF.create();    	// End Set Value Temporal

			}
			
			
			iCB.addQuadruples(ref.getICB().create());	

				iCB.addQuadruple("STP", rTemp, expFirstTemp, expSecondTemp);
			
		}

		this.setIntermediateCode(iCB.create());
	}

}
