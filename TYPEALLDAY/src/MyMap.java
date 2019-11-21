
import java.awt.*;
import static java.awt.BorderLayout.SOUTH;
import java.awt.event.*;
import java.text.AttributedCharacterIterator;
import java.util.Random;
import javax.swing.*;


public class MyMap extends JPanel implements KeyListener {

    public int px = 0, py = 0;
    static Toolkit tk = Toolkit.getDefaultToolkit();
    static int xSize = ((int) tk.getScreenSize().getWidth());
    static int ySize = ((int) tk.getScreenSize().getHeight());
    static JLabel lb = new JLabel();
    static String[] backG = {"bg", "bg_1", "bg_2"};
    static String[] oong = {"sprite_oong-1", "sprite_oong-2"};
    static int i = getRandomNumberInRange(0, 2);
    JDesktopPane dp = new JDesktopPane();
    JPanel transparentPanel = new JPanel();
    public static void main(String[] args) {
        MyMap p = new MyMap();
        JFrame fr = new JFrame();
        fr.setSize((xSize/2)+300, (ySize/2)+200);
        lb.setFont(new Font("Dialog", Font.BOLD, 70));
        p.add(lb);
        fr.add(p);
        JTextField txt1 = new JTextField(10);
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();

        p.setPreferredSize(new Dimension(700,700));

        //set layout
        p1.setLayout(new FlowLayout());
        p1.add(txt1);

        fr.add(p,BorderLayout.CENTER);
        fr.add(p1,BorderLayout.SOUTH);

        fr.addKeyListener(p);
        
        
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setResizable(false);
        fr.setLocationRelativeTo(null);
        }
        private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
            
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public void paintComponent(Graphics g) {
        Image bg = new ImageIcon("src/images/" + backG[i] + ".jpg").getImage();
        Image oong_b = new ImageIcon("src/images/sprite_oong.gif").getImage();
        Image oong_w = new ImageIcon("src/images/" + oong[getRandomNumberInRange(0,1)] + ".png").getImage();
        g.drawImage(bg, 0, 0, this);
        g.drawImage(oong_b, 900,370, this);
        g.drawImage(oong_w, 50, 370, this);
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


