package gui;

import jdbc.JdbcConnector;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class Cart extends JFrame {

	private JPanel contentPane;
	private JTextField totalPrice;
	private JCheckBox productCheckBox[];
	private JLabel priceTextField[];
	private JTextField CountTextField;

	int count; // 장바구니 품목 개수
	int check; // 체크 한 상품 개수
	public Cart() {
		setBounds(100, 100, 585, 492);
		setResizable(false); // 프레임사이즈조절 불가능
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216,210, 199));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		// 장바구니 패널
		JPanel cartPanel = new JPanel();
		cartPanel.setBackground(new Color(247, 247, 247));
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
			check = i+1;
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
			// 체크박스 설정 시 리스너
			productCheckBox[i].addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					//체크 되어있을경우
					if (e.getStateChange() == 1) {
						int sell = price;
						int all = Integer.parseInt(totalPrice.getText());
						totalPrice.setText(Integer.toString(all + sell));
						check++;
						CountTextField.setText(Integer.toString(check));
					}
					//체크 안된 경우
					else {
						int sell = price;
						int all = Integer.parseInt(totalPrice.getText());
						totalPrice.setText(Integer.toString(all - sell));
						check--;
						CountTextField.setText(Integer.toString(check));
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
		totalPrice.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 18));
		totalPrice.setBounds(357, 375, 185, 22);
		contentPane.add(totalPrice);
		totalPrice.setColumns(10);
		
		
		// 결제버튼
		JButton paymentBtn = new Rb("\uACB0\uC81C\uD558\uAE30");
		paymentBtn.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 12));
		paymentBtn.setBounds(336, 420, 97, 23);
		paymentBtn.setFocusPainted(false);
		contentPane.add(paymentBtn);
		//장바구니에서 결제 버튼 클릭 시
		paymentBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Payment pay = new Payment();
				pay.setVisible(true);
				dispose();
			}
		});

		// 취소버튼
		JButton cancleBtn = new Rb("\uCDE8 \uC18C");
		cancleBtn.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 12));
		cancleBtn.setBounds(445, 420, 97, 23);
		cancleBtn.setFocusPainted(false);
		contentPane.add(cancleBtn);
		cancleBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 프레임 종료
				dispose();
			}
		});
		//총 금액 라벨
		JLabel totalPriceLabel = new JLabel("\uCD1D \uAE08\uC561");
		totalPriceLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 18));
		totalPriceLabel.setBounds(280, 375, 65, 23);
		contentPane.add(totalPriceLabel);
		
		JLabel cartLabel = new JLabel("C A R T");
		cartLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 25));
		cartLabel.setForeground(new Color(255, 255, 255));
		cartLabel.setBackground(new Color(60, 61, 72));
		cartLabel.setBounds(162, 5, 245, 31);
		cartLabel.setOpaque(true);
		cartLabel.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(cartLabel);
		
		cartPanel.setPreferredSize(new Dimension(550, 596));
		JScrollPane cartScrollPane = new JScrollPane(cartPanel);
		cartScrollPane.setBounds(0, 40, 569, 324);
		contentPane.add(cartScrollPane);
		
		CountTextField = new JTextField();
		CountTextField.setBounds(10, 375, 36, 21);
		contentPane.add(CountTextField);
		CountTextField.setColumns(10);
		
		JLabel totalCount = new JLabel("개");
		totalCount.setBounds(56, 380, 50, 15);
		contentPane.add(totalCount);
	}
}
