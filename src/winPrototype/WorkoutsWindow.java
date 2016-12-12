package winPrototype;

import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class WorkoutsWindow {

	private JFrame windowFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkoutsWindow window = new WorkoutsWindow();
					window.windowFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WorkoutsWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		windowFrame = new JFrame();
		windowFrame.setBounds(100, 100, 295, 475);
		windowFrame.getContentPane().setBackground(SystemColor.textHighlight);
		windowFrame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(29, 64, 195, 239);
		windowFrame.getContentPane().add(textArea);
		textArea.append("Test");
		windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
