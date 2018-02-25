package compiler.syntax.nonTerminal;

import compiler.lexical.Token;
import es.uned.lsi.compiler.semantic.type.TypeIF;

public class LlamadaSubprograma extends Expresion{
		
		// Variables
		private Token _id;
		private ListaParametros _parametros_subprograma;
		private TypeIF _tipo_retorno;
		
		// Constructores

		
		public LlamadaSubprograma(Token id, ListaParametros parametrosSubprograma)
		{
			super();
			this._id = id;
			this._parametros_subprograma = parametrosSubprograma;
		}
		
		// Métodos
		
		public Token getId()
		{
			return _id;
		}
		
		
		public TypeIF getTipoRetorno()
		{
			return _tipo_retorno;
		}
		
		public ListaParametros getParametrosSubprograma()
		{
			return _parametros_subprograma;		
		}

}
