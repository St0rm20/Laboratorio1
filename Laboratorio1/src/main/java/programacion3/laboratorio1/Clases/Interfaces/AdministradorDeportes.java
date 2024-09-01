package programacion3.laboratorio1.Clases.Interfaces;

import programacion3.laboratorio1.Clases.Club.Deporte;
import programacion3.laboratorio1.Clases.enums.Dificultad;

public interface AdministradorDeportes {

    public void aniadirDeporte(String nombre, String descripcion, Dificultad dificultad);
    public void eliminarDeporte(Deporte deporte);
}
