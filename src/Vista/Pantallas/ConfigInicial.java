package Vista.Pantallas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.ListSelectionModel;
import javax.swing.JLabel;

import Controladores.ControladorConfigInicial;

public class ConfigInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JList<String> ltsConfig;
	private JButton btnAgregar;
	private JButton btnComenzar;
	private JButton btnSalir;
	private JLabel lblConfiguracionesExistentes;
	
	public ConfigInicial(ControladorConfigInicial CCI) {
		setTitle("Bomberman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(false);
		setSize(322, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ltsConfig = new JList<String>();
		ltsConfig.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ltsConfig.setFont(new Font("Arial", Font.PLAIN, 18));
		ltsConfig.setBounds(10, 46, 286, 232);
		contentPane.add(ltsConfig);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(10, 289, 89, 23);
		btnAgregar.setActionCommand("agregar");
		btnAgregar.addActionListener(CCI);
		contentPane.add(btnAgregar);
		
		btnComenzar = new JButton("Comenzar");
		btnComenzar.setBounds(109, 289, 89, 23);
		btnComenzar.setActionCommand("comenzar");
		btnComenzar.addActionListener(CCI);
		contentPane.add(btnComenzar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(208, 289, 89, 23);
		btnSalir.setActionCommand("salir");
		btnSalir.addActionListener(CCI);
		contentPane.add(btnSalir);
		
		lblConfiguracionesExistentes = new JLabel("Configuraciones existentes");
		lblConfiguracionesExistentes.setBounds(10, 10, 200, 23);
		contentPane.add(lblConfiguracionesExistentes);
	}

	public JList<String> getLtsConfig() {
		return ltsConfig;
	}
	
}
