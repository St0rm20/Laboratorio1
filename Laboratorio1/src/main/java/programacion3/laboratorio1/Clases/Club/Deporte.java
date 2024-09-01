package programacion3.laboratorio1.Clases.Club;

import programacion3.laboratorio1.Clases.Herramientas.Alerta;
import programacion3.laboratorio1.Clases.Personas.Entrenador;
import programacion3.laboratorio1.Clases.Personas.Miembro;
import programacion3.laboratorio1.Clases.enums.Dificultad;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Predicate;

public class Deporte {
    private String nombre;
    private String descripcion;
    private Dificultad dificultad;
    private ArrayList<Entrenador> entrenadores;
    private ArrayList<Miembro> miembros;

    public Deporte(String nombre, String descripcion, Dificultad dificultad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.dificultad = dificultad;
        this.entrenadores = new ArrayList<>();
        this.miembros = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }



    public ArrayList<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public ArrayList<Miembro> getMiembros() {
        return miembros;
    }





    public Optional<Entrenador> buscarEntrenadorPorNombre(String nombre){
        Predicate<Entrenador> condicion = entrenador->entrenador.getNombre().equals(nombre);
        return entrenadores.stream().filter(condicion).findAny();
    }

    @Override
    public String toString() {
        return nombre ;
    }
}
