package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import data.GestorEntidades;
import model.Guia;
import model.Operador;
import model.Proveedor;
import model.Registrable;
import model.ServicioTuristico;
import model.Tour;

public class GuiLlanquihueTour extends JFrame {
    private final GestorEntidades gestor;
    private JTextArea areaResultados;
    
    public GuiLlanquihueTour() {
        this.gestor = new GestorEntidades();
        inicializarGUI();
        cargarDatosEjemplo();
    }
    
    private void inicializarGUI() {
        setTitle("Llanquihue Tour - Sistema de Gestion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(41, 128, 185));
        JLabel titulo = new JLabel("Sistema de Gestion Turistica - Llanquihue Tour");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setForeground(Color.WHITE);
        panelTitulo.add(titulo);
        add(panelTitulo, BorderLayout.NORTH);
        
        areaResultados = new JTextArea();
        areaResultados.setEditable(false);
        areaResultados.setFont(new Font("Monospaced", Font.PLAIN, 13));
        JScrollPane scrollPane = new JScrollPane(areaResultados);
        add(scrollPane, BorderLayout.CENTER);
        
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 4, 10, 10));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JButton btnRegistrarGuia = crearBoton("Registrar Guia", new Color(52, 152, 219));
        JButton btnRegistrarProveedor = crearBoton("Registrar Proveedor", new Color(46, 204, 113));
        JButton btnRegistrarTour = crearBoton("Registrar Tour", new Color(231, 76, 60));
        JButton btnMostrar = crearBoton("Mostrar Entidades", new Color(155, 89, 182));
        JButton btnEstadisticas = crearBoton("Estadisticas", new Color(241, 196, 15));
        JButton btnSalir = crearBoton("Salir", new Color(189, 195, 199));
        
        panelBotones.add(btnRegistrarGuia);
        panelBotones.add(btnRegistrarProveedor);
        panelBotones.add(btnRegistrarTour);
        panelBotones.add(btnMostrar);
        panelBotones.add(btnEstadisticas);
        panelBotones.add(btnSalir);
        
        add(panelBotones, BorderLayout.SOUTH);
        
        btnRegistrarGuia.addActionListener(e -> registrarGuia());
        btnRegistrarProveedor.addActionListener(e -> registrarProveedor());
        btnRegistrarTour.addActionListener(e -> registrarTour());
        btnMostrar.addActionListener(e -> mostrarEntidades());
        btnEstadisticas.addActionListener(e -> mostrarEstadisticas());
        btnSalir.addActionListener(e -> System.exit(0));
        
