package Vista.Representacion;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;

import Logica.Jugador;
import Logica.Mundo;
import Logica.Componente.Bomba.Bomba;
import Logica.Conexion.ClienteSocket;
import Logica.Observer.Observer;
import Logica.Observer.Sujeto;
import Vista.Bloque.Bloque;
import Vista.Fabricas.FabricaImagenes;
import Vista.Fabricas.FabricaListaArchivos;

public class RepresentacionJugador extends Sujeto implements Observer,Runnable{

	private Rectangle cuadrante;
	private String keyRep;
	private int velocidad;
	private String nombre;
	
	private boolean moverArriba;
	private boolean moverAbajo;
	private boolean moverDerecha;
	private boolean moverIzquierda;
	
	private int imagenArribaS;
	private int imagenAbajoS;
	private int imagenDerechaS;
	private int imagenIzquierdaS;
	
	private Image imagenMuestra;
	private String pathMuestra;
	private ArrayList<String> imagenArriba;
	private ArrayList<String> imagenAbajo;
	private ArrayList<String> imagenDerecha;
	private ArrayList<String> imagenIzquierda;
	
	public RepresentacionJugador(String keyRep) {
		super();
		cuadrante=new Rectangle(Mundo.largo+1,Mundo.largo+1,Mundo.largo-11, Mundo.largo-11);
		
		moverArriba=false;
		moverAbajo=false;
		moverDerecha=false;
		moverIzquierda=false;
		
		imagenArribaS=0;
		imagenAbajoS=0;
		imagenDerechaS=0;
		imagenIzquierdaS=0;
		
		setKeyRep(keyRep);
		pathMuestra="src/Recursos/Representacion/"+getKeyRep()+"/abajo/"+imagenAbajo.get(0);
		imagenMuestra=FabricaImagenes.get(pathMuestra);
	}
	
