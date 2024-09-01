package programacion3.laboratorio1.Clases.Personas;

import programacion3.laboratorio1.Clases.Club.SesionEntrenamiento;
import programacion3.laboratorio1.Clases.Herramientas.Alerta;
import programacion3.laboratorio1.Clases.enums.Categoria;
import programacion3.laboratorio1.Clases.enums.Dificultad;
import programacion3.laboratorio1.Clases.enums.Estado;

import java.util.ArrayList;

public class Miembro extends Persona {

    private String dirrecionCorreo;
    private Categoria categoria;
    private ArrayList<SesionEntrenamiento> sesiones = new ArrayList<>();

    public Miembro(String nombre, String ID, String dirrecionCorreo, Categoria categoria) {
        super(nombre, ID);
        this.dirrecionCorreo = dirrecionCorreo;
        this.categoria = categoria;
    }

    public String getDirrecionCorreo() {
        return dirrecionCorreo;
    }

    public Categoria getCategoria() {
        return categoria;
    }


    public void aniadirSesion(SesionEntrenamiento sesion) {
        if (sesiones.contains(sesion)) {
            Alerta.mostrarError("La sesión ya está en la lista.");
            return;
        }
    if(sesion.getEstado().equals(Estado.PROGRAMADA)) {
        if (categoria.equals(Categoria.ADULTO)) {
            sesiones.add(sesion);
        } else if (categoria.equals(Categoria.JUVENIL)) {
            if (sesion.getDeporte().getDificultad().equals(Dificultad.BAJO) ||
                    sesion.getDeporte().getDificultad().equals(Dificultad.MEDIO)) {
                sesiones.add(sesion);
                Alerta.mostrarInformacion("Inscripción realizada con éxito");
            } else {
                Alerta.mostrarError("No puede unirse a esta sesión debido a la dificultad.");
            }
        }        }else{
            Alerta.mostrarError("La sesión ya ha sido completada.");
        }  }


}
