package entidades;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import juego.Juego;
import mundo.Tile;
import recursos.Recursos;
import entidades.Animacion;

public class Entidad {

	Juego juego;
	
	// Tama�o de la entidad
	private int ancho;
	private int alto;
	
	// Posiciones
	private float x;
	private float y;
	private float xInicio;
	private float yInicio;
	private float xFinal;
	private float yFinal;
	private float offSetX;
	private float offSetY;
	private int posMouse[];

	// Calculo de movimiento
	private float difX;
	private float difY;
	private float relacion;
	
	// Posicion final
	private int auxX;
	private int auxY;

	// Movimiento Actual
	private boolean enMovimiento;
	private boolean horizontal;
	private boolean vertical;
	private boolean diagonalInfIzq;
	private boolean diagonalInfDer;
	private boolean diagonalSupIzq;
	private boolean diagonalSupDer;

	
	// Animaciones
	private final Animacion moverIzq;
	private final Animacion moverArribaIzq;
	private final Animacion moverArriba;
	private final Animacion moverArribaDer;
	private final Animacion moverDer;
	private final Animacion moverAbajoDer;
	private final Animacion moverAbajo;
	private final Animacion moverAbajoIzq;
	
	public Entidad(Juego juego, int tamAncho, int tamAlto, float spawnX, float spawnY) {
		this.juego = juego;
		this.ancho = tamAncho;
		this.alto = tamAlto;
		offSetX = ancho / 2;
		offSetY  = alto / 2;
		x = spawnX - offSetX;
		y = spawnY - offSetY;
		
		moverIzq = new Animacion(200, Recursos.ogroIzq); 
		moverArribaIzq = new Animacion(200, Recursos.ogroArribaIzq);
		moverArriba = new Animacion(200, Recursos.ogroArriba);
		moverArribaDer = new Animacion(200, Recursos.ogroArribaDer);
		moverDer = new Animacion(200, Recursos.ogroDer);
		moverAbajoDer = new Animacion(200, Recursos.ogroAbajoDer);
		moverAbajo = new Animacion(200, Recursos.ogroAbajo);
		moverAbajoIzq = new Animacion(200, Recursos.ogroAbajoIzq);
	}

	public void actualizar() {
		moverIzq.actualizar();
		moverArribaIzq.actualizar();
		moverArriba.actualizar();
		moverArribaDer.actualizar();
		moverDer.actualizar();
		moverAbajoDer.actualizar();
		moverAbajo.actualizar();
		moverAbajoIzq.actualizar();
		getEntrada();
		mover();
	}

	public void getEntrada() {

		posMouse = juego.getHandlerMouse().getPosMouse();

		if (juego.getHandlerMouse().getNuevoRecorrido()) {
			diagonalInfIzq = false;
			diagonalInfDer = false;
			diagonalSupIzq = false;
			diagonalSupDer = false;
			vertical = false;
			horizontal = false;
			enMovimiento = false;

			x = Math.round(x);
			y = Math.round(y);
			xInicio = x;
			yInicio = y;
			
			xFinal = posMouse[0] - offSetX;
			yFinal = posMouse[1] - offSetY;

			System.out.println(xInicio + " " + yInicio);
			
			difX = Math.abs(xFinal - xInicio);
			difY = Math.abs(yFinal - yInicio);
			relacion = difX / difY;

			if (difX == 0 || difY == 0) {
				relacion = 1;
			}
			
			if (difX < ancho && yInicio != yFinal) {
				vertical = true;
				horizontal = true;
			}
			if (difY < alto && xInicio != xFinal) {
				horizontal = true;
				vertical = true;
			}

			if (!vertical && !horizontal) {
				if (xFinal > xInicio && yFinal > yInicio) {
					diagonalInfDer = true;
				} else if (xFinal < xInicio && yFinal > yInicio) {
					diagonalInfIzq = true;
				} else if (xFinal > xInicio && yFinal < yInicio) {
					diagonalSupDer = true;
				} else if (xFinal < xInicio && yFinal < yInicio) {
					diagonalSupIzq = true;
				}
			}

			juego.getHandlerMouse().setNuevoRecorrido(false);
			enMovimiento = true;
		}
	}

	public void mover() {

		if (enMovimiento && (x != xFinal || y != yFinal)) {
			
			if (vertical) {
				if (yFinal > y) {
					y++;
				} else {
					y--;
				}
			}

			if (horizontal) {
				if (xFinal > x) {
					x++;
				} else {
					x--;
				}
			}

			if (diagonalInfDer) {
				x += relacion;
				y++;
			} else if (diagonalInfIzq) {
				x -= relacion;
				y++;
			} else if (diagonalSupDer) {
				x += relacion;
				y--;
			} else if (diagonalSupIzq) {
				x -= relacion;
				y--;
			}
			
			auxX = (int) Math.round(x);
			auxY = (int) Math.round(y);

			if (horizontal || vertical) {
				if (auxX == xFinal) {
					horizontal = false;
				}

				if (auxY == yFinal) {
					vertical = false;
				}
			}

			if (auxX == xFinal && auxY == yFinal) {
				diagonalInfIzq = false;
				diagonalInfDer = false;
				diagonalSupIzq = false;
				diagonalSupDer = false;
				enMovimiento = false;
			}
		}
	}
	
	public void graficar(Graphics g) {
		g.drawImage(getFrameAnimacionActual(), (int) x, (int) y, ancho, alto, null);
	}
	
	private BufferedImage getFrameAnimacionActual() {
		if(horizontal && x > xFinal) {
			return moverIzq.getFrameActual();
		} else if(horizontal && x < xFinal) {
			return moverDer.getFrameActual();
		} else if(vertical && y > yFinal) {
			return moverArriba.getFrameActual();
		} else if(vertical && y < yFinal) {
			return moverAbajo.getFrameActual();
		} else if(diagonalInfIzq) {
			return moverAbajoIzq.getFrameActual();
		} else if(diagonalInfDer) {
			return moverAbajoDer.getFrameActual();
		} else if(diagonalSupIzq) {
			return moverArribaIzq.getFrameActual();
		} else if(diagonalSupDer) {
			return moverArribaDer.getFrameActual();
		}
		
		return Recursos.ogroAbajo[0];
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}	
}
