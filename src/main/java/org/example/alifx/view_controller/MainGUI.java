package org.example.alifx.view_controller;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.example.alifx.model.GPT;

import java.io.IOException;

public class MainGUI extends Application {

    private TextField input = new TextField();
    private TextArea conversation = new TextArea();

    @Override
    public void start(Stage stage) throws IOException {
        createGUI(stage);
        registerHandler();
    }

    public void registerHandler() {
        input.setOnAction(e -> {
            String userQuestion = input.getText();
            if (!userQuestion.trim().isEmpty()) {
                GPT gpt = new GPT();
                String output = gpt.getOutput(userQuestion);

                // Update conversation history
                conversation.appendText("You: " + userQuestion + "\n");
                conversation.appendText("Bot: " + output + "\n\n");

                input.setText("");
            }
        });
    }

    public void createGUI(Stage primaryStage) {
        // Configure input area
        input.setPromptText("Ask a question...");
        input.setPrefWidth(800);

        // Configure conversation area
        conversation.setEditable(false);
        conversation.setWrapText(true);

        // Scroll pane for conversation area
        ScrollPane scrollPane = new ScrollPane(conversation);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        // Layout for input and button
        HBox inputBox = new HBox(input);
        inputBox.setAlignment(Pos.CENTER);
        inputBox.setPadding(new Insets(10));

        // Main layout
        BorderPane mainLayout = new BorderPane();
        mainLayout.setCenter(scrollPane);
        mainLayout.setBottom(inputBox);
        mainLayout.setPadding(new Insets(10));

        // Scene setup
        Scene scene = new Scene(mainLayout, 900, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ChatGPT Clone");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
