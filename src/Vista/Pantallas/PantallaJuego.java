package Vista.Pantallas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controladores.ControladorPantallaJuego;

public class PantallaJuego extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private CanvasBonus canvasBonus;
	private CanvasJuego canvasJuego;
	
	public PantallaJuego(ControladorPantallaJuego CPJ) {
		setTitle("Bomberman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(860, 810);
		setVisible(false);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		canvasBonus=new CanvasBonus();
		canvasBonus.setLocation(760,10);
		canvasBonus.setVisible(true);
		contentPane.add(canvasBonus);
		
		canvasJuego=new CanvasJuego();
		canvasJuego.setLocation(10, 10);
		canvasJuego.addKeyListener(CPJ);
		contentPane.add(canvasJuego);
		
		addKeyListener(CPJ);
		
		canvasJuego.setFocusable(true);
	}

	public CanvasBonus getCanvasBonus() {
		return canvasBonus;
	}

	public CanvasJuego getCanvasJuego() {
		return canvasJuego;
	}

}
