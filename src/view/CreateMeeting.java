package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.CalendarModel;
import model.TInterval;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JList;

public class CreateMeeting extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField personN;
	public JComboBox<String> selectDate, selectTS;

	CalendarModel cmodel;
	boolean updated;

	public boolean wasUpdated() {
		return updated;
	}

	/**
	 * Create the dialog.
	 */
	public CreateMeeting(CalendarModel cm) {
		this.cmodel = cm;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblName = new JLabel("Person Name: ");
		lblName.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblName.setBounds(44, 37, 109, 16);
		contentPanel.add(lblName);

		JLabel lblStartDate = new JLabel("Select Date");
		lblStartDate.setBounds(44, 78, 97, 16);
		contentPanel.add(lblStartDate);

		JLabel lblEndDate = new JLabel("Select TimeSlot");
		lblEndDate.setBounds(44, 118, 109, 16);
		contentPanel.add(lblEndDate);

		personN = new JTextField();
		personN.setBounds(226, 32, 130, 26);
		contentPanel.add(personN);
		personN.setColumns(10);
		
		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<String>();
		for (Date date : cmodel.dateList) {
			SimpleDateFormat dFormat = new SimpleDateFormat("EEE, MMM-dd-yyyy");
			dcbm.addElement(dFormat.format(date));
		}
		selectDate = new JComboBox<String>(dcbm);
		selectDate.setBounds(226, 74, 130, 27);
		selectDate.setSelectedItem(null);
		contentPanel.add(selectDate);
		

		DefaultComboBoxModel<String> dcbm_1 = new DefaultComboBoxModel<String>();
		for (TInterval ti : cmodel.timeSlots) {
			dcbm_1.addElement(ti.startTime);
		}
		selectTS = new JComboBox<String>(dcbm_1);
		selectTS.setBounds(226, 114, 130, 27);
		selectTS.setSelectedItem(null);
		contentPanel.add(selectTS);

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


		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				updated = true;
				CreateMeeting.this.setVisible(false);
				
			}
			
		});

		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				updated = false;
				CreateMeeting.this.setVisible(false);
				
			}
			
		});

		personN.addKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent e) {
				okButton.setEnabled(personN.getText().length() > 0);
			}
		});
	}
}
