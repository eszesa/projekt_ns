package hu.novaservices.view;

import hu.novaservices.CompanyController;
import hu.novaservices.EmployeeController;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CompanyAddDialog extends Stage {

    CompanyController companyController = new CompanyController();

    public CompanyAddDialog(CompanyController controller) {
        this.companyController = controller;
        construct();
    }

    private void construct() {
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));

        TextField shortNameTF = new TextField();
        TextField fullNameTF = new TextField();
        TextField taxNumberTF = new TextField();
        TextField industryClassTF = new TextField();
        TextField headquartersTF = new TextField();
        TextField connTypeTF = new TextField();
        TextField compContactTF = new TextField();
        TextField ourContactTF = new TextField();
        TextField regNumberTF = new TextField();
        TextField bankAccountTF = new TextField();
        TextField billingNameTF = new TextField();
        TextField billingAddressTF = new TextField();
        TextField descriptionTF = new TextField();
        descriptionTF.setPrefSize(50,50);

        gridPane.add(new Text("Rövid név:"), 0, 0);
        gridPane.add(shortNameTF, 1, 0);
        gridPane.add(new Text("Teljes név:"), 0, 1);
        gridPane.add(fullNameTF, 1, 1);
        gridPane.add(new Text("Adószám:"), 0, 2);
        gridPane.add(taxNumberTF, 1, 2);
        gridPane.add(new Text("Iparági besorolás:"), 0, 3);
        gridPane.add(industryClassTF, 1, 3);
        gridPane.add(new Text("Cég kapcsolattípus:"), 0, 4);
        gridPane.add(connTypeTF, 1, 4);
        gridPane.add(new Text("Céges kapcsolattartó:"), 0, 5);
        gridPane.add(compContactTF, 1, 5);
        gridPane.add(new Text("Tőlünk kapcsolattartó:"), 0, 6);
        gridPane.add(ourContactTF, 1, 6);
        gridPane.add(new Text("Székhely:"), 0, 7);
        gridPane.add(headquartersTF, 1, 7);
        gridPane.add(new Text("Cégjegyzékszám:"), 0, 8);
        gridPane.add(regNumberTF, 1, 8);
        gridPane.add(new Text("Bankszámlaszám:"), 0, 9);
        gridPane.add(bankAccountTF, 1, 9);
        gridPane.add(new Text("Számlázási név és cím"), 0, 10);
        gridPane.add(billingNameTF, 1, 10);
        gridPane.add(billingAddressTF, 2, 10);
        gridPane.add(new Text("Szöveges értékelés:"), 0, 11);
        gridPane.add(descriptionTF, 1, 11);


        //gombok eseménykezelés
        Button saveButton = new Button("Mentés");
        saveButton.setDefaultButton(true);
        saveButton.setOnAction(e -> {});

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

        gridPane.add(buttonPane, 0, 13, 2, 1);

        Scene scene = new Scene(gridPane);
        setScene(scene);
        setTitle("NovaServices ERP - Új cég felvétele");
        show();

    }
}
