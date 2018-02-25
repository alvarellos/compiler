package compiler.intermediate.Factory;

import compiler.CompilerContext;
import compiler.intermediate.Value;
import compiler.lexical.Token;
import compiler.syntax.nonTerminal.Axiom;
import compiler.syntax.nonTerminal.Bloque;
import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
import es.uned.lsi.compiler.intermediate.LabelFactory;
import es.uned.lsi.compiler.intermediate.LabelIF;
import es.uned.lsi.compiler.semantic.ScopeIF;

public class IntermedioAxiom extends Axiom {

	// Variables
	private Token _id;
	private Bloque _bloque;	
	
	public IntermedioAxiom() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public IntermedioAxiom(Token id, Bloque block) 
	{
		super();
		this._id = id;
		this._bloque = block;
	}

	public IntermedioAxiom(Bloque block) 
	{
		super();
		this._bloque = block;
	}
	
	
	// Métodos
	public void codigoIntermedio()
	{
		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();

		LabelFactory labFact = new LabelFactory();
		LabelIF label = labFact.create(_id.getLexema().toUpperCase());

		IntermediateCodeBuilder iCB = new IntermediateCodeBuilder(scope);
	    //iCB.addQuadruples(_bloque.getSubprogramas().getIntermediateCode());
		
		// Etiqueta para un bloque
		iCB.addQuadruple("INL", label, new Value(scope.getLevel()));
		// Sentencias de bloque
		iCB.addQuadruples(_bloque.getSentencias().getIntermediateCode());
				
		this.setIntermediateCode(iCB.create());
		this.setLabel(label);
	}	

}
