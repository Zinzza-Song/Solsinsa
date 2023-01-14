package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.MouseEvent;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.event.MouseListener;

public class Lookup extends JFrame {
	private JPanel contentPane;

	private JScrollPane productScrolledPane1;
	private JScrollPane logScrolledPane;
	private JScrollPane userScrolledPane;
	private JTable productTable;
	private JTable userTable;
	private JTable logTable;

	/**
	 * Create the frame.
	 */
	public Lookup() {
		setBounds(100, 100, 1000, 660);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton a = new JButton("추가");
		// 상품 테이블에 행 추가하기
		String productHeader[] = { "NO", "NAME", "PRICE", "CTG", "STOCK", "ADD" };
		Object[][] productInformation = { { "상품번호", "상품명", "가격", "카테고리", 100, "추가" },
				{ "상품번호", "상품명", "가격", "카테고리", 100, "추가" }, { "상품번호", "상품명", "가격", "카테고리", 100, "추가" },
				{ "상품번호", "상품명", "가격", "카테고리", 100, "추가" }, { "상품번호", "상품명", "가격", "카테고리", 100, "추가" } };

		// 유저 테이블에 행 추가하기
		String userHeader[] = { "NO", "ID", "PW", "NAME", "BIRTH", "ADDR", "PHONE", "EMAIL" };
		String[][] userInformation = { { "회원번호", "아이디", "비밀번호", "이름", "생일", "주소", "핸드폰", "이메일" },
				{ "회원번호", "아이디", "비밀번호", "이름", "생일", "주소", "핸드폰", "이메일" },
				{ "회원번호", "아이디", "비밀번호", "이름", "생일", "주소", "핸드폰", "이메일" },
				{ "회원번호", "아이디", "비밀번호", "이름", "생일", "주소", "핸드폰", "이메일" },
				{ "회원번호", "아이디", "비밀번호", "이름", "생일", "주소", "핸드폰", "이메일" } };

		// 로그 테이블에 행 추가하기
		String logHeader[] = { "일자", "LOG" };
		String logInformation[][] = { { "0000/00/00", "000님이 회원가입 하셨습니다." }, { "0000/00/00", "상품이름이 추가되었습니다." },
				{ "0000/00/00", "000님이 회원탈퇴 하셨습니다." }, { "0000/00/00", "상품이름이 감소되었습니다." } };

		// 테이블 글자 정렬
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		contentPane.setLayout(null);

		// product테이블
		productTable = new JTable(productInformation, productHeader);
		productTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		productScrolledPane1 = new JScrollPane(productTable);

		productScrolledPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		productScrolledPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		productScrolledPane1.setBounds(5, 5, 480, 282);
		productScrolledPane1.setBorder(new LineBorder(new Color(0, 0, 0)));

		// 컬럼 사이즈 조절
		productTable.getColumnModel().getColumn(0).setMaxWidth(40);
		productTable.getColumnModel().getColumn(0).setMinWidth(50);
		productTable.getColumnModel().getColumn(0).setWidth(50);

		productTable.getColumnModel().getColumn(1).setMinWidth(350);
		productTable.getColumnModel().getColumn(1).setWidth(350);

		// product테이블 글자 정렬
		for (int i = 0; i < 6; i++) {
			productTable.getColumn(productHeader[i]).setCellRenderer(celAlignCenter);
		}
		getContentPane().add(productScrolledPane1);

		// product 테이블 추가 버튼 클릭 시
		productTable.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = productTable.getSelectedRow();
				Object value = productTable.getValueAt(row,4);
				int add = (Integer)value;
				add += 1;
				value = (Object)add;
				productTable.setValueAt(value, row, 4);

			}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}});


		// customer테이블
		userTable = new JTable(userInformation, userHeader);
		userTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		userTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		userScrolledPane = new JScrollPane(userTable);
		userScrolledPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		userScrolledPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		userScrolledPane.setBounds(500, 5, 480, 282);
		userScrolledPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		// 컬럼 사이즈 조절
		userTable.getColumnModel().getColumn(0).setMaxWidth(40);
		userTable.getColumnModel().getColumn(0).setMinWidth(40);
		userTable.getColumnModel().getColumn(0).setWidth(40);

		userTable.getColumnModel().getColumn(4).setMinWidth(100);
		userTable.getColumnModel().getColumn(4).setWidth(100);

		userTable.getColumnModel().getColumn(5).setMinWidth(100);
		userTable.getColumnModel().getColumn(5).setWidth(100);

		userTable.getColumnModel().getColumn(6).setMinWidth(100);
		userTable.getColumnModel().getColumn(6).setWidth(100);

		userTable.getColumnModel().getColumn(7).setMinWidth(100);
		userTable.getColumnModel().getColumn(7).setWidth(100);

		// customer테이블 글자 정렬
		for (int i = 0; i < 8; i++) {
			userTable.getColumn(userHeader[i]).setCellRenderer(celAlignCenter);
		}
		contentPane.add(userScrolledPane);

		// log테이블
		logTable = new JTable(logInformation, logHeader);
		logTable.setCellSelectionEnabled(true);
		logTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		logTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

