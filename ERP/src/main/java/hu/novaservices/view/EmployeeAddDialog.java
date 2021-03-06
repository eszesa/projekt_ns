package hu.novaservices.view;

import hu.novaservices.controller.EmployeeController;
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
        //TextField sexTF = new TextField();
        final ComboBox sexCB = new ComboBox();
        TextField birthPlaceTF = new TextField();
        DatePicker birthDateDP = new DatePicker();
        TextField secondaryNameTF = new TextField();
        TextField secondaryPhoneTF = new TextField();
        //TextField statusTF = new TextField();
        final ComboBox statusCB = new ComboBox();
        //TextField statusTypeTF = new TextField();
        final ComboBox statTypeCB = new ComboBox();
        //TextField taskClassTF = new TextField();
        final ComboBox taskClassCB = new ComboBox();
        TextField hourlyRateTF = new TextField();
        TextField positionTF = new TextField();
        TextField monthlyHoursTF = new TextField();
        TextField projektTF = new TextField();

        sexCB.getItems().addAll(
                "f??rfi",
                "n??"
        );

        statusCB.getItems().addAll(
                "akt??v",
                "passz??v"
        );

        statTypeCB.getItems().addAll(
                "Munkav??llal??",
                "Alv??llalkoz??",
                "Di??k"
        );

        taskClassCB.getItems().addAll(
                //'external', 'internal', 'manufacturer', 'management'
                "Bels??s",
                "K??ls??s termel??",
                "Menedzsment",
                "Termel??"
        );


        gridPane.add(new Text("Teljes n??v*:"), 0, 0);
        gridPane.add(nameTF, 1, 0);
        gridPane.add(new Text("E-mail c??m*:"), 0, 1);
        gridPane.add(emailTF, 1, 1);
        gridPane.add(new Text("Szem??lyi igazolv??ny sz??m"), 0, 2);
        gridPane.add(idCardTF, 1, 2);
        gridPane.add(new Text("C??m"), 0, 3);
        gridPane.add(addressTF, 1, 3);
        gridPane.add(new Text("Telefonsz??m:"), 0, 4);
        gridPane.add(phoneTF, 1, 4);
        gridPane.add(new Text("Nem:"), 0, 5);
        gridPane.add(sexCB, 1, 5);
        gridPane.add(new Text("Sz??let??si hely ??s d??tum:"), 0, 6);
        gridPane.add(birthPlaceTF, 1, 6);
        gridPane.add(birthDateDP, 2, 6);
        gridPane.add(new Text("??rtes??t??si n??v ??s telefonsz??m:"), 0, 7);
        gridPane.add(secondaryNameTF, 1, 7);
        gridPane.add(secondaryPhoneTF, 2, 7);
        gridPane.add(new Text("St??tusz ??s t??pus*:"), 0, 8);
        gridPane.add(statusCB, 1, 8);
        gridPane.add(statTypeCB, 2, 8);
        gridPane.add(new Text("Feledat oszt??ly*:"), 0, 9);
        gridPane.add(taskClassCB, 1, 9);
        gridPane.add(new Text("??rad??j*:"), 0, 10);
        gridPane.add(hourlyRateTF, 1, 10);
        gridPane.add(new Text("Poz??ci??:"), 0, 11);
        gridPane.add(positionTF, 1, 11);
        gridPane.add(new Text("Munkaid?? alap:"), 0, 12);
        gridPane.add(monthlyHoursTF, 1, 12);
        gridPane.add(new Text("Projekt:"), 0, 13);
        gridPane.add(projektTF, 1, 13);
        gridPane.add(new Text("* A csillaggal jel??lt mez??k kit??lt??se k??telez??"),0, 15);


        //gombok esem??nykezel??s
        Button saveButton = new Button("Ment??s");
        saveButton.setDefaultButton(true);
        saveButton.setOnAction(e -> {
            //k??telez?? mez??k kit??lt??s??nek ellen??rz??se ment??s el??tt
            if (nameTF.getText().contentEquals("")) {
                HibernateUtil.showWarning("A n??v megad??sa k??telez??");
                return;
            }
            if (emailTF.getText().contentEquals("")) {
                HibernateUtil.showWarning("Az email c??m megad??sa k??telez??");
                return;
            }
            if (statusCB.getItems().contains(null)) {
                HibernateUtil.showWarning("Az st??tusz megad??sa k??telez??");
                return;
            }
            if (statTypeCB.getItems().contains(null)) {
                HibernateUtil.showWarning("Az st??tusz t??pus megad??sa k??telez??");
                return;
            }
            if (taskClassCB.getItems().contains(null)) {
                HibernateUtil.showWarning("Az feladat oszt??ly megad??sa k??telez??");
                return;
            }
            if (hourlyRateTF.getText().contentEquals("")) {
                HibernateUtil.showWarning("Az ??rad??j megad??sa k??telez??");
                return;
            }
            //TODO EmployeeController add()
           // if (controller.add(new Employee(nameTF.getText(), emailTF.getText(), ))) {
           //     close();
            else {
                HibernateUtil.showWarning("Nem siker??lt a ment??s");
                return;
            }
        });

        Button cancelButton = new Button("Bez??r??s");
        cancelButton.setCancelButton(true);
        cancelButton.setOnAction(e -> {
            close();
        });

        FlowPane buttonPane = new FlowPane();
        buttonPane.setOrientation(Orientation.HORIZONTAL);
        buttonPane.setHgap(15);
        buttonPane.setAlignment(Pos.BOTTOM_LEFT);
        buttonPane.getChildren().addAll(saveButton, cancelButton);

        gridPane.add(buttonPane, 0, 17, 2, 1);

        Scene scene = new Scene(gridPane, 650, 600);
        setScene(scene);
        setTitle("NovaServices ERP - ??j szem??ly felv??tele");
        show();
    }
}
