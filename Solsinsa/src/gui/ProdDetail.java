package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;

public class ProdDetail extends JFrame {

	private JPanel contentPane;

	
	private JTextField FeatureTextField[] = new JTextField[14];
	private JTextField DetailTextField[] = new JTextField[14];
	private String detail[] = {"상품명","가격","재질","핏","촉감","신축성","비침","두께","사이즈","총장","너비","어깨너비","가슴단면","소매길이"};
	/**
	 * Create the frame.
	 */
	public ProdDetail(String category, ImageIcon img, String probName) {
		setBounds(100, 100, 931, 647);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(234, 232, 227));
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
		productimgLabel.setBackground(new Color(255, 255, 255));
		
		JPanel DetailePanel = new JPanel();
		DetailePanel.setBounds(-36, 145, 398, 430);
		productimgPanel.add(DetailePanel);
		DetailePanel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 0, 0)));
		DetailePanel.setLayout(new GridLayout(10, 0, 0, 0));
		// 상품 상세정보
//		JLabel productName = new JLabel("상품명 : ");
//		productName.setFont(new Font("맑은 고딕", Font.BOLD, 22));
//		productName.setBounds(524, 33, 101, 38);
//		contentPane.add(productName);
//
//		JLabel productNameLabel = new JLabel(probName);
//		productNameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 22));
//		productNameLabel.setBounds(613, 30, 319, 38);
//		contentPane.add(productNameLabel);
//
//		JLabel productPriceLabel = new JLabel("New label");
//		productPriceLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
//		productPriceLabel.setBounds(622, 104, 319, 38);
//		contentPane.add(productPriceLabel);
//
//		JLabel productPrice = new JLabel("가격 : ");
//		productPrice.setFont(new Font("맑은 고딕", Font.BOLD, 22));
//		productPrice.setBounds(544, 107, 101, 38);
//		contentPane.add(productPrice);
		// ============================
		// 하단 버튼
		JButton addCartBtn = new Rb("장바구니 담기");
		addCartBtn.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 20));
		addCartBtn.setFocusPainted(false);
		addCartBtn.setBounds(535, 520, 143, 49);
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
		cancelBtn.setBounds(731, 520, 143, 49);
		contentPane.add(cancelBtn);
		
		JPanel FeaturePanel = new JPanel();
		FeaturePanel.setBounds(518, 33, 104, 426);
		contentPane.add(FeaturePanel);
		FeaturePanel.setLayout(new GridLayout(14, 0, 0, 0));
		
		JPanel DetailPanel = new JPanel();
		DetailPanel.setBounds(634, 33, 271, 426);
		contentPane.add(DetailPanel);
		DetailPanel.setLayout(new GridLayout(14, 0, 0, 0));
		
		
		
		for(int i = 0; i < 14; i++) {
			FeatureTextField[i] = new JTextField();
			FeatureTextField[i].setColumns(10);
			FeatureTextField[i].setText(detail[i]);
			FeatureTextField[i].setHorizontalAlignment(JTextField.CENTER);
			FeaturePanel.add(FeatureTextField[i]);
		}	
		
		for(int i = 0; i < 14; i++) {
			DetailTextField[i] = new JTextField();
			DetailTextField[i].setColumns(10);
			DetailTextField[0].setText(probName);
			DetailTextField[i].setHorizontalAlignment(JTextField.CENTER);
			DetailPanel.add(DetailTextField[i]);
		}
		
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
