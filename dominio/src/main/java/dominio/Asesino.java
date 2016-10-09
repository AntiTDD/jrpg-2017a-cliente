package dominio;

public class Asesino extends Casta {

	public Asesino(double prob_crit,double evasion,double da�o_crit)
	{
		super(prob_crit,evasion,da�o_crit);
	}
	
	
	public void golpeCritico(Personaje caster, Peleable atacado)// ataca con un golpe mas poderoso de lo normal, hay que ver el porcentaje
	{
		atacado.serAtacado((int)(caster.getFuerza()*caster.getCasta().getDa�oCritico()));
	}
	
	public void perspicacia()// aumenta su probabilidadEvitarDa�o, hasta un maximo posible
	{
		if(this.getProbabilidadEvitarDa�o()>0.5)
		this.probabilidadEvitarDa�o+=0.15;// hay que ponerle un tope
	}
	
	public boolean robar(Personaje caster, Peleable atacado)//roba un item, aunque tiene una probabilidad de exito
	{
		return true;
	}
}
