package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class Calculatorhsk extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Calculator");
			primaryStage.setResizable(false);
			
			TextField textfield = new TextField("0.0");
			textfield.setEditable(false);
			textfield.setAlignment(Pos.CENTER_RIGHT);
			
			Button bt7 = new Button("7");
			Button bt8 = new Button("8");
			Button bt9 = new Button("9");
			Button bt91 = new Button("+");
			Button bt4 = new Button("4");
			Button bt5 = new Button("5");
			Button bt6 = new Button("6");
			Button bt61 = new Button("-");
			Button bt1 = new Button("1");
			Button bt2 = new Button("2");
			Button bt3 = new Button("3");
			Button bt31 = new Button("*");
			Button bt0 = new Button("0");
			Button bt01 = new Button(". ");
			Button bt02 = new Button("=");
			Button bt03 = new Button("/");
			
			GridPane gridpane = new GridPane();
			gridpane.setHgap(20);
			gridpane.setVgap(20);
			gridpane.setLayoutY(10);
			gridpane.setPrefWidth(20);
			gridpane.setPrefHeight(10);
			gridpane.setPadding(new Insets(5));
			gridpane.add(bt7,0,0);
			gridpane.add(bt8,1,0);
			gridpane.add(bt9,2,0);
			gridpane.add(bt91,3,0);
			gridpane.add(bt4,0,1);
			gridpane.add(bt5,1,1);
			gridpane.add(bt6,2,1);
			gridpane.add(bt61,3,1);
			gridpane.add(bt1,0,2);
			gridpane.add(bt2,1,2);
			gridpane.add(bt3,2,2);
			gridpane.add(bt31,3,2);
			gridpane.add(bt0,0,3);
			gridpane.add(bt01,1,3);
			gridpane.add(bt02,2,3);
			gridpane.add(bt03,3,3);
			
			
			
			
			BorderPane borderpane = new BorderPane();
			Scene scene = new Scene(new Group(),220,180);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			borderpane.setBottom(gridpane);
			borderpane.setTop(textfield);
			((Group) scene.getRoot()).getChildren().add(borderpane);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
