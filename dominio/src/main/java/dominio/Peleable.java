package dominio;

public interface Peleable {
	public int serAtacado(int da�o);
	public int getSalud();
	public void despuesDeTurno();
	public void atacar(Peleable atacado);
}
