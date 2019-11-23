
import java.awt.*;
import static java.awt.BorderLayout.SOUTH;
import java.awt.event.*;
import java.text.AttributedCharacterIterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class MyMap extends JPanel implements KeyListener, Commons, Runnable {

    static String[] backG = {"bg", "bg_1", "bg_2"}; //เอาไว้ random พื้นหลังตอนเปิดเกม
    static int i = getRandomNumberInRange(0, 2); //เลขที่ได้จาการ Random
    static JTextField answer = new JTextField(10);
    static int hp = 3;
    static JLabel text1 = new JLabel(words[getRandomNumberInRange(0, 900)]);
    static JLabel text2 = new JLabel(words[getRandomNumberInRange(0, 900)]);
    static JLabel text3 = new JLabel(words[getRandomNumberInRange(0, 900)]);
    static JLabel HP_bar = new JLabel(Integer.toString(hp));
    static JLabel endSCENE = new JLabel("GAME OVER");
    static int potX[] = {getRandomNumberInRange(100, 700), getRandomNumberInRange(100, 700), getRandomNumberInRange(100, 700)};
    static int potY[] = {-100, -300, -500};
    static int speed = 100;
    static int status = 0;

    public static void main() {
        MyMap Map = new MyMap();
        JFrame fr = new JFrame();
        ImageIcon bg = new ImageIcon("src/images/" + backG[i] + ".jpg"); //รูปพื้นหลังที่สุ่มเสร็จแล้วเอามาเก็บในตัวแปร
        ImageIcon oong_b = new ImageIcon("src/images/sprite_oong.gif");//รูปอ๋องดำ
        ImageIcon oong_w = new ImageIcon("src/images/sprite_white_oong.gif");//รูปอ๋องขาว
        JLabel img_oong_b = new JLabel(oong_b);//เอารูปใส่JLabel
        JLabel img_oong_w = new JLabel(oong_w);//เอารูปใส่JLabel
        JLabel bg_lb = new JLabel(bg);//เอารูปใส่JLabel
        

        fr.setSize(1100, 650);//จัดขนาดของwindow

        JPanel p1 = new JPanel();

        //set layout
        p1.setLayout(new FlowLayout());
        p1.add(answer);
        fr.add(text1);
        fr.add(text2);
        fr.add(text3);
        fr.add(HP_bar);
        
        fr.add(img_oong_b);
        fr.add(img_oong_w);
        fr.add(bg_lb);
        endSCENE.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
        text1.setForeground(Color.white);
        text1.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
        text2.setForeground(Color.white);
        text2.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
        text3.setForeground(Color.white);
        text3.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
        HP_bar.setForeground(Color.white);
        HP_bar.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
        p1.setBackground(Color.black);

        HP_bar.setBounds(1000, -80, 1000, 250);
        img_oong_b.setBounds(900, 350, 150, 250);//จัดตำแหน่งรูปกับขนาด (x,y,w,h)
        img_oong_w.setBounds(50, 350, 150, 250);//จัดตำแหน่งรูปกับขนาด (x,y,w,h)
        fr.add(p1, BorderLayout.SOUTH);

        Thread t1 = new Thread(Map);
        t1.start();

//        fr.add(meteor.paint());
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setResizable(false);
        fr.setLocationRelativeTo(null);//ทำให้ตอนรันโค้ดแล้วทำให้windowมาอยู่ตรงกลางจอ
    }

    public void run() {       
        try {
            while (hp != 0) {
                Thread.sleep(speed);
                text1.setBounds(potX[0], potY[0], 1000, 250);
                text2.setBounds(potX[1], potY[1], 1000, 250);
                text3.setBounds(potX[2], potY[2], 1000, 250);

                //check text
                if (answer.getText().equals(text1.getText())) {
                    potY[0] = -300;
                    if(speed > 40){speed--;}
                    answer.setText("");
                }
                if (answer.getText().equals(text2.getText())) {
                    potY[1] = -300;
                    if(speed > 40){speed--;}
                    answer.setText("");
                }
                if (answer.getText().equals(text3.getText())) {
                    potY[2] = -300;
                    if(speed > 40){speed--;}
                    answer.setText("");
                }
                //text down floor to HP decrease
                if (potY[0] > 425) {
                    hp -= 1;
                    potY[0] = -135;
                    potX[0] = getRandomNumberInRange(100, 700);
                }
                //change text
                if (potY[0] == -130) {
                    text1.setText(words[getRandomNumberInRange(0, 900)]);
                }
                //text down floor to HP decrease
                if (potY[1] > 425) {
                    potY[1] = -130;
                    potX[1] = getRandomNumberInRange(100, 700);
                    hp -= 1;
                }
                //change text
                if (potY[1] == -135) {
                    text2.setText(words[getRandomNumberInRange(0, 900)]);
                }
                //text down floor to HP decrease
                if (potY[2] > 425) {
                    potY[2] = -135;
                    potX[2] = getRandomNumberInRange(100, 700);
                    hp -= 1;
                }
                //change text
                if (potY[2] == -130) {
                    text3.setText(words[getRandomNumberInRange(0, 900)]);
                }
                if(hp == 0){
                    this.status = 1;
                }
                HP_bar.setText(Integer.toString(hp));
                potY[0] += 5;
                potY[1] += 5;
                potY[2] += 5;
                System.out.println(speed);
            }
        } catch (Exception e) {
        }
        repaint();
    }

    private static int getRandomNumberInRange(int min, int max) {//เอาไว้สุ่มเลข
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");

        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public void keyTyped(KeyEvent ke) {
    }

    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

    void main(char c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void setSpeed(int speed) {
        MyMap.speed = speed;
    }
    
}
