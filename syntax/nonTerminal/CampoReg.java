package compiler.syntax.nonTerminal;

import es.uned.lsi.compiler.semantic.symbol.SymbolIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

public class CampoReg extends NonTerminal{
	
	private String nombre;
	private Integer valor, linea, columna, desplazamiento;
	private TypeIF tipo;
	private SymbolIF simbolo;
	
	
	// Constructores
	
	public CampoReg() {
		super();
	}
	
	
	public CampoReg(String nombre, Integer valor, Integer linea, Integer columna, SymbolIF simbolo) {
		super();
		this.nombre = nombre;
		this.valor = valor;
		this.linea = linea;
		this.columna = columna;
		this.simbolo = simbolo;
	}





	// Métodos


	// Getters and Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	public Integer getLinea() {
		return linea;
	}
	public void setLinea(Integer linea) {
		this.linea = linea;
	}
	public Integer getColumna() {
		return columna;
	}
	public void setColumna(Integer columna) {
		this.columna = columna;
	}
	public Integer getDesplazamiento() {
		return desplazamiento;
	}
	public void setDesplazamiento(Integer desplazamiento) {
		this.desplazamiento = desplazamiento;
	}
	public TypeIF getTipo() {
		return tipo;
	}
	public void setTipo(TypeIF tipo) {
		this.tipo = tipo;
	}
	public SymbolIF getSimbolo() {
		return simbolo;
	}
	public void setSimbolo(SymbolIF simbolo) {
		this.simbolo = simbolo;
	}

	
	
	// fin getters and setters
	
	
	
	

}
