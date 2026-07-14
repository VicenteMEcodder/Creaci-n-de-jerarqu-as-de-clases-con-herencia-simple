package service;

import java.util.List;
import java.util.Scanner;

import data.DataManager;
import model.ExcursionCultural;
import model.Guia;
import model.PaseoLacustre;
import model.Proveedor;
import model.RutaGastronomica;
import model.ServicioTuristico;
import model.Tour;

public class BusquedaService {
    private final DataManager dataManager;
    private final Scanner scanner;

    public BusquedaService(DataManager dataManager) {
        this.dataManager = dataManager;
        this.scanner = new Scanner(System.in);
    }

    private void buscarGuiasPorEspecialidad() {
        System.out.println("\n=== BUSQUEDA DE GUIAS POR ESPECIALIDAD ===\n");
        System.out.print("Ingrese la especialidad: ");
        String especialidad = scanner.nextLine().toLowerCase();
        
        List<Guia> resultados = dataManager.getGuias().stream()
            .filter(g -> g.getEspecialidad().toLowerCase().contains(especialidad))
            .toList();
        
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron guias con esa especialidad.");
        } else {
            System.out.println("\nRESULTADOS (" + resultados.size() + " guias):");
            resultados.forEach(System.out::println);
        }
    }

    private void buscarGuiasCertificadas() {
        System.out.println("\n=== GUIAS CERTIFICADAS ===\n");
        List<Guia> certificados = dataManager.getGuias().stream()
            .filter(Guia::isCertificado)
            .toList();
        
        if (certificados.isEmpty()) {
            System.out.println("No hay guias certificados.");
        } else {
            System.out.println("Guias certificados (" + certificados.size() + "):");
            certificados.forEach(System.out::println);
        }
    }

    private void buscarProveedoresPorRubro() {
        System.out.println("\n=== BUSQUEDA DE PROVEEDORES POR RUBRO ===\n");
        System.out.print("Ingrese el rubro: ");
        String rubro = scanner.nextLine().toLowerCase();
        
        List<Proveedor> resultados = dataManager.getProveedores().stream()
            .filter(p -> p.getRubro().toLowerCase().contains(rubro))
            .toList();
        
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron proveedores con ese rubro.");
        } else {
            System.out.println("\nRESULTADOS (" + resultados.size() + " proveedores):");
            resultados.forEach(System.out::println);
        }
    }

    private void buscarToursPorPrecio() {
        System.out.println("\n=== BUSQUEDA DE TOURS POR PRECIO ===\n");
        System.out.print("Ingrese el precio maximo: ");
        double precioMax = Double.parseDouble(scanner.nextLine());
        
        List<Tour> resultados = dataManager.getTours().stream()
            .filter(t -> t.getPrecio() <= precioMax)
            .toList();
        
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron tours con precio <= " + precioMax);
        } else {
            System.out.println("\nRESULTADOS (" + resultados.size() + " tours):");
            resultados.forEach(System.out::println);
        }
    }

    public void buscarServiciosPorNombre() {
        System.out.println("\n=== BUSQUEDA DE SERVICIOS POR NOMBRE ===\n");
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
        System.out.println("\n=== BUSQUEDA DE SERVICIOS POR DURACION ===\n");
        System.out.print("Ingrese la duracion maxima en horas: ");
        double horasMax = Double.parseDouble(scanner.nextLine());
        
        List<ServicioTuristico> resultados = dataManager.buscarServiciosPorDuracion(horasMax);
        
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron servicios con duracion <= " + horasMax + " horas");
        } else {
            System.out.println("\nRESULTADOS (" + resultados.size() + " servicios):");
            resultados.forEach(System.out::println);
        }
    }

    public void listarServiciosPorTipo() {
        System.out.println("\n=== SERVICIOS POR TIPO ===\n");
        
        System.out.println("--- RUTAS GASTRONOMICAS ---");
        List<RutaGastronomica> rutas = dataManager.getRutasGastronomicas();
        if (rutas.isEmpty()) {
            System.out.println("No hay rutas gastronomicas registradas.");
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

    public void mostrarMenuBusqueda() {
        System.out.println("\n=== MENU DE BUSQUEDA ===");
        System.out.println("1. Buscar Guias por Especialidad");
        System.out.println("2. Ver Guias Certificadas");
        System.out.println("3. Buscar Proveedores por Rubro");
        System.out.println("4. Buscar Tours por Precio Maximo");
        System.out.println("5. Buscar Servicios por Nombre");
        System.out.println("6. Buscar Servicios por Duracion");
        System.out.println("7. Listar Servicios por Tipo");
        System.out.println("8. Volver al menu principal");
        System.out.print("Seleccione una opcion: ");
        
        int opcion = Integer.parseInt(scanner.nextLine());
        
        switch (opcion) {
            case 1 -> buscarGuiasPorEspecialidad();
            case 2 -> buscarGuiasCertificadas();
            case 3 -> buscarProveedoresPorRubro();
            case 4 -> buscarToursPorPrecio();
            case 5 -> buscarServiciosPorNombre();
            case 6 -> buscarServiciosPorDuracion();
            case 7 -> listarServiciosPorTipo();
            case 8 -> System.out.println("Volviendo al menu principal...");
            default -> System.out.println("Opcion no valida");
        }
    }
}