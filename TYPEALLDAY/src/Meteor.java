
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Meteor extends MyMap {

    int x = 180;
    int y = 100;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D gd = (Graphics2D) g;
        gd.setColor(Color.red);
        gd.setFont(new Font("Bold",Font.BOLD,22));
        gd.drawString("FUCK YOU", x, y);
        try {
            Thread.sleep(1000);
            y += 50;
        } catch (Exception e) {
        }
        if (y > getHeight()) {
            y = 0;
        }
        repaint();
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(500,500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new Meteor());
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
