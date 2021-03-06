package mensajeria;

import com.google.gson.Gson;

public abstract class Comando {
	
	public static final String[] CLASSNAMES = { "Conexion", "CreacionPJ","Desconectar" ,"InicioSesion","MostrarMapas","Movimiento", "Registro", "Salir", "Batalla", "Atacar", "FinalizarBatalla", "ActualizarPersonaje", "Comercio" };

	public static final int ACTUALIZARPERSONAJE = 11;
	public static final int ATACAR = 9;
	public static final int BATALLA = 8;
	public static final int CONEXION = 0;
	public static final int CREACIONPJ = 1;
	public static final int DESCONECTAR = 2;
	public static final int FINALIZARBATALLA = 10; 
	public static final int INICIOSESION = 3;
	public static final int MOSTRARMAPAS = 4;
	public static final int MOVIMIENTO = 5;
	public static final int REGISTRO = 6;
	public static final int SALIR = 7;
	public static final int COMERCIO = 12;
	public static final int ACTUALIZARCOMERCIO = 13;
	
	protected final Gson gson = new Gson();
	protected String cadenaLeida;
	
	public abstract void ejecutar();
	
	public void setCadena(String cadenaLeida) {
		this.cadenaLeida = cadenaLeida;
	}
}
