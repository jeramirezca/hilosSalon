package Datos;

import java.util.ArrayList;



public class Salon extends Thread {
    private int numeroSalon;
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Estudiante> estudiantesActuales;
    private Profesor profesorActual;
    private boolean disponibilidad;
    private long tiempoClase;


    public Salon(int  numero, ArrayList<Estudiante> lista, Profesor profesor, boolean disponibilidad, long tiempoClase){
        this.setNumeroSalon(numero);
        this.setDisponibilidad(disponibilidad);
        this.setEstudiantes(lista);
        this.setEstudiantesActuales(lista);
        this.setProfesorActual(profesor);
        this.setTiempoClase(tiempoClase); 
    }

    public Salon(){
        this(0, new ArrayList<Estudiante>(), new Profesor(), true, 1000 );
        
    }

    @Override
    public void run(){
            //La idea es que desde el metodo run de esta clase se llamen a los demás métodos de las clases estudiante
            //y profesor, tipo que desde este hilo se creen otros subhilos
    }

    public long getTiempoClase() {
        return tiempoClase;
    }

    public void setTiempoClase(long tiempoClase) {
        this.tiempoClase = tiempoClase;
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Profesor getProfesorActual() {
        return profesorActual;
    }

    public void setProfesorActual(Profesor profesorActual) {
        this.profesorActual = profesorActual;
    }

    public ArrayList<Estudiante> getEstudiantesActuales() {
        return estudiantesActuales;
    }

    public void setEstudiantesActuales(ArrayList<Estudiante> estudiantesActuales) {
        this.estudiantesActuales = estudiantesActuales;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public int getNumeroSalon() {
        return numeroSalon;
    }

    public void setNumeroSalon(int numeroSalon) {
        this.numeroSalon = numeroSalon;
    }

    public void salirEstudiante(Estudiante sale){
        ArrayList<Estudiante> currentList = this.getEstudiantesActuales();
        currentList.remove(sale);
        this.setEstudiantesActuales(currentList);
        
    }

    public void entrarEstudiante(Estudiante entra){
        ArrayList<Estudiante> currentList = this.getEstudiantesActuales();
        currentList.add(entra);
        this.setEstudiantesActuales(currentList);
    }

    public void entrarProfesor(Profesor entra){
       this.setProfesorActual(entra);
       //pendiente ponerle nombre al profesor
       System.out.println("Ha entrado el profesor  al salon "+ this.getNumeroSalon()+ "-------");
    }

    public void salirProfesor(Profesor sale){
        Profesor nadie = new Profesor();
        this.setProfesorActual(nadie);
        System.out.println("---------El profesor se ha ido--------");
    }

    public int imprimirEstudianteEnClase(){
        ArrayList<Estudiante> currentStudents = this.getEstudiantesActuales();
        int numero = currentStudents.size();
        return numero;
    }

    @Override
    public String toString(){
        Profesor mostrando = this.getProfesorActual();
        String informacion= " ";
        informacion += "Salon numero " + this.getNumeroSalon()
        + "\n Profesor actual " + mostrando.getNombre()+ " \n Clase" + mostrando.getMateriaDictada() 
        + "\n Numero de estudiantos "+ imprimirEstudianteEnClase();
        return informacion;
    }
    
    


    
}