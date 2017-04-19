package com.godyo.mathema.campus.demo;
 
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
 
public class MathemaDemo extends Application {
	
	GreetingsFactory greetingsFac = new GreetingsFactory();
	
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	final String COMMAND_GREETING = "Sag Hallo!";
    	final String COMMAND_SILENT = "So Ruhe jetzt!";

    	primaryStage.setTitle("Hallo Mathema Demo!");
        
        Button btn = new Button();
		btn.setText(COMMAND_GREETING);
        Label textLabel = new Label();
        textLabel.setContentDisplay(ContentDisplay.CENTER);
        textLabel.setMinSize(300, 100);
        textLabel.setAlignment(Pos.CENTER);
        textLabel.setStyle("-fx-font-size: 15pt;");


        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            	switch (btn.getText()) {
            		case COMMAND_GREETING: 
            			textLabel.setText(greetingsFac.createGreeting("Mathema Campus"));
            			btn.setText(COMMAND_SILENT);
            			break;
            		case COMMAND_SILENT: 
            			textLabel.setText("");
            			btn.setText(COMMAND_GREETING);
            	}
            }
        });
        
        
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(btn);
        borderPane.setBottom(textLabel);
        
        primaryStage.setScene(new Scene(borderPane, 300, 250));
        primaryStage.show();
    }
}