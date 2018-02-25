package compiler.syntax.Expresion;

import compiler.syntax.nonTerminal.Expresion;
import es.uned.lsi.compiler.intermediate.OperandIF;
import es.uned.lsi.compiler.semantic.type.TypeIF;

public class ExpresionAccesoRegistro extends Expresion{
	
	// Variables
	private String identificador;
	private String identificador2;
	private String campo;
    private TypeIF tipo;
    private OperandIF resultado;
    private int linea;
    private int columna;
    private boolean referencia=false;       // Indica si una variable puede ser de referencia.
	
	public ExpresionAccesoRegistro() {
		super();
	}

	public ExpresionAccesoRegistro(TypeIF expresion) {
		super(expresion);
	}

	public ExpresionAccesoRegistro(String identificador, String campo) {
		super();
		this.identificador = identificador;
		this.campo = campo;
	}
	
	public ExpresionAccesoRegistro(String identificador, String identificador2, String campo) {
		super();
		this.identificador = identificador;
		this.identificador2 = identificador2;
		this.campo = campo;
	}

	public ExpresionAccesoRegistro(TypeIF tipo, int linea, int columna) {
		super();
		this.tipo = tipo;
		this.linea = linea;
		this.columna = columna;
	}
	
	
	public TypeIF getTipo() {
		return tipo;
	}

	public void setTipo(TypeIF tipo) {
		this.tipo = tipo;
	}

	public OperandIF getResultado() {
		return resultado;
	}

	public void setResultado(OperandIF resultado) {
		this.resultado = resultado;
	}

	public int getLinea() {
		return linea;
	}

	public void setLinea(int linea) {
		this.linea = linea;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public boolean isReferencia() {
		return referencia;
	}

	public void setReferencia(boolean referencia) {
		this.referencia = referencia;
	}


	//  Getters and Setters
	
	
	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getIdentificador2() {
		return identificador2;
	}

	public void setIdentificador2(String identificador2) {
		this.identificador2 = identificador2;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}




}
