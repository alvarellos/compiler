package compiler.intermediate.Factory;

import compiler.CompilerContext;
import compiler.code.ActivaMemoria;
import compiler.intermediate.Value;
import compiler.lexical.Token;
import compiler.semantic.type.TypeBoolean;
import compiler.syntax.nonTerminal.Expresion;
import compiler.syntax.nonTerminal.SentenciaSalidaValor;
import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
import es.uned.lsi.compiler.intermediate.LabelFactory;
import es.uned.lsi.compiler.intermediate.LabelFactoryIF;
import es.uned.lsi.compiler.intermediate.LabelIF;
import es.uned.lsi.compiler.intermediate.TemporalIF;
import es.uned.lsi.compiler.semantic.ScopeIF;

public class IntermedioSentenciaSalidaValor extends SentenciaSalidaValor {

	private Expresion _expresion = null;
	private Token _cadena = null;
	private String _texto;	
	
	
	public IntermedioSentenciaSalidaValor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IntermedioSentenciaSalidaValor(Expresion expresion) {
		super();		
		this._expresion = expresion;
		// TODO Auto-generated constructor stub
	}

/*	public IntermedioSentenciaWrite(String texto) {
		super(texto);
		// TODO Auto-generated constructor stub
	}*/

	public IntermedioSentenciaSalidaValor(Token cadena) {
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

		if(_expresion != null)
		{
			// WRITE PARI expresion PARD
			
			Expresion exp = _expresion;

			if(exp.getTipoExpresion() instanceof TypeBoolean)
			{
				LabelFactoryIF lF = new LabelFactory();
				LabelIF l1 = lF.create();
				LabelIF l2 = lF.create();

				iCB.addQuadruples(exp.getIntermediateCode());

				nullTemporalManagement(exp, iCB);
				TemporalIF eTemp = exp.getTemporal();

				iCB.addQuadruple("BRF", eTemp, l1);
				// Codigo final 
				iCB.addQuadruple("WRITE", new Value(ActivaMemoria.getKeyTrue()));
				iCB.addQuadruple("BR", l2);
				iCB.addQuadruple("INL", l1);

				// Código final
				iCB.addQuadruple("WRITE", new Value(ActivaMemoria.getKeyFalse()));
				iCB.addQuadruple("INL", l2);

			}
			else
			{	

				iCB.addQuadruples(exp.getIntermediateCode());
				nullTemporalManagement(exp, iCB);
				TemporalIF eTemp = exp.getTemporal();

				iCB.addQuadruple("WRITE", eTemp);

			}
			
		}
		else if(_cadena == null)
		{
			// PRINTI OBRACKET CBRACKET SEMICOLON
			iCB.addQuadruple("WRITE", null);
		}
		else
		{
			// Sintactico Imprime Cadena (nunca llega aqui)
		}

		this.setIntermediateCode(iCB.create());
	}
}
