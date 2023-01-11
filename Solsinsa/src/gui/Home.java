package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField idtextField;
	private JTextField pwtextField;
	private JButton productJbtn[];
	private JTextField imageJbtnName[];
	private JTextField imageJbtnPrice[];
	private ImageIcon imgIcon[] = new ImageIcon[4];

	static String top[] = { "허드슨 아란 점퍼 니트 님부스 / WJ 5740", "Velour Soccer Jersey Black", "WORLD EP HOODIE SLATE BLUE","코튼 워셔블 하찌 하프집업 니트_5 COLOR", "레터링 타투 후드 기모 블랙", "벌키 브러쉬 아가일 니트 BLACK", "미니멀 울 라이크 반목폴라 니트 [그레이]","Fluff Mood Check shirt S24 Navy", "프레첼 코듀로이 셔츠 카키브라운 JJLS7525", "울 하이넥 케이블 집업 니트 - 샌드","CROPPED HAIRY KNIT - MELANGE", "옵티멀 베이직 셔츠-화이트" };

	static String outer[] = { "BROWN reversible shearling short coat(OJ315)","LIGHTWEIGHT VEGAN LEATHER MA-1 JACKET [BLACK]", "오버사이즈 울 트렌치 코트 [BEIGE]", "Flat Single Coat (Black)","OVERSIZED BALMACAAN COAT _ BLACK", "말본 아노락 자켓 BEIGE (MAN)", "[PRIMALOFT] 몬스터 숏패딩_블랙","REVERSIBLE WARM UP QUILTING JACKET BLACK / IVORY", "후드 미니멀 푸퍼_SPJPC4TC12","[리뉴얼ver]컴포터블 벌룬핏 다운 패딩 다크그레이 COOSJP031D.GRAY", "PERTEX® T Down Jacket Bandana Grey","[리뉴얼ver]컨템포러리 몬스터파카 다크그레이 COOSJP028D.GRAY" };

	static String bottom[] = { "WIDE DENIM PANTS [BLACK]", "컷 오프 블리치 워시드 데님 팬츠 (TP0042)","1967 JET BLACK JEANS [WIDE STRAIGHT]", "와이드 워시드 카고 데님 팬츠 블랙", "TAG FLEECE PANTS - BLACK","코듀로이 원턱 조거팬츠-KHAKI", "939 LOGO SWEAT PANTS (BLACK)", "와이드 히든 밴딩 슬랙스 [블랙]", "테이퍼드 히든 밴딩 크롭 슬랙스 [라이트 베이지]","세미 부츠컷 슬랙스 [그레이]", "데님 오버롤 멜빵 팬츠 [블루]", "오버라운드 퍼티그 점프슈트 OF-501 블랙" };

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
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 226, 235));
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
		TitleLabel.setFont(new Font("한컴 말랑말랑", Font.BOLD, 40));
		TitleLabel.setForeground(new Color(255, 255, 255));
		TitleLabel.setBounds(228, 10, 212, 51);
		homeName.add(TitleLabel);

		// 아이디 입력 창
		idtextField = new JTextField();
		idtextField.setBounds(33, 22, 116, 21);
		contentPane.add(idtextField);
		idtextField.setColumns(10);

		JLabel idLabel = new JLabel("ID");
		idLabel.setBounds(12, 25, 20, 15);
		contentPane.add(idLabel);

		// 비밀번호 입력 창
		pwtextField = new JTextField();
		pwtextField.setBounds(184, 21, 116, 21);
		contentPane.add(pwtextField);
		pwtextField.setColumns(10);

		JLabel pwLabel = new JLabel("PW");
		pwLabel.setBounds(159, 24, 20, 15);
		contentPane.add(pwLabel);

		// 카테고리 버튼 클릭시 제품 창 띄워짐
		JButton CategoryTop = new JButton("TOP");
		CategoryTop.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 15));
		CategoryTop.setBounds(72, 134, 160, 25);
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

		JButton CategoryBottom = new JButton("BOTTOM");
		CategoryBottom.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 15));
		CategoryBottom.setBounds(262, 134, 160, 25);
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

		JButton CategoryOuter = new JButton("OUTER");
		CategoryOuter.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 15));
		CategoryOuter.setBounds(447, 134, 160, 25);
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
		// 로그인 버튼
		JButton loginbtn = new JButton("login");
		loginbtn.setFont(new Font("굴림", Font.PLAIN, 12));
		loginbtn.setBounds(310, 20, 67, 23);
		contentPane.add(loginbtn);

		// 로그인 시 액션 리스너
		loginbtn.addActionListener(new ActionListener() {
			// 관리자 계정 로그인 시 조회프레임 호출
			// 로그인 버튼 클릭 시 db와 연동해서 로그인
			// db에 없는 데이터라면 오류 띄우기
			@Override
			public void actionPerformed(ActionEvent e) {
				if(idtextField.getText().equals("admin")&&pwtextField.getText().equals("1234")) {
					dispose();
					Lookup lookup = new Lookup();
					lookup.setVisible(true);
				}
				// else if(db의 회원 정보에서 아이디나 비밀번호 2가지 중 1개가 맞지 않는 경우){ }
				JOptionPane.showMessageDialog(null, "아이디와 비밀번호가 존재하지 않습니다.");

				// else if(아이디, 비밀번호가 둘 다 일치하는 경우){ }
				// 로그인프레임 login = new 로그인프레임();
				AfterLogin login = new AfterLogin();
				login.setVisible(true);
				dispose();
			}
		});

		// 회원가입 버튼
		JButton joinbtn = new JButton("join");
		joinbtn.setFont(new Font("굴림", Font.PLAIN, 12));
		joinbtn.setBounds(389, 21, 67, 23);
		contentPane.add(joinbtn);

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
		productPanel1.setSize(633, 1000);
		productPanel1.setLayout(null);

		productJbtn = new JButton[4];
		imageJbtnName = new JTextField[4];
		imageJbtnPrice = new JTextField[4];
		ImageIcon imgIcon[] = new ImageIcon[4];

		int xBtn1 = 20, xName1 = 45, xPrice1 = 65;
		int xBtn2 = 15, xName2 = 40, xPrice2 = 55;

		for (int i = 0; i < 4; i++) {
			int random = (int) (Math.random() * 12) + 1;
			// 상의 사진
			String topImg = "src/쇼핑몰 사진/상의/TOP_" + random + ".jpg";
			ImageIcon topIcon = new ImageIcon(topImg);
			Image img = topIcon.getImage();
			Image changeimg = img.getScaledInstance(250, 210, Image.SCALE_SMOOTH); // 이미지 사이즈 조절
			// 아우터 사진
			String outerImg = "src/쇼핑몰 사진/아우터/OUTER_" + random + ".jpg";
			ImageIcon outerIcon = new ImageIcon(outerImg);
			Image img3 = outerIcon.getImage();
			Image changeimg2 = img3.getScaledInstance(250, 210, Image.SCALE_SMOOTH); // 이미지 사이즈 조절

			// 상품 이미지 버튼
			if (i % 2 != 0) {
				imgIcon[i] = new ImageIcon(changeimg);
			} else if (i % 2 == 0) {
				imgIcon[i] = new ImageIcon(changeimg2);
			}
			productJbtn[i] = new JButton(imgIcon[i]);
			productJbtn[i].setBackground(new Color(255, 255, 255)); // 버튼 색상 변경

			// 상품 이름
			imageJbtnName[i] = new JTextField(top[i]);
			imageJbtnName[i].setFont(new Font("한컴 말랑말랑", Font.BOLD, 12));
			imageJbtnName[i].setHorizontalAlignment(SwingConstants.CENTER);
			imageJbtnName[i].setColumns(10);

			// 상품 가격
			imageJbtnPrice[i] = new JTextField("가격");
			imageJbtnPrice[i].setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
			imageJbtnPrice[i].setHorizontalAlignment(SwingConstants.CENTER);
			imageJbtnPrice[i].setColumns(10);

			// 상품 클릭 시 상품 상세정보로 이동
			productJbtn[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

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
	}
}