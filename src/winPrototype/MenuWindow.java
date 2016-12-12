package winPrototype;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import win.*;
public class MenuWindow {


	private JFrame menuFrame;
	private static User user = HomeScreen.getUser();
	
	public void setUser(User user){
		this.user = user;
		System.out.println("now in MenuWindow setUser" + user.getName());
	}
	
	public static User getUser(){
		return user;
	}

	//Launch the application.
	public static void displayMenuWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuWindow window = new MenuWindow();
					window.menuFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Create the application.
	public MenuWindow() {		
		initialize();		
	}
	
	//Initialize the contents of the frame
	private void initialize() {
		menuFrame = new JFrame();
		menuFrame.setTitle("Win");
		menuFrame.getContentPane().setBackground(SystemColor.textHighlight);

		JButton homeButton = new JButton("Home");
		/**take user back to homepage
		 * 
		 */
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeScreen homeScreen = new HomeScreen();
				homeScreen.displayHomeScreen();
				menuFrame.setVisible(false);
			}
		});
		homeButton.setBounds(108, 61, 79, 23);
		
		

		JButton profileButton = new JButton("Profile");
		/**take user to the profile window
		 * 
		 */
		profileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfileScreen profileScreen = new ProfileScreen();
				//profileScreen.setUser(user);
				profileScreen.displayProfileScreen();				
				menuFrame.setVisible(false);
			}
		});
		profileButton.setBounds(108, 110, 79, 23);
		
		/**
		 * MenuWindow menuWindow = new MenuWindow();
				menuWindow.setUser(user);
				menuWindow.displayMenuWindow();				
				homeFrame.setVisible(false);
		 */

		JButton setGoalsButton = new JButton("Set Goals");
		/**display set goals window
		 * 
		 */
		setGoalsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetGoalsWindow setGoalsWdw = new SetGoalsWindow();
				setGoalsWdw.displaySetGoalsWindow();
				menuFrame.setVisible(false);
			}
		});
		setGoalsButton.setBounds(98, 162, 101, 23);
		
		

		JButton remindersButton = new JButton("Set Reminders");
		remindersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetRemindersWindow reminders = new SetRemindersWindow();
				reminders.displaySetRemindersWindow();
				menuFrame.setVisible(false);
			}
		});
		remindersButton.setBounds(86, 218, 118, 23);

		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setBounds(10, 0, 69, 35);
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMenu.setForeground(SystemColor.text);
		menuFrame.getContentPane().setLayout(null);
		
		JButton menuButton = new JButton("");
		menuButton.setBounds(231, 10, 38, 36);
		menuFrame.getContentPane().add(menuButton);
		/**scale menu stripes icon into the 
		 * size of the menuButton
		 */
		ImageIcon menuIcon = new ImageIcon("C:\\Users\\AnaJacqueline\\Documents\\Adv OOP\\stuffForGUI\\menu-icon.png");
		Image menuImg = menuIcon.getImage();
		Image resizedMenu = menuImg.getScaledInstance(menuButton.getWidth(), menuButton.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon resizedMenuIcon = new ImageIcon(resizedMenu);
		menuButton.setIcon(resizedMenuIcon);
		menuFrame.getContentPane().add(profileButton);
		menuFrame.getContentPane().add(homeButton);
		menuFrame.getContentPane().add(setGoalsButton);
		menuFrame.getContentPane().add(remindersButton);
		menuFrame.getContentPane().add(lblMenu);
		menuFrame.setBounds(100, 100, 297, 475);
		
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
