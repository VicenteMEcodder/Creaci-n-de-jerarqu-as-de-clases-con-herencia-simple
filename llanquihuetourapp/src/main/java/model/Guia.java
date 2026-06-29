package model;

public class Guia extends Persona {
    private String especialidad;
    private int anosExperiencia;
    private boolean certificado;
    private String idiomas;

    public Guia(String rut, String nombre, String apellido, String telefono, String email,
                String especialidad, int anosExperiencia, boolean certificado, String idiomas) {
        super(rut, nombre, apellido, telefono, email);
        this.especialidad = (especialidad == null || especialidad.trim().isEmpty()) ? "Sin especialidad" : especialidad.trim();
        this.anosExperiencia = (anosExperiencia < 0) ? 0 : Math.min(anosExperiencia, 50);
        this.certificado = certificado;
        this.idiomas = (idiomas == null || idiomas.trim().isEmpty()) ? "Español" : idiomas.trim();
    }

    public Guia(String rut, String nombre, String apellido, String telefono,
                String especialidad, int anosExperiencia, boolean certificado) {
        this(rut, nombre, apellido, telefono, "sin@email.com", 
             especialidad, anosExperiencia, certificado, "Español");
    }

    // Getters
    public String getEspecialidad() { return especialidad; }
    public int getAnosExperiencia() { return anosExperiencia; }
    public boolean isCertificado() { return certificado; }
    public String getIdiomas() { return idiomas; }

    // Setters
    public void setEspecialidad(String especialidad) {
        try {
            if (especialidad == null || especialidad.trim().isEmpty()) {
                throw new IllegalArgumentException("La especialidad no puede estar vacía");
            }
            this.especialidad = especialidad.trim();
        } catch (IllegalArgumentException e) {
            System.err.println("Error en especialidad: " + e.getMessage());
            this.especialidad = "Sin especialidad";
        }
    }

    public void setAnosExperiencia(int anosExperiencia) {
        try {
            if (anosExperiencia < 0) {
                throw new IllegalArgumentException("Los años de experiencia no pueden ser negativos");
            }
            if (anosExperiencia > 50) {
                throw new IllegalArgumentException("Los años de experiencia no pueden superar 50");
            }
            this.anosExperiencia = anosExperiencia;
        } catch (IllegalArgumentException e) {
            System.err.println("Error en años experiencia: " + e.getMessage());
            this.anosExperiencia = 0;
        }
    }

    public void setCertificado(boolean certificado) { this.certificado = certificado; }

    public void setIdiomas(String idiomas) {
        this.idiomas = (idiomas == null || idiomas.trim().isEmpty()) ? "Español" : idiomas.trim();
    }

    @Override
    public String toString() {
        return super.toString() +
               " | Especialidad: " + especialidad +
               " | Años Exp: " + anosExperiencia +
               " | Certificado: " + (certificado ? "Sí" : "No") +
               " | Idiomas: " + idiomas;
    }
}