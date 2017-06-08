package testsCliente;

import java.io.IOException;

import javax.swing.JTextArea;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import cliente.Cliente;
import mensajeria.Comando;
import mensajeria.Paquete;
import mensajeria.PaqueteAtacar;
import mensajeria.PaqueteBatalla;
import mensajeria.PaqueteFinalizarBatalla;
import mensajeria.PaqueteMovimiento;
import mensajeria.PaquetePersonaje;
import mensajeria.PaqueteUsuario;

public class TestCliente {

	@Test
	public void testPaqueteUsuario() {

		PaqueteUsuario pu = new PaqueteUsuario(1,"Javier","ABC");
		Assert.assertEquals(1, pu.getIdPj());
		Assert.assertEquals("Javier", pu.getUsername());
		Assert.assertEquals("ABC", pu.getPassword());
		Assert.assertFalse(pu.isInicioSesion());
	}


	@Test
	public void testPaquetePersonaje() {
		
		PaquetePersonaje pp = new PaquetePersonaje();
		pp.setCasta("Asesino");
		pp.setDestreza(1);
		pp.setEnergiaTope(1);
		pp.setEstado(1);
		pp.setExperiencia(1);
		pp.setFuerza(1);
		pp.setId(1);
		pp.setMapa(1);
		pp.setInteligencia(1);
		pp.setNivel(1);
		pp.setNombre("Hola");
		pp.setRaza("Orco");
		pp.setSaludTope(1);
		
		Assert.assertEquals("Asesino", pp.getCasta());
		Assert.assertEquals(1, pp.getDestreza());
		Assert.assertEquals(1, pp.getEnergiaTope());
		Assert.assertEquals(1, pp.getEstado());
		Assert.assertEquals(1, pp.getExperiencia());
		Assert.assertEquals(1, pp.getFuerza());
		Assert.assertEquals(1, pp.getId());
		Assert.assertEquals(1, pp.getMapa());
		Assert.assertEquals(1, pp.getInteligencia());
		Assert.assertEquals(1, pp.getNivel());
		Assert.assertEquals("Hola", pp.getNombre());
		Assert.assertEquals("Orco", pp.getRaza());
		Assert.assertEquals(1, pp.getSaludTope());		
	}
	
	
	@Test
	public void testPaqueteMovimiento() {
		
		PaqueteMovimiento pm = new PaqueteMovimiento(1,1,1);
		pm.setDireccion(1);
		pm.setFrame(1);
		
		Assert.assertEquals(1, pm.getIdPersonaje());
		Assert.assertEquals(1, pm.getPosX(),0.01);
		Assert.assertEquals(1, pm.getPosY(),0.01);
		Assert.assertEquals(1, pm.getDireccion());
		Assert.assertEquals(1, pm.getFrame());
	}
	
	
	@Test
	public void testPaqueteFinalizarBatalla() {
		
		PaqueteFinalizarBatalla pfb = new PaqueteFinalizarBatalla();
		pfb.setId(1);
		pfb.setIdEnemigo(1);
		
		Assert.assertEquals(1, pfb.getId());
		Assert.assertEquals(1, pfb.getIdEnemigo());
	}
	
	
	@Test
	public void testPaqueteBatalla() {
		
		PaqueteBatalla pb = new PaqueteBatalla();
		pb.setId(1);
		pb.setIdEnemigo(1);
		pb.setMiTurno(true);
		
		Assert.assertEquals(1, pb.getId());
		Assert.assertEquals(1, pb.getIdEnemigo());
		Assert.assertTrue(pb.isMiTurno());
	}
	
	
	@Test
	public void testPaqueteAtacar() {
		
		PaqueteAtacar pa = new PaqueteAtacar(1, 1, 1, 1, 1, 1);
		
		Assert.assertEquals(1, pa.getId());
		Assert.assertEquals(1, pa.getIdEnemigo());
	}
	
	
	@Test
	public void testPaquete() {
		
		Paquete p = new Paquete("Hola", "Marco-Polo", "A", 1);
		
		Assert.assertEquals("Hola", p.getMensaje());
		Assert.assertEquals("A", p.getIp());
		Assert.assertEquals(1, p.getComando());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	@Test
	public void testRegistrarPersonaje() {
		Gson gson = new Gson();

		Cliente cliente = new Cliente();

		// Registro de usuario
		PaqueteUsuario pu = new PaqueteUsuario();
		pu.setComando(Comando.REGISTRO);
		pu.setUsername("nuevoUser");
		pu.setPassword("test");

		// Registro de personaje
		PaquetePersonaje pp = new PaquetePersonaje();
		pp.setComando(Comando.CREACIONPJ);
		pp.setCasta("Humano");
		pp.setDestreza(1);
		pp.setEnergiaTope(1);
		pp.setExperiencia(1);
		pp.setFuerza(1);
		pp.setInteligencia(1);
		pp.setNivel(1);
		pp.setNombre("PjTest");
		pp.setRaza("Asesino");
		pp.setSaludTope(1);

		try {

			// Envio el paquete de registro de usuario
			cliente.getSalida().writeObject(gson.toJson(pu));

			// Recibo la respuesta del servidor
			Paquete paquete = (Paquete) gson.fromJson((String) cliente.getEntrada().readObject(), Paquete.class);

			// Envio el paquete de registro de personaje
			cliente.getSalida().writeObject(gson.toJson(pp));

			// Recibo el personaje de mi usuario
			pp = (PaquetePersonaje) gson.fromJson((String) cliente.getEntrada().readObject(), PaquetePersonaje.class);

			// Cierro las conexiones
			Paquete p = new Paquete();
			p.setComando(Comando.DESCONECTAR);
			p.setIp(cliente.getMiIp());
			cliente.getSalida().writeObject(gson.toJson(p));
			cliente.getSalida().close();
			cliente.getEntrada().close();
			cliente.getSocket().close();

			Assert.assertEquals("PjTest", pp.getNombre());
		} catch (IOException | JsonSyntaxException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testIniciarSesion() {
		Gson gson = new Gson();
		Cliente cliente = new Cliente();

		PaqueteUsuario pu = new PaqueteUsuario();
		pu.setComando(Comando.INICIOSESION);
		pu.setUsername("nuevoUser");
		pu.setPassword("test");

		try {

			// Envio el paquete de incio de sesion
			cliente.getSalida().writeObject(gson.toJson(pu));

			// Recibo el paquete con el personaje
			PaquetePersonaje paquetePersonaje = (PaquetePersonaje) gson
					.fromJson((String) cliente.getEntrada().readObject(), PaquetePersonaje.class);

			// Cierro las conexiones
			Paquete p = new Paquete();
			p.setComando(Comando.DESCONECTAR);
			p.setIp(cliente.getMiIp());
			cliente.getSalida().writeObject(gson.toJson(p));
			cliente.getSalida().close();
			cliente.getEntrada().close();
			cliente.getSocket().close();

			Assert.assertEquals("PjTest", paquetePersonaje.getNombre());
		} catch (IOException | JsonSyntaxException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testActualizarPersonaje() {
		Gson gson = new Gson();
		Cliente cliente = new Cliente();

		PaquetePersonaje pp = new PaquetePersonaje();
		pp.setComando(Comando.ACTUALIZARPERSONAJE);
		pp.setCasta("Humano");
		pp.setDestreza(1);
		pp.setEnergiaTope(1);
		pp.setExperiencia(1);
		pp.setFuerza(1);
		pp.setInteligencia(1);
		pp.setNivel(1);
		pp.setNombre("PjTest");
		pp.setRaza("Asesino");
		pp.setSaludTope(10000);

		try {

			// Envio el paquete de actualizacion de personaje
			cliente.getSalida().writeObject(gson.toJson(pp));

			// Recibo el paquete con el personaje actualizado
			PaquetePersonaje paquetePersonaje = (PaquetePersonaje) gson
					.fromJson((String) cliente.getEntrada().readObject(), PaquetePersonaje.class);

			// Cierro las conexiones
			Paquete p = new Paquete();
			p.setComando(Comando.DESCONECTAR);
			p.setIp(cliente.getMiIp());
			cliente.getSalida().writeObject(gson.toJson(p));
			cliente.getSalida().close();
			cliente.getEntrada().close();
			cliente.getSocket().close();

			Assert.assertEquals(10000, paquetePersonaje.getSaludTope());
		} catch (IOException | JsonSyntaxException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	*/
}
