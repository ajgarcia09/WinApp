package winPrototype;

import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import java.awt.Label;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

import win.User;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SetGoalsWindow {

	private JFrame setGoalsframe;
	private JTextField stepField;
	private JTextField sleepHrField;
	private JTextField lapsField;
	private JTextField runField;
	private JTextField minSleepField;
	private User user = HomeScreen.getUser();
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		displaySetGoalsWindow();
	}

	/**
	 * Create the application.
	 */
	public SetGoalsWindow() {
		initialize();
	}

	public static void displaySetGoalsWindow(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetGoalsWindow window = new SetGoalsWindow();
					window.setGoalsframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setGoalsframe = new JFrame();
		setGoalsframe.setBounds(100, 100, 295, 475);
		setGoalsframe.getContentPane().setBackground(SystemColor.textHighlight);
		setGoalsframe.getContentPane().setLayout(null);

		JButton menuButton = new JButton("");
		/**takes the user to the menu window
		 * 
		 */
		menuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuWindow menuWindow = new MenuWindow();
				menuWindow.displayMenuWindow();
				setGoalsframe.setVisible(false);
				
			}
		});
		menuButton.setBounds(231, 10, 38, 36);
		setGoalsframe.getContentPane().add(menuButton);
		ImageIcon menuIcon = new ImageIcon("C:\\Users\\AnaJacqueline\\Documents\\Adv OOP\\stuffForGUI\\menu-icon.png");
		Image menuImg = menuIcon.getImage();
		Image resizedMenu = menuImg.getScaledInstance(menuButton.getWidth(), menuButton.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon resizedMenuIcon = new ImageIcon(resizedMenu);
		menuButton.setIcon(resizedMenuIcon);

		Label setMyGoalslabel = new Label("Set My Goals");
		setMyGoalslabel.setForeground(Color.WHITE);
		setMyGoalslabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		setMyGoalslabel.setBounds(10, 10, 154, 36);
		setGoalsframe.getContentPane().add(setMyGoalslabel);

		JLabel stepLabel = new JLabel("Daily Step Goal");
		stepLabel.setForeground(Color.WHITE);
		stepLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		stepLabel.setBounds(10, 66, 184, 19);
		setGoalsframe.getContentPane().add(stepLabel);

		JLabel sleepLabel = new JLabel("Daily Sleep Goal");
		sleepLabel.setForeground(Color.WHITE);
		sleepLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		sleepLabel.setBounds(10, 156, 184, 19);
		setGoalsframe.getContentPane().add(sleepLabel);

		JLabel lapsGoal = new JLabel("Swimming Laps Goal");
		lapsGoal.setForeground(Color.WHITE);
		lapsGoal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lapsGoal.setBounds(10, 239, 184, 19);
		setGoalsframe.getContentPane().add(lapsGoal);

		JLabel kmGoal = new JLabel("Km to Run Goal");
		kmGoal.setForeground(Color.WHITE);
		kmGoal.setFont(new Font("Tahoma", Font.BOLD, 15));
		kmGoal.setBounds(10, 320, 184, 19);
		setGoalsframe.getContentPane().add(kmGoal);

		JLabel enterValueLbl1 = new JLabel("Enter a value and hit Enter");
		enterValueLbl1.setForeground(Color.WHITE);
		enterValueLbl1.setFont(new Font("Tahoma", Font.BOLD, 10));
		enterValueLbl1.setBounds(10, 132, 133, 13);
		setGoalsframe.getContentPane().add(enterValueLbl1);

		stepField = new JTextField("10000");
		String stepsNum = stepField.getText();
		int stepGoal = Integer.parseInt(stepsNum); //to create a new step goal
		stepField.setBounds(10, 96, 86, 20);
		setGoalsframe.getContentPane().add(stepField);
		stepField.setColumns(10);
		
		JButton btnSetStepGoal = new JButton("Set Step Goal");
		/**set a new value for the user's step goal
		 * 
		 */
		btnSetStepGoal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.setStepGoal(stepGoal);
			}
		});
		btnSetStepGoal.setBounds(157, 96, 112, 23);
		setGoalsframe.getContentPane().add(btnSetStepGoal);

		sleepHrField = new JTextField("8");
		String sleepH = sleepHrField.getText();
		int sleepHrs = Integer.parseInt(sleepH);
		sleepHrField.setColumns(10);
		sleepHrField.setBounds(10, 186, 41, 20);
		setGoalsframe.getContentPane().add(sleepHrField);

		minSleepField = new JTextField("30");
		String sleepM = minSleepField.getText();
		int sleepMins = Integer.parseInt(sleepM);
		minSleepField.setColumns(10);
		minSleepField.setBounds(72, 186, 41, 20);
		setGoalsframe.getContentPane().add(minSleepField);
		
		JButton btnSetSleepGoal = new JButton("Set Sleep Goal");
		/**set a new sleep goal for the user by adding sleep hours plus slepe minutes
		 * 
		 */
		btnSetSleepGoal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//time in minutes
				user.setSleepGoal(sleepHrs*60 + sleepMins);
			}
		});
		btnSetSleepGoal.setBounds(146, 185, 123, 23);
		setGoalsframe.getContentPane().add(btnSetSleepGoal);


		JLabel enterValueLbl2 = new JLabel("Enter a value and hit Enter");
		enterValueLbl2.setForeground(Color.WHITE);
		enterValueLbl2.setFont(new Font("Tahoma", Font.BOLD, 10));
		enterValueLbl2.setBounds(10, 215, 133, 13);
		setGoalsframe.getContentPane().add(enterValueLbl2);

		lapsField = new JTextField("5");
		String swimLaps = lapsField.getText();
		int swimGoal = Integer.parseInt(swimLaps);
		lapsField.setColumns(10);
		lapsField.setBounds(10, 265, 86, 20);
		setGoalsframe.getContentPane().add(lapsField);
		
		JButton btnSetSwimGoal = new JButton("Set Swim Goal");
		/**set user's swim goal upon clicking set swim goal button
		 * 
		 */
		btnSetSwimGoal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.setSwimGoal(swimGoal);
			}
		});
		btnSetSwimGoal.setBounds(146, 269, 123, 23);
		setGoalsframe.getContentPane().add(btnSetSwimGoal);

		runField = new JTextField("10");
		String runDistance = runField.getText();
		int runGoal = Integer.parseInt(runDistance);
		runField.setColumns(10);
		runField.setBounds(10, 350, 86, 20);
		setGoalsframe.getContentPane().add(runField);
		
		JButton btnSetRunGoal = new JButton("Set Run Goal");
		btnSetRunGoal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.setRunGoal(runGoal);
			}
		});
		btnSetRunGoal.setBounds(157, 349, 112, 23);
		setGoalsframe.getContentPane().add(btnSetRunGoal);	

		JLabel enterValueLbl3 = new JLabel("Enter a value and hit Enter");
		enterValueLbl3.setForeground(Color.WHITE);
		enterValueLbl3.setFont(new Font("Tahoma", Font.BOLD, 10));
		enterValueLbl3.setBounds(10, 296, 133, 13);
		setGoalsframe.getContentPane().add(enterValueLbl3);

		JLabel enterValueLbl4 = new JLabel("Enter a value and hit Enter");
		enterValueLbl4.setForeground(Color.WHITE);
		enterValueLbl4.setFont(new Font("Tahoma", Font.BOLD, 10));
		enterValueLbl4.setBounds(10, 381, 133, 13);
		setGoalsframe.getContentPane().add(enterValueLbl4);	


		JLabel hourLabel = new JLabel("hr");
		hourLabel.setForeground(Color.WHITE);
		hourLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		hourLabel.setBounds(54, 193, 21, 13);
		setGoalsframe.getContentPane().add(hourLabel);

		JLabel minLabel = new JLabel("min");
		minLabel.setForeground(Color.WHITE);
		minLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		minLabel.setBounds(123, 193, 21, 13);
		setGoalsframe.getContentPane().add(minLabel);
		setGoalsframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}



}
