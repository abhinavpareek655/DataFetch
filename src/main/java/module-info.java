module com.example.data2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.data2 to javafx.fxml;
    exports com.example.data2;
}