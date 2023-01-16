package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import client.Client;
import client.Userinfo;

@SuppressWarnings("serial")
public class ProdDetail extends JFrame {

	private JPanel contentPane;

	private JTextField FeatureTextField[] = new JTextField[14];
	private JTextField DetailTextField[] = new JTextField[14];
	ImageIcon img;
	server.Top topdetails;
	server.Bottom bottomdetails;
	server.Outer outerdetails;
	private String detailT[] = { "상품명", "가격", "재질", "핏", "촉감", "신축성", "비침", "두께", "사이즈", "총장", "어깨너비", "가슴단면", "소매길이" };
	private String detailB[] = { "상품명", "가격", "재질", "핏", "촉감", "신축성", "비침", "두께", "사이즈", "총장", "허리단면", "허벅지단면", "밑위",
			"밑단단면" };
	int index;
	String str[];

	public ProdDetail(server.Product prod, int num) {

		setBounds(100, 100, 931, 647);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(234, 232, 227));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		String Link;

		if (prod.getCategory().equals("상의")) {
			index = num;
			topdetails = Client.tops.get(index);
			String topImgStr[] = { prod.getName(), Integer.toString(prod.getPrice()), topdetails.getMaterial(),
					topdetails.getFit(), topdetails.getTouch(), topdetails.getFlexible(), topdetails.getThrough(),
					topdetails.getThickness(), topdetails.getSize(), Integer.toString(topdetails.getLength()),
					Integer.toString(topdetails.getShoulder()), Integer.toString(topdetails.getChest()),
					Integer.toString(topdetails.getSleeve()) };
			str = topImgStr;
		} else if (prod.getCategory().equals("하의")) {
			index = num - 24;
			bottomdetails = Client.bottoms.get(index);
			String bottomImgStr[] = { prod.getName(), Integer.toString(prod.getPrice()), bottomdetails.getMaterial(),
					bottomdetails.getFit(), bottomdetails.getTouch(), bottomdetails.getFlexible(),
					bottomdetails.getThrough(), bottomdetails.getThickness(), bottomdetails.getSize(),
					Integer.toString(bottomdetails.getLength()), Integer.toString(bottomdetails.getLength()),
					Integer.toString(bottomdetails.getWaist()), Integer.toString(bottomdetails.getThigh()),
					Integer.toString(bottomdetails.getRise()), Integer.toString(bottomdetails.getHem()) };
			str = bottomImgStr;

		} else if (prod.getCategory().equals("아우터")) {
			index = num - 12;
			outerdetails = Client.outers.get(index);
			String outerImgStr[] = { prod.getName(), Integer.toString(prod.getPrice()), outerdetails.getMaterial(),
					outerdetails.getFit(), outerdetails.getTouch(), outerdetails.getFlexible(),
					outerdetails.getThrough(), outerdetails.getThickness(), outerdetails.getSize(),
					Integer.toString(outerdetails.getLength()), Integer.toString(outerdetails.getShoulder()),
					Integer.toString(outerdetails.getChest()), Integer.toString(outerdetails.getSleeve()) };
			str = outerImgStr;
		}

		Link = "./src/쇼핑몰 사진/" + prod.getCategory() + "/" + prod.getImg();
		img = new ImageIcon(Link);

		Image Img = img.getImage();
		Image changeImg = Img.getScaledInstance(468, 500, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);

		// 좌측 상품 이미지 패널
		JPanel productimgPanel = new JPanel();
		productimgPanel.setBounds(22, 33, 468, 500);
		contentPane.add(productimgPanel);
		productimgPanel.setLayout(null);
		// 상품 이미지 라벨
		JLabel productimgLabel = new JLabel(changeIcon);
		productimgLabel.setBounds(0, 0, 468, 500);
		productimgPanel.add(productimgLabel);
		productimgLabel.setOpaque(true);
		productimgLabel.setBackground(new Color(255, 255, 255));
		productimgLabel.setBackground(new Color(255, 255, 255));

