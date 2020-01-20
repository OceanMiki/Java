package application;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient {
	private JFrame jFrame;
	private JTextArea jArea;
	private JScrollPane jScrollPane;
	private JButton Send;
	private JButton Quit;
	private JTextField jTextField;

	private Box east_box;

	public ChatClient() {
		jFrame = new JFrame("Chat Room");
		Send = new JButton("Send");
		Quit = new JButton("Quit");
		jArea = new JTextArea("javaFX is fun");
		jTextField = new JTextField(50);
		jScrollPane = new JScrollPane(jArea);
		east_box = Box.createVerticalBox();
	}

	public void launchFrame() {
		jFrame.setSize(600, 250);
		JPanel jPanel = new JPanel();
		jFrame.add(jPanel);
		jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jFrame.add(jScrollPane, BorderLayout.CENTER);
		jFrame.add(jTextField, BorderLayout.SOUTH);

		east_box.add(Send);
		east_box.add(Quit);
		east_box.add(Box.createVerticalStrut(10));
		east_box.add(Box.createVerticalGlue());

		jFrame.add(east_box, BorderLayout.EAST);
		jFrame.pack();

		jPanel.setBackground(Color.red);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		ChatClient newChatClient = new ChatClient();
		newChatClient.launchFrame();
	}
}
