package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DressPanel extends JPanel {
	
	Home home;//홈에서 상품 이름 가져오기위한 필드변수 선언
	DressThread1 dressThread1;
	private JPanel panel;	// 상품사진 스레드 패널1
	private JPanel panel2;	// 상품사진 스레드 패널2
	//상품 사진 라벨
	JLabel product1;
	JLabel product2;
	JLabel product3;
	JLabel product4;
	JLabel product11;
	JLabel product22;
	JLabel product33;
	JLabel product44;

	DressPanel() {
		setBounds(12, 169, 683, 124);
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 683, 123);
		add(panel);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		panel2 = new JPanel();
		panel2.setBounds(-panel.getWidth(), 0, 683, 123);
		add(panel2);
		panel2.setLayout(new GridLayout(0, 4, 0, 0));
		
		// 1번 사진
		String TopName1 = home.top[2];
		String Link1 = "./src/쇼핑몰 사진/상의/TOP_3.jpg";
		ImageIcon image1 = new ImageIcon(Link1);
		Image img1 = image1.getImage();
		Image changeimg1 = img1.getScaledInstance(150, 130, Image.SCALE_SMOOTH);
		ImageIcon changeIcon1 = new ImageIcon(changeimg1);

		// 2번 사진
		String OuterName1 = home.bottom[4];
		String Link2 = "./src/쇼핑몰 사진/아우터/OUTER_5.jpg";
		ImageIcon image2 = new ImageIcon(Link2);
		Image img2 = image2.getImage();
		Image changeimg2 = img2.getScaledInstance(150, 130, Image.SCALE_SMOOTH);
		ImageIcon changeIcon2 = new ImageIcon(changeimg2);

		// 3번 사진
		String TopName2 = home.top[6];
		String Link3 = "./src/쇼핑몰 사진/상의/TOP_7.jpg";
		ImageIcon image3 = new ImageIcon(Link3);
		Image img3 = image3.getImage();
		Image changeimg3 = img3.getScaledInstance(150, 130, Image.SCALE_SMOOTH);
		ImageIcon changeIcon3 = new ImageIcon(changeimg3);

		// 4번 사진
		String OuterName2 = home.outer[8];
		String Link4 = "./src/쇼핑몰 사진/아우터/OUTER_9.jpg";
		ImageIcon image4 = new ImageIcon(Link4);
		Image img4 = image4.getImage();
		Image changeimg4 = img4.getScaledInstance(150, 130, Image.SCALE_SMOOTH);
		ImageIcon changeIcon4 = new ImageIcon(changeimg4);

		// 상품 이미지 패널들
		product1 = new JLabel(changeIcon1);
		product1.setBounds(0, 0, 100, 100);
		product11 = new JLabel(changeIcon1);
		product11.setBounds(0, 0, 100, 100);
		panel.add(product1);
		panel2.add(product11);
		
		product2 = new JLabel(changeIcon2);
		product2.setBounds(200, 100, 100, 100);
		product22 = new JLabel(changeIcon2);
		product22.setBounds(200, 100, 100, 100);
		panel.add(product2);
		panel2.add(product22);
		
		product3 = new JLabel(changeIcon3);
		product3.setBounds(400, 0, 100, 100);
		product33 = new JLabel(changeIcon3);
		product33.setBounds(400, 0, 100, 100);
		panel.add(product3);
		panel2.add(product33);
		
		product4 = new JLabel(changeIcon4);
		product4.setBounds(600, 0, 100, 100);
		product44 = new JLabel(changeIcon4);
		product44.setBounds(600, 0, 100, 100);
		panel.add(product4);
		panel2.add(product44);
		
		//상품 사진 클릭 시 상품 상세 정보로 바로 이동
		product1.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				ProdDetail prod = new ProdDetail("TOP", image1, TopName1);
				prod.setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {}@Override
			public void mouseReleased(MouseEvent e) {}@Override
			public void mouseEntered(MouseEvent e) {}@Override
			public void mouseExited(MouseEvent e) {}});
		product2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				ProdDetail prod = new ProdDetail("OUTER", image2, OuterName1);
				prod.setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {}@Override
			public void mouseReleased(MouseEvent e) {}@Override
			public void mouseEntered(MouseEvent e) {}@Override
			public void mouseExited(MouseEvent e) {}});
		product3.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				ProdDetail prod = new ProdDetail("TOP", image3, TopName2);
				prod.setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {}@Override
			public void mouseReleased(MouseEvent e) {}@Override
			public void mouseEntered(MouseEvent e) {}@Override
			public void mouseExited(MouseEvent e) {}});
		product4.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				ProdDetail prod = new ProdDetail("OUTER", image4, OuterName2);
				prod.setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {}@Override
			public void mouseReleased(MouseEvent e) {}@Override
			public void mouseEntered(MouseEvent e) {}@Override
			public void mouseExited(MouseEvent e) {}});
		product11.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				ProdDetail prod = new ProdDetail("TOP", image1, TopName1);
				prod.setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {}@Override
			public void mouseReleased(MouseEvent e) {}@Override
			public void mouseEntered(MouseEvent e) {}@Override
			public void mouseExited(MouseEvent e) {}});	
		product22.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				ProdDetail prod = new ProdDetail("OUTER", image2, OuterName1);
				prod.setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {}@Override
			public void mouseReleased(MouseEvent e) {}@Override
			public void mouseEntered(MouseEvent e) {}@Override
			public void mouseExited(MouseEvent e) {}});
		product33.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				ProdDetail prod = new ProdDetail("TOP", image3, TopName2);
				prod.setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {}@Override
			public void mouseReleased(MouseEvent e) {}@Override
			public void mouseEntered(MouseEvent e) {}@Override
			public void mouseExited(MouseEvent e) {}});
		product44.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				ProdDetail prod = new ProdDetail("OUTER", image4, OuterName2);
				prod.setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {}@Override
			public void mouseReleased(MouseEvent e) {}@Override
			public void mouseEntered(MouseEvent e) {}@Override
			public void mouseExited(MouseEvent e) {}});
		
		// 스레드에 마우스 올릴 시
