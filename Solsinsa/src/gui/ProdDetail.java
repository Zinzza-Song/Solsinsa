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
import javax.swing.SwingConstants;

public class ProdDetail extends JFrame {

	private JPanel contentPane;

	Home h = new Home();
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public ProdDetail(String category, ImageIcon img, String probName) {
		setBounds(100, 100, 931, 751);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216,210,199));
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
		productimgLabel.setBackground(new Color(255, 255, 255));
		// 상품 상세정보
		JLabel productName = new JLabel("상품명 : ");
		productName.setHorizontalAlignment(SwingConstants.RIGHT);
		productName.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 22));
		productName.setBounds(502, 48, 78, 38);
		contentPane.add(productName);

		JLabel productNameLabel = new JLabel(probName);
		productNameLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 16));
		productNameLabel.setBounds(592, 48, 290, 38);
		contentPane.add(productNameLabel);

		JLabel productPriceLabel = new JLabel("New label");
		productPriceLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 24));
		productPriceLabel.setBounds(592, 95, 290, 38);
		contentPane.add(productPriceLabel);

		JLabel productPrice = new JLabel("가격 : ");
		productPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		productPrice.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 22));
		productPrice.setBounds(502, 96, 78, 38);
		contentPane.add(productPrice);

		JLabel producDetail = new JLabel("상품정보");
		producDetail.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 22));
		producDetail.setBounds(502, 238, 78, 38);
		contentPane.add(producDetail);
		// ============================
		// 하단 버튼
		JButton addCartBtn = new Rb("장바구니 담기");
		addCartBtn.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 30));
		addCartBtn.setFocusPainted(false);
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

		JButton cancelBtn = new Rb("닫기"); 
		cancelBtn.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 30));
		cancelBtn.setFocusPainted(false);
		cancelBtn.setBounds(535, 624, 272, 49);
		contentPane.add(cancelBtn);

		textField = new JTextField();
		textField.setBounds(613, 245, 208, 214);
		contentPane.add(textField);
		textField.setColumns(10);
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
