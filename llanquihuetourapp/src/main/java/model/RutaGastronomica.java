package model;

public class RutaGastronomica extends ServicioTuristico {
    private int numeroDeParadas;

    public RutaGastronomica(String nombre, double duracionHoras, int numeroDeParadas) {
        super(nombre, duracionHoras);
        this.numeroDeParadas = (numeroDeParadas < 1) ? 1 : Math.min(numeroDeParadas, 20);
    }

    public int getNumeroDeParadas() { return numeroDeParadas; }

    public void setNumeroDeParadas(int numeroDeParadas) {
        try {
            if (numeroDeParadas < 1) {
                throw new IllegalArgumentException("El número de paradas debe ser al menos 1");
            }
            if (numeroDeParadas > 20) {
                throw new IllegalArgumentException("El número de paradas no puede superar 20");
            }
            this.numeroDeParadas = numeroDeParadas;
        } catch (IllegalArgumentException e) {
            System.err.println("Error en número de paradas: " + e.getMessage());
            this.numeroDeParadas = 1;
        }
    }

    @Override
    public String toString() {
        return "Ruta Gastronómica | " + super.toString() + " | Paradas: " + numeroDeParadas;
    }
}