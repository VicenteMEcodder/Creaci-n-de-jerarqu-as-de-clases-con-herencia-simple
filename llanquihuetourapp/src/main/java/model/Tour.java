package model;

import java.util.ArrayList;
import java.util.List;

public class Tour {
    private String codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private int duracionHoras;
    private Guia guiaAsignado;
    private List<Proveedor> proveedores;
    private List<String> actividades;

    public Tour(String codigo, String nombre, String descripcion, double precio, 
                int duracionHoras, Guia guiaAsignado) {
 
        this.codigo = (codigo == null || codigo.trim().isEmpty()) ? "TMP-000" : codigo.trim();
        this.nombre = (nombre == null || nombre.trim().isEmpty()) ? "Tour sin nombre" : nombre.trim();
        this.descripcion = (descripcion == null) ? "" : descripcion;
        this.precio = (precio < 0) ? 0.0 : precio;
        this.duracionHoras = (duracionHoras <= 0) ? 1 : duracionHoras;
        this.guiaAsignado = guiaAsignado;
        this.proveedores = new ArrayList<>();
        this.actividades = new ArrayList<>();
    }


    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio() { return precio; }
    public int getDuracionHoras() { return duracionHoras; }
    public Guia getGuiaAsignado() { return guiaAsignado; }
    public List<Proveedor> getProveedores() { return proveedores; }
    public List<String> getActividades() { return actividades; }

    
    public void setCodigo(String codigo) {
        try {
            if (codigo == null || codigo.trim().isEmpty()) {
                throw new IllegalArgumentException("El código no puede estar vacío");
            }
            this.codigo = codigo.trim();
        } catch (IllegalArgumentException e) {
            System.err.println("Error en código: " + e.getMessage());
            this.codigo = "TMP-000";
        }
    }

    public void setNombre(String nombre) {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre no puede estar vacío");
            }
            this.nombre = nombre.trim();
        } catch (IllegalArgumentException e) {
            System.err.println("Error en nombre: " + e.getMessage());
            this.nombre = "Tour sin nombre";
        }
    }

    public void setDescripcion(String descripcion) { 
        this.descripcion = (descripcion == null) ? "" : descripcion; 
    }

    public void setPrecio(double precio) {
        try {
            if (precio < 0) {
                throw new IllegalArgumentException("El precio no puede ser negativo");
            }
            this.precio = precio;
        } catch (IllegalArgumentException e) {
            System.err.println("Error en precio: " + e.getMessage());
            this.precio = 0.0;
        }
    }

    public void setDuracionHoras(int duracionHoras) {
        try {
            if (duracionHoras <= 0) {
                throw new IllegalArgumentException("La duración debe ser mayor a 0");
            }
            this.duracionHoras = duracionHoras;
        } catch (IllegalArgumentException e) {
            System.err.println("Error en duración: " + e.getMessage());
            this.duracionHoras = 1;
        }
    }

    public void setGuiaAsignado(Guia guiaAsignado) { this.guiaAsignado = guiaAsignado; }
    public void setProveedores(List<Proveedor> proveedores) { this.proveedores = proveedores; }
    public void setActividades(List<String> actividades) { this.actividades = actividades; }

    //agregar elementos
    public void agregarProveedor(Proveedor proveedor) {
        if (proveedor != null && !proveedores.contains(proveedor)) {
            proveedores.add(proveedor);
        }
    }

    public void agregarActividad(String actividad) {
        if (actividad != null && !actividad.trim().isEmpty() && !actividades.contains(actividad.trim())) {
            actividades.add(actividad.trim());
        }
    }

    public String mostrarResumen() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== TOUR: ").append(codigo).append(" ===\n");
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("Descripción: ").append(descripcion).append("\n");
        sb.append("Precio: $").append(precio).append("\n");
        sb.append("Duración: ").append(duracionHoras).append(" horas\n");
        sb.append("Guía asignado: ").append(guiaAsignado != null ? guiaAsignado.getNombre() : "Sin asignar").append("\n");
        sb.append("Proveedores (").append(proveedores.size()).append("):\n");
        for (Proveedor p : proveedores) {
            sb.append("  - ").append(p.getNombre()).append(" (").append(p.getRubro()).append(")\n");
        }
        sb.append("Actividades:\n");
        for (String act : actividades) {
            sb.append("  - ").append(act).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Tour: " + codigo + " | " + nombre + " | $" + precio + " | " + duracionHoras + "h";
    }
}