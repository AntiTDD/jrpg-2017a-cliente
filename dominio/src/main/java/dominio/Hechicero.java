package dominio;

public class Hechicero extends Casta{
	
	public Hechicero(double prob_crit,double evasion, double da�o_crit)
	{
		super(prob_crit,evasion,da�o_crit);
	}
	
	public void curar(Personaje caster, Peleable aliado) //cura la salud a un aliado
	{
		if(aliado instanceof Personaje)
			((Personaje) aliado).serCurado(caster.getInteligencia()); //la inteligencia es la "fuerza" de mis hechizos, hay que modificarlo
	}
	
	public void bolaDeFuego(Personaje caster, Peleable atacado) //lanza una bola de fuego que es mas fuerte que su ataque "basico"
	{
		atacado.serAtacado(caster.getInteligencia());
	}
	
	public void quitarEnergia(Personaje caster, Peleable atacado) //roba energia de los enemigos
	{
		if(atacado instanceof Personaje)
			((Personaje) atacado).serDesernegizado(caster.getInteligencia());
		
	}

}
