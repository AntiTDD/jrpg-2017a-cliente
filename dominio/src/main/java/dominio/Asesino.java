package dominio;

public class Asesino extends Casta {

	public Asesino(double crit,double evasion)
	{
		this.probabilidadGolpeCritico=crit;
		this.probabilidadEvitarDa�o=evasion;
	}
	
	
	public void golpeCritico(Personaje caster, Peleable atacado)// ataca con un golpe mas poderoso de lo normal, hay que ver el porcentaje
	{
		
	}
	
	public void perspicacia()// aumenta su probabilidadEvitarDa�o, hasta un maximo posible
	{
		this.probabilidadEvitarDa�o+=0.2;// hay que ponerle un tope
	}
	
	public boolean robar(Personaje caster, Peleable atacado)//roba un item, aunque tiene una probabilidad de exito
	{
		return true;
	}
}
