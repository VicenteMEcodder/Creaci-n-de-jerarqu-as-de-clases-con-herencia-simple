package model;

public class Operador extends Persona {
    private String tipoOperacion;
    private String zonaOperacion;
    private int capacidadMaxima;
    private boolean habilitado;

    public Operador(String rut, String nombre, String apellido, String telefono, String email,
                    String tipoOperacion, String zonaOperacion, int capacidadMaxima, boolean habilitado) {
        super(rut, nombre, apellido, telefono, email);
        this.tipoOperacion = (tipoOperacion == null || tipoOperacion.trim().isEmpty()) ? "Sin especificar" : tipoOperacion.trim();
        this.zonaOperacion = (zonaOperacion == null || zonaOperacion.trim().isEmpty()) ? "Sin zona" : zonaOperacion.trim();
        this.capacidadMaxima = (capacidadMaxima < 0) ? 0 : Math.min(capacidadMaxima, 1000);
        this.habilitado = habilitado;
    }

    public Operador(String rut, String nombre, String apellido, String telefono,
                    String tipoOperacion, String zonaOperacion, int capacidadMaxima) {
        this(rut, nombre, apellido, telefono, "sin@email.com", 
             tipoOperacion, zonaOperacion, capacidadMaxima, true);
    }

    public Operador(String rut, String nombre, String apellido, String telefono, String email,
                    String tipoOperacion, String zonaOperacion, int capacidadMaxima) {
        this(rut, nombre, apellido, telefono, email,
             tipoOperacion, zonaOperacion, capacidadMaxima, true);
    }

    public String getTipoOperacion() { return tipoOperacion; }
    public String getZonaOperacion() { return zonaOperacion; }
    public int getCapacidadMaxima() { return capacidadMaxima; }
    public boolean isHabilitado() { return habilitado; }

    public void setTipoOperacion(String tipoOperacion) {
        try {
            if (tipoOperacion == null || tipoOperacion.trim().isEmpty()) {
                throw new IllegalArgumentException("El tipo de operacion no puede estar vacio");
            }
            this.tipoOperacion = tipoOperacion.trim();
        } catch (IllegalArgumentException e) {
            System.err.println("Error en tipo operacion: " + e.getMessage());
            this.tipoOperacion = "Sin especificar";
        }
    }

    public void setZonaOperacion(String zonaOperacion) {
        try {
            if (zonaOperacion == null || zonaOperacion.trim().isEmpty()) {
                throw new IllegalArgumentException("La zona de operacion no puede estar vacia");
            }
            this.zonaOperacion = zonaOperacion.trim();
        } catch (IllegalArgumentException e) {
            System.err.println("Error en zona operacion: " + e.getMessage());
            this.zonaOperacion = "Sin zona";
        }
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        try {
            if (capacidadMaxima < 0) {
                throw new IllegalArgumentException("La capacidad no puede ser negativa");
            }
            if (capacidadMaxima > 1000) {
                throw new IllegalArgumentException("La capacidad no puede superar 1000");
            }
            this.capacidadMaxima = capacidadMaxima;
        } catch (IllegalArgumentException e) {
            System.err.println("Error en capacidad: " + e.getMessage());
            this.capacidadMaxima = 0;
        }
    }

    public void setHabilitado(boolean habilitado) { this.habilitado = habilitado; }

    @Override
    public String mostrarResumen() {
        return """
               Operador
                  Nombre: """ + getNombre() + " " + getApellido() + "\n" +
               "   RUT: " + getRut() + "\n" +
               "   Tipo Operacion: " + tipoOperacion + "\n" +
               "   Zona: " + zonaOperacion + "\n" +
               "   Capacidad: " + capacidadMaxima + " personas\n" +
               "   Habilitado: " + (habilitado ? "Si" : "No");
    }

    @Override
    public String toString() {
        return super.toString() +
               " | Operacion: " + tipoOperacion +
               " | Zona: " + zonaOperacion +
               " | Capacidad: " + capacidadMaxima +
               " | Habilitado: " + (habilitado ? "Si" : "No");
    }
}