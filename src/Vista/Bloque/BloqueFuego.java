package Vista.Bloque;

import java.awt.Rectangle;

import Logica.Mundo;
import Vista.Fabricas.FabricaImagenes;

public class BloqueFuego extends Bloque {

	public BloqueFuego() {
		super();
		imagen=FabricaImagenes.get("src/Recursos/Mundo/"+Mundo.getInstancia().getKeyMundo()+"/fuego.png");
	}
	
	@Override
	public boolean interseccion(Rectangle r) {
		if(rep.isIndestructible()){
			return false;
		}
		return cuadrante.intersects(r);
	}

	@Override
	public boolean accion() {
		rep.setVidas(rep.getVidas()-1);
		return true;
	}

	@Override
	public Object clone() {
		return new BloqueFuego();
	}

	@Override
	public void setImagen() {
		imagen=FabricaImagenes.get("src/Recursos/Mundo/"+Mundo.getInstancia().getKeyMundo()+"/fuego.png");
	}
	
}
