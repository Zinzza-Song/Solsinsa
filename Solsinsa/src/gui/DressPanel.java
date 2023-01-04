package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import jdbc.JdbcConnector;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DressPanel extends JPanel {

	DressThread1 dressThread;
	DressThread2 dressThread2;
	DressThread3 dressThread3;
	DressThread4 dressThread4;

	JPanel productPanel1;
	JPanel productPanel2;
	JPanel productPanel3;
	JPanel productPanel4;

	JLabel product1;
	JLabel product2;
	JLabel product3;
	JLabel product4;

	DressPanel() {
		this.setBounds(12, 169, 683, 124);
		this.setLayout(new GridLayout(0, 4, 0, 0));
		this.setBackground(new Color(255, 255, 255));

		// 1번 사진
		ImageIcon image1 = new ImageIcon("Solsinsa/src/gui/쇼핑몰 사진/상의/TOP_1.jpg");
		Image img1 = image1.getImage();
		Image changeimg1 = img1.getScaledInstance(150, 130, Image.SCALE_SMOOTH);
		ImageIcon changeIcon1 = new ImageIcon(changeimg1);

		// 2번 사진
		ImageIcon image2 = new ImageIcon("Solsinsa/src/gui/쇼핑몰 사진/상의/TOP_2.jpg");
		Image img2 = image2.getImage();
		Image changeimg2 = img2.getScaledInstance(150, 130, Image.SCALE_SMOOTH);
		ImageIcon changeIcon2 = new ImageIcon(changeimg2);

		// 3번 사진
		ImageIcon image3 = new ImageIcon("Solsinsa/src/gui/쇼핑몰 사진/상의/TOP_3.jpg");
		Image img3 = image3.getImage();
		Image changeimg3 = img3.getScaledInstance(150, 130, Image.SCALE_SMOOTH);
		ImageIcon changeIcon3 = new ImageIcon(changeimg3);

		// 4번 사진
		ImageIcon image4 = new ImageIcon("Solsinsa/src/gui/쇼핑몰 사진/상의/TOP_4.jpg");
		Image img4 = image4.getImage();
		Image changeimg4 = img4.getScaledInstance(150, 130, Image.SCALE_SMOOTH);
		ImageIcon changeIcon4 = new ImageIcon(changeimg4);

		// 상품 이미지 패널들
		productPanel1 = new JPanel();
		product1 = new JLabel(changeIcon1);
		product1.setBounds(0, 0, 100, 100);
		productPanel1.add(product1);
		productPanel1.setBackground(new Color(255, 255, 255));
		this.add(productPanel1);

		productPanel2 = new JPanel();
		product2 = new JLabel(changeIcon2);
		product2.setBounds(200, 100, 100, 100);
		productPanel2.add(product2);
		productPanel2.setBackground(new Color(255, 255, 255));
		this.add(productPanel2);

		productPanel3 = new JPanel();
		product3 = new JLabel(changeIcon3);
		product3.setBounds(400, 0, 100, 100);
		productPanel3.add(product3);
		productPanel3.setBackground(new Color(255, 255, 255));
		this.add(productPanel3);

		productPanel4 = new JPanel();
		product4 = new JLabel(changeIcon4);
		product4.setBounds(600, 0, 100, 100);
		productPanel4.add(product4);
		productPanel4.setBackground(new Color(255, 255, 255));
		this.add(productPanel4);

		// 스레드에 마우스 올릴 시
		this.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					DressThread1.sleep(500);
					DressThread2.sleep(500);
					DressThread3.sleep(500);
					DressThread4.sleep(500);
				} catch (Exception exc) {
					exc.printStackTrace();
				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});

		// 스레드 상품 이미지 클릭 시 상세정보로 이동
//		productPanel2.addMouseListener(new MouseListener() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// ������ �� ���� �������� �̵�
//			}
//			@Override
//			public void mousePressed(MouseEvent e) {}
//			@Override
//			public void mouseReleased(MouseEvent e) {}
//			@Override
//			public void mouseExited(MouseEvent e) {}
//			@Override
//			public void mouseEntered(MouseEvent e) {}
//		});
//		
		// 스레드 상품 이미지 클릭 시 상세정보로 이동
