package Vista.Pantallas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Loading extends JFrame {
	
	private static final long serialVersionUID = -4258679833962248897L;
	
	private JPanel contentPane;

	public Loading() {
		setTitle("Bomberman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCargando = new JLabel("Cargando");
		lblCargando.setIcon(new ImageIcon(Loading.class.getResource("/Vista/Pantallas/cargar.gif")));
		lblCargando.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargando.setBounds(10, 11, 400, 300);
		contentPane.add(lblCargando);
	}
}
