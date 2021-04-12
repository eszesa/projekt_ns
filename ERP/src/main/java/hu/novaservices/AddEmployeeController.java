package hu.novaservices;

import javafx.fxml.FXML;

import java.io.IOException;

public class AddEmployeeController {
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
