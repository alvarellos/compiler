package compiler.intermediate.Factory;

import compiler.CompilerContext;
import compiler.code.ActivaMemoria;
import compiler.intermediate.Value;
import compiler.lexical.Token;
import compiler.syntax.nonTerminal.SentenciaSalidaCadena;
import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
import es.uned.lsi.compiler.semantic.ScopeIF;

public class IntermedioSentenciaSalidaCadena extends SentenciaSalidaCadena {

	
	private Token _cadena = null;
	private String _texto;	
	
	
	public IntermedioSentenciaSalidaCadena() {
		super();
		// TODO Auto-generated constructor stub
	}


	public IntermedioSentenciaSalidaCadena(Token cadena) {
		super();	
		
		// Se añade para el código final
		this._cadena = cadena;
		this._texto = ActivaMemoria.getKeyText();
		ActivaMemoria.addText(_texto, _cadena.getLexema());
		// TODO Auto-generated constructor stub
	}

	public void codigoIntermedio()
	{
		ScopeIF scope               = CompilerContext.getScopeManager().getCurrentScope();
		IntermediateCodeBuilder iCB = new IntermediateCodeBuilder (scope);

			// PRINTC OBRACKET TCHAIN CBRACKET SEMICOLON;
			iCB.addQuadruple("WRITE", new Value(_texto));

		this.setIntermediateCode(iCB.create());
	}
}
