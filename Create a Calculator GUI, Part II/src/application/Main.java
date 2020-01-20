package application;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/***
 * 
 * @author ������ɫ�ģ�
 * ���ò�˵������ѧǳ���һ����������ο�����һ�±��˵Ĳ���
 * �ر��Ǹ�л������ƪ���£������Һܴ������
 * https://blog.csdn.net/u012169821/article/details/83301828
 * ����ר�������һ��MyButton
 * ����ͱ�úÿ����������Լ���ʼ���ĵ�ʱ��
 * ��ť�����һ�𣬲����ۣ�����
 * �����ҷ������ϵı������ļ���������һ��Clear��ť
 * ��������������룬�Ҹо�ͦ�õģ���һ�¾ͺ��ˣ���4��4ľ��λ��
 * Ϊ������ʵ�ֿγ���ƣ���û������
 * ���ԣ�ÿ����������˾Ͳ�������ɣ��ӡ���
 * ���У������С������ʱ������ǽ�ͷ�ö�
 * �������㶨��
 * ������������
 *
 */

class MyButton extends Button {

	public MyButton(String text) {
		super(text);
		setPrefWidth(35);
		setPrefHeight(30);
	}
}
 
/**
 * ������
 */
public class Main extends Application {
	private String num1;//�������ǰ���� 
	private String num2;//������������� 
	private String logic;//��������ı��� null
	private TextField view;//��ʾ���
	private boolean flag;//��¼��һ�ε�������֮���ƴ�Ӳ���
	private boolean eq;//��¼�Ƿ��˵Ⱥ�
	public void start(Stage primaryStage) {
		try {
			//�������ֶ���
			AnchorPane root = new AnchorPane();
//			root.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
			//������������
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			//���ô��ڿ���
			primaryStage.setWidth(228);
			primaryStage.setHeight(260);
			primaryStage.setTitle("Calculator");
			primaryStage.setResizable(false);
			
			//���÷����������
			addComp(root);
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * �÷������������
	 * @param root
	 */
	private void addComp(AnchorPane root) {
		//������ʾ��
		view = new TextField("");
		view.setMinSize(200, 50);
		view.setLayoutX(10);
		view.setLayoutY(15);
		//����ֻ��
		view.setEditable(false);
		//�����Ҷ���
		view.setAlignment(Pos.CENTER_RIGHT);
		//��������
		view.setFont(new Font("Consolas", 20));
		root.getChildren().add(view);
		
		//����һ�����񲼾�
		GridPane gridPane = new GridPane();
		//���ò�����Ԫ�����������
		gridPane.setHgap(20);
		//���ò�����Ԫ�����������
		gridPane.setVgap(10);
		gridPane.setLayoutY(65);
		gridPane.setPrefWidth(228);
		gridPane.setPrefHeight(185);
//		gridPane.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		gridPane.setPadding(new Insets(10));
		//������
		root.getChildren().add(gridPane);
		
		//�������ּ���������
		NumberEvent numberEvent = new NumberEvent();
		DotEvent dotEvent = new DotEvent();
		//���Ӱ�ť
		Button btn_7 = new MyButton("7");
		btn_7.setOnMouseClicked(numberEvent);
		gridPane.add(btn_7,0,0);
		
		Button btn_8 = new MyButton("8");
		btn_8.setOnMouseClicked(numberEvent);
		gridPane.add(btn_8,1,0);
		
		Button btn_9 = new MyButton("9");
		btn_9.setOnMouseClicked(numberEvent);
		gridPane.add(btn_9,2,0);
		
		Button btn_4 = new MyButton("4");
		btn_4.setOnMouseClicked(numberEvent);
		gridPane.add(btn_4,0,1);
		
		Button btn_5 = new MyButton("5");
		btn_5.setOnMouseClicked(numberEvent);
		gridPane.add(btn_5,1,1);
		
		Button btn_6 = new MyButton("6");
		btn_6.setOnMouseClicked(numberEvent);
		gridPane.add(btn_6,2,1);
		
		Button btn_1 = new MyButton("1");
		btn_1.setOnMouseClicked(numberEvent);
		gridPane.add(btn_1,0,2);
		
		Button btn_2 = new MyButton("2");
		btn_2.setOnMouseClicked(numberEvent);
		gridPane.add(btn_2,1,2);
		
		Button btn_3 = new MyButton("3");
		btn_3.setOnMouseClicked(numberEvent);
		gridPane.add(btn_3,2,2);
		
		Button btn_0 = new MyButton("0");
		btn_0.setOnMouseClicked(numberEvent);
		gridPane.add(btn_0,0,3);
		
		Button btn_dot = new MyButton(".");
		btn_dot.setOnMouseClicked(dotEvent);
		gridPane.add(btn_dot,1,3);
		
		Button btn_eq = new MyButton("=");
		btn_eq.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				//��¼����ṹ
				Double number1 = Double.parseDouble(num1);
				Double number2 = Double.parseDouble(num2);
				switch (logic) {
				case "+":
					number1 = number1+number2;
					break;
				case "-":
					number1 = number1-number2;
					break;
				case "*":
					number1 = number1*number2;
					break;
				case "/":
					number1 = number1/number2;
					break;
 
				default:
					break;
				}
				//�ѽ����ʾ����ʾ��
				view.setText(number1+"");
				//���˵Ⱥ�
				eq = true;
			}
		});
		gridPane.add(btn_eq,2,3);
		//������İ�ť
		
