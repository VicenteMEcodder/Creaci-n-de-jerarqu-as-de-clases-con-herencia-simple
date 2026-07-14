package app;

import java.util.Scanner;

import data.DataManager;
import service.BusquedaService;
import service.RegistroService;

public class LlanquihueTourApp {
    private static DataManager dataManager;
    private static RegistroService registroService;
    private static BusquedaService busquedaService;
    private static Scanner scanner;

    public static void main(String[] args) {
        dataManager = new DataManager();
        registroService = new RegistroService(dataManager);
        busquedaService = new BusquedaService(dataManager);
        scanner = new Scanner(System.in);

        mostrarEncabezado();
        dataManager.cargarTodosLosDatos();
        dataManager.mostrarEstadisticas();

        boolean continuar = true;
        while (continuar) {
            mostrarMenuPrincipal();
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> dataManager.mostrarTodosLosDatos();
                case 2 -> busquedaService.mostrarMenuBusqueda();
                case 3 -> registroService.mostrarMenuRegistro();
                case 4 -> dataManager.mostrarEstadisticas();
                case 5 -> {
                    System.out.println("\nAbriendo interfaz grafica...");
                    ui.GuiLlanquihueTour.main(new String[0]);
                }
                case 6 -> {
                    System.out.println("\nGracias por usar Llanquihue Tour App!");
                    continuar = false;
                }
                default -> System.out.println("Opcion no valida. Intente nuevamente.");
            }
        }

        scanner.close();
    }

    private static void mostrarEncabezado() {
        System.out.println("+=================================================+");
        System.out.println("|                                                 |");
        System.out.println("|        LLANQUIHUE TOUR APP                      |");
        System.out.println("|        Sistema de Gestion Turistica             |");
        System.out.println("|        Region de Los Lagos, Chile               |");
        System.out.println("|                                                 |");
        System.out.println("+=================================================+\n");
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1. Mostrar todos los datos");
        System.out.println("2. Buscar informacion");
        System.out.println("3. Registrar nuevo elemento");
        System.out.println("4. Ver estadisticas");
        System.out.println("5. Abrir interfaz grafica");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opcion: ");
    }
}