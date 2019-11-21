
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

        fr.add(lb_bg);
        fr.add(logo);
        p1.add(btn1);
        p1.add(btn2);

        fr.add(p1);
        logo.setBounds(300,300, 100, 100);
        fr.setLayout(new FlowLayout());
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }

    public void paintComponent(Graphics g) {

    }

    public static void main(String[] args) {
        new Menu();
    }
}
