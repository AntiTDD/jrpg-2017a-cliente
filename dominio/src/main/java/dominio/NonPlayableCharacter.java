package dominio;

public class NonPlayableCharacter implements Peleable{

	int salud;
	int fuerza;
	
	
	
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

	public int serAtacado(int da�o){
		salud -= da�o;
		return da�o;
	}
	
	public void despuesDeTurno(){
		
	}
}