		//��������������
		LogicEvent logicEvent = new LogicEvent();
		Button btn_add = new MyButton("+");
		//����ť�����¼�������
		btn_add.setOnMouseClicked(logicEvent);
		gridPane.add(btn_add,3,0);
		Button btn_sub = new MyButton("-");
		btn_sub.setOnMouseClicked(logicEvent);
		gridPane.add(btn_sub,3,1);
		Button btn_mul = new MyButton("*");
		btn_mul.setOnMouseClicked(logicEvent);
		gridPane.add(btn_mul,3,2);
		Button btn_div = new MyButton("/");
		btn_div.setOnMouseClicked(logicEvent);
		gridPane.add(btn_div,3,3);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	/**
	 * ���ּ�����
	 */
	class NumberEvent implements EventHandler<Event>{
		public void handle(Event event) {
			//�����һ���ǵȺţ��������һ��
			if (eq) {
				clean();
			}
			
			/**
			 *  ���ж�����������Ƿ���ֵ
				�������ֵ������ť�����ݱ��浽2�еı���
				�����û��ֵ������ť�����ݱ��浽1�еı���
			 */
			//��ȡ��ǰ��ʾ������
			String text = view.getText();
			//��ȡ�¼�Դ  (��ȡ�����¼��İ�ť)
			MyButton btn = (MyButton)event.getSource();
			//�Ȼ�ȡ��ǰ��ť������
			String btnNumber = btn.getText();
			//����ʾ��ԭ��������ƴ�ӵ�ǰ��ť������
			if (flag) {
				text = "";
				flag = false;
			}
			text+=btnNumber;
			String num = text;
			//û�е���������ť
			if (logic==null) {
				num1 = num;
				view.setText(num1+"");
			//������������ť
			}else {
				num2 = num;
				view.setText(num2+"");
			}
			
		}
	}
	/**
	 * С�����¼�������
	 */
	
	class DotEvent implements EventHandler<Event>{
		@Override
		public void handle(Event event) {

			//��ȡ��ǰ��ʾ������
			String text = view.getText();
			//ƴ��С����
			text+=".";
			view.setText(text);	
		}
	}
	/**
	 * ��������¼�������
	 */
	class LogicEvent implements EventHandler<Event>{
 
		public void handle(Event event) {
			//�õ���ť
			MyButton logicBtn = (MyButton)event.getSource();
			//��ȡ��ť����
			logic = logicBtn.getText();
			flag = true;
			eq = false;
		}
		
	}
	/**
	 * ��������������߼��ı���
	 */
	private void clean() {
		num1 = null;
		num2 = null;
		logic = null;
		flag = false;
		eq = false;

		view.setText("");
	}
}