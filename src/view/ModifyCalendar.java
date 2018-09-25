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

public class ModifyCalendar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JTextField startDate;
	JTextField endDate;
	JButton okButton;
	JButton cancelButton;
	boolean updated;
	CalendarModel cmodel;

	public JTextField getEndDate() {
		return endDate;
	}

	public boolean wasUpdated() {
		return updated;
	}

	public ModifyCalendar(CalendarModel cm) {
		this.cmodel = cm;
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

		startDate = new JTextField(cmodel.getStartDate());
		startDate.setEditable(false);
		startDate.setBounds(226, 76, 130, 26);
		contentPanel.add(startDate);
		startDate.setColumns(10);

		endDate = new JTextField();
		endDate.setBounds(226, 113, 130, 26);
		contentPanel.add(endDate);
		endDate.setColumns(10);

		JLabel calendarN = new JLabel(cmodel.getName());
		calendarN.setBounds(226, 37, 130, 16);
		contentPanel.add(calendarN);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		okButton.setEnabled(false);
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				updated = true;
				ModifyCalendar.this.setVisible(false);

			}

		});

		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updated = false;
				ModifyCalendar.this.setVisible(false);

			}

		});

		endDate.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				okButton.setEnabled(endDate.getText().length() > 0);
			}
		});
	}
}