        setVisible(true);
    }
    
    private JButton crearBoton(String texto, Color color) {
        JButton boton = new JButton(texto);
        boton.setBackground(color);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Arial", Font.BOLD, 12));
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setOpaque(true);
        return boton;
    }
    
    private void cargarDatosEjemplo() {
        gestor.agregarEntidad(new Guia("12345678-9", "Maria", "Gonzalez", "987654321", 
            "maria@email.com", "Trekking", 5, true, "Espanol, Ingles"));
        gestor.agregarEntidad(new Proveedor("87654321-0", "Juan", "Perez", "912345678", 
            "juan@email.com", "Transporte", "Turismo", 4));
        gestor.agregarEntidad(new Tour("TR-001", "Tour Lago Todos los Santos", 
            "Recorrido por el lago", 45000, 4, null));
        areaResultados.append("Datos de ejemplo cargados correctamente.\n");
    }
    
    private void registrarGuia() {
        try {
            String rut = JOptionPane.showInputDialog(this, "Ingrese el RUT:", "Registrar Guia", JOptionPane.QUESTION_MESSAGE);
            if (rut == null || rut.trim().isEmpty()) return;
            
            String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre:", "Registrar Guia", JOptionPane.QUESTION_MESSAGE);
            if (nombre == null || nombre.trim().isEmpty()) return;
            
            String apellido = JOptionPane.showInputDialog(this, "Ingrese el apellido:", "Registrar Guia", JOptionPane.QUESTION_MESSAGE);
            if (apellido == null || apellido.trim().isEmpty()) return;
            
            String telefono = JOptionPane.showInputDialog(this, "Ingrese el telefono:", "Registrar Guia", JOptionPane.QUESTION_MESSAGE);
            if (telefono == null || telefono.trim().isEmpty()) return;
            
            String especialidad = JOptionPane.showInputDialog(this, "Ingrese la especialidad:", "Registrar Guia", JOptionPane.QUESTION_MESSAGE);
            if (especialidad == null || especialidad.trim().isEmpty()) return;
            
            String experienciaStr = JOptionPane.showInputDialog(this, "Ingrese los anos de experiencia:", "Registrar Guia", JOptionPane.QUESTION_MESSAGE);
            if (experienciaStr == null || experienciaStr.trim().isEmpty()) return;
            int experiencia = Integer.parseInt(experienciaStr);
            
            String certificadoStr = JOptionPane.showInputDialog(this, "Esta certificado? (S/N):", "Registrar Guia", JOptionPane.QUESTION_MESSAGE);
            if (certificadoStr == null || certificadoStr.trim().isEmpty()) return;
            boolean certificado = certificadoStr.equalsIgnoreCase("S");
            
            String idiomas = JOptionPane.showInputDialog(this, "Ingrese los idiomas:", "Registrar Guia", JOptionPane.QUESTION_MESSAGE);
            if (idiomas == null || idiomas.trim().isEmpty()) return;
            
            Guia guia = new Guia(rut, nombre, apellido, telefono, "sin@email.com", 
                                 especialidad, experiencia, certificado, idiomas);
            gestor.agregarEntidad(guia);
            
            JOptionPane.showMessageDialog(this, "Guia registrado exitosamente!", 
                                         "Exito", JOptionPane.INFORMATION_MESSAGE);
            areaResultados.append("Guia registrado: " + nombre + " " + apellido + "\n");
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: El formato del numero es invalido", 
                                         "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void registrarProveedor() {
        try {
            String rut = JOptionPane.showInputDialog(this, "Ingrese el RUT:", "Registrar Proveedor", JOptionPane.QUESTION_MESSAGE);
            if (rut == null || rut.trim().isEmpty()) return;
            
            String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre:", "Registrar Proveedor", JOptionPane.QUESTION_MESSAGE);
            if (nombre == null || nombre.trim().isEmpty()) return;
            
            String apellido = JOptionPane.showInputDialog(this, "Ingrese el apellido:", "Registrar Proveedor", JOptionPane.QUESTION_MESSAGE);
            if (apellido == null || apellido.trim().isEmpty()) return;
            
            String telefono = JOptionPane.showInputDialog(this, "Ingrese el telefono:", "Registrar Proveedor", JOptionPane.QUESTION_MESSAGE);
            if (telefono == null || telefono.trim().isEmpty()) return;
            
            String tipoServicio = JOptionPane.showInputDialog(this, "Ingrese el tipo de servicio:", "Registrar Proveedor", JOptionPane.QUESTION_MESSAGE);
            if (tipoServicio == null || tipoServicio.trim().isEmpty()) return;
            
            String rubro = JOptionPane.showInputDialog(this, "Ingrese el rubro:", "Registrar Proveedor", JOptionPane.QUESTION_MESSAGE);
            if (rubro == null || rubro.trim().isEmpty()) return;
            
            String calificacionStr = JOptionPane.showInputDialog(this, "Ingrese la calificacion (1-5):", "Registrar Proveedor", JOptionPane.QUESTION_MESSAGE);
            if (calificacionStr == null || calificacionStr.trim().isEmpty()) return;
            int calificacion = Integer.parseInt(calificacionStr);
            
            Proveedor proveedor = new Proveedor(rut, nombre, apellido, telefono, "sin@email.com", 
                                                tipoServicio, rubro, calificacion);
            gestor.agregarEntidad(proveedor);
            
            JOptionPane.showMessageDialog(this, "Proveedor registrado exitosamente!", 
                                         "Exito", JOptionPane.INFORMATION_MESSAGE);
            areaResultados.append("Proveedor registrado: " + nombre + " " + apellido + "\n");
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: El formato del numero es invalido", 
                                         "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void registrarTour() {
        try {
            String codigo = JOptionPane.showInputDialog(this, "Ingrese el codigo:", "Registrar Tour", JOptionPane.QUESTION_MESSAGE);
            if (codigo == null || codigo.trim().isEmpty()) return;
            
            String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del tour:", "Registrar Tour", JOptionPane.QUESTION_MESSAGE);
            if (nombre == null || nombre.trim().isEmpty()) return;
            
            String descripcion = JOptionPane.showInputDialog(this, "Ingrese la descripcion:", "Registrar Tour", JOptionPane.QUESTION_MESSAGE);
            if (descripcion == null) return;
            
            String precioStr = JOptionPane.showInputDialog(this, "Ingrese el precio:", "Registrar Tour", JOptionPane.QUESTION_MESSAGE);
            if (precioStr == null || precioStr.trim().isEmpty()) return;
            double precio = Double.parseDouble(precioStr);
            
            String duracionStr = JOptionPane.showInputDialog(this, "Ingrese la duracion (horas):", "Registrar Tour", JOptionPane.QUESTION_MESSAGE);
            if (duracionStr == null || duracionStr.trim().isEmpty()) return;
            int duracion = Integer.parseInt(duracionStr);
            
            Tour tour = new Tour(codigo, nombre, descripcion, precio, duracion, null);
            gestor.agregarEntidad(tour);
            
            JOptionPane.showMessageDialog(this, "Tour registrado exitosamente!", 
                                         "Exito", JOptionPane.INFORMATION_MESSAGE);
            areaResultados.append("Tour registrado: " + nombre + " (" + codigo + ")\n");
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: El formato del numero es invalido", 
                                         "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void mostrarEntidades() {
        areaResultados.setText("");
        areaResultados.append("LISTADO DE ENTIDADES REGISTRADAS\n");
        areaResultados.append("=".repeat(60) + "\n");
        
        if (gestor.getEntidades().isEmpty()) {
            areaResultados.append("No hay entidades registradas.\n");
            return;
        }
        
        areaResultados.append("Total: " + gestor.getEntidades().size() + " entidades\n\n");
        
        for (Registrable entidad : gestor.getEntidades()) {
            if (entidad == null) {
                areaResultados.append("ENTIDAD NULA ENCONTRADA\n");
                areaResultados.append("-".repeat(50) + "\n");
                continue;
            }
            
            if (entidad instanceof Guia) {
                areaResultados.append("GUIA TURISTICO\n");
            } else if (entidad instanceof Proveedor) {
                areaResultados.append("PROVEEDOR\n");
            } else if (entidad instanceof Operador) {
                areaResultados.append("OPERADOR\n");
            } else if (entidad instanceof Tour) {
                areaResultados.append("TOUR\n");
            } else if (entidad instanceof ServicioTuristico) {
                areaResultados.append("SERVICIO TURISTICO\n");
            }
            
            areaResultados.append(entidad.mostrarResumen() + "\n");
            areaResultados.append("-".repeat(50) + "\n");
        }
    }
    
    private void mostrarEstadisticas() {
        areaResultados.setText("");
        areaResultados.append("ESTADISTICAS DE ENTIDADES\n");
        areaResultados.append("=".repeat(50) + "\n");
        areaResultados.append("Total entidades: " + gestor.getEntidades().size() + "\n");
        
        long guias = gestor.getEntidades().stream().filter(e -> e instanceof Guia).count();
        long proveedores = gestor.getEntidades().stream().filter(e -> e instanceof Proveedor).count();
        long operadores = gestor.getEntidades().stream().filter(e -> e instanceof Operador).count();
        long tours = gestor.getEntidades().stream().filter(e -> e instanceof Tour).count();
        long servicios = gestor.getEntidades().stream().filter(e -> e instanceof ServicioTuristico).count();
        
        areaResultados.append("   - Guias: " + guias + "\n");
        areaResultados.append("   - Proveedores: " + proveedores + "\n");
        areaResultados.append("   - Operadores: " + operadores + "\n");
        areaResultados.append("   - Tours: " + tours + "\n");
        areaResultados.append("   - Servicios Turisticos: " + servicios + "\n");
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GuiLlanquihueTour();
        });
    }
}