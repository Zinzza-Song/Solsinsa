package gui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.*;
import javax.swing.border.*;

import client.Client;
import client.Userinfo;

public class Home extends JFrame {

	JPanel inputPanel;
	private JPanel contentPane;
	private JTextField idtextField;
	private JPasswordField pwtextField;
	private JButton productJbtn[];
	private JTextField imageJbtnName[];
	private JTextField imageJbtnPrice[];
	private ImageIcon imgIcon[] = new ImageIcon[4];

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Home frame = new Home();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 723, 653);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216, 210, 199));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		// 스레드 패널
		DressPanel banner = new DressPanel();
		contentPane.add(banner);

		banner.startThread();

		// 쇼핑몰 이름 패널
		JPanel homeName = new JPanel();
		homeName.setBounds(12, 53, 683, 71);
		homeName.setBackground(new Color(76, 76, 76));
		homeName.setToolTipText("SOLSINSA");
		homeName.setBorder(new LineBorder(new Color(34, 41, 55), 3));
		contentPane.add(homeName);
		homeName.setLayout(null);

		JLabel TitleLabel = new JLabel("SOLSINSA");
		TitleLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 40));
		TitleLabel.setForeground(new Color(255, 255, 255));
		TitleLabel.setBounds(228, 10, 212, 51);
		homeName.add(TitleLabel);
		
		// 상단 아이디 패스워드 입력 패널
		inputPanel = new JPanel();
		inputPanel.setBounds(0, 0, 707, 54);
		inputPanel.setBackground(new Color(216,210,199));
		inputPanel.setLayout(null);
		contentPane.add(inputPanel);
		// 아이디 입력 창
		idtextField = new JTextField();
		idtextField.setBounds(33, 22, 116, 21);
		inputPanel.add(idtextField);
		idtextField.setColumns(10);

		JLabel idLabel = new JLabel("ID");
		idLabel.setBounds(12, 25, 20, 15);
		inputPanel.add(idLabel);

		// 비밀번호 입력 창
		pwtextField = new JPasswordField();
		pwtextField.setBounds(184, 21, 116, 21);
		inputPanel.add(pwtextField);
		pwtextField.setColumns(10);

		JLabel pwLabel = new JLabel("PW");
		pwLabel.setFont(new Font("굴림", Font.BOLD, 12));
		pwLabel.setBounds(159, 24, 20, 15);
		inputPanel.add(pwLabel);

		// 카테고리 버튼 클릭시 제품 창 띄워짐
		JButton CategoryTop = new Rb("TOP");
		CategoryTop.setBackground(new Color(68, 83, 91));
		CategoryTop.setForeground(new Color(255, 255, 255));
		CategoryTop.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 15));
		CategoryTop.setBounds(72, 134, 160, 25);
		CategoryTop.setFocusPainted(false);
		contentPane.add(CategoryTop);
		CategoryTop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Products prod = new Products(0);
				prod.setVisible(true);
			}
		});

		JButton CategoryBottom = new Rb("BOTTOM");
		CategoryBottom.setBackground(new Color(68, 83, 91));
		CategoryBottom.setForeground(new Color(255, 255, 255));
		CategoryBottom.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 15));
		CategoryBottom.setBounds(262, 134, 160, 25);
		CategoryBottom.setFocusPainted(false);
		contentPane.add(CategoryBottom);
		CategoryBottom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Products prod = new Products(24);
				prod.setVisible(true);
			}
		});

		JButton CategoryOuter = new Rb("OUTER");
		CategoryOuter.setBackground(new Color(68, 83, 91));
		CategoryOuter.setForeground(new Color(255, 255, 255));
		CategoryOuter.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 15));
		CategoryOuter.setBounds(447, 134, 160, 25);
		CategoryOuter.setFocusPainted(false);
		contentPane.add(CategoryOuter);
		CategoryOuter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Products prod = new Products(12);
				prod.setVisible(true);
			}
		});
		// ===========================================================================
		// 로그인 버튼
		JButton loginbtn = new JButton("login");
		loginbtn.setBackground(new Color(77, 77, 77));
		loginbtn.setForeground(new Color(255, 255, 255));
		loginbtn.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 12));
		loginbtn.setBounds(310, 20, 67, 23);
		loginbtn.setFocusPainted(false);
		inputPanel.add(loginbtn);

		// 로그인 시 액션 리스너
		loginbtn.addActionListener(new ActionListener() {
			// 관리자 계정 로그인 시 조회프레임 호출
			// 로그인 버튼 클릭 시 db와 연동해서 로그인
			// db에 없는 데이터라면 오류 띄우기
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idtextField.getText();
				String pw = pwtextField.getText();
				
				String data = id + "," + pw;
				String protocol = ":1003";
				
				Client.msg = data + protocol;
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				} // 응답을 받기위한 대기시간
				String str = Client.ans; // 서버 응답(로그인 결과)
				Client.ans = null;
				StringTokenizer st = new StringTokenizer(str, "/");
				
				int check = Integer.parseInt(st.nextToken()); // 해당 결과를 정수로 형변환
				
				if(check == -1)
					JOptionPane.showMessageDialog(null, "해당 아이디가 없습니다.");
				else if(check == -2)
					JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.");
				else if(check == 0) {
					if(idtextField.getText().equals("admin")&&pwtextField.getText().equals("1234")) {
						dispose();
						Lookup lookup = new Lookup();
						lookup.setVisible(true);
					} else {
						String userData = st.nextToken();
						st = new StringTokenizer(userData, ",");
						
						int noData = Integer.parseInt(st.nextToken());
						String idData = st.nextToken();
						String pwData = st.nextToken();
						String nameData = st.nextToken();
						String birthData = st.nextToken();
						String addrData = st.nextToken();
						String phoneData = st.nextToken();
						String mailData = st.nextToken();
						
						Userinfo.getUserInfo();
						Userinfo.getUserInfo().setUserinfo(noData, idData, pwData, nameData, birthData, addrData, phoneData, mailData);
						AfterLogin login = new AfterLogin();
						contentPane.add(login);
						login.setVisible(true);
						inputPanel.setVisible(false);
					}
				}
			}
		});

		// 회원가입 버튼
		JButton joinbtn = new JButton("join");
		joinbtn.setBackground(new Color(77, 77, 77));
		joinbtn.setForeground(new Color(255, 255, 255));
		joinbtn.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 12));
		joinbtn.setBounds(389, 21, 67, 23);
		joinbtn.setFocusPainted(false);
		inputPanel.add(joinbtn);

		// 회원가입 버튼 액션 리스너
		joinbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NewUser userFrame = new NewUser();
				userFrame.setVisible(true);
			}
		});
		// ===========================================================================
		// 상품표시패널
		JPanel productPanel1 = new JPanel();
		productPanel1.setBorder(null);
		productPanel1.setBackground(new Color(216, 210, 199));
		productPanel1.setSize(633, 1000);
		productPanel1.setLayout(null);

		productJbtn = new JButton[4];
		imageJbtnName = new JTextField[4];
		imageJbtnPrice = new JTextField[4];
		ImageIcon imgIcon[] = new ImageIcon[4];

		int xBtn1 = 20, xName1 = 45, xPrice1 = 65;
		int xBtn2 = 15, xName2 = 40, xPrice2 = 55;

		ArrayList<Integer> checkList = new ArrayList<>();
		checkList.add(37);
		
		for (int i = 0; i < 4; i++) {
			int random = (int) (Math.random() * 35) + 1;
			
			Boolean check = true;
			while(check) {
				boolean numCheck = true;
				for(int j = 0; j < checkList.size(); ++j) {
					if(random == checkList.get(i)) {
						numCheck = false;
						random = (int) (Math.random() * 36) + 1;
						break;
					}
				}
				if(numCheck) {
					checkList.add(random);
					break;
				}
			}
			
			server.Product product = Client.products.get(random);
			
			String pCategory = product.getCategory();
			String pImg = product.getImg();
			System.out.println(pCategory);
			System.out.println(pImg);
			System.out.println(product.getName());
			System.out.println(product.getPrice());
			String setImg = "src/쇼핑몰 사진/"+ pCategory +"/" + pImg;
			ImageIcon setIcon = new ImageIcon(setImg);
			Image img = setIcon.getImage();
			Image changeimg = img.getScaledInstance(250, 210, Image.SCALE_SMOOTH); // 이미지 사이즈 조절
			ImageIcon changeIcon = new ImageIcon(changeimg);
			imgIcon[i] = changeIcon;
			
			productJbtn[i] = new JButton(imgIcon[i]);
			productJbtn[i].setBackground(new Color(255, 255, 255)); // 버튼 색상 변경
			productJbtn[i].setFocusPainted(false);

			// 상품 이름
			imageJbtnName[i] = new JTextField(product.getName());
			imageJbtnName[i].setFont(new Font("한컴 말랑말랑", Font.BOLD, 12));
			imageJbtnName[i].setHorizontalAlignment(SwingConstants.CENTER);
			imageJbtnName[i].setColumns(10);

			// 상품 가격
			imageJbtnPrice[i] = new JTextField(Integer.toString(product.getPrice()));
			imageJbtnPrice[i].setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
			imageJbtnPrice[i].setHorizontalAlignment(SwingConstants.CENTER);
			imageJbtnPrice[i].setColumns(10);

			// 상품 클릭 시 상품 상세정보로 이동
			productJbtn[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ProdDetail detail = new ProdDetail(product, product.getCategory_code());
					detail.setVisible(true);
				}});
			
			
			if (i < 2) {
				productJbtn[i].setBounds(xBtn1, 10, 295, 210);
				productPanel1.add(productJbtn[i]);
				imageJbtnName[i].setBounds(xName1, 230, 243, 22);
				productPanel1.add(imageJbtnName[i]);
				imageJbtnPrice[i].setBounds(xPrice1, 262, 200, 22);
				productPanel1.add(imageJbtnPrice[i]);

				xBtn1 += 330;
				xName1 += 330;
				xPrice1 += 330;
			} else {
				productJbtn[i].setBounds(xBtn2, 300, 295, 210);
				productPanel1.add(productJbtn[i]);
				imageJbtnName[i].setBounds(xName2, 520, 243, 22);
				productPanel1.add(imageJbtnName[i]);
				imageJbtnPrice[i].setBounds(xPrice2, 552, 200, 22);
				productPanel1.add(imageJbtnPrice[i]);

				xBtn2 += 330;
				xName2 += 330;
				xPrice2 += 330;
			}
		}

		productPanel1.setPreferredSize(new Dimension(633, 596));

		JScrollPane scrollPane = new JScrollPane(productPanel1, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0), 2));
		scrollPane.setBounds(12, 303, 683, 311);

		contentPane.add(scrollPane);
	}
}