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
 * @author 冷亚麻色的？
 * 不得不说，才疏学浅的我还是上网“参考”了一下别人的布局
 * 特别是感谢下面这篇文章，给了我很大的启发
 * https://blog.csdn.net/u012169821/article/details/83301828
 * 别人专门设计了一个MyButton
 * 界面就变得好看起来，我自己开始捣鼓的时候
 * 按钮都黏在一起，不美观！！！
 * 还有我发现网上的别人做的计算器都有一个Clear按钮
 * 用于清除错误输入，我感觉挺好的（加一下就好了，可4×4木有位置
 * 为了完美实现课程设计，我没有添加
 * 所以，每次输入错误了就叉掉重来吧（逃。。
 * 还有，我这个小数点搞得时候真的是焦头烂额
 * 还好最后搞定了
 * 奥利给！！！
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
 * 计算器
 */
public class Main extends Application {
	private String num1;//存运算符前数字 
	private String num2;//存运算符后数字 
	private String logic;//存运算符的变量 null
	private TextField view;//显示结果
	private boolean flag;//记录第一次点击运算符之后的拼接操作
	private boolean eq;//记录是否按了等号
	public void start(Stage primaryStage) {
		try {
			//创建布局对象
			AnchorPane root = new AnchorPane();
//			root.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
			//创建场景对象
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			//设置窗口宽高
			primaryStage.setWidth(228);
			primaryStage.setHeight(260);
			primaryStage.setTitle("Calculator");
			primaryStage.setResizable(false);
			
			//调用方法添加组件
			addComp(root);
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 该方法是添加组件
	 * @param root
	 */
	private void addComp(AnchorPane root) {
		//添加显示框
		view = new TextField("");
		view.setMinSize(200, 50);
		view.setLayoutX(10);
		view.setLayoutY(15);
		//设置只读
		view.setEditable(false);
		//内容右对齐
		view.setAlignment(Pos.CENTER_RIGHT);
		//设置字体
		view.setFont(new Font("Consolas", 20));
		root.getChildren().add(view);
		
		//添加一个表格布局
		GridPane gridPane = new GridPane();
		//设置布局中元素组件横向间距
		gridPane.setHgap(20);
		//设置布局中元素组件纵向间距
		gridPane.setVgap(10);
		gridPane.setLayoutY(65);
		gridPane.setPrefWidth(228);
		gridPane.setPrefHeight(185);
//		gridPane.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		gridPane.setPadding(new Insets(10));
		//列容器
		root.getChildren().add(gridPane);
		
		//创建数字监听器对象
		NumberEvent numberEvent = new NumberEvent();
		DotEvent dotEvent = new DotEvent();
		//添加按钮
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
				//记录运算结构
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
				//把结果显示回显示框
				view.setText(number1+"");
				//按了等号
				eq = true;
			}
		});
		gridPane.add(btn_eq,2,3);
		//运算符的按钮
		
		//创建监听器对象
		LogicEvent logicEvent = new LogicEvent();
		Button btn_add = new MyButton("+");
		//给按钮添加事件监听器
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
	 * 数字监听器
	 */
	class NumberEvent implements EventHandler<Event>{
		public void handle(Event event) {
			//如果上一次是等号，得先清除一次
			if (eq) {
				clean();
			}
			
			/**
			 *  ①判断运算符变量是否有值
				②如果有值，将按钮的内容保存到2中的变量
				③如果没有值，将按钮的内容保存到1中的变量
			 */
			//获取当前显示框内容
			String text = view.getText();
			//获取事件源  (获取触发事件的按钮)
			MyButton btn = (MyButton)event.getSource();
			//先获取当前按钮的内容
			String btnNumber = btn.getText();
			//将显示框原本的数字拼接当前按钮的数字
			if (flag) {
				text = "";
				flag = false;
			}
			text+=btnNumber;
			String num = text;
			//没有点击运算符按钮
			if (logic==null) {
				num1 = num;
				view.setText(num1+"");
			//点击了运算符按钮
			}else {
				num2 = num;
				view.setText(num2+"");
			}
			
		}
	}
	/**
	 * 小数点事件监听器
	 */
	
	class DotEvent implements EventHandler<Event>{
		@Override
		public void handle(Event event) {

			//获取当前显示框内容
			String text = view.getText();
			//拼接小数点
			text+=".";
			view.setText(text);	
		}
	}
	/**
	 * 运算符的事件监听器
	 */
	class LogicEvent implements EventHandler<Event>{
 
		public void handle(Event event) {
			//得到按钮
			MyButton logicBtn = (MyButton)event.getSource();
			//获取按钮内容
			logic = logicBtn.getText();
			flag = true;
			eq = false;
		}
		
	}
	/**
	 * 清除计算器参与逻辑的变量
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