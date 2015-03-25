/**
 * FileName: PrintTest1.java <br/>
 */
package com.print;

/**
 * Project: Test <br/>
 * Class: com.print.PrintTest1 <br/>
 * Description: <������Ĺ���>. <br/>
 * Copyright: Copyright (c) 2014 <br/>
 * Makedate: 2014-10-14 ����04:25:45 <br/>
 * 
 * @author guanxiaolin
 * @version 1.0
 * @since 1.0
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import java.awt.Toolkit;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.AttributedString;

import javax.swing.JApplet;



public class PrintTest1   implements Printable{
   /**
   * @param Graphicָ����ӡ��ͼ�λ���
   * @param PageFormatָ����ӡҳ��ʽ��ҳ���С�Ե�Ϊ������λ��1��Ϊ1Ӣ�ŵ�1/72��1Ӣ��Ϊ25.4���ס�A4ֽ����Ϊ595��842�㣩
   * @param pageIndexָ��ҳ��
   **/
   public int print(Graphics gra, PageFormat pf, int pageIndex) throws PrinterException {
       System.out.println("pageIndex="+pageIndex);
       Component c = null;
      //print string
      String str = "�л����������͡��¸Һ͸����ǻ۵�ΰ�����塣";
      //ת����Graphics2D
      Graphics2D g2 = (Graphics2D) gra;
      //���ô�ӡ��ɫΪ��ɫ
      g2.setColor(Color.black);
      
      /*Paper paper = pf.getPaper();//�õ�ҳ���ʽ��ֽ�� 
      paper.setSize(500,500);//ֽ�Ŵ�С 
      paper.setImageableArea(0,0,500,500); //���ô�ӡ����Ĵ�С 
      System.out.println(paper.getWidth());
      System.out.println(paper.getHeight()); 
      pf.setPaper(paper);//����ֽ����Ϊ��ʽ */

      //��ӡ�������
      double x = pf.getImageableX();
      double y = pf.getImageableY();
       
      switch(pageIndex){
         case 0:
           //���ô�ӡ���壨�������ơ���ʽ�͵��С�����������ƿ�������������߼����ƣ�
           //Javaƽ̨���������������ϵ�У�Serif��SansSerif��Monospaced��Dialog �� DialogInput
           Font font = new Font("������", Font.PLAIN, 9);
           g2.setFont(font);//��������
           //BasicStroke   bs_3=new   BasicStroke(0.5f);  
           float[]   dash1   =   {4.0f}; 
           g2.setStroke(new   BasicStroke(0.5f,   BasicStroke.CAP_BUTT,   BasicStroke.JOIN_MITER,   4.0f,   dash1,   0.0f));

           float heigth = font.getSize2D();//����߶�
           System.out.println("x="+x);
           //ʹ�ÿ����ģʽ����ı�����
           /*g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
          RenderingHints.VALUE_TEXT_ANTIALIAS_ON);*/
           // -1- ��Graphics2Dֱ�����
           //���ַ��Ļ���(���²�)λ���û��ռ��е� (x, y) λ�ô�
           
           //g2.drawLine(10,10,200,10);  
           
           Image src = Toolkit.getDefaultToolkit().getImage("d://logo.gif");
           g2.drawImage(src,(int)x,(int)y,c);
           int img_Height=src.getHeight(c);
           int img_width=src.getWidth(c);
           //System.out.println("img_Height="+img_Height+"img_width="+img_width) ;
           
           g2.drawString(str, (float)x, (float)y+1*heigth+img_Height);
           g2.drawLine((int)x,(int)(y+1*heigth+img_Height+10),(int)x+200,(int)(y+1*heigth+img_Height+10));
           
           g2.drawImage(src,(int)x,(int)(y+1*heigth+img_Height+11),c);
           
    
           // -2- ֱ�ӹ���TextLayout��ӡ
           /*FontRenderContext frc = g2.getFontRenderContext();
           TextLayout layout = new TextLayout(str, font, frc);
           layout.draw(g2, (float)x, (float)y+2*heigth);*/
           // -3- ��LineBreakMeasurer���д�ӡ
           /*AttributedString text = new AttributedString(str);
           text.addAttribute(TextAttribute.FONT, font);
           LineBreakMeasurer lineBreaker = new LineBreakMeasurer(text.getIterator(), frc);
           //ÿ���ַ���ʾ����(��)
           double width = pf.getImageableWidth();
           //���ַ��Ļ���λ���û��ռ��е� (x, y) λ�ô�
           Point2D.Double pen = new Point2D.Double (100, y+3*heigth);
           while ( (layout = lineBreaker.nextLayout( (float) width)) != null){
              layout.draw(g2, (float)x, (float) pen.y);
              pen.y += layout.getAscent();
           }*/
         return PAGE_EXISTS;
         default:
         return NO_SUCH_PAGE;
      }
      
   }


public static void main(String[] args) {
    
     //��ȡ��ӡ�������
     PrinterJob job = PrinterJob.getPrinterJob();     
     PageFormat pageFormat = job.defaultPage();//�õ�Ĭ��ҳ��ʽ  
     job.setPrintable(new PrintTest1());//���ô�ӡ��
     
     try {
         //������printDialog��ʾ��ӡ�Ի������û�ȷ�Ϻ��ӡ��Ҳ����ֱ�Ӵ�ӡ
         //boolean a=job.printDialog();
         //if(a)
         //{
         
         job.print();
         //}
     } catch (PrinterException e) {
         e.printStackTrace();
     }
   }
}