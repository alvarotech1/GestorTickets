package App;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

public class VentanaVuelos extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel panelPrincipal;
    private JCheckBox chckIda;
    private JCheckBox chckbxIdaVuelta;
    private JDateChooser dateChooserIda;
    private JDateChooser dateChooserVuelta;
    private JComboBox<String> comboBoxClases;
    private JComboBox<String> comboBoxVuelosIda;
    private JComboBox<String> comboBoxVuelosVuelta;
    private JButton btnReservar;
    private List<Vuelo> listaVuelos;
    private List<Vuelo> vuelosIdaFiltrados;
    private List<Vuelo> vuelosVueltaFiltrados;

    
    public VentanaVuelos() {
        configurarVentana();
        cargarVuelos();
        iniciarComponentes();
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

        JButton btnVolver = new JButton("<-");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaUsuario ventanaInicio = new VentanaUsuario();
                ventanaInicio.setVisible(true);
                dispose();
            }
        });
        btnVolver.setBounds(0, 0, 49, 28);
        btnVolver.setToolTipText("Volver al menú inicial");
        panelPrincipal.add(btnVolver);
        
        JButton btnBuscarVuelos = new JButton("Buscar Vuelos");
        btnBuscarVuelos.setBounds(37, 420, 150, 30);
        btnBuscarVuelos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarVuelosSeleccionados();
                
               
            }});
        
        panelPrincipal.add(btnBuscarVuelos);


        comboBoxClases = new JComboBox<String>();
        comboBoxClases.setModel(new DefaultComboBoxModel<String>(new String[] { "Economica", "Ejecutiva", "Primera Clase" }));
        comboBoxClases.setToolTipText("");
        comboBoxClases.setBounds(37, 367, 155, 19);
        comboBoxClases.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
            }
        });
        panelPrincipal.add(comboBoxClases);

        comboBoxVuelosIda = new JComboBox<>();
        comboBoxVuelosIda.setBounds(37, 211, 379, 20);
        panelPrincipal.add(comboBoxVuelosIda);

        comboBoxVuelosVuelta = new JComboBox<>();
        comboBoxVuelosVuelta.setBounds(37, 250, 379, 20);
        panelPrincipal.add(comboBoxVuelosVuelta);

        dateChooserIda = new JDateChooser();
        dateChooserIda.setBounds(37, 306, 155, 19);
        dateChooserIda.getDateEditor().addPropertyChangeListener((e) -> {
            if ("date".equals(e.getPropertyName())) {
               
            }
        });
        panelPrincipal.add(dateChooserIda);
        dateChooserIda.setMinSelectableDate(new Date());
        dateChooserIda.setEnabled(false);

        dateChooserVuelta = new JDateChooser();
        dateChooserVuelta.setBounds(215, 306, 155, 19);
        dateChooserVuelta.getDateEditor().addPropertyChangeListener((e) -> {
            if ("date".equals(e.getPropertyName())) {
               
            }
        });
        panelPrincipal.add(dateChooserVuelta);
        dateChooserVuelta.setMinSelectableDate(new Date());
        dateChooserVuelta.setEnabled(false);

        chckIda = new JCheckBox("Ida");
        chckIda.setBounds(38, 153, 129, 23);
        panelPrincipal.add(chckIda);

        chckbxIdaVuelta = new JCheckBox("Ida y vuelta");
        chckbxIdaVuelta.setBounds(171, 153, 129, 23);
        panelPrincipal.add(chckbxIdaVuelta);

        ButtonGroup checkboxGroup = new ButtonGroup();
        checkboxGroup.add(chckIda);
        checkboxGroup.add(chckbxIdaVuelta);
        

        chckIda.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                	dateChooserIda.setCalendar(null);
                	dateChooserVuelta.setCalendar(null); 
                	comboBoxVuelosVuelta.removeAllItems();
                	comboBoxVuelosIda.removeAllItems();
                    dateChooserIda.setEnabled(true);
                    dateChooserVuelta.setEnabled(false);
                    chckbxIdaVuelta.setSelected(false);
                    
                } else {
                    dateChooserIda.setEnabled(false);
                }
            }
        });

        chckbxIdaVuelta.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                	dateChooserIda.setCalendar(null);
                	dateChooserVuelta.setCalendar(null);
                	comboBoxVuelosVuelta.removeAllItems();
                	comboBoxVuelosIda.removeAllItems();
                    dateChooserIda.setEnabled(true);
                    dateChooserVuelta.setEnabled(false);
                    chckIda.setSelected(false);
                   
                } else {
                    dateChooserIda.setEnabled(false);
                    dateChooserVuelta.setEnabled(false);
                }
            }
        });
        
        dateChooserIda.getDateEditor().addPropertyChangeListener((e) -> {
            if ("date".equals(e.getPropertyName())) {
                if (chckbxIdaVuelta.isSelected()) {
                    dateChooserVuelta.setEnabled(true);
                    dateChooserVuelta.setMinSelectableDate(dateChooserIda.getDate());
                }
            }
        });

        dateChooserVuelta.getDateEditor().addPropertyChangeListener((e) -> {
            if ("date".equals(e.getPropertyName())) {
                if (chckbxIdaVuelta.isSelected()) {
                    Date fechaIda = dateChooserIda.getDate();
                    Date fechaVuelta = dateChooserVuelta.getDate(); 
                    if (fechaIda != null && fechaVuelta != null && fechaVuelta.before(fechaIda)) {
                        JOptionPane.showMessageDialog(null, "La fecha de vuelta no puede ser anterior a la fecha de ida", "Fecha inválida", JOptionPane.WARNING_MESSAGE);
                        dateChooserVuelta.setDate(null);
                    }
                }
            }
        });

        JLabel lblTitulo = new JLabel("Seleccione su vuelo");
        lblTitulo.setFont(new Font("Dialog", Font.BOLD, 20));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(-22, 50, 527, 52);
        panelPrincipal.add(lblTitulo);
        
        btnReservar = new JButton("Reservar");
        btnReservar.setBounds(236, 367, 150, 19);
        btnReservar.setEnabled(false);
        btnReservar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				reservarVuelo();
				
			}
		});
        panelPrincipal.add(btnReservar);
        
        JLabel lblFechaDeIda = new JLabel("Fecha de ida");
        lblFechaDeIda.setBounds(37, 289, 109, 15);
        panelPrincipal.add(lblFechaDeIda);
        
        JLabel lblFechaDeVuelta = new JLabel("Fecha de vuelta");
        lblFechaDeVuelta.setBounds(216, 289, 129, 15);
        panelPrincipal.add(lblFechaDeVuelta);
        
        JLabel lblVueloDeIda = new JLabel("Vuelo de ida");
        lblVueloDeIda.setHorizontalAlignment(SwingConstants.CENTER);
        lblVueloDeIda.setBounds(37, 194, 379, 15);
        panelPrincipal.add(lblVueloDeIda);
        
        JLabel lblVueloDeVuelta = new JLabel("Vuelo de vuelta");
        lblVueloDeVuelta.setHorizontalAlignment(SwingConstants.CENTER);
        lblVueloDeVuelta.setBounds(37, 235, 379, 15);
        panelPrincipal.add(lblVueloDeVuelta);
        
        JLabel lblCategoria = new JLabel("Clase");
        lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
        lblCategoria.setBounds(37, 351, 155, 15);
        panelPrincipal.add(lblCategoria);
    }

    private void configurarVentana() {
        setTitle("AeroTicket Manager");
        setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaInicio.class.getResource("/App/iconApp.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 827, 563);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void cargarVuelos() {
        listaVuelos = CSVReader.leerVuelosDesdeCSV();
    }
    
    
    private void mostrarVuelosSeleccionados() {
        if (chckIda.isSelected()) {
          
            if (dateChooserIda.getDate() == null) {
            	btnReservar.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Por favor, seleccione una fecha de ida", "Fecha de vuelo no seleccionada", JOptionPane.WARNING_MESSAGE);
                return; 
            }
       
            btnReservar.setEnabled(true);
            vuelosIdaFiltrados = filtrarVuelosIda();
            cargarVuelosEnComboBoxIda();
        }
        if (chckbxIdaVuelta.isSelected()) {
            if (dateChooserVuelta.getDate() == null || dateChooserIda.getDate() == null) {
                btnReservar.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Por favor, seleccione una fecha de ida y de vuelta", "Fecha de vuelo no seleccionada", JOptionPane.WARNING_MESSAGE);
                return;
            }

           
            btnReservar.setEnabled(true);
            vuelosIdaFiltrados = filtrarVuelosIda();
            vuelosVueltaFiltrados = filtrarVuelosVuelta();
            cargarVuelosEnComboBoxIda();
            if(comboBoxVuelosIda.getSelectedItem() == null) {
            	return;
            }
            cargarVuelosEnComboBoxVuelta();
            
        }
    }


    private List<Vuelo> filtrarVuelosIda() {

        Date fechaIda = dateChooserIda.getDate();

 
        String claseSeleccionada = comboBoxClases.getSelectedItem().toString();


        List<Vuelo> vuelosFiltrados = new ArrayList<>();

        for (Vuelo vuelo : listaVuelos) {
            try {

                Date fechaVuelo = new SimpleDateFormat("yyyy-MM-dd").parse(vuelo.getFecha());
  
                if (isSameDay(fechaIda, fechaVuelo) && vuelo.getClase().equals(claseSeleccionada)) {
                    vuelosFiltrados.add(vuelo);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(vuelosFiltrados.isEmpty()) {
        	btnReservar.setEnabled(false);
       	 	JOptionPane.showMessageDialog(null, "No se han encontrado vuelos de ida para esa fecha", "Sin vuelos", JOptionPane.INFORMATION_MESSAGE);
       	 	
       }
        
        return vuelosFiltrados;
    }

    private List<Vuelo> filtrarVuelosVuelta() {
        // Obtener la lista de ciudades de destino de los vuelos de ida seleccionados
        List<String> ciudadesDestinoIda = obtenerCiudadesDestinoIdaSeleccionados();
        List<String> ciudadesOrigenIda = obtenerCiudadesOrigenIdaSeleccionados();
        Date fechaVuelta = dateChooserVuelta.getDate();
        String claseSeleccionada = comboBoxClases.getSelectedItem().toString();

        List<Vuelo> vuelosFiltrados = new ArrayList<>();

        for (Vuelo vuelo : listaVuelos) {
            try {
                Date fechaVuelo = new SimpleDateFormat("yyyy-MM-dd").parse(vuelo.getFecha());
                
                
                if (ciudadesDestinoIda.contains(vuelo.getOrigen()) && ciudadesOrigenIda.contains(vuelo.getDestino()) && isSameDay(fechaVuelta, fechaVuelo) && vuelo.getClase().equals(claseSeleccionada)) {
                    vuelosFiltrados.add(vuelo);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        
        if(vuelosFiltrados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se han encontrado vuelos de vuelta para esa fecha y destino", "Sin vuelos", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return vuelosFiltrados;
    }

    private List<String> obtenerCiudadesDestinoIdaSeleccionados() {
        List<String> ciudadesDestino = new ArrayList<>();
        
        for (Vuelo vuelo : vuelosIdaFiltrados) {
            ciudadesDestino.add(vuelo.getDestino());
        }
        
        return ciudadesDestino;
    }
    
    private List<String> obtenerCiudadesOrigenIdaSeleccionados() {
        List<String> ciudadesOrigen = new ArrayList<>();
        
        for (Vuelo vuelo : vuelosIdaFiltrados) {
            ciudadesOrigen.add(vuelo.getOrigen());
        }
        
        return ciudadesOrigen;
    }


    
    private void cargarVuelosEnComboBoxIda() {
        
        comboBoxVuelosIda.removeAllItems();
       
        for (Vuelo vuelo : vuelosIdaFiltrados) {
        	
            comboBoxVuelosIda.addItem("Vuelo " + vuelo.getId() + ": " + vuelo.getOrigen() + " a " + vuelo.getDestino() + " a la hora" + ": " + vuelo.getHora());
        }
        comboBoxVuelosIda.revalidate();
        comboBoxVuelosIda.repaint();
    }
    
    
    private void cargarVuelosEnComboBoxVuelta() {
    	comboBoxVuelosVuelta.removeAllItems();
    	for (Vuelo vuelo : vuelosVueltaFiltrados) {
    		comboBoxVuelosVuelta.addItem("Vuelo " + vuelo.getId() + ": " + vuelo.getOrigen() + " a " + vuelo.getDestino() + " a la hora" + ": " + vuelo.getHora());
    	}
    	comboBoxVuelosVuelta.revalidate();
    	comboBoxVuelosVuelta.repaint();
    }
    
    private boolean isSameDay(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
               cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
               cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
    }
    
    private void reservarVuelo() {
       
        if (chckIda.isSelected() && comboBoxVuelosIda.getItemCount() > 0) {
            if (comboBoxVuelosIda.getSelectedItem() != null) {
               
            	JOptionPane.showMessageDialog(null,"Reserva realizada para el vuelo: " + comboBoxVuelosIda.getSelectedItem().toString(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
               
                btnReservar.setEnabled(false);
                comboBoxVuelosIda.removeAllItems();
            } else {
                System.out.println("No hay elemento seleccionado en el ComboBox de ida.");
            }
        } else if (chckbxIdaVuelta.isSelected() && comboBoxVuelosIda.getItemCount() > 0 && comboBoxVuelosVuelta.getItemCount() > 0) {
           
            if (comboBoxVuelosIda.getSelectedItem() != null && comboBoxVuelosVuelta.getSelectedItem() != null) {
                
            	JOptionPane.showMessageDialog(null,"Reserva realizada para el vuelo de ida: " + comboBoxVuelosIda.getSelectedItem().toString() 
            	+ "\n" + "Reserva realizada para el vuelo de vuelta: " + comboBoxVuelosVuelta.getSelectedItem().toString(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
                
               
                btnReservar.setEnabled(false);
                dateChooserIda.setDate(null);
                dateChooserVuelta.setDate(null);
                comboBoxVuelosIda.removeAllItems();
                comboBoxVuelosVuelta.removeAllItems();
            } else {
                System.out.println("No hay elemento seleccionado en el ComboBox de ida o vuelta.");
            }
        } else {
        
            JOptionPane.showMessageDialog(null, "No se pueden realizar reservas. Verifique los datos seleccionados.", "Error de reserva", JOptionPane.ERROR_MESSAGE);
        }
        btnReservar.setEnabled(false);
    }
    
  
}
