package CanerBank;


import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PersonelBilgileri {

	private JFrame frame;
	private JTable table;


	public PersonelBilgileri() {
		initialize();
	}

	private void initialize() {
		DataBase p1 = new DataBase();
		frame = new JFrame("Personel Bilgileri Görüntüle");
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 416, 221);
		frame.getContentPane().add(scrollPane);
		
		String bilgiler[] = p1.getPersonel("personel");
		String[][] dizi = new String[bilgiler.length][]; 

		int i = 0;
		while (i < bilgiler.length) {
		    dizi[i] = bilgiler[i].split(" ");
		    i++;
		}
		
		 String[] columnNames = {"Ad", "Soyad", "Telefon"};
		table = new JTable( dizi, columnNames);
		scrollPane.setViewportView(table);
	
		
		JButton güncelle = new JButton("güncelle");
		güncelle.setBounds(175, 240, 89, 23);
		frame.getContentPane().add(güncelle);
		
		güncelle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 11, 416, 221);
				frame.getContentPane().add(scrollPane);
				
				String bilgiler[] = p1.getPersonel("personel");
				String[][] dizi = new String[bilgiler.length][]; 

				int i = 0;
				while (i < bilgiler.length) {
				    dizi[i] = bilgiler[i].split(" ");
				    i++;
				}
				
				 String[] columnNames = {"Ad", "Soyad", "Telefon"};
				table = new JTable( dizi, columnNames);
				scrollPane.setViewportView(table);
				
			}
		});

		frame.setVisible(true);
	
	}
}
