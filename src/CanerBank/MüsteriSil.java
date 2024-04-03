package CanerBank;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;

public class MüsteriSil {

	private JFrame frame;
	private JTextField textField;
	private JLabel sonuc;

	public MüsteriSil() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("Müşteri Silme Ekranı");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(500, 500, 450, 300);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Müşteri Sil");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(142, 133, 148, 38);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DataBase db1 = new DataBase();
				db1.delete(Long.parseLong(textField.getText()));
				sonuc.setText("Müşteri Başarıyla Silindi");
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("T.C. Kimlik Numarası");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 58, 132, 44);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setBackground(Color.BLACK);
		textField.setBounds(152, 64, 122, 32);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		sonuc = new JLabel("");
		sonuc.setForeground(Color.RED);
		sonuc.setHorizontalAlignment(SwingConstants.CENTER);
		sonuc.setBounds(107, 182, 209, 44);
		frame.getContentPane().add(sonuc);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
	}
}
