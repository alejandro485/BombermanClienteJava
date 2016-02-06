package Vista.Representacion;

import java.awt.Image;
import java.awt.Rectangle;

import Logica.Mundo;
import Logica.Observer.Sujeto;
import Vista.Fabricas.FabricaImagenes;

public class RepresentacionAjena extends Sujeto{
	private Image imagen;
	private Rectangle cuadrante;
	private String nombre;
	
	public RepresentacionAjena() {
		cuadrante=new Rectangle(0,0,Mundo.largo-11, Mundo.largo-11);
	}
	
	public Image getImagen() {
		return imagen;
	}
	public void setImagen(String path) {
		this.imagen = FabricaImagenes.get(path);
		notificar();
	}
	
	public Rectangle getCuadrante() {
		return cuadrante;
	}
	public void setCuadrante(int x,int y) {
		this.cuadrante.translate(x, y);
		notificar();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
		notificar();
	}
	
}
