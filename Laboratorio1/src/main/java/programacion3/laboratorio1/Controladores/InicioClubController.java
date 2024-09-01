package programacion3.laboratorio1.Controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import programacion3.laboratorio1.Clases.AppClub;
import programacion3.laboratorio1.Clases.Herramientas.InicializarDatos;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InicioClubController {

    static boolean iniciado = false;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text TextFieldBienvenido;

    @FXML
    private Text TextFieldEligeQueCatego;

    @FXML
    private Text TextFieldNoHacesParte;

    @FXML
    private Button ButtonAdministrador;

    @FXML
    private Button ButtonDeportista;

    @FXML
    private Button ButtonEntrenador;

    @FXML
    private Button ButtonUnirte;

    @FXML
    void OnButtonAdministrador() throws IOException {
        AppClub.setRoot("/com/programacion3/laboratorio1/ADMININICIODESESION.fxml");
    }

    @FXML
    void OnButtonDeportista() throws IOException {
        AppClub.setRoot("/com/programacion3/laboratorio1/DEPORTISTAINICIOSESION.fxml");
    }

    @FXML
    void OnButtonEntrenador() throws IOException {
        AppClub.setRoot("/com/programacion3/laboratorio1/ENTRENADORINICIOSESION.fxml");
    }

    @FXML
    void OnButtonUnirte() throws IOException {
        AppClub.setRoot("/com/programacion3/laboratorio1/UNIRTEPAGINA.fxml");
    }

    @FXML
    void initialize() {

        if(iniciado == false){
            InicializarDatos.inicializarDatos();
            iniciado = true;
        }
    }
}