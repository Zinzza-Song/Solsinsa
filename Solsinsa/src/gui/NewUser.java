package gui;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import client.Client;

public class NewUser extends JFrame {

	private JPanel contentPane;
	private JLabel signUpLabel;
	
	private JLabel idLabel;
	private JTextField idTextField;
	private JLabel nameLabel;
	private JTextField nameTextField;
	private JButton reduplicationCheckBtn;
	private JLabel pwLabel;
	private JPasswordField pwTextField;
	private JLabel pwCheckLabel;
	private JPasswordField pwCheckTextField;
	private JLabel addressLabel;
	private JTextField addressTextField;
	private JLabel emailLabel;
	private JTextField emailTextField;
	private JLabel phoneLabel;
	private JTextField phoneTextField;
	private JLabel BirthLabel;
	private JTextField BirthTextField;
	
	//형식 확인용 (정규표현식 사용)
	private static final String NAME_PATTERN = "^[가-힣]{2,5}$";
	private static final String EMAIL_PATTERN = "^[0-9a-zA-Z]+@[0-9a-zA-Z]+\\.[a-zA-Z]+$";
	private static final String PHONE_PATTERN = "^01(?:[0-9])-(?:\\d{3,4})-\\d{4}$";
	private static final String BIRTH_PATTERN = "^(19[0-9][0-9]|20\\d{2})-(0[0-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$";
	
