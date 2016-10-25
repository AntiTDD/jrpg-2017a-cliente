package dominio;

public interface Peleable {
	public int serAtacado(int da�o);
	public int getSalud();
	public void despuesDeTurno();
	public void atacar(Peleable atacado);
	public Item serRobado();
	public int otorgarExp();
	public int getAtaque();
	public void setAtaque(int ataque);
}
