package CanerBank;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class PersonelEkle {

	private JFrame frame;
	private JTextField tckno;
	private JTextField nam;
	private JTextField srname;
	private JTextField brth;
	private JTextField adres;
	private JTextField salar;
	private JTextField passwor;
	private JTextField telefonNo;
	public PersonelEkle() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 375);
		frame.getContentPane().setLayout(null);
		
		JLabel TCKNO = new JLabel("TCKNO");
		TCKNO.setHorizontalAlignment(SwingConstants.CENTER);
		TCKNO.setBounds(10, 11, 99, 31);
		frame.getContentPane().add(TCKNO);
		
		JLabel Name = new JLabel("Name");
		Name.setHorizontalAlignment(SwingConstants.CENTER);
		Name.setBounds(10, 53, 99, 22);
		frame.getContentPane().add(Name);
		
		JLabel Surname = new JLabel("Surname");
		Surname.setHorizontalAlignment(SwingConstants.CENTER);
		Surname.setBounds(10, 86, 99, 22);
		frame.getContentPane().add(Surname);
		
		JLabel birth = new JLabel("birth");
		birth.setHorizontalAlignment(SwingConstants.CENTER);
		birth.setBounds(10, 119, 99, 22);
		frame.getContentPane().add(birth);
		
		JLabel address = new JLabel("address");
		address.setHorizontalAlignment(SwingConstants.CENTER);
		address.setBounds(10, 152, 99, 22);
		frame.getContentPane().add(address);
		
		JLabel salary = new JLabel("salary");
		salary.setHorizontalAlignment(SwingConstants.CENTER);
		salary.setBounds(10, 185, 99, 22);
		frame.getContentPane().add(salary);
		
		JLabel password = new JLabel("password");
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setBounds(10, 218, 99, 22);
		frame.getContentPane().add(password);
		
		tckno = new JTextField();
		tckno.setForeground(Color.WHITE);
		tckno.setBackground(Color.BLACK);
		tckno.setBounds(119, 16, 96, 20);
		frame.getContentPane().add(tckno);
		tckno.setColumns(20);
		
		nam = new JTextField();
		nam.setForeground(Color.WHITE);
		nam.setBackground(Color.BLACK);
		nam.setColumns(10);
		nam.setBounds(119, 54, 96, 20);
		frame.getContentPane().add(nam);
		
		srname = new JTextField();
		srname.setForeground(Color.WHITE);
		srname.setBackground(Color.BLACK);
		srname.setColumns(10);
		srname.setBounds(119, 87, 96, 20);
		frame.getContentPane().add(srname);
		
		brth = new JTextField();
		brth.setForeground(Color.WHITE);
		brth.setBackground(Color.BLACK);
		brth.setColumns(10);
		brth.setBounds(119, 120, 96, 20);
		frame.getContentPane().add(brth);
		
		adres = new JTextField();
		adres.setForeground(Color.WHITE);
		adres.setBackground(Color.BLACK);
		adres.setColumns(10);
		adres.setBounds(119, 153, 96, 20);
		frame.getContentPane().add(adres);
		
		salar = new JTextField();
		salar.setForeground(Color.WHITE);
		salar.setBackground(Color.BLACK);
		salar.setColumns(10);
		salar.setBounds(119, 186, 96, 20);
		frame.getContentPane().add(salar);
		
		passwor = new JTextField();
		passwor.setForeground(Color.WHITE);
		passwor.setBackground(Color.BLACK);
		passwor.setColumns(10);
		passwor.setBounds(119, 219, 96, 20);
		frame.getContentPane().add(passwor);
		
		JButton kaydet = new JButton("KAYDET");
		kaydet.setForeground(Color.WHITE);
		kaydet.setBackground(Color.BLACK);
		kaydet.setBounds(119, 304, 89, 23);
		frame.getContentPane().add(kaydet);
		
		JLabel telefonLabel = new JLabel("Telefon NO:");
		telefonLabel.setHorizontalAlignment(SwingConstants.CENTER);
		telefonLabel.setBounds(10, 251, 99, 22);
		frame.getContentPane().add(telefonLabel);
		
		telefonNo = new JTextField();
		telefonNo.setForeground(Color.WHITE);
		telefonNo.setBackground(Color.BLACK);
		telefonNo.setColumns(10);
		telefonNo.setBounds(119, 250, 96, 20);
		frame.getContentPane().add(telefonNo);
		kaydet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Long tckno1 = Long.parseLong(tckno.getText());
				String name1 = nam.getText();
				String surname1 = srname.getText();
				String birth1 = brth.getText();
				String adrs = address.getText();
				int salr = Integer.parseInt(salar.getText());
				int pswrd = Integer.parseInt(passwor.getText());
				String telefon = telefonNo.getText();
				DataBase dataBase = new DataBase();
                dataBase.insert_per(tckno1, name1, surname1, birth1, adrs, salr, pswrd,telefon);
			}
		});
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
	}

}
