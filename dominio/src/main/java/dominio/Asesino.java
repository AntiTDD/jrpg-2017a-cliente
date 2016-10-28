package dominio;

import java.util.Random;

public class Asesino extends Casta {

	private double prob_robar = 0.2;/// y tambien va a depender de la destreza

	public Asesino(double prob_crit, double evasion, double da�o_crit) {
		super(prob_crit, evasion, da�o_crit);
	}

	public Asesino()// creo que se llama por defecto no? preguntarle a lucas
	{
		super();
	}

	public boolean habilidad1(Personaje caster, Peleable atacado)// ataca con un
																// golpe mas
																// poderoso de
																// lo normal,
																// hay que ver
																// el porcentaje
	{
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if(atacado.serAtacado((int) (caster.ataque * caster.getCasta().getDa�oCritico()))!=0)
				return true;
		}
		return false;
	}

	public boolean habilidad2(Personaje caster, Peleable atacado)// aumenta su
																// probabilidadEvitarDa�o,
																// hasta un
																// maximo
																// posible
	{
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (this.getProbabilidadEvitarDa�o() + 0.15 < 0.5)
				this.probabilidadEvitarDa�o += 0.15;// hay que ponerle un
													// tope(en este caso 0.5)
			else
				this.probabilidadEvitarDa�o = 0.5;
			return true;
		}
		return false;
	}

	public boolean habilidad3(Personaje caster, Peleable atacado)// roba un
																	// item,
																	// aunque
																	// tiene
																	// una
																	// probabilidad
																	// de exito
	{

		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			Random rnd = new Random();

			if ((rnd.nextDouble() <= this.prob_robar + caster.getDestreza() / 1000)
					&& caster.itemsGuardados.size() < 20) {
				Item aux = atacado.serRobado();
				if (aux != null) {
					caster.itemsGuardados.add(aux);
					System.out.println("Se pudo robar!");
					return true;
				} else
					System.out.println("No se pudo robar!(No hay items para robar)");

			} else
				System.out.println("No se pudo robar!");

		}
		return false;
	}
}
