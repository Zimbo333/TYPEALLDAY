import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JPanel implements Runnable, ActionListener {

    private JFrame fr;
    private JPanel p1, p2, p3;
    private ImageIcon i1, i2, i3, bg, i4;
    private JLabel lb1, logo, lb_bg;
    private JButton btn1, btn2, btn4;
    private int x = -168;

    public Menu() {
        fr = new JFrame("TypeAllDay");
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        p2 = new JPanel();
        p3 = new JPanel();

        lb1 = new JLabel(i1);
        bg = new ImageIcon("src/images/bg_2.jpg");
        i1 = new ImageIcon("src/images/logo.png");
        i2 = new ImageIcon("src/images/button1.png");
        i3 = new ImageIcon("src/images/button2.png");
        i4 = new ImageIcon("src/images/howtoplay.png");
        
        p1 = new JPanel();
        fr.setSize(500, 630);
        lb_bg = new JLabel(bg);
        logo = new JLabel(i1);
        btn1 = new JButton(i2);
        btn1.setCursor(cursor);
        btn2 = new JButton(i3);
        btn2.setCursor(cursor);
        btn4 = new JButton(i4);
        btn4.setCursor(cursor);

        fr.add(logo);
        fr.add(btn1);
        fr.add(btn2);
        fr.add(btn4);
        fr.add(p1);
        fr.add(lb_bg);

//        fr.add(p1);
        lb_bg.setBounds(x, 0, 1000, 630);    //กำหนดตำแหน่งและขนาด 
        logo.setBounds(70, 70, 347, 159);   //กำหนดตำแหน่งและขนาด

//        p1.setBounds(630, 100, 500, 500);
        btn1.setBounds(100, 250, 251, 103); //กำหนดตำแน่งและขนาด
        btn2.setBounds(130, 350, 249, 97);  //กำหนดตำแน่งและขนาด
        btn4.setBounds(80, 440, 270, 97);

//        fr.setLayout(new FlowLayout());
        btn1.setBorder(BorderFactory.createEmptyBorder()); //ทำให้ปุ่มไม่มีขอบ
        btn1.setContentAreaFilled(false);                  // ไม่มีพื้นหลังปุ่ม

        btn2.setBorder(BorderFactory.createEmptyBorder());//ทำให้ปุ่มไม่มีขอบ
        btn2.setContentAreaFilled(false);                  // ไม่มีพื้นหลังปุ่ม

        btn4.setBorder(BorderFactory.createEmptyBorder());//ทำให้ปุ่มไม่มีขอบ
        btn4.setContentAreaFilled(false);                  // ไม่มีพื้นหลังปุ่ม
        
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null); //ให้JFrame ขึ้นตรงกลางหน้าจอ
        fr.setVisible(true);
        fr.setResizable(false);         //ปรับขนาดไม่ได้

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn4.addActionListener(this);

    }
    public void howtoplay(){

        JFrame fr = new JFrame("TYPEALLDAY");
        JPanel p1 = new JPanel();
        ImageIcon i1 = new ImageIcon("src/images/con1.jpg");
        ImageIcon bg = new ImageIcon("src/images/bg_2.jpg");
        JLabel img_bg = new JLabel(bg);
        JLabel header = new JLabel("HOW TO PLAY");
        JLabel con1 = new JLabel(i1);
        JLabel con2 = new JLabel();
        JButton btn1 = new JButton();
       
        fr.setSize(500, 630);
        fr.add(lb_bg);
        fr.setLocationRelativeTo(null);
        lb_bg.setBounds(x, 0, 1000, 630);
        fr.setVisible(true);
        fr.setResizable(false);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
       
     
    }
    @Override
    public void run() {

        try {
            while (true) {
                Thread.sleep(10);
                lb_bg.setBounds(x, 0, 1000, 630);
                x -= 5;
                if (x <= -506) {
                    x = -168;
                }
            }
        } catch (InterruptedException e) {
        }
        repaint();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btn1) {
            MyMap.setSpeed(100);
            MyMap Map = new MyMap();
            Map.reset();
            fr.dispose();
        }
        if (ae.getSource() == btn2) {
            MyMap.setSpeed(50);
            MyMap Map = new MyMap();
            Map.reset();
            fr.dispose();
        }
        if (ae.getSource() == btn4) {
            System.out.println("TEST");
            fr.dispose();
            howtoplay();
        }
        
    }

}
