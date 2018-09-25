package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.MeetingController;
import model.CalendarModel;
import model.Meeting;

import javax.swing.JTabbedPane;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;

public class MeetingSchedule extends JFrame {

	private JPanel contentPane;
	JPanel mSchedule, dSchedule;
	public JTextField selectMonth, selectDate;

	public JButton deleteBtn;
	public JList<Meeting> meetingList, monthlyList, dailyList;
	CalendarModel cmodel;
	String month, date;

	public MeetingSchedule(CalendarModel cm) {
		this.cmodel = cm;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup()
						.addGap(1).addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE).addGap(1)));
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup()
						.addGap(1).addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE).addGap(1)));

		JPanel panel = new JPanel();
		tabbedPane.addTab("All Meeting", null, panel, null);

		DefaultListModel<Meeting> dlm = new DefaultListModel<Meeting>();
		cmodel.meetings.forEach(meeting -> dlm.addElement(meeting));
		meetingList = new JList<Meeting>(dlm);

		meetingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		deleteBtn = new JButton("Remove");
		deleteBtn.setEnabled(false);
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// action
				new MeetingController(cmodel, MeetingSchedule.this).deleteProcess();
			}
		});

		meetingList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				new MeetingController(cmodel, MeetingSchedule.this).selectItemProcess();
			}

		});

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(6)
						.addComponent(meetingList, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE).addGap(30)
						.addComponent(deleteBtn, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
						.addGap(24)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(6)
						.addComponent(meetingList, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE).addGap(21))
				.addGroup(gl_panel.createSequentialGroup().addGap(89).addComponent(deleteBtn)));
		panel.setLayout(gl_panel);

		mSchedule = new JPanel();
		tabbedPane.addTab("Monthly", null, mSchedule, null);

		monthlyList = new JList();

		JLabel lblNewLabel = new JLabel("Enter Month:");

		selectMonth = new JTextField();
		selectMonth.setColumns(10);

		selectMonth.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					// update list

					month = selectMonth.getText();
					DefaultListModel<Meeting> dlmMonth = new DefaultListModel<Meeting>();
					dlmMonth.removeAllElements();
					for (int i = 0; i < cmodel.meetings.size(); i++) {
						if (cmodel.meetings.get(i).meetingD.contains(month)) {
							dlmMonth.addElement(cmodel.meetings.get(i));
						} else {
							continue;
						}
					}
					monthlyList.setModel(dlmMonth);

					mSchedule.repaint();

				}
			}

		});

		GroupLayout gl_panel_1 = new GroupLayout(mSchedule);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(6)
						.addComponent(monthlyList, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE).addGap(29)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup().addGap(7).addComponent(lblNewLabel,
										GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
								.addComponent(selectMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(11)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(6)
						.addComponent(monthlyList, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE).addGap(21))
				.addGroup(gl_panel_1.createSequentialGroup().addGap(36).addComponent(lblNewLabel).addGap(21)
						.addComponent(selectMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)));
		mSchedule.setLayout(gl_panel_1);

		dSchedule = new JPanel();
		tabbedPane.addTab("Daily", null, dSchedule, null);

		dailyList = new JList();

		JLabel lblNewLabel_1 = new JLabel("Enter Date");

		selectDate = new JTextField();
		selectDate.setColumns(10);

		selectDate.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					date = selectDate.getText();

					DefaultListModel<Meeting> dlmDate = new DefaultListModel<Meeting>();
					dlmDate.removeAllElements();
					for (int i = 0; i < cmodel.meetings.size(); i++) {
						if (cmodel.meetings.get(i).meetingD.contains(date)) {
							dlmDate.addElement(cmodel.meetings.get(i));
						} else {
							continue;
						}
					}
					dailyList.setModel(dlmDate);

					dSchedule.repaint();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		}

		);
		GroupLayout gl_panel_2 = new GroupLayout(dSchedule);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_2.createSequentialGroup().addContainerGap()
						.addComponent(dailyList, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup().addGap(32).addComponent(selectDate,
										GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_2.createSequentialGroup().addGap(40).addComponent(lblNewLabel_1,
										GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
						.addGap(19)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup().addGap(46).addComponent(lblNewLabel_1)
										.addGap(23).addComponent(selectDate, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_2.createSequentialGroup().addContainerGap().addComponent(dailyList,
										GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)))
						.addGap(27)));
		dSchedule.setLayout(gl_panel_2);
		contentPane.setLayout(gl_contentPane);
	}
}
