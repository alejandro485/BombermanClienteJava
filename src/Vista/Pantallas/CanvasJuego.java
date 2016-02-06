package Vista.Pantallas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.HashMap;

import Logica.Mundo;
import Logica.Observer.Observer;
import Logica.Observer.Sujeto;
import Vista.Bloque.Bloque;
import Vista.Fabricas.FabricaImagenes;
import Vista.Representacion.RepresentacionAjena;
import Vista.Representacion.RepresentacionJugador;

public class CanvasJuego extends Canvas implements Observer{

	private static final long serialVersionUID = 1L;
	
	private volatile HashMap<Point,Bloque> listaBloques;
	private volatile HashMap<String, RepresentacionAjena> listaRep;
	private volatile RepresentacionJugador jugador;
	
	private Image imagen;
	private Graphics graficas;
	
	public CanvasJuego() {
		listaBloques=Mundo.getInstancia().getListaBloque();
		listaRep=Mundo.getInstancia().getJugadores();
		setSize(Mundo.largo*15, Mundo.largo*15);
	}
	
	public void setJugador(RepresentacionJugador jugador) {
		this.jugador = jugador;
	}
	
	@Override
	public void paint(Graphics g) {
		imagen=createImage(this.getWidth(),this.getHeight());
		graficas=imagen.getGraphics();
		graficas.setColor(Color.WHITE);
		graficas.fillRect(0, 0, getWidth(), getHeight());
		graficas.drawImage(FabricaImagenes.get("src/Recursos/Mundo/"+Mundo.getInstancia().getKeyMundo()+"/fondo.png", Mundo.largo*15, Mundo.largo*15), 0, 0, this);
		for(Point key: listaBloques.keySet()){
			graficas.drawImage(listaBloques.get(key).getImagen(),listaBloques.get(key).getCuadrante().x,listaBloques.get(key).getCuadrante().y,this);
		}
		for(String key: listaRep.keySet()){
			graficas.drawImage(listaRep.get(key).getImagen(),listaRep.get(key).getCuadrante().x-5,listaRep.get(key).getCuadrante().y-5,this);
		}
		graficas.drawImage(jugador.getImagenMuestra(), jugador.getCuadrante().x-5, jugador.getCuadrante().y-5, this);
		graficas.setColor(Color.blue);
		graficas.drawString(jugador.getNombre(), jugador.getCuadrante().x, jugador.getCuadrante().y);
		
		g.drawImage(imagen, 0, 0, this);
	}
	@Override
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void actualizar(Sujeto sujeto) {
		repaint();
	}
	
}
