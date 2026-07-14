package model;

import java.util.ArrayList;
import java.util.List;

public class Tour implements Registrable {
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
                throw new IllegalArgumentException("El codigo no puede estar vacio");
            }
            this.codigo = codigo.trim();
        } catch (IllegalArgumentException e) {
            System.err.println("Error en codigo: " + e.getMessage());
            this.codigo = "TMP-000";
        }
    }

    public void setNombre(String nombre) {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre no puede estar vacio");
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
                throw new IllegalArgumentException("La duracion debe ser mayor a 0");
            }
            this.duracionHoras = duracionHoras;
        } catch (IllegalArgumentException e) {
            System.err.println("Error en duracion: " + e.getMessage());
            this.duracionHoras = 1;
        }
    }

    public void setGuiaAsignado(Guia guiaAsignado) { this.guiaAsignado = guiaAsignado; }
    public void setProveedores(List<Proveedor> proveedores) { this.proveedores = proveedores; }
    public void setActividades(List<String> actividades) { this.actividades = actividades; }

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

    @Override
    public String mostrarResumen() {
        return """
               Tour
                  Codigo: """ + codigo + "\n" +
               "   Nombre: " + nombre + "\n" +
               "   Precio: $" + String.format("%.0f", precio) + "\n" +
               "   Duracion: " + duracionHoras + " horas\n" +
               "   Guia: " + (guiaAsignado != null ? guiaAsignado.getNombre() : "Sin asignar") + "\n" +
               "   Proveedores: " + proveedores.size() + "\n" +
               "   Actividades: " + actividades.size();
    }

    @Override
    public String toString() {
        return "Tour: " + codigo + " | " + nombre + " | $" + precio + " | " + duracionHoras + "h";
    }
}