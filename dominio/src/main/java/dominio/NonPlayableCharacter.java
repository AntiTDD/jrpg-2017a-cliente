package dominio;

public class NonPlayableCharacter implements Peleable{

	int salud;
	int fuerza;
	
	public void serAtacado(int da�o){
		salud -= da�o;
	}
	
	public void despuesDeTurno(){
		
	}
}
