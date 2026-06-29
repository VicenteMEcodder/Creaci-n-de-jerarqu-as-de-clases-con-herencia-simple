package model;

public class PaseoLacustre extends ServicioTuristico {
    private String tipoEmbarcacion;

    public PaseoLacustre(String nombre, double duracionHoras, String tipoEmbarcacion) {
        super(nombre, duracionHoras);
        this.tipoEmbarcacion = (tipoEmbarcacion == null || tipoEmbarcacion.trim().isEmpty()) 
                              ? "Sin especificar" : tipoEmbarcacion.trim();
    }

    public String getTipoEmbarcacion() { return tipoEmbarcacion; }

    public void setTipoEmbarcacion(String tipoEmbarcacion) {
        try {
            if (tipoEmbarcacion == null || tipoEmbarcacion.trim().isEmpty()) {
                throw new IllegalArgumentException("El tipo de embarcación no puede estar vacío");
            }
            this.tipoEmbarcacion = tipoEmbarcacion.trim();
        } catch (IllegalArgumentException e) {
            System.err.println("Error en tipo de embarcación: " + e.getMessage());
            this.tipoEmbarcacion = "Sin especificar";
        }
    }

    @Override
    public String toString() {
        return "Paseo Lacustre | " + super.toString() + " | Embarcación: " + tipoEmbarcacion;
    }
}