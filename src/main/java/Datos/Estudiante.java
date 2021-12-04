package Datos;

import java.util.ArrayList;
import java.util.Random;


public class Estudiante {
    private String nombre;
    private Salon salonClase;
    private boolean atencion;
    private ArrayList<String> actividades;
    private String actividadActual;

    public void hacerAlgo(){
        Random actividad = new Random();
        this.setActividadActual("hol");
        this.distraerse(0);
    }
    
    public void distraerse(int actividad){
        if (actividad/2==0){
            this.setAtencion(false);
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

    public boolean isAtencion() {
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
    
}
