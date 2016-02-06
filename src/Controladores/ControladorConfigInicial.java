package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Logica.Persistencia.Configuracion;
import Modelo.Modelo;

public class ControladorConfigInicial implements ActionListener{
	
	private Modelo modelo;
	
	public ControladorConfigInicial(Modelo m) {
		modelo=m;
	}

	@Override
	public void actionPerformed(ActionEvent arg) {
		if(arg.getActionCommand().equals("salir")){
			System.exit(0);
		}
		else if(arg.getActionCommand().equals("agregar")){
			modelo.getVistaConfigInicial().setVisible(false);
			modelo.getVistaAgregarConfig().setVisible(true);
		}
		else if(arg.getActionCommand().equals("comenzar")){
			int s=modelo.getVistaConfigInicial().getLtsConfig().getSelectedIndex();
			if(s>=0){
				Configuracion.setConfiguracion(modelo.getListaMemento().getMemento(s).getConfig());
				modelo.getVistaConfigInicial().setVisible(false);
				modelo.getVistaDatosJugador().setVisible(true);
			}
			else{
				JOptionPane.showMessageDialog(null, "Seleccione primero una configuracion");
			}
		}
	}

}
