package model;

public class ExcursionCultural extends ServicioTuristico {
    private String lugarHistorico;

    public ExcursionCultural(String nombre, double duracionHoras, String lugarHistorico) {
        super(nombre, duracionHoras);
        this.lugarHistorico = (lugarHistorico == null || lugarHistorico.trim().isEmpty()) 
                             ? "Sin lugar histórico" : lugarHistorico.trim();
    }

    public String getLugarHistorico() { return lugarHistorico; }

    public void setLugarHistorico(String lugarHistorico) {
        try {
            if (lugarHistorico == null || lugarHistorico.trim().isEmpty()) {
                throw new IllegalArgumentException("El lugar histórico no puede estar vacío");
            }
            this.lugarHistorico = lugarHistorico.trim();
        } catch (IllegalArgumentException e) {
            System.err.println("Error en lugar histórico: " + e.getMessage());
            this.lugarHistorico = "Sin lugar histórico";
        }
    }

    @Override
    public String toString() {
        return "Excursión Cultural | " + super.toString() + " | Lugar Histórico: " + lugarHistorico;
    }
}