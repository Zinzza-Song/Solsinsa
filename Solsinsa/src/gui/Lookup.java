package gui;

import jdbc.JdbcConnector;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.Component;
import javax.swing.table.TableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Lookup extends JFrame {

	private JPanel contentPane;

	private JScrollPane productScrolledPane1;
	private JScrollPane customerScrolledPane;
	private JScrollPane logScrolledPane;
	private JTable productTable;
	private JTable customerTable;
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

		contentPane.setLayout(null);

		productTable = new JTable(productInformation, productHeader);
		productTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		productScrolledPane1 = new JScrollPane(productTable);
		productScrolledPane1.setBounds(5, 5, 386, 282);
		productScrolledPane1.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(productScrolledPane1);

		customerTable = new JTable(logInformation, logHeader);
		customerTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		customerScrolledPane = new JScrollPane(customerTable);
		customerScrolledPane.setBounds(0, 294, 783, 282);
		customerScrolledPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(customerScrolledPane);

		logTable = new JTable(userInformation, userHeader);
		logTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//		logTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		logTable.getColumn("LOG").setPreferredWidth(700);
		logScrolledPane = new JScrollPane(logTable);
		

		logScrolledPane.setBounds(397, 5, 386, 282);
		logScrolledPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(logScrolledPane);
	}
}
