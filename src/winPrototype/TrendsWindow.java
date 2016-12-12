package winPrototype;
import win.*;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import win.User;

import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TrendsWindow {

	private JFrame trendsFrame;
	private JTable dayTable;
	private User user = HomeScreen.getUser();
	private JButton backButton;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		displayTrendsWindow();
//	}

	/**
	 * Create the application.
	 */
	public TrendsWindow() {
		initialize();
	}

	public static void displayTrendsWindow(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrendsWindow window = new TrendsWindow();
					window.trendsFrame.setVisible(true);
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
		trendsFrame = new JFrame();
		trendsFrame.setBounds(100, 100, 295, 475);
		trendsFrame.getContentPane().setBackground(SystemColor.textHighlight);
		trendsFrame.getContentPane().setLayout(null);
		//trendsFrame.getContentPane().setLayout(null);
		//DailyTrend dailyTrend = getDailyTrend();
		DailyTrend[] dayTrend = user.getWeeklyTrends().getDailyProgress();
		dayTable = new JTable();		
		dayTable.setModel(new DefaultTableModel(

				new Object[][] {
					{"Sleep Time",user.getDaySleep() }, //30
					{"Workout Time", user.getDayWorkout()},//45
					{"Steps", user.getDaySteps()},//10000
				},
				new String[] {
						"Data", "Value"
				}
				) {
			Class[] columnTypes = new Class[] {
					Object.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		dayTable.setBackground(SystemColor.textHighlight);
		dayTable.setBounds(20, 101, 174, 48);
		trendsFrame.getContentPane().add(dayTable);
		
		Label myTrendslabel = new Label("My Trends");
		myTrendslabel.setForeground(Color.WHITE);
		myTrendslabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		myTrendslabel.setBounds(10, 10, 206, 36);
		trendsFrame.getContentPane().add(myTrendslabel);
		
		JLabel todayLabel = new JLabel("Today");
		todayLabel.setForeground(Color.WHITE);
		todayLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		todayLabel.setBounds(10, 62, 148, 28);
		trendsFrame.getContentPane().add(todayLabel);
		
		backButton = new JButton("Back to Profile");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfileScreen profile = new ProfileScreen();
				ProfileScreen.displayProfileScreen();
				trendsFrame.setVisible(false);
			}
		});
		backButton.setBounds(134, 402, 135, 23);
		trendsFrame.getContentPane().add(backButton);

		trendsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

//	public DailyTrend getDailyTrend(){
//		DailyTrend dailyTrend = new DailyTrend();
//		for(Iterator it = user.getDailyTrends().iterator(); it.hasNext();)
//			dailyTrend = (DailyTrend)it.next();
//		return dailyTrend;
//	}

}
