package gui;


import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.*;

public class Rb extends JButton {
      public Rb() {
    	  super(); decorate(); 
    	  } 
      public Rb(String text) { 
    	  super(text); decorate(); 
    	  } 
      public Rb(Action action) {
    	  super(action); decorate();
    	  } 
      public Rb(Icon icon) {
    	  super(icon); decorate(); 
    	  } 
      public Rb(String text, Icon icon) {
    	  super(text, icon); decorate();
    	  } 
      protected void decorate() {
    	  setBorderPainted(false); //버튼의 외곽선을 없애줌
    	  setOpaque(false);  //배경색설정불가
    	  } 
      @Override 
      protected void paintComponent(Graphics g) {  //그래픽스 (임포트java.awt)안의 페인트 컴포넌트 함수 재정의
         Color backColor=new Color(68, 83, 91); //배경색 결정
         Color fontColor=new Color(255,255,255); //글자색 결정
         int width = getWidth(); 
         int height = getHeight(); 
         Graphics2D graphics = (Graphics2D) g; //그래픽스에 배경색입히고 각도 깍은걸 가져온 버튼의 width,height 사이즈만큼 넣을것
         graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //안티에일리어싱 사용(그래픽 사용중 계단현상방지)
         if (getModel().isArmed()) { graphics.setColor(backColor.darker()); }  //버튼(getModel() 클릭하는동안 색상을 어둡게 설정
         else if (getModel().isRollover()) { graphics.setColor(backColor.brighter()); } //마우스가 올라가면 밝게 설정
         else { graphics.setColor(backColor); } 
         graphics.fillRoundRect(0, 0, width, height, 20, 20); //버튼의 각도를 20만큼 깍음
         FontMetrics fontMetrics = graphics.getFontMetrics();     //현재 설정된 폰트의 정보를 가지고 있는 클래스 객체에 그래픽스에서 가져온 폰트 저장
         Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
         int textX = (width - stringBounds.width) / 2;  //글자의 범위 설정 x축(가져온 가로길이에 텍스트 길이 빼고 /2 즉 가운데정렬)
         int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); //y축도 똑같이 정렬하겠다
         graphics.setColor(fontColor); 
         graphics.setFont(getFont()); 
         graphics.drawString(getText(), textX, textY); //가운데 정렬한 곳에 텍스트 부착(셋바운즈너낌)
         graphics.dispose(); //위 데코레이터 함수 호출해서 내가 선언한 색상만 사용가능하도록함(즉 컬러변경해도 안변함)
         super.paintComponent(g); 
         }
      }