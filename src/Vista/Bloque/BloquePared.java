package Vista.Bloque;

import java.awt.Rectangle;

import Logica.Mundo;
import Vista.Fabricas.FabricaImagenes;

public class BloquePared extends Bloque {

	public BloquePared() {
		super();
		imagen=FabricaImagenes.get("src/Recursos/Mundo/"+Mundo.getInstancia().getKeyMundo()+"/pared.png");
	}
	
	@Override
	public boolean interseccion(Rectangle r) {
		if(rep.isAtravesarParedes()){
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
		return new BloquePared();
	}

	@Override
	public void setImagen() {
		imagen=FabricaImagenes.get("src/Recursos/Mundo/"+Mundo.getInstancia().getKeyMundo()+"/pared.png");
	}

}
