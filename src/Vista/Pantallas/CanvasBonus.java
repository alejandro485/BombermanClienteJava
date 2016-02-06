package Vista.Pantallas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import Logica.Jugador;
import Logica.Mundo;
import Logica.Observer.Observer;
import Logica.Observer.Sujeto;
import Vista.Fabricas.FabricaImagenes;

public class CanvasBonus extends Canvas implements Observer{
	
	private static final long serialVersionUID = 1L;
	
	private boolean indestructible;
	private boolean atraviesaPared;
	private boolean atraviesaBomba;
	private boolean fullFire;
	private int vidas;
	private Image bomba;
	private Image corazon;
	
	private Image imagen;
	private Graphics graficas;

	public CanvasBonus() {
		System.out.println(Mundo.getInstancia().getKeyMundo());
		setSize(50, 300);
		indestructible=false;
		atraviesaBomba=false;
		atraviesaPared=false;
		fullFire=false;
		vidas=0;
	}

	@Override
	public void paint(Graphics g) {
		bomba=FabricaImagenes.get("src/Recursos/Mundo/"+Mundo.getInstancia().getKeyMundo()+"/bomba.png");
		corazon=FabricaImagenes.get("src/Recursos/Mundo/"+Mundo.getInstancia().getKeyMundo()+"/corazon.png");
		imagen=createImage(Mundo.largo,Mundo.largo*6);
		graficas=imagen.getGraphics();
		graficas.setColor(Color.GREEN);
		graficas.fillRect(0, 0, getWidth(), getHeight());
		graficas.drawImage(corazon, 0, 0, this);
		graficas.setColor(Color.BLACK);
		graficas.setFont(new Font("Arial", Font.PLAIN, 50));
		System.out.println(vidas);
		graficas.drawString(vidas+"", 10, Mundo.largo);
		graficas.drawImage(bomba, 0, Mundo.largo, this);
		if(indestructible){
			graficas.drawImage(FabricaImagenes.get("src/Recursos/Bonus/Indestructible.png"), 0, Mundo.largo*2, this);
		}
		if(atraviesaBomba){
			graficas.drawImage(FabricaImagenes.get("src/Recursos/Bonus/AtraviesaBomba.png"), 0, Mundo.largo*3, this);
		}
		if(atraviesaPared){
			graficas.drawImage(FabricaImagenes.get("src/Recursos/Bonus/AtraviesaPared.png"), 0, Mundo.largo*4, this);
		}
		if(fullFire){
			graficas.drawImage(FabricaImagenes.get("src/Recursos/Bonus/FullFire.png"), 0, Mundo.largo*4, this);
		}
		
		g.drawImage(imagen, 0, 0, this);
	}
	
	public void update(Graphics g) {
		paint(g);
	}
	
	@Override
	public void actualizar(Sujeto sujeto) {
		if(sujeto instanceof Jugador){
			Jugador j=(Jugador)sujeto;
			indestructible=j.isIndestructible();
			atraviesaBomba=j.isAtravesarBombas();
			atraviesaPared=j.isAtravesarParedes();
			fullFire=j.isFullFire();
			vidas=j.getVidas();
		}
		repaint();
	}

}
