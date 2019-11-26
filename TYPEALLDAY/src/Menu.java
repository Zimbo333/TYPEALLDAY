
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JPanel implements Runnable, ActionListener {

    private JFrame fr;
    private JPanel p1, p2, p3;
    private ImageIcon i1, i2, i3, bg, i4;
    private JLabel lb1, logo, lb_bg;
    private JButton btn1, btn2, btn4, btn_B;
    private speed speed = new speed();
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

    public void howtoplay() {

        JFrame fr = new JFrame("TYPEALLDAY");
        JPanel p1 = new JPanel();
        ImageIcon con_1 = new ImageIcon("src/images/con1.png");
        ImageIcon con_2 = new ImageIcon("src/images/con2.png");
        ImageIcon bg = new ImageIcon("src/images/bg_2.jpg");
        ImageIcon back = new ImageIcon("src/images/back.png");
        JLabel img_bg = new JLabel(bg);
        JLabel header = new JLabel("HOW TO PLAY");
        JLabel con1 = new JLabel(con_1);
        JLabel con2 = new JLabel(con_2);
        btn_B = new JButton(back);

        fr.setSize(500, 630);
        //fr.add(header);

        fr.add(con1);
        fr.add(con2);
        fr.add(btn_B);
        fr.add(lb_bg);

        fr.setLocationRelativeTo(null);
        lb_bg.setBounds(x, 0, 1000, 630);
        fr.setVisible(true);
        fr.setResizable(false);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn_B.setBorder(BorderFactory.createEmptyBorder());//ทำให้ปุ่มไม่มีขอบ
        btn_B.setContentAreaFilled(false);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        btn_B.setCursor(cursor);
        // ไม่มีพื้นหลังปุ่ม

        img_bg.setBounds(x, 0, 1000, 630);    //กำหนดตำแหน่งและขนาด 
        header.setBounds(70, 70, 347, 159);   //กำหนดตำแหน่งและขนาด
        btn_B.setBounds(115, 410, 270, 97);
//        p1.setBounds(630, 100, 500, 500);
        con1.setBounds(5, 125, 500, 200); //กำหนดตำแน่งและขนาด
        con2.setBounds(5, 250, 500, 200);  //กำหนดตำแน่งและขนาด

        btn_B.addActionListener(this);

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
            speed.setSpeed(100);
            MyMap Map = new MyMap();
            Map.reset();
            fr.dispose();
        }
        if (ae.getSource() == btn2) {
            speed.setSpeed(50);
            MyMap Map = new MyMap();
            Map.reset();
            fr.dispose();
        }
        if (ae.getSource() == btn4) {
            System.out.println("TEST");
            fr.dispose();
            howtoplay();
        }
        if (ae.getSource() == btn_B) {
            Menu menu = new Menu();
            Thread t = new Thread(menu);
            t.start();
        }

    }

}
