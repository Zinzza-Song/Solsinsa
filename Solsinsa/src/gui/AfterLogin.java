package gui;

import java.awt.Color;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class AfterLogin extends JFrame {

	private JPanel contentPane;
	private JButton productJbtn[];
	private JTextField imageJbtnName[];
	private JTextField imageJbtnPrice[];
	private ImageIcon imgIcon[] = new ImageIcon[4];
	
	String top[] = { "허드슨 아란 점퍼 니트 님부스 / WJ 5740", "Velour Soccer Jersey Black", "WORLD EP HOODIE SLATE BLUE",
			"코튼 워셔블 하찌 하프집업 니트_5 COLOR", "레터링 타투 후드 기모 블랙", "벌키 브러쉬 아가일 니트 BLACK", "미니멀 울 라이크 반목폴라 니트 [그레이]",
			"Fluff Mood Check shirt S24 Navy", "프레첼 코듀로이 셔츠 카키브라운 JJLS7525", "울 하이넥 케이블 집업 니트 - 샌드",
			"CROPPED HAIRY KNIT - MELANGE", "옵티멀 베이직 셔츠-화이트" };

	String outer[] = { "BROWN reversible shearling short coat(OJ315)", "LIGHTWEIGHT VEGAN LEATHER MA-1 JACKET [BLACK]",
			"오버사이즈 울 트렌치 코트 [BEIGE]", "Flat Single Coat (Black)", "OVERSIZED BALMACAAN COAT _ BLACK",
			"말본 아노락 자켓 BEIGE (MAN)", "[PRIMALOFT] 몬스터 숏패딩_블랙", "REVERSIBLE WARM UP QUILTING JACKET BLACK / IVORY",
			"후드 미니멀 푸퍼_SPJPC4TC12", "[리뉴얼ver]컴포터블 벌룬핏 다운 패딩 다크그레이 COOSJP031D.GRAY",
			"PERTEX® T Down Jacket Bandana Grey", "[리뉴얼ver]컨템포러리 몬스터파카 다크그레이 COOSJP028D.GRAY" };

	String bottom[] = { "WIDE DENIM PANTS [BLACK]", "컷 오프 블리치 워시드 데님 팬츠 (TP0042)",
			"1967 JET BLACK JEANS [WIDE STRAIGHT]", "와이드 워시드 카고 데님 팬츠 블랙", "TAG FLEECE PANTS - BLACK",
			"코듀로이 원턱 조거팬츠-KHAKI", "939 LOGO SWEAT PANTS (BLACK)", "와이드 히든 밴딩 슬랙스 [블랙]", "테이퍼드 히든 밴딩 크롭 슬랙스 [라이트 베이지]",
			"세미 부츠컷 슬랙스 [그레이]", "데님 오버롤 멜빵 팬츠 [블루]", "오버라운드 퍼티그 점프슈트 OF-501 블랙" };

	/**
	 * Create the frame.
	 */
	public AfterLogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 653);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216,210,199));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		// 스레드 패널
		DressPanel banner = new DressPanel();
		contentPane.add(banner);

		banner.startThread();

		// 타이틀 패널
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

		// 카테고리 버튼 클릭시 제품 창 띄워짐
		//상의
		JButton CategoryTop = new Rb("TOP");
		CategoryTop.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 15));
		CategoryTop.setBounds(72, 134, 160, 25);
		CategoryTop.setFocusPainted(false);
		contentPane.add(CategoryTop);
		CategoryTop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String column = e.getActionCommand();
				Products prod = new Products(column);
				prod.setVisible(true);
			}
		});
		//하의
		JButton CategoryBottom = new Rb("BOTTOM");
		CategoryBottom.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 15));
		CategoryBottom.setBounds(262, 134, 160, 25);
		CategoryBottom.setFocusPainted(false);
		contentPane.add(CategoryBottom);
		CategoryBottom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String column = e.getActionCommand();
				Products prod = new Products(column);
				prod.setVisible(true);
			}
		});
		//아우터
		JButton CategoryOuter = new Rb("OUTER");
		CategoryOuter.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 15));
		CategoryOuter.setBounds(447, 134, 160, 25);
		CategoryOuter.setFocusPainted(false);
		contentPane.add(CategoryOuter);
		CategoryOuter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String column = e.getActionCommand();
				Products prod = new Products(column);
				prod.setVisible(true);
			}
		});
		// ===========================================================================
		// 상품표시패널
		JPanel productPanel1 = new JPanel();
		productPanel1.setSize(633, 1000);
		productPanel1.setLayout(null);

		productJbtn = new JButton[4];
		imageJbtnName = new JTextField[4];
		imageJbtnPrice = new JTextField[4];
		ImageIcon imgIcon[] = new ImageIcon[4];

		int xBtn1 = 20, xName1 = 45, xPrice1 = 65;
		int xBtn2 = 15, xName2 = 40, xPrice2 = 55;
		for (int i = 0; i < 4; i++) {
			int random = (int)(Math.random()*12)+1;
			int num = i;
			//
			String topImg = "src/쇼핑몰 사진/상의/TOP_" + random + ".jpg";
			ImageIcon topIcon = new ImageIcon(topImg);
			Image img = topIcon.getImage();
			Image changeimg = img.getScaledInstance(250, 210, Image.SCALE_SMOOTH); // 이미지 사이즈 조절
			//
			String outerImg = "src/쇼핑몰 사진/아우터/OUTER_" + random + ".jpg";
			ImageIcon outerIcon = new ImageIcon(outerImg);
			Image img2 = outerIcon.getImage();
			Image changeimg2 = img2.getScaledInstance(250, 210, Image.SCALE_SMOOTH); // 이미지 사이즈 조절

			// 상품 이미지 버튼
			if (i % 2 != 0) {
				imgIcon[i] = new ImageIcon(changeimg);
			} else if (i % 2 == 0) {
				imgIcon[i] = new ImageIcon(changeimg2);
			}
			productJbtn[i] = new JButton(imgIcon[i]);
			productJbtn[i].setBackground(new Color(255, 255, 255)); // 버튼 색상 변경
			productJbtn[i].setFocusPainted(false);

			imageJbtnName[i] = new JTextField(top[i]);
			imageJbtnName[i].setFont(new Font("한컴 말랑말랑", Font.BOLD, 12));
			imageJbtnName[i].setHorizontalAlignment(SwingConstants.CENTER);
			imageJbtnName[i].setColumns(10);

			imageJbtnPrice[i] = new JTextField(top[i]);
			imageJbtnPrice[i].setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
			imageJbtnPrice[i].setHorizontalAlignment(SwingConstants.CENTER);
			imageJbtnPrice[i].setColumns(10);
			// 액션리스너
			productJbtn[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(num % 2 != 0) {
						ProdDetail prod = new ProdDetail("TOP", topIcon, top[num+5]);
						prod.setVisible(true);
					}
					else {
						ProdDetail prod = new ProdDetail("OUTER", outerIcon, outer[num+5]);
						prod.setVisible(true);
					}
				}
			});
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
		//상단에 표시될 버튼들
		//장바구니 버튼
		JButton cartBtn = new JButton("장바구니");
		cartBtn.setForeground(new Color(255, 255, 255));
		cartBtn.setBackground(new Color(0, 0, 64));
		cartBtn.setBounds(478, 10, 35, 35);
		cartBtn.setFocusPainted(false);
		contentPane.add(cartBtn);
		cartBtn.setOpaque(true);
		//버튼 클릭시 장바구니 오픈
		cartBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Cart cart = new Cart();
				cart.setVisible(true);
				
			}
			
		});
		//마이 페이지 버튼
		JButton mypageBtn = new JButton("마이페이지");
		mypageBtn.setBackground(new Color(128, 128, 192));
		mypageBtn.setBounds(544, 10, 35, 35);
		mypageBtn.setFocusPainted(false);
		contentPane.add(mypageBtn);
		mypageBtn.setOpaque(true);
		mypageBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MyPage mypage = new MyPage();
				mypage.setVisible(true);
				dispose();
			}
			
		});
		
		JLabel welcomeLabel = new JLabel("000님 환영합니다.");
		welcomeLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
		welcomeLabel.setBounds(280, 10, 192, 35);
		contentPane.add(welcomeLabel);
		
		//로그아웃 버튼
		JButton logoutBtn = new JButton("로그아웃");
		logoutBtn.setOpaque(true);
		logoutBtn.setBackground(new Color(128, 128, 192));
		logoutBtn.setBounds(614, 10, 81, 35);
		contentPane.add(logoutBtn);
		//로그아웃 클릭 시 액션 리스너
		logoutBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "로그아웃 되었습니다.");
				Home home = new Home();
				home.setVisible(true);
				dispose();
			}
			
		});
	}
}