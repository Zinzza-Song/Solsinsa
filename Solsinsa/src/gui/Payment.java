package gui;

import javax.swing.*;
import javax.swing.border.*;

import client.Userinfo;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Iterator;

public class Payment extends JFrame {

	private JPanel contentPane;

	private JLabel payListNameLabel[]; // 주문목록 상품명 라벨
	private JTextField payPriceTextField[]; // 주문목록 상품 가격
	private JTextField payTotalPrice;

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPanel panel;
	private JLabel payTitleLabel;
	private JPanel panel_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField textField_6;
	private JLabel lblNewLabel_6;
	private HashMap<Integer, String> map;
	
	/**
	 * Create the frame.
	 */
	public Payment(HashMap<Integer, String> map) {

		this.map = map;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 723, 660);
		setResizable(false);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(62, 62, 62));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// 주문/배송지 입력 패널
		JPanel orderPanel = new JPanel();
		orderPanel.setBounds(0, 117, 340, 377);
		orderPanel.setBackground(new Color(255, 255, 255));
		contentPane.add(orderPanel);
		orderPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("주문/배송 정보");
		lblNewLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 121, 28);
		orderPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("주문자");
		lblNewLabel_1.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(12, 68, 57, 28);
		orderPanel.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		textField.setText(Userinfo.getUserInfo().getName());
		textField.setBounds(12, 106, 116, 21);
		orderPanel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		textField_1.setText(Userinfo.getUserInfo().getPhone());
		textField_1.setBounds(153, 106, 158, 21);
		orderPanel.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		textField_2.setText(Userinfo.getUserInfo().getMail());
		textField_2.setBounds(12, 149, 219, 21);
		orderPanel.add(textField_2);
		textField_2.setColumns(10);

		lblNewLabel_2 = new JLabel("배송지 정보");
		lblNewLabel_2.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(12, 211, 116, 28);
		orderPanel.add(lblNewLabel_2);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		textField_3.setText(Userinfo.getUserInfo().getName());
		textField_3.setColumns(10);
		textField_3.setBounds(12, 249, 116, 21);
		orderPanel.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		textField_4.setText(Userinfo.getUserInfo().getPhone());
		textField_4.setColumns(10);
		textField_4.setBounds(153, 249, 158, 21);
		orderPanel.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		textField_5.setText(Userinfo.getUserInfo().getAddr());
		textField_5.setColumns(10);
		textField_5.setBounds(12, 292, 219, 21);
		orderPanel.add(textField_5);
		//

		// 장바구니에서 체크표시된 결제품목의 개수
		int payCount = 5;
		int addHeight = 31;
		// 결제금액의 총 합
		int paySum = 0;

		// 결제리스트 패널
		JPanel payList = new JPanel();
		payList.setBounds(309, 214, 280, 13 * payCount);
		payList.setBackground(new Color(255, 255, 255));
		contentPane.add(payList);
		payList.setLayout(null);
		
//		Iterator<E>

//		for (int i = 0; i < payCount; i++) {
//			// 상품명
//			payListNameLabel = new JLabel[payCount]; // 체크박스에 체크표시된 품목만큼의 라벨생성
//			payListNameLabel[i] = new JLabel(payListName[i]); // 상품명 라벨에 넣기
//			payListNameLabel[i].setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 12)); // 상품명 폰트
//			payListNameLabel[i].setBounds(8, addHeight + 20, 100, 23); // 위치 사이즈
//			// 상품명 패널에 부착
//			payList.add(payListNameLabel[i]);
//
//			// 상품가격
//			int payPrice = payPrices[i]; // 상품가격을 차례대로 넣음
//			payPriceTextField = new JTextField[payCount]; // 가격텍스트필드 몇개인지!
//			payPriceTextField[i] = new JTextField(Integer.toString(payPrice)); // 문자열로 가격 입력함
//			payPriceTextField[i].setHorizontalAlignment(SwingConstants.RIGHT); // 글씨 오른쪽 정렬
//			payPriceTextField[i].setBounds(190, addHeight + 20, 100, 23);
//			// 가격 패널에 부착
//			payList.add(payPriceTextField[i]);
//
//			addHeight += 35; // 위에서부터 위치 떨어지는 정도를 추가
//		}

		// 총 금액 표시 텍스트필드 == new JTextField(여기에 금액들의 합 입력)
//		for (int payPrice : payPrices) {
//			paySum += payPrice;
//		}
		payTotalPrice = new JTextField();
		payTotalPrice.setBounds(478, 260, 175, 22);
		payTotalPrice.setText(Integer.toString(paySum));
		payTotalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		payTotalPrice.setFont(new Font("���� �������� Bold", Font.PLAIN, 18));
		contentPane.add(payTotalPrice);
		payTotalPrice.setColumns(10);

		JLabel totalPriceLabel = new JLabel("\uCD1D \uAE08\uC561");
		totalPriceLabel.setForeground(new Color(255, 255, 255));
		totalPriceLabel.setBounds(352, 260, 301, 22);
		totalPriceLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 20));
		contentPane.add(totalPriceLabel);

		// 스크롤팬
		payList.setPreferredSize(new Dimension(280, 13 * payCount));
		JScrollPane payScrollPane = new JScrollPane(payList);

		lblNewLabel_3 = new JLabel("구매목록");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(12, 10, 121, 28);
		payList.add(lblNewLabel_3);
		payScrollPane.setBounds(342, 0, 320, 250);
		payScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(payScrollPane);

		payTitleLabel = new JLabel("Pay Ment");
		payTitleLabel.setForeground(new Color(255, 255, 255));
		payTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		payTitleLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 30));
		payTitleLabel.setBounds(20, 25, 291, 40);
		contentPane.add(payTitleLabel);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(342, 299, 320, 322);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		lblNewLabel_4 = new JLabel("결제 수단");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(12, 10, 121, 28);
		panel_1.add(lblNewLabel_4);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("무통장입금");
		rdbtnNewRadioButton.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setBounds(12, 57, 121, 38);
		panel_1.add(rdbtnNewRadioButton);

		JLabel lblNewLabel_5 = new JLabel("솔데은행 1111-11-11 예금주 : 솔신사");
		lblNewLabel_5.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 18));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setBounds(35, 101, 257, 28);
		panel_1.add(lblNewLabel_5);

		textField_6 = new JTextField();
		textField_6.setFont(new Font("굴림", Font.PLAIN, 18));
		textField_6.setBounds(136, 152, 156, 28);
		panel_1.add(textField_6);
		textField_6.setColumns(10);

		lblNewLabel_6 = new JLabel("입 금 자 명 : ");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(35, 150, 257, 28);
		panel_1.add(lblNewLabel_6);

		// 결제버튼
		JButton paymentBtn = new Rb("\uACB0\uC81C\uD558\uAE30");
		paymentBtn.setBounds(35, 231, 96, 47);
		panel_1.add(paymentBtn);
		paymentBtn.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 16));
		// 결제버튼 클릭 시 이벤트 처리
		paymentBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "결제하시겠습니까?","결제 여부",JOptionPane.YES_NO_OPTION);
				
				if(result == 0) {
					JOptionPane.showMessageDialog(null,"결제가 완료되었습니다");
					dispose();
				}
				else {
					dispose();
				}
			}
		});
		
		// 취소버튼
		JButton cancleBtn = new Rb("\uCDE8 \uC18C");
		cancleBtn.setBounds(182, 231, 96, 47);
		cancleBtn.setFocusPainted(false);
		panel_1.add(cancleBtn);
		cancleBtn.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 16));
		cancleBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 프레임 종료
				dispose();
			}
		});

	}
}
