package model;

public class Proveedor extends Persona {
    private String tipoServicio;
    private String rubro;
    private int calificacion;
    private boolean activo;

    public Proveedor(String rut, String nombre, String apellido, String telefono, String email,
                     String tipoServicio, String rubro, int calificacion, boolean activo) {
        super(rut, nombre, apellido, telefono, email);
  
        this.tipoServicio = (tipoServicio == null || tipoServicio.trim().isEmpty()) ? "Sin especificar" : tipoServicio.trim();
        this.rubro = (rubro == null || rubro.trim().isEmpty()) ? "Sin rubro" : rubro.trim();
        this.calificacion = (calificacion < 1 || calificacion > 5) ? 3 : calificacion;
        this.activo = activo;
    }

    public Proveedor(String rut, String nombre, String apellido, String telefono,
                     String tipoServicio, String rubro, int calificacion) {
        this(rut, nombre, apellido, telefono, "sin@email.com", 
             tipoServicio, rubro, calificacion, true);
    }

    
    public String getTipoServicio() { return tipoServicio; }
    public String getRubro() { return rubro; }
    public int getCalificacion() { return calificacion; }
    public boolean isActivo() { return activo; }

    
    public void setTipoServicio(String tipoServicio) {
        try {
            if (tipoServicio == null || tipoServicio.trim().isEmpty()) {
                throw new IllegalArgumentException("El tipo de servicio no puede estar vacío");
            }
            this.tipoServicio = tipoServicio.trim();
        } catch (IllegalArgumentException e) {
            System.err.println("Error en tipo servicio: " + e.getMessage());
            this.tipoServicio = "Sin especificar";
        }
    }

    public void setRubro(String rubro) {
        try {
            if (rubro == null || rubro.trim().isEmpty()) {
                throw new IllegalArgumentException("El rubro no puede estar vacío");
            }
            this.rubro = rubro.trim();
        } catch (IllegalArgumentException e) {
            System.err.println("Error en rubro: " + e.getMessage());
            this.rubro = "Sin rubro";
        }
    }

    public void setCalificacion(int calificacion) {
        try {
            if (calificacion < 1 || calificacion > 5) {
                throw new IllegalArgumentException("La calificación debe ser entre 1 y 5");
            }
            this.calificacion = calificacion;
        } catch (IllegalArgumentException e) {
            System.err.println("Error en calificación: " + e.getMessage());
            this.calificacion = 3;
        }
    }

    public void setActivo(boolean activo) { this.activo = activo; }

    @Override
    public String toString() {
        return super.toString() +
               " | Servicio: " + tipoServicio +
               " | Rubro: " + rubro +
               " | Calificación: " + calificacion + "★" +
               " | Estado: " + (activo ? "Activo" : "Inactivo");
    }
}