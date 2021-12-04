package Datos;

import java.util.ArrayList;
import java.util.Random;

public class Salon extends Thread {
    private int numeroSalon;
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Estudiante> estudiantesActuales;
    private ArrayList<Profesor> profesores;
    private Profesor profesorActual;
    private boolean disponibilidad;

    public Salon(int numero, ArrayList<Estudiante> lista, boolean disponibilidad, long tiempoClase) {
        this.setNumeroSalon(numero);
        this.setDisponibilidad(disponibilidad);
        this.setEstudiantes(lista);
        this.setEstudiantesActuales(lista);
        // this.setProfesorActual(profesor);

    }

    public Salon() {
        this(0, new ArrayList<Estudiante>(), true, 1000);

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

    public ArrayList<Profesor> getProfesores() {
        return this.profesores;
    }

    public void setProfesores(ArrayList<Profesor> profesores) {
        this.profesores = profesores;
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

    public void salirEstudiante(Estudiante sale) {
        ArrayList<Estudiante> currentList = this.getEstudiantesActuales();
        currentList.remove(sale);
        this.setEstudiantesActuales(currentList);
        System.out.println("El estudiante "+ sale.getNombre()+" salio de la clase "+ sale.getSalonClase());

    }

    public void entrarEstudiante() {
        ArrayList<Estudiante> realList = this.getEstudiantes();
        ArrayList<Estudiante> currentList = this.getEstudiantesActuales();
        for(Estudiante estudianteFaltante: realList){
            if(currentList.contains(estudianteFaltante)== false){
                currentList.add(estudianteFaltante);
                this.setEstudiantesActuales(currentList);
                System.out.println("El estudiante "+ estudianteFaltante.getNombre()+" volvio a la clase "+ estudianteFaltante.getSalonClase());
            }
            
        }
        
    }
    
     // public void entrarProfesor(Profesor entra) {
     // this.setProfesorActual(entra);
     // pendiente ponerle nombre al profesor
     //System.out.println("Ha entrado el profesor "+
     // this.getProfesorActual()+"  al salon " + this.getNumeroSalon() + "-------");
      //}
     

    public void cambioProfesor() {
        System.out.println("---------El profesor " + this.getProfesorActual().getNombre() + " se ha ido--------");
        Profesor profesorNuevo = profesores.get(numeroRandom(profesores.size()));
        profesorNuevo.setSalonClases(this);
        this.setProfesorActual(profesorNuevo);
        
    }

    public int imprimirEstudianteEnClase() {
        ArrayList<Estudiante> currentStudents = this.getEstudiantesActuales();
        int numero = currentStudents.size();
        return numero;
    }

    

    public int numeroRandom(int tamanio) {
        Random randomGenerate = new Random();
        int num = randomGenerate.nextInt(tamanio);
        return num;
    }

    public void esperar(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        Profesor mostrando = this.getProfesorActual();
        String informacion = " ";
        informacion += "Salon numero " + this.getNumeroSalon()
                + "\n Profesor actual " + mostrando.getNombre() + " \n Clase: " + mostrando.getMateriaDictada()
                + "\n Numero de estudiantes " + imprimirEstudianteEnClase();
        return informacion;
    }

    @Override
    public void run() {
        System.out.println("BIENVENID@ A LA ESCUELITA DE DOÑA RITA");
        int cantidadClases = 3;
        int horaDia = 8;
        while (cantidadClases > 0) {
            System.out.println("-------------");
            System.out.println(this.toString());
            System.out.println("-------------");
            System.out.println("La clase de " + this.getProfesorActual().getMateriaDictada() + " comenzó en el salon "
                    + this.getNumeroSalon() + " a las " + horaDia + " horas");
            esperar();
            for (int u = 0; u < 2; u++) {
                if(u>0) entrarEstudiante();

                System.out.println("----------------------------------------------------------------------------------------------") ;
                System.out.println("Son las " + horaDia + " horas y Hay " + this.getEstudiantesActuales().size()+ " estudiantes en clase de " + this.getProfesorActual().getMateriaDictada());
                esperar() ;
                int estudiantesHay = this.estudiantesActuales.size();
                //System.out.println(estudiantesHay);
                Estudiante estudiante = this.estudiantesActuales.get(estudiantesHay-1);
                Estudiante estudiante2 = this.estudiantesActuales.get(estudiantesHay-1);
                estudiante.hacerAlgo();

                if(this.estudiantesActuales.size()>2)salirEstudiante(estudiante2);
                
                esperar();
                Profesor pecha = this.getProfesorActual();
                pecha.HacerAlgo();
               esperar();
                if (estudiante.getAtencion() == false) {
                    pecha.Reganiar();
                    esperar();
                }
                if (u == 0) {
                    pecha.LlamarLista(this.getEstudiantesActuales());
                    esperar();
                }
                horaDia++;
            }
            System.out.println("------------------------------------------------------------------------");
            System.out.println("La clase de " + this.getProfesorActual().getMateriaDictada() + " termino en el salón "
                    + this.getNumeroSalon() + " a las " + horaDia + " horas");
            cambioProfesor();
            esperar();
            cantidadClases--;
            
        }
    }
}