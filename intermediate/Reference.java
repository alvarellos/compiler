package compiler.intermediate;

import compiler.CompilerContext;
import compiler.semantic.symbol.SymbolConstantBoolean;
import compiler.semantic.symbol.SymbolConstantInteger;
import compiler.semantic.symbol.SymbolParameter;
import compiler.semantic.symbol.SymbolVariable;
import compiler.semantic.type.TypeRecord;
import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
import es.uned.lsi.compiler.intermediate.TemporalFactory;
import es.uned.lsi.compiler.intermediate.TemporalIF;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.symbol.SymbolBase;
import es.uned.lsi.compiler.semantic.symbol.SymbolIF;

public class Reference {

	
	// Variables
	private SymbolIF _simbolo;
	private Boolean _es_referencia_expresion = false;
	private TemporalIF _temporal;
	private IntermediateCodeBuilder _iCB;
	private Boolean _esta_inicializada = false;
	
	// Constructores
	public Reference(SymbolIF symbol, Boolean es_ref_expresion)
	{
		this._simbolo = symbol;
		this._es_referencia_expresion = true;
		codigoIntermedio();
	}
	public Reference(SymbolIF simbolo)
	{	 
		this._simbolo = simbolo;
		codigoIntermedio();
	}
	
	// Metodos
	public SymbolIF get_simbolo() {
		return _simbolo;
	}
	public void set_simbolo(SymbolIF _simbolo) {
		this._simbolo = _simbolo;
	}
	public Boolean get_es_referencia_expresion() {
		return _es_referencia_expresion;
	}
	public void set_es_referencia_expresion(Boolean _es_referencia_expresion) {
		this._es_referencia_expresion = _es_referencia_expresion;
	}
	public TemporalIF get_temporal() {
		return _temporal;
	}
	public void set_temporal(TemporalIF _temporal) {
		this._temporal = _temporal;
	}
	

	// Para el código intermedio
	public IntermediateCodeBuilder getICB()
	{
		return _iCB;
	}
	

	private void codigoIntermedio() 
	{	
		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();
		TemporalFactory tF = new TemporalFactory(scope);		
		Temporal temp = (Temporal) tF.create();
		
		_iCB = new IntermediateCodeBuilder(scope);	
		_temporal = temp;
		
	

		// fin bloque
		
		if(_simbolo instanceof SymbolConstantInteger)
		{
			SymbolConstantInteger sC = (SymbolConstantInteger) _simbolo;
			_iCB.addQuadruple("MOVE", temp, new Value(sC.getEntera()));		
			
		}
		else if(_simbolo instanceof SymbolConstantBoolean)
		{
            SymbolConstantBoolean sC = (SymbolConstantBoolean) _simbolo;
			_iCB.addQuadruple("MOVE", temp, new Value(sC.getResultado() ? 1 : 0));

		}
		
		
		else
		{
			Variable var = null;
			 
			if(_simbolo instanceof SymbolVariable && !(_simbolo instanceof SymbolParameter))
			{	
					var = new Variable((SymbolVariable)_simbolo);
			}
			
			else if(_simbolo instanceof SymbolParameter)
			{
				var = new Variable((SymbolParameter)_simbolo);
			}
			
			
			
			if (_simbolo instanceof SymbolVariable || _es_referencia_expresion){
				
				
				if (_simbolo instanceof SymbolParameter){
					//var = new Variable((SymbolParameter)_simbolo);
					// Es un parametro
					
					_iCB.addQuadruple("MVA", temp, var);
					
					temp.getAddress();
					TemporalIF temp1 = tF.create();
					if(_es_referencia_expresion && !(_simbolo.getType() instanceof TypeRecord) && !(_simbolo instanceof SymbolConstantInteger))
					{

						_iCB.addQuadruple("MVP", temp1, temp);
						_temporal = temp1;
						
						// Si se asigna un valor a la variable inicializada 
						// Se asigna el nuevo valor luego 
						//si.setInicializada(false);
						
					}
					
				}
				
				else{
					
					// No es un parámetro
					
					// Contro si variable está inicializada
					SymbolBase sV = (SymbolBase) _simbolo;
					String so = sV.getName();

					SymbolVariable si = (SymbolVariable) _simbolo;
					if (si.isInicializada()){
						//si.setInicializada(true);
						_esta_inicializada=true;
					}
					
					_iCB.addQuadruple("MVA", temp, var);
					
					// El temporal, contendrá la dirección de la variable. Por tanto es
					// necesario ponerle la propiedad 'containRefenceAddress' a true,
					// para poder distinguir que temporales contienen la dirección de
					// una referencia y cuales no (Revisar)
					temp.setContainRefenceAddress(true); // 
					
					
					temp.getAddress();
					TemporalIF temp1 = tF.create();
					if(_es_referencia_expresion && !(_simbolo.getType() instanceof TypeRecord) && !(_simbolo instanceof SymbolConstantInteger))
					{

						_iCB.addQuadruple("MVP", temp1, temp);
						_temporal = temp1;
						
						// Si se asigna un valor a la variable inicializada 
						// Se asigna el nuevo valor luego 
						si.setInicializada(false);						

					}
					
						
					
					// Se trata de una variable inicializada con una Constante
					if(so!=null && _esta_inicializada == true &&  _es_referencia_expresion){
				
						SymbolVariable sC = (SymbolVariable) _simbolo;
						
						temp1.getAddress();
						_iCB.addQuadruple("MOVE", temp1, new Value(sC.getEntera()));	

					}
					
					// Se trata de una variable inicializada con un entero (Sobraaa ?)	
					
				} // fin no es un parametro
				
			
				
				
			}
			
			
		}
	}

}
