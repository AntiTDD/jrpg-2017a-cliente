package dominio;

public class Accesorio extends Item {

	public Accesorio(int idItem, int prioridad, String nombre, String tipo, int bonoDa�o, int bonoDefensa,
			int bonoMagia, int bonoSalud, int bonoEnergia, int fuerzaRequerida, int inteligenciaRequerida,
			int destrezaRequerida) {
		super(idItem, prioridad, nombre, tipo, bonoDa�o, bonoDefensa, bonoMagia, bonoSalud, bonoEnergia,
				fuerzaRequerida, inteligenciaRequerida, destrezaRequerida);
	}

	public int obtenerCantidadDeItemsMaximo() {
		return 1;
	}

	public Item clone() {
		return new Accesorio(this.idItem, this.prioridad, this.nombre, this.tipo, this.bonoDa�o, this.bonoDefensa,
				this.bonoMagia, this.bonoSalud, this.bonoEnergia, this.fuerzaRequerida, this.inteligenciaRequerida,
				this.destrezaRequerida);
	}
}
