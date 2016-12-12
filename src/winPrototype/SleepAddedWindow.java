package winPrototype;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SleepAddedWindow {

	private JFrame sleepAddedFrame;

	/**
	 * Launch the application.
	 */
	public static void displaySleepAddedwindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SleepAddedWindow window = new SleepAddedWindow();
					window.sleepAddedFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SleepAddedWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		sleepAddedFrame = new JFrame();
		sleepAddedFrame.getContentPane().setBackground(SystemColor.textHighlight);
//		ImageIcon imageIcon = new ImageIcon("/winPrototype/checkMark_smaller.png");
//		Image image = imageIcon.getImage();
//		Image newImage = image.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
//		imageIcon = new ImageIcon(newImage);
		
		JLabel sleepAddedLabel = new JLabel("Sleep Added!");
		sleepAddedLabel.setForeground(SystemColor.window);
		sleepAddedLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JButton backHomeButton = new JButton("Back to Home");
		/**takes user back to homepage
		 * 
		 */
		backHomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeScreen homeScreen = new HomeScreen();
				homeScreen.displayHomeScreen();
				sleepAddedFrame.setVisible(false);
			}
		});
		
		JButton addActivityButton = new JButton("Add Another Activity");
		/**takes user back to LogActivityWindow
		 * 
		 */
		addActivityButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogActivityWindow logAct = new LogActivityWindow();
				logAct.displayLogActivityWindow();
				sleepAddedFrame.setVisible(false);
			}
		});
		
		JLabel checkMarkLabel = new JLabel("");
		checkMarkLabel.setBounds(21, 70, 150, 150);
		ImageIcon myImage = new ImageIcon("C:\\Users\\AnaJacqueline\\Documents\\Adv OOP\\stuffForGUI\\checkMark_smaller.png");
		Image img = myImage.getImage();
		Image newImg = img.getScaledInstance(checkMarkLabel.getWidth(), checkMarkLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		checkMarkLabel.setIcon(image);
		
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(sleepAddedFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(57, Short.MAX_VALUE)
					.addComponent(checkMarkLabel, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
					.addGap(36))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addComponent(sleepAddedLabel)
					.addContainerGap(47, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(71)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(backHomeButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(addActivityButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(51, Short.MAX_VALUE)
					.addComponent(checkMarkLabel, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(sleepAddedLabel)
					.addGap(34)
					.addComponent(backHomeButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(addActivityButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(44))
		);
		sleepAddedFrame.getContentPane().setLayout(groupLayout);
		sleepAddedFrame.setBounds(100, 100, 295, 475);
		sleepAddedFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

}
