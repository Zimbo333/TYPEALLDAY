
import java.awt.*;
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
public class Menu extends JPanel {

    static Toolkit tk = Toolkit.getDefaultToolkit();
    static int xSize = ((int) tk.getScreenSize().getWidth());
    static int ySize = ((int) tk.getScreenSize().getHeight());
    private JFrame fr;
    private JPanel p1, p2, p3;
    private ImageIcon i1, i2, i3, bg;
    private JLabel lb1, logo, lb_bg;
    private JButton btn1, btn2, btn3, btn4;

    public Menu() {
        fr = new JFrame("TypeAllDay");

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
        btn2 = new JButton(i3);
        btn3 = new JButton("Add");

        fr.add(logo);
        fr.add(btn1);
        fr.add(btn2);
        fr.add(p1);
        fr.add(lb_bg);

//        fr.add(p1);

        lb_bg.setBounds(0, 0, 500, 630);    //กำหนดตำแน่งและขนาด 
        logo.setBounds(70, 70, 347, 159);   //กำหนดตำแน่งและขนาด
        
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
    }

    public void paintComponent(Graphics g) {

    }

    public static void main(String[] args) {
        new Menu();
    }
}
