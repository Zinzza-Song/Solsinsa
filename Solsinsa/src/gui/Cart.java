package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import client.Client;
import client.Userinfo;

@SuppressWarnings("serial")
public class Cart extends JFrame {

	private JPanel contentPane;
	private JTextField totalPrice;
	private JCheckBox productCheckBox[];
	private JLabel priceTextField[];
	private JTextField CountTextField;
	private ArrayList<String> items;

	int check = 0; // 체크 한 상품 개수
	int sum = 0; // 가격

	public Cart() {
		setBounds(100, 100, 585, 492);
		setResizable(false); // 프레임사이즈조절 불가능
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(216, 210, 199));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		// 장바구니 패널
		JPanel cartPanel = new JPanel();
		cartPanel.setBackground(new Color(247, 247, 247));
		cartPanel.setBounds(0, 40, 569, 324);
		cartPanel.setLayout(null);

		int yCoordinate = 31;

		// 장바구니 품목 개수에 맞춰서 목록 추가 생성
		Client.msg = Integer.toString(Userinfo.getUserInfo().getNo()) + ":1005";

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		String list = Client.ans;
		StringTokenizer st = new StringTokenizer(list, "/");
		int count = st.countTokens();
		productCheckBox = new JCheckBox[count];
		priceTextField = new JLabel[count];

		items = new ArrayList<>();

		for (int i = 0; i < count; ++i) {
			String listItem = st.nextToken();
			StringTokenizer itemst = new StringTokenizer(listItem, ",");
			String itemName = itemst.nextToken();
			int itemPrice = Integer.parseInt(itemst.nextToken());
			int itemNo = Integer.parseInt(itemst.nextToken());

			productCheckBox[i] = new JCheckBox(itemName, false);
			productCheckBox[i].setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 12));
			productCheckBox[i].setBounds(8, yCoordinate, 367, 23);

			cartPanel.add(productCheckBox[i]);

			priceTextField[i] = new JLabel(Integer.toString(itemPrice));
			priceTextField[i].setHorizontalAlignment(SwingConstants.RIGHT); // 글씨 오른쪽 정렬
			priceTextField[i].setBounds(396, yCoordinate, 144, 23);
			yCoordinate += 38;
			cartPanel.add(priceTextField[i]);

			// 체크박스 설정 시 리스너
			productCheckBox[i].addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					// 체크 되어있을경우
					if (e.getStateChange() == 1) {
						sum += itemPrice;
						totalPrice.setText(Integer.toString(sum));
						check++;
						CountTextField.setText(Integer.toString(check));
						items.add(itemNo + "/" + itemName + "/" + itemPrice);
					}
					// 체크 안된 경우
					else {
						sum -= itemPrice;
						totalPrice.setText(Integer.toString(sum));
						check--;
						CountTextField.setText(Integer.toString(check));
						items.remove(itemNo + "/" + itemName + "/" + itemPrice);
					}
				}
			});
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
		// 장바구니에서 결제 버튼 클릭 시
		paymentBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (check != 0) {
					Payment pay = new Payment(items);
					pay.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "1개 이상 선택을 하세요.");
				}
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
		// 총 금액 라벨
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
