package mensajeria;

import java.io.Serializable;
import java.util.ArrayList;

import dominio.Item;

public class PaqueteComercio extends Paquete implements Serializable, Cloneable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private int idComerciante;
	private boolean respuesta;
	private boolean resultadoComercio;
	
	private ArrayList<Item> itemsAComerciar = new ArrayList<Item>();
	private ArrayList<Item> itemsARecibir = new ArrayList<Item>();
	
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

	public ArrayList<Item> getItemsAComerciar() {
		return itemsAComerciar;
	}

	public void setItemsAComerciar(ArrayList<Item> itemsAComerciar) {
		this.itemsAComerciar = itemsAComerciar;
	}

	public ArrayList<Item> getItemsARecibir() {
		return itemsARecibir;
	}

	public void setItemsARecibir(ArrayList<Item> itemsARecibir) {
		this.itemsARecibir = itemsARecibir;
	}

	public boolean getResultadoComercio() {
		return resultadoComercio;
	}

	public void setResultadoComercio(boolean resultadoComercio) {
		this.resultadoComercio = resultadoComercio;
	}

}