//		this.addMouseListener(new MouseListener() {
//			public void mouseEntered(MouseEvent e) {
//				// TODO Auto-generated method stub
//				try {
//					DressThread1.sleep(500);
//					
//				} catch (Exception e1) {
//					e1.printStackTrace();
//				}
//			}
//
//			@Override
//			public void mouseClicked(MouseEvent e) {}@Override
//			public void mousePressed(MouseEvent e) {}@Override
//			public void mouseReleased(MouseEvent e) {}@Override
//			public void mouseExited(MouseEvent e) {}});
	}

	// 스레드 시작 메소드
	public void startThread() {
		dressThread1 = new DressThread1(panel, panel2);
		dressThread1.start();
	}
	// 스레드 클래스
	class DressThread1 extends Thread {
		JPanel productJPanel;
		JPanel productJPanel2;
		
		DressThread1(JPanel productJPanel, JPanel productJPanel2) {
			this.productJPanel = productJPanel;
			this.productJPanel2 = productJPanel2;
		}

		// 스레드 동작 설정
		public void run() {
			while (true) {
				int x = productJPanel.getX() + 1;
				int x2 = productJPanel2.getX() + 1;
				int y = productJPanel.getY();
				int y2 = productJPanel2.getY();
				
				int afterx = -productJPanel.getWidth();
				int afterx2 = -productJPanel2.getWidth();
				// DressPanel을 벗어 난 경우
				if (x > DressPanel.this.getWidth()) {
					productJPanel.setLocation(afterx, 0);
				}
				else if(x2 > DressPanel.this.getWidth()) {
					productJPanel2.setLocation(afterx2, 0);
				}
				// 벗어나지 않은 경우
				else {
					productJPanel.setLocation(x, y);
					productJPanel2.setLocation(x2,y2);
				}
				// 매 0.05초 마다 이동
				try {
					sleep(30);

				}
				// 스레드가 죽었을 경우
				catch (Exception e) {
					productJPanel.setLocation(0, 0);

					try {
						sleep(100);
					} catch (Exception e2) {
					}
				}

			}
		}

	}
}