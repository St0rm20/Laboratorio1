package programacion3.laboratorio1.Clases.Club;

import programacion3.laboratorio1.Clases.Herramientas.Alerta;
import programacion3.laboratorio1.Clases.Personas.Administrador;
import programacion3.laboratorio1.Clases.Personas.Entrenador;
import programacion3.laboratorio1.Clases.Personas.Miembro;
import programacion3.laboratorio1.Clases.enums.Categoria;
import programacion3.laboratorio1.Clases.enums.Dificultad;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Predicate;

public class Club{

    private static Club instance;

    private String nombre;
    private String dirrecion;
    private ArrayList<Deporte> deportes;
    private ArrayList<Entrenador> entrenadores;
    private ArrayList<Miembro> miembros;
    private ArrayList<Administrador> administradores;
    private ArrayList<SesionEntrenamiento> sesionEntrenamientos;

    private Club() {
        this.deportes = new ArrayList<>();
        this.entrenadores = new ArrayList<>();
        this.miembros = new ArrayList<>();
        this.administradores = new ArrayList<>();
        this.sesionEntrenamientos = new ArrayList<>();
    }

    public Club(String nombre, String direccion) {
        this.nombre = nombre;
        this.dirrecion = direccion;
        this.deportes = new ArrayList<>();
        this.entrenadores = new ArrayList<>();
        this.miembros = new ArrayList<>();
        this.administradores = new ArrayList<>();
        this.sesionEntrenamientos = new ArrayList<>();
    }


