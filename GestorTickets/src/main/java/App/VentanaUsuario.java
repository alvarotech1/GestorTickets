package App;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;

public class VentanaUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;
	private JTextField txtUsuario;
	private JPasswordField passField;

	public VentanaUsuario() {
		configurarVentana();
		iniciarComponentes();
	}

	private void configurarVentana() {
        setTitle("AeroTicket Manager");
        setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaInicio.class.getResource("/App/iconApp.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 827, 563);
        setResizable(false);
        setLocationRelativeTo(null);
    }

	private void iniciarComponentes() {
        panelPrincipal = new JPanel();
        panelPrincipal.setBackground(new Color(205, 171, 143));

        setContentPane(panelPrincipal);
        panelPrincipal.setLayout(null);
        
        JLabel lblLogo = new JLabel("");
        lblLogo.setIcon(new ImageIcon(VentanaUsuario.class.getResource("/App/iconResize.png")));
        lblLogo.setBounds(560, 166, 204, 200);
        panelPrincipal.add(lblLogo);
        
        JLabel lblFondo = new JLabel("");
        lblFondo.setIcon(new ImageIcon(VentanaUsuario.class.getResource("/App/jajas.jpg")));
        lblFondo.setBounds(497, 0, 332, 533);
        panelPrincipal.add(lblFondo);
        
        JLabel lblIniciarSesin = new JLabel("INICIAR SESIÓN");
        lblIniciarSesin.setFont(new Font("Dialog", Font.BOLD, 20));
        lblIniciarSesin.setHorizontalAlignment(SwingConstants.CENTER);
        lblIniciarSesin.setBounds(65, 132, 240, 82);
        panelPrincipal.add(lblIniciarSesin);
        
        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        lblUsuario.setBounds(53, 235, 89, 15);
        panelPrincipal.add(lblUsuario);
        
        txtUsuario = new JTextField();
        txtUsuario.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtUsuario.getText().equals("Ingrese su nombre de usuario")) {
                    txtUsuario.setText("");
                    txtUsuario.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtUsuario.getText().isEmpty()) {
                    txtUsuario.setText("Ingrese su nombre de usuario");
                    txtUsuario.setForeground(new Color(119, 118, 123));
                }
            }
        });
        
        txtUsuario.setFont(new Font("Roboto", Font.BOLD, 12));
        txtUsuario.setForeground(new Color(119, 118, 123));
        txtUsuario.setText("Ingrese su nombre de usuario");
        txtUsuario.setBounds(65, 251, 256, 28);
        panelPrincipal.add(txtUsuario);
        txtUsuario.setColumns(10);
        
        JLabel lblContrasenia = new JLabel("Contraseña");
        lblContrasenia.setHorizontalAlignment(SwingConstants.CENTER);
        lblContrasenia.setBounds(65, 302, 89, 15);
        panelPrincipal.add(lblContrasenia);
        
        passField = new JPasswordField();
        passField.setForeground(new Color(119, 118, 123));
        passField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(passField.getPassword()).equals("**************")) {
                    passField.setText("");
                    passField.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(passField.getPassword()).isEmpty()) {
                    passField.setText("**************");
                    passField.setForeground(new Color(119, 118, 123));
                }
            }
        });

        passField.setText("**************");
        passField.setToolTipText("");
        passField.setBounds(65, 318, 256, 28);
        panelPrincipal.add(passField);
        
        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 String nombreUsuario = txtUsuario.getText();
        	        String contraseña = String.valueOf(passField.getPassword());

        	        if (AutenticadorUsuario.autenticarUsuario(nombreUsuario, contraseña)) {
        	            VentanaVuelos newframe = new VentanaVuelos();
        	            newframe.setVisible(true);
        	            dispose();
        	        } else {
        	            JOptionPane.showMessageDialog(null, "Datos incorrectos\nIntente nuevamente", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
        	}}}
        );
        btnIngresar.setBounds(65, 368, 117, 25);
        panelPrincipal.add(btnIngresar);
        
        JButton btnVolver = new JButton("<-");
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 VentanaInicio ventanaInicio = new VentanaInicio();
                 ventanaInicio.setVisible(true);
                 dispose();
        	}
        });
        btnVolver.setBounds(0, 0, 49, 28);
        btnVolver.setToolTipText("Volver al menu inicial");
        panelPrincipal.add(btnVolver);
    }
}