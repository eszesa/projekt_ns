package hu.novaservices.view;

import hu.novaservices.controller.EmployeeController;
import hu.novaservices.controller.ProjectController;
import hu.novaservices.util.HibernateUtil;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ProjectAddDialog extends Stage {

    ProjectController controller = new ProjectController();

    public ProjectAddDialog(ProjectController controller) {
        this.controller = controller;
        construct();
    }

    private void construct() {
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));

        TextField codeTF = new TextField();
        TextField nameTF = new TextField();
        DatePicker startDP = new DatePicker();
        DatePicker endDP = new DatePicker();
        final ComboBox statusCB = new ComboBox();
        TextField incomeTF = new TextField();
        //todo fővállalkozó drop down list cégek
        //final ComboBox contructorCB = new ComboBox();
        TextField contructorTF = new TextField();
        TextField projectmanagerTF = new TextField();

        statusCB.getItems().addAll(
                "aktív",
                "lezárt"
        );


        gridPane.add(new Text("Kód:"), 0, 0);
        gridPane.add(codeTF, 1, 0);
        gridPane.add(new Text("Név:"), 0, 1);
        gridPane.add(nameTF, 1, 1);
        gridPane.add(new Text("Projekt kezdete és vége:"), 0, 2);
        gridPane.add(startDP, 1, 2);
        gridPane.add(endDP, 2, 2);
        gridPane.add(new Text("Állapot:"), 0, 3);
        gridPane.add(statusCB, 1, 3);
        gridPane.add(new Text("Bevétel:"), 0, 4);
        gridPane.add(incomeTF, 1, 4);
        gridPane.add(new Text("Fővállalkozó:"), 0, 5);
        gridPane.add(contructorTF, 1, 5);
        gridPane.add(new Text("Projektvezető:"), 0, 6);
        gridPane.add(projectmanagerTF, 1, 6);



        //gombok eseménykezelés
        Button saveButton = new Button("Mentés");
        saveButton.setDefaultButton(true);
        saveButton.setOnAction(e -> {
            //TODO ProjectController add()
            // if (controller.add(new Employee(nameTF.getText(), emailTF.getText(), ))) {
            //     close();
            {
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

        gridPane.add(buttonPane, 0, 8, 2, 1);

        Scene scene = new Scene(gridPane, 450, 400);
        setScene(scene);
        setTitle("NovaServices ERP - Új projekt felvétele");
        show();
    }
}
