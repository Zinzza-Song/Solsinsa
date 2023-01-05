package gui;
import jdbc.JdbcConnector;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class Cart extends JFrame {

	private JPanel contentPane;
	private JTextField totalPrice;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cart frame = new Cart();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Cart() {
		setBounds(100, 100, 585, 492);
		setResizable(false);  //프레임사이즈조절 불가능
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel cartPanel = new JPanel();
		cartPanel.setBounds(0, 40, 569, 324);
		
		cartPanel.setLayout(null);
		
		//구매할 목록 체크하는 체크박스 
		//여기부터
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("\uC0C1\uD488\uBA85");
		chckbxNewCheckBox_1.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 12));
		chckbxNewCheckBox_1.setBounds(8, 31, 367, 23);
		cartPanel.add(chckbxNewCheckBox_1);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setText("\uAC00\uACA9");
		textField_1.setBounds(396, 31, 144, 23);
		cartPanel.add(textField_1);
		textField_1.setColumns(10);
		
		//여기까지 포문 돌리면 될듯?
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("\uC0C1\uD488\uBA85");
		chckbxNewCheckBox_2.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 12));
		chckbxNewCheckBox_2.setBounds(8, 69, 367, 23);
		cartPanel.add(chckbxNewCheckBox_2);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.RIGHT); //글씨 오른쪽 정렬
		textField_2.setText("\uAC00\uACA9");
		textField_2.setColumns(10);
		textField_2.setBounds(396, 69, 144, 23);
		cartPanel.add(textField_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("\uC0C1\uD488\uBA85");
		chckbxNewCheckBox_3.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 12));
		chckbxNewCheckBox_3.setBounds(8, 102, 367, 23);
		cartPanel.add(chckbxNewCheckBox_3);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3.setText("\uAC00\uACA9");
		textField_3.setColumns(10);
		textField_3.setBounds(396, 102, 144, 23);
		cartPanel.add(textField_3);
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("\uC0C1\uD488\uBA85");
		chckbxNewCheckBox_4.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 12));
		chckbxNewCheckBox_4.setBounds(8, 140, 367, 23);
		cartPanel.add(chckbxNewCheckBox_4);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_4.setText("\uAC00\uACA9");
		textField_4.setColumns(10);
		textField_4.setBounds(396, 140, 144, 23);
		cartPanel.add(textField_4);
		
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("\uC0C1\uD488\uBA85");
		chckbxNewCheckBox_5.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 12));
		chckbxNewCheckBox_5.setBounds(8, 179, 367, 23);
		cartPanel.add(chckbxNewCheckBox_5);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_5.setText("\uAC00\uACA9");
		textField_5.setColumns(10);
		textField_5.setBounds(396, 179, 144, 23);
		cartPanel.add(textField_5);
		
		JCheckBox chckbxNewCheckBox_6 = new JCheckBox("\uC0C1\uD488\uBA85");
		chckbxNewCheckBox_6.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 12));
		chckbxNewCheckBox_6.setBounds(8, 217, 367, 23);
		cartPanel.add(chckbxNewCheckBox_6);
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_6.setText("\uAC00\uACA9");
		textField_6.setColumns(10);
		textField_6.setBounds(396, 217, 144, 23);
		cartPanel.add(textField_6);
		
		JCheckBox chckbxNewCheckBox_7 = new JCheckBox("\uC0C1\uD488\uBA85");
		chckbxNewCheckBox_7.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 12));
		chckbxNewCheckBox_7.setBounds(8, 250, 367, 23);
		cartPanel.add(chckbxNewCheckBox_7);
		
		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_7.setText("\uAC00\uACA9");
		textField_7.setColumns(10);
		textField_7.setBounds(396, 250, 144, 23);
		cartPanel.add(textField_7);
		
		JCheckBox chckbxNewCheckBox_8 = new JCheckBox("\uC0C1\uD488\uBA85");
		chckbxNewCheckBox_8.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 12));
		chckbxNewCheckBox_8.setBounds(8, 288, 367, 23);
		cartPanel.add(chckbxNewCheckBox_8);
		
		textField_8 = new JTextField();
		textField_8.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_8.setText("\uAC00\uACA9");
		textField_8.setColumns(10);
		textField_8.setBounds(396, 288, 144, 23);
		cartPanel.add(textField_8);
		
		//까지 상품 목록
		
		//결제버튼
		JButton paymentbtn = new JButton("\uACB0\uC81C\uD558\uAE30");
		paymentbtn.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 12));
		paymentbtn.setBounds(336, 420, 97, 23);
		contentPane.add(paymentbtn);
		paymentbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub	
				
			}
			
		});
		
		//취소버튼
		JButton canclebtn = new JButton("\uCDE8 \uC18C");
		canclebtn.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 12));
		canclebtn.setBounds(445, 420, 97, 23);
		contentPane.add(canclebtn);
		canclebtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub	
				
				//프레임 종료
				dispose();
			}
			
		});
		
		JLabel totalPriceLabel = new JLabel("\uCD1D \uAE08\uC561");
		totalPriceLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 12));
		totalPriceLabel.setBounds(282, 374, 59, 23);
		contentPane.add(totalPriceLabel);
		
		//총 금액 표시 텍스트필드
		totalPrice = new JTextField();
		totalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		totalPrice.setFont(new Font("���� �������� Bold", Font.PLAIN, 18));
		totalPrice.setBounds(357, 375, 185, 22);
		contentPane.add(totalPrice);
		totalPrice.setColumns(10);
		
		JLabel cartLabel = new JLabel("\uC7A5\uBC14\uAD6C\uB2C8");
		cartLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 25));
		cartLabel.setForeground(new Color(255, 255, 255));
		cartLabel.setBackground(new Color(60, 61, 72));
		cartLabel.setBounds(160, 10, 245, 31);
		cartLabel.setOpaque(true);
		cartLabel.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(cartLabel);
		
		cartPanel.setPreferredSize(new Dimension(550, 596));
		JScrollPane cartScrollPane = new JScrollPane(cartPanel);
		cartScrollPane.setBounds(0, 40, 569, 324);
		contentPane.add(cartScrollPane);
	}
}
