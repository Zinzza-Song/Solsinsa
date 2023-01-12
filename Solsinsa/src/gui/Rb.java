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
    	  setBorderPainted(false); setOpaque(false);
    	  }
      @Override 
      protected void paintComponent(Graphics g) {
         Color backColor=new Color(68, 83, 91); //배경색 결정
         Color fontColor=new Color(255,255,255); //글자색 결정
         int width = getWidth(); 
         int height = getHeight(); 
         Graphics2D graphics = (Graphics2D) g; 
         graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
         if (getModel().isArmed()) { graphics.setColor(backColor.darker()); } 
         else if (getModel().isRollover()) { graphics.setColor(backColor.brighter()); } 
         else { graphics.setColor(backColor); } 
         graphics.fillRoundRect(0, 0, width, height, 20, 20); 
         FontMetrics fontMetrics = graphics.getFontMetrics(); 
         Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
         int textX = (width - stringBounds.width) / 2; 
         int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
         graphics.setColor(fontColor); 
         graphics.setFont(getFont()); 
         graphics.drawString(getText(), textX, textY); 
         graphics.dispose(); 
         super.paintComponent(g); 
         }
      }