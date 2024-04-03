package CanerBank;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LogMüsteri {

	private JFrame frame;
	private JTextField tc;
	private JPasswordField sifre;
	
	public LogMüsteri(JFrame fr) {
		initialize(fr);
	}

	private void initialize(JFrame fr) {
		DataBase müsteri1 = new DataBase();
		JFrame frame = new JFrame("Müşteri Girişi");
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(400, 200, 600, 300);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TC/Müşteri No");
		lblNewLabel.setBounds(39, 72, 126, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Şifre");
		lblNewLabel_1.setBounds(39, 108, 47, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton giris = new JButton("Giriş");
		giris.setForeground(new Color(255, 255, 255));
		giris.setBackground(new Color(0, 0, 0));
		giris.setBounds(129, 146, 89, 23);
		frame.getContentPane().add(giris);
		
		
		giris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String klncad = tc.getText();
				String sif = sifre.getText();
				String giris1 = klncad + " " + sif;
				DefaultListModel<String> s1 = new DefaultListModel<String>();
				List<String> sorgu = müsteri1.getAllTCAndPasswords();
				int i = 0;
				for (String element : sorgu) {
					System.out.println(element);
					if(giris1.equals(element)) {
						frame.dispose();
						MüsteriEkranı mEkranı = new MüsteriEkranı(Long.parseLong(klncad), Integer.parseInt(sif));
						System.out.println(element);
						i = 1;
						break;
					}
				}
				if(i== 0) {
					JOptionPane me1 = new JOptionPane();
					me1.showMessageDialog(null, "KULLANICI ADI VEYA ŞİFRE HATALI");
				}
				
			}
		});
		
		tc = new JTextField();
		tc.setBounds(129, 69, 96, 20);
		frame.getContentPane().add(tc);
		tc.setColumns(10);
		
		sifre = new JPasswordField();
		sifre.setBounds(129, 105, 96, 20);
		frame.getContentPane().add(sifre);
		
		JCheckBox göster = new JCheckBox("Şifre göster");
		göster.setForeground(Color.WHITE);
		göster.setBackground(Color.BLACK);
		göster.setBounds(231, 104, 97, 23);
		frame.getContentPane().add(göster);
		
		JButton back = new JButton("Giriş Ekranına Geri Dön");
		back.setForeground(new Color(255, 255, 255));
		back.setBackground(new Color(0, 0, 0));
		back.setBounds(10, 219, 236, 33);
		frame.getContentPane().add(back);
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				fr.setVisible(true);
			}
		});
		
		göster.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(göster.isSelected()) {
					sifre.setEchoChar((char)0);
				}
				else {
					sifre.setEchoChar('*');
				}
				
			}
		});
		
		
		
		frame.setVisible(true);
	}
}
