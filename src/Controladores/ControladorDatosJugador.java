package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Logica.Jugador;
import Logica.Mundo;
import Modelo.Modelo;
import Vista.Fabricas.BonoAutomatico;
import Vista.Fabricas.FabricaListaArchivos;
import Vista.Representacion.RepresentacionJugador;

public class ControladorDatosJugador implements ActionListener {

	private Modelo modelo;
	
	public ControladorDatosJugador(Modelo m) {
		modelo=m;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg) {
		if(arg.getActionCommand().equals("aceptar")){
			modelo.getVistaDatosJugador().setVisible(false);
			modelo.setJugador(new Jugador(modelo.getVistaDatosJugador().getTxtNombre().getText()));
			int i=modelo.getVistaDatosJugador().getCbxMundo().getSelectedIndex();
			Mundo.getInstancia().setKeyMundo(FabricaListaArchivos.get("src/Recursos/Mundo").get(i));
			i=modelo.getVistaDatosJugador().getCbxSkin().getSelectedIndex();
			modelo.setRepresentacion(new RepresentacionJugador(FabricaListaArchivos.get("src/Recursos/Representacion").get(i)));
			modelo.registrar();
			new Thread(modelo.getRepresentacion()).start();
			BonoAutomatico.comenzar();
			Mundo.getInstancia().actualizar();
			modelo.getVistaPantallaJugador().setVisible(true);
		}
		if(arg.getActionCommand().equals("cancelar")){
			modelo.getVistaDatosJugador().setVisible(false);
			modelo.getVistaAgregarConfig().setVisible(true);
		}
	}

}
