package org.example.alifx.view_controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.example.alifx.model.PythonRunner;

import java.io.IOException;

public class MainGUI extends Application {

    private TextField input = new TextField("Enter name");
    private Label name = new Label("Nothing");

    @Override
    public void start(Stage stage) throws IOException {
        createGUI(stage);
        registerHandler();
    }

    public void registerHandler() {

        input.setOnAction(e -> {
            PythonRunner runner = new PythonRunner();
            runner.doIt(input.getText());
            name.setText(runner.output.toString());
        });
    }

    public void createGUI(Stage primaryStage) {
        GridPane inputGrid = new GridPane();

        inputGrid.add(input, 0, 0);
        inputGrid.add(name, 0, 2);



        Scene scene = new Scene(inputGrid, 1000, 1000);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Classifier");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}