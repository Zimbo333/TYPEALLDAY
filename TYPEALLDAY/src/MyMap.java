
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MyMap extends JPanel implements KeyListener {

    public int px = 0, py = 0;
    static Toolkit tk = Toolkit.getDefaultToolkit();
    static int xSize = ((int) tk.getScreenSize().getWidth());
    static int ySize = ((int) tk.getScreenSize().getHeight());

    public static void main(String[] args) {
        MyMap p = new MyMap();
        JFrame fr = new JFrame();
        fr.setSize(xSize, ySize);
        fr.add(p);
        fr.addKeyListener(p);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(0, 0, xSize, ySize);
        Image img = new ImageIcon("src/images/sprite.gif").getImage();
        Image img2 = new ImageIcon("src/images/tenor.gif").getImage();
        g.drawImage(img2, 0, 0, null);
        g.drawImage(img, this.px, this.py, this);
        
    }

    public void keyTyped(KeyEvent ke) {
    }

    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == 37) { //Left
            this.px -= 10;
        } else if (ke.getKeyCode() == 38) { //Up
            this.py -= 10;
        } else if (ke.getKeyCode() == 39) { //Right
            this.px += 10;
        } else if (ke.getKeyCode() == 40) { //Down
            this.py += 10;
        }
        repaint();
    }

    public void keyReleased(KeyEvent ke) {
    }
}
