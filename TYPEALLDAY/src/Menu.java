
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Menu extends JPanel implements Runnable, ActionListener {

    private JFrame fr;
    private JPanel p1, p2, p3;
    private ImageIcon i1, i2, i3, bg, i4;
    private JLabel lb1, logo, lb_bg;
    private JButton btn1, btn2, btn3, btn_B;
    private int x_background_move = -168;
    private JLabel header = new JLabel("- HOW TO PLAY -");
    private int[] change_color = {255, 0, 0};
    private Font pixelMplus;

    public Menu() {
        fr = new JFrame("TypeAllDay");

        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        i1 = new ImageIcon("src/images/logo.png");
        lb1 = new JLabel(i1);
        bg = new ImageIcon("src/images/bg_2.jpg");
        i2 = new ImageIcon("src/images/button1.png");
        i3 = new ImageIcon("src/images/button2.png");
        i4 = new ImageIcon("src/images/howtoplay.png");


        fr.setSize(500, 630);
        lb_bg = new JLabel(bg);
        logo = new JLabel(i1);
        btn1 = new JButton(i2);
        btn1.setCursor(cursor);
        btn2 = new JButton(i3);
        btn2.setCursor(cursor);
        btn3 = new JButton(i4);
        btn3.setCursor(cursor);

        fr.add(logo);
        fr.add(btn1);
        fr.add(btn2);
        fr.add(btn3);

        fr.add(lb_bg);


        lb_bg.setBounds(x_background_move, 0, 1000, 630);    //กำหนดตำแหน่งและขนาด 
        logo.setBounds(70, 70, 347, 159);   //กำหนดตำแหน่งและขนาด


        btn1.setBounds(100, 250, 251, 103); //กำหนดตำแน่งและขนาด
        btn2.setBounds(130, 350, 249, 97);  //กำหนดตำแน่งและขนาด
        btn3.setBounds(80, 440, 270, 97);


        btn1.setBorder(BorderFactory.createEmptyBorder()); //ทำให้ปุ่มไม่มีขอบ
        btn1.setContentAreaFilled(false);                  // ไม่มีพื้นหลังปุ่ม

        btn2.setBorder(BorderFactory.createEmptyBorder());//ทำให้ปุ่มไม่มีขอบ
        btn2.setContentAreaFilled(false);                  // ไม่มีพื้นหลังปุ่ม

        btn3.setBorder(BorderFactory.createEmptyBorder());//ทำให้ปุ่มไม่มีขอบ
        btn3.setContentAreaFilled(false);                  // ไม่มีพื้นหลังปุ่ม

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null); //ให้JFrame ขึ้นตรงกลางหน้าจอ
        fr.setVisible(true);
        fr.setResizable(false);         //ปรับขนาดไม่ได้

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);

    }

    public void howtoplay() {

        JFrame fr = new JFrame("TYPEALLDAY");
        JPanel p1 = new JPanel();
        ImageIcon con_1 = new ImageIcon("src/images/con1.png");
        ImageIcon con_2 = new ImageIcon("src/images/con2.png");
        ImageIcon bg = new ImageIcon("src/images/bg_2.jpg");
        ImageIcon back = new ImageIcon("src/images/back.png");
        JLabel img_bg = new JLabel(bg);
        JLabel con1 = new JLabel(con_1);
        JLabel con2 = new JLabel(con_2);
        btn_B = new JButton(back);

        fr.setSize(500, 630);
        //fr.add(header);

        fr.add(con1);
        fr.add(con2);
        fr.add(btn_B);
        fr.add(header);
        fr.add(lb_bg);

        header.setFont(pixelMplus);
        header.setForeground(new Color(change_color[0], change_color[1], change_color[2]));
        fr.setLocationRelativeTo(null);
        lb_bg.setBounds(x_background_move, 0, 1000, 630);
        fr.setVisible(true);
        fr.setResizable(false);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn_B.setBorder(BorderFactory.createEmptyBorder());//ทำให้ปุ่มไม่มีขอบ
        btn_B.setContentAreaFilled(false);

        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        btn_B.setCursor(cursor);
        // ไม่มีพื้นหลังปุ่ม

        img_bg.setBounds(x_background_move, 0, 1000, 630);    //กำหนดตำแหน่งและขนาด 
        header.setBounds(75, 20, 500, 159);   //กำหนดตำแหน่งและขนาด
        btn_B.setBounds(115, 410, 270, 97);
//        p1.setBounds(630, 100, 500, 500);
        con1.setBounds(0, 125, 500, 200); //กำหนดตำแน่งและขนาด
        con2.setBounds(5, 250, 500, 200);  //กำหนดตำแน่งและขนาด

        btn_B.addActionListener(this);

    }

    @Override
    public void run() {

        try {
            while (true) {
                pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("src/font/VCR_OSD_MONO_1.001.ttf")).deriveFont(40f);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/font/VCR_OSD_MONO_1.001.ttf")));
                Thread.sleep(10);
                lb_bg.setBounds(x_background_move, 0, 1000, 630);
                x_background_move -= 5;
                if (change_color[0] >= 255 && change_color[1] < 255 && change_color[2] == 0) {
                    change_color[1]++;
                } else if (change_color[0] != 0 && change_color[1] >= 255 && change_color[2] == 0) {
                    change_color[0]--;
                } else if (change_color[0] == 0 && change_color[1] >= 255 && change_color[2] < 255) {
                    change_color[2]++;
                } else if (change_color[0] == 0 && change_color[1] != 0 && change_color[2] >= 255) {
                    change_color[1]--;
                } else if (change_color[0] < 255 && change_color[1] == 0 && change_color[2] >= 255) {
                    change_color[0]++;
                } else if (change_color[0] >= 255 && change_color[1] == 0 && change_color[2] != 0) {
                    change_color[2]--;
                }
                header.setForeground(new Color(change_color[0], change_color[1], change_color[2]));
                if (x_background_move <= -506) {
                    x_background_move = -168;
                }

            }
        } catch (InterruptedException e) {
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FontFormatException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btn1) {
            MyMap Map = new MyMap();
            Map.setSpeed(100);
            Map.reset();
            fr.dispose();
        }
        if (ae.getSource() == btn2) {

            MyMap Map = new MyMap();
            Map.setSpeed(50);
            Map.reset();
            fr.dispose();
        }
        if (ae.getSource() == btn3) {
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
