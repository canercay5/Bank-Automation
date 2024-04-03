package CanerBank;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class LogYönetici {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	
	public LogYönetici(JFrame fr) {
		initialize(fr);
	}

	private void initialize(JFrame fr) {
		DataBase db1 = new DataBase();
		frame = new JFrame("Yönetici Girişi");
		frame.setBounds(400, 200, 600, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TC/Müşteri No");
		lblNewLabel.setBounds(39, 72, 126, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Şifre");
		lblNewLabel_1.setBounds(39, 108, 47, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Giriş");
		
		btnNewButton.setBounds(129, 146, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(129, 69, 96, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(129, 105, 96, 20);
		frame.getContentPane().add(passwordField);
		
		JCheckBox göster = new JCheckBox("Şifre göster");
		göster.setBounds(231, 104, 97, 23);
		frame.getContentPane().add(göster);
		frame.setVisible(true);
		
		göster.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(göster.isSelected()) {
					passwordField.setEchoChar((char)0);
				}
				else {
					passwordField.setEchoChar('*');
				}
				
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String klncad = textField.getText();
		        String sif = passwordField.getText();
		        String giris1 = klncad + " " + sif;
		        DefaultListModel<String> s1 = new DefaultListModel<String>();
		        List<String> sorgu = db1.adminGiris();
		        int i = 0;
		        for (String element : sorgu) {
		            System.out.println(element);
		            if (giris1.equals(element)) {
		            	i = 1;
		                SwingUtilities.invokeLater(() -> {
		                	frame.dispose();
		                    Yönetici p1 = new Yönetici(frame);
		                });
		                System.out.println(element);
		            }
		        }
		        if(i == 0) {
		        	JOptionPane p1 = new JOptionPane();
		        	p1.showMessageDialog(null, "KULLANICI ADI VEYA ŞİFRE HATALI");
		        }
		    }
		});
		
		JButton back = new JButton("Giriş Ekranına Geri Dön");
		back.setBounds(10, 219, 236, 33);
		frame.getContentPane().add(back);
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				fr.setVisible(true);
			}
		});
	}
}
