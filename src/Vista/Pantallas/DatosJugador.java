package Vista.Pantallas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import Controladores.ControladorDatosJugador;

public class DatosJugador extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtNombre;
	private JComboBox<String> cbxSkin;
	private JComboBox<String> cbxMundo;
	private JButton btnCancelar;
	private JButton btnAceptar;

	public DatosJugador(ControladorDatosJugador CDJ) {
		setTitle("Bomberman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(306, 302);
		setVisible(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(104, 184, 89, 23);
		contentPane.add(btnAceptar);
		btnAceptar.setActionCommand("aceptar");
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(104, 218, 89, 23);
		contentPane.add(btnCancelar);
		btnCancelar.setActionCommand("cancelar");
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 11, 270, 14);
		contentPane.add(lblNombre);
		
		JLabel lblSeleccionDeSkin = new JLabel("Seleccion de skin");
		lblSeleccionDeSkin.setBounds(10, 70, 270, 14);
		contentPane.add(lblSeleccionDeSkin);
		
		JLabel lblSeleccionDeMundo = new JLabel("Seleccion de mundo");
		lblSeleccionDeMundo.setBounds(10, 124, 270, 14);
		contentPane.add(lblSeleccionDeMundo);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(10, 36, 270, 23);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		cbxSkin = new JComboBox<String>();
		cbxSkin.setBounds(10, 90, 270, 23);
		contentPane.add(cbxSkin);
		
		cbxMundo = new JComboBox<String>();
		cbxMundo.setBounds(10, 150, 270, 23);
		contentPane.add(cbxMundo);
		
		btnAceptar.addActionListener(CDJ);
		btnCancelar.addActionListener(CDJ);
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JComboBox<String> getCbxSkin() {
		return cbxSkin;
	}

	public JComboBox<String> getCbxMundo() {
		return cbxMundo;
	}
	
}
