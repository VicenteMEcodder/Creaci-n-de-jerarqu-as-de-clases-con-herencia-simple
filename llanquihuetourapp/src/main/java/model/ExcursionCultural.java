package model;

public class ExcursionCultural extends ServicioTuristico {
    private String lugarHistorico;

    public ExcursionCultural(String nombre, double duracionHoras, String lugarHistorico) {
        super(nombre, duracionHoras);
        this.lugarHistorico = (lugarHistorico == null || lugarHistorico.trim().isEmpty()) 
                             ? "Sin lugar historico" : lugarHistorico.trim();
    }

    public String getLugarHistorico() { return lugarHistorico; }

    public void setLugarHistorico(String lugarHistorico) {
        try {
            if (lugarHistorico == null || lugarHistorico.trim().isEmpty()) {
                throw new IllegalArgumentException("El lugar historico no puede estar vacio");
            }
            this.lugarHistorico = lugarHistorico.trim();
        } catch (IllegalArgumentException e) {
            System.err.println("Error en lugar historico: " + e.getMessage());
            this.lugarHistorico = "Sin lugar historico";
        }
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("=== EXCURSION CULTURAL ===");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Duracion: " + getDuracionHoras() + " horas");
        System.out.println("Lugar historico: " + lugarHistorico);
        System.out.println("Tipo de servicio: Excursion Cultural");
        System.out.println("=========================");
    }

    @Override
    public String mostrarResumen() {
        return """
               Excursion cultural
                  Nombre: """ + getNombre() + "\n" +
               "   Duracion: " + getDuracionHoras() + " horas\n" +
               "   Lugar Historico: " + lugarHistorico;
    }
}