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
                throw new IllegalArgumentException("El tipo de embarcacion no puede estar vacio");
            }
            this.tipoEmbarcacion = tipoEmbarcacion.trim();
        } catch (IllegalArgumentException e) {
            System.err.println("Error en tipo de embarcacion: " + e.getMessage());
            this.tipoEmbarcacion = "Sin especificar";
        }
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("=== PASEO LACUSTRE ===");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Duracion: " + getDuracionHoras() + " horas");
        System.out.println("Tipo de embarcacion: " + tipoEmbarcacion);
        System.out.println("Tipo de servicio: Paseo Lacustre");
        System.out.println("=====================");
    }

    @Override
    public String mostrarResumen() {
        return """
               Paseo lacustre
                  Nombre: """ + getNombre() + "\n" +
               "   Duracion: " + getDuracionHoras() + " horas\n" +
               "   Embarcacion: " + tipoEmbarcacion;
    }
}