package programacion3.laboratorio1.Controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import programacion3.laboratorio1.Clases.AppClub;
import programacion3.laboratorio1.Clases.Club.Club;
import programacion3.laboratorio1.Clases.Herramientas.Alerta;
import programacion3.laboratorio1.Clases.Herramientas.UsuarioActual;
import programacion3.laboratorio1.Clases.Personas.Administrador;
import programacion3.laboratorio1.Clases.Personas.Entrenador;

import java.io.IOException;
import java.util.Objects;


public class InicioSesionAdministradorController {

        Club club = Club.getInstance();
        @FXML
        private Text TextFieldAdministrador;

        @FXML
        private Text TextFieldId;

        @FXML
        private Text TextFieldIngresarDatos;

        @FXML
        private Text TextFieldNombre;

        @FXML
        private PasswordField getIDPassword;

        @FXML
        private TextField getTextFieldNombre;

        @FXML
        private Button ButtonAtras;

        @FXML
        private Button ButtonIngresar;

    @FXML
    void OnButtonAtras() throws IOException {
        AppClub.setRoot("/com/programacion3/laboratorio1/INICIOCLUB.fxml");
    }

    @FXML
    void OnButtonIngresar() throws IOException {
        Administrador usuarioEncontrado = confirmarUsuario();
        if(usuarioEncontrado != null){
            UsuarioActual.setUsuarioActual(usuarioEncontrado);
            AppClub.setRoot("/com/programacion3/laboratorio1/ADMINISTRADORPAGINA.fxml");
        }
    }

    private Administrador confirmarUsuario() {
        String nombre = getTextFieldNombre.getText();
        String id = getIDPassword.getText();

        for (Administrador administrador : club.getAdministradores()) {
            if (Objects.equals(administrador.getNombre(), nombre) && Objects.equals(administrador.getID(), id)) {
                return administrador;
            }
        }

        // Ningún usuario coincide.
        Alerta.mostrarError("Nombre de usuario o ID incorrectos.");
        return null;
    }


}
