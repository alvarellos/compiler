package compiler.intermediate.Factory;

import compiler.CompilerContext;
import compiler.syntax.nonTerminal.Expresion;
import compiler.syntax.nonTerminal.SentenciaSeleccion;
import compiler.syntax.nonTerminal.Sentencias;
import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
import es.uned.lsi.compiler.intermediate.LabelFactory;
import es.uned.lsi.compiler.intermediate.LabelFactoryIF;
import es.uned.lsi.compiler.intermediate.LabelIF;
import es.uned.lsi.compiler.intermediate.TemporalIF;
import es.uned.lsi.compiler.semantic.ScopeIF;

public class IntermedioSentenciaSeleccion extends SentenciaSeleccion{

	// Variables
	protected Expresion _exp;
	protected Sentencias _if_sentencia;
	protected Sentencias _else_sentencia;	
	
	// Constructores

	public IntermedioSentenciaSeleccion(Expresion exp, Sentencias if_sentencia, Sentencias else_sentencia) {
		super(exp, if_sentencia, else_sentencia);
		// TODO Auto-generated constructor stub
		this._exp = exp;
		this._if_sentencia = if_sentencia;
		this._else_sentencia = else_sentencia;
	}

	public IntermedioSentenciaSeleccion(Expresion exp, Sentencias if_sentencia) {
		super(exp, if_sentencia);
		// TODO Auto-generated constructor stub
		this._exp = exp;
		this._if_sentencia = if_sentencia;
		this._else_sentencia = null;
	}	
	

	// Métodos
	

	
	
	public void codigoIntermedio() 
	{	

		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();
		LabelFactoryIF lF = new LabelFactory();
		LabelIF l1 = lF.create();

		IntermediateCodeBuilder iCB = new IntermediateCodeBuilder(scope);
		iCB.addQuadruples(_exp.getIntermediateCode());
		nullTemporalManagement(_exp, iCB);
		TemporalIF eTemp = _exp.getTemporal();
		
		
		if(_else_sentencia != null)
		{
			// con sentencias else
			LabelIF l2 = lF.create();
		
			iCB.addQuadruple("BRF", eTemp, l1);
			iCB.addQuadruples(_if_sentencia.getIntermediateCode());
			iCB.addQuadruple("BR", l2);
			iCB.addQuadruple("INL", l1);
			iCB.addQuadruples(_else_sentencia.getIntermediateCode());
			iCB.addQuadruple("INL", l2);
			iCB.addQuadruple("NOP");
		
			this.setIntermediateCode(iCB.create());
		}
		
		else 
		{
			// sin sentencias else
			
			iCB.addQuadruple("BRF", eTemp, l1);
			iCB.addQuadruples(_if_sentencia.getIntermediateCode());
			iCB.addQuadruple("INL", l1);
			iCB.addQuadruple("NOP");
			
			this.setIntermediateCode(iCB.create());
		}
	
	}	
	
	
}
