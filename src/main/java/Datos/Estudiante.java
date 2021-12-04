package Datos;

import java.util.ArrayList;
import java.util.Random;

public class Estudiante {
    private String nombre;
    private Salon salonClase;
    private boolean atencion;
    private ArrayList<String> actividades;
    private String actividadActual;

    public void hacerAlgo() {
        Random randomGenerate = new Random();

        int indice = randomGenerate.nextInt(actividades.size() - 1);
        this.setActividadActual(actividades.get(indice));
        String actividad = this.getActividadActual();
        mostrarAccion(actividad);
        this.distraerse(indice);
    }

    public void mostrarAccion(String a) {
        System.out.println(
                "El estudiante: " + this.getNombre() + " del salon " + this.getSalonClase().getNumeroSalon()
                        + " está " + a);
    }

    public void distraerse(int indice) {
        if (indice % 2 == 0) {
            this.setAtencion(false);
        } else {
            this.setAtencion(true);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Salon getSalonClase() {
        return salonClase;
    }

    public void setSalonClase(Salon salonClase) {
        this.salonClase = salonClase;
    }

    public boolean getAtencion() {
        return atencion;
    }

    public void setAtencion(boolean atencion) {
        this.atencion = atencion;
    }

    public ArrayList<String> getActividades() {
        return actividades;
    }

    public void setActividades(ArrayList<String> actividades) {
        this.actividades = actividades;
    }

    public String getActividadActual() {
        return actividadActual;
    }

    public void setActividadActual(String actividadActual) {
        this.actividadActual = actividadActual;
    }

    // CONSTRUCTORES
    public Estudiante(String nombre) {
        this.nombre = nombre;
        this.atencion = true;
        this.actividades = new ArrayList<String>();
        ;
        actividades.add("leyendo");
        actividades.add("jugando");
        actividades.add("hablando");
        actividades.add("distraido");

    }

}
