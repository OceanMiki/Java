package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
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
 *
 */
public class Main extends Application {

	private TextField tx = new TextField();
	private TextArea ta = new TextArea();
	private ChoiceBox<String> choiceBox = new ChoiceBox<>();

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
			String name = choiceBox.getValue();

			message = message + name + ": " + tx.getText() + System.getProperty("line.separator");

			ta.setFont(Font.font("STXingkai"));
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
		
		MenuBar menubar = new MenuBar();//创建菜单栏
		Menu menuFile = new Menu("File");
		MenuItem quitItem = new MenuItem("quit");
		menuFile.getItems().add(quitItem);
		quitItem.setOnAction(actionEvent -> Platform.exit());
		Menu menuHelp = new Menu("Help");
		menuHelp.getItems().add(new MenuItem("about"));
		menubar.getMenus().addAll(menuFile,menuHelp);	

		Quit_exit exit = new Quit_exit();
		Send_message sMessage = new Send_message();// 事件注册

		ScrollPane sp = new ScrollPane();
		sp.setHbarPolicy(ScrollBarPolicy.NEVER);
		sp.setVbarPolicy(ScrollBarPolicy.NEVER);

		BorderPane bp = new BorderPane();

		VBox vb = new VBox();
		vb.setPadding(new Insets(40, 100, 100, 100));
		vb.setSpacing(10);

		Button send = new Button("Send");
		send.setStyle("-fx-background-color: red");
		Button quit = new Button("Quit");
		quit.setStyle("-fx-background-color: yellow");
		send.setOnMouseClicked(sMessage);
		
		choiceBox.getItems().addAll(
			    "希尔瓦娜斯·风行者", 
			    "加尔鲁什·地狱咆哮",
			    "安度因·乌瑞恩",
			    "玛法里奥·怒风",
			    "雷克萨",
			    "吉安娜",
			    "乌瑞恩",
			    "瓦莉拉",
			    "萨尔"
			    );
		choiceBox.setStyle("-fx-background-color: #33FFFF");
		
		
		quit.setOnMouseClicked(exit);
		quit.setFont(Font.font("Georgia"));

		/**
		 * 发送信息事件处理
		 * 
		 */
		tx.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					String message = ta.getText();
					String name = (String)choiceBox.getValue();

					message = message + name + ": " + tx.getText() + System.getProperty("line.separator");

					ta.setFont(Font.font("STXingkai"));
					ta.setText(message);// 复制文本
					
					tx.setText(null);
				}
			}
		});

		vb.getChildren().add(send);
		vb.getChildren().add(quit);
		vb.getChildren().add(choiceBox);
		bp.setRight(vb);
		bp.setTop(menubar);
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
