package CanerBank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class Raporlama {

	private JFrame frame;

	public Raporlama() {
		initialize();
	}

	private void initialize() {
		DataBase per1 = new DataBase();
		frame = new JFrame("Raporlama");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		
		JLabel tit = new JLabel("Lütfen Gündelik Rapor Bilgisini Okunaklı Olarak Gönderiniz.");
		tit.setFont(new Font("Times New Roman", Font.BOLD, 13));
		tit.setHorizontalAlignment(SwingConstants.CENTER);
		tit.setBounds(10, 11, 416, 40);
		frame.getContentPane().add(tit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 62, 361, 132);
		frame.getContentPane().add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		textPane.setForeground(Color.WHITE);
		textPane.setBackground(Color.BLACK);
		scrollPane.setViewportView(textPane);
		
		JButton gönder = new JButton("GÖNDER");
		gönder.setForeground(Color.WHITE);
		gönder.setBackground(Color.BLACK);
		gönder.setBounds(171, 212, 102, 40);
		frame.getContentPane().add(gönder);
		
		gönder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				HashMap<Integer, String> raporMap = new HashMap<>();
				raporMap = per1.getRapor();
				int id = 0;
				for (Integer reportId : raporMap.keySet()) {
		            String rapor = raporMap.get(reportId);
		            System.out.println("Report ID: " + reportId + ", Rapor: " + rapor);
		            id = reportId;
		        }
		        String rapor = textPane.getText();
		        per1.setRapor(id+1, rapor);
		        tit.setText("Başarıyla Gönderildi.");
				
			}
		});
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
	}
}