	public void dejarBomba(Bomba bomba){
		int x=0;
		int y=-1;
		int pocX=0;
		int pocY=0;
		if(moverArriba){
			x=0;
			y=-1;
			pocX=(int)cuadrante.getCenterX()/Mundo.largo;
			pocY=(int)cuadrante.y/Mundo.largo;
		}
		else if(moverAbajo){
			x=0;
			y=1;
			pocX=(int)cuadrante.getCenterX()/Mundo.largo;
			pocY=(int)(cuadrante.y+cuadrante.getHeight())/Mundo.largo;
		}
		else if(moverDerecha){
			x=1;
			y=0;
			pocX=(int)(cuadrante.x+cuadrante.getWidth())/Mundo.largo;
			pocY=(int)cuadrante.getCenterY()/Mundo.largo;
		}
		else if(moverIzquierda){
			x=-1;
			y=0;
			pocX=(int)cuadrante.x/Mundo.largo;
			pocY=(int)cuadrante.getCenterY()/Mundo.largo;
		}
		else{
			return;
		}
		Mundo.getInstancia().agregarBomba(pocX + x, pocY+ y, bomba);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	public Rectangle getCuadrante() {
		return cuadrante;
	}
	public void setCuadrante(Rectangle cuadrante) {
		this.cuadrante = cuadrante;
	}
	public Image getImagenMuestra() {
		
		return imagenMuestra;
	}
	public void setImagenMuestra(Image imagenMuestra) {
		this.imagenMuestra = imagenMuestra;
	}
	public String getKeyRep() {
		return keyRep;
	}
	public void setKeyRep(String keyRep) {
		this.keyRep = keyRep;
		cargarAnimacion();
	}
	public boolean isMoverArriba() {
		return moverArriba;
	}
	public void setMoverArriba(boolean moverArriba) {
		this.moverArriba = moverArriba;
	}
	public boolean isMoverAbajo() {
		return moverAbajo;
	}
	public void setMoverAbajo(boolean moverAbajo) {
		this.moverAbajo = moverAbajo;
	}
	public boolean isMoverDerecha() {
		return moverDerecha;
	}
	public void setMoverDerecha(boolean moverDerecha) {
		this.moverDerecha = moverDerecha;
	}
	public boolean isMoverIquierda() {
		return moverIzquierda;
	}
	public void setMoverIquierda(boolean moverIquierda) {
		this.moverIzquierda = moverIquierda;
	}
	public String getPathMuestra() {
		return pathMuestra;
	}

	public void actualizar(){
		pathMuestra="";
		
		if(moverArriba){//mover arriba
			moverArriba();
		}
		else{
			imagenArribaS=0;
		}
		
		if(moverAbajo){//mover abajo
			moverAbajo();
		}
		else{
			imagenAbajoS=0;
		}
		
		if(moverDerecha){//mover derecha
			moverDerecha();
		}
		else{
			imagenDerechaS=0;
		}
		
		if(moverIzquierda){//mover izquierda
			moverIzquierda();
		}
		else{
			imagenIzquierdaS=0;
		}
		
		if(pathMuestra==""){
			pathMuestra="/abajo/"+imagenAbajo.get(0);
		}
		pathMuestra="src/Recursos/Representacion/"+keyRep+pathMuestra;
		imagenMuestra=FabricaImagenes.get(pathMuestra);
		notificar();
	}
	
	@Override
	public void actualizar(Sujeto sujeto) {
		if(sujeto instanceof Jugador){
			Jugador j=(Jugador)sujeto;
			this.velocidad=j.getVelocidad();
			this.nombre=j.getNombre();
		}
	}
	
	private void moverArriba(){
		cuadrante.translate(0, -velocidad);
		if(validacionColision()){
			cuadrante.translate(0, velocidad);
		}
		pathMuestra="/arriba/"+imagenArriba.get(imagenArribaS);
		imagenArribaS++;
		imagenArribaS%=imagenArriba.size();
	}
	
	private void moverAbajo(){
		cuadrante.translate(0, velocidad);
		if(validacionColision()){
			cuadrante.translate(0, -velocidad);
		}
		pathMuestra="/abajo/"+imagenAbajo.get(imagenAbajoS);
		imagenAbajoS++;
		imagenAbajoS%=imagenAbajo.size();
	}
	
	private void moverDerecha(){
		cuadrante.translate(velocidad,0);
		if(validacionColision()){
			cuadrante.translate(-velocidad,0);
		}
		pathMuestra="/derecha/"+imagenDerecha.get(imagenDerechaS);
		imagenDerechaS++;
		imagenDerechaS%=imagenDerecha.size();
	}
	
	private void moverIzquierda(){
		cuadrante.translate(-velocidad,0);
		if(validacionColision()){
			cuadrante.translate(velocidad,0);
		}
		pathMuestra="/izquierda/"+imagenIzquierda.get(imagenIzquierdaS);
		imagenIzquierdaS++;
		imagenIzquierdaS%=imagenIzquierda.size();
	}
	
	
	private boolean validacionColision(){
		HashMap<Point,Bloque> listaBloques=Mundo.getInstancia().getListaBloque();
		for(Point key: listaBloques.keySet()){
			if(listaBloques.get(key).interseccion(cuadrante)){
				return !listaBloques.get(key).accion();
			}
		}
		return false;
	}
	
	private void cargarAnimacion(){
		imagenArriba=FabricaListaArchivos.get("src/Recursos/Representacion/"+keyRep+"/arriba");
		imagenAbajo=FabricaListaArchivos.get("src/Recursos/Representacion/"+keyRep+"/abajo");
		imagenDerecha=FabricaListaArchivos.get("src/Recursos/Representacion/"+keyRep+"/derecha");
		imagenIzquierda=FabricaListaArchivos.get("src/Recursos/Representacion/"+keyRep+"/izquierda");
	}
	
	@Override
	public void run() {
		while(true){
			actualizar();
			String comando="jugador||"+getNombre()+"||"+getPathMuestra()+"||"+getCuadrante().x+"||"+getCuadrante().y;
			ClienteSocket.getClienteS().enviarMensaje(comando);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}