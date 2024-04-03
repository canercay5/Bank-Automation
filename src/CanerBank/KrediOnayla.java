package CanerBank;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KrediOnayla {

	private JFrame frame;
	private JTable table;
	private JTextField tcgir;
	private JButton onay;
	private JLabel lblNewLabel;
	private JLabel sonuc;

	public KrediOnayla() {
		initialize();
	}


	private void initialize() {
		DataBase db1 = new DataBase();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 416, 137);
		frame.getContentPane().add(scrollPane);
		String[] title = {"TCKNO", "Kredi", "Durum"};
		
		table = new JTable(db1.getAllCreditInfo(),title);
		scrollPane.setViewportView(table);
		
		tcgir = new JTextField();
		tcgir.setBounds(39, 182, 162, 42);
		frame.getContentPane().add(tcgir);
		tcgir.setColumns(10);
		
		onay = new JButton("ONAYLA");
		onay.setBounds(235, 182, 136, 42);
		frame.getContentPane().add(onay);
		
		onay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				db1.changeDurum(Long.parseLong(tcgir.getText()), true);
				sonuc.setText(tcgir.getText()+" için kredi onaylandı.");
				
			}
		});
		
		lblNewLabel = new JLabel("T.C Giriniz: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(55, 159, 127, 22);
		frame.getContentPane().add(lblNewLabel);
		
		sonuc = new JLabel("");
		sonuc.setHorizontalAlignment(SwingConstants.CENTER);
		sonuc.setForeground(Color.RED);
		sonuc.setBounds(10, 237, 416, 26);
		frame.getContentPane().add(sonuc);
	}

}
