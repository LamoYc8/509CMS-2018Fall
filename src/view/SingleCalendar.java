package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class SingleCalendar extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SingleCalendar frame = new SingleCalendar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SingleCalendar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Time Slot:");
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Modify Calendar");
		
		JButton btnNewButton_1 = new JButton("Close TimeSlot");
		
		JButton btnCreateMeeting = new JButton("Create Meeting");
		
		JButton btnMeetingSchedule = new JButton("Meeting Schedule");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(2)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(2)
									.addComponent(btnCreateMeeting, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))))
						.addComponent(btnMeetingSchedule, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
					.addGap(23))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(lblNewLabel)
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(17)
							.addComponent(btnNewButton)
							.addGap(11)
							.addComponent(btnNewButton_1)
							.addGap(12)
							.addComponent(btnCreateMeeting)))
					.addGap(7)
					.addComponent(btnMeetingSchedule)
					.addGap(23))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
