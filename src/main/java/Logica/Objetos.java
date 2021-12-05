package Logica;

import Datos.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Objetos {
    
        public static ArrayList<Estudiante> copiar(ArrayList<Estudiante> original, ArrayList<Estudiante> copia){
            for(Estudiante estudiante : original){
                copia.add(estudiante);
            }
            return copia;
        }

        public static void InstanciarObjetos() {
            
                // ESTUDIANTES
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
                
                // PROFESORES
                ArrayList<String> actividades = new ArrayList<String>(
                                Arrays.asList("Calificando", "Tomando Tinto", "Leyendo", "regañar"));

                Profesor profesor1 = new Profesor("Matemáticas", "Arcenio Pecha", true,
                                actividades);

                Profesor profesor2 = new Profesor("Sociales", "Marta marcela", true,
                                actividades);

                Profesor profesor3 = new Profesor("Ingles", "Alexei Ochoa", true,
                                actividades);
                
                // SALON

                ArrayList<Estudiante> estSalon1 = new ArrayList<Estudiante>(

                                Arrays.asList(estudiante1, estudiante2, estudiante3, estudiante4, estudiante5));

                ArrayList<Estudiante> estSalon2 = new ArrayList<Estudiante>(
                                Arrays.asList(estudiante6, estudiante7, estudiante8, estudiante9, estudiante10));
                
                ArrayList<Estudiante> copiaest1 = copiar(estSalon1, new ArrayList<Estudiante>() );
                
                ArrayList<Estudiante> copiaest2 = copiar(estSalon2,new ArrayList<Estudiante>() );
                
                ArrayList<Profesor> profesores = new ArrayList<Profesor>(
                                Arrays.asList(profesor1, profesor2, profesor3));

                Salon salon1 = new Salon(1, estSalon1, copiaest1, true, 12000);
                Salon salon2 = new Salon(2, estSalon2, copiaest2, true, 12000);

                salon1.setProfesores(profesores);
                salon2.setProfesores(profesores);

                profesor1.setSalonClases(salon1);
                profesor2.setSalonClases(salon2);
                salon1.setProfesorActual(profesor1);
                salon2.setProfesorActual(profesor2);
                

                for (int i = 0; i < estSalon1.size(); i++) {
                        estSalon1.get(i).setSalonClase(salon1);
                }

                for (int i = 0; i < estSalon2.size(); i++) {
                        estSalon2.get(i).setSalonClase(salon2);
                }
                salon1.start();
                salon2.start();
        }

}
