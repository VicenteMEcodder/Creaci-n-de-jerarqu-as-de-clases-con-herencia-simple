package model;

public class ServicioTuristico {
    private String nombre;
    private double duracionHoras;

    public ServicioTuristico(String nombre, double duracionHoras) {
        this.nombre = (nombre == null || nombre.trim().isEmpty()) ? "Servicio sin nombre" : nombre.trim();
        this.duracionHoras = (duracionHoras <= 0) ? 1.0 : duracionHoras;
    }

    
    public String getNombre() { return nombre; }
    public double getDuracionHoras() { return duracionHoras; }

   
    public void setNombre(String nombre) {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre no puede estar vacío");
            }
            this.nombre = nombre.trim();
        } catch (IllegalArgumentException e) {
            System.err.println("Error en nombre: " + e.getMessage());
            this.nombre = "Servicio sin nombre";
        }
    }

    public void setDuracionHoras(double duracionHoras) {
        try {
            if (duracionHoras <= 0) {
                throw new IllegalArgumentException("La duración debe ser mayor a 0");
            }
            this.duracionHoras = duracionHoras;
        } catch (IllegalArgumentException e) {
            System.err.println("Error en duración: " + e.getMessage());
            this.duracionHoras = 1.0;
        }
    }

    @Override
    public String toString() {
        return "Servicio: " + nombre + " | Duración: " + duracionHoras + " horas";
    }
}