		// 상품 상세정보
		JPanel DetailePanel = new JPanel();
		DetailePanel.setBounds(-36, 145, 398, 430);
		productimgPanel.add(DetailePanel);
		DetailePanel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 0, 0)));
		DetailePanel.setLayout(new GridLayout(10, 0, 0, 0));

		// ============================
		// 하단 버튼
		JButton addCartBtn = new Rb("장바구니 담기");
		addCartBtn.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 20));
		addCartBtn.setFocusPainted(false);
		addCartBtn.setBounds(535, 520, 143, 49);
		contentPane.add(addCartBtn);

		// 장바구니 담기 버튼 클릭 시
		// 장바구니 db 연결 ========================
		addCartBtn.addActionListener(new ActionListener() {
			// 장바구니 담기 클릭 시 장바구니에 추가됨
			@Override
			public void actionPerformed(ActionEvent e) {

				Client.msg = Userinfo.getUserInfo().getNo() + "," + prod.getNo() + ":1004";
				JOptionPane.showMessageDialog(null, "장바구니에 추가되었습니다.");
				dispose();
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

		JPanel DetailPanel = new JPanel();
		DetailPanel.setBounds(634, 33, 271, 426);
		contentPane.add(DetailPanel);

		// 상의 상세 정보
		if (prod.getCategory().equals("상의")) {
			FeaturePanel.setLayout(new GridLayout(13, 0, 0, 0));
			DetailPanel.setLayout(new GridLayout(13, 0, 0, 0));

			for (int i = 0; i < 13; i++) {
				FeatureTextField[i] = new JTextField();
				FeatureTextField[i].setColumns(10);
				FeatureTextField[i].setText(detailT[i]);
				FeatureTextField[i].setHorizontalAlignment(JTextField.CENTER);
				FeaturePanel.add(FeatureTextField[i]);

				DetailTextField[i] = new JTextField();
				DetailTextField[i].setColumns(10);
				DetailTextField[i].setText(str[i]);
				DetailTextField[i].setHorizontalAlignment(JTextField.CENTER);
				DetailPanel.add(DetailTextField[i]);
			}
		}
		// 하의 상세 정보
		else if (prod.getCategory().equals("하의")) {
			FeaturePanel.setLayout(new GridLayout(14, 0, 0, 0));
			DetailPanel.setLayout(new GridLayout(14, 0, 0, 0));
			for (int i = 0; i < 14; i++) {
				FeatureTextField[i] = new JTextField();
				FeatureTextField[i].setColumns(10);
				FeatureTextField[i].setText(detailB[i]);
				FeatureTextField[i].setHorizontalAlignment(JTextField.CENTER);
				FeaturePanel.add(FeatureTextField[i]);

				DetailTextField[i] = new JTextField();
				DetailTextField[i].setColumns(10);
				DetailTextField[i].setText(str[i]);
				DetailTextField[i].setHorizontalAlignment(JTextField.CENTER);
				DetailPanel.add(DetailTextField[i]);
			}
		} else if (prod.getCategory().equals("아우터")) {
			FeaturePanel.setLayout(new GridLayout(13, 0, 0, 0));
			DetailPanel.setLayout(new GridLayout(13, 0, 0, 0));
			for (int i = 0; i < 13; i++) {
				FeatureTextField[i] = new JTextField();
				FeatureTextField[i].setColumns(10);
				FeatureTextField[i].setText(detailT[i]);
				FeatureTextField[i].setHorizontalAlignment(JTextField.CENTER);
				FeaturePanel.add(FeatureTextField[i]);

				DetailTextField[i] = new JTextField();
				DetailTextField[i].setColumns(10);
				DetailTextField[i].setText(str[i]);
				DetailTextField[i].setHorizontalAlignment(JTextField.CENTER);
				DetailPanel.add(DetailTextField[i]);
			}
		}

		// 닫기 버튼 클릭 시
		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});

	}
}
