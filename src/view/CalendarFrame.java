package view;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.*;
import controller.*;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class CalendarFrame extends JFrame {

	private JPanel contentPane;

	JButton	createButton;
	JButton deleteButton;
	JButton	openButton;
	JList<CalendarModel> calendarList;
	Model model;

	//Capacity that get attributes
	public JButton getCreateBtn() {	return createButton;}
	public JButton getdeleteBtn() {	return deleteButton;}
	public JButton getOpenBtn() {	return openButton;}

	public JList<CalendarModel> getCalendarList() { return calendarList;}


	public CalendarFrame(Model m) {
		this.model = m;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Calendars:");
		
		JScrollPane scrollPane = new JScrollPane();
		
		//Calendar List 
		calendarList = new JList<CalendarModel>();
		calendarList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(calendarList);
		

		//Set up three buttons 
		createButton = new JButton("Create");

		deleteButton = new JButton("Delete");
		deleteButton.setEnabled(false);

		openButton = new JButton("Open");
		openButton.setEnabled(false);

		//Listener for buttons
		createButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new FirstViewController(model, CalendarFrame.this).createProcess();
				} catch (ParseException e1) {
					
					e1.printStackTrace();
				}
				
			}
			
		});
		
		deleteButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new FirstViewController(model, CalendarFrame.this).deleteProcess();
			}

		});

		openButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new FirstViewController(model, CalendarFrame.this).openProcess();
			}

		});

		//Listener for JList
		calendarList.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent e) {
				new FirstViewController(model, CalendarFrame.this).selectItemProcess();
			}
			
		});

		
		

		
		
		

		//groupLayout
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(createButton, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
						.addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
						.addComponent(openButton, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
					.addGap(27))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(lblNewLabel)
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(40)
							.addComponent(createButton)
							.addGap(15)
							.addComponent(deleteButton)
							.addGap(12)
							.addComponent(openButton))))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