    public static Club getInstance() {
        if (instance == null) {
            instance = new Club();
        }
        return instance;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDirrecion() {
        return dirrecion;
    }
    public ArrayList<Deporte> getDeportes() {
        return deportes;
    }

    public ArrayList<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public ArrayList<Miembro> getMiembros() {
        return miembros;
    }

    public ArrayList<Administrador> getAdministradores() {
        return administradores;
    }

    public ArrayList<SesionEntrenamiento> getSesionEntrenamientos() {
        return sesionEntrenamientos;
    }


    /**
    * @param fecha Fecha de la sesion
    * @param duracion Duracion de la sesion
    * @param deporte Nombre del deporte
    * @param entrenador Nombre del entrenador
    * Agrega una sesion de entrenamiento al club
     */
    public void aniadirSesion(LocalDate fecha, int duracion, String deporte, String entrenador) {
        Deporte deporte1 = buscarDeporte(deporte);
        Entrenador entrenador1 = buscarEntrenador(entrenador);
        if(deporte1!= null||entrenador1 != null) {
            if(entrenador1.getEspecialidad().equals(deporte)){
                SesionEntrenamiento sesionEntrenamiento = new SesionEntrenamiento(fecha, duracion, deporte1, entrenador1);
                sesionEntrenamientos.add(sesionEntrenamiento);
                entrenador1.aniadirEntrenamiento(sesionEntrenamiento);
            }else{
                Alerta.mostrarError("El entrenador no tiene la especialidad del deporte");
            }

        }else{
            Alerta.mostrarError("El deporte o el entrenador no existen");
        }

    }

    /**
     * @param fecha Fecha de la sesion
     * @param duracion Duracion de la sesion
     * @param deporte Nombre del deporte
     * @param entrenador Nombre del entrenador
     * Agrega una sesion de entrenamiento al club
     */
    public void aniadirSesion(LocalDate fecha, int duracion, Deporte deporte, Entrenador entrenador) {
        if(entrenador.getEspecialidad().equals(deporte.getNombre())){
            SesionEntrenamiento sesionEntrenamiento = new SesionEntrenamiento(fecha, duracion, deporte, entrenador);
            sesionEntrenamientos.add(sesionEntrenamiento);
            entrenador.aniadirEntrenamiento(sesionEntrenamiento);
        }else{
            Alerta.mostrarError("El entrenador no tiene la especialidad del deporte");
        }

    }


    public void aniadirSesion(SesionEntrenamiento sesionEntrenamiento) {
        sesionEntrenamientos.add(sesionEntrenamiento);
    }

    /**
    * @param nombre Nombre del deporte
    * Busca un deporte según del nombre de este
     */
    public Deporte buscarDeporte(String nombre) {
        for (Deporte deporte : deportes) {
            if (deporte.getNombre().equals(nombre)) {
                return deporte;
            }
        }
        return null;
    }

    /**
     * @param nombre Nombre del entrenador
     * Busca un entrenador según del nombre de este
     */
    public Entrenador buscarEntrenador(String nombre) {
        for (Entrenador entrenador : entrenadores) {
            if (entrenador.getNombre().equals(nombre)) {
                return entrenador;
            }
        }
        return null;
    }


    public void eliminarSesion(SesionEntrenamiento sesionEntrenamiento) {
        sesionEntrenamientos.remove(sesionEntrenamiento);
    }

    /**
    * @param nombre Nombre del deporte
    * @param descripcion Descripcion del deporte
    * @param dificultad Dificultad del deporte
    * Agrega un deporte al club
     */
    public void aniadirDeporte(String nombre, String descripcion, Dificultad dificultad) {
        Deporte deporte = new Deporte(nombre, descripcion, dificultad);
        boolean existeDeporte = validarDeporteExiste(deporte);
        if (!existeDeporte) {
            deportes.add(deporte);
        }
    }

    public void aniadirDeporte(Deporte deporte) {
        boolean existeDeporte = validarDeporteExiste(deporte);
        if (!existeDeporte) {
            deportes.add(deporte);
        }
    }

    /**
     * @param nombre Nombre del entrenador
     * @param ID ID del entrenador
     * @param especialidad Especialidad del entrenador
     * Agrega un entrenador al club
     */
    public void aniadirEntrenador(String nombre, String ID, String especialidad) {
        Entrenador entrenador = new Entrenador(nombre, ID, especialidad);
        boolean existeEntrenador = validarEntrenadorExiste(entrenador);
        if (!existeEntrenador) {
            entrenadores.add(entrenador);
        }
    }


    /**
     * @param nombre Nombre del miembro
     * @param ID ID del miembro
     * @param dirrecionCorreo Correo del miembro
     * @param categoria Categoria del miembro
     * Agrega un miembro al club
     */

    public void aniadirMiembro(String nombre, String ID, String dirrecionCorreo, Categoria categoria) {
        Miembro miembro = new Miembro(nombre, ID, dirrecionCorreo, categoria);
        boolean existeMiembro = validarMiembroExiste(miembro);
        if (!existeMiembro) {
            miembros.add(miembro);
        }
    }

    /**
     * @param nombre Nombre del administrador
     * @param ID ID del administrador
     * Agrega un administrador al club
     */
    public void aniadirAdministrador(String nombre, String ID) {
        Administrador administrador = new Administrador(nombre, ID);
        boolean existeAdministrador = validarAdministradorExiste(administrador);
        if (!existeAdministrador) {
            administradores.add(administrador);
        }
    }



    public void eliminarDeporte(Deporte deporte) {
        deportes.remove(deporte);
    }

    public void eliminarEntrenador(Entrenador entrenador) {
        entrenadores.remove(entrenador);
    }

    public void eliminarMiembro(Miembro miembro) {
        miembros.remove(miembro);
    }

    public void eliminarAdministrador(Administrador administrador) {
        administradores.remove(administrador);
    }


    public boolean validarDeporteExiste(Deporte deporte) {
        boolean existeDeporte = buscarDeportePorNombre(deporte.getNombre()).isPresent();
        if (existeDeporte) {
            Alerta.mostrarError("El deporte ya existe");
            return true;
        } else {
            return false;
        }
    }

    public boolean validarEntrenadorExiste(Entrenador entrenador) {
        boolean existeEntrenador = buscarEntrenadorPorID(entrenador.getID()).isPresent();
        if (existeEntrenador) {
            Alerta.mostrarError("El entrenador ya existe");
            return true;
        } else {
            return false;
        }
    }

    public boolean validarMiembroExiste(Miembro miembro) {
        boolean existeMiembro = buscarMiembroPorID(miembro.getID()).isPresent();
        if (existeMiembro) {
            Alerta.mostrarError("El miembro ya existe");
            return true;
        } else {
            return false;
        }
    }

    public boolean validarAdministradorExiste(Administrador administrador) {
        boolean existeAdministrador = buscarAdministradorPorID(administrador.getID()).isPresent();
        if (existeAdministrador) {
            Alerta.mostrarError("El administrador ya existe");
            return true;
        } else {
            return false;
        }
    }


    public Optional<Deporte> buscarDeportePorNombre(String nombre) {
        Predicate<Deporte> condicion = deporte -> deporte.getNombre().equals(nombre);
        return deportes.stream().filter(condicion).findAny();
    }

    public Optional<Entrenador> buscarEntrenadorPorID(String id) {
        Predicate<Entrenador> condicion = entrenador -> entrenador.getID().equals(id);
        return entrenadores.stream().filter(condicion).findAny();
    }

    public Optional<Miembro> buscarMiembroPorID(String id) {
        Predicate<Miembro> condicion = miembro -> miembro.getID().equals(id);
        return miembros.stream().filter(condicion).findAny();
    }

    public Optional<Administrador> buscarAdministradorPorID(String id) {
        Predicate<Administrador> condicion = administrador -> administrador.getID().equals(id);
        return administradores.stream().filter(condicion).findAny();
    }


}
