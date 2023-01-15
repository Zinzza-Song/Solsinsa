package gui;

import jdbc.JdbcConnector;
import server.Product;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Products extends JFrame {

	private JPanel contentPane;
	JButton productImgBtn[];
	JButton cancleBtn;
	JButton cartBtn;

	ArrayList<Product> products;
	JTextField productName[];
	JTextField productPrice[];
	String Link;
	String probName;

	// 홈 화면에서 카테고리에 따라 사진 변경을 위한 String category 추가
	public Products(int num) {
		if (num == 0) {
			setTitle("TOP");
		} else if (num == 1) {
			setTitle("BOTTOM");
		} else if (num == 2) {
			setTitle("OUTER");
		}
		setBounds(100, 100, 694, 602);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(216, 210, 199));
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// 상품 패널 만들고 스크롤팬안에 패널 넣기
		JPanel productPanel = new JPanel();
		productPanel.setBackground(new Color(234, 232, 227));
		productPanel.setPreferredSize(new Dimension(490, 980));

		JScrollPane productScrollPane = new JScrollPane(productPanel);
		productScrollPane.setBounds(0, 0, 680, 498);
		productPanel.setLayout(null);

		// productImgBth 상품 이미지 넣을 버튼
		// productName 상품 이름
		// productPrice 상품 가격
		productImgBtn = new JButton[12];
		productName = new JTextField[12];
		productPrice = new JTextField[12];
		// x, y 좌표 설정 초기화
		int xBtn1 = 30, xName1 = 22, xPrice1 = 53;
		int xBtn2 = 30, xName2 = 22, xPrice2 = 53;
		int xBtn3 = 30, xName3 = 22, xPrice3 = 53;
		int xBtn4 = 30, xName4 = 22, xPrice4 = 53;

		if (num == 0) {
			for (int i = 0; i < 12; i++) {
				Product prod = products.get(i);
				String pName = prod.getName();
				int ctgNum = prod.getCategory_code();
				int pPrice = prod.getPrice();
				Link = "./src/쇼핑몰 사진/상의/TOP_" + prod.getImg();
				ImageIcon imageIcon = new ImageIcon(Link);
				Image Img = imageIcon.getImage();
				Image changeImg = Img.getScaledInstance(160, 172, Image.SCALE_SMOOTH);
				ImageIcon changeIcon = new ImageIcon(changeImg);

				productImgBtn[i] = new JButton(changeIcon);
				productImgBtn[i].setFocusPainted(false);
				productImgBtn[i].setBackground(new Color(234, 232, 227));
				productImgBtn[i].setOpaque(true);

				productName[i] = new JTextField(pName);
				productPrice[i] = new JTextField(pPrice + " 원");
				// 상품의 카테고리 별 상품 클릭 시 상세정보 페이지 호출
				productImgBtn[i].addActionListener(new ActionListener() {
					// 상품 상세정보 페이지에 상품 사진, 이름 사용을 위해
					// category, imageIcon, probName 파라미터를 사용해
					@Override
					public void actionPerformed(ActionEvent e) {
						ProdDetail productdt = new ProdDetail(prod, ctgNum);
						productdt.setVisible(true);
						setVisible(true);
					}
				});
			}
		} else if (num == 1) {
			for (int i = 12; i < 24; i++) {
				
				Product prod = products.get(i);
				String pName = prod.getName();
				int ctgNum = prod.getCategory_code();
				int pPrice = prod.getPrice();
				
				Link = "./src/쇼핑몰 사진/하의/BOTTOM_" + prod.getImg();
				ImageIcon imageIcon = new ImageIcon(Link);
				Image Img = imageIcon.getImage();
				Image changeImg = Img.getScaledInstance(160, 172, Image.SCALE_SMOOTH);
				ImageIcon changeIcon = new ImageIcon(changeImg);

				productImgBtn[i] = new JButton(changeIcon);
				productName[i] = new JTextField(pName);
				productPrice[i] = new JTextField(pPrice);
				// 상품의 카테고리 별 상품 클릭 시 상세정보 페이지 호출
				productImgBtn[i].addActionListener(new ActionListener() {
					// 상품 상세정보 페이지에 상품 사진, 이름 사용을 위해
					// category, imageIcon, probName 파라미터를 사용해
					@Override
					public void actionPerformed(ActionEvent e) {
						ProdDetail productdt = new ProdDetail(prod, ctgNum);
						productdt.setVisible(true);
						setVisible(true);
					}
				});
			}
		} else if (num == 2) {
			for (int i = 24; i < 36; i++) {

				Product prod = products.get(i);
				String pName = prod.getName();
				int ctgNum = prod.getCategory_code();
				int pPrice = prod.getPrice();

				Link = "./src/쇼핑몰 사진/아우터/OUTER_" + prod.getImg();
				ImageIcon imageIcon = new ImageIcon(Link);
				Image Img = imageIcon.getImage();
				Image changeImg = Img.getScaledInstance(160, 172, Image.SCALE_SMOOTH);
				ImageIcon changeIcon = new ImageIcon(changeImg);

				productImgBtn[i] = new JButton(changeIcon);
				productName[i] = new JTextField(pName);
				productPrice[i] = new JTextField(pPrice);
				// 상품의 카테고리 별 상품 클릭 시 상세정보 페이지 호출
				productImgBtn[i].addActionListener(new ActionListener() {
					// 상품 상세정보 페이지에 상품 사진, 이름 사용을 위해
					// category, imageIcon, probName 파라미터를 사용해
					@Override
					public void actionPerformed(ActionEvent e) {
						ProdDetail productdt = new ProdDetail(prod, ctgNum);
						productdt.setVisible(true);
						setVisible(true);
					}
				});
			}
		}
		for (int i = 0; i < 12; i++) {
			productName[i].setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
			productName[i].setHorizontalAlignment(SwingConstants.CENTER);
			productName[i].setColumns(10);

			productPrice[i].setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
			productPrice[i].setHorizontalAlignment(SwingConstants.CENTER);
			productPrice[i].setColumns(10);

			if (i < 3) {
				productImgBtn[i].setBounds(xBtn1, 20, 160, 172);
				productPanel.add(productImgBtn[i]);
				productName[i].setBounds(xName1, 195, 180, 21);
				productPanel.add(productName[i]);
				productPrice[i].setBounds(xPrice1, 225, 116, 21);
				productPanel.add(productPrice[i]);

				xBtn1 += 222;
				xName1 += 220;
				xPrice1 += 220;
			} else if (i < 6) {
				productImgBtn[i].setBounds(xBtn2, 260, 160, 172);
				productPanel.add(productImgBtn[i]);
				productName[i].setBounds(xName2, 435, 180, 21);
				productPanel.add(productName[i]);
				productPrice[i].setBounds(xPrice2, 465, 116, 21);
				productPanel.add(productPrice[i]);
				xBtn2 += 222;
				xName2 += 220;
				xPrice2 += 220;
			} else if (i < 9) {
				productImgBtn[i].setBounds(xBtn3, 500, 160, 172);
				productPanel.add(productImgBtn[i]);
				productName[i].setBounds(xName3, 675, 180, 21);
				productPanel.add(productName[i]);
				productPrice[i].setBounds(xPrice3, 705, 116, 21);
				productPanel.add(productPrice[i]);
				xBtn3 += 222;
				xName3 += 220;
				xPrice3 += 220;
			} else {
				productImgBtn[i].setBounds(xBtn4, 740, 160, 172);
				productPanel.add(productImgBtn[i]);
				productName[i].setBounds(xName4, 915, 180, 21);
				productPanel.add(productName[i]);
				productPrice[i].setBounds(xPrice4, 945, 116, 21);
				productPanel.add(productPrice[i]);
				xBtn4 += 222;
				xName4 += 220;
				xPrice4 += 220;
			}
		}

		// 닫기 버튼
		cancleBtn = new Rb("닫기");
		cancleBtn.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 24));
		cancleBtn.setBounds(265, 510, 150, 35);
		cancleBtn.setFocusPainted(false);
		contentPane.add(cancleBtn);
		cancleBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}

		});

		productScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(productScrollPane);

	}
}