
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
    static ImageIcon game_over = new ImageIcon("src/images/game_over.png");
    static ImageIcon img_hp = new ImageIcon("src/images/hp.gif");
    static ImageIcon oong_b = new ImageIcon("src/images/sprite_oong.gif");//รูปอ๋องดำ
    static ImageIcon oong_w = new ImageIcon("src/images/sprite_white_oong.gif");//รูปอ๋องขาว
    static ImageIcon oong_b_dm = new ImageIcon("src/images/sprite_oong_dmg.png");//รูปอ๋องดำโดนตี
    static ImageIcon oong_w_dm = new ImageIcon("src/images/sprite_white_oong_dmg.png");//รูปอ๋องขาวโดนตี
    static JLabel text1 = new JLabel(words[getRandomNumberInRange(0, 900)]);
    static JLabel text2 = new JLabel(words[getRandomNumberInRange(0, 900)]);
    static JLabel text3 = new JLabel(words[getRandomNumberInRange(0, 900)]);
    static JLabel endSCENE = new JLabel(game_over);
    static JLabel img_HP1 = new JLabel(img_hp);
    static JLabel img_HP2 = new JLabel(img_hp);
    static JLabel img_HP3 = new JLabel(img_hp);
    static JLabel img_oong_b = new JLabel(oong_b);//เอารูปใส่JLabel
    static JLabel img_oong_w = new JLabel(oong_w);//เอารูปใส่JLabel
    static int potX[] = {getRandomNumberInRange(100, 700), getRandomNumberInRange(100, 700), getRandomNumberInRange(100, 700)};
    static int potY[] = {-200, -400, -600};
    static int speed = 100;
    static int status = 0;
    static JFrame fr = new JFrame();

    public static void main() {
        MyMap Map = new MyMap();
        
        ImageIcon bg = new ImageIcon("src/images/" + backG[i] + ".jpg"); //รูปพื้นหลังที่สุ่มเสร็จแล้วเอามาเก็บในตัวแปร
        JLabel bg_lb = new JLabel(bg);//เอารูปใส่JLabel game_over
        

        fr.setSize(1100, 650);//จัดขนาดของwindow

        JPanel p1 = new JPanel();

        //set layout
        p1.setLayout(new FlowLayout());
        p1.add(answer);
        fr.add(endSCENE);
        fr.add(text1);
        fr.add(text2);
        fr.add(text3);
        fr.add(img_HP1);
        fr.add(img_HP2);
        fr.add(img_HP3);
        
        
        fr.add(img_oong_b);
        fr.add(img_oong_w);
        fr.add(bg_lb);
//        endSCENE.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        text1.setForeground(Color.white);
        text1.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        text2.setForeground(Color.white);
        text2.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        text3.setForeground(Color.white);
        text3.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        p1.setBackground(Color.black);
        
        img_HP1.setBounds(900, 0, 64, 64);
        img_HP2.setBounds(950, 0, 64, 64);
        img_HP3.setBounds(1000, 0, 64, 64);
        endSCENE.setBounds(1000, 1000, 1000, 250);
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
                    img_oong_w.setIcon(oong_w_dm);
                    potY[0] = -300;
                    if(speed > 40){speed--;}
                    answer.setText("");
                }
                
                if (answer.getText().equals(text2.getText())) {
                    img_oong_w.setIcon(oong_w_dm);
                    potY[1] = -300;
                    if(speed > 40){speed--;}
                    answer.setText("");
                }
                if (answer.getText().equals(text3.getText())) {
                    img_oong_w.setIcon(oong_w_dm);
                    potY[2] = -300;
                    if(speed > 40){speed--;}
                    answer.setText("");
                }
                //change รูปอ๋องขาวที่โดนตีให้กับมาเป็นตัวเดิม
                if(potY[0] == -295|| potY[1] == -295|| potY[2] == -295){img_oong_w.setIcon(oong_w);}
                //text down floor to HP decrease
                if (potY[0] > 425) {                  
                    img_oong_b.setIcon(oong_b_dm);
                    potY[0] = -140;
                    potX[0] = getRandomNumberInRange(100, 700);
                    hp -= 1;
                }
                //change text
                if (potY[0] == -135) {
                    text1.setText(words[getRandomNumberInRange(0, 900)]);
                    img_oong_b.setIcon(oong_b);
                }
                //text down floor to HP decrease
                if (potY[1] > 425) {
                    img_oong_b.setIcon(oong_b_dm);
                    potY[1] = -140;
                    potX[1] = getRandomNumberInRange(100, 700);
                    hp -= 1;
                }
                //change text
                if (potY[1] == -135) {
                    text2.setText(words[getRandomNumberInRange(0, 900)]);
                    img_oong_b.setIcon(oong_b);
                }
                //text down floor to HP decrease
                if (potY[2] > 425) {
                    img_oong_b.setIcon(oong_b_dm);
                    potY[2] = -140;
                    potX[2] = getRandomNumberInRange(100, 700);
                    hp -= 1;
                }
                //change text
                if (potY[2] == -135) {
                    text3.setText(words[getRandomNumberInRange(0, 900)]);
                    img_oong_b.setIcon(oong_b);
                }
               if(hp == 2){img_HP1.setBounds(2000, 0, 64, 64);}
               if(hp == 1){img_HP2.setBounds(2000, 0, 64, 64);}
                potY[0] += 5;
                potY[1] += 5;
                potY[2] += 5;
            } 
            
        } catch (Exception e) {
        }
        if(hp == 0){
                    endSCENE.setBounds(50, 200, 1000, 250);
                    img_HP3.setBounds(2000, 0, 64, 64);
                    
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
