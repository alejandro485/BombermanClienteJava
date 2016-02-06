package Vista.Bloque;

import java.awt.Image;
import java.awt.Rectangle;

import Logica.Jugador;
import Logica.Mundo;

public abstract class Bloque implements Cloneable{
	protected Rectangle cuadrante;
	protected Image imagen;
	protected Jugador rep;
	
	public Bloque() {
		cuadrante=new Rectangle(0,0,Mundo.largo,Mundo.largo);
	}
	
	public Jugador getRep() {
		return rep;
	}
	
	public void setRep(Jugador rep) {
		this.rep = rep;
	}
	
	public Rectangle getCuadrante() {
		return cuadrante;
	}
	
	public void setCuadrante(int x,int y) {
		this.cuadrante.setLocation(x,y);
	}
	
	public Image getImagen() {
		return imagen;
	}
	
	public abstract boolean interseccion(Rectangle r);
	
	public abstract boolean accion();
	
	public abstract Object clone();
	
	public abstract void setImagen();
	
}
