package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import model.*;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JList;

public class CloseTimeSlot extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField date;
	private JTextField day;
	private JComboBox<String> timeInterval;

	CalendarModel cmodel;
	boolean updated;

	public JTextField getChosenDate() {
		return date;
	}

	public JTextField getChosenDay() {
		return day;
	}

	public JComboBox<String> getChosenTS() {
		return timeInterval;
	}

	/**
	 * Create the dialog.
	 */
	public CloseTimeSlot(CalendarModel cm) {
		this.cmodel = cm;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblName = new JLabel("Close TimeSlot:");
		lblName.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblName.setBounds(28, 30, 109, 16);
		contentPanel.add(lblName);

		JLabel lblStartDate = new JLabel("Enter Date:");
		lblStartDate.setBounds(71, 78, 97, 16);
		contentPanel.add(lblStartDate);

		JLabel lblEndDate = new JLabel("Enter Day:");
		lblEndDate.setBounds(71, 118, 79, 16);
		contentPanel.add(lblEndDate);

		JLabel lblMeetingDuraton = new JLabel("TimeSlot");
		lblMeetingDuraton.setBounds(71, 158, 86, 16);
		contentPanel.add(lblMeetingDuraton);

		date = new JTextField();
		date.setBounds(226, 73, 130, 26);
		contentPanel.add(date);
		date.setColumns(10);

		day = new JTextField();
		day.setBounds(226, 113, 130, 26);
		contentPanel.add(day);
		day.setColumns(10);
		
		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<String>();
		for (TInterval ti : cmodel.timeSlots) {
			dcbm.addElement(ti.startTime);

		}
		
		timeInterval = new JComboBox<String>(dcbm);
		timeInterval.setBounds(226, 154, 130, 27);
		timeInterval.setSelectedItem(null);
		contentPanel.add(timeInterval);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		okButton.setEnabled(false);
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

		//Listener for buttons and keyboard inputs;
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				updated = true;
				CloseTimeSlot.this.setVisible(false);
				
			}
			
		});
		
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				updated = false;
				CloseTimeSlot.this.setVisible(false);
				
			}
			
		});
		
		date.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				okButton.setEnabled(date.getText().length() > 0);
			}
		});

		day.addKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent e){
				okButton.setEnabled(day.getText().length() > 0);
			}
		});
	}
}
