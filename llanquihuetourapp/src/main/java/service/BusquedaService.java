package service;

import java.util.List;
import java.util.Scanner;

import data.DataManager;
import model.Guia;
import model.Proveedor;
import model.Tour;
import model.ServicioTuristico;
import model.RutaGastronomica;
import model.PaseoLacustre;
import model.ExcursionCultural;

public class BusquedaService {
    private final DataManager dataManager;
    private final Scanner scanner;

    public BusquedaService(DataManager dataManager) {
        this.dataManager = dataManager;
        this.scanner = new Scanner(System.in);
    }

    // Métodos existentes (buscarGuiasPorEspecialidad, buscarGuiasCertificadas, etc.)
    // ...

    // Nuevos métodos para servicios turísticos
    public void buscarServiciosPorNombre() {
        System.out.println("\n=== BÚSQUEDA DE SERVICIOS POR NOMBRE ===\n");
        System.out.print("Ingrese el nombre del servicio a buscar: ");
        String nombre = scanner.nextLine();
        
        List<ServicioTuristico> resultados = dataManager.buscarServiciosPorNombre(nombre);
        
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron servicios con ese nombre.");
        } else {
            System.out.println("\nRESULTADOS (" + resultados.size() + " servicios):");
            resultados.forEach(System.out::println);
        }
    }

    public void buscarServiciosPorDuracion() {
        System.out.println("\n=== BÚSQUEDA DE SERVICIOS POR DURACIÓN ===\n");
        System.out.print("Ingrese la duración máxima en horas: ");
        double horasMax = Double.parseDouble(scanner.nextLine());
        
        List<ServicioTuristico> resultados = dataManager.buscarServiciosPorDuracion(horasMax);
        
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron servicios con duración ≤ " + horasMax + " horas");
        } else {
            System.out.println("\nRESULTADOS (" + resultados.size() + " servicios):");
            resultados.forEach(System.out::println);
        }
    }

    public void listarServiciosPorTipo() {
        System.out.println("\n=== SERVICIOS POR TIPO ===\n");
        
        System.out.println("--- RUTAS GASTRONÓMICAS ---");
        List<RutaGastronomica> rutas = dataManager.getRutasGastronomicas();
        if (rutas.isEmpty()) {
            System.out.println("No hay rutas gastronómicas registradas.");
        } else {
            rutas.forEach(System.out::println);
        }
        
        System.out.println("\n--- PASEOS LACUSTRES ---");
        List<PaseoLacustre> paseos = dataManager.getPaseosLacustres();
        if (paseos.isEmpty()) {
            System.out.println("No hay paseos lacustres registrados.");
        } else {
            paseos.forEach(System.out::println);
        }
        
        System.out.println("\n--- EXCURSIONES CULTURALES ---");
        List<ExcursionCultural> excursiones = dataManager.getExcursionesCulturales();
        if (excursiones.isEmpty()) {
            System.out.println("No hay excursiones culturales registradas.");
        } else {
            excursiones.forEach(System.out::println);
        }
    }

    // Modificar el menú de búsqueda para incluir servicios
    public void mostrarMenuBusqueda() {
        System.out.println("\n=== MENÚ DE BÚSQUEDA ===");
        System.out.println("1. Buscar Guías por Especialidad");
        System.out.println("2. Ver Guías Certificadas");
        System.out.println("3. Buscar Proveedores por Rubro");
        System.out.println("4. Buscar Tours por Precio Máximo");
        System.out.println("5. Buscar Servicios por Nombre");
        System.out.println("6. Buscar Servicios por Duración");
        System.out.println("7. Listar Servicios por Tipo");
        System.out.println("8. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
        
        int opcion = Integer.parseInt(scanner.nextLine());
        
        switch (opcion) {
            case 1 -> buscarGuiasPorEspecialidad();
            case 2 -> buscarGuiasCertificadas();
            case 3 -> buscarProveedoresPorRubro();
            case 4 -> buscarToursPorPrecio();
            case 5 -> buscarServiciosPorNombre();
            case 6 -> buscarServiciosPorDuracion();
            case 7 -> listarServiciosPorTipo();
            case 8 -> System.out.println("Volviendo al menú principal...");
            default -> System.out.println("Opción no válida");
        }
    }

    // Métodos existentes (buscarGuiasPorEspecialidad, etc.) se mantienen igual
    // Solo se agregan los nuevos métodos para servicios
}