package App;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaCrearUsuario extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel panelPrincipal;
    private JTextField txtNombreUsuario;
    private JPasswordField passField;
    private JPasswordField confirmarPassField;
    private JTextField txtEmail;

    private void limpiarCampos() {
        txtNombreUsuario.setText("Ingrese su nombre de usuario");
        txtNombreUsuario.setForeground(new Color(119, 118, 123));
        passField.setText("**************");
        passField.setForeground(new Color(119, 118, 123));
        confirmarPassField.setText("**************");
        confirmarPassField.setForeground(new Color(119, 118, 123));
        txtEmail.setText("Ingrese su correo electrónico");
        txtEmail.setForeground(new Color(119, 118, 123));
    }
    
    public VentanaCrearUsuario() {
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

        JLabel lblCrearUsuario = new JLabel("CREAR USUARIO");
        lblCrearUsuario.setFont(new Font("Dialog", Font.BOLD, 20));
        lblCrearUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        lblCrearUsuario.setBounds(0, 24, 240, 82);
        panelPrincipal.add(lblCrearUsuario);

        txtNombreUsuario = new JTextField();
        txtNombreUsuario.setFont(new Font("Roboto", Font.BOLD, 12));
        txtNombreUsuario.setForeground(new Color(119, 118, 123));
        txtNombreUsuario.setText("Ingrese su nombre de usuario");
        txtNombreUsuario.setBounds(65, 130, 256, 28);
        panelPrincipal.add(txtNombreUsuario);
        txtNombreUsuario.setColumns(10);

        passField = new JPasswordField();
        passField.setForeground(new Color(119, 118, 123));
        passField.setText("**************");
        passField.setBounds(65, 180, 256, 28);
        panelPrincipal.add(passField);

        confirmarPassField = new JPasswordField();
        confirmarPassField.setForeground(new Color(119, 118, 123));
        confirmarPassField.setText("**************");
        confirmarPassField.setBounds(65, 230, 256, 28);
        panelPrincipal.add(confirmarPassField);

        txtEmail = new JTextField();
        txtEmail.setFont(new Font("Roboto", Font.BOLD, 12));
        txtEmail.setForeground(new Color(119, 118, 123));
        txtEmail.setText("Ingrese su correo electrónico");
        txtEmail.setBounds(65, 283, 256, 28);
        panelPrincipal.add(txtEmail);
        txtEmail.setColumns(10);

        // FocusListeners
        txtNombreUsuario.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtNombreUsuario.getText().equals("Ingrese su nombre de usuario")) {
                    txtNombreUsuario.setText("");
                    txtNombreUsuario.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtNombreUsuario.getText().isEmpty()) {
                    txtNombreUsuario.setText("Ingrese su nombre de usuario");
                    txtNombreUsuario.setForeground(new Color(119, 118, 123));
                }
            }
        });

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

        confirmarPassField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(confirmarPassField.getPassword()).equals("**************")) {
                    confirmarPassField.setText("");
                    confirmarPassField.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(confirmarPassField.getPassword()).isEmpty()) {
                    confirmarPassField.setText("**************");
                    confirmarPassField.setForeground(new Color(119, 118, 123));
                }
            }
        });

        txtEmail.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtEmail.getText().equals("Ingrese su correo electrónico")) {
                    txtEmail.setText("");
                    txtEmail.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtEmail.getText().isEmpty()) {
                    txtEmail.setText("Ingrese su correo electrónico");
                    txtEmail.setForeground(new Color(119, 118, 123));
                }
            }
        });

        JButton btnCrearUsuario = new JButton("Crear Usuario");
        btnCrearUsuario.setBounds(65, 330, 150, 28);
        btnCrearUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              
                String nombreUsuario = txtNombreUsuario.getText();
                String contraseña = String.valueOf(passField.getPassword());
                String confirmarContraseña = String.valueOf(confirmarPassField.getPassword());
                String email = txtEmail.getText();

                
                if ("Ingrese su nombre de usuario".equals(nombreUsuario) || "**************".equals(contraseña) ||
                    "**************".equals(confirmarContraseña) || "Ingrese su correo electrónico".equals(email)) {
                    JOptionPane.showMessageDialog(null, "Todos los campos deben ser completados", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!contraseña.equals(confirmarContraseña)) {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
              
                Usuario nuevoUsuario = new Usuario(nombreUsuario, contraseña, email);

                List<Usuario> usuarios = CSVReader.leerUsuariosDesdeCSV();
            
                usuarios.add(nuevoUsuario);
            
                CSVWriter.escribirUsuariosEnCSV(usuarios);
         
                JOptionPane.showMessageDialog(null, "Usuario creado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                       
                limpiarCampos();
            }
        });


        panelPrincipal.add(btnCrearUsuario);

        JButton btnVolver = new JButton("<-");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaInicio ventanaInicio = new VentanaInicio();
                ventanaInicio.setVisible(true);
                dispose();
            }
        });
        btnVolver.setBounds(0, 0, 49, 28);
        btnVolver.setToolTipText("Volver al menú inicial");
        panelPrincipal.add(btnVolver);
        
        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setBounds(65, 113, 70, 15);
        panelPrincipal.add(lblUsuario);
        
        JLabel lblContraseña = new JLabel("Contraseña");
        lblContraseña.setBounds(65, 166, 94, 15);
        panelPrincipal.add(lblContraseña);
        
        JLabel lblConfContraseña = new JLabel("Confirmar contraseña");
        lblConfContraseña.setBounds(65, 214, 175, 15);
        panelPrincipal.add(lblConfContraseña);
        
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(65, 269, 70, 15);
        panelPrincipal.add(lblEmail);
    }
}
