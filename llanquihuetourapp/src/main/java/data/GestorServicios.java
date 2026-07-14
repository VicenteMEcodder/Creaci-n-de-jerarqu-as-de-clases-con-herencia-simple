package data;

import java.util.ArrayList;
import java.util.List;

import model.ExcursionCultural;
import model.PaseoLacustre;
import model.RutaGastronomica;
import model.ServicioTuristico;

public class GestorServicios {
    private final List<ServicioTuristico> servicios;
    
    public GestorServicios() {
        this.servicios = new ArrayList<>();
    }
    
    public void agregarServicio(ServicioTuristico servicio) {
        if (servicio != null) {
            servicios.add(servicio);
        }
    }

    public void agregarServicios(List<ServicioTuristico> servicios) {
        if (servicios != null) {
            this.servicios.addAll(servicios);
        }
    }

    public List<ServicioTuristico> getServicios() {
        return servicios;
    }
    
    public void mostrarTodosLosServicios() {
        if (servicios.isEmpty()) {
            System.out.println("No hay servicios registrados.");
            return;
        }
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("      LISTADO DE SERVICIOS TURISTICOS");
        System.out.println("=".repeat(50));
        System.out.println("Total: " + servicios.size() + " servicios\n");
        
        for (ServicioTuristico servicio : servicios) {
            servicio.mostrarInformacion();
            System.out.println();
        }
        
        System.out.println("=".repeat(50));
    }
    
    public void mostrarEstadisticas() {
        long rutasGastronomicas = servicios.stream()
            .filter(s -> s instanceof RutaGastronomica)
            .count();
        
        long paseosLacustres = servicios.stream()
            .filter(s -> s instanceof PaseoLacustre)
            .count();
        
        long excursionesCulturales = servicios.stream()
            .filter(s -> s instanceof ExcursionCultural)
            .count();
        
        System.out.println("\nEstadisticas de servicios:");
        System.out.println("  - Total servicios: " + servicios.size());
        System.out.println("  - Rutas Gastronomicas: " + rutasGastronomicas);
        System.out.println("  - Paseos Lacustres: " + paseosLacustres);
        System.out.println("  - Excursiones Culturales: " + excursionesCulturales);
    }
}