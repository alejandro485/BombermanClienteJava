package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Logica.Persistencia.Configuracion;
import Modelo.Modelo;

public class ControladorAgregarConfig implements ActionListener{

	private Modelo modelo;
	
	public ControladorAgregarConfig(Modelo m) {
		modelo=m;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg) {
		if(arg.getActionCommand().equals("aceptar")){
			Configuracion c=new Configuracion();
			c.setHost(modelo.getVistaAgregarConfig().getTxtHost().getText());
			c.setPuerto(Integer.parseInt(modelo.getVistaAgregarConfig().getTxtPuerto().getText()));
			modelo.getListaMemento().agregarMemento(c.getMemento());
			Configuracion.setConfiguracion(c);
			modelo.getVistaAgregarConfig().setVisible(false);
			modelo.getVistaDatosJugador().setVisible(true);
		}
		if(arg.getActionCommand().equals("cancelar")){
			modelo.getVistaAgregarConfig().setVisible(false);
			modelo.getVistaConfigInicial().setVisible(true);
		}
	}
	
}
