package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class ProdDetail extends JFrame {

	private JPanel contentPane;

	Home h = new Home();

	/**
	 * Create the frame.
	 */
	public ProdDetail(String category, ImageIcon img, String probName) {
		setBounds(100, 100, 931, 751);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// 좌측 상품 이미지 패널
		JPanel productimgPanel = new JPanel();
		productimgPanel.setBounds(22, 33, 468, 426);
		contentPane.add(productimgPanel);
		productimgPanel.setLayout(null);
		// 상품 이미지 라벨
		JLabel productimgLabel = new JLabel(img);
		productimgLabel.setBounds(0, 0, 468, 425);
		productimgPanel.add(productimgLabel);
		productimgLabel.setOpaque(true);
		productimgLabel.setBackground(new Color(64, 0, 64));
		// 상품 상세정보
		JLabel productName = new JLabel("상품명 : ");
		productName.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		productName.setBounds(524, 33, 101, 38);
		contentPane.add(productName);

		JLabel productNameLabel = new JLabel(probName);
		productNameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		productNameLabel.setBounds(613, 30, 319, 38);
		contentPane.add(productNameLabel);

		JLabel productPriceLabel = new JLabel("New label");
		productPriceLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		productPriceLabel.setBounds(622, 104, 319, 38);
		contentPane.add(productPriceLabel);

		JLabel productPrice = new JLabel("가격 : ");
		productPrice.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		productPrice.setBounds(544, 107, 101, 38);
		contentPane.add(productPrice);
		// ============================
		// 하단 버튼
		JButton addCartBtn = new JButton("장바구니 담기");
		addCartBtn.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		addCartBtn.setBounds(148, 624, 272, 49);
		contentPane.add(addCartBtn);

		// 장바구니 db 연결 ========================
		addCartBtn.addActionListener(new ActionListener() {
			// 장바구니 담기 클릭 시 장바구니에 추가됨
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				JOptionPane.showMessageDialog(null, "장바구니에 추가되었습니다.");
				dispose();
				Products prod = new Products(category);
				prod.setVisible(true);
			}
		});

		JButton cancelBtn = new JButton("닫기");
		cancelBtn.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		cancelBtn.setBounds(535, 624, 272, 49);
		contentPane.add(cancelBtn);
		
		JLabel productName_1 = new JLabel("상품명 : ");
		productName_1.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		productName_1.setBounds(524, 172, 101, 38);
		contentPane.add(productName_1);
		
		JLabel productNameLabel_1 = new JLabel("<dynamic>");
		productNameLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		productNameLabel_1.setBounds(613, 169, 319, 38);
		contentPane.add(productNameLabel_1);
		
		JLabel productName_2 = new JLabel("상품명 : ");
		productName_2.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		productName_2.setBounds(524, 241, 101, 38);
		contentPane.add(productName_2);
		
		JLabel productNameLabel_2 = new JLabel("<dynamic>");
		productNameLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		productNameLabel_2.setBounds(613, 238, 319, 38);
		contentPane.add(productNameLabel_2);
		
		JLabel productName_3 = new JLabel("상품명 : ");
		productName_3.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		productName_3.setBounds(524, 312, 101, 38);
		contentPane.add(productName_3);
		
		JLabel productNameLabel_3 = new JLabel("<dynamic>");
		productNameLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		productNameLabel_3.setBounds(613, 309, 319, 38);
		contentPane.add(productNameLabel_3);
		
		JLabel productName_4 = new JLabel("상품명 : ");
		productName_4.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		productName_4.setBounds(524, 389, 101, 38);
		contentPane.add(productName_4);
		
		JLabel productNameLabel_4 = new JLabel("<dynamic>");
		productNameLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		productNameLabel_4.setBounds(613, 386, 319, 38);
		contentPane.add(productNameLabel_4);
		
		JLabel productName_5 = new JLabel("상품명 : ");
		productName_5.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		productName_5.setBounds(524, 463, 101, 38);
		contentPane.add(productName_5);
		
		JLabel productNameLabel_5 = new JLabel("<dynamic>");
		productNameLabel_5.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		productNameLabel_5.setBounds(613, 460, 319, 38);
		contentPane.add(productNameLabel_5);
		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Products prod = new Products(category);
				prod.setVisible(true);
				dispose();
			}
		});

	}
}
