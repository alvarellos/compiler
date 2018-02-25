package compiler.intermediate.Factory;

import compiler.CompilerContext;
import compiler.intermediate.Variable;
import compiler.semantic.symbol.SymbolVariable;
import compiler.syntax.Expresion.ExpresionAccesoRegistro;
import compiler.syntax.Expresion.ExpresionAsignacion;
import compiler.syntax.nonTerminal.Expresion;
import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
import es.uned.lsi.compiler.intermediate.TemporalIF;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.semantic.symbol.SymbolIF;

public class IntermedioExpresionAsignacionRegistros extends ExpresionAsignacion{
	
	// Variables
	private ExpresionAccesoRegistro _registro;
	private Expresion _expresion;
	private ScopeIF _scope;
	private SymbolIF _simbolo;
	private SymbolVariable _simboloCampo;
	private int _anidamientoReg;
	
	
	// Constructores
	
	public IntermedioExpresionAsignacionRegistros(ExpresionAccesoRegistro _registro,
			SymbolIF _simbolo, SymbolVariable _simboloCampo, Expresion _expresion, ScopeIF _scope) {
		super();
		this._registro = _registro;
		this._expresion = _expresion;
		this._scope = _scope;
		this._simbolo = _simbolo;
		this._simboloCampo = _simboloCampo;
	}


	
	public IntermedioExpresionAsignacionRegistros(ExpresionAccesoRegistro _registro,
			SymbolIF _simbolo, SymbolVariable _simboloCampo, Expresion _expresion, ScopeIF _scope, int anidamientoReg) {
		super();
		this._registro = _registro;
		this._expresion = _expresion;
		this._scope = _scope;
		this._simbolo = _simbolo;
		this._simboloCampo = _simboloCampo;
		this._anidamientoReg = anidamientoReg;
	}
	

	// Métodos


	public void codigoIntermedio()
	{
		ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();
		IntermediateCodeBuilder iCB = new IntermediateCodeBuilder(scope);
		
        String identificadorRegisto = _registro.getIdentificador();
        String ident2 = _registro.getIdentificador2();
        String campoRegistro = _registro.getCampo();
        
        if (ident2 == null){
        	// No hay un campo ligado a otro registro
        	
            Variable var = new Variable(identificadorRegisto, scope);
            var.setAmbito(_simbolo.getScope());
            
            Variable var2 = new Variable(campoRegistro, scope);
    		var2.setDesplazamientoCampo(_simboloCampo.getDesplazamiento());
    		
    		
    		TemporalIF expFirstTemp = _expresion.getTemporal();		
    		
    		iCB.addQuadruples(_expresion.getIntermediateCode());
    		iCB.addQuadruple("REG", var, var2, expFirstTemp);
            
            
        } else {
        	// Campo ligado a otro registro
        	
           // Variable var = new Variable(ident2, scope);
           // var.setAmbito(_simbolo.getScope());
            
            Variable var = new Variable(identificadorRegisto, scope);
            var.setAmbito(_simbolo .getScope());
            
            Variable var2 = new Variable(campoRegistro, scope);
            
            //var2.setTablaDesplazamiento(_desplazaScope);
			
            // este tengo 
    		var2.setDesplazamientoCampo(_anidamientoReg);

    		TemporalIF temp = _expresion.getTemporal();	
    		
    		iCB.addQuadruples(_expresion.getIntermediateCode());
    		iCB.addQuadruple("REG", var, var2, temp);

        }

		this.setIntermediateCode(iCB.create());
	}


}