//		productPanel3.addMouseListener(new MouseListener() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// ������ �� ���� �������� �̵�
//			}
//			@Override
//			public void mousePressed(MouseEvent e) {}
//			@Override
//			public void mouseReleased(MouseEvent e) {}
//			@Override
//			public void mouseExited(MouseEvent e) {}
//			@Override
//			public void mouseEntered(MouseEvent e) {}
//		});
//		
		// 스레드 상품 이미지 클릭 시 상세정보로 이동
//		productPanel4.addMouseListener(new MouseListener() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// ������ �� ���� �������� �̵�
//			}
//			@Override
//			public void mousePressed(MouseEvent e) {}
//			@Override
//			public void mouseReleased(MouseEvent e) {}
//			@Override
//			public void mouseExited(MouseEvent e) {}
//			@Override
//			public void mouseEntered(MouseEvent e) {}
//		});

	}

	// 스레드 시작 메소드
	public void startThread() {
		dressThread = new DressThread1(product1, productPanel1);
		dressThread.start();

		dressThread2 = new DressThread2(product2, productPanel2);
		dressThread2.start();

		dressThread3 = new DressThread3(product3, productPanel3);
		dressThread3.start();

		dressThread4 = new DressThread4(product4, productPanel4);
		dressThread4.start();

	}

	class DressThread1 extends Thread {
		JLabel productJLabel;
		JPanel productJPanel;

		DressThread1(JLabel productJLabel, JPanel productJPanel) {
			this.productJLabel = productJLabel;
			this.productJPanel = productJPanel;
		}

		// 스레드 동작 설정
		public void run() {
			while (true) {
				int x = productJPanel.getX() + 3;
				int y = productJPanel.getY();

				// DressPanel을 벗어 난 경우
				if (x > DressPanel.this.getWidth()) {
					productJPanel.setLocation(0, 0);
				}
				// 벗어나지 않은 경우
				else {
					productJPanel.setLocation(x, y);
				}
				// 매 0.05초 마다 이동
				try {
					sleep(50);

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

	class DressThread2 extends Thread {
		JLabel productJLabel;
		JPanel productJPanel;

		DressThread2(JLabel productJLabel, JPanel productJPanel) {
			this.productJLabel = productJLabel;
			this.productJPanel = productJPanel;
			productJLabel.setLocation(productJPanel.getWidth(), productJPanel.getHeight());
		}

		// 스레드 동작 설정
		public void run() {
			while (true) {
				int x = productJPanel.getX() + 3;
				int y = productJPanel.getY();

				// DressPanel을 벗어 난 경우
				if (x > DressPanel.this.getWidth()) {
					productJPanel.setLocation(0, 0);
				}
				// 벗어나지 않은 경우
				else {
					productJPanel.setLocation(x, y);
				}
				// 매 0.05초 마다 이동
				try {
					sleep(50);

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

	class DressThread3 extends Thread {
		JLabel productJLabel;
		JPanel productJPanel;

		DressThread3(JLabel productJLabel, JPanel productJPanel) {
			this.productJLabel = productJLabel;
			this.productJPanel = productJPanel;
		}

		// 스레드 동작 설정
		public void run() {
			while (true) {
				int x = productJPanel.getX() + 3;
				int y = productJPanel.getY();

				// DressPanel을 벗어 난 경우
				if (x > DressPanel.this.getWidth()) {
					productJPanel.setLocation(0, 0);
				}
				// 벗어나지 않은 경우
				else {
					productJPanel.setLocation(x, y);
				}
				// 매 0.05초 마다 이동
				try {
					sleep(50);

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

	class DressThread4 extends Thread {
		JLabel productJLabel;
		JPanel productJPanel;

		DressThread4(JLabel productJLabel, JPanel productJPanel) {
			this.productJLabel = productJLabel;
			this.productJPanel = productJPanel;
		}

		// 스레드 동작 설정
		public void run() {
			while (true) {
				int x = productJPanel.getX() + 3;
				int y = productJPanel.getY();

				// DressPanel을 벗어 난 경우
				if (x > DressPanel.this.getWidth()) {
					productJPanel.setLocation(0, 0);
				}
				// 벗어나지 않은 경우
				else {
					productJPanel.setLocation(x, y);
				}
				// 매 0.05초 마다 이동
				try {
					sleep(50);

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