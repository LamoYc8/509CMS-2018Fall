package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.SingleCalendarController;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import model.*;

public class SingleCalendar extends JFrame {

	private JPanel contentPane;
	

	JButton modifyBtn;
	JButton closeTSBtn;
	JButton createMBtn;
	JButton meetingSBtn;

	JTable timeSlotTable;

	CalendarModel cmodel;
	
	/**
	 * Create the frame.
	 */
	public SingleCalendar(CalendarModel cm) {
		this.cmodel = cm;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Time Slot:");
		
		JScrollPane scrollPane = new JScrollPane();
		
		//JTable content set up
		timeSlotTable = new JTable();
		scrollPane.setViewportView(timeSlotTable);
		
	 	modifyBtn = new JButton("Modify Calendar");
		
		closeTSBtn = new JButton("Close TimeSlot");
		
		createMBtn = new JButton("Create Meeting");
		
		meetingSBtn = new JButton("Meeting Schedule");

		//Listeners for all buttons
		modifyBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new SingleCalendarController(cmodel, SingleCalendar.this).modifyCProcess();
				
			}
			
		});

		closeTSBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new SingleCalendarController(cmodel, SingleCalendar.this).closeTSProcess();
				
			}
			
		});
		createMBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new SingleCalendarController(cmodel, SingleCalendar.this).createMProcess();
				
			}
			
		});
		meetingSBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new SingleCalendarController(cmodel, SingleCalendar.this).meetingSchedule();
				
			}
			
		});


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
								.addComponent(modifyBtn, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(2)
									.addComponent(closeTSBtn, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(2)
									.addComponent(createMBtn, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))))
						.addComponent(meetingSBtn, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
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
							.addComponent(modifyBtn)
							.addGap(11)
							.addComponent(closeTSBtn)
							.addGap(12)
							.addComponent(createMBtn)))
					.addGap(7)
					.addComponent(meetingSBtn)
					.addGap(23))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
