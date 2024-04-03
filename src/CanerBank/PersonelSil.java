package CanerBank;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class PersonelSil {

	private JFrame frame;
	private JTextField tcal;

	public PersonelSil() {
		initialize();
	}

	private void initialize() {
		DataBase db1 = new DataBase();
		frame = new JFrame("Personel Sil");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TC Giriniz: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 74, 149, 65);
		frame.getContentPane().add(lblNewLabel);
		
		JButton sil = new JButton("SİL");
		sil.setForeground(Color.WHITE);
		sil.setBackground(Color.BLACK);
		sil.setBounds(170, 150, 149, 65);
		frame.getContentPane().add(sil);
	
		
		tcal = new JTextField();
		tcal.setForeground(Color.WHITE);
		tcal.setBackground(Color.BLACK);
		tcal.setBounds(170, 74, 149, 65);
		frame.getContentPane().add(tcal);
		tcal.setColumns(10);
		
		JLabel sonuc = new JLabel("");
		sonuc.setForeground(Color.GREEN);
		sonuc.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		sonuc.setHorizontalAlignment(SwingConstants.CENTER);
		sonuc.setBounds(10, 21, 416, 36);
		frame.getContentPane().add(sonuc);
		frame.setVisible(true);
		
		sil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				db1.delete_per(Long.parseLong(tcal.getText()));
				sonuc.setText("Başarıyla Silindi");
				
			}
		});
		
		
	}

}
