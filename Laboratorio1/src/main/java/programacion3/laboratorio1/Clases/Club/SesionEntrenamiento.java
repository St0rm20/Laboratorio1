package programacion3.laboratorio1.Clases.Club;

import programacion3.laboratorio1.Clases.Herramientas.Alerta;
import programacion3.laboratorio1.Clases.Personas.Entrenador;
import programacion3.laboratorio1.Clases.enums.Estado;

import java.time.LocalDate;

public class SesionEntrenamiento {
    private LocalDate fecha;
    private int duracion;
    private Deporte deporte;
    private Entrenador entrenador;
    private Estado estado;

    public SesionEntrenamiento(LocalDate fecha, int duracion, Deporte deporte, Entrenador entrenador) {
        this.fecha = fecha;
        this.duracion = duracion;
        this.deporte = deporte;
        this.entrenador = entrenador;
        actualizarEstado();

    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getDuracion() {
        return duracion;
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public Estado getEstado() {
        return estado;
    }


    public void gestionarFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void gestionarDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void gestionarDeporte(Deporte deporte) {
        this.deporte = deporte;
    }

    public void gestionarEntrenador(Entrenador entrenador) {

        if(entrenador.getEspecialidad().equals(deporte.getNombre())){
            this.entrenador.eliminarEntrenamiento(this);
            entrenador.aniadirEntrenamiento(this);
            this.entrenador = entrenador;
        }else {
            Alerta.mostrarError("El entrenador no tiene la especialidad del deporte");
        }

    }

    public void actualizarEstado() {
        if(fecha.equals(LocalDate.now())||fecha.isAfter(LocalDate.now())) {
            this.estado = Estado.PROGRAMADA;
        }else{
                this.estado = Estado.COMPLETADA;
        }
    }

}
