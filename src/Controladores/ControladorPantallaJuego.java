package Controladores;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Modelo.Modelo;

public class ControladorPantallaJuego implements KeyListener{
	
	private Modelo modelo;

	public ControladorPantallaJuego(Modelo m) {
		modelo=m;
	}
	
	@Override
	public void keyPressed(KeyEvent arg) {
		if(arg.getKeyCode()==(KeyEvent.VK_UP)){
			modelo.getRepresentacion().setMoverArriba(true);
		}
		if(arg.getKeyCode()==(KeyEvent.VK_DOWN)){
			modelo.getRepresentacion().setMoverAbajo(true);
		}
		if(arg.getKeyCode()==(KeyEvent.VK_LEFT)){
			modelo.getRepresentacion().setMoverIquierda(true);
		}
		if(arg.getKeyCode()==(KeyEvent.VK_RIGHT)){
			modelo.getRepresentacion().setMoverDerecha(true);
		}
		if(arg.getKeyCode()==(KeyEvent.VK_SPACE)){
			modelo.getRepresentacion().dejarBomba(modelo.getJugador().getTipoBomba());
		}
	}

	@Override
	public void keyReleased(KeyEvent arg) {
		if(arg.getKeyCode()==(KeyEvent.VK_UP)){
			modelo.getRepresentacion().setMoverArriba(false);
		}
		if(arg.getKeyCode()==(KeyEvent.VK_DOWN)){
			modelo.getRepresentacion().setMoverAbajo(false);
		}
		if(arg.getKeyCode()==(KeyEvent.VK_LEFT)){
			modelo.getRepresentacion().setMoverIquierda(false);
		}
		if(arg.getKeyCode()==(KeyEvent.VK_RIGHT)){
			modelo.getRepresentacion().setMoverDerecha(false);
		}
	}

	@Override
	public void keyTyped(KeyEvent arg) {
	}

}
