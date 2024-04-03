package CanerBank;

import java.awt.EventQueue;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.Color;

public class PerGor {

	private JFrame frame;
	private JTable table;

	public PerGor() {
		initialize();
	}
	
	private void initialize() {
		DataBase per1 = new DataBase();
		frame = new JFrame();
		frame.setBounds(300, 300, 800, 600);
		frame.getContentPane().setLayout(null);

		String perL[] = per1.getEmployees();
		
		DefaultListModel<String> s = new DefaultListModel<>();
		for (int i=0; i<perL.length; i++) {
			s.addElement(perL[i]);
			
		}

		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 766, 541);
		frame.getContentPane().add(scrollPane_1);
		
		
		
		String[][] d = per1.getAllEmployees();
		String[] f1 = {"TC", "AD", "SOYAD","DOĞUM TARİHİ","ADRES","MAAŞ","ŞİFRE","TELEFON"};
		table = new JTable(d,f1);
		table.setForeground(Color.WHITE);
		table.setBackground(Color.BLACK);
		scrollPane_1.setViewportView(table);
		
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
