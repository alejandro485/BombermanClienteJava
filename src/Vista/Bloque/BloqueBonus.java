package Vista.Bloque;

import java.awt.Rectangle;

import Logica.Mundo;
import Logica.Componente.Bonus.Bonus;
import Logica.Conexion.ClienteSocket;
import Vista.Fabricas.FabricaImagenes;

public class BloqueBonus extends Bloque {
	
	private Bonus bonus;
	
	public BloqueBonus() {
		super();
	}
	
	public Bonus getBonus() {
		return bonus;
	}

	public void setBonus(Bonus bonus) {
		this.bonus = bonus;
		imagen=FabricaImagenes.get("src/Recursos/Bonus/"+bonus.getClass().getSimpleName()+".png");
	}

	@Override
	public boolean interseccion(Rectangle r) {
		return cuadrante.intersects(r);
	}

	@Override
	public boolean accion() {
		bonus.setReceptor(rep);
		bonus.activar();
		int x=(int)this.getCuadrante().getCenterX()/Mundo.largo;
		int y=(int)this.getCuadrante().getCenterY()/Mundo.largo;
		String Comando="remove||"+x+"||"+y;
		ClienteSocket.getClienteS().enviarMensaje(Comando);;
		Mundo.getInstancia().asignarValor(x, y, 0);
		return true;
	}
	
	@Override
	public Object clone(){
		return new BloqueBonus();
	}

	@Override
	public void setImagen() {
		imagen=FabricaImagenes.get("src/Recursos/Bonus/"+bonus.getClass().getSimpleName()+".png");
	}

}
