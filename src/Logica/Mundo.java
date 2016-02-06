package Logica;

import java.awt.Point;
import java.util.HashMap;

import Logica.Componente.Bomba.Bomba;
import Logica.Componente.Bonus.Bonus;
import Logica.Conexion.ClienteSocket;
import Logica.Observer.Sujeto;
import Vista.Bloque.Bloque;
import Vista.Bloque.BloqueBonus;
import Vista.Fabricas.PrototiposBloques;
import Vista.Representacion.RepresentacionAjena;

public class Mundo extends Sujeto{
	
	public static final int largo=50;
	
	private volatile HashMap<Point, Bonus> listaBonus;
	private volatile HashMap<Point, Bomba> listaBomba;
	private volatile HashMap<Point, Bloque> listaBloque;
	private volatile HashMap<String,RepresentacionAjena> jugadores;
	private int[][] matriz;
	private Jugador jugador;
	private String keyMundo;
	
	private static Mundo mundo=null;
	
	public Mundo() {
		super();
		keyMundo="zelda";
		jugador=new Jugador("default");
		listaBonus=new HashMap<Point,Bonus>();
		listaBomba=new HashMap<Point,Bomba>();
		listaBloque=new HashMap<Point, Bloque>();
		jugadores=new HashMap<String, RepresentacionAjena>();
		matriz=new int[15][15];
		for(int i=0;i<15;i++){
			for(int j=0;j<15;j++){
				matriz[i][j]=0;
			}
		}
		for(int i=2;i<13;i+=2){
			for(int j=2;j<13;j+=2){
				matriz[i][j]=1;
			}
		}
		
		for(int i=0;i<15;i++){
			matriz[i][0]=5;
			matriz[0][i]=5;
			matriz[14][i]=5;
			matriz[i][14]=5;
		}
	}

	public static Mundo getInstancia(){
		if(mundo==null){
			mundo=new Mundo();
		}
		return mundo;
	}
	
	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
		for(Point key: listaBloque.keySet()){
			listaBloque.get(key).setRep(this.jugador);
		}
	}

	public void asignarValor(int x, int y, int valor){
		matriz[x][y]=valor;
		notificar(x,y);
	}
	
	public void agregarBonus(int x,int y, Bonus b){
		if(matriz[x][y]==0){
			listaBonus.put(new Point(x,y), b);
			String comando="bonus||"+b.getClass().getSimpleName()+"||"+x+"||"+y;
			ClienteSocket.getClienteS().enviarMensaje(comando);
			asignarValor(x,y,4);
		}
	}
	
	public void agregarBomba(int x, int y, Bomba b){
		if(matriz[x][y]==0){
			b.setPocX(x);
			b.setPocY(y);
			listaBomba.put(new Point(x,y), b);
			String comando="bomba||"+b.getClass().getSimpleName()+"||"+b.getCapacidad()+"||"+x+"||"+y;
			ClienteSocket.getClienteS().enviarMensaje(comando);
			asignarValor(x,y,2);
			b.activar();
		}
	}
	
	public void actualizar(){
		for(int i=0;i<15;i++){
			for(int j=0;j<15;j++){
				notificar(i,j);
			}
		}
	}
	
	public void notificar(int x,int y){
		Point p=new Point(x,y);
		Bloque ayuda;
		switch(matriz[x][y]){
			case 0:
				listaBonus.remove(p);
				listaBomba.remove(p);
				listaBloque.remove(p);
				break;
			case 1:
				listaBonus.remove(p);
				listaBomba.remove(p);
				ayuda=PrototiposBloques.getBloque("BloquePared");
				ayuda.setCuadrante(x*Mundo.largo, y*Mundo.largo);
				ayuda.setRep(this.jugador);
				listaBloque.put(p, ayuda);
				break;
			case 2:
				listaBonus.remove(p);
				ayuda=PrototiposBloques.getBloque("BloqueBomba");
				ayuda.setCuadrante(x*Mundo.largo, y*Mundo.largo);
				ayuda.setRep(this.jugador);
				listaBloque.put(p, ayuda);
				break;
			case 3:
				listaBonus.remove(p);
				listaBomba.remove(p);
				ayuda=PrototiposBloques.getBloque("BloqueFuego");
				ayuda.setCuadrante(x*Mundo.largo, y*Mundo.largo);
				ayuda.setRep(this.jugador);
				listaBloque.put(p, ayuda);
				break;
			case 4:
				listaBomba.remove(p);
				ayuda=PrototiposBloques.getBloque("BloqueBonus");
				ayuda.setCuadrante(x*Mundo.largo, y*Mundo.largo);
				((BloqueBonus)ayuda).setBonus(listaBonus.get(p));
				ayuda.setRep(this.jugador);
				listaBloque.put(p, ayuda);
				break;
			case 5:
				listaBomba.remove(p);
				ayuda=PrototiposBloques.getBloque("BloqueParedFirme");
				ayuda.setCuadrante(x*Mundo.largo, y*Mundo.largo);
				listaBloque.put(p, ayuda);
				break;
		}
		notificar();
	}

	public int[][] getMatriz() {
		return matriz;
	}
	
	public HashMap<Point, Bonus> getListaBonus() {
		return listaBonus;
	}

	public HashMap<Point, Bomba> getListaBomba() {
		return listaBomba;
	}

	public HashMap<Point, Bloque> getListaBloque() {
		return listaBloque;
	}

	public HashMap<String, RepresentacionAjena> getJugadores() {
		return jugadores;
	}
	
	public void agregarRepresentacionAjena(RepresentacionAjena rp,String key){
		jugadores.put(key, rp);
	}

	public String getKeyMundo() {
		return keyMundo;
	}

	public void setKeyMundo(String keyMundo) {
		this.keyMundo = keyMundo;
	}
	
}
