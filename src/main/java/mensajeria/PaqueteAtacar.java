package mensajeria;

import java.io.Serializable;
import java.util.HashMap;

public class PaqueteAtacar extends Paquete implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int idEnemigo;
	
	private HashMap<String,Integer> personaje = new HashMap<String,Integer>();
	private HashMap<String,Integer> atacante = new HashMap<String,Integer>();
	
	public PaqueteAtacar(int id, int idEnemigo, int nuevaSalud, int nuevaEnergia, int nuevaSaludEnemigo, int nuevaEnergiaEnemigo) {
		setComando(Comando.ATACAR);
		this.id = id;
		this.idEnemigo = idEnemigo;
		this.personaje.put("salud", nuevaSalud);
		this.atacante.put("salud", nuevaSaludEnemigo);
		this.personaje.put("energia", nuevaEnergia);
		this.atacante.put("energia", nuevaEnergiaEnemigo);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdEnemigo() {
		return idEnemigo;
	}

	public void setIdEnemigo(int idEnemigo) {
		this.idEnemigo = idEnemigo;
	}

	public HashMap<String,Integer> getMapPersonaje(){
		return personaje;
	}
	
	public HashMap<String,Integer> getMapAtacante(){
		return atacante;
	}


}
