package org.example.alifx.view_controller;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.example.alifx.model.GPT;

import java.io.IOException;

public class MainGUI extends Application {

    private TextField input = new TextField("Enter question");
    private Label name = new Label("Nothing");

    @Override
    public void start(Stage stage) throws IOException {
        createGUI(stage);
        registerHandler();
    }

    public void registerHandler() {
//hi
        input.setOnAction(e -> {
            GPT gpt = new GPT();
            String output = gpt.getOutput(input.getText());
            name.setText(output);
            input.setText("");
        });
    }

    public void createGUI(Stage primaryStage) {
        GridPane inputGrid = new GridPane();

        inputGrid.setAlignment(Pos.CENTER);
        inputGrid.setVgap(10);
        inputGrid.add(input, 20, 20);
        inputGrid.add(name, 20, 22);


        Scene scene = new Scene(inputGrid, 1000, 1000);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Classifier");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}