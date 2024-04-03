package CanerBank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JInternalFrame;

public class Login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	private void initialize() {
		DataBase db1 = new DataBase();
		frame = new JFrame("Caner Bank Giriş Ekranı");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.setResizable(false);
		frame.setBounds(400, 200, 683, 359);
		
		frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                String[] puanOptions = {"1", "2", "3", "4", "5"};
                JComboBox<String> puanComboBox = new JComboBox<>(puanOptions);
                JTextArea feedbackTextArea = new JTextArea(5, 20);

                Object[] message = {
                        "Soru 1: Uygulamamızı 5 üzerinden nasıl puanlarsınız?",
                        puanComboBox,
                        "\nSoru 2: Geri bildirim yapar mısınız?",
                        feedbackTextArea
                };

                int choice = JOptionPane.showConfirmDialog(
                        frame,
                        message,
                        "Anket, Değerlendirmeniz için teşekkür ederiz.",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE);
                if (choice == JOptionPane.OK_OPTION) {
                    
                    int puan = Integer.parseInt((String) puanComboBox.getSelectedItem());
                    String feedback = feedbackTextArea.getText();
                    db1.insertAnket(puan, feedback);
                }
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
		});		
		JButton btnNewButton = new JButton("Personel");
		btnNewButton.setBounds(241, 86, 200, 100);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LogPersonel personel = new LogPersonel(frame);
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnMteri = new JButton("Müşteri");
		btnMteri.setBounds(10, 86, 200, 100);
		btnMteri.setForeground(new Color(255, 255, 255));
		btnMteri.setBackground(new Color(0, 0, 0));
		btnMteri.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		
		btnMteri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LogMüsteri müsteri = new LogMüsteri(frame);
				
			}
		});
		frame.getContentPane().add(btnMteri);
		
		JButton btnYnetici = new JButton("Yönetici");
		btnYnetici.setBounds(459, 86, 200, 100);
		btnYnetici.setForeground(new Color(255, 255, 255));
		btnYnetici.setBackground(new Color(0, 0, 0));
		btnYnetici.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		frame.getContentPane().add(btnYnetici);
		
		btnYnetici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LogYönetici yönetici = new LogYönetici(frame);
			}
		});
		
		JLabel lblNewLabel = new JLabel("CANER BANK HOŞ GELDİNİZ LÜTFEN GİRİŞ TÜRÜ SEÇİNİZ");
		lblNewLabel.setBounds(10, 11, 649, 41);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel mesag = new JLabel("BİZİ TERCİH ETTİĞİNİZ İÇİN TEŞEKKÜRLER, LÜTFEN SİZE UYGUN OLAN GİRİŞ TÜRÜNÜ SEÇİNİZ");
		mesag.setBounds(10, 197, 649, 114);
		mesag.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		mesag.setForeground(Color.BLACK);
		mesag.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(mesag);
		
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
