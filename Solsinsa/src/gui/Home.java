package gui;
import jdbc.JdbcConnector;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

public class Home extends JFrame {

   private JPanel contentPane;
   private JTextField idtextField;
   private JTextField pwtextField;
   private JTextField imagebtn1Name;
   private JTextField imagebtn1Price;
   private JTextField imagebtn2Name;
   private JTextField imagebtn2Price;
   private JTextField imagebtn3Name;
   private JTextField imagebtn4name;
   private JTextField imagebtn3Price;
   private JTextField imagebtn4Price;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Home frame = new Home();
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
   public Home() {
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 723, 653);
      contentPane = new JPanel();
      contentPane.setBackground(new Color(222, 226, 235));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      DressPanel banner = new DressPanel();
      contentPane.add(banner);
      
      banner.startThread();
      JPanel homeName = new JPanel();
      homeName.setBounds(12, 53, 683, 71);
      homeName.setBackground(new Color(76, 76, 76));
      homeName.setToolTipText("SOLSINSA");
      homeName.setBorder(new LineBorder(new Color(34, 41, 55), 3));
      contentPane.add(homeName);
      homeName.setLayout(null);
      
      JLabel lblNewLabel_2 = new JLabel("SOLSINSA");
      lblNewLabel_2.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 40));
      lblNewLabel_2.setForeground(new Color(255, 255, 255));
      lblNewLabel_2.setBounds(228, 10, 212, 51);
      homeName.add(lblNewLabel_2);
      
      JPanel panel = new JPanel();
      panel.setBounds(12, 169, 683, 124);
      panel.setBackground(new Color(54, 58, 80));
      panel.setBorder(new LineBorder(new Color(0, 0, 0)));
      contentPane.add(panel);
      panel.setLayout(null);
      
      JLabel lblNewLabel_3 = new JLabel("imageThread");
      lblNewLabel_3.setForeground(new Color(255, 255, 255));
      lblNewLabel_3.setBackground(new Color(255, 255, 255));
      lblNewLabel_3.setBounds(12, 10, 659, 104);
      panel.add(lblNewLabel_3);
      
      idtextField = new JTextField();
      idtextField.setBounds(33, 22, 116, 21);
      contentPane.add(idtextField);
      idtextField.setColumns(10);
      
      pwtextField = new JTextField();
      pwtextField.setBounds(184, 21, 116, 21);
      contentPane.add(pwtextField);
      pwtextField.setColumns(10);
      
      JLabel idLabel = new JLabel("ID");
      idLabel.setBounds(12, 25, 20, 15);
      contentPane.add(idLabel);
      
      JLabel pwLabel = new JLabel("PW");
      pwLabel.setBounds(159, 24, 20, 15);
      contentPane.add(pwLabel);
      
      JButton CategoryTop = new JButton("TOP");
      CategoryTop.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 15));
      CategoryTop.setBounds(72, 134, 160, 25);
      contentPane.add(CategoryTop);
      
      JButton CategoryBottom = new JButton("BOTTOM");
      CategoryBottom.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 15));
      CategoryBottom.setBounds(262, 134, 160, 25);
      contentPane.add(CategoryBottom);
      
      JButton CategoryOuter = new JButton("OUTER");
      CategoryOuter.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 15));
      CategoryOuter.setBounds(447, 134, 160, 25);
      contentPane.add(CategoryOuter);
      
      JButton loginbtn = new JButton("login");
      loginbtn.setFont(new Font("굴림", Font.PLAIN, 12));
      loginbtn.setBounds(310, 20, 67, 23);
      contentPane.add(loginbtn);
      
      JButton joinbtn = new JButton("join");
      joinbtn.setFont(new Font("굴림", Font.PLAIN, 12));
      joinbtn.setBounds(389, 21, 67, 23);
      contentPane.add(joinbtn);
      
      //상품표시패널
      JPanel productPanel1 = new JPanel();
      productPanel1.setSize(633, 1000);
      productPanel1.setLayout(null);
      
      ImageIcon icon=new ImageIcon("src/쇼핑몰 사진/상의/님부스그레이.jpg");
      Image img1 = icon.getImage();
      Image changeimg1 = img1.getScaledInstance(250, 210, Image.SCALE_SMOOTH);  //이미지 사이즈 조절
      ImageIcon changeIcon1 = new ImageIcon(changeimg1);
      
      JButton imagebtn1 = new JButton(changeIcon1);
      imagebtn1.setBackground(new Color(255, 255, 255));  //버튼 색상 변경
      
      //액션리스너
      imagebtn1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      imagebtn1.setBounds(12, 10, 295, 210);
      productPanel1.add(imagebtn1);
      
      JButton imagebtn2 = new JButton("New button");
      imagebtn2.setBackground(new Color(255, 255, 255));
      imagebtn2.setBounds(324, 10, 295, 210);
      productPanel1.add(imagebtn2);
      
      imagebtn1Name = new JTextField();
      imagebtn1Name.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
      imagebtn1Name.setText("\uC544\uAC00\uC77C");
      imagebtn1Name.setBounds(34, 230, 243, 22);
      productPanel1.add(imagebtn1Name);
      imagebtn1Name.setColumns(10);
      
      imagebtn1Price = new JTextField();
      imagebtn1Price.setText("\uC544\uAC00\uC77C");
      imagebtn1Price.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
      imagebtn1Price.setColumns(10);
      imagebtn1Price.setBounds(34, 262, 243, 22);
      productPanel1.add(imagebtn1Price);
      
      imagebtn2Name = new JTextField();
      imagebtn2Name.setText("\uC544\uAC00\uC77C");
      imagebtn2Name.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
      imagebtn2Name.setColumns(10);
      imagebtn2Name.setBounds(352, 230, 243, 22);
      productPanel1.add(imagebtn2Name);
      
      imagebtn2Price = new JTextField();
      imagebtn2Price.setText("\uC544\uAC00\uC77C");
      imagebtn2Price.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
      imagebtn2Price.setColumns(10);
      imagebtn2Price.setBounds(352, 262, 243, 22);
      productPanel1.add(imagebtn2Price);
      
      JButton imagebtn3 = new JButton("..");
      imagebtn3.setBackground(new Color(255, 255, 255));
      imagebtn3.setBounds(12, 305, 295, 210);
      productPanel1.add(imagebtn3);
      
      JButton imagebtn4 = new JButton("New button");
      imagebtn4.setBackground(new Color(255, 255, 255));
      imagebtn4.setBounds(324, 305, 295, 210);
      productPanel1.add(imagebtn4);
      
      imagebtn3Name = new JTextField();
      imagebtn3Name.setText("\uC544\uAC00\uC77C");
      imagebtn3Name.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
      imagebtn3Name.setColumns(10);
      imagebtn3Name.setBounds(34, 525, 243, 22);
      productPanel1.add(imagebtn3Name);
      
      imagebtn4name = new JTextField();
      imagebtn4name.setText("\uC544\uAC00\uC77C");
      imagebtn4name.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
      imagebtn4name.setColumns(10);
      imagebtn4name.setBounds(352, 525, 243, 22);
      productPanel1.add(imagebtn4name);
      
      imagebtn3Price = new JTextField();
      imagebtn3Price.setText("\uC544\uAC00\uC77C");
      imagebtn3Price.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
      imagebtn3Price.setColumns(10);
      imagebtn3Price.setBounds(34, 557, 243, 22);
      productPanel1.add(imagebtn3Price);
      
      imagebtn4Price = new JTextField();
      imagebtn4Price.setText("\uC544\uAC00\uC77C");
      imagebtn4Price.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 12));
      imagebtn4Price.setColumns(10);
      imagebtn4Price.setBounds(352, 557, 243, 22);
      productPanel1.add(imagebtn4Price);

      productPanel1.setPreferredSize(new Dimension(633, 596));
      
      JScrollPane scrollPane = new JScrollPane(productPanel1, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0), 2));
      scrollPane.setBounds(12, 303, 683, 311);

      contentPane.add(scrollPane);
   }
}