package mensajeria;

import java.io.Serializable;

public class PaqueteComercio extends Paquete implements Serializable, Cloneable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private int idComerciante;
	private boolean respuesta;
	
	public PaqueteComercio() {
		setComando(Comando.COMERCIO);
		respuesta = true;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdComerciante() {
		return idComerciante;
	}

	public void setIdEnemigo(int idComerciante){
		this.idComerciante = idComerciante;
	}
	
	public boolean getRespuesta() {
		return this.respuesta;
	}
	
	public void setRespuesta(boolean respuesta) {
		this.respuesta = respuesta;
	}

}
