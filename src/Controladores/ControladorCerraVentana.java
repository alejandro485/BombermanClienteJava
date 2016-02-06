package Controladores;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import Logica.Mundo;
import Logica.Conexion.ClienteSocket;

public class ControladorCerraVentana implements WindowListener {

	@Override
	public void windowActivated(WindowEvent arg) {
	}

	@Override
	public void windowClosed(WindowEvent arg) {
	}

	@Override
	public void windowClosing(WindowEvent arg) {
		ClienteSocket.getClienteS().enviarMensaje("logout||"+Mundo.getInstancia().getJugador().getNombre());
	}

	@Override
	public void windowDeactivated(WindowEvent arg) {

	}

	@Override
	public void windowDeiconified(WindowEvent arg) {

	}

	@Override
	public void windowIconified(WindowEvent arg) {

	}

	@Override
	public void windowOpened(WindowEvent arg) {

	}

}
