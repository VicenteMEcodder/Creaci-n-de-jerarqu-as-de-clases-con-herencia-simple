package data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.ExcursionCultural;
import model.Guia;
import model.Operador;
import model.PaseoLacustre;
import model.Proveedor;
import model.RutaGastronomica;
import model.ServicioTuristico;
import model.Tour;

public class DataManager {
    private List<Guia> guias;
    private List<Proveedor> proveedores;
    private List<Operador> operadores;
    private List<Tour> tours;
    private List<ServicioTuristico> serviciosTuristicos; 

    public DataManager() {
        this.guias = new ArrayList<>();
        this.proveedores = new ArrayList<>();
        this.operadores = new ArrayList<>();
        this.tours = new ArrayList<>();
        this.serviciosTuristicos = new ArrayList<>(); 
    }

    public void cargarTodosLosDatos() {
        System.out.println("=== CARGANDO DATOS DE LA AGENCIA ===\n");
        
        this.guias = DataLoader.cargarGuias("guias.txt");
        this.proveedores = DataLoader.cargarProveedores("proveedores.txt");
        this.operadores = DataLoader.cargarOperadores("operadores.txt");
        this.tours = DataLoader.cargarTours("tours.txt", this.guias, this.proveedores);
        
    
        this.serviciosTuristicos = crearServiciosDePrueba();
        
        System.out.println("\n=== CARGA COMPLETADA ===\n");
        System.out.println("Servicios turísticos cargados: " + serviciosTuristicos.size());
    }

    private List<ServicioTuristico> crearServiciosDePrueba() {
        List<ServicioTuristico> servicios = new ArrayList<>();
        

        servicios.add(new RutaGastronomica("Ruta del Vino y Mar", 4.5, 5));
        servicios.add(new RutaGastronomica("Sabores del Lago", 3.0, 4));
        servicios.add(new RutaGastronomica("Cocina Mapuche", 6.0, 8));
        

        servicios.add(new PaseoLacustre("Navegación al Atardecer", 2.0, "Velero"));
        servicios.add(new PaseoLacustre("Exploración de Islas", 5.0, "Lancha Motora"));
        servicios.add(new PaseoLacustre("Tour Fotográfico", 3.5, "Kayak"));
        
   
        servicios.add(new ExcursionCultural("Ruta de los Fuertes", 6.0, "Fuerte San José"));
        servicios.add(new ExcursionCultural("Historia del Lago", 3.5, "Museo Colonial"));
        servicios.add(new ExcursionCultural("Arte y Tradición", 4.0, "Mercado Artesanal"));
        
        return servicios;
    }


    public List<Guia> getGuias() { return guias; }
    public List<Proveedor> getProveedores() { return proveedores; }
    public List<Operador> getOperadores() { return operadores; }
    public List<Tour> getTours() { return tours; }
    public List<ServicioTuristico> getServiciosTuristicos() { return serviciosTuristicos; }


    public List<ServicioTuristico> buscarServiciosPorNombre(String nombre) {
        return serviciosTuristicos.stream()
                .filter(s -> s.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<ServicioTuristico> buscarServiciosPorDuracion(double horasMaximas) {
        return serviciosTuristicos.stream()
                .filter(s -> s.getDuracionHoras() <= horasMaximas)
                .collect(Collectors.toList());
    }

    
    public List<RutaGastronomica> getRutasGastronomicas() {
        return serviciosTuristicos.stream()
                .filter(s -> s instanceof RutaGastronomica)
                .map(s -> (RutaGastronomica) s)
                .collect(Collectors.toList());
    }

    public List<PaseoLacustre> getPaseosLacustres() {
        return serviciosTuristicos.stream()
                .filter(s -> s instanceof PaseoLacustre)
                .map(s -> (PaseoLacustre) s)
                .collect(Collectors.toList());
    }

    public List<ExcursionCultural> getExcursionesCulturales() {
        return serviciosTuristicos.stream()
                .filter(s -> s instanceof ExcursionCultural)
                .map(s -> (ExcursionCultural) s)
                .collect(Collectors.toList());
    }


    public void mostrarEstadisticas() {
        System.out.println("\n=== ESTADÍSTICAS DE LA AGENCIA ===\n");
        System.out.println("Total de Guías: " + guias.size());
        System.out.println("Total de Proveedores: " + proveedores.size());
        System.out.println("Total de Operadores: " + operadores.size());
        System.out.println("Total de Tours: " + tours.size());
        System.out.println("Total de Servicios Turísticos: " + serviciosTuristicos.size());
        
        if (!serviciosTuristicos.isEmpty()) {
            System.out.println("\n--- Desglose de Servicios ---");
            System.out.println("  Rutas Gastronómicas: " + getRutasGastronomicas().size());
            System.out.println("  Paseos Lacustres: " + getPaseosLacustres().size());
            System.out.println("  Excursiones Culturales: " + getExcursionesCulturales().size());
        }
        
        if (!guias.isEmpty()) {
            long certificados = guias.stream().filter(Guia::isCertificado).count();
            System.out.println("\nGuías certificados: " + certificados + " (" + 
                             (certificados * 100 / guias.size()) + "%)");
        }
        
        if (!proveedores.isEmpty()) {
            long activos = proveedores.stream().filter(Proveedor::isActivo).count();
            System.out.println("Proveedores activos: " + activos + " (" + 
                             (activos * 100 / proveedores.size()) + "%)");
        }
    }


    public void mostrarTodosLosDatos() {
        System.out.println("\n=== LISTADO COMPLETO DE DATOS ===\n");
        
        System.out.println("--- GUÍAS (" + guias.size() + ") ---");
        guias.forEach(System.out::println);
        
        System.out.println("\n--- PROVEEDORES (" + proveedores.size() + ") ---");
        proveedores.forEach(System.out::println);
        
        System.out.println("\n--- OPERADORES (" + operadores.size() + ") ---");
        operadores.forEach(System.out::println);
        
        System.out.println("\n--- TOURS (" + tours.size() + ") ---");
        tours.forEach(System.out::println);
        
        System.out.println("\n--- SERVICIOS TURÍSTICOS (" + serviciosTuristicos.size() + ") ---");
        System.out.println("  Rutas Gastronómicas:");
        getRutasGastronomicas().forEach(r -> System.out.println("    " + r));
        System.out.println("  Paseos Lacustres:");
        getPaseosLacustres().forEach(p -> System.out.println("    " + p));
        System.out.println("  Excursiones Culturales:");
        getExcursionesCulturales().forEach(e -> System.out.println("    " + e));
    }
}