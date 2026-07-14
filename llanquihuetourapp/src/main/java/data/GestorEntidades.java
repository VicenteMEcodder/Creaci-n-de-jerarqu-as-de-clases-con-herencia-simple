package data;

import java.util.ArrayList;
import java.util.List;

import model.Guia;
import model.Operador;
import model.Proveedor;
import model.Registrable;
import model.ServicioTuristico;
import model.Tour;

public class GestorEntidades {
    private final List<Registrable> entidades;
    
    public GestorEntidades() {
        this.entidades = new ArrayList<>();
    }
    
    public void agregarEntidad(Registrable entidad) {
        if (entidad != null) {
            entidades.add(entidad);
        }
    }

    public void agregarEntidades(List<Registrable> entidades) {
        if (entidades != null) {
            this.entidades.addAll(entidades);
        }
    }

    public List<Registrable> getEntidades() {
        return entidades;
    }
    
    public void mostrarTodosLosResumenes() {
        if (entidades.isEmpty()) {
            System.out.println("No hay entidades registradas.");
            return;
        }
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("      LISTADO DE ENTIDADES REGISTRADAS");
        System.out.println("=".repeat(60));
        System.out.println("Total: " + entidades.size() + " entidades\n");
        
        int contador = 1;
        for (Registrable entidad : entidades) {
            if (entidad == null) {
                System.out.println("[" + contador + "] Entidad nula encontrada");
                contador++;
                continue;
            }
            
            System.out.println("[" + contador + "] " + "-".repeat(50));
            
            if (entidad instanceof Guia) {
                System.out.println("TIPO: GUIA TURISTICO");
            } else if (entidad instanceof Proveedor) {
                System.out.println("TIPO: PROVEEDOR");
            } else if (entidad instanceof Operador) {
                System.out.println("TIPO: OPERADOR");
            } else if (entidad instanceof Tour) {
                System.out.println("TIPO: TOUR");
            } else if (entidad instanceof ServicioTuristico) {
                System.out.println("TIPO: SERVICIO TURISTICO");
            } else {
                System.out.println("TIPO: DESCONOCIDO");
            }
            
            System.out.println(entidad.mostrarResumen());
            System.out.println();
            contador++;
        }
        
        System.out.println("=".repeat(60));
    }
    
    public void mostrarEstadisticas() {
        System.out.println("\nESTADISTICAS DE ENTIDADES:");
        System.out.println("   Total entidades: " + entidades.size());
        
        long guias = entidades.stream().filter(e -> e instanceof Guia).count();
        long proveedores = entidades.stream().filter(e -> e instanceof Proveedor).count();
        long operadores = entidades.stream().filter(e -> e instanceof Operador).count();
        long tours = entidades.stream().filter(e -> e instanceof Tour).count();
        long servicios = entidades.stream().filter(e -> e instanceof ServicioTuristico).count();
        
        System.out.println("   - Guias: " + guias);
        System.out.println("   - Proveedores: " + proveedores);
        System.out.println("   - Operadores: " + operadores);
        System.out.println("   - Tours: " + tours);
        System.out.println("   - Servicios Turisticos: " + servicios);
    }
    
    public List<Registrable> filtrarPorTipo(Class<?> tipo) {
        List<Registrable> filtradas = new ArrayList<>();
        for (Registrable entidad : entidades) {
            if (entidad != null && tipo.isInstance(entidad)) {
                filtradas.add(entidad);
            }
        }
        return filtradas;
    }
}