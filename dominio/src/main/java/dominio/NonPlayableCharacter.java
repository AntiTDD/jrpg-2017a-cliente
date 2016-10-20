package dominio;
import java.util.Random;

public class NonPlayableCharacter implements Peleable{

	private int salud;
	private  int fuerza;
	private int defensa;
	private Item[] items_dropeables;
	
	
	public boolean estaVivo() {
		return salud > 0;
	}
	
	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public void atacar(Peleable atacado)
	{
		Random rnd = new Random();
		if(rnd.nextDouble()<=0.15)//los NPC tienen 15% de golpes criticos
			{
			System.out.println("GOLPE CRITICO NPC!");
			atacado.serAtacado((int) (this.getFuerza()*1.5));//pego da�o critico
			}
		else
	atacado.serAtacado(this.getFuerza());
	}
	
	public int serAtacado(int da�o){
		 Random rnd = new Random();
			if(rnd.nextDouble()>=0.15)
			{
			da�o -= this.getDefensa()/2;
			if (da�o > 0) {
				salud -= da�o;
				return da�o;
			}
			return 0;// no le hace da�o ya que la defensa fue mayor
			}
			System.out.println("GOLPE EVADIDO NPC!");
			return 0;//esquivo el golpe
	}
	
	public void despuesDeTurno(){
		
	}
	
	public Item dropearItemAleatorio()
	{
		Random rnd =new Random();
		int aux=(int) (rnd.nextDouble()*10);
			while(aux>items_dropeables.length-1)
				aux=(int) (rnd.nextDouble()*10);
		return items_dropeables[aux];
	}
}
