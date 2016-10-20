package dominio;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Personaje implements Peleable {

	protected int salud;
	protected int energia;
	protected int fuerza;
	protected int destreza;
	protected int inteligencia;
	protected Casta casta;

	
	protected LinkedList<Item> itemsEquipados;
	protected LinkedList<Item> itemsGuardados;
	protected int experiencia;
	protected int nivel;

	protected int defensa;
	protected int idPersonaje;
	protected int item_manos = 0;
	protected Alianza clan = null;
	protected int salud_tope;// nose si va
	protected int energia_tope;// nose si va

	public Personaje(String casta) {

	}

	public Personaje(int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			LinkedList<Item> itemsEquipados, LinkedList<Item> itemsGuardados, int experiencia, int nivel, int idPersonaje, int defensa) {

		this.salud = salud;
		this.energia = energia;
		this.fuerza = fuerza;
		this.destreza = destreza;
		this.inteligencia = inteligencia;
		this.casta = casta;
		this.itemsEquipados = itemsEquipados;
		this.itemsGuardados = itemsGuardados;
		this.experiencia = experiencia;
		this.nivel = nivel;

		this.idPersonaje = idPersonaje;// agregue un Id para la base de datos
										// (nose si se va a implementar asi)
		this.defensa = defensa;// creo que es mas comodo tener un atributo
								// defensa que un metodo calcularPuntosDefensa
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
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

	public Casta getCasta() {
		return casta;
	}

	public void setCasta(Casta casta) {
		this.casta = casta;
	}

	public LinkedList<Item> getItemsEquipados() {
		return itemsEquipados;
	}

	public void setItemsEquipados(LinkedList<Item> itemsEquipados) {
		this.itemsEquipados = itemsEquipados;
	}

	public LinkedList<Item> getItemsGuardados() {
		return itemsGuardados;
	}

	public void setItemsGuardados(LinkedList<Item> itemsGuardados) {
		this.itemsGuardados = itemsGuardados;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getIdPersonaje() {
		return idPersonaje;
	}

	public void setIdPersonaje(int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public void atacar(Peleable atacado) {
		Random rnd = new Random();
		if (rnd.nextDouble() <= this.getCasta().getProbabilidadGolpeCritico()) {
			System.out.println("GOLPE CRITICO!");
			atacado.serAtacado((int) (this.calcularPuntosDeAtaque() * this.getCasta().getDa�oCritico()));// pego
																											// da�o
																											// critico
		}
		else
		atacado.serAtacado(this.calcularPuntosDeAtaque());
	}

	public void despuesDeTurno() {

	}

	public boolean puedeAtacar() {
		return true;
	}

	public int calcularPuntosDeAtaque() {
		int da�o_items = 0;
		Iterator<Item> it = this.itemsEquipados.iterator();
		while(it.hasNext())
			da�o_items += it.next().bono_da�o;
		System.out.println("Da�o causado: " + (this.getFuerza() + da�o_items));
		return (this.getFuerza() + da�o_items); // hago que el da�o de un
		// personaje sea igual a la
		// fuerza que tiene mas el da�o
		// de sus items, luego hay que
		// modificarlo

	}

	public int calcularPuntosDeDefensa() {
		int defensa_items = 0;
		Iterator<Item> it = this.itemsEquipados.iterator();
		while(it.hasNext())
			defensa_items += it.next().bono_defensa;
		System.out.println("Defensa obtenida: " + (this.getDefensa() * 0.5 + defensa_items + this.getDestreza()));
		return (int) (this.getDefensa() * 0.5 + defensa_items + this.getDestreza());
	}

	public boolean estaVivo() {
		return salud > 0;
	}

	public int serAtacado(int da�o) {
		Random rnd = new Random();
		if (rnd.nextDouble() >= this.getCasta().getProbabilidadEvitarDa�o()) {
			da�o -= this.calcularPuntosDeDefensa();
			if (da�o > 0) {
				salud -= da�o;
				return da�o;
			}
			return 0;// no le hace da�o ya que la defensa fue mayor
		}
		System.out.println("GOLPE EVADIDO!");
		return 0;// esquivo el golpe
	}

	public boolean serDesernegizado(int da�o) { //nose si se va a usar este metodo, mas facil es manejarse con get y set
		if(energia>0 && energia-da�o>0)
			{
			energia -= da�o;
			return true;
			}
		return false;
	}

	public void serCurado(int salud) {
		if(this.salud+salud<=this.salud_tope)
			this.salud += salud;
		else
			this.salud=salud_tope;
	}

	public void serEnergizado(int energia) {
		if(this.energia+energia<=this.energia_tope)
			this.energia += energia;
		else
			this.energia=energia_tope;
	}

	public boolean desequiparItem(Item i) { // lo puedo usar para desequipar un
											// item o para dropear directamente
										// un item equipado
		if(this.itemsEquipados.remove(i))
		{
		if (i.getTipo()=="Manos")
			this.item_manos--;
		return true;
		}
		return false;
	}

	public boolean dropearItem(Item i) { // aca se dropearia desde la mochila
		return this.itemsGuardados.remove(i);
		}

	public boolean guardarItem(Item i) {
		
		if(this.itemsGuardados.size()<=20)
		{
			this.itemsGuardados.add(i);
			return true;
		}
		return false;	
	}

	public boolean equiparItem(Item i) {
		if(this.itemsEquipados.size()<=6)
		{
			if(this.puedeEquipar(i))
				{
				this.itemsEquipados.add(i);
			
				return true;
				}
			
		}

		return false;
	}
			
			
		
	 boolean puedeEquipar(Item i) {

		 if(i.getTipo() == "Manos")
		 {
			 if (item_manos < 2) 
			 	{
					item_manos++;
					return true;
				}
			 return false;
		 }
		 
		 Iterator<Item> it = this.itemsEquipados.iterator();
			while(it.hasNext())
			{
				if(it.next().getTipo() == i.getTipo())
					return false;
			}
		 return true;
		}


	public String listaItemsEquipados() {
		String aux = "";
		for (Item i : this.itemsEquipados) {
			if (i != null)
				aux += i.toString();
		}
		return aux;

	}

	public String listaItemsGuardados() {
		String aux = "";
		for (Item i : this.itemsGuardados) {
			if (i != null)
				aux += i.toString();
		}
		return aux;

	}

	public void crearAlianza(String nombre_alianza) {
		this.clan = new Alianza(nombre_alianza);
		this.clan.a�adirPersonaje(this);
	}

	public void salirDeAlianza() {
		if (this.clan != null) {
			this.clan.eliminarPersonaje(this);
			this.clan = null;
		}
	}

	public boolean aliar(Personaje nuevo_aliado) {
		if (nuevo_aliado.clan == null) {
			nuevo_aliado.clan = this.clan;
			this.clan.a�adirPersonaje(nuevo_aliado);
			return true;
		} else
			System.out.println("NO SE PUEDE ALIAR YA QUE YA ESTA EN UNA ALIANZA");
		return false;
	}

	public boolean subirNivel() {
		if (this.nivel < 100) {
			this.nivel++;
			return true;
		} else {
			System.out.println("Maximo nivel alcanzado");
			return false;
		}
	}

	public void ganarExperiencia(int exp) {
		experiencia += exp;
	}

	/*
	 * public void habilidad1(Peleable atacado) { if(this.getCasta() instanceof
	 * Guerrero) { if(this.getEnergia()>10)// habria que ver cuanta energia
	 * consume cada habilidad {
	 * 
	 * Guerrero g1= (Guerrero)this.getCasta(); g1.golpeDoble(this, atacado);
	 * this.setEnergia(this.getEnergia()-10); } }
	 * 
	 * if(this.getCasta() instanceof Hechicero) { if(this.getEnergia()>10) {
	 * Hechicero h1= (Hechicero)this.getCasta(); h1.curar(this, atacado);
	 * this.setEnergia(this.getEnergia()-10); } }
	 * 
	 * if(this.getCasta() instanceof Asesino) { if(this.getEnergia()>10){
	 * Asesino a1= (Asesino)this.getCasta(); a1.golpeCritico(this, atacado);
	 * this.setEnergia(this.getEnergia()-10); } }
	 * 
	 * }
	 * 
	 * 
	 * public void habilidad2( Peleable atacado) { if(this.getCasta() instanceof
	 * Guerrero) { if(this.getEnergia()>10){ Guerrero g1=
	 * (Guerrero)this.getCasta(); g1.aumentarDefensa(this);
	 * this.setEnergia(this.getEnergia()-10); } }
	 * 
	 * if(this.getCasta() instanceof Hechicero) { if(this.getEnergia()>10){
	 * Hechicero h1= (Hechicero)this.getCasta(); h1.bolaDeFuego(this, atacado);
	 * this.setEnergia(this.getEnergia()-10); } }
	 * 
	 * if(this.getCasta() instanceof Asesino) { if(this.getEnergia()>10){
	 * Asesino a1= (Asesino)this.getCasta(); a1.perspicacia();
	 * this.setEnergia(this.getEnergia()-10); } } }
	 * 
	 * public void habilidad3(Peleable atacado) { if(this.getCasta() instanceof
	 * Guerrero) { if(this.getEnergia()>10){ Guerrero g1=
	 * (Guerrero)this.getCasta(); g1.ignoraDefensa(this, atacado);
	 * this.setEnergia(this.getEnergia()-10); } }
	 * 
	 * if(this.getCasta() instanceof Hechicero) { if(this.getEnergia()>10){
	 * Hechicero h1= (Hechicero)this.getCasta(); h1.quitarEnergia(this,
	 * atacado); this.setEnergia(this.getEnergia()-10); } }
	 * 
	 * if(this.getCasta() instanceof Asesino) { if(this.getEnergia()>10){
	 * Asesino a1= (Asesino)this.getCasta(); a1.robar(this, atacado);
	 * this.setEnergia(this.getEnergia()-10); } } }
	 */

	public void habilidadCasta1(Peleable atacado) {
		this.getCasta().habilidad1(this, atacado);
	}

	public void habilidadCasta2(Peleable atacado) {
		this.getCasta().habilidad1(this, atacado);
	}

	public void habilidadCasta3(Peleable atacado) {
		this.getCasta().habilidad1(this, atacado);
	}

	public static void main(String[] args) {
		Humano h = new Humano(100, 100, 15, 20, 30, new Guerrero(0.2, 0.3, 1.5), new LinkedList<Item>(), new LinkedList<Item>(), 0, 1, 1,
				50);
		Orco o = new Orco(200, 100, 15, 20, 30, new Guerrero(0.2, 0.3, 1.5), new LinkedList<Item>(), new LinkedList<Item>(), 0, 1, 1, 50);

		ItemDeManos excalibur = new ItemDeManos(1, 10, "Excalibur","Manos", 50, 0, 0, 0, 0, 10, 10, 10);
		ItemDeTorso cotaDeMalla = new ItemDeTorso(2, 10, "Cota de Malla","Manos", 0, 20, 0, 0, 0, 10, 10, 10);

		h.equiparItem(excalibur);
		h.equiparItem(excalibur);
		
		System.out.println("Energia Humano:" + " " + h.getEnergia());
		System.out.println("Vida del Orco:" + " " + o.getSalud());

		// h.habilidadCasta1(o);
		h.atacar(o);

		System.out.println("Energia Humano:" + " " + h.getEnergia());
		System.out.println("Vida del Orco:" + " " + o.getSalud());

	}

}
