module com.example.p0_new {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.StringOrder to javafx.fxml;
    exports com.example.StringOrder;
}