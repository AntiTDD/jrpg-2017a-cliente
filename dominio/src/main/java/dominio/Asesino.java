package dominio;

import java.util.Random;

public class Asesino extends Casta {

	private double probabilidadDeRobo = 0.2;

	public Asesino(double prob_crit, double evasion, double da�o_crit) {
		super(prob_crit, evasion, da�o_crit);
		this.nombreCasta="Asesino";
	}

	public Asesino() {
		super();
		this.nombreCasta="Asesino";
		habilidadesCasta = new String[3];
		habilidadesCasta[0] = "Golpe Cr�tico";
		habilidadesCasta[1] = "Aumentar Evasi�n";
		habilidadesCasta[2] = "Robar";
	}

	// Golpe Cr�tico
	public boolean habilidad1(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado.serAtacado((int) (caster.ataque * caster.getCasta().getDa�oCritico())) > 0)
				return true;
		}
		return false;
	}

	// Aumentar Evasion
	public boolean habilidad2(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (this.getProbabilidadEvitarDa�o() + 0.15 < 0.5)
				this.probabilidadEvitarDa�o += 0.15;
			else
				this.probabilidadEvitarDa�o = 0.5;
			return true;
		}
		return false;
	}

	// Robar
	public boolean habilidad3(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			Random rnd = new Random();
			if ((rnd.nextDouble() <= this.probabilidadDeRobo + caster.getDestreza() / 1000)
					&& caster.itemsGuardados.size() < 20) {
				Item itemRobado = atacado.serRobado();
				if (itemRobado != null) {
					caster.itemsGuardados.add(itemRobado);
					return true;
				}
			}
		}
		return false;
	}

}
