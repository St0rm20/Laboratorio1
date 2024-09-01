package programacion3.laboratorio1.Clases.Personas;

import programacion3.laboratorio1.Clases.Club.SesionEntrenamiento;
import programacion3.laboratorio1.Clases.Herramientas.Alerta;
import programacion3.laboratorio1.Clases.Interfaces.AdministradorSesionesEntrenador;

import java.util.ArrayList;

public class Entrenador extends Persona implements AdministradorSesionesEntrenador {
    private String especialidad;
    private ArrayList<SesionEntrenamiento> sesiones;

    public Entrenador(String nombre, String ID, String especialidad) {
        super(nombre, ID);
        this.especialidad = especialidad;
        this.sesiones = new ArrayList<>();
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public ArrayList<SesionEntrenamiento> getSesiones() {
        return sesiones;
    }

    @Override
    public void aniadirEntrenamiento(SesionEntrenamiento sesion) {
        sesiones.add(sesion);
    }

    public void validarExiste(SesionEntrenamiento sesion){
        if(!sesiones.contains(sesion)){
            Alerta.mostrarError("La sesion no existe");
        }
    }

    @Override
    public void eliminarEntrenamiento(SesionEntrenamiento sesion) {
        validarExiste(sesion);
        sesiones.remove(sesion);
    }

    @Override
    public String toString() {
        return getNombre();
    }
}
