package service;

import model.Guia;
import model.Proveedor;
import data.DataManager;

import java.util.Scanner;

public class RegistroService {
    private final DataManager dataManager;
    private final Scanner scanner;

    public RegistroService(DataManager dataManager) {
        this.dataManager = dataManager;
        this.scanner = new Scanner(System.in);
    }

    public void registrarNuevoGuia() {
        System.out.println("\n=== REGISTRO DE NUEVO GUÍA ===\n");
        
        try {
            System.out.print("RUT: ");
            String rut = scanner.nextLine();
            
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            
            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();
            
            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();
            
            System.out.print("Email: ");
            String email = scanner.nextLine();
            
            System.out.print("Especialidad: ");
            String especialidad = scanner.nextLine();
            
            System.out.print("Años de experiencia: ");
            int anosExperiencia = Integer.parseInt(scanner.nextLine());
            
            System.out.print("¿Está certificado? (true/false): ");
            boolean certificado = Boolean.parseBoolean(scanner.nextLine());
            
            System.out.print("Idiomas: ");
            String idiomas = scanner.nextLine();
            
            Guia nuevoGuia = new Guia(rut, nombre, apellido, telefono, email, 
                                     especialidad, anosExperiencia, certificado, idiomas);
            
            dataManager.getGuias().add(nuevoGuia);
            System.out.println("\n✅ Guía registrado exitosamente!");
            System.out.println(nuevoGuia);
            
        } catch (NumberFormatException e) {
            System.err.println("Error: Formato de número inválido. Intente nuevamente.");
        } catch (Exception e) {
            System.err.println("Error al registrar el guía: " + e.getMessage());
        }
    }

    public void registrarNuevoProveedor() {
        System.out.println("\n=== REGISTRO DE NUEVO PROVEEDOR ===\n");
        
        try {
            System.out.print("RUT: ");
            String rut = scanner.nextLine();
            
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            
            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();
            
            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();
            
            System.out.print("Email: ");
            String email = scanner.nextLine();
            
            System.out.print("Tipo de servicio: ");
            String tipoServicio = scanner.nextLine();
            
            System.out.print("Rubro: ");
            String rubro = scanner.nextLine();
            
            System.out.print("Calificación (1-5): ");
            int calificacion = Integer.parseInt(scanner.nextLine());
            
            Proveedor nuevoProveedor = new Proveedor(rut, nombre, apellido, telefono, email, 
                                                    tipoServicio, rubro, calificacion);
            
            dataManager.getProveedores().add(nuevoProveedor);
            System.out.println("\n✅ Proveedor registrado exitosamente!");
            System.out.println(nuevoProveedor);
            
        } catch (NumberFormatException e) {
            System.err.println("Error: Formato de número inválido. Intente nuevamente.");
        } catch (Exception e) {
            System.err.println("Error al registrar el proveedor: " + e.getMessage());
        }
    }

    // CORREGIDO: Usando Rule Switch (Java 14+)
    public void mostrarMenuRegistro() {
        System.out.println("\n=== MENÚ DE REGISTRO ===");
        System.out.println("1. Registrar Guía");
        System.out.println("2. Registrar Proveedor");
        System.out.println("3. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
        
        int opcion = Integer.parseInt(scanner.nextLine());
        
        switch (opcion) {
            case 1 -> registrarNuevoGuia();
            case 2 -> registrarNuevoProveedor();
            case 3 -> System.out.println("Volviendo al menú principal...");
            default -> System.out.println("Opción no válida");
        }
    }
}