//		logTable.getColumnModel().getColumn(0).setMaxWidth(80);
		logTable.getColumnModel().getColumn(0).setMinWidth(80);
//		logTable.getColumnModel().getColumn(0).setWidth(80);
		
		logTable.getColumnModel().getColumn(1).setMinWidth(920);
		logTable.getColumnModel().getColumn(1).setWidth(920);

		// log테이블 글자 정렬
		logTable.getColumn("일자").setCellRenderer(celAlignCenter);

		logScrolledPane = new JScrollPane(logTable);
		logScrolledPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		logScrolledPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		logScrolledPane.setBounds(5, 330, 980, 291);
		logScrolledPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(logScrolledPane);

		JButton custLog = new JButton("회원로그조회");
		custLog.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		custLog.setBounds(291, 297, 119, 23);
		contentPane.add(custLog);

		JButton productLog = new JButton("상품로그조회");
		productLog.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		productLog.setBounds(153, 296, 119, 23);
		contentPane.add(productLog);

		JButton allLog = new JButton("전체로그조회");
		allLog.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		allLog.setBounds(15, 296, 119, 23);
		contentPane.add(allLog);
		// 조회프레임 닫을 경우 기본 홈 화면으로 돌아가기
		this.addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {
			}

			@Override
			public void windowClosing(WindowEvent e) {
				Home home = new Home();
				home.setVisible(true);
				dispose();
			}

			@Override
			public void windowClosed(WindowEvent e) {
			}

			@Override
			public void windowIconified(WindowEvent e) {
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
			}

			@Override
			public void windowActivated(WindowEvent e) {
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
			}
		});

		// 버튼으로 바꾸고 싶은 컬럼 번호를 변경해주기
		// 테이블의 각 셀들은 텍스트필드로 구성되어 있기 때문에 랜더를 통해서
		// 텍스트 필드에 버튼을 넣어야 한다.
		productTable.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
		productTable.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JTextField()));

	}

	// BUTTON RENDERER 클래스
	class ButtonRenderer extends JButton implements TableCellRenderer {

		public ButtonRenderer() {
			// 버튼 속성 설정
			setOpaque(true);
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object obj, boolean selected, boolean focused,
				int row, int col) {

			setText((obj == null) ? "" : obj.toString());

			return this;
		}

	}

	// BUTTON EDITOR 클래스
	class ButtonEditor extends DefaultCellEditor {
		protected JButton btn;
		private String lbl;
		private Boolean clicked;

		public ButtonEditor(JTextField txt) {
			super(txt);

			btn = new JButton();
			btn.setOpaque(true);

			// 버튼 클릭 시
			btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					fireEditingStopped();
				}
			});
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object obj, boolean selected, int row, int col) {

			lbl = (obj == null) ? "" : obj.toString();
			btn.setText(lbl);
			clicked = true;
			return btn;
		}

		// 버튼 클릭 시
		@Override
		public Object getCellEditorValue() {

			if (clicked) {
				int a = (Integer) productTable.getValueAt(4, 4) + 1;
			}
			// 클릭한 즉시 "추가"텍스트를 덧씌워줌
			// 이게 없으면 버튼 클릭 시 텍스트 지워지
			clicked = false;
			return new String(lbl);
		}

		@Override
		public boolean stopCellEditing() {

			// 처음에 거짓으로 설정해줘야 인식 가능
			clicked = false;
			return super.stopCellEditing();
		}

		@Override
		protected void fireEditingStopped() {
			// TODO Auto-generated method stub
			super.fireEditingStopped();
		}
	}
}