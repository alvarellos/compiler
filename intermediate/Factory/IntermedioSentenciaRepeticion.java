package compiler.intermediate.Factory;

import compiler.CompilerContext;
import compiler.syntax.nonTerminal.Expresion;
import compiler.syntax.nonTerminal.SentenciaRepeticion;
import compiler.syntax.nonTerminal.Sentencias;
import compiler.intermediate.Factory.IntermedioExpresionAsignacion;
import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
import es.uned.lsi.compiler.intermediate.LabelFactory;
import es.uned.lsi.compiler.intermediate.LabelFactoryIF;
import es.uned.lsi.compiler.intermediate.LabelIF;
import es.uned.lsi.compiler.intermediate.TemporalIF;
import es.uned.lsi.compiler.semantic.ScopeIF;

public class IntermedioSentenciaRepeticion extends SentenciaRepeticion {
	
	// Variables
	private Expresion _asignacion, _expresion_1, _expresion_2;
	private Sentencias _sentencias;
	
	//Constructoes

	public IntermedioSentenciaRepeticion(Expresion asignacion, Expresion expresion1, Expresion expresion2, Sentencias sentencia) {
		super();
		this._asignacion = asignacion;
		this._expresion_1 = expresion1;
		this._expresion_2 = expresion2;
		this._sentencias = sentencia;
		// TODO Auto-generated constructor stub
	}

	// Métodos
	
	public void codigoIntermedio()
	{
		
		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();

		LabelFactoryIF lF = new LabelFactory();
		LabelIF l1 = lF.create();
		LabelIF l2 = lF.create();
		
		IntermediateCodeBuilder iCB = new IntermediateCodeBuilder(scope);

		// Inicializacion del indice
		
		if (_asignacion instanceof IntermedioExpresionAsignacion){
			
			// La asignacion del indice es una variable
			((IntermedioExpresionAsignacion)_asignacion).codigoIntermedio();
			iCB.addQuadruples(_asignacion.getIntermediateCode());
			
			// Inicio del bucle
			iCB.addQuadruple("INL", l1);

			iCB.addQuadruples(_expresion_1.getIntermediateCode());

			nullTemporalManagement(_expresion_1, iCB);
			TemporalIF eTemp = _expresion_1.getTemporal();
			
			iCB.addQuadruple("BRF", eTemp, l2);		
			
			iCB.addQuadruples(_expresion_2.getIntermediateCode());
			iCB.addQuadruples(_sentencias.getIntermediateCode());
			
			
			iCB.addQuadruple("BR", l1);
			
			// Fin del bucle
			iCB.addQuadruple("INL", l2);
			
			
			this.setIntermediateCode(iCB.create());
			
		} else {
			
			// La asignacion del indice es un campo registro
			((IntermedioExpresionAsignacionRegistros)_asignacion).codigoIntermedio();
			iCB.addQuadruples(_asignacion.getIntermediateCode());
			
			// Inicio del bucle
			iCB.addQuadruple("INL", l1);

			iCB.addQuadruples(_expresion_1.getIntermediateCode());

			nullTemporalManagement(_expresion_1, iCB);
			TemporalIF eTemp = _expresion_1.getTemporal();
			
			iCB.addQuadruple("BRF", eTemp, l2);		
			
			iCB.addQuadruples(_expresion_2.getIntermediateCode());
			iCB.addQuadruples(_sentencias.getIntermediateCode());
			
			
			iCB.addQuadruple("BR", l1);
			
			// Fin del bucle
			iCB.addQuadruple("INL", l2);
			
			
			this.setIntermediateCode(iCB.create());
			
		}



	}

}
