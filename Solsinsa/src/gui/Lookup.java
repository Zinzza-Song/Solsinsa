package gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class Lookup extends JFrame {

	private JPanel contentPane;

	private JScrollPane productScrolledPane1;
	private JScrollPane logScrolledPane;
	private JScrollPane userScrolledPane;
	private JTable productTable;
	private JTable userTable;
	private JTable logTable;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lookup frame = new Lookup();
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
	public Lookup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 797, 613);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// 상품 테이블에 행 추가하기
		String productHeader[] = { "NO", "NAME", "PRICE", "CTG", "STOCK" };
		String[][] productInformation = { { "상품번호", "상품명", "가격", "카테고리", "재고" }, { "상품번호", "상품명", "가격", "카테고리", "재고" },
				{ "상품번호", "상품명", "가격", "카테고리", "재고" }, { "상품번호", "상품명", "가격", "카테고리", "재고" },
				{ "상품번호", "상품명", "가격", "카테고리", "재고" } };

		// 유저 테이블에 행 추가하기
		String userHeader[] = { "ID", "PW", "NAME", "BIRTH", "ADDR", "PHONE", "EMAIL" };
		String[][] userInformation = { { "아이디", "비밀번호", "이름", "생일", "주소", "핸드폰", "이메일" },
				{ "아이디", "비밀번호", "이름", "생일", "주소", "핸드폰", "이메일" }, { "아이디", "비밀번호", "이름", "생일", "주소", "핸드폰", "이메일" },
				{ "아이디", "비밀번호", "이름", "생일", "주소", "핸드폰", "이메일" }, { "아이디", "비밀번호", "이름", "생일", "주소", "핸드폰", "이메일" } };

		// 로그 테이블에 행 추가하기
		String logHeader[] = { "NO", "LOG" };
		String logInformation[][] = { { "번호", "000님이 회원가입 하셨습니다." }, { "번호", "상품이름이 추가되었습니다." },
				{ "번호", "000님이 회원탈퇴 하셨습니다." }, { "번호", "상품이름이 감소되었습니다." } };
		
		// 테이블 글자 정렬
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		contentPane.setLayout(null);
		
		//product테이블
		productTable = new JTable(productInformation, productHeader);
		productTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		productScrolledPane1 = new JScrollPane(productTable);
		productScrolledPane1.setBounds(5, 5, 386, 282);
		productScrolledPane1.setBorder(new LineBorder(new Color(0, 0, 0)));
		//product테이블 글자 정렬
		for(int i = 0; i < 5; i++) {
		productTable.getColumn(productHeader[i]).setCellRenderer(celAlignCenter);
		}
		getContentPane().add(productScrolledPane1);
		
		//customer테이블
		userTable = new JTable(userInformation, userHeader);
		userTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		userScrolledPane = new JScrollPane(userTable);
		userScrolledPane.setBounds(397, 5, 386, 282);
		userScrolledPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		//customer테이블 글자 정렬
		for(int i = 0; i < 7; i++) {
			userTable.getColumn(userHeader[i]).setCellRenderer(celAlignCenter);
		}
		contentPane.add(userScrolledPane);
		
		//log테이블
		logTable = new JTable(logInformation, logHeader);
		logTable.setCellSelectionEnabled(true);
		logTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		logTable.getColumnModel().getColumn(0).setMaxWidth(60);
		logTable.getColumnModel().getColumn(0).setMinWidth(60);
		logTable.getColumnModel().getColumn(0).setWidth(60);
		
		logTable.getColumnModel().getColumn(1).setMaxWidth(720);
		logTable.getColumnModel().getColumn(1).setMinWidth(720);
		logTable.getColumnModel().getColumn(1).setWidth(720);
		//log테이블 글자 정렬
		logTable.getColumn("NO").setCellRenderer(celAlignCenter);
		
		logScrolledPane = new JScrollPane(logTable);
		logScrolledPane.setBounds(0, 294, 783, 282);
		logScrolledPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(logScrolledPane);
}
}