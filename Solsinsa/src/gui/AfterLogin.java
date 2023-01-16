package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import client.Userinfo;

@SuppressWarnings("serial")
public class AfterLogin extends JPanel {

	public AfterLogin(JPanel inputPanel) {
		// 로그인 후 패널

		setBounds(0, 0, 707, 54);
		setBackground(new Color(216, 210, 199));
		setLayout(null);
		// 상단에 표시될 버튼들

		ImageIcon cartIcon = new ImageIcon("./src/icon/Cart1.png");
		Image cartImg = cartIcon.getImage();
		Image changeCartImg = cartImg.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		ImageIcon changeCartIcon = new ImageIcon(changeCartImg);

		// 장바구니 버튼
		JButton cartBtn = new JButton(changeCartIcon);
		cartBtn.setForeground(new Color(255, 255, 255));
		cartBtn.setBackground(new Color(0, 0, 64));
		cartBtn.setBounds(478, 10, 35, 35);
		cartBtn.setFocusPainted(false);
		add(cartBtn);
		cartBtn.setOpaque(true);
		// 버튼 클릭시 장바구니 오픈
		cartBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Cart cart = new Cart();
				cart.setVisible(true);
			}
		});

		ImageIcon myIcon = new ImageIcon("./src/icon/Mypage1.png");
		Image myImg = myIcon.getImage();
		Image changeMyImg = myImg.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		ImageIcon changeMyIcon = new ImageIcon(changeMyImg);

		JPanel afterLoginPanel = this;
		// 마이 페이지 버튼
		JButton mypageBtn = new JButton(changeMyIcon);
		mypageBtn.setBackground(new Color(128, 128, 192));
		mypageBtn.setBounds(544, 10, 35, 35);
		mypageBtn.setFocusPainted(false);
		add(mypageBtn);
		mypageBtn.setOpaque(true);
		mypageBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MyPage my = new MyPage(inputPanel, afterLoginPanel);
				my.setVisible(true);
			}
		});

		// ㅇㅇㅇ님 환영합니다 라벨
		JLabel welcomeLabel = new JLabel(Userinfo.getUserInfo().getId() + "님 환영합니다.");
		welcomeLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 22));
		welcomeLabel.setBounds(158, 8, 192, 35);
		add(welcomeLabel);

		// 로그아웃 버튼

		ImageIcon logoutIcon = new ImageIcon("./src/icon/Logout1.jpg");
		Image logoutImg = logoutIcon.getImage();
		Image changelogoutImg = logoutImg.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		ImageIcon changelogoutIcon = new ImageIcon(changelogoutImg);

		JButton logoutBtn = new JButton(changelogoutIcon);
		logoutBtn.setOpaque(true);
		logoutBtn.setBackground(new Color(128, 128, 192));
		logoutBtn.setBounds(610, 10, 35, 35);
		add(logoutBtn);

		// 로그아웃 클릭 시 액션 리스너
		logoutBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "로그아웃 되었습니다.");
				Userinfo.getUserInfo().Logout();
				inputPanel.setVisible(true);
				setVisible(false);
			}
		});
	}
}