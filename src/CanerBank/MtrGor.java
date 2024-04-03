package CanerBank;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;

public class MtrGor{

	private JFrame frame;
	private JTable table;

	public MtrGor() {
		initialize();
	}

	private void initialize() {
		DataBase müsteri1 = new DataBase();
		frame = new JFrame("Müşteri Listesi");
		frame.setBounds(300, 400, 800, 600);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 776, 541);
		frame.getContentPane().add(scrollPane);
		String[] title = {"TCKNO", "Name", "Surname", "Birth", "Address", "Balance", "Password", "Telefon"};

		
		table = new JTable(müsteri1.getAllCustomers(),title);
		table.setForeground(Color.WHITE);
		table.setBackground(Color.BLACK);
		scrollPane.setViewportView(table);

	
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
