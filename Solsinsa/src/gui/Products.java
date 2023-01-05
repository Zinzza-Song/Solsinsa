package gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
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
import java.awt.GridBagConstraints;

import jdbc.JdbcConnector;


public class Products extends JFrame {

	private JPanel contentPane;
	
	private JTextField productName_1;
	private JTextField productPrice_1;
	private JTextField productName_2;
	private JTextField productPrice_2;
	private JTextField productName_3;
	private JTextField productPrice_3;
	private JTextField productName_4;
	private JTextField productPrice_4;
	private JTextField productName_5;
	private JTextField productPrice_5;
	private JTextField productName_6;
	private JTextField productPrice_6;
	private JButton productImgBtn_7;
	private JTextField productName_7;
	private JTextField productPrice_7;
	private JButton productImgBtn_8;
	private JTextField productName_8;
	private JTextField productPrice_8;
	private JButton productImgBtn_9;
	private JTextField productName_9;
	private JTextField productPrice_9;
	private JButton productImgBtn_10;
	private JTextField productName_10;
	private JTextField productPrice_10;
	private JButton productImgBtn_11;
	private JTextField productName_11;
	private JButton productImgBtn_12;
	private JTextField productName_12;
	private JTextField productPrice_12;
	
	public Products() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 694, 602);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton CategoryTop = new JButton("TOP");
		CategoryTop.setBounds(67, 10, 160, 25);
		CategoryTop.setForeground(new Color(255, 255, 255));
		CategoryTop.setBackground(new Color(80, 80, 80));
		CategoryTop.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 15));
		contentPane.add(CategoryTop);
		
		JButton CategoryBottom = new JButton("BOTTOM");
		CategoryBottom.setBounds(257, 10, 160, 25);
		CategoryBottom.setForeground(new Color(255, 255, 255));
		CategoryBottom.setBackground(new Color(80, 80, 80));
		CategoryBottom.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 15));
		contentPane.add(CategoryBottom);
		
		JButton CategoryOuter = new JButton("OUTER");
		CategoryOuter.setBounds(442, 10, 160, 25);
		CategoryOuter.setForeground(new Color(255, 255, 255));
		CategoryOuter.setBackground(new Color(80, 80, 80));
		CategoryOuter.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 15));
		contentPane.add(CategoryOuter);
		
		//상품 패널 만들고 스크롤팬안에 패널 넣기
		
		JPanel productPanel = new JPanel();
		productPanel.setPreferredSize(new Dimension(490, 980));
		
		JScrollPane productScrollPane = new JScrollPane(productPanel);
		productScrollPane.setBounds(12, 45, 663, 498);
		productPanel.setLayout(null);
		
		JButton productImgBtn_1 = new JButton("New button");
		productImgBtn_1.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productImgBtn_1.setBounds(12, 10, 189, 172);
		productPanel.add(productImgBtn_1);
		
		productName_1 = new JTextField();
		productName_1.setHorizontalAlignment(SwingConstants.CENTER);
		productName_1.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productName_1.setBounds(48, 192, 116, 21);
		productPanel.add(productName_1);
		productName_1.setColumns(10);
		
		productPrice_1 = new JTextField();
		productPrice_1.setHorizontalAlignment(SwingConstants.CENTER);
		productPrice_1.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productPrice_1.setText("");
		productPrice_1.setBounds(48, 223, 116, 21);
		productPanel.add(productPrice_1);
		productPrice_1.setColumns(10);
		
		JButton productImgBtn_2 = new JButton("New button");
		productImgBtn_2.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productImgBtn_2.setBounds(226, 10, 189, 172);
		productPanel.add(productImgBtn_2);
		
		productName_2 = new JTextField();
		productName_2.setHorizontalAlignment(SwingConstants.CENTER);
		productName_2.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productName_2.setColumns(10);
		productName_2.setBounds(262, 192, 116, 21);
		productPanel.add(productName_2);
		
		productPrice_2 = new JTextField();
		productPrice_2.setText("");
		productPrice_2.setHorizontalAlignment(SwingConstants.CENTER);
		productPrice_2.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productPrice_2.setColumns(10);
		productPrice_2.setBounds(262, 223, 116, 21);
		productPanel.add(productPrice_2);
		
		JButton productImgBtn_3 = new JButton("New button");
		productImgBtn_3.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productImgBtn_3.setBounds(438, 10, 189, 172);
		productPanel.add(productImgBtn_3);
		
		productName_3 = new JTextField();
		productName_3.setHorizontalAlignment(SwingConstants.CENTER);
		productName_3.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productName_3.setColumns(10);
		productName_3.setBounds(474, 192, 116, 21);
		productPanel.add(productName_3);
		
		productPrice_3 = new JTextField();
		productPrice_3.setText("");
		productPrice_3.setHorizontalAlignment(SwingConstants.CENTER);
		productPrice_3.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productPrice_3.setColumns(10);
		productPrice_3.setBounds(474, 223, 116, 21);
		productPanel.add(productPrice_3);
		
		JButton productImgBtn_4 = new JButton("New button");
		productImgBtn_4.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productImgBtn_4.setBounds(12, 258, 189, 172);
		productPanel.add(productImgBtn_4);
		
		productName_4 = new JTextField();
		productName_4.setHorizontalAlignment(SwingConstants.CENTER);
		productName_4.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productName_4.setColumns(10);
		productName_4.setBounds(48, 440, 116, 21);
		productPanel.add(productName_4);
		
		productPrice_4 = new JTextField();
		productPrice_4.setText("");
		productPrice_4.setHorizontalAlignment(SwingConstants.CENTER);
		productPrice_4.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productPrice_4.setColumns(10);
		productPrice_4.setBounds(48, 471, 116, 21);
		productPanel.add(productPrice_4);
		
		JButton productImgBtn_5 = new JButton("New button");
		productImgBtn_5.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productImgBtn_5.setBounds(226, 258, 189, 172);
		productPanel.add(productImgBtn_5);
		
		productName_5 = new JTextField();
		productName_5.setHorizontalAlignment(SwingConstants.CENTER);
		productName_5.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productName_5.setColumns(10);
		productName_5.setBounds(262, 440, 116, 21);
		productPanel.add(productName_5);
		
		productPrice_5 = new JTextField();
		productPrice_5.setText("");
		productPrice_5.setHorizontalAlignment(SwingConstants.CENTER);
		productPrice_5.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productPrice_5.setColumns(10);
		productPrice_5.setBounds(262, 471, 116, 21);
		productPanel.add(productPrice_5);
		
		JButton productImgBtn_6 = new JButton("New button");
		productImgBtn_6.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productImgBtn_6.setBounds(438, 258, 189, 172);
		productPanel.add(productImgBtn_6);
		
		productName_6 = new JTextField();
		productName_6.setHorizontalAlignment(SwingConstants.CENTER);
		productName_6.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productName_6.setColumns(10);
		productName_6.setBounds(474, 440, 116, 21);
		productPanel.add(productName_6);
		
		productPrice_6 = new JTextField();
		productPrice_6.setText("");
		productPrice_6.setHorizontalAlignment(SwingConstants.CENTER);
		productPrice_6.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productPrice_6.setColumns(10);
		productPrice_6.setBounds(474, 471, 116, 21);
		
		productPanel.add(productPrice_6);
		
		productImgBtn_7 = new JButton("New button");
		productImgBtn_7.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productImgBtn_7.setBounds(12, 502, 189, 172);
		productPanel.add(productImgBtn_7);
		
		productName_7 = new JTextField();
		productName_7.setHorizontalAlignment(SwingConstants.CENTER);
		productName_7.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productName_7.setColumns(10);
		productName_7.setBounds(48, 684, 116, 21);
		productPanel.add(productName_7);
		
		productPrice_7 = new JTextField();
		productPrice_7.setText("");
		productPrice_7.setHorizontalAlignment(SwingConstants.CENTER);
		productPrice_7.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productPrice_7.setColumns(10);
		productPrice_7.setBounds(48, 715, 116, 21);
		productPanel.add(productPrice_7);
		
		productImgBtn_8 = new JButton("New button");
		productImgBtn_8.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productImgBtn_8.setBounds(226, 502, 189, 172);
		productPanel.add(productImgBtn_8);
		
		productName_8 = new JTextField();
		productName_8.setHorizontalAlignment(SwingConstants.CENTER);
		productName_8.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productName_8.setColumns(10);
		productName_8.setBounds(262, 684, 116, 21);
		productPanel.add(productName_8);
		
		productPrice_8 = new JTextField();
		productPrice_8.setText("");
		productPrice_8.setHorizontalAlignment(SwingConstants.CENTER);
		productPrice_8.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productPrice_8.setColumns(10);
		productPrice_8.setBounds(262, 715, 116, 21);
		productPanel.add(productPrice_8);
		
		productImgBtn_9 = new JButton("New button");
		productImgBtn_9.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productImgBtn_9.setBounds(438, 502, 189, 172);
		productPanel.add(productImgBtn_9);
		
		productName_9 = new JTextField();
		productName_9.setHorizontalAlignment(SwingConstants.CENTER);
		productName_9.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productName_9.setColumns(10);
		productName_9.setBounds(474, 684, 116, 21);
		productPanel.add(productName_9);
		
		productPrice_9 = new JTextField();
		productPrice_9.setText("");
		productPrice_9.setHorizontalAlignment(SwingConstants.CENTER);
		productPrice_9.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productPrice_9.setColumns(10);
		productPrice_9.setBounds(474, 715, 116, 21);
		productPanel.add(productPrice_9);
		
		productImgBtn_10 = new JButton("New button");
		productImgBtn_10.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productImgBtn_10.setBounds(12, 750, 189, 172);
		productPanel.add(productImgBtn_10);
		
		productName_10 = new JTextField();
		productName_10.setHorizontalAlignment(SwingConstants.CENTER);
		productName_10.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productName_10.setColumns(10);
		productName_10.setBounds(48, 932, 116, 21);
		productPanel.add(productName_10);
		
		productPrice_10 = new JTextField();
		productPrice_10.setText("");
		productPrice_10.setHorizontalAlignment(SwingConstants.CENTER);
		productPrice_10.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productPrice_10.setColumns(10);
		productPrice_10.setBounds(48, 963, 116, 21);
		productPanel.add(productPrice_10);
		
		productImgBtn_11 = new JButton("New button");
		productImgBtn_11.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productImgBtn_11.setBounds(226, 750, 189, 172);
		productPanel.add(productImgBtn_11);
		
		productName_11 = new JTextField();
		productName_11.setHorizontalAlignment(SwingConstants.CENTER);
		productName_11.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productName_11.setColumns(10);
		productName_11.setBounds(262, 932, 116, 21);
		productPanel.add(productName_11);
		
		JTextField productPrice_11 = new JTextField();
		productPrice_11.setText("");
		productPrice_11.setHorizontalAlignment(SwingConstants.CENTER);
		productPrice_11.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productPrice_11.setColumns(10);
		productPrice_11.setBounds(262, 963, 116, 21);
		productPanel.add(productPrice_11);
		
		productImgBtn_12 = new JButton("New button");
		productImgBtn_12.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productImgBtn_12.setBounds(438, 750, 189, 172);
		productPanel.add(productImgBtn_12);
		
		productName_12 = new JTextField();
		productName_12.setHorizontalAlignment(SwingConstants.CENTER);
		productName_12.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productName_12.setColumns(10);
		productName_12.setBounds(474, 932, 116, 21);
		productPanel.add(productName_12);
		
		productPrice_12 = new JTextField();
		productPrice_12.setText("");
		productPrice_12.setHorizontalAlignment(SwingConstants.CENTER);
		productPrice_12.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
		productPrice_12.setColumns(10);
		productPrice_12.setBounds(474, 963, 116, 21);
		productPanel.add(productPrice_12);
		productScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(productScrollPane);
		contentPane.add(productScrollPane);
		
		
		
	}
}
