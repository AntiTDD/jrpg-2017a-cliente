package cliente;

import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import dominio.Item;
import estados.Estado;
import estados.EstadoBatalla;
import frames.MenuComercio;
import frames.MenuInventario;
import juego.Juego;
import mensajeria.Comando;
import mensajeria.Paquete;
import mensajeria.PaqueteAtacar;
import mensajeria.PaqueteBatalla;
import mensajeria.PaqueteComercio;
import mensajeria.PaqueteDeMovimientos;
import mensajeria.PaqueteDePersonajes;
import mensajeria.PaqueteMovimiento;
import mensajeria.PaquetePersonaje;

public class EscuchaMensajes extends Thread {

	private Juego juego;
	private Cliente cliente;
	private ObjectInputStream entrada;
	private final Gson gson = new Gson();
	
	private Map<Integer, PaqueteMovimiento> ubicacionPersonajes;
	private Map<Integer, PaquetePersonaje> personajesConectados;

	public EscuchaMensajes(Juego juego) {
		this.juego = juego;
		cliente = juego.getCliente();
		entrada = cliente.getEntrada();
	}

	public void run() {

		try {

			Paquete paquete;
			PaquetePersonaje paquetePersonaje;
			PaqueteBatalla paqueteBatalla;
			PaqueteAtacar paqueteAtacar;
			PaqueteComercio paqueteComercio;
			personajesConectados = new HashMap<>();
			ubicacionPersonajes = new HashMap<>();

			while (true) {
				
				String objetoLeido = (String)entrada.readObject();

				paquete = gson.fromJson(objetoLeido , Paquete.class);
				
				switch (paquete.getComando()) {
	
				case Comando.CONEXION:
					personajesConectados = (Map<Integer, PaquetePersonaje>) gson.fromJson(objetoLeido, PaqueteDePersonajes.class).getPersonajes();
					break;

				case Comando.MOVIMIENTO:
					ubicacionPersonajes = (Map<Integer, PaqueteMovimiento>) gson.fromJson(objetoLeido, PaqueteDeMovimientos.class).getPersonajes();
					break;
					
				case Comando.BATALLA:
					paqueteBatalla = gson.fromJson(objetoLeido, PaqueteBatalla.class);
					juego.getPersonaje().setEstado(Estado.estadoBatalla);
					Estado.setEstado(null);
					juego.setEstadoBatalla(new EstadoBatalla(juego, paqueteBatalla));
					Estado.setEstado(juego.getEstadoBatalla());
					break;
					
				case Comando.ATACAR:
					paqueteAtacar = (PaqueteAtacar) gson.fromJson(objetoLeido, PaqueteAtacar.class);
					juego.getEstadoBatalla().getEnemigo().actualizarAtributosPersonaje(paqueteAtacar.getMapPersonaje());
					juego.getEstadoBatalla().getPersonaje().actualizarAtributosPersonaje(paqueteAtacar.getMapAtacante());
					juego.getEstadoBatalla().setMiTurno(true);
					break;
					
				case Comando.FINALIZARBATALLA:
					juego.getPersonaje().setEstado(Estado.estadoJuego);
					Estado.setEstado(juego.getEstadoJuego());
					break;
					
				case Comando.ACTUALIZARPERSONAJE:
					paquetePersonaje = (PaquetePersonaje) gson.fromJson(objetoLeido, PaquetePersonaje.class);

					personajesConectados.remove(paquetePersonaje.getId());
					personajesConectados.put(paquetePersonaje.getId(), paquetePersonaje);
					
					if(juego.getPersonaje().getId() == paquetePersonaje.getId()) {
						if(juego.getPersonaje().getGanoBatalla()){
							juego.getPersonaje().aniadirItem(juego.getPersonaje().getInventario().get(juego.getPersonaje().getInventario().size()-1));
							juego.getPersonaje().setGanoBatalla(false);
						}
						juego.actualizarPersonaje();
						juego.getEstadoJuego().actualizarPersonaje();
						juego.getCliente().actualizarPersonaje(paquetePersonaje);
					}
					break;
					
				case Comando.COMERCIO:
					paqueteComercio = (PaqueteComercio) gson.fromJson(objetoLeido, PaqueteComercio.class);
					paqueteComercio.setIdEnemigo(paqueteComercio.getId());
					paqueteComercio.setId(juego.getCliente().getPaquetePersonaje().getId());
					
					if(paqueteComercio.getRespuesta()) {
						if(juego.getCliente().getMenuComercio() != null) {
							paqueteComercio.setMensaje(Paquete.msjFracaso);
						} else {
							juego.getCliente().setPaqueteComercio(paqueteComercio);
							juego.getCliente().setMenuInventario(new MenuInventario(juego ,new MenuComercio(juego.getCliente())));
							juego.getCliente().getMenuInventario().setVisible(true);
							paqueteComercio.setMensaje(Paquete.msjExito);
						}
						
						paqueteComercio.setRespuesta(false);
						juego.getCliente().getSalida().writeObject(gson.toJson(paqueteComercio));
					} else {
						if(paqueteComercio.getMensaje().equals((Paquete.msjFracaso))) {
							JOptionPane.showMessageDialog(null, "El jugador ya esta comerciando");
						} else {
							if(juego.getCliente().getMenuComercio() == null) {
								juego.getCliente().setPaqueteComercio(paqueteComercio);
								juego.getCliente().setMenuInventario(new MenuInventario(juego ,new MenuComercio(juego.getCliente())));
								juego.getCliente().getMenuInventario().setVisible(true);
							}
						}
					}
					break;
					
				case Comando.ACTUALIZARCOMERCIO:
					System.out.println("ENTRO");
					int cantItemsAcomerciar = juego.getCliente().getMenuComercio().getItemsAComerciar().size();
					int cantItemsObtener;
					paqueteComercio = gson.fromJson(objetoLeido, PaqueteComercio.class);
					cantItemsObtener = paqueteComercio.getItemsAComerciar().size();//dice items a comerciar ya que seria el paquete del otro cliente
					if(juego.getCliente().getPaqueteComercio().getResultadoComercio() == true && paqueteComercio.getResultadoComercio() == true) {
						if(cantItemsAcomerciar > 0 && cantItemsObtener >0) {
							
							juego.getCliente().getMenuComercio().getItemsAObtener().removeAll(juego.getCliente().getMenuComercio().getItemsAObtener());
							for(Item item : paqueteComercio.getItemsAComerciar()){
								juego.getCliente().getMenuComercio().getItemsAObtener().add(item);
							}
							juego.getCliente().getPaqueteComercio().setItemsARecibir(paqueteComercio.getItemsAComerciar());
							
						} else {
							JOptionPane.showMessageDialog(null, "Ambos jugadores deben ofertar items.");
						}
					}else {
						JOptionPane.showMessageDialog(null, "No se acepto el trueque.");
					}
				}	
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Fallo la conexión con el servidor.");
			e.printStackTrace();
		}
	}

	public Map<Integer, PaqueteMovimiento> getUbicacionPersonajes() {
		return ubicacionPersonajes;
	}
	
	public Map<Integer, PaquetePersonaje> getPersonajesConectados(){
		return personajesConectados;
	}
}