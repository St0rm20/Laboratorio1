package programacion3.laboratorio1.Clases.Herramientas;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Alerta {

    // Muestra un diálogo de confirmación con el mensaje especificado y devuelve true si el usuario hace clic en OK
    public static boolean mostrarMensajeConfirmacion(String message){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación de acción");
        alert.setContentText(message);
        Optional<ButtonType> action = alert.showAndWait();
        return action.isPresent() && action.get() == ButtonType.OK;
    }
    // Muestra una advertencia con el contenido especificado
    public static void mostrarAdvertencia(String contenido){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setTitle("Advertencia");
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    public static void mostrarInformacion(String contenido){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Informacion");
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    public static void mostrarError(String contenido){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText(contenido);
        alert.showAndWait();
    }
    // Muestra una alerta con el título, encabezado, contenido y tipo de alerta especificados
    public static void mostrarAlerta(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
