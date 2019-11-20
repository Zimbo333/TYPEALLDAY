
import java.awt.BorderLayout;
import static java.awt.BorderLayout.SOUTH;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.AttributedCharacterIterator;
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
    static JLabel lb = new JLabel();
    static String txt = "";
    JDesktopPane dp = new JDesktopPane();
    JPanel transparentPanel = new JPanel();
    public static void main(String[] args) {
        MyMap p = new MyMap();
        JFrame fr = new JFrame();
        fr.setSize((xSize/2)+300, (ySize/2)+200);
        lb.setFont(new Font("Dialog", Font.BOLD, 70));
        p.add(lb);
        fr.add(p);
        
        fr.addKeyListener(p);
        
        
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setResizable(false);
        fr.setLocationRelativeTo(null);
        }

    public void paintComponent(Graphics g) {
        Image bg = new ImageIcon("src/images/bg_2.jpg").getImage();
        Image oong_b = new ImageIcon("src/images/sprite_oong.gif").getImage();
        Image oong_w = new ImageIcon("src/images/sprite_white_oong0.png").getImage();
        g.drawImage(bg, 0, 0, this);
        g.drawImage(oong_b, 900,370, this);
        g.drawImage(oong_w, 0, 380, this);
//        g.drawString((AttributedCharacterIterator) lb, 430, 500);
        
        
    }
 
    public void keyTyped(KeyEvent ke) {
    }

    public void keyPressed(KeyEvent ke) {
         if(ke.getKeyCode() == 32){
            lb.setText("");
        }
        else{
            lb.setText(lb.getText() + ke.getKeyChar());
        }
    }

    public void keyReleased(KeyEvent ke) {
    }

   
}
