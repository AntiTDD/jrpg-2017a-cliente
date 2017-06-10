package mensajeria;

import java.io.Serializable;
import java.util.ArrayList;

import dominio.Item;
import estados.Estado;

public class PaquetePersonaje extends Paquete implements Serializable, Cloneable {

	/**
	 * 
	 *///necesito commitear
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
	private static final int TAMANOINVENTARIO = 19;
	
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
	
	public void aniadirItem(Item nuevoItem) {
		
		if(this.inventarioLleno()) {
			this.eliminarUltimoItem();
		}
		
		this.inventario.add(nuevoItem);
		
		//actualizo al personaje con los bonus de los nuevos items
		this.saludTope = this.saludTope + nuevoItem.getBonus().get("bonoSalud");
		this.destreza = this.destreza + nuevoItem.getBonus().get("bonoDefensa");
		this.energiaTope = this.energiaTope + nuevoItem.getBonus().get("bonoEnergia");
		this.inteligencia = this.inteligencia + nuevoItem.getBonus().get("BonoMagia");
		
	}
	
	//Con este metodo aplico los bonus de mis items del inventario al iniciar sesion
	public void aplicarBonus() {
		
		for(int i=0; i<inventario.size(); i++) {
			this.saludTope = this.saludTope + inventario.get(i).getBonus().get("bonoSalud");
			this.energiaTope = this.energiaTope + inventario.get(i).getBonus().get("bonoEnergia");
			this.destreza = this.destreza + inventario.get(i).getBonus().get("bonoDefensa");
			this.inteligencia = this.inteligencia + inventario.get(i).getBonus().get("BonoMagia");
		}
	}
	
	//Con este metodo quito los bonus antes de desconectar al personaje. Asi no modifico sus atributos directamente
	public void quitarBonus() {
		
		for(int i=0; i<inventario.size(); i++) {
			this.saludTope = this.saludTope - inventario.get(i).getBonus().get("bonoSalud");
			this.energiaTope = this.energiaTope - inventario.get(i).getBonus().get("bonoEnergia");
			this.destreza = this.destreza - inventario.get(i).getBonus().get("bonoDefensa");
			this.inteligencia = this.inteligencia - inventario.get(i).getBonus().get("BonoMagia");
		}
	}
	
	public boolean inventarioLleno() {
		return inventario.size() == TAMANOINVENTARIO + 1;
	}
	
	public void eliminarUltimoItem() {
		Item ultimoItem = new Item ();
		ultimoItem = inventario.get(TAMANOINVENTARIO);
		this.saludTope = this.saludTope - ultimoItem.getBonus().get("bonoSalud");
		this.energiaTope = this.energiaTope - ultimoItem.getBonus().get("bonoEnergia");
		this.destreza = this.destreza - ultimoItem.getBonus().get("bonoDefensa");
		this.inteligencia = this.inteligencia - ultimoItem.getBonus().get("BonoMagia");
		inventario.remove(ultimoItem);
	}
	
	public ArrayList<Integer> listarItems() {
		ArrayList<Integer> listadoItems = new ArrayList<Integer>();
		
		for(int i = 0; i<inventario.size(); i++) {
			listadoItems.add(this.inventario.get(i).getId());
		}
		
		return listadoItems;
	}
	
	public Object clone() {
		Object obj = null;
		obj = super.clone();
		return obj;
	}
}
