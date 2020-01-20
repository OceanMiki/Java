package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("ChatRoom");
			primaryStage.setResizable(false);
			
			TextField textfield = new TextField();
			TextArea textarea = new TextArea("javaFX is fun");
			
			Button send = new Button("Send");
			Button quit = new Button("Quit");
			
			BorderPane borderpane = new BorderPane();
			Scene scene = new Scene(borderpane,400,200);
			
			VBox vbox = new VBox();
			vbox.setSpacing(20);
			vbox.setPadding(new Insets(10));;
			
			vbox.getChildren().addAll(send,quit);
			
			borderpane.setRight(vbox);
			borderpane.setBottom(textfield);
			borderpane.setCenter(textarea);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
