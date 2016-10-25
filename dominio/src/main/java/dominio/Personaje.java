package dominio;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public abstract class Personaje implements Peleable {

	protected int salud;
	protected int energia;
	protected int defensa;//depende de la destreza y de los items
	protected int ataque;//depende de la fuerza y de los items
	protected int magia;//depende de la inteligencia y de los items
	
	protected String nombre;//hay que agregarlo a todos los constructores
	
	protected int x;
	protected int y;
	
	protected int salud_tope;
	protected int energia_tope;
	
	protected int fuerza;
	protected int destreza;
	protected int inteligencia;
	protected Casta casta;

	protected LinkedList<Item> itemsEquipados;
	protected LinkedList<Item> itemsGuardados;
	protected int experiencia;
	protected int nivel;

	
	protected int idPersonaje;
	protected int item_manos = 0;
	protected Alianza clan = null;
	protected static int tabla_nivel[];

	public static void cargar_tabla_nivel() {
		Personaje.tabla_nivel = new int[100];
		Personaje.tabla_nivel[0] = 0;
		for (int i = 1; i < 100; i++)
			Personaje.tabla_nivel[i] = Personaje.tabla_nivel[i - 1] + 50;
		
	}

	public Personaje(String casta) {

	}

	public Personaje(int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			LinkedList<Item> itemsEquipados, LinkedList<Item> itemsGuardados, int experiencia, int nivel,
			int idPersonaje) {
		
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

		this.salud_tope=this.salud;
		this.energia_tope=this.energia;
		
		this.idPersonaje = idPersonaje;
		this.defensa=this.calcularPuntosDeDefensa();
		this.ataque=this.calcularPuntosDeAtaque();
		this.magia=this.calcularPuntosDeMagia();
	}

	
	
	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getMagia() {
		return magia;
	}

	public void setMagia(int magia) {
		this.magia = magia;
	}

	public int getPosicion_x() {
		return x;
	}

	public void setPosicion_x(int posicion_x) {
		this.x = posicion_x;
	}

	public int getPosicion_y() {
		return y;
	}

	public void setPosicion_y(int posicion_y) {
		this.y = posicion_y;
	}

	public Alianza getClan() {
		return clan;
	}

	public void setClan(Alianza clan) {
		this.clan = clan;
		clan.a�adirPersonaje(this);//////////////////////
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
		if(salud==0) return;
		if(atacado.getSalud()>0){
			if (rnd.nextDouble() <= this.casta.getProbabilidadGolpeCritico() + this.destreza / 1000) {/// estoy
																									/// sacando
																									/// el
																									/// 10%
																									/// de
																									/// la
																									/// destreza
																									/// para
																									/// aumentar
																									/// la
																									/// prob
																									/// de
																									/// critico
				System.out.println("GOLPE CRITICO!");
				System.out.println("Da�o inflingido: "+(this.ataque * this.getCasta().getDa�oCritico()));
				atacado.serAtacado((int) (this.ataque * this.getCasta().getDa�oCritico()));// pego
																											// da�o
																											// critico
			} else
				{System.out.println("Da�o inflingido: "+(this.ataque));
				atacado.serAtacado(this.ataque);}
		}
	}

	public void despuesDeTurno() {

	}

	public boolean puedeAtacar() {
		return true;
	}

	public int calcularPuntosDeAtaque() {
		int da�o_items = 0;
		Iterator<Item> it = this.itemsEquipados.iterator();
		while (it.hasNext())
			da�o_items += it.next().bono_da�o;
		//System.out.println("Da�o : " + (this.getFuerza() + da�o_items));
		return (this.getFuerza() + da�o_items); // hago que el da�o de un
		// personaje sea igual a la
		// fuerza que tiene mas el da�o
		// de sus items

	}

	public int calcularPuntosDeDefensa() {
		int defensa_items = 0;
		Iterator<Item> it = this.itemsEquipados.iterator();
		while (it.hasNext())
			defensa_items += it.next().bono_defensa;
		//System.out.println("Defensa : " + (this.getDefensa() * 0.5 + defensa_items + this.getDestreza()));
		return (int) (defensa_items + this.getDestreza());
	}

	public int calcularPuntosDeMagia() {
		int magia_items = 0;
		Iterator<Item> it = this.itemsEquipados.iterator();
		while (it.hasNext())
			magia_items += it.next().bono_magia;
		//System.out.println("Magia : " + (this.getInteligencia() + magia_items));
		return (this.getInteligencia() + magia_items);

	}
	
/*	public int calcularPuntosDeSalud()
	{
		int salud_items=0;
		Iterator<Item> it = this.itemsEquipados.iterator();
		while (it.hasNext())
			salud_items += it.next().bono_salud;
		System.out.println("Salud del pj: "+this.getSalud()+" Salud del item"+salud_items);
		return (this.getSalud()+salud_items);
	} ////MAL IMPLEMENTADOSSSSSSSSSSSSSSSSSSSSSSSS
	
	public int calcularPuntosDeEnergia()
	{
		int energia_items=0;
		Iterator<Item> it = this.itemsEquipados.iterator();
		while (it.hasNext())
			energia_items += it.next().bono_energia;
		System.out.println("Energia del pj: "+this.getEnergia()+" Energia del item:"+energia_items);
		return (this.getEnergia()+energia_items);
	}*/ //MAL IMPLEMENTADOSSSSSSSSSSSSSSSSSSSSSSSS
	
	public void modificarAtributos()
	{
	//	this.salud=this.calcularPuntosDeSalud();
	//	this.energia=this.calcularPuntosDeEnergia();
		this.ataque=this.calcularPuntosDeAtaque();
		this.defensa=this.calcularPuntosDeDefensa();
		this.magia=this.calcularPuntosDeMagia();
		
	}

	public boolean estaVivo() {
		return salud > 0;
	}

	public int serAtacado(int da�o) {
		Random rnd = new Random();
		if (rnd.nextDouble() >= this.getCasta().getProbabilidadEvitarDa�o()) {
			da�o -= this.defensa;
			System.out.println("Defensa obtenida: "+this.defensa);
			if (da�o > 0) {
				if(salud<=da�o){
					da�o=salud;
					salud=0;
				}
				else{
					salud -= da�o;
					return da�o;
				}
			}
			return 0;// no le hace da�o ya que la defensa fue mayor
		}
		System.out.println("GOLPE EVADIDO!");
		return 0;// esquivo el golpe
	}

	public int serRobadoSalud(int da�o) {
		da�o -= this.defensa;
		if (da�o <= 0)
			return 0;
		if ((salud - da�o) >= 0)
			salud -= da�o;
		else
			{da�o = salud;// le queda menos salud que el da�o inflingido
			salud=0;
			}
		return da�o;
	}

	public int serDesernegizado(int da�o) {
		da�o -= this.defensa;
		if (da�o <= 0)
			return 0;
		if ((energia - da�o) >= 0)
			energia -= da�o;
		else
			{da�o = energia;// le queda menos energia que el da�o inflingido
			energia=0;
			}
		return da�o;
	}

	public void serCurado(int salud) {
		if ((this.salud + salud) <= this.salud_tope)
			this.salud += salud;
		else
			this.salud = this.salud_tope;
			
			
	}

	public void serEnergizado(int energia) {
		if ((this.energia + energia) <= this.energia_tope)
			this.energia += energia;
		else
			this.energia = this.energia_tope;
	}

	public boolean desequiparItem(Item i) { // lo puedo usar para desequipar un
											// item o para dropear directamente
		// un item equipado
		if (this.itemsEquipados.remove(i)) {
			if (i.getTipo() == "Manos")
				this.item_manos--;
			this.modificarAtributos();
			this.salud_tope-=i.getBono_salud();
			this.energia_tope-=i.getBono_energia();
			this.salud=this.salud_tope;
			this.energia=this.energia_tope;
			return true;
		}
		return false;
	}

	public boolean dropearItemMochila(Item i) { // aca se dropearia desde la
												// mochila
		return this.itemsGuardados.remove(i);
	}

	public boolean guardarItem(Item i) {

		if (this.itemsGuardados.size() < 20) {
			this.itemsGuardados.add(i);
			return true;
		}
		return false;
	}

	public boolean equiparItem(Item i) {
		if (this.itemsEquipados.size() <= 6) {
			if (this.puedeEquipar(i)) {
				this.itemsEquipados.add(i);
				this.modificarAtributos();
				this.salud_tope+=i.getBono_salud();
				this.energia_tope+=i.getBono_energia();
				this.salud=this.salud_tope;
				this.energia=this.energia_tope;
				return true;
			}

		}

		return false;
	}

	public boolean puedeEquipar(Item i) {
		if (this.fuerza < i.getFuerza_requerida() || this.destreza < i.getDestreza_requerida()
				|| this.inteligencia < i.getInteligencia_requerida())
			return false;
		if (i.getTipo() == "Manos") {
			if (item_manos < 2) {
				item_manos++;
				return true;
			}
			return false;
		}

		Iterator<Item> it = this.itemsEquipados.iterator();
		while (it.hasNext()) {
			if (it.next().getTipo() == i.getTipo())
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

	public Item serRobado() {
		int num_item_desequipado;
		Item item_robado;
		if (this.itemsEquipados.size() == 0 && this.itemsGuardados.size() == 0)
			return null;

		Random rnd = new Random();

		if (rnd.nextInt(2) == 0)// 0=itemsEquipados, 1=itemsGuardados
		{
			if (this.itemsEquipados.size() != 0) {
				num_item_desequipado = rnd.nextInt(this.itemsEquipados.size());
				item_robado = this.itemsEquipados.get(num_item_desequipado);
				this.desequiparItem(item_robado);
				return item_robado;
			}
		}
		num_item_desequipado = rnd.nextInt(this.itemsGuardados.size());
		item_robado = this.itemsGuardados.get(num_item_desequipado);
		this.dropearItemMochila(item_robado);
		return item_robado;
	}

	public Item getEquipado(int i)
	{
		if(this.itemsEquipados.size()>i)
			return this.itemsEquipados.get(i);
		return null;
	}
	
	public Item getMochila(int i)
	{
		if(this.itemsGuardados.size()>i)
		return this.itemsGuardados.get(i);
		return null;
	}
	
	public Item otorgarItem()
	{
		if(this.getItemsEquipados().size()==0 && this.getItemsGuardados().size()==0)
			return null;
		Item aux;
		Random rnd = new Random();
		if(this.getItemsGuardados().size()>0)
			{
			aux = this.getItemsGuardados().get(rnd.nextInt(this.itemsGuardados.size()));
			this.dropearItemMochila(aux);
			return aux;
			}
		else
		{
			aux = this.getItemsEquipados().get(rnd.nextInt(this.itemsEquipados.size()));
			this.desequiparItem(aux);
			return aux;
		}
		
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

/*	public void asignarPuntos() {
		int puntos = this.nivel / 10 + 1;
		int p_fuerza, p_inteligencia, p_destreza;
		System.out.println("Usted tiene " + puntos + " puntos para repartir");
		System.out.println("Ingrese los puntos a repartir entre F I D:");
		Scanner sc = new Scanner(System.in);
		while (puntos == this.nivel / 10 + 1) {
			p_fuerza = sc.nextInt();
			p_inteligencia = sc.nextInt();
			p_destreza = sc.nextInt();
			if ((p_fuerza + p_inteligencia + p_destreza == puntos) && (this.fuerza + p_fuerza <= 200)
					&& (this.inteligencia + p_inteligencia <= 200) && (this.destreza + p_destreza <= 200)) {
				this.fuerza += p_fuerza;
				this.inteligencia += p_inteligencia;
				this.destreza += p_destreza;
				puntos = 0;
			} else
				System.out.println("ASIGNE BIEN LOS PUNTOS F I D:");

		}
		sc.close();

	}*/

	public void subirNivel() {

		int aux = 0;
		if(this.nivel==100)
		{
			System.out.println("Ya ha alcanzado el maximo nivel!");
			return;
		}
		while (this.nivel!=100 && (this.experiencia >= Personaje.tabla_nivel[this.nivel] + aux)  ) {
			aux += Personaje.tabla_nivel[this.nivel];
			this.nivel++;
	//		this.asignarPuntos();
			this.modificarAtributos();
		}
		this.experiencia -= aux;
	}

	public void ganarExperiencia(int exp) {
		this.experiencia += exp;
		System.out.println("oaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		if (experiencia >= Personaje.tabla_nivel[this.nivel])
			this.subirNivel();
	}

	public int otorgarExp()
	{
		return this.nivel*40;
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

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	public double distanciaCon(Personaje p) {
		return Math.sqrt( Math.pow(this.x - p.x, 2)
				+ Math.pow(this.y - p.y, 2));
	}

	public void habilidadCasta1(Peleable atacado) {
		this.getCasta().habilidad1(this, atacado);
	}

	public void habilidadCasta2(Peleable atacado) {
		this.getCasta().habilidad2(this, atacado);
	}

	public void habilidadCasta3(Peleable atacado) {
		this.getCasta().habilidad3(this, atacado);
	}

	public abstract void habilidadRaza1(Peleable atacado);
	public abstract void habilidadRaza2(Peleable atacado);
	
	public int elegirOpcion(){
		return 1;
	}
	
	public LinkedList <Personaje> armarBatallonPjs()
	{
		
		LinkedList <Personaje> batallon_amigo = new LinkedList();
		Iterator <Personaje> it = this.getClan().getAliados().iterator(); 
		Personaje aux;
		while(it.hasNext())
		{
			aux=it.next();
			if(aux.distanciaCon(this)<=10)
				batallon_amigo.add(aux);
		}
		return batallon_amigo;
	}
	
}
