package compiler.syntax.nonTerminal;

public class DeclaracionFuncion extends NonTerminal {
	private String _nombre;
	private DeclaracionListaParametros _listaParametros;
	private CuerpoFuncion _cuerpo;
	
	public DeclaracionFuncion(){
		
	}
	public DeclaracionFuncion(String nombre){
		_nombre = nombre;
	}
	public DeclaracionFuncion(DeclaracionListaParametros listaParametros){
		_listaParametros = listaParametros;
	}
	public DeclaracionFuncion(String nombre, DeclaracionListaParametros listaParametros){
		_nombre = nombre;
		_listaParametros = listaParametros;
	}
	
	public String getNombre(){
		return _nombre;
	}
	public void setNombre(String nombre){
		_nombre = nombre;
	}
	
	public DeclaracionListaParametros getListaParametros(){
		return _listaParametros;
	}
	
	public CuerpoFuncion getCuerpoFuncion(){
		return _cuerpo;
	}
	public void setCuerpoFuncion(CuerpoFuncion cuerpo){
		_cuerpo = cuerpo;
	}
	
	public boolean tieneRetorno(){
		return (_cuerpo!=null && _cuerpo.tieneRetorno()); 
	}
}
