package dominio;

public class ItemDeCabeza extends Item{

	public ItemDeCabeza(int id_Item, int prioridad, String nombre, int bono_da�o, int bono_defensa, int bono_magia,
			int bono_salud, int bono_energia,int fuerza_requerida,int inteligencia_requerida,int destreza_requerida) {
		super(id_Item, prioridad, nombre, bono_da�o, bono_defensa, bono_magia, bono_salud, bono_energia,fuerza_requerida,inteligencia_requerida,destreza_requerida);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int obtenerCantidadDeItemsMaximo() {
		// TODO Auto-generated method stub
		return 1;
	}

}
