module programacion3.laboratorio1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens programacion3.laboratorio1.Clases to javafx.fxml;
    opens programacion3.laboratorio1.Controladores to javafx.fxml;

    exports programacion3.laboratorio1.Clases;
    exports programacion3.laboratorio1.Controladores;
}