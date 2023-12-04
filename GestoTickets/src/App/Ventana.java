package App;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;

	
	public Ventana() {
		setTitle("AeroTicket Manager");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana.class.getResource("/App/iconApp.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 563);
		setResizable(false);
		iniciarComponestes();
	}

	private void iniciarComponestes() {
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(new Color(205, 171, 143));
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JLabel lblTituloInicio = new JLabel("BIENVENIDO A");
		lblTituloInicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloInicio.setBounds(209, 25, 433, 79);
		lblTituloInicio.setFont(new Font("Liberation Serif", Font.BOLD | Font.ITALIC, 18));
		panelPrincipal.add(lblTituloInicio);
		
		JLabel lblTituloInicio_B = new JLabel("AeroTicket Manager");
		lblTituloInicio_B.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloInicio_B.setBounds(252, 91, 343, 43);
		lblTituloInicio_B.setFont(new Font("Liberation Serif", Font.BOLD | Font.ITALIC, 29));
		panelPrincipal.add(lblTituloInicio_B);
		
		JLabel lblImagenInicio = new JLabel("");
		lblImagenInicio.setIcon(new ImageIcon(Ventana.class.getResource("/App/imageAvion.png")));
		lblImagenInicio.setBounds(34, 221, 532, 231);
		panelPrincipal.add(lblImagenInicio);
		
		
	}
}
