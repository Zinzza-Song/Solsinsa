package gui;
import java.awt.Color;
import java.awt.EventQueue;

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
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class MyPage extends JFrame {
	
	private JPanel contentPane;

	private JFrame frame;
	private JLabel myLabel[];
	private JTextField myTextField[];
	private JTable myOrderTable;
	
	
	private JLabel myLabel2[];
	private JTextField myTextField2[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPage window = new MyPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 650);
		setVisible(true);
		setResizable(false);
		
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
		
		
		JLabel myPageLabel = new JLabel("MY Page");
		myPageLabel.setForeground(new Color(255, 255, 255));
		myPageLabel.setFont(new Font("굴림", Font.BOLD, 30));
		myPageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		myPageLabel.setBounds(53, 10, 282, 63);
		changePanel.add(myPageLabel);
		
		JButton btnNewButton = new JButton("수 정");
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 25));
		btnNewButton.setBounds(53, 354, 112, 52);
		changePanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("탈 퇴");
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 25));
		btnNewButton_1.setBounds(207, 354, 112, 52);
		changePanel.add(btnNewButton_1);
		
		//나의 주문 목록 패널
		JPanel panel = new JPanel();
		panel.setBackground(new Color(54, 54, 54));
		panel.setBounds(0, 426, 384, 185);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
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
		//myOrderTable.getTableHeader().setResizingAllowed(false);
		//테이블 컬럼의 사이즈를 고정시킨다. 이걸 사용하면 컬럼 사이즈가 변하지 않는다.
		
		myOrderTable.getColumnModel().getColumn(0).setPreferredWidth(200);
		myOrderTable.getColumnModel().getColumn(1).setPreferredWidth(80);
		myOrderTable.getColumnModel().getColumn(2).setPreferredWidth(80);
		myOrderTable.setBounds(12, 46, 360, 129);
		
				
		
		JLabel lblNewLabel = new JLabel("나의 주문 목록");
		lblNewLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(12, 10, 167, 30);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane(myOrderTable);
		scrollPane.setBounds(12, 46, 360, 129);
		panel.add(scrollPane);
		
		
		
		
		String myNames[]= {"ID","이 름","PW","주소","이메일","전화번호","생년월일"}; 
		int startY =83;
		String myName;  //라벨에 들어갈 이름 
		String myTexts[]={"ID","이 름","PW","주소","이메일","전화번호","생년월일"};;
		String myText;
		
		for(int i=0;i<myNames.length;i++) {
			
			myLabel = new JLabel[7];
			myLabel[i]=new JLabel(myNames[i]);
			myLabel[i].setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 14));
			myLabel[i].setBounds(40, startY,82,24);
			myLabel[i].setForeground(new Color(255, 255, 255));
			changePanel.add(myLabel[i]);
			
			myTextField= new JTextField[7];  //
			myTextField[i]=new JTextField(myTexts[i]);
			myTextField[i].setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 14));
			myTextField[i].setBounds(126,startY,161,24);
			myTextField[i].setEditable(true);  //텍스트필드 수정가능 완료버튼 후 다시 false.
			changePanel.add(myTextField[i]);
			startY+=35;
			
		}
		///////////////////////////////////////////////////////////////////////////
		
		//수정 후 패널
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
		afterPanel.add(myPageLabel);
		
		JButton btnNewButton2 = new JButton("수 정");
		btnNewButton2.setFont(new Font("굴림", Font.PLAIN, 25));
		btnNewButton2.setBounds(53, 354, 112, 52);
		afterPanel.add(btnNewButton2);
		
		JButton btnNewButton3 = new JButton("탈 퇴");
		btnNewButton3.setFont(new Font("굴림", Font.PLAIN, 25));
		btnNewButton3.setBounds(207, 354, 112, 52);
		afterPanel.add(btnNewButton3);
		
		
	
		
		String myNames2[]= {"ID","이 름","PW","주소","이메일","전화번호","생년월일"}; 
		//int startY2 =83;
		String myName2;  //라벨들이 들어갈 이름
		String myTexts2[]={"ID","이 름","PW","주소","이메일","전화번호","생년월일"};; // 수정된 값이 들어와야함
		String myText2;  // 수정된 값이 차례대로 들어갈 변수명
		
		for(int i=0;i<myNames2.length;i++) {
			
			myLabel2 = new JLabel[7];
			myLabel2[i]=new JLabel(myNames2[i]);
			myLabel2[i].setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 14));
			myLabel2[i].setBounds(40, startY,82,24);
			myLabel2[i].setForeground(new Color(255, 255, 255));
			afterPanel.add(myLabel2[i]);
			
			myTextField2= new JTextField[7];  //
			myTextField2[i]=new JTextField(myTexts[i]);
			myTextField2[i].setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 14));
			myTextField2[i].setBounds(126,startY,161,24);
			myTextField2[i].setEditable(false);  //텍스트필드 수정불가
			afterPanel.add(myTextField2[i]);
			startY+=35;
			
		}
		afterPanel.setVisible(false);  //수정누르기전에 false 누르면 true.
		
		
	}
}
