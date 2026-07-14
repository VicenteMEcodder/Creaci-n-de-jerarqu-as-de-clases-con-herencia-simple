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
                throw new IllegalArgumentException("El numero de paradas debe ser al menos 1");
            }
            if (numeroDeParadas > 20) {
                throw new IllegalArgumentException("El numero de paradas no puede superar 20");
            }
            this.numeroDeParadas = numeroDeParadas;
        } catch (IllegalArgumentException e) {
            System.err.println("Error en numero de paradas: " + e.getMessage());
            this.numeroDeParadas = 1;
        }
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("=== RUTA GASTRONOMICA ===");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Duracion: " + getDuracionHoras() + " horas");
        System.out.println("Numero de paradas: " + numeroDeParadas);
        System.out.println("Tipo de servicio: Ruta Gastronomica");
        System.out.println("========================");
    }

    @Override
    public String mostrarResumen() {
        return """
               Ruta gastronomica
                  Nombre: """ + getNombre() + "\n" +
               "   Duracion: " + getDuracionHoras() + " horas\n" +
               "   Paradas: " + numeroDeParadas + " lugares";
    }
}