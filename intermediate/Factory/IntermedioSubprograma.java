package compiler.intermediate.Factory;

import compiler.CompilerContext;
import compiler.intermediate.Procedure;
import compiler.intermediate.Value;
import compiler.semantic.type.TypeInteger;
import compiler.syntax.nonTerminal.CuerpoFuncion;
import compiler.syntax.nonTerminal.Subprograma;
import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
import es.uned.lsi.compiler.intermediate.LabelIF;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.symbol.SymbolIF;
import es.uned.lsi.compiler.semantic.symbol.SymbolTableIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

public class IntermedioSubprograma extends Subprograma{
	
	// Variables
	private CuerpoFuncion _bloque;
	private TypeIF _tipoRetorno;
	
	// Constructores
	public IntermedioSubprograma() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IntermedioSubprograma(CuerpoFuncion block, TypeIF retorno) {
		super(block);
		// TODO Auto-generated constructor stub
		this._bloque = block;
		this._tipoRetorno = retorno;
	}
	
	
	public IntermedioSubprograma(CuerpoFuncion block) {
		super(block);
		// TODO Auto-generated constructor stub
		this._bloque = block;
	}

	public void codigoIntermedio(String sName)
	{
		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();

		SymbolTableIF sTable = scope.getSymbolTable();
		SymbolIF symbol = sTable.getSymbol(sName);	
		Procedure proc = new Procedure(sName, scope);
		LabelIF label = proc.getCodeLabel();
		int level = proc.getScope().getLevel() + 1;

		
		IntermediateCodeBuilder iCB = new IntermediateCodeBuilder(scope);
	//	iCB.addQuadruples(_bloque.getBloqueSentencias().getIntermediateCode());
		
		iCB.addQuadruple("INL", label, new Value(level));		
		//iCB.addQuadruple("INL", label, new Value(scope.getLevel()));

		iCB.addQuadruple("NOP");
		
		iCB.addQuadruples(_bloque.getListaSentencias().getIntermediateCode());

		// Si el retorno es de tipo VOID se añade esta cuádrupla para evitar
		// Recursividad infinita		
		if(!(_tipoRetorno instanceof TypeInteger))
		{
			iCB.addQuadruple("RET", null, new Value(level));
		}
		
		this.setIntermediateCode(iCB.create());

	}

}
