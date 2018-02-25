package compiler.zExtra;

public class SemanticErrors {

	
	// Errores para el análisis semántico (utilizados en el parser.cup y en alguna clase

	// Errores para los símbolos y tipos
	public final static String Simbolo_duplicado            = "Símbolo duplicado";
	public final static String Simbolo_no_declarado         = "Símbolo no declarado";

	public final static String Simbolo_utilizado_constante  = "El identificador ya ha sido utilizado al declarar una constante/parámetro";
	public final static String Simbolo_constante_declarada  = "Constante ya declarada con ese identificador";
	public final static String Simbolo_duplicado_tipo       = "Identificador ya ha sido utilizado para declarar un tipo";	
	public final static String Simbolo_variable_declarada   = "variable o constante ya declarada con ese identificador";	
	public final static String Simbolo_duplicado_funcion    = "Símbolo con mismo identificador al de función";
	public final static String Simbolo_Ident_utilizado      = "El identificador de función/procedimiento ya está siendo utilizado";	
	public final static String Simbolo_no_es_de_funcion     = "La llamada no corresponde a una función";
	public final static String Simbolo_Expresion_incorrecta = "La Expresión introducida no corresponde con una funcion";
	public final static String Simbolo_Sentencia_incorrecta = "La Sentencia introducida no corresponde con un procedimiento";

	// Errores para los tipos
	public final static String Tipo_incorrecto             = "Tipo incorrecto";	
	public final static String Tipo_duplicado              = "Tipo duplicado";		
	public final static String Tipo_no_declarado           = "Tipo no declarado";
	public final static String Tipos_incompatibles         = "Tipos incompatibles";
	public final static String Tipo_Ident_utilizado        = "El identificador de función/procedimiento ha sido declarado anteriormente por un tipo";		
	public final static String Tipo_usado_en_expresion	   = "Un identificador de tipo no puede ser utilizado en una expresión";

	public final static String Sentencia_incorrecta        = "Sentencia incorrecta";
	public final static String Expresion_incorrecta        = "Expresion incorrecta";		

	// Llamada a función
	public final static String Tipo_parametro_incorrecto     = "Tipo del parámetro incorrecto";
	public final static String Numero_incorrecto_parametros  = "Numero incorrecto de parámetros";	
	public final static String Simbolo_Funcion_no_declarada = "La función no ha sido declarada previamente";
	public final static String Retorno_de_funcion_incorrecto  = "La función tiene que devolver un tipo entero";
	public final static String Retorno_de_funcion_incorrecto_2  = "No se puede devolver un tipo entero en una sentencia";
	
	// Operadores
	public final static String Operador_no_declarado     = "EL operador/identificador/retorno no ha sido declarado previamente";

	// Retorno
	public final static String No_instruccion_retorno      = "No existe instrucción de retorno";
	public final static String Tipo_incorrecto_retorno_1   = "La instrucción de retorno debe ser vacía en procedimientos/funciones VOID";
	public final static String Tipo_incorrecto_retorno_2   = "La instrucción de retorno no devuelve un tipo entero (cte, var entera o expresión resta)";
	public final static String Error_no_controlado         = "Error no controlado";

	// Para comprobacion tipo Registro
	public final static String Registro_incorrecto          = "Registro incorrecto";
	public final static String Campo_ya_declarado           = "El identificador para el campo ya ha sido utilizado";
	public final static String Campo_no_declarado           = "El campo del registro no tiene declarado este campo";
	public final static String Nivel_anidamiento_excedido	= "No se permite más de 2 anidamientos en la declaración de registros";

	// Asignaciones
	public final static String Variable_no_permitida        = "No se permiten tipos estructurados en la asignacion";
	public final static String Asignacion_ValorNoValido 	= "Valor no válido para asignación en la declaración de la variable";
	public final static String Asignacion_no_permitida      = "Esta asignacion no esta permitida";
	public final static String Referencia_no_asignable      = "Referencia no asignable";	
	
	// Bucles
	public final static String Indice_no_declarado           = "Indice de control del bucle FOR no ha sido declarado";
	public final static String Valor_indice_incorrecto       = "Solamente se permite iniciar la variable con un valor entero valido";
	public final static String Variable_no_coincide          = "Se ha de decrementar la misma variable en el bucle";
	public final static String Expresion_logica_no_valida    = "Solamente se permite expresión del tipo (a>NUM) y equivale a (a>=NUM)";
	public final static String Expresion_logica_no_valida_2  = "Se ha de decrementar la variable inicial ";
	
}
