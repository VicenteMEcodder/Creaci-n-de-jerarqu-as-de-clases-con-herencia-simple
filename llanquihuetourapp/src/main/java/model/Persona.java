package model;

public class Persona implements Registrable {
    private String rut;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    public Persona(String rut, String nombre, String apellido, String telefono, String email) {
        this.rut = (rut == null || rut.trim().isEmpty()) ? "00000000-0" : rut.trim();
        this.nombre = (nombre == null || nombre.trim().isEmpty()) ? "Sin nombre" : nombre.trim();
        this.apellido = (apellido == null || apellido.trim().isEmpty()) ? "Sin apellido" : apellido.trim();
        this.telefono = (telefono == null || telefono.trim().isEmpty()) ? "000000000" : telefono.trim();
        this.email = (email == null || email.trim().isEmpty()) ? "sin@email.com" : email.trim();
    }

    public Persona(String rut, String nombre, String apellido, String telefono) {
        this(rut, nombre, apellido, telefono, "sin@email.com");
    }

    public String getRut() { return rut; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }

    public void setRut(String rut) {
        try {
            if (rut == null || rut.trim().isEmpty()) {
                throw new IllegalArgumentException("El RUT no puede estar vacio");
            }
            this.rut = rut.trim();
        } catch (IllegalArgumentException e) {
            System.err.println("Error en RUT: " + e.getMessage());
            this.rut = "00000000-0";
        }
    }

    public void setNombre(String nombre) {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre no puede estar vacio");
            }
            this.nombre = nombre.trim();
        } catch (IllegalArgumentException e) {
            System.err.println("Error en nombre: " + e.getMessage());
            this.nombre = "Sin nombre";
        }
    }

    public void setApellido(String apellido) {
        try {
            if (apellido == null || apellido.trim().isEmpty()) {
                throw new IllegalArgumentException("El apellido no puede estar vacio");
            }
            this.apellido = apellido.trim();
        } catch (IllegalArgumentException e) {
            System.err.println("Error en apellido: " + e.getMessage());
            this.apellido = "Sin apellido";
        }
    }

    public void setTelefono(String telefono) {
        try {
            if (telefono == null || telefono.trim().isEmpty()) {
                throw new IllegalArgumentException("El telefono no puede estar vacio");
            }
            this.telefono = telefono.trim();
        } catch (IllegalArgumentException e) {
            System.err.println("Error en telefono: " + e.getMessage());
            this.telefono = "000000000";
        }
    }

    public void setEmail(String email) {
        try {
            if (email == null || email.trim().isEmpty()) {
                throw new IllegalArgumentException("El email no puede estar vacio");
            }
            this.email = email.trim();
        } catch (IllegalArgumentException e) {
            System.err.println("Error en email: " + e.getMessage());
            this.email = "sin@email.com";
        }
    }

    @Override
    public String mostrarResumen() {
        return "Persona: " + nombre + " " + apellido + 
               " | RUT: " + rut + 
               " | Telefono: " + telefono;
    }

    @Override
    public String toString() {
        return "RUT: " + rut + 
               " | Nombre: " + nombre + " " + apellido + 
               " | Telefono: " + telefono +
               " | Email: " + email;
    }
}