package Vista.Bloque;

import java.awt.Rectangle;

import Logica.Mundo;
import Vista.Fabricas.FabricaImagenes;

public class BloqueParedFirme extends Bloque{

	public BloqueParedFirme() {
		super();
		imagen=FabricaImagenes.get("src/Recursos/Mundo/"+Mundo.getInstancia().getKeyMundo()+"/pared.png");
	}
	
	@Override
	public boolean interseccion(Rectangle r) {
		return cuadrante.intersects(r);
	}

	@Override
	public boolean accion() {
		return false;
	}

	@Override
	public Object clone() {
		return new BloqueParedFirme();
	}

	@Override
	public void setImagen() {
		imagen=FabricaImagenes.get("src/Recursos/Mundo/"+Mundo.getInstancia().getKeyMundo()+"/pared.png");
	}

}
