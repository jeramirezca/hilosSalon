
package Datos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Profesor {
    private String materiaDictada;
    private String nombre;
    private boolean DictaClase;
    private Salon salonClases;
    private ArrayList<String> Actividades;

    // GET Y SET DE LOS ATRIBUTOS
    public String getMateriaDictada() {
        return this.materiaDictada;
    }

    public void setMateriaDictada(String materia) {
        this.materiaDictada = materia;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getDictaClase() {
        return this.DictaClase;
    }

    public void setDictaClase(boolean bandera) {
        this.DictaClase = bandera;
    }

    public Salon getSalonClases() {
        return this.salonClases;
    }

    public void setSalonClases(Salon salon) {
        this.salonClases = salon;
    }

    public ArrayList<String> getActividades() {
        return this.Actividades;
    }

    public void setActividades(ArrayList<String> actividades) {
        this.Actividades = actividades;
    }

    // METODOS DE LA CLASE

    public void Reganiar() {
        // Salon salonClase = getSalonClases();
        // ArrayList<Estudiante> estudiantes = salonClase.getEstudiantesActuales();
        System.out.println(this.nombre + ": PONGAN ATENCIÓN !!!");
    }

    public boolean Encontrar(Estudiante elemento, ArrayList<Estudiante> lista) {

        int i = 0;
        int n = lista.size();
        while (i < n && (elemento != lista.get(i))) {
            i++;
        }

        return i < n;
    }

    public void LlamarLista(ArrayList<Estudiante> estudiantes) {
        Salon salonClase = getSalonClases();

        ArrayList<Estudiante> estudiantesSalon = salonClase.getEstudiantesActuales();
        HashMap<Estudiante, Boolean> listaClase = new HashMap<Estudiante, Boolean>();
        System.out.println(
                "El profesor " + this.getNombre() + " Esta llamando lista en clase de " + this.getMateriaDictada());
        for (Estudiante estudiante : estudiantes) {
            if (Encontrar(estudiante, estudiantesSalon)) {
                listaClase.put(estudiante, true);
                System.out.println("El estudiante " + estudiante.getNombre() + " Esta en el salon "+ this.getSalonClases().getNumeroSalon());
            } else {
                listaClase.put(estudiante, false);
                System.out.println("El estudiante " + estudiante.getNombre() + " Esta en el salon "+ this.getSalonClases().getNumeroSalon());
            }
        }

        // IMPRIMIR LLAMAR LISTA
    }

    public void Dictando(int indice) {
        if (indice % 2 == 0) {
            setDictaClase(true);
        } else {
            setDictaClase(false);
        }
    }

    public String HacerAlgo() {
        ArrayList<String> actividades = getActividades();
        int n = actividades.size();

        Random randomGenerator = new Random();
        int indice = randomGenerator.nextInt(n - 1);

        Dictando(indice);

        return actividades.get(indice);
    }
    // CONSTRUCTORES

    public Profesor(String materia, String nombre, boolean dictar,
            ArrayList<String> actividades) {
        this.setMateriaDictada(materia);
        this.setNombre(nombre);
        this.setDictaClase(dictar);
        // this.setSalonClases(new Salon());
        this.setActividades(actividades);
    }

    public Profesor() {
        this("Ninguna", "Desconocido", false, new ArrayList<String>());
    }

    // METODO toString

    @Override

    public String toString() {
        String cadena = "Profesor :" + nombre + " Materia Dictada: " + materiaDictada
                // + " en el salon: " + this.salonClases.getNumeroSalon() + "¿Esta dictando clase? "
                + DictaClase + "Actividad que hace : " // + HacerAlgo;
        ;
        return cadena;
    }

}
