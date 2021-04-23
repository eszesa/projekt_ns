package hu.novaservices.view;

import hu.novaservices.EmployeeController;
import hu.novaservices.domain.Employee;
import hu.novaservices.util.HibernateUtil;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EmployeeAddDialog extends Stage {

    EmployeeController controller;

    public EmployeeAddDialog(EmployeeController controller) {
        this.controller = controller;
        construct();
    }

    private void construct() {
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));

        TextField nameTF = new TextField();
        TextField emailTF = new TextField();
        TextField idCardTF = new TextField();
        TextField addressTF = new TextField();
        TextField phoneTF = new TextField();
        TextField sexTF = new TextField();
        TextField birthPlaceTF = new TextField();
        DatePicker birthDateDP = new DatePicker();
        TextField secondaryNameTF = new TextField();
        TextField secondaryPhoneTF = new TextField();
        TextField statusTF = new TextField();
        TextField statusTypeTF = new TextField();
        TextField taskClassTF = new TextField();
        TextField hourlyRateTF = new TextField();
        TextField positionTF = new TextField();
        TextField monthlyHoursTF = new TextField();

        gridPane.add(new Text("Teljes név*:"), 0, 0);
        gridPane.add(nameTF, 1, 0);
        gridPane.add(new Text("E-mail cím*:"), 0, 1);
        gridPane.add(emailTF, 1, 1);
        gridPane.add(new Text("Személyi igazolvány szám"), 0, 2);
        gridPane.add(idCardTF, 1, 2);
        gridPane.add(new Text("Cím"), 0, 3);
        gridPane.add(addressTF, 1, 3);
        gridPane.add(new Text("Telefonszám:"), 0, 4);
        gridPane.add(phoneTF, 1, 4);
        gridPane.add(new Text("Nem:"), 0, 5);
        gridPane.add(sexTF, 1, 5);
        gridPane.add(new Text("Születési hely és dátum:"), 0, 6);
        gridPane.add(birthPlaceTF, 1, 6);
        gridPane.add(birthDateDP, 2, 6);
        gridPane.add(new Text("Értesítési név és telefonszám:"), 0, 7);
        gridPane.add(secondaryNameTF, 1, 7);
        gridPane.add(secondaryPhoneTF, 2, 7);
        gridPane.add(new Text("Státusz és típus*:"), 0, 8);
        gridPane.add(statusTF, 1, 8);
        gridPane.add(statusTypeTF, 2, 8);
        gridPane.add(new Text("Feledat osztály*:"), 0, 9);
        gridPane.add(taskClassTF, 1, 9);
        gridPane.add(new Text("Óradíj*:"), 0, 10);
        gridPane.add(hourlyRateTF, 1, 10);
        gridPane.add(new Text("Pozíció:"), 0, 11);
        gridPane.add(positionTF, 1, 11);
        gridPane.add(new Text("Munkaidő alap:"), 0, 12);
        gridPane.add(monthlyHoursTF, 1, 12);


        //gombok eseménykezelés
        Button saveButton = new Button("Mentés");
        saveButton.setDefaultButton(true);
        saveButton.setOnAction(e -> {
            //kötelező mezők kitöltésének ellenőrzése mentés előtt
            if (nameTF.getText().contentEquals("")) {
                HibernateUtil.showWarning("A név megadása kötelező");
                return;
            }
            if (emailTF.getText().contentEquals("")) {
                HibernateUtil.showWarning("Az email cím megadása kötelező");
                return;
            }
            if (statusTF.getText().contentEquals("")) {
                HibernateUtil.showWarning("Az státusz megadása kötelező");
                return;
            }
            if (statusTypeTF.getText().contentEquals("")) {
                HibernateUtil.showWarning("Az státusz típus megadása kötelező");
                return;
            }
            if (taskClassTF.getText().contentEquals("")) {
                HibernateUtil.showWarning("Az feladat osztály megadása kötelező");
                return;
            }
            if (hourlyRateTF.getText().contentEquals("")) {
                HibernateUtil.showWarning("Az óradíj megadása kötelező");
                return;
            }
            //TODO EmployeeController add()
           // if (controller.add(new Employee(nameTF.getText(), emailTF.getText(), ))) {
           //     close();
            else {
                HibernateUtil.showWarning("Nem sikerült a mentés");
                return;
            }
        });

        Button cancelButton = new Button("Bezárás");
        cancelButton.setCancelButton(true);
        cancelButton.setOnAction(e -> {
            close();
        });

        FlowPane buttonPane = new FlowPane();
        buttonPane.setOrientation(Orientation.HORIZONTAL);
        buttonPane.setHgap(15);
        buttonPane.setAlignment(Pos.BOTTOM_LEFT);
        buttonPane.getChildren().addAll(saveButton, cancelButton);

        gridPane.add(buttonPane, 0, 14, 2, 1);

        Scene scene = new Scene(gridPane);
        setScene(scene);
        setTitle("NovaServices ERP - Új személy felvétele");
        show();
    }
}
