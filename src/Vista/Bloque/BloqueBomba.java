package Vista.Bloque;

import java.awt.Rectangle;

import Logica.Mundo;
import Vista.Fabricas.FabricaImagenes;

public class BloqueBomba extends Bloque {
	
	public BloqueBomba() {
		super();
		imagen=FabricaImagenes.get("src/Recursos/Mundo/"+Mundo.getInstancia().getKeyMundo()+"/bomba.png");
	}
	
	@Override
	public boolean interseccion(Rectangle r) {
		if(rep.isAtravesarBombas()){
			return false;
		}
		return cuadrante.intersects(r);
	}

	@Override
	public boolean accion() {
		return false;
	}

	@Override
	public Object clone(){
		return new BloqueBomba();
	}

	@Override
	public void setImagen() {
		imagen=FabricaImagenes.get("src/Recursos/Mundo/"+Mundo.getInstancia().getKeyMundo()+"/bomba.png");
	}
	
}
