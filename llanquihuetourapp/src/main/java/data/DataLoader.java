package data;

import model.Guia;
import model.Proveedor;
import model.Operador;
import model.Tour;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {

    public static List<Guia> cargarGuias(String nombreArchivo) {
        List<Guia> guias = new ArrayList<>();
        String ruta = "resources/" + nombreArchivo;

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            int numeroLinea = 0;
            while ((linea = br.readLine()) != null) {
                numeroLinea++;
                String[] datos = linea.split(",");
                
                //rut,nombre,apellido,telefono,email,especialidad,anosExp,certificado,idiomas
                if (datos.length == 9) {
                    try {
                        Guia guia = new Guia(
                            datos[0].trim(),
                            datos[1].trim(),
                            datos[2].trim(),
                            datos[3].trim(),
                            datos[4].trim(),
                            datos[5].trim(),
                            Integer.parseInt(datos[6].trim()),
                            Boolean.parseBoolean(datos[7].trim()),
                            datos[8].trim()
                        );
                        guias.add(guia);
                    } catch (NumberFormatException e) {
                        System.err.println("Error en línea " + numeroLinea + ": formato de número inválido");
                    }
                } else {
                    System.err.println("Línea " + numeroLinea + " omitida: formato incorrecto (" + datos.length + " campos)");
                }
            }
            System.out.println("Se cargaron " + guias.size() + " guías correctamente.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de guías: " + e.getMessage());
        }
        return guias;
    }

    public static List<Proveedor> cargarProveedores(String nombreArchivo) {
        List<Proveedor> proveedores = new ArrayList<>();
        String ruta = "resources/" + nombreArchivo;

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            int numeroLinea = 0;
            while ((linea = br.readLine()) != null) {
                numeroLinea++;
                String[] datos = linea.split(",");
                
                // rut,nombre,apellido,telefono,email,tipoServicio,rubro,calificacio
                if (datos.length == 8) {
                    try {
                        Proveedor proveedor = new Proveedor(
                            datos[0].trim(),  // rut
                            datos[1].trim(),  // nombre
                            datos[2].trim(),  // apellido
                            datos[3].trim(),  // telefono
                            datos[4].trim(),  // email
                            datos[5].trim(),  // tipoServicio
                            datos[6].trim(),  // rubro
                            Integer.parseInt(datos[7].trim()) // calificacion
                        );
                        proveedores.add(proveedor);
                    } catch (NumberFormatException e) {
                        System.err.println("Error en línea " + numeroLinea + ": formato de número inválido");
                    }
                } else {
                    System.err.println("Línea " + numeroLinea + " omitida: formato incorrecto (" + datos.length + " campos)");
                }
            }
            System.out.println("Se cargaron " + proveedores.size() + " proveedores correctamente.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de proveedores: " + e.getMessage());
        }
        return proveedores;
    }

    public static List<Operador> cargarOperadores(String nombreArchivo) {
        List<Operador> operadores = new ArrayList<>();
        String ruta = "resources/" + nombreArchivo;

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            int numeroLinea = 0;
            while ((linea = br.readLine()) != null) {
                numeroLinea++;
                String[] datos = linea.split(",");
                
                //rut,nombre,apellido,telefono,email,tipoOperacion,zona,capacidad
                if (datos.length == 8) {
                    try {
                        Operador operador = new Operador(
                            datos[0].trim(),  // rut
                            datos[1].trim(),  // nombre
                            datos[2].trim(),  // apellido
                            datos[3].trim(),  // telefono
                            datos[4].trim(),  // email
                            datos[5].trim(),  // tipoOperacion
                            datos[6].trim(),  // zonaOperacion
                            Integer.parseInt(datos[7].trim()) // capacidadMaxima
                        );
                        operadores.add(operador);
                    } catch (NumberFormatException e) {
                        System.err.println("Error en línea " + numeroLinea + ": formato de número inválido");
                    }
                } else {
                    System.err.println("Línea " + numeroLinea + " omitida: formato incorrecto (" + datos.length + " campos)");
                }
            }
            System.out.println("Se cargaron " + operadores.size() + " operadores correctamente.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de operadores: " + e.getMessage());
        }
        return operadores;
    }

    public static List<Tour> cargarTours(String nombreArchivo, List<Guia> guias, List<Proveedor> proveedores) {
        List<Tour> tours = new ArrayList<>();
        String ruta = "resources/" + nombreArchivo;

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            int numeroLinea = 0;
            while ((linea = br.readLine()) != null) {
                numeroLinea++;
                String[] datos = linea.split(",");
                
                if (datos.length >= 5) {
                    try {
                        String codigo = datos[0].trim();
                        String nombreTour = datos[1].trim();
                        String descripcion = datos[2].trim();
                        double precio = Double.parseDouble(datos[3].trim());
                        int duracion = Integer.parseInt(datos[4].trim());
                        
                        Guia guiaAsignado = null;
                        if (datos.length > 5 && !datos[5].trim().isEmpty()) {
                            String rutGuia = datos[5].trim();
                            for (Guia g : guias) {
                                if (g.getRut().equals(rutGuia)) {
                                    guiaAsignado = g;
                                    break;
                                }
                            }
                        }
                        
                        Tour tour = new Tour(codigo, nombreTour, descripcion, precio, duracion, guiaAsignado);
                        
                        if (datos.length > 6 && !datos[6].trim().isEmpty()) {
                            String[] rutsProveedores = datos[6].trim().split("\\|");
                            for (String rutProv : rutsProveedores) {
                                for (Proveedor p : proveedores) {
                                    if (p.getRut().equals(rutProv.trim())) {
                                        tour.agregarProveedor(p);
                                        break;
                                    }
                                }
                            }
                        }
                        
                        if (datos.length > 7 && !datos[7].trim().isEmpty()) {
                            String[] actividades = datos[7].trim().split("\\|");
                            for (String act : actividades) {
                                tour.agregarActividad(act.trim());
                            }
                        }
                        
                        tours.add(tour);
                    } catch (NumberFormatException e) {
                        System.err.println("Error en línea " + numeroLinea + ": formato de número inválido");
                    }
                } else {
                    System.err.println("Línea " + numeroLinea + " omitida: formato incorrecto");
                }
            }
            System.out.println("Se cargaron " + tours.size() + " tours correctamente.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de tours: " + e.getMessage());
        }
        return tours;
    }
}