package App;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;

	
	public VentanaInicio() {
		setTitle("AeroTicket Manager");
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaInicio.class.getResource("/App/iconApp.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 563);
		setResizable(false);
		iniciarComponestes();
		setLocationRelativeTo(null);
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
		lblImagenInicio.setIcon(new ImageIcon(VentanaInicio.class.getResource("/App/imageAvion.png")));
		lblImagenInicio.setBounds(-13, 269, 505, 307);
		panelPrincipal.add(lblImagenInicio);
		
		JButton btnIngreso = new JButton("Iniciar Sesión");
		btnIngreso.setBackground(Color.WHITE);
		btnIngreso.setFont(new Font("Roboto", Font.BOLD, 14));
		btnIngreso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaUsuario newframe = new VentanaUsuario();
				newframe.setVisible(true);
				VentanaInicio.this.dispose();
				
			}
		});
		btnIngreso.setBounds(307, 194, 250, 27);
		panelPrincipal.add(btnIngreso);
		
		JButton btnCrearUsuario = new JButton("Crear Usuario");
		btnCrearUsuario.setBackground(Color.WHITE);
		btnCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCrearUsuario newframe = new VentanaCrearUsuario();
				newframe.setVisible(true);
				VentanaInicio.this.dispose();
				
			}
		});
		btnCrearUsuario.setFont(new Font("Roboto", Font.BOLD, 14));
		btnCrearUsuario.setBounds(307, 232, 250, 27);
		panelPrincipal.add(btnCrearUsuario);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(Color.WHITE);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setFont(new Font("Roboto", Font.BOLD, 14));
		btnSalir.setBounds(367, 271, 136, 27);
		panelPrincipal.add(btnSalir);
		
		
	}
}
