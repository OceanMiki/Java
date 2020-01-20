package application;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/******
 *
 * @author 冷亚麻色的？
 *
 *         functino:send & quit
 *
 */
public class Main extends Application {

	private TextField tx = new TextField();
	private TextArea ta = new TextArea("javaFX is fun\n");

	class Quit_exit implements EventHandler<Event> {
		@Override
		public void handle(Event e) {
			System.exit(0);
		}
	}

	class Send_message implements EventHandler<Event> {

		@Override
		public void handle(Event e) {
			String message = ta.getText();

			message = message + tx.getText() + System.getProperty("line.separator");

			ta.setText(message);// 复制文本

			tx.setText(null);

		}

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("ChatRoom");
		primaryStage.setResizable(false);

		Send_message sMessage = new Send_message();// 事件注册

		ScrollPane sp = new ScrollPane();
		sp.setHbarPolicy(ScrollBarPolicy.NEVER);
		sp.setVbarPolicy(ScrollBarPolicy.NEVER);

		BorderPane bp = new BorderPane();

		VBox vb = new VBox();
		vb.setPadding(new Insets(40, 100, 100, 100));
		vb.setSpacing(10);

		Button send = new Button("Send");
		Button quit = new Button("Quit");
		send.setOnMouseClicked(sMessage);
		Quit_exit exit = new Quit_exit();
		quit.setOnMouseClicked(exit);

		tx.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					String message = ta.getText();

					message = message + tx.getText() + System.getProperty("line.separator");

					ta.setText(message);// 复制文本

					tx.setText(null);
				}
			}
		});

		vb.getChildren().add(send);
		vb.getChildren().add(quit);
		bp.setRight(vb);

		bp.setBottom(tx);

		Scene scene = new Scene(new Group());

		sp.setContent(ta);
		bp.setCenter(sp);

		sp.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		bp.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		((Group) scene.getRoot()).getChildren().add(bp);

		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
