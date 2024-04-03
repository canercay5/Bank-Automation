package CanerBank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import java.awt.Color;

public class RaporlarıOku {

	private JFrame frame;
	private JTable table;

	public RaporlarıOku() {
		initialize();
	}
	
	private void initialize() {
		DataBase db1 = new DataBase();
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 724, 414);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 690, 355);
		frame.getContentPane().add(scrollPane);
		String[]d = {"Rapor No","Rapor Dökümü"};
		
		table = new JTable(db1.getAllReports(), d) ;
		table.setForeground(Color.WHITE);
		table.setBackground(Color.BLACK);
		scrollPane.setViewportView(table);
		frame.setVisible(true);
		
		TableColumnModel columnModel= table.getColumnModel();
		columnModel.getColumn(0).setMinWidth(1);
        columnModel.getColumn(0).setMaxWidth(100);
		
		
		
	}

}
