package compiler.syntax.nonTerminal;

import java.util.ArrayList;
import java.util.List;

import compiler.CompilerContext;
import compiler.intermediate.Factory.IntermedioExpresionAccesoRegistro;
import es.uned.lsi.compiler.intermediate.IntermediateCodeBuilder;
import es.uned.lsi.compiler.intermediate.LabelIF;
import es.uned.lsi.compiler.intermediate.QuadrupleIF;
import es.uned.lsi.compiler.intermediate.TemporalFactory;
import es.uned.lsi.compiler.intermediate.TemporalIF;
import es.uned.lsi.compiler.semantic.ScopeIF;
import es.uned.lsi.compiler.syntax.nonTerminal.NonTerminalIF;

/**
 * Abstract class for non terminals.
 */
public abstract class NonTerminal
    implements NonTerminalIF
{


	private List<QuadrupleIF> intermediateCode;
    
	// Nuevas
	private LabelIF label;
	private TemporalIF firstTemporal, secondTemporal = null;
	private IntermedioExpresionAccesoRegistro _acceso;
	// fin nuevas
    
    /**
     * Constructor for NonTerminal.
     */
    public NonTerminal ()
    {
        super ();
        this.intermediateCode = new ArrayList<QuadrupleIF> ();
    }

    /**
     * Returns the intermediateCode.
     * @return Returns the intermediateCode.
     */
    public List<QuadrupleIF> getIntermediateCode ()
    {
        return intermediateCode;
    }

    /**
     * Sets The intermediateCode.
     * @param intermediateCode The intermediateCode to set.
     */
    public void setIntermediateCode (List<QuadrupleIF> intermediateCode)
    {
        this.intermediateCode = intermediateCode;
    }
    
    
    // Nuevo 
    
    /**
     * 
     * @return
     */
    public LabelIF getLabel()
    {
		return label;
	}

    /**
     * 
     * @param label
     */
	public void setLabel(LabelIF label)
	{
		this.label = label;
	}

	/**
	 * 
	 * @return el primer temporal
	 */
	public TemporalIF getTemporal() 
	{
		return firstTemporal;
	}
	
	/**
	 * 
	 * @return El segundo temporal
	 */
	public TemporalIF getSecondTemporal() 
	{
		return secondTemporal;
	}

	/**
	 * 
	 * @param temporal
	 */
	public void setTemporal(TemporalIF temporal) 
	{
		this.firstTemporal = temporal;
	}
	
	public void setSecondTemporal(TemporalIF temporal) 
	{
		this.secondTemporal = temporal;
	}
	
// Metodos para comporbar existencia de temporales nulos
	
	protected void nullTemporalManagement(Expresion exp, IntermediateCodeBuilder iCb)
	{
		if (exp.getTemporal() == null )
		{
			
			// Creamos un el nuevo Temporal
			ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();
			TemporalFactory tF = new TemporalFactory(scope);
			TemporalIF temp = tF.create();

			// Se lo asignamos a la expresión
			exp.setTemporal(temp);
			
		}
		
	}    
	
	
	protected void nullTemporalManagementToken(TokenVar token, IntermediateCodeBuilder iCb)
	{
		if (token.getTemporal() == null)
		{
			// Creamos un el nuevo Temporal
			ScopeIF scope = CompilerContext.getScopeManager().getCurrentScope();
			TemporalFactory tF = new TemporalFactory(scope);
			TemporalIF temp = tF.create();

			// Se lo asignamos al token (ID o número)
			token.setTemporal(temp);

		}
	} 
    
}