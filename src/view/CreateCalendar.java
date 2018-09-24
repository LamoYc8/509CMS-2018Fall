package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.CalendarModel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComboBox;
import javax.swing.JList;

public class CreateCalendar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField calendarN;
	private JTextField startDate;
	private JTextField endDate;
	private JComboBox<Integer> intervalBox;
	private JButton okButton;

	CalendarModel calendar;
	boolean updated = false;

	public JTextField getNameField() {
		return calendarN;
	}

	public JTextField getStartDateField() {
		return startDate;
	}

	public JTextField getEndDateField() {
		return endDate;
	}

	public JComboBox getIntervalBox() {
		return intervalBox;
	}

	public JButton getOkBtn() {
		return okButton;
	}

	public boolean wasUpdated() {
		return updated;
	};

	public CreateCalendar() {
		//this.calendar = cm;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblName = new JLabel("Calendar Name: ");
		lblName.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblName.setBounds(44, 37, 109, 16);
		contentPanel.add(lblName);

		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setBounds(44, 78, 97, 16);
		contentPanel.add(lblStartDate);

		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setBounds(44, 118, 79, 16);
		contentPanel.add(lblEndDate);

		JLabel lblMeetingDuraton = new JLabel("TimeSlot Duration");
		lblMeetingDuraton.setBounds(44, 158, 124, 16);
		contentPanel.add(lblMeetingDuraton);

		calendarN = new JTextField();
		calendarN.setBounds(226, 32, 130, 26);
		contentPanel.add(calendarN);
		calendarN.setColumns(10);

		startDate = new JTextField();
		startDate.setBounds(226, 73, 130, 26);
		contentPanel.add(startDate);
		startDate.setColumns(10);

		endDate = new JTextField();
		endDate.setBounds(226, 113, 130, 26);
		contentPanel.add(endDate);
		endDate.setColumns(10);

		intervalBox = new JComboBox<Integer>();
		intervalBox.setBounds(226, 154, 130, 27);
		intervalBox.addItem(10);
		intervalBox.addItem(15);
		intervalBox.addItem(20);
		intervalBox.addItem(30);
		intervalBox.addItem(60);
		intervalBox.setSelectedItem(null);
		contentPanel.add(intervalBox);
		
		JLabel lblNewLabel = new JLabel("minutes");
		lblNewLabel.setBounds(368, 158, 61, 16);
		contentPanel.add(lblNewLabel);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		okButton = new JButton("OK");
		okButton.setEnabled(false);
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

		//Listerner for buttons and textfields
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				updated = true;
				CreateCalendar.this.setVisible(false);

			}

		});

		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updated = false;
				CreateCalendar.this.setVisible(false);

			}
		});

		calendarN.addKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent e){
				okButton.setEnabled(calendarN.getText().length() > 0);
			}
		});

		

	}
}
