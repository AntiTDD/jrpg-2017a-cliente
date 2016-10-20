package dominio;

import java.util.LinkedList;

public class Orco extends Personaje {
	
	public Orco(String casta){
		super(casta);
	}
	
	
	
	public Orco(int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta, LinkedList<Item> itemsEquipados,
			LinkedList<Item> itemsGuardados, int experiencia, int nivel, int idPersonaje,int defensa) {
		super(salud, energia, fuerza, destreza, inteligencia, casta, itemsEquipados, itemsGuardados, experiencia, nivel,
				idPersonaje,defensa);
		
	}



	public void superGole(Batallon enemigos){
		
	}
	
	public void mordiscoDeVida(Peleable atacado){
		if(this.getEnergia()>10)
		{
		int da�o_causado = atacado.serAtacado(this.getFuerza());
		this.serCurado(da�o_causado);//se cura con el da�o que le causo al oponente
		this.setEnergia(this.getEnergia()-10);
		}
	}

}
