
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MyMap extends JPanel implements KeyListener {

    public int px = 0, py = 0;
    static Toolkit tk = Toolkit.getDefaultToolkit();
    static int xSize = ((int) tk.getScreenSize().getWidth());
    static int ySize = ((int) tk.getScreenSize().getHeight());
    ImageIcon ic = new   ImageIcon("C:\\Users\\chanl\\Desktop\\TYPEALLDAY\\TYPEALLDAY\\src\\images\\tenor.gif");
    JDesktopPane dp = new JDesktopPane();
    JLabel lbl = new JLabel(ic);
    JPanel transparentPanel = new JPanel();
    public static void main(String[] args) {
        MyMap p = new MyMap();
        JFrame fr = new JFrame();
        fr.setSize(xSize/2, ySize);
        fr.add(p);
        fr.addKeyListener(p);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setResizable(false);
        }

    public void paintComponent(Graphics g) {
        g.fillRect(0, 0, xSize, ySize);
        Image bg = new ImageIcon("src/images/1.gif").getImage();
        Image img = new ImageIcon("src/images/sprite_oong-1.gif").getImage();
        Image img2 = new ImageIcon("src/images/sprite.gif").getImage();
        g.drawImage(bg, 0, 0, this);
        g.drawImage(img2, 300, 0, this);
        g.drawImage(img, 300,585, this);
        
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
