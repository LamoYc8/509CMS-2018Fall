package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.SingleCalendarController;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import model.*;
import javax.swing.JTextArea;

public class SingleCalendar extends JFrame {

	private JPanel contentPane;
	

	JButton modifyBtn;
	JButton closeTSBtn;
	JButton createMBtn;
	JButton meetingSBtn;

	CalendarModel cmodel;
	private JTable timeSlotTable;

	public JTable getTimeSlot() {
		return this.timeSlotTable;
	}
	
	/**
	 * Create the frame.
	 */
	public SingleCalendar(CalendarModel cm) {
		this.cmodel = cm;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Time Slot:");
		
		JScrollPane scrollPane = new JScrollPane();
		
	 	modifyBtn = new JButton("Modify Calendar");
		
		closeTSBtn = new JButton("Close TimeSlot");
		
		createMBtn = new JButton("Create Meeting");
		
		meetingSBtn = new JButton("Meeting Schedule");

		//Listeners for all buttons and current window
		modifyBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new SingleCalendarController(cmodel, SingleCalendar.this).modifyCProcess();
				} catch (ParseException e1) {
					
					e1.printStackTrace();
				}
				
			}
			
		});

		closeTSBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new SingleCalendarController(cmodel, SingleCalendar.this).closeTSProcess();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
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
		

		Object[][] dataVector = new Object[cmodel.dateList.size()][cmodel.timeSlots.size()+1];
		SimpleDateFormat dFormat = new SimpleDateFormat("EEE, MMM-dd-yyyy");
	
		for (int i = 0; i < cmodel.dateList.size(); i++) {
			for (int j = 0; j < dataVector[i].length; j++) {
				if (j==0) {
					dataVector[i][j] = dFormat.format(cmodel.dateList.get(i));
				} else {
					dataVector[i][j] = cmodel.timeSlots.get(j-1).startTime;
				}
			}

		}
		Object[] columnIdentifiers = new Object[cmodel.timeSlots.size()+1];
		for (int i = 0; i < columnIdentifiers.length; i++) {
			if (i ==0) {
				columnIdentifiers[i] = "Date";
			} else {
				columnIdentifiers[i] = "Start Time";
			}
		}
		DefaultTableModel dtm = new DefaultTableModel(dataVector, columnIdentifiers);

		timeSlotTable = new JTable(dtm);
		scrollPane.setViewportView(timeSlotTable);
		contentPane.setLayout(gl_contentPane);


	}
}
