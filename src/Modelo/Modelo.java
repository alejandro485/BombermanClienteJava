package Modelo;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;

import Controladores.ControladorCerraVentana;
import Controladores.ControladorConfigInicial;
import Controladores.ControladorDatosJugador;
import Controladores.ControladorAgregarConfig;
import Controladores.ControladorPantallaJuego;
import Controladores.ControladorRecurrencia;
import Logica.Jugador;
import Logica.Mundo;
import Logica.Conexion.ClienteSocket;
import Logica.Persistencia.Archivo;
import Logica.Persistencia.Configuracion;
import Logica.Persistencia.ListaMemento;
import Vista.Fabricas.BonoAutomatico;
import Vista.Fabricas.FabricaImagenes;
import Vista.Fabricas.FabricaListaArchivos;
import Vista.Fabricas.PrototiposBloques;
import Vista.Fabricas.PrototiposBomba;
import Vista.Fabricas.PrototiposBonus;
import Vista.Pantallas.AgregarConfig;
import Vista.Pantallas.ConfigInicial;
import Vista.Pantallas.DatosJugador;
import Vista.Pantallas.Loading;
import Vista.Pantallas.PantallaJuego;
import Vista.Representacion.RepresentacionJugador;


public class Modelo{
	private AgregarConfig vistaAgregarConfig;
	private DatosJugador vistaDatosJugador;
	private ConfigInicial vistaConfigInicial;
	private Loading vistaLoading;
	private PantallaJuego vistaPantallaJugador;
	
	private ControladorDatosJugador CDJ;
	private ControladorAgregarConfig CVI;
	private ControladorConfigInicial CCI;
	private ControladorPantallaJuego CPJ;
	private ControladorRecurrencia CR;
	private ControladorCerraVentana CCV;
	
	private ListaMemento listaMemento;
	
	private Jugador jugador;
	private volatile RepresentacionJugador representacion;
	
	
	public Modelo(){
		FabricaImagenes.abrirFabrica();
		FabricaListaArchivos.abrirFabrica();
		PrototiposBloques.abrirPrototipos();
		PrototiposBomba.abrirPrototipos();
		PrototiposBonus.abrirPrototipos();
		
		listaMemento=new ListaMemento();
		Mundo.getInstancia();
		Mundo.getInstancia().actualizar();
		
		CDJ=new ControladorDatosJugador(this);
		CVI=new ControladorAgregarConfig(this);
		CCI=new ControladorConfigInicial(this);
		CPJ=new ControladorPantallaJuego(this);
		CR=new ControladorRecurrencia();
		CCV=new ControladorCerraVentana();
		
		BonoAutomatico.crearRecurrencia(CR);
		
		vistaAgregarConfig=new AgregarConfig(CVI);
		vistaDatosJugador=new DatosJugador(CDJ);
		vistaConfigInicial=new ConfigInicial(CCI);
		vistaLoading=new Loading();
		vistaPantallaJugador=new PantallaJuego(CPJ);
		vistaPantallaJugador.addWindowListener(CCV);
		cargarCombo(vistaDatosJugador.getCbxMundo(),"src/Recursos/Mundo");
		cargarCombo(vistaDatosJugador.getCbxSkin(),"src/Recursos/Representacion");
		cargarLista(vistaConfigInicial.getLtsConfig(),"src/Logica/Persistencia/Cf");
		
		if(listaMemento.getLargoLista()==0){
			vistaAgregarConfig.setVisible(true);
		}
		else{
			vistaConfigInicial.setVisible(true);
		}
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
		Mundo.getInstancia().setJugador(this.jugador);
	}

	public RepresentacionJugador getRepresentacion() {
		return representacion;
	}

	public void setRepresentacion(RepresentacionJugador representacion) {
		this.representacion = representacion;
		vistaPantallaJugador.getCanvasJuego().setJugador(getRepresentacion());
	}
	
	public AgregarConfig getVistaAgregarConfig() {
		return vistaAgregarConfig;
	}

	public PantallaJuego getVistaPantallaJugador() {
		return vistaPantallaJugador;
	}

	public DatosJugador getVistaDatosJugador(){
		ClienteSocket.getClienteS();
		return vistaDatosJugador;
	}
	
	public ConfigInicial getVistaConfigInicial(){
		return vistaConfigInicial;
	}
	
	public Loading getVistaLoading(){
		return vistaLoading;
	}
	
	public ListaMemento getListaMemento() {
		return listaMemento;
	}
	
	private void cargarCombo(JComboBox<String> combo, String path){
		ArrayList<String> lista=FabricaListaArchivos.get(path);
		DefaultComboBoxModel<String> cm=new DefaultComboBoxModel<String>();
		for(int i=0;i<lista.size();i++){
			cm.addElement(lista.get(i));
		}
		combo.setModel(cm);
	}
	
	private void cargarLista(JList<String> lista,String path){
		ArrayList<String> l=FabricaListaArchivos.get(path);
		DefaultListModel<String> lm=new DefaultListModel<String>();
		Configuracion cf;
		for(int i=0;i<l.size();i++){
			cf=Archivo.getInstancia().cargar(path+"/"+l.get(i)).getConfig();
			lm.addElement("Host: "+cf.getHost()+"; Puerto: "+cf.getPuerto());
		}
		lista.setModel(lm);
	}
	
	public void registrar(){
		jugador.agregarObservador(representacion);
		jugador.agregarObservador(vistaPantallaJugador.getCanvasBonus());
		representacion.agregarObservador(vistaPantallaJugador.getCanvasJuego());
		Mundo.getInstancia().agregarObservador(vistaPantallaJugador.getCanvasJuego());
		jugador.notificar();
		representacion.notificar();
		Mundo.getInstancia().notificar();
		new Thread(representacion).start();
	}
	
}
