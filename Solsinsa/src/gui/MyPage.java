package gui;
import java.awt.*;
import java.awt.event.*;
import java.util.StringTokenizer;

import javax.swing.*;
import javax.swing.border.*;

import client.Client;
import client.Userinfo;

public class MyPage extends JFrame {
	
	private JPanel contentPane;
	private JFrame frame;
	private JLabel myLabel[];
	private JTextField myTextField[];
	private JTable myOrderTable;
	private JLabel myLabel2[];
	private JTextField myTextField2[];
	private JPanel inputPanel;
	private JPanel afterLoginPanel;

	public MyPage(JPanel inputPanel, JPanel afterLoginPanel) {
		this.inputPanel = inputPanel;
		this.afterLoginPanel = afterLoginPanel;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setBounds(100, 100, 400, 650);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 226, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//수정전 패널
		JPanel changePanel=new JPanel();
		changePanel.setBackground(new Color(25, 25, 25));
		changePanel.setBounds(0, 0, 384, 430);
		contentPane.add(changePanel);
		changePanel.setLayout(null);
		changePanel.setVisible(true);  //수정누르면 false;
		//마이페이지 제목
		JLabel myPageLabel = new JLabel("MY Page");
		myPageLabel.setForeground(new Color(255, 255, 255));
		myPageLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 30));
		myPageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		myPageLabel.setBounds(53, 10, 282, 63);
		changePanel.add(myPageLabel);
		//정보 수정 버튼
		JButton modifyBtn = new JButton("수 정");
		modifyBtn.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 25));
		modifyBtn.setBounds(53, 354, 112, 52);
		changePanel.add(modifyBtn);
		//회원 탈퇴 버튼
		JButton ResignBtn = new JButton("탈 퇴");
		ResignBtn.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 25));
		ResignBtn.setBounds(207, 354, 112, 52);
		changePanel.add(ResignBtn);
		
		//나의 주문 목록 패널
		JPanel orderPanel = new JPanel();
		orderPanel.setBackground(new Color(54, 54, 54));
		orderPanel.setBounds(0, 426, 384, 185);
		contentPane.add(orderPanel);
		orderPanel.setLayout(null);
		
		Client.msg = Userinfo.getUserInfo().getNo() + ":1009";
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		String str = Client.ans;
		StringTokenizer st = new StringTokenizer(str, "/");
		
		//주문 목록 조회 테이블 
		int orderCnt= st.countTokens();  //주문완료한 상품의 개수 
		String myOrderListHeader[]= {"상품명", "가 격", "주문일"};
		String[][] myOrder = new String[orderCnt][3];
		for(int i = 0; i < orderCnt; ++i) {
			String item = st.nextToken();
			StringTokenizer itemst = new StringTokenizer(item, ",");
			myOrder[i][0] = itemst.nextToken();
			myOrder[i][1] = itemst.nextToken();
			myOrder[i][2] = itemst.nextToken();
		}
		
		myOrderTable = new JTable(myOrder,myOrderListHeader);
		myOrderTable.setCellSelectionEnabled(true);
		myOrderTable.setColumnSelectionAllowed(true);
		myOrderTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		//테이블 로우를 한개만 선택가능하게 한다 오직 한개의 로우만 선택할 수 있다
		
		myOrderTable.getTableHeader().setReorderingAllowed(false);
		//테이블의 컬럼 이동을 제한
		myOrderTable.getTableHeader().setResizingAllowed(false);
		//테이블 컬럼의 사이즈를 고정시킨다. 이걸 사용하면 컬럼 사이즈가 변하지 않는다.
		
		myOrderTable.getColumnModel().getColumn(0).setPreferredWidth(200);
		myOrderTable.getColumnModel().getColumn(1).setPreferredWidth(80);
		myOrderTable.getColumnModel().getColumn(2).setPreferredWidth(80);
		myOrderTable.setBounds(12, 46, 360, 129);
		
		JLabel orderLabel = new JLabel("나의 주문 목록");
		orderLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 18));
		orderLabel.setForeground(new Color(255, 255, 255));
		orderLabel.setBounds(12, 10, 167, 30);
		orderPanel.add(orderLabel);
		
		JScrollPane scrollPane = new JScrollPane(myOrderTable);
		scrollPane.setBounds(12, 46, 360, 129);
		orderPanel.add(scrollPane);
		
		String userNames[]= {"이 름", "ID","PW","주소","전화번호","이메일","생년월일"};
		int startY =83;
		String userName;  //라벨에 들어갈 이름
		
		String id = Userinfo.getUserInfo().getId();
		String name = Userinfo.getUserInfo().getName();
		String pw = Userinfo.getUserInfo().getPw();
		String addr = Userinfo.getUserInfo().getAddr();
		String mail = Userinfo.getUserInfo().getMail();
		String phone = Userinfo.getUserInfo().getPhone();
		String birth = Userinfo.getUserInfo().getBirth();
		String userTexts[]={name,id,pw,addr,phone,mail,birth};
		
		JTextField[] setTextFields = new JTextField[userNames.length];
		
		//마이 페이지 유저 정보란 
		for(int i=0;i<userNames.length;i++) {
			
			myLabel = new JLabel[7];
			myLabel[i]=new JLabel(userNames[i]);
			myLabel[i].setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 14));
			myLabel[i].setBounds(40, startY,82,24);
			myLabel[i].setForeground(new Color(255, 255, 255));
			changePanel.add(myLabel[i]);
			//유저 정보 입력 텍스트 필드들
			myTextField= new JTextField[7]; 
			myTextField[i]=new JTextField(userTexts[i]);
			myTextField[i].setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 14));
			myTextField[i].setBounds(126,startY,161,24);
			myTextField[i].setEditable(false);   //텍스트필드 수정불가 
			changePanel.add(myTextField[i]);
			setTextFields[i] = myTextField[i];
			startY+=35;
		}
		
		///////////////////////////////////////////////////////////////////////////
		//수정 클릭 후 패널
		
		JPanel afterPanel = new JPanel();
		afterPanel.setBackground(new Color(25, 25, 25));
		afterPanel.setBounds(0, 0, 384, 430);
		contentPane.add(afterPanel);
		afterPanel.setLayout(null);
		
		JLabel myPageLabel2 = new JLabel("MY Page");
		myPageLabel2.setForeground(new Color(255, 255, 255));
		myPageLabel2.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 30));
		myPageLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		myPageLabel2.setBounds(53, 10, 282, 63);
		afterPanel.add(myPageLabel2);
		
		JButton okBtn = new JButton("수정완료");
		okBtn.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 20));
		okBtn.setBounds(53, 354, 112, 52);
		afterPanel.add(okBtn);
		
		JButton cancleBtn = new JButton("취 소");
		cancleBtn.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 25));
		cancleBtn.setBounds(207, 354, 112, 52);
		afterPanel.add(cancleBtn);
		
		String userNames2[]= {"이 름", "ID","PW","주소","전화번호","이메일","생년월일"}; 
		int startY2 =83;
		String myName2;  // 라벨들이 들어갈 이름
		String userTexts2[]={name,id,pw,addr,phone,mail,birth}; // 수정된 값이 들어와야함
		String myText2;  // 수정된 값이 차례대로 들어갈 변수명
		
		JTextField[] updatesFields = new JTextField[userNames2.length];
		for(int i=0;i<userNames2.length;i++) {
			
			myLabel2 = new JLabel[7];
			myLabel2[i]=new JLabel(userNames2[i]);
			myLabel2[i].setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 14));
			myLabel2[i].setBounds(40, startY2,82,24);
			myLabel2[i].setForeground(new Color(255, 255, 255));
			afterPanel.add(myLabel2[i]);
			
			myTextField2= new JTextField[7];  //
			myTextField2[i]=new JTextField(userTexts2[i]);
			myTextField2[i].setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 14));
			myTextField2[i].setBounds(126,startY2,161,24);
			myTextField2[i].setEditable(true); //
			afterPanel.add(myTextField2[i]);
			updatesFields[i] = myTextField2[i];
			startY2+=35;
			
		}
		afterPanel.setVisible(false);  //수정누르기전에 false 누르면 true.
		
		// 수정 버튼 클릭 시 텍스트 수정가능하게 변화
		modifyBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel.setVisible(false);
				afterPanel.setVisible(true);
			}
		});
		// 회원 탈퇴 버튼 클릭 시 회원 탈퇴
		ResignBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			int result = JOptionPane.showConfirmDialog(null, "정말로 회원 탈퇴하시겠습니까?","회원탈퇴여부",JOptionPane.YES_NO_OPTION);
				// 예 버튼 클릭 시 초기 홈 표출
			if(JOptionPane.YES_OPTION == result) {
					// 이곳에 회원 탈퇴 시 기능 작성
				String id = Userinfo.getUserInfo().getId();
				String pw = Userinfo.getUserInfo().getPw();
				Client.msg = id + "," + pw + ":1008";
				inputPanel.setVisible(true);
				afterLoginPanel.setVisible(false);
				Userinfo.getUserInfo().Logout();
				dispose();
				}
//			else if(JOptionPane.NO_OPTION == result) {
//				
//			}
			}
			
		});
		// 수정 완료 버튼 클릭 후 원래 패널 변경
		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String updateUserInfo = "";
				for(int i = 0;  i < updatesFields.length; ++i) {
					setTextFields[i].setText(updatesFields[i].getText());
					if(i != 0 && i != updatesFields.length - 1) {
						if(i == updatesFields.length - 2)
							updateUserInfo += updatesFields[i].getText();
						else 
							updateUserInfo += updatesFields[i].getText() + ",";
					}
				}
				
				Client.msg = updateUserInfo + ":1007";
				
				Userinfo.getUserInfo().setPw(updatesFields[2].getText());
				Userinfo.getUserInfo().setAddr(updatesFields[3].getText());
				Userinfo.getUserInfo().setPhone(updatesFields[4].getText());
				Userinfo.getUserInfo().setMail(updatesFields[5].getText());
				changePanel.setVisible(true);
				afterPanel.setVisible(false);
			}
		});
		// 취소 버튼 입력 시 돌아옴
		cancleBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel.setVisible(true);
				afterPanel.setVisible(false);
			}
		});
	}
}
