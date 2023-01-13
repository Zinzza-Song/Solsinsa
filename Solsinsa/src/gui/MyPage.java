package gui;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.*;

import java.awt.*;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.*;

public class MyPage extends JFrame {
	
	private JPanel contentPane;
	private JFrame frame;
	private JLabel myLabel[];
	private JTextField myTextField[];
	private JTable myOrderTable;
	private JLabel myLabel2[];
	private JTextField myTextField2[];

	// 137 번 줄 myTextField[i]=new JTextField(userTexts[i]);에 유저 정보 입력하시면 됩니다!
	
	public MyPage() {
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
		
		
		JLabel myPageLabel = new JLabel("MY Page");
		myPageLabel.setForeground(new Color(255, 255, 255));
		myPageLabel.setFont(new Font("굴림", Font.BOLD, 30));
		myPageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		myPageLabel.setBounds(53, 10, 282, 63);
		changePanel.add(myPageLabel);
		
		JButton modifyBtn = new JButton("수 정");
		modifyBtn.setFont(new Font("굴림", Font.PLAIN, 25));
		modifyBtn.setBounds(53, 354, 112, 52);
		changePanel.add(modifyBtn);
		
		JButton ResignBtn = new JButton("탈 퇴");
		ResignBtn.setFont(new Font("굴림", Font.PLAIN, 25));
		ResignBtn.setBounds(207, 354, 112, 52);
		changePanel.add(ResignBtn);
		
		//나의 주문 목록 패널
		JPanel orderPanel = new JPanel();
		orderPanel.setBackground(new Color(54, 54, 54));
		orderPanel.setBounds(0, 426, 384, 185);
		contentPane.add(orderPanel);
		orderPanel.setLayout(null);
		
		
		//주문 목록 조회 테이블 
		int orderCnt=2;  //주문완료한 상품의 개수 
		String myOrderListHeader[]= {"상품명", "가 격", "주문일"};
		
		//String myOrder[][]=new String[orderCnt][3];
		String myOrder[][]={{"Velour Soccer Jersey Black", "82,000", "2023-01-11"},
				{"Flat Single Coat (Black)", "69,000", "2023-01-11"}};
		
		
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
		
		String userNames[]= {"ID","이 름","PW","주소","이메일","전화번호","생년월일"}; 
		int startY =83;
		String userName;  //라벨에 들어갈 이름 
		String userTexts[]={"ID","이 름","PW","주소","이메일","전화번호","생년월일"};;
		String userText;
		
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
		myPageLabel2.setFont(new Font("굴림", Font.BOLD, 30));
		myPageLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		myPageLabel2.setBounds(53, 10, 282, 63);
		afterPanel.add(myPageLabel2);
		
		JButton okBtn = new JButton("수 정 완 료");
		okBtn.setFont(new Font("굴림", Font.PLAIN, 25));
		okBtn.setBounds(53, 354, 112, 52);
		afterPanel.add(okBtn);
		
		JButton cancleBtn = new JButton("취 소");
		cancleBtn.setFont(new Font("굴림", Font.PLAIN, 25));
		cancleBtn.setBounds(207, 354, 112, 52);
		afterPanel.add(cancleBtn);
		
		
	
		
		String userNames2[]= {"ID","이 름","PW","주소","이메일","전화번호","생년월일"}; 
		int startY2 =83;
		String myName2;  //라벨들이 들어갈 이름
		String userTexts2[]={"ID","이 름","PW","주소","이메일","전화번호","생년월일"}; // 수정된 값이 들어와야함
		String myText2;  // 수정된 값이 차례대로 들어갈 변수명
		
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
			startY2+=35;
			
		}
		
		afterPanel.setVisible(false);  //수정누르기전에 false 누르면 true.
		
		//수정 버튼 클릭 시 텍스트 수정가능하게 변화
		modifyBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel.setVisible(false);
				afterPanel.setVisible(true);
			}
		});
		//회원 탈퇴 버튼 클릭 시 회원 탈퇴
		ResignBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			int result = JOptionPane.showConfirmDialog(null, "정말로 회원 탈퇴하시겠습니까?","Confirm",JOptionPane.YES_NO_OPTION);
				// 예 버튼 클릭 시 초기 홈 표출
			if(JOptionPane.YES_OPTION == result) {
					// 이곳에 회원 탈퇴 시 기능 작성
				Home h = new Home();
				h.setVisible(true);
				
				dispose();
				}
			else if(JOptionPane.NO_OPTION == result) {
				
			}
			}
			
		});
		// 수정 완료 버튼 클릭 후 원래 패널 변경
		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
