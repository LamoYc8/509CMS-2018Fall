package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalendarFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalendarFrame frame = new CalendarFrame();
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
	public CalendarFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Calendars");
		lblNewLabel.setBounds(16, 6, 72, 16);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 27, 329, 245);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(347, 67, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.setBounds(347, 111, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Open");
		btnNewButton_2.setBounds(347, 152, 117, 29);
		contentPane.add(btnNewButton_2);
	}

}
