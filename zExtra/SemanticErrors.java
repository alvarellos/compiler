package compiler.zExtra;

public class SemanticErrors {

	
	// Errores para el an�lisis sem�ntico (utilizados en el parser.cup y en alguna clase

	// Errores para los s�mbolos y tipos
	public final static String Simbolo_duplicado            = "S�mbolo duplicado";
	public final static String Simbolo_no_declarado         = "S�mbolo no declarado";

	public final static String Simbolo_utilizado_constante  = "El identificador ya ha sido utilizado al declarar una constante/par�metro";
	public final static String Simbolo_constante_declarada  = "Constante ya declarada con ese identificador";
	public final static String Simbolo_duplicado_tipo       = "Identificador ya ha sido utilizado para declarar un tipo";	
	public final static String Simbolo_variable_declarada   = "variable o constante ya declarada con ese identificador";	
	public final static String Simbolo_duplicado_funcion    = "S�mbolo con mismo identificador al de funci�n";
	public final static String Simbolo_Ident_utilizado      = "El identificador de funci�n/procedimiento ya est� siendo utilizado";	
	public final static String Simbolo_no_es_de_funcion     = "La llamada no corresponde a una funci�n";
	public final static String Simbolo_Expresion_incorrecta = "La Expresi�n introducida no corresponde con una funcion";
	public final static String Simbolo_Sentencia_incorrecta = "La Sentencia introducida no corresponde con un procedimiento";

	// Errores para los tipos
	public final static String Tipo_incorrecto             = "Tipo incorrecto";	
	public final static String Tipo_duplicado              = "Tipo duplicado";		
	public final static String Tipo_no_declarado           = "Tipo no declarado";
	public final static String Tipos_incompatibles         = "Tipos incompatibles";
	public final static String Tipo_Ident_utilizado        = "El identificador de funci�n/procedimiento ha sido declarado anteriormente por un tipo";		
	public final static String Tipo_usado_en_expresion	   = "Un identificador de tipo no puede ser utilizado en una expresi�n";

	public final static String Sentencia_incorrecta        = "Sentencia incorrecta";
	public final static String Expresion_incorrecta        = "Expresion incorrecta";		

	// Llamada a funci�n
	public final static String Tipo_parametro_incorrecto     = "Tipo del par�metro incorrecto";
	public final static String Numero_incorrecto_parametros  = "Numero incorrecto de par�metros";	
	public final static String Simbolo_Funcion_no_declarada = "La funci�n no ha sido declarada previamente";
	public final static String Retorno_de_funcion_incorrecto  = "La funci�n tiene que devolver un tipo entero";
	public final static String Retorno_de_funcion_incorrecto_2  = "No se puede devolver un tipo entero en una sentencia";
	
	// Operadores
	public final static String Operador_no_declarado     = "EL operador/identificador/retorno no ha sido declarado previamente";

	// Retorno
	public final static String No_instruccion_retorno      = "No existe instrucci�n de retorno";
	public final static String Tipo_incorrecto_retorno_1   = "La instrucci�n de retorno debe ser vac�a en procedimientos/funciones VOID";
	public final static String Tipo_incorrecto_retorno_2   = "La instrucci�n de retorno no devuelve un tipo entero (cte, var entera o expresi�n resta)";
	public final static String Error_no_controlado         = "Error no controlado";

	// Para comprobacion tipo Registro
	public final static String Registro_incorrecto          = "Registro incorrecto";
	public final static String Campo_ya_declarado           = "El identificador para el campo ya ha sido utilizado";
	public final static String Campo_no_declarado           = "El campo del registro no tiene declarado este campo";
	public final static String Nivel_anidamiento_excedido	= "No se permite m�s de 2 anidamientos en la declaraci�n de registros";

	// Asignaciones
	public final static String Variable_no_permitida        = "No se permiten tipos estructurados en la asignacion";
	public final static String Asignacion_ValorNoValido 	= "Valor no v�lido para asignaci�n en la declaraci�n de la variable";
	public final static String Asignacion_no_permitida      = "Esta asignacion no esta permitida";
	public final static String Referencia_no_asignable      = "Referencia no asignable";	
	
	// Bucles
	public final static String Indice_no_declarado           = "Indice de control del bucle FOR no ha sido declarado";
	public final static String Valor_indice_incorrecto       = "Solamente se permite iniciar la variable con un valor entero valido";
	public final static String Variable_no_coincide          = "Se ha de decrementar la misma variable en el bucle";
	public final static String Expresion_logica_no_valida    = "Solamente se permite expresi�n del tipo (a>NUM) y equivale a (a>=NUM)";
	public final static String Expresion_logica_no_valida_2  = "Se ha de decrementar la variable inicial ";
	
}
