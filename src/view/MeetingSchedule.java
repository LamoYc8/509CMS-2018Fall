package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MeetingSchedule extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MeetingSchedule frame = new MeetingSchedule();
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
	public MeetingSchedule() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel allSchedule = new JPanel();
		tabbedPane.addTab("All", null, allSchedule, null);
		allSchedule.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(6, 6, 360, 287);
		allSchedule.add(scrollPane_2);
		
		JList list_2 = new JList();
		scrollPane_2.setViewportView(list_2);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setBounds(375, 81, 117, 29);
		allSchedule.add(btnNewButton);
		
		JPanel mSchedule = new JPanel();
		tabbedPane.addTab("Monthly Schedule", null, mSchedule, null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JList list_1 = new JList();
		scrollPane_1.setViewportView(list_1);
		
		JLabel lblNewLabel_1 = new JLabel("Choose Month");
		
		JComboBox comboBox_1 = new JComboBox();
		GroupLayout gl_mSchedule = new GroupLayout(mSchedule);
		gl_mSchedule.setHorizontalGroup(
			gl_mSchedule.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_mSchedule.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_mSchedule.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_mSchedule.createSequentialGroup()
							.addComponent(comboBox_1, 0, 110, Short.MAX_VALUE)
							.addGap(6))
						.addGroup(gl_mSchedule.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_mSchedule.setVerticalGroup(
			gl_mSchedule.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mSchedule.createSequentialGroup()
					.addGroup(gl_mSchedule.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_mSchedule.createSequentialGroup()
							.addGap(63)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_mSchedule.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(8, Short.MAX_VALUE))
		);
		mSchedule.setLayout(gl_mSchedule);
		
		JPanel dSchedule = new JPanel();
		tabbedPane.addTab("Daily Schedule", null, dSchedule, null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JLabel lblNewLabel = new JLabel("Choose Date");
		
		JComboBox comboBox = new JComboBox();
		GroupLayout gl_dSchedule = new GroupLayout(dSchedule);
		gl_dSchedule.setHorizontalGroup(
			gl_dSchedule.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_dSchedule.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
					.addGap(12)
					.addGroup(gl_dSchedule.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_dSchedule.createSequentialGroup()
							.addGap(8)
							.addComponent(lblNewLabel))
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
					.addGap(1))
		);
		gl_dSchedule.setVerticalGroup(
			gl_dSchedule.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dSchedule.createSequentialGroup()
					.addGap(45)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(190))
				.addGroup(gl_dSchedule.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
					.addContainerGap())
		);
		dSchedule.setLayout(gl_dSchedule);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
