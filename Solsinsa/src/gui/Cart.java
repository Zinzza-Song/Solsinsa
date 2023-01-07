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
import java.util.ArrayList;
import java.util.List;

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
	private JCheckBox productCheckBox;
	private JTextField priceTextField;
	
	public Cart(String productName) {
		setBounds(100, 100, 585, 492);
		setResizable(false);  //프레임사이즈조절 불가능
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		// 장바구니 패널
		JPanel cartPanel = new JPanel();
		cartPanel.setBounds(0, 40, 569, 324);
		cartPanel.setLayout(null);
		
		//구매할 목록 체크하는 체크박스 
		//여기부터
		int yCoordinate = 31;
		for(int i = 0; i < 5; i++) {
		productCheckBox = new JCheckBox(productName);
		productCheckBox.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 12));
		productCheckBox.setBounds(8, yCoordinate, 367, 23);
		cartPanel.add(productCheckBox);
		
		priceTextField = new JTextField();
		priceTextField.setHorizontalAlignment(SwingConstants.RIGHT); //글씨 오른쪽 정렬
		priceTextField.setText("\uAC00\uACA9");
		priceTextField.setColumns(10);
		priceTextField.setBounds(396, yCoordinate, 144, 23);
		yCoordinate += 38;
		cartPanel.add(priceTextField);
		}
		
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
