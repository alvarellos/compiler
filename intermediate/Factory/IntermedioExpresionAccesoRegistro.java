package compiler.intermediate.Factory;

import java.util.HashMap;

import compiler.CompilerContext;
import compiler.intermediate.Temporal;
import compiler.intermediate.Variable;
import compiler.semantic.symbol.SymbolVariable;
import compiler.syntax.Expresion.ExpresionAccesoRegistro;
import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
import es.uned.lsi.compiler.intermediate.TemporalFactory;
import es.uned.lsi.compiler.intermediate.TemporalIF;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.symbol.SymbolIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

public class IntermedioExpresionAccesoRegistro extends ExpresionAccesoRegistro{

	private ScopeIF _scope;
	private SymbolIF _simbolo;
	private SymbolVariable _simboloCampo;
	private int _desplazamiento;
	private int _anidamientoReg;
	private ExpresionAccesoRegistro _expresion;
	private ExpresionAccesoRegistro _registro;
	private HashMap<Integer, Integer> _diccionario;
	
	private IntermediateCodeBuilder _iCB;
	private TemporalIF _temporal;
	
	public IntermedioExpresionAccesoRegistro(ExpresionAccesoRegistro registro, ExpresionAccesoRegistro expresion, SymbolIF _simbolo, SymbolVariable _simboloCampo, 
			ScopeIF _scope, int desplazamiento) {
		super();
		this._scope = _scope;
		this._simbolo = _simbolo;
		this._simboloCampo = _simboloCampo;
		this._desplazamiento = desplazamiento;
		this._expresion = expresion;
		this._registro = registro;
	}
	
	public IntermedioExpresionAccesoRegistro(ExpresionAccesoRegistro registro, ExpresionAccesoRegistro expresion, SymbolIF _simbolo, SymbolVariable _simboloCampo, 
			ScopeIF _scope, int desplazamiento, int anidamientoRegistro) {
		super();
		this._scope = _scope;
		this._simbolo = _simbolo;
		this._simboloCampo = _simboloCampo;
		this._desplazamiento = desplazamiento;
		this._expresion = expresion;
		this._registro = registro;
		this._anidamientoReg = anidamientoRegistro;
	}
	
	public IntermedioExpresionAccesoRegistro(ExpresionAccesoRegistro registro, ExpresionAccesoRegistro expresion, SymbolIF _simbolo, SymbolVariable _simboloCampo, 
			ScopeIF _scope, int desplazamiento, int anidamientoRegistro, HashMap diccionario) {
		super();
		this._scope = _scope;
		this._simbolo = _simbolo;
		this._simboloCampo = _simboloCampo;
		this._desplazamiento = desplazamiento;
		this._expresion = expresion;
		this._registro = registro;
		this._anidamientoReg = anidamientoRegistro;
		this._diccionario = diccionario;
	}

	public IntermedioExpresionAccesoRegistro() {
		super();
	}


	public IntermedioExpresionAccesoRegistro(String identificador, String campo) {
		super(identificador, campo);
	}

	public IntermedioExpresionAccesoRegistro(TypeIF expresion) {
		super(expresion);
	}
	

	public void codigoIntermedio()
	{
		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();
		IntermediateCodeBuilder iCB = new IntermediateCodeBuilder(scope);
		
        String identificadorRegisto = _registro.getIdentificador();
        String ident2 = _registro.getIdentificador2();
        String campoRegistro = _registro.getCampo();
		
        
        if (ident2 == null){
        	
            _iCB = new IntermediateCodeBuilder(scope);
            
            Variable var = new Variable(identificadorRegisto, scope);
            var.setAmbito(_simbolo.getScope());
            
            Variable var2 = new Variable(campoRegistro, scope);
               
    		var2.setDesplazamientoCampo(_simboloCampo.getDesplazamiento());
    	
    		TemporalFactory tf = new TemporalFactory(scope);
            Temporal temporal = (Temporal) tf.create();
            temporal.setDesplazamiento(_desplazamiento);
    			
    		// _temporal = temporal;	
            _expresion.setReferencia(true);
            _expresion.setResultado(temporal);
          
    		iCB.addQuadruple("REG_ACC", temporal, var, var2);
    		
    /*		iCB.addQuadruples(_expresion.getIntermediateCode());
    		_expresion.setResultado(temporal);*/
    	     	

        } else {
        
        	_iCB = new IntermediateCodeBuilder(scope);
            
            Variable var = new Variable(identificadorRegisto, scope);
            var.setAmbito(_simbolo.getScope());
            
            Variable var2 = new Variable(campoRegistro, scope);
            
            //var2.setDesplazamientoCampo(_anidamientoReg+_desplazamiento);
            var2.setDesplazamientoCampo(_desplazamiento);
    		//var2.setDesplazamientoCampo(_anidamientoReg);
    	
    		TemporalFactory tf = new TemporalFactory(scope);
            Temporal temporal = (Temporal) tf.create();
            temporal.setDesplazamiento(_desplazamiento);
    			
    		// _temporal = temporal;	
            _expresion.setReferencia(true);
            _expresion.setResultado(temporal);
          
    		iCB.addQuadruple("REG_ACC", temporal, var, var2);
    		
    /*		iCB.addQuadruples(_expresion.getIntermediateCode());
    		_expresion.setResultado(temporal);*/     	
        	
        }
        
		this.setIntermediateCode(iCB.create());
	}

}
