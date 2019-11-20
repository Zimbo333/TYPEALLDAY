
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
    private ImageIcon i1, i2, i3;
    private JLabel lb1;
    private JButton btn1, btn2, btn3, btn4;

    public Menu() {
        fr = new JFrame("TypeAllDay");
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        
        lb1 = new JLabel(i1);

        i1 = new ImageIcon("src/images/logo.png");
        i2 = new ImageIcon("src/images/button1.png");
        i3 = new ImageIcon("src/images/button2.png");

        btn1 = new JButton(i2);
        btn2 = new JButton(i3);
        btn3 = new JButton("Add");
        fr.add(lb1);
        fr.setLayout(new FlowLayout());
        fr.add(btn1);
        fr.add(btn2);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }
public static void main(String[] args) {
        new Menu();
    }
}
