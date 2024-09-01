package programacion3.laboratorio1.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import programacion3.laboratorio1.Clases.AppClub;
import programacion3.laboratorio1.Clases.Club.Club;
import programacion3.laboratorio1.Clases.Herramientas.Alerta;
import programacion3.laboratorio1.Clases.enums.Categoria;

import java.io.IOException;
import java.util.Optional;

public class UnirtePaginaController {
    Club club = Club.getInstance();
    @FXML
    private Button ButtonAtras;

    @FXML
    private Button ButtonUnirte;

    @FXML
    private Text TextFieldID;

    @FXML
    private Text TextFieldNombre;

    @FXML
    private TextField getNombre;

    @FXML
    private PasswordField getTextID;

    @FXML
    private ChoiceBox<String> ChoiceBoxTipo;

    @FXML
    void initialize() {
        // Inicializar ChoiceBox con las opciones
        ChoiceBoxTipo.getItems().addAll("Administrador", "Miembro", "Entrenador");
    }

    @FXML
    void OnButtonUnirte(ActionEvent event) {

        String selectedTipo = ChoiceBoxTipo.getValue();

        // Imprimir el tipo correspondiente
        if (selectedTipo != null) {
            if (selectedTipo.equals("Administrador")) {
                crearAdministrador();
            } else if (selectedTipo.equals("Miembro")) {
               crearMiembro();
            } else if (selectedTipo.equals("Entrenador")) {
                crearEntrenador();
            }

        } else {
            Alerta.mostrarError("No se ha seleccionado ningún tipo.");
        }

    }

    private void crearAdministrador() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Clave de Seguridad");
        dialog.setHeaderText(null);
        dialog.setContentText("Ingrese la clave de seguridad:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            String clave = result.get();
            if ("1234".equals(clave)) {
                club.aniadirAdministrador(getNombre.getText(), getTextID.getText());

                Alerta.mostrarInformacion("Te has unido al club con éxito");
            }else{
                Alerta.mostrarError("Clave incorrecta");
            }
        } else {
            Alerta.mostrarError("No se ha ingresado ninguna clave.");
        }
    }

    private void crearMiembro() {
        // Crear el primer diálogo para el correo electrónico
        TextInputDialog emailDialog = new TextInputDialog();
        emailDialog.setTitle("Completar datos");
        emailDialog.setHeaderText(null);
        emailDialog.setContentText("Ingrese su correo electrónico:");

        Optional<String> emailResult = emailDialog.showAndWait();
        if (emailResult.isPresent()) {
            String email = emailResult.get();

            // Limpiar el campo de texto del diálogo y crear el segundo diálogo para la categoría
            TextInputDialog categoriaDialog = new TextInputDialog();
            categoriaDialog.setTitle("Completar datos");
            categoriaDialog.setHeaderText(null);
            categoriaDialog.setContentText("Ingrese su categoría (Juvenil o Adulto):");

            Optional<String> categoriaResult = categoriaDialog.showAndWait();
            if (categoriaResult.isPresent()) {
                String categoria = categoriaResult.get();
                if (categoria.equalsIgnoreCase("Juvenil")) {
                    club.aniadirMiembro(getNombre.getText(), getTextID.getText(), email, Categoria.JUVENIL);
                    Alerta.mostrarInformacion("Te has unido al club con éxito como Juvenil");
                } else if (categoria.equalsIgnoreCase("Adulto")) {
                    club.aniadirMiembro(getNombre.getText(), getTextID.getText(), email, Categoria.ADULTO);
                    Alerta.mostrarInformacion("Te has unido al club con éxito como Adulto");
                } else {
                    Alerta.mostrarError("Categoría no válida");
                }
            } else {
                Alerta.mostrarError("No se ha ingresado ninguna categoría.");
            }
        } else {
            Alerta.mostrarError("No se ha ingresado ningún correo electrónico.");
        }
    }


    private void crearEntrenador() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Completar datos");
        dialog.setHeaderText(null);
        dialog.setContentText("Ingrese su especialidad:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            String especialidad = result.get();
            club.aniadirEntrenador(getNombre.getText(), getTextID.getText(), especialidad);
            Alerta.mostrarInformacion("Te has unido al club con éxito");
        } else {
            Alerta.mostrarError("No se ha ingresado ninguna especialidad.");
        }
    }


    @FXML
    void OnNombre(MouseEvent event) {
        // Puedes agregar la lógica para manejar el evento aquí
    }

    @FXML
    void OnTextID(ActionEvent event) {
        // Puedes agregar la lógica para manejar el evento aquí
    }

    @FXML
    void OnButtonAtras() throws IOException {
        AppClub.setRoot("/com/programacion3/laboratorio1/INICIOCLUB.fxml");
    }
}
