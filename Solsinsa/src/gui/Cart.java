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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class Cart extends JFrame {

	private JPanel contentPane;
	private JTextField totalPrice;
	private JCheckBox productCheckBox[];
	private JLabel priceTextField[];

	int count; // 장바구니 품목 개수

	public Cart() {
		setBounds(100, 100, 585, 492);
		setResizable(false); // 프레임사이즈조절 불가능
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		// 장바구니 패널
		JPanel cartPanel = new JPanel();
		cartPanel.setBounds(0, 40, 569, 324);
		cartPanel.setLayout(null);
		

		// 구매할 목록 체크하는 체크박스
		// count는 db에서 장바구니 항목의 개수
		count = 5;
		
		String name[] = { "상품이름1", "상품이름2", "상품이름3", "상품이름4", "상품이름5" };
		int prices[] = { 10000, 20000, 30000, 40000, 50000 };
		int sum = 0;
		int yCoordinate = 31;

		// 장바구니 품목 개수에 맞춰서 목록 추가 생성
		for (int i = 0; i < count; i++) {
			int price = prices[i];
			// 체크 박스
			productCheckBox = new JCheckBox[5];
			productCheckBox[i] = new JCheckBox(name[i], true);
			productCheckBox[i].setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 12));
			productCheckBox[i].setBounds(8, yCoordinate, 367, 23);

			cartPanel.add(productCheckBox[i]);

			// 상품 가격 텍스트필드 (문자열으로 가격 입력)
			priceTextField = new JLabel[5];
			priceTextField[i] = new JLabel(Integer.toString(price));
			priceTextField[i].setHorizontalAlignment(SwingConstants.RIGHT); // 글씨 오른쪽 정렬
			priceTextField[i].setBounds(396, yCoordinate, 144, 23);
			yCoordinate += 38;
			cartPanel.add(priceTextField[i]);
			
			productCheckBox[i].addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					if (e.getStateChange() == 1) {
						int sell = price;
						int all = Integer.parseInt(totalPrice.getText());
						totalPrice.setText(Integer.toString(all + sell));
					}
					else {
						int sell = price;
						int all = Integer.parseInt(totalPrice.getText());
						totalPrice.setText(Integer.toString(all - sell));
						
					}
					
				}
			});
		}
		// 총 금액 표시 텍스트필드 == new JTextField(여기에 금액들의 합 입력)
		for(int price : prices) {
			sum += price;
		}
		totalPrice = new JTextField();
		totalPrice.setText(Integer.toString(sum));
		totalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		totalPrice.setFont(new Font("���� �������� Bold", Font.PLAIN, 18));
		totalPrice.setBounds(357, 375, 185, 22);
		contentPane.add(totalPrice);
		totalPrice.setColumns(10);
		
		
		// 결제버튼
		JButton paymentBtn = new JButton("\uACB0\uC81C\uD558\uAE30");
		paymentBtn.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 12));
		paymentBtn.setBounds(336, 420, 97, 23);
		contentPane.add(paymentBtn);
		paymentBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});

		// 취소버튼
		JButton cancleBtn = new JButton("\uCDE8 \uC18C");
		cancleBtn.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 12));
		cancleBtn.setBounds(445, 420, 97, 23);
		contentPane.add(cancleBtn);
		cancleBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				// 프레임 종료
				dispose();
			}

		});

		JLabel totalPriceLabel = new JLabel("\uCD1D \uAE08\uC561");
		totalPriceLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 12));
		totalPriceLabel.setBounds(282, 374, 59, 23);
		contentPane.add(totalPriceLabel);

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
