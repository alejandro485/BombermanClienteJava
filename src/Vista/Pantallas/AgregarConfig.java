package Vista.Pantallas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import Controladores.ControladorAgregarConfig;

public class AgregarConfig extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtHost;
	private JTextField txtPuerto;
	private JButton btnAceptar;
	private JButton btnCancelar;

	public AgregarConfig(ControladorAgregarConfig CVI) {
		setTitle("Bomberman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(261, 287);
		setVisible(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtHost = new JTextField();
		txtHost.setBounds(20, 36, 208, 20);
		contentPane.add(txtHost);
		txtHost.setColumns(10);
		
		txtPuerto = new JTextField();
		txtPuerto.setColumns(10);
		txtPuerto.setBounds(20, 92, 208, 20);
		contentPane.add(txtPuerto);
		
		JLabel lblHostDelJuego = new JLabel("Host del juego");
		lblHostDelJuego.setBounds(10, 11, 182, 14);
		contentPane.add(lblHostDelJuego);
		
		JLabel lblPuertoDelJuego = new JLabel("Puerto del juego");
		lblPuertoDelJuego.setBounds(10, 67, 182, 14);
		contentPane.add(lblPuertoDelJuego);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(72, 149, 89, 23);
		btnAceptar.setActionCommand("aceptar");
		contentPane.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(72, 173, 89, 23);
		btnCancelar.setActionCommand("cancelar");
		contentPane.add(btnCancelar);
		
		btnAceptar.addActionListener(CVI);
		btnCancelar.addActionListener(CVI);
	}

	public JTextField getTxtHost() {
		return txtHost;
	}

	public JTextField getTxtPuerto() {
		return txtPuerto;
	}
}
