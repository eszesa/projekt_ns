package org.example;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;

public class ERP extends Application {

    private Stage mainWindow;

    @Override
    public void start(Stage stage) throws Exception{
/*
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("hello jfx");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
*/
        mainWindow = stage;

        VBox root = new VBox();
        Text text = new Text("welcome");
        root.getChildren().add(text);
        Scene scene = new Scene(root, 800, 500);

        stage.setScene(scene);
        stage.setTitle("ERP");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}