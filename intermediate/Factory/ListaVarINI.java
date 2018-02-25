package compiler.intermediate.Factory;

import java.util.ArrayList;


public class ListaVarINI extends IntermedioDeclaracionVariables {
	
	
	// Mi lista de CI
	private IntermedioDeclaracionVariables _CI_var_ini;
	
	private ArrayList<IntermedioDeclaracionVariables> _lista_CI_var_ini; 
	
	
	public ListaVarINI() {
		super();
		this._lista_CI_var_ini = new ArrayList<IntermedioDeclaracionVariables>();
		// TODO Auto-generated constructor stub
	}
	
	
	public void addVarINI(IntermedioDeclaracionVariables var)
	{
		this._lista_CI_var_ini.add(var);
		this.getIntermediateCode().addAll(var.getIntermediateCode());
	}
	
	public void addVarINI(ListaVarINI var)
	{
		this.getIntermediateCode().addAll(var.getIntermediateCode());
	}

}
