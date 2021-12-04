
package Logica;

import Datos.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main extends Thread {
    public static void InstanciarObjetos(){
        Estudiante estudiante1 = new Estudiante("Juan Manuel");
        Estudiante estudiante2 = new Estudiante("Simón Ramos");
        Estudiante estudiante3 = new Estudiante("Jefferson Ramírez");
        Estudiante estudiante4 = new Estudiante("Jorge Cubides ");
        Estudiante estudiante5 = new Estudiante("Marcela Orozco");
        Estudiante estudiante6 = new Estudiante("Carlos Bodoque");
        Estudiante estudiante7 = new Estudiante("Joaquin Torres");
        Estudiante estudiante8 = new Estudiante("Arcenio Blanco");
        Estudiante estudiante9 = new Estudiante("Juana Gonzalez");
        Estudiante estudiante10 = new Estudiante("Camila Natalia Pinzón");
        
        ArrayList<String> actividades = new ArrayList<String>(Arrays.asList("Calificando","Tomando Tinto", "Leyendo","regañar"));
        
        Profesor profesor1 = new Profesor("Matemáticas", "Arcenio Pecha", true,
            actividades);
        Profesor profesor2 = new Profesor("Sociales", "Marta marcela", true,
            actividades);
        
        Profesor profe3 = new Profesor("Ciencias Naturales" ,"Alexei Ochoa", true,
            actividades);
        
        ArrayList<Estudiante> estSalon1 = new ArrayList<Estudiante>(
        Arrays.asList(estudiante1,estudiante2,estudiante3,estudiante4,estudiante5));
        
        ArrayList<Estudiante> estSalon2 = new ArrayList<Estudiante>(
        Arrays.asList(estudiante6,estudiante7,estudiante8,estudiante9,estudiante10));
        
        Salon salon1 = new Salon(1, estSalon1, true, 12000);
        Salon salon2 = new Salon(2,estSalon2, true, 12000);

        profesor1.setSalonClases(salon1);
        profesor2.setSalonClases(salon2);
        salon1.setProfesorActual(profesor1);
        salon2.setProfesorActual(profesor2);
        System.out.println("Hola mundo");
        salon1.start();
        salon2.start();
    }

    public static void main(String[] arqs) {
        InstanciarObjetos();
    }

}
