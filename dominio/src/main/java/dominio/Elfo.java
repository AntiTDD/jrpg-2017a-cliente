package dominio;

import java.util.LinkedList;

public class Elfo extends Personaje{
	
	public Elfo(String nombre,Casta casta,int id)
	{
		super(nombre,casta,id);
		energia_tope+=10;
		salud=salud_tope;
		energia=energia_tope;
	}
	
	
	public Elfo(String nombre,int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta, LinkedList<Item> itemsEquipados,
			LinkedList<Item> itemsGuardados, int experiencia, int nivel, int idPersonaje) {
		super(nombre,salud, energia, fuerza, destreza, inteligencia, casta, itemsEquipados, itemsGuardados, experiencia, nivel,
				idPersonaje);
		// TODO Auto-generated constructor stub
	}



	public boolean habilidadRaza1(Peleable atacado){ //golpelevel
		if(this.getEnergia()>10)
		{
			this.setEnergia(this.getEnergia()-10);
			if(atacado.serAtacado(this.getFuerza()+this.getNivel()*10)!=0)
				return true;
		}
		return false;
	}
	
	public boolean habilidadRaza2(Peleable atacado){ //ataquebosque
		if(this.getEnergia()>10)
		{
			this.setEnergia(this.getEnergia()-10);
			if(atacado.serAtacado( (int) (this.magia))!=0)
				return true;
		}
		return false;
	}

}
