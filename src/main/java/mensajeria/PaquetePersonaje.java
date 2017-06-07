package mensajeria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import dominio.Item;
import estados.Estado;

public class PaquetePersonaje extends Paquete implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int idMapa;
	private int estado;
	private String casta;
	private String nombre;
	private String raza;
	private int saludTope;
	private int energiaTope;
	private int fuerza;
	private int destreza;
	private int inteligencia;
	private int nivel;
	private int experiencia;
	private ArrayList<Item> inventario = new ArrayList<Item>();
	
	public PaquetePersonaje() {
		estado = Estado.estadoOffline;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public int getMapa(){
		return idMapa;
	}
	
	public void setMapa(int mapa){
		idMapa = mapa;
	}
	
	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCasta() {
		return casta;
	}


	public void setCasta(String casta) {
		this.casta = casta;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getRaza() {
		return raza;
	}


	public void setRaza(String raza) {
		this.raza = raza;
	}


	public int getSaludTope() {
		return saludTope;
	}


	public void setSaludTope(int saludTope) {
		this.saludTope = saludTope;
	}


	public int getEnergiaTope() {
		return energiaTope;
	}


	public void setEnergiaTope(int energiaTope) {
		this.energiaTope = energiaTope;
	}


	public int getFuerza() {
		return fuerza;
	}


	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}


	public int getDestreza() {
		return destreza;
	}


	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}


	public int getInteligencia() {
		return inteligencia;
	}


	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}
	

	public ArrayList<Item> getInventario() {
		return inventario;
	}

	public void setInventario (ArrayList<Item> inventario) {
		this.inventario = inventario;
	}
	
	//Metodo para obtener un item y su bonus
	
	public int getItem(int index) {
		return inventario.get(index).getId();
	}
	
	public void aniadirItem(String nombre, HashMap<String,Integer> bonus, Integer ubicacion) {
		
		Item nuevoItem = new Item (inventario.size(), nombre, bonus, ubicacion);
		inventario.add(nuevoItem);
		//Con esto aplico el/los bonus del nuevo item
		
		this.saludTope = this.saludTope + nuevoItem.getBonus().get("salud");
		this.destreza = this.destreza + nuevoItem.getBonus().get("destreza");
		this.energiaTope = this.energiaTope + nuevoItem.getBonus().get("energia");
		this.fuerza = this.fuerza + nuevoItem.getBonus().get("fuerza");
		this.inteligencia = this.inteligencia + nuevoItem.getBonus().get("inteligencia");
		
	}
	
	//Con este metodo aplico los bonus de mis items del inventario al iniciar sesion
	public void aplicarBonus() {
		
		for(int i=0; i<inventario.size(); i++) {
			this.saludTope = this.saludTope + inventario.get(i).getBonus().get("salud");
			this.destreza = this.destreza + inventario.get(i).getBonus().get("destreza");
			this.energiaTope = this.energiaTope + inventario.get(i).getBonus().get("energia");
			this.fuerza = this.fuerza + inventario.get(i).getBonus().get("fuerza");
			this.inteligencia = this.inteligencia + inventario.get(i).getBonus().get("inteligencia");
		}
	}
	
	//Con este metodo quito los bonus antes de desconectar al personaje. Asi no modifico sus atributos directamente
	public void quitarBonus() {
		
		for(int i=0; i<inventario.size(); i++) {
			this.saludTope = this.saludTope - inventario.get(i).getBonus().get("salud");
			this.destreza = this.destreza - inventario.get(i).getBonus().get("destreza");
			this.energiaTope = this.energiaTope - inventario.get(i).getBonus().get("energia");
			this.fuerza = this.fuerza - inventario.get(i).getBonus().get("fuerza");
			this.inteligencia = this.inteligencia - inventario.get(i).getBonus().get("inteligencia");
		}
	}

	public Object clone() {
		Object obj = null;
		obj = super.clone();
		return obj;
	}
}