		public NewUser() {
		setBounds(100, 100, 425, 419);  //위치 사이즈설정
		setResizable(false);   //사이즈 조절 불가능
		contentPane = new JPanel(); 
		contentPane.setBackground(new Color(216,210,199));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		//회원가입라벨
		signUpLabel = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		signUpLabel.setForeground(new Color(255, 255, 255));
		signUpLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 23));
		signUpLabel.setBackground(new Color(60, 61, 72));  //라벨 배경색
		signUpLabel.setBounds(109, 10, 180, 33);
		signUpLabel.setOpaque(true);   //라벨에 배경색 입히는 코드
		signUpLabel.setHorizontalAlignment(JLabel.CENTER);  //중앙정렬
		contentPane.add(signUpLabel);
		
		//id라벨
		idLabel = new JLabel("ID");
		idLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 14));
		idLabel.setBounds(12, 58, 84, 24);
		contentPane.add(idLabel);
		
		//id입력받는창
		idTextField = new JTextField();
		idTextField.setHorizontalAlignment(SwingConstants.LEFT);
		idTextField.setBounds(108, 60, 181, 22);
		contentPane.add(idTextField);
		idTextField.setColumns(10);
		
		//중복확인버튼
		JButton reduplicationCheckBtn = new Rb("\uC911\uBCF5\uD655\uC778");
		reduplicationCheckBtn.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 14));
		reduplicationCheckBtn.setBounds(301, 59, 97, 23);
		reduplicationCheckBtn.setFocusPainted(false);
		contentPane.add(reduplicationCheckBtn);
		reduplicationCheckBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String data = idTextField.getText(); // 중복검사를 할 아이디
				String code = ":1002"; // 중복검사 프로토콜 코드
				Client.msg = data + code; // 서버로 중복검사를 할 아이디와 프로토콜 코드를 알려줘 중복검사 작업을 요청
				System.out.println(Client.msg);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				} // 응답을 받기위한 대기시간
				String str = Client.ans; // 서버 응답(중복검사 결과)
				int check = Integer.parseInt(str); // 해당 결과를 정수로 형변환
				
				// 서버가 응답한 결과에 따른 처리
				if(check == -1) {
					JOptionPane.showMessageDialog(null, "아이디가 이미 존재합니다.");
					idTextField.setText("");
				} else if(check == -2) {
					JOptionPane.showMessageDialog(null, "아이디가 검색 중 오류가 발생");
				} else if(check == 0) {
					JOptionPane.showMessageDialog(null, "아이디가 사용 가능합니다.");
				}
			}
		});
		
		//이름 라벨
		nameLabel = new JLabel("\uC774 \uB984");
		nameLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 14));
		nameLabel.setBounds(12, 92, 84, 24);
		contentPane.add(nameLabel);
		
		//이름입력받는창
		nameTextField = new JTextField();
		nameTextField.setHorizontalAlignment(SwingConstants.LEFT);
		nameTextField.setColumns(10);
		nameTextField.setBounds(108, 94, 181, 22);
		contentPane.add(nameTextField);
		
		//비밀번호 라벨
		pwLabel = new JLabel("PW");
		pwLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 14));
		pwLabel.setBounds(12, 126, 84, 24);
		contentPane.add(pwLabel);
		
		//비번입력창
		pwTextField = new JPasswordField();         //JPasswordField
		pwTextField.setHorizontalAlignment(SwingConstants.LEFT);
		pwTextField.setColumns(10);
		pwTextField.setBounds(108, 128, 181, 22);
		contentPane.add(pwTextField);
		
		//비밀번호 확인 라벨
		pwCheckLabel = new JLabel("PW \uD655\uC778");
		pwCheckLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 14));
		pwCheckLabel.setBounds(12, 160, 84, 24);
		contentPane.add(pwCheckLabel);
		
		//비번체크창
		pwCheckTextField = new JPasswordField();
		pwCheckTextField.setHorizontalAlignment(SwingConstants.LEFT);
		pwCheckTextField.setColumns(10);
		pwCheckTextField.setBounds(108, 162, 181, 22);
		contentPane.add(pwCheckTextField);
		
		//주소 라벨
		addressLabel = new JLabel("\uC8FC \uC18C");
		addressLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 14));
		addressLabel.setBounds(12, 194, 84, 24);
		contentPane.add(addressLabel);
		//주소 입력 창
		addressTextField = new JTextField();
		addressTextField.setHorizontalAlignment(SwingConstants.LEFT);
		addressTextField.setColumns(10);
		addressTextField.setBounds(108, 196, 181, 22);
		contentPane.add(addressTextField);
		
		//이메일 라벨
		emailLabel = new JLabel("\uC774\uBA54\uC77C");
		emailLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 14));
		emailLabel.setBounds(12, 228, 84, 24);
		contentPane.add(emailLabel);
		//이메일 입력창
		emailTextField = new JTextField();
		emailTextField.setHorizontalAlignment(SwingConstants.LEFT);
		emailTextField.setColumns(10);
		emailTextField.setBounds(108, 230, 181, 22);
		contentPane.add(emailTextField);
		
		//전화번호 라벨
		phoneLabel = new JLabel("\uC804\uD654\uBC88\uD638");
		phoneLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 14));
		phoneLabel.setBounds(12, 262, 84, 24);
		contentPane.add(phoneLabel);
		//전화번호 입력창
		phoneTextField = new JTextField();
		phoneTextField.setHorizontalAlignment(SwingConstants.LEFT);
		phoneTextField.setColumns(10);
		phoneTextField.setBounds(108, 264, 181, 22);
		contentPane.add(phoneTextField);
		
		// 생년월일 라벨
		BirthLabel = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		BirthLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 14));
		BirthLabel.setBounds(12, 296, 84, 24);
		contentPane.add(BirthLabel);
		// 생년월일 입력 창
		BirthTextField = new JTextField();
		BirthTextField.setHorizontalAlignment(SwingConstants.LEFT);
		BirthTextField.setColumns(10);
		BirthTextField.setBounds(108, 298, 181, 22);
		contentPane.add(BirthTextField);
		BirthTextField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent k) {
				JTextField src = (JTextField)k.getSource();
				if(src.getText().length() >= 11){
					k.consume();
				}
			}
		});
		
		//회원가입 버튼
		JButton confirmBtn = new Rb("회원가입완료");
		confirmBtn.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 14));
		confirmBtn.setBounds(205, 346, 84, 23);
		confirmBtn.setFocusPainted(false);
		contentPane.add(confirmBtn);
		//회원 가입 버튼 클릭 시 액션 리스너
		confirmBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if((idTextField.getText() == null || idTextField.getText().length() == 0) || (pwTextField.getText() == null || pwTextField.getText().length() == 0)||
						(pwCheckTextField.getText() == null || pwCheckTextField.getText().length() == 0) || (addressTextField.getText() == null|| addressTextField.getText().length() == 0)||
						(emailTextField.getText() == null || emailTextField.getText().length() == 0)||(phoneTextField.getText() == null || phoneTextField.getText().length() == 0)||
						(BirthTextField.getText() == null || BirthTextField.getText().length() == 0)) {
					JOptionPane.showMessageDialog(null, "모든 정보를 입력해 주세요");
				}
				// 비밀번호가 일치하지 않으면 다이어로그 호출로 회원가입 방지
				if(!pwTextField.getText().equals(pwCheckTextField.getText())) {
					pwTextField.setText("");
					pwCheckTextField.setText("");
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
				}
				// 이름 입력
				else if(Pattern.matches(NAME_PATTERN,nameTextField.getText()) == false) {
					nameTextField.setText("");
					JOptionPane.showMessageDialog(null, "이름은 한글로 작성해 주세요 ( 2글자 ~ 5글자 )");
				}
				// 전화번호 입력
				else if(Pattern.matches(PHONE_PATTERN,phoneTextField.getText()) == false) {
					phoneTextField.setText("");
					JOptionPane.showMessageDialog(null, "전화번호를 형식에 맞게 작성해주세요\n01(0 ~ 9) - 0000 - 0000");
				}
				//이메일 입력
				else if(Pattern.matches(EMAIL_PATTERN,emailTextField.getText()) == false) {
					emailTextField.setText("");
					JOptionPane.showMessageDialog(null, "이메일을 형식에 맞게 입력해 주세요 ( 영어, 숫자 사용 )\n계정 @ 도메인 .com");
				}
				//생일 입력
				else if(Pattern.matches(BIRTH_PATTERN,BirthTextField.getText()) == false) {
					BirthTextField.setText("");
					JOptionPane.showMessageDialog(null, "생년월일을 형식에 맞게 입력해 주세요\n(1900 또는 2000) - (01 ~ 12) - (01 ~ 31)");
				}
				
				else if((idTextField.getText() != null && idTextField.getText().length() != 0) || (pwTextField.getText() != null || pwTextField.getText().length() != 0)||
						(pwCheckTextField.getText() != null && pwCheckTextField.getText().length() != 0) || (addressTextField.getText() != null|| addressTextField.getText().length() != 0)||
						(emailTextField.getText() != null && emailTextField.getText().length() != 0)||(phoneTextField.getText() != null || phoneTextField.getText().length() != 0)||
						(BirthTextField.getText() != null && BirthTextField.getText().length() != 0)) {
					
					String id = idTextField.getText() + ",";
					String pw = pwTextField.getText() + ",";
					String name = nameTextField.getText() + ",";
					String date = BirthTextField.getText() + ",";
					String address = addressTextField.getText() + ",";
					String phone = phoneTextField.getText() + ",";
					String email = emailTextField.getText(); // 고객 테이블에 들어갈 데이터들
					
					String data = id + pw + name + date + address + phone + email; // 회원가입을 위한 데이터 세팅
					String code = ":1001"; // 회원가입을 위한 프로토콜 코드 세팅
					
					Client.msg = data + code; // 서버로 세팅한 데이터와 코드를 알려준다.
					
					JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
					dispose();
				}
		}});
		
		//취소버튼
		JButton cancleBtn = new Rb("\uCDE8 \uC18C");
		cancleBtn.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 14));
		cancleBtn.setBounds(301, 346, 84, 23);
		cancleBtn.setFocusPainted(false);
		contentPane.add(cancleBtn);
		cancleBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//프레임 종료
				dispose();
				AfterLogin after = new AfterLogin();
				after.setVisible(false);
			}
			
		});
	}

}
