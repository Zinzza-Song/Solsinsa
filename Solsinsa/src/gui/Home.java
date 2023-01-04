package gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import jdbc.JdbcConnector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Home extends JFrame {

	private JPanel mainPanel;
	private JTextField idtextField;
	private JTextField pwtextField;
	private JTextField imagebtn1Name;
	private JTextField imagebtn1Price;
	private JTextField imagebtn2Name;
	private JTextField imagebtn2Price;
	private JTextField imagebtn3Name;
	private JTextField imagebtn4name;
	private JTextField imagebtn3Price;
	private JTextField imagebtn4Price;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 653);
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(222, 226, 235));
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		// 홈 화면 스레드
		DressPanel bannerThread = new DressPanel();
		mainPanel.add(bannerThread);

		bannerThread.startThread();
		// 로고 위치
		JPanel mainTitle = new JPanel();
		mainTitle.setBounds(12, 53, 683, 71);
		mainTitle.setBackground(new Color(76, 76, 76));
		mainTitle.setToolTipText("SOLSINSA");
		mainTitle.setBorder(new LineBorder(new Color(34, 41, 55), 3));
		mainPanel.add(mainTitle);
		mainTitle.setLayout(null);

		JLabel mainLogo = new JLabel("SOLSINSA");
		mainLogo.setFont(new Font("���� �������� Bold", Font.BOLD, 40));
		mainLogo.setForeground(new Color(255, 255, 255));
		mainLogo.setBounds(228, 10, 212, 51);
		mainTitle.add(mainLogo);

		// 홈 상단 id, pw 버튼
		idtextField = new JTextField();
		idtextField.setBounds(33, 22, 116, 21);
		mainPanel.add(idtextField);
		idtextField.setColumns(10);

		pwtextField = new JTextField();
		pwtextField.setBounds(184, 21, 116, 21);
		mainPanel.add(pwtextField);
		pwtextField.setColumns(10);

		JLabel idLabel = new JLabel("ID");
		idLabel.setBounds(12, 25, 20, 15);
		mainPanel.add(idLabel);

		JButton loginbtn = new JButton("login");
		loginbtn.setFont(new Font("����", Font.PLAIN, 12));
		loginbtn.setBounds(310, 20, 59, 23);
		mainPanel.add(loginbtn);

		JLabel pwLabel = new JLabel("PW");
		pwLabel.setBounds(159, 24, 20, 15);
		mainPanel.add(pwLabel);

		JButton joinbtn = new JButton("join");
		joinbtn.setFont(new Font("����", Font.PLAIN, 12));
		joinbtn.setBounds(377, 21, 59, 23);
		mainPanel.add(joinbtn);

		// 카테고리 버튼
		JButton CategoryTop = new JButton("TOP");
		CategoryTop.setFont(new Font("���� �������� Bold", Font.PLAIN, 15));
		CategoryTop.setBounds(72, 134, 160, 25);
		mainPanel.add(CategoryTop);

		JButton CategoryBottom = new JButton("BOTTOM");
		CategoryBottom.setFont(new Font("���� �������� Bold", Font.PLAIN, 15));
		CategoryBottom.setBounds(262, 134, 160, 25);
		mainPanel.add(CategoryBottom);

		JButton CategoryOuter = new JButton("OUTER");
		CategoryOuter.setFont(new Font("���� �������� Bold", Font.PLAIN, 15));
		CategoryOuter.setBounds(447, 134, 160, 25);
		mainPanel.add(CategoryOuter);

		// 스크롤 패널의 상품 사진 패널
		JPanel showproductsPanel = new JPanel();
		showproductsPanel.setSize(633, 1000);
		showproductsPanel.setLayout(null);

		// 1번 상품
		JButton imagebtn1 = new JButton("New button");
		imagebtn1.setIcon(new ImageIcon(""));
		// 클릭시 상품 상세정보 페이지 이동
		imagebtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		imagebtn1.setBounds(12, 10, 295, 210);
		showproductsPanel.add(imagebtn1);

		imagebtn1Name = new JTextField();
		imagebtn1Name.setFont(new Font("���� �������� Regular", Font.PLAIN, 12));
		imagebtn1Name.setText("\uC544\uAC00\uC77C");
		imagebtn1Name.setBounds(34, 230, 243, 22);
		showproductsPanel.add(imagebtn1Name);
		imagebtn1Name.setColumns(10);

		imagebtn1Price = new JTextField();
		imagebtn1Price.setText("\uC544\uAC00\uC77C");
		imagebtn1Price.setFont(new Font("���� �������� Regular", Font.PLAIN, 12));
		imagebtn1Price.setColumns(10);
		imagebtn1Price.setBounds(34, 262, 243, 22);
		showproductsPanel.add(imagebtn1Price);

		// 2번 상품
		JButton imagebtn2 = new JButton("New button");
		imagebtn2.setBounds(324, 10, 295, 210);
		showproductsPanel.add(imagebtn2);
		// 클릭시 상품 상세정보 페이지 이동
		imagebtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		imagebtn2Name = new JTextField();
		imagebtn2Name.setText("\uC544\uAC00\uC77C");
		imagebtn2Name.setFont(new Font("���� �������� Regular", Font.PLAIN, 12));
		imagebtn2Name.setColumns(10);
		imagebtn2Name.setBounds(352, 230, 243, 22);
		showproductsPanel.add(imagebtn2Name);

		imagebtn2Price = new JTextField();
		imagebtn2Price.setText("\uC544\uAC00\uC77C");
		imagebtn2Price.setFont(new Font("���� �������� Regular", Font.PLAIN, 12));
		imagebtn2Price.setColumns(10);
		imagebtn2Price.setBounds(352, 262, 243, 22);
		showproductsPanel.add(imagebtn2Price);

		// 3번 상품
		JButton imagebtn3 = new JButton("New button");
		imagebtn3.setBounds(12, 305, 295, 210);
		showproductsPanel.add(imagebtn3);
		// 클릭시 상품 상세정보 페이지 이동
		imagebtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		imagebtn3Name = new JTextField();
		imagebtn3Name.setText("\uC544\uAC00\uC77C");
		imagebtn3Name.setFont(new Font("���� �������� Regular", Font.PLAIN, 12));
		imagebtn3Name.setColumns(10);
		imagebtn3Name.setBounds(34, 525, 243, 22);
		showproductsPanel.add(imagebtn3Name);

		imagebtn3Price = new JTextField();
		imagebtn3Price.setText("\uC544\uAC00\uC77C");
		imagebtn3Price.setFont(new Font("���� �������� Regular", Font.PLAIN, 12));
		imagebtn3Price.setColumns(10);
		imagebtn3Price.setBounds(34, 557, 243, 22);
		showproductsPanel.add(imagebtn3Price);

		// 4번 상품
		JButton imagebtn4 = new JButton("New button");
		imagebtn4.setBounds(324, 305, 295, 210);
		showproductsPanel.add(imagebtn4);
		// 클릭시 상품 상세정보 페이지 이동
		imagebtn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		imagebtn4name = new JTextField();
		imagebtn4name.setText("\uC544\uAC00\uC77C");
		imagebtn4name.setFont(new Font("���� �������� Regular", Font.PLAIN, 12));
		imagebtn4name.setColumns(10);
		imagebtn4name.setBounds(352, 525, 243, 22);
		showproductsPanel.add(imagebtn4name);

		imagebtn4Price = new JTextField();
		imagebtn4Price.setText("\uC544\uAC00\uC77C");
		imagebtn4Price.setFont(new Font("���� �������� Regular", Font.PLAIN, 12));
		imagebtn4Price.setColumns(10);
		imagebtn4Price.setBounds(352, 557, 243, 22);
		showproductsPanel.add(imagebtn4Price);

		showproductsPanel.setPreferredSize(new Dimension(633, 596));

		JScrollPane scrollPane = new JScrollPane(showproductsPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0), 2));
		scrollPane.setBounds(12, 303, 683, 311);

		mainPanel.add(scrollPane);
	}
}