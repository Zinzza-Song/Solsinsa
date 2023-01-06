package gui;

import jdbc.JdbcConnector;

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

public class Products extends JFrame {

	private JPanel contentPane;
	JButton productImgBtn[];
	JButton cancleBtn;
	JButton cartBtn;
	JTextField productName[];
	JTextField productPrice[];

	String top[] = { "허드슨 아란 점퍼 니트 님부스 / WJ 5740", "Velour Soccer Jersey Black", "WORLD EP HOODIE SLATE BLUE",
			"코튼 워셔블 하찌 하프집업 니트_5 COLOR", "레터링 타투 후드 기모 블랙", "벌키 브러쉬 아가일 니트 BLACK", "미니멀 울 라이크 반목폴라 니트 [그레이]",
			"Fluff Mood Check shirt S24 Navy", "프레첼 코듀로이 셔츠 카키브라운 JJLS7525", "울 하이넥 케이블 집업 니트 - 샌드",
			"CROPPED HAIRY KNIT - MELANGE", "옵티멀 베이직 셔츠-화이트" };

	String outer[] = {"BROWN reversible shearling short coat(OJ315)","LIGHTWEIGHT VEGAN LEATHER MA-1 JACKET [BLACK]",
			"오버사이즈 울 트렌치 코트 [BEIGE]","Flat Single Coat (Black)","OVERSIZED BALMACAAN COAT _ BLACK",
			"말본 아노락 자켓 BEIGE (MAN)","[PRIMALOFT] 몬스터 숏패딩_블랙","REVERSIBLE WARM UP QUILTING JACKET BLACK / IVORY",
			"후드 미니멀 푸퍼_SPJPC4TC12","[리뉴얼ver]컴포터블 벌룬핏 다운 패딩 다크그레이 COOSJP031D.GRAY",
			"PERTEX® T Down Jacket Bandana Grey","[리뉴얼ver]컨템포러리 몬스터파카 다크그레이 COOSJP028D.GRAY"};

	String bottom[] = {"WIDE DENIM PANTS [BLACK]","컷 오프 블리치 워시드 데님 팬츠 (TP0042)",
			"1967 JET BLACK JEANS [WIDE STRAIGHT]","와이드 워시드 카고 데님 팬츠 블랙","TAG FLEECE PANTS - BLACK","코듀로이 원턱 조거팬츠-KHAKI",
			"939 LOGO SWEAT PANTS (BLACK)","와이드 히든 밴딩 슬랙스 [블랙]","테이퍼드 히든 밴딩 크롭 슬랙스 [라이트 베이지]",
			"세미 부츠컷 슬랙스 [그레이]","데님 오버롤 멜빵 팬츠 [블루]","오버라운드 퍼티그 점프슈트 OF-501 블랙"};

	// 홈 화면에서 카테고리에 따라 사진 변경을 위한 String category 추가
	public Products(String category) {
		setTitle(category);
		setBounds(100, 100, 694, 602);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// 상품 패널 만들고 스크롤팬안에 패널 넣기
		JPanel productPanel = new JPanel();
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
		int xBtn1 = 20, xName1 = 28, xPrice1 = 58;
		int xBtn2 = 20, xName2 = 28, xPrice2 = 58;
		int xBtn3 = 20, xName3 = 28, xPrice3 = 58;
		int xBtn4 = 20, xName4 = 28, xPrice4 = 58;

		for (int i = 0; i < 12; i++) {
			if (category.equals("TOP")) {
				
				ImageIcon imageIcon = new ImageIcon("./src/쇼핑몰 사진/상의/TOP_" + (i + 1) + ".jpg");
				Image Img = imageIcon.getImage();
				Image changeImg = Img.getScaledInstance(160, 172, Image.SCALE_SMOOTH);
				ImageIcon changeIcon = new ImageIcon(changeImg);
				
				productImgBtn[i] = new JButton(changeIcon);
				productName[i] = new JTextField(top[i]);
				productPrice[i] = new JTextField("");
			}
			else if(category.equals("BOTTOM")) {
				
				ImageIcon imageIcon = new ImageIcon("./src/쇼핑몰 사진/하의/BOTTOM_" + (i + 1) + ".jpg");
				Image Img = imageIcon.getImage();
				Image changeImg = Img.getScaledInstance(160, 172, Image.SCALE_SMOOTH);
				ImageIcon changeIcon = new ImageIcon(changeImg);
				
				productImgBtn[i] = new JButton(changeIcon);
				productName[i] = new JTextField(bottom[i]);
				productPrice[i] = new JTextField("");
			}
			else if(category.equals("OUTER")) {
				
				ImageIcon imageIcon = new ImageIcon("./src/쇼핑몰 사진/아우터/OUTER_" + (i + 1) + ".jpg");
				Image Img = imageIcon.getImage();
				Image changeImg = Img.getScaledInstance(160, 172, Image.SCALE_SMOOTH);
				ImageIcon changeIcon = new ImageIcon(changeImg);
				
				productImgBtn[i] = new JButton(changeIcon);
				productName[i] = new JTextField(outer[i]);
				productPrice[i] = new JTextField("");
			}
			
			productName[i].setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
			productName[i].setHorizontalAlignment(SwingConstants.CENTER);
			productName[i].setColumns(10);

			productPrice[i].setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
			productPrice[i].setHorizontalAlignment(SwingConstants.CENTER);
			productPrice[i].setColumns(10);

			if (i < 3) {
				productImgBtn[i].setBounds(xBtn1, 20, 189, 172);
				productPanel.add(productImgBtn[i]);
				productName[i].setBounds(xName1, 195, 180, 21);
				productPanel.add(productName[i]);
				productPrice[i].setBounds(xPrice1, 225, 116, 21);
				productPanel.add(productPrice[i]);
				xBtn1 += 222;
				xName1 += 220;
				xPrice1 += 220;
			} else if (i < 6) {
				productImgBtn[i].setBounds(xBtn2, 260, 189, 172);
				productPanel.add(productImgBtn[i]);
				productName[i].setBounds(xName2, 435, 180, 21);
				productPanel.add(productName[i]);
				productPrice[i].setBounds(xPrice2, 465, 116, 21);
				productPanel.add(productPrice[i]);
				xBtn2 += 222;
				xName2 += 220;
				xPrice2 += 220;
			} else if (i < 9) {
				productImgBtn[i].setBounds(xBtn3, 500, 189, 172);
				productPanel.add(productImgBtn[i]);
				productName[i].setBounds(xName3, 675, 180, 21);
				productPanel.add(productName[i]);
				productPrice[i].setBounds(xPrice3, 705, 116, 21);
				productPanel.add(productPrice[i]);
				xBtn3 += 222;
				xName3 += 220;
				xPrice3 += 220;
			} else {
				productImgBtn[i].setBounds(xBtn4, 740, 189, 172);
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
		
		cancleBtn = new JButton("닫기");
		cancleBtn.setBounds(265,510,150,35);
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
