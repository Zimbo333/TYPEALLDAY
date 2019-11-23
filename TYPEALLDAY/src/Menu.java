
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Acer
 */
public class Menu extends JPanel implements Runnable, ActionListener {

    private JFrame fr;
    private JPanel p1, p2, p3;
    private ImageIcon i1, i2, i3, bg;
    private JLabel lb1, logo, lb_bg;
    private JButton btn1, btn2, btn3;
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
        p1 = new JPanel();
        fr.setSize(500, 630);
        lb_bg = new JLabel(bg);
        logo = new JLabel(i1);
        btn1 = new JButton(i2);
        btn1.setCursor(cursor);
        btn2 = new JButton(i3);
        btn2.setCursor(cursor);
        btn3 = new JButton("Add");

        fr.add(logo);
        fr.add(btn1);
        fr.add(btn2);
        fr.add(p1);
        fr.add(lb_bg);

//        fr.add(p1);
        lb_bg.setBounds(x, 0, 1000, 630);    //กำหนดตำแหน่งและขนาด 
        logo.setBounds(70, 70, 347, 159);   //กำหนดตำแหน่งและขนาด

//        p1.setBounds(630, 100, 500, 500);
        btn1.setBounds(100, 250, 251, 103); //กำหนดตำแน่งและขนาด
        btn2.setBounds(130, 375, 249, 97);  //กำหนดตำแน่งและขนาด

//        fr.setLayout(new FlowLayout());
        btn1.setBorder(BorderFactory.createEmptyBorder()); //ทำให้ปุ่มไม่มีขอบ
        btn1.setContentAreaFilled(false);                  // ไม่มีพื้นหลังปุ่ม

        btn2.setBorder(BorderFactory.createEmptyBorder());//ทำให้ปุ่มไม่มีขอบ
        btn2.setContentAreaFilled(false);                  // ไม่มีพื้นหลังปุ่ม

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null); //ให้JFrame ขึ้นตรงกลางหน้าจอ
        fr.setVisible(true);
        fr.setResizable(false);         //ปรับขนาดไม่ได้
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);

    }

    public void paintComponent(Graphics g) {

    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        Thread t = new Thread(menu);
        
        t.start();
    }

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
        } catch (Exception e) {
        }
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btn1){
            MyMap.main();
            fr.dispose();
        }
        if (ae.getSource() == btn2){    
            MyMap.setSpeed(50);
            MyMap.main();
            fr.dispose();
        }
    }
    
}
