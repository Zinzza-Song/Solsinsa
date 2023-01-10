package gui;
import jdbc.JdbcConnector;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class NewUser extends JFrame {

	private JPanel contentPane;
	private JTextField idTextField;
	private JTextField nameTextField;
	private JPasswordField pwTextField;
	private JPasswordField pwCheckTextField;
	private JTextField addressTextField;
	private JTextField emailTextField;
	private JTextField phoneTextField;
	private JTextField dateOfBirthTextField;
	
	public NewUser() {
		setBounds(100, 100, 425, 419);  //위치 사이즈설정
		setResizable(false);   //사이즈 조절 불가능
		contentPane = new JPanel(); 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//회원가입라벨
		JLabel signUpLabel = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		signUpLabel.setForeground(new Color(255, 255, 255));
		signUpLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 23));
		signUpLabel.setBackground(new Color(60, 61, 72));  //라벨 배경색
		signUpLabel.setBounds(109, 10, 180, 33);
		signUpLabel.setOpaque(true);   //라벨에 배경색 입히는 코드
		signUpLabel.setHorizontalAlignment(JLabel.CENTER);  //중앙정렬
		
		contentPane.add(signUpLabel);
		
		JLabel idLabel = new JLabel("ID");
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
		JButton reduplicationCheckBtn = new JButton("\uC911\uBCF5\uD655\uC778");
		reduplicationCheckBtn.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 14));
		reduplicationCheckBtn.setBounds(301, 59, 97, 23);
		contentPane.add(reduplicationCheckBtn);
		reduplicationCheckBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		JLabel nameLabel = new JLabel("\uC774 \uB984");
		nameLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 14));
		nameLabel.setBounds(12, 92, 84, 24);
		contentPane.add(nameLabel);
		
		//이름입력받는창
		nameTextField = new JTextField();
		nameTextField.setHorizontalAlignment(SwingConstants.LEFT);
		nameTextField.setColumns(10);
		nameTextField.setBounds(108, 94, 181, 22);
		contentPane.add(nameTextField);
		
		
		
		JLabel pwLabel = new JLabel("PW");
		pwLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 14));
		pwLabel.setBounds(12, 126, 84, 24);
		contentPane.add(pwLabel);
		
		//비번입력창
		pwTextField = new JPasswordField();         //JPasswordField
		pwTextField.setHorizontalAlignment(SwingConstants.LEFT);
		pwTextField.setColumns(10);
		pwTextField.setBounds(108, 128, 181, 22);
		contentPane.add(pwTextField);
		
		
		
		JLabel pwCheckLabel = new JLabel("PW \uD655\uC778");
		pwCheckLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 14));
		pwCheckLabel.setBounds(12, 160, 84, 24);
		contentPane.add(pwCheckLabel);
		
		//비번체크창
		pwCheckTextField = new JPasswordField();
		pwCheckTextField.setHorizontalAlignment(SwingConstants.LEFT);
		pwCheckTextField.setColumns(10);
		pwCheckTextField.setBounds(108, 162, 181, 22);
		contentPane.add(pwCheckTextField);
		
		
		
		JLabel addressLabel = new JLabel("\uC8FC \uC18C");
		addressLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 14));
		addressLabel.setBounds(12, 194, 84, 24);
		contentPane.add(addressLabel);
		
		addressTextField = new JTextField();
		addressTextField.setHorizontalAlignment(SwingConstants.LEFT);
		addressTextField.setColumns(10);
		addressTextField.setBounds(108, 196, 181, 22);
		contentPane.add(addressTextField);
		
		
		
		JLabel emailLabel = new JLabel("\uC774\uBA54\uC77C");
		emailLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 14));
		emailLabel.setBounds(12, 228, 84, 24);
		contentPane.add(emailLabel);
		
		emailTextField = new JTextField();
		emailTextField.setHorizontalAlignment(SwingConstants.LEFT);
		emailTextField.setColumns(10);
		emailTextField.setBounds(108, 230, 181, 22);
		contentPane.add(emailTextField);
		
		
		
		JLabel phoneLabel = new JLabel("\uC804\uD654\uBC88\uD638");
		phoneLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 14));
		phoneLabel.setBounds(12, 262, 84, 24);
		contentPane.add(phoneLabel);
		
		phoneTextField = new JTextField();
		phoneTextField.setHorizontalAlignment(SwingConstants.LEFT);
		phoneTextField.setColumns(10);
		phoneTextField.setBounds(108, 264, 181, 22);
		contentPane.add(phoneTextField);
		
		
		
		JLabel dateOfBirthLabel = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		dateOfBirthLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 14));
		dateOfBirthLabel.setBounds(12, 296, 84, 24);
		contentPane.add(dateOfBirthLabel);
		
		dateOfBirthTextField = new JTextField();
		dateOfBirthTextField.setHorizontalAlignment(SwingConstants.LEFT);
		dateOfBirthTextField.setColumns(10);
		dateOfBirthTextField.setBounds(108, 298, 181, 22);
		contentPane.add(dateOfBirthTextField);
		
		
		//확인버튼
		JButton confirmBtn = new JButton("회원가입 완료");
		confirmBtn.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 14));
		confirmBtn.setBounds(205, 346, 84, 23);
		contentPane.add(confirmBtn);
		confirmBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
				//프레임 종료
				dispose();
			}
		});
		
		//취소버튼
		JButton cancleBtn = new JButton("\uCDE8 \uC18C");
		cancleBtn.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 14));
		cancleBtn.setBounds(301, 346, 84, 23);
		contentPane.add(cancleBtn);
		cancleBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub	
				
				//프레임 종료
				dispose();
			}
			
		});
	}

}
