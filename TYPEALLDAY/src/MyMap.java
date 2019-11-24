
import java.awt.*;
import static java.awt.BorderLayout.SOUTH;
import java.awt.event.*;
import java.text.AttributedCharacterIterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class MyMap extends JPanel implements ActionListener, Commons, Runnable {

    static String[] backG = {"bg", "bg_1", "bg_2"}; //เอาไว้ random พื้นหลังตอนเปิดเกม
    static int i = getRandomNumberInRange(0, 2); //เลขที่ได้จาการ Random
    static int hp = 1;
    static int potX[] = {getRandomNumberInRange(100, 700), getRandomNumberInRange(100, 700), getRandomNumberInRange(100, 700)};
    static int potY[] = {-200, -400, -600};
    static int speed = 100;
    static int score = 0;
    private boolean check = true;
    private JFrame fr;
    private JTextField answer;
    private ImageIcon game_over, img_hp, img_menu, img_retry, oong_b, oong_w, oong_b_dm, oong_w_dm, bg;
    private JLabel text1, text2, text3, endSCENE, img_HP1, img_HP2, img_HP3, img_oong_b, img_oong_w, bg_lb, scr;
    private JButton btn_1, btn_2;

    public MyMap() {
        fr = new JFrame();
        answer = new JTextField(10);
        bg = new ImageIcon("src/images/" + backG[i] + ".jpg"); //รูปพื้นหลังที่สุ่มเสร็จแล้วเอามาเก็บในตัวแปร
        game_over = new ImageIcon("src/images/game_over.png");
        img_hp = new ImageIcon("src/images/hp.gif");
        img_menu = new ImageIcon("src/images/menu.png");
        img_retry = new ImageIcon("src/images/retry.png");
        oong_b = new ImageIcon("src/images/sprite_oong.gif");//รูปอ๋องดำ
        oong_w = new ImageIcon("src/images/sprite_white_oong.gif");//รูปอ๋องขาว
        oong_b_dm = new ImageIcon("src/images/sprite_oong_dmg.png");//รูปอ๋องดำโดนตี
        oong_w_dm = new ImageIcon("src/images/sprite_white_oong_dmg.png");//รูปอ๋องขาวโดนตี
        text1 = new JLabel(words[getRandomNumberInRange(0, 900)]);
        text2 = new JLabel(words[getRandomNumberInRange(0, 900)]);
        text3 = new JLabel(words[getRandomNumberInRange(0, 900)]);
        bg_lb = new JLabel(bg);//เอารูปใส่JLabel game_over
        endSCENE = new JLabel(game_over);
        img_HP1 = new JLabel(img_hp);
        img_HP2 = new JLabel(img_hp);
        img_HP3 = new JLabel(img_hp);
        img_oong_b = new JLabel(oong_b);//เอารูปใส่JLabel
        img_oong_w = new JLabel(oong_w);//เอารูปใส่JLabel
        btn_1 = new JButton(img_retry);
        btn_2 = new JButton(img_menu);
        scr = new JLabel("SCORE : "+score + "");
        //answer.setVisible(false);
        fr.setSize(1100, 650);//จัดขนาดของwindow

        JPanel p1 = new JPanel();

        //set layout
        p1.setLayout(new FlowLayout());
        p1.add(answer);
        fr.add(endSCENE);
        fr.add(btn_1);
        fr.add(btn_2);
        fr.add(text1);
        fr.add(text2);
        fr.add(text3);
        fr.add(img_HP1);
        fr.add(img_HP2);
        fr.add(img_HP3);
        fr.add(p1, BorderLayout.SOUTH);

        fr.add(img_oong_b);
        fr.add(img_oong_w);
        fr.add(scr);
        fr.add(bg_lb);

//        endSCENE.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        text1.setForeground(Color.white);
        text1.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        text2.setForeground(Color.white);
        text2.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        text3.setForeground(Color.white);
        text3.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        scr.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        scr.setForeground(new Color(228, 245, 255));
        p1.setBackground(Color.black);

        scr.setBounds(10, 0, 200, 64);
        img_HP1.setBounds(900, 0, 64, 64);
        img_HP2.setBounds(950, 0, 64, 64);
        img_HP3.setBounds(1000, 0, 64, 64);
        btn_1.setBounds(1000, 1000, 215, 73);
        btn_2.setBounds(1000, 1000, 215, 73);
        endSCENE.setBounds(1000, 1000, 1000, 250);
        img_oong_b.setBounds(900, 350, 150, 250);//จัดตำแหน่งรูปกับขนาด (x,y,w,h)
        img_oong_w.setBounds(50, 350, 150, 250);//จัดตำแหน่งรูปกับขนาด (x,y,w,h)

        btn_1.setBorder(BorderFactory.createEmptyBorder()); //ทำให้ปุ่มไม่มีขอบ
        btn_1.setContentAreaFilled(false);                  // ไม่มีพื้นหลังปุ่ม

        btn_2.setBorder(BorderFactory.createEmptyBorder());//ทำให้ปุ่มไม่มีขอบ
        btn_2.setContentAreaFilled(false);

        btn_1.addActionListener(this);
        btn_2.addActionListener(this);

//        fr.add(meteor.paint());
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setResizable(false);
        fr.setLocationRelativeTo(null);//ทำให้ตอนรันโค้ดแล้วทำให้windowมาอยู่ตรงกลางจอ
    }

    public static void main() {
        MyMap Map = new MyMap();
        Thread t1 = new Thread(Map);
        t1.start();
    }

    public void run() {
        try {
            while (check) {
                Thread.sleep(speed);
                text1.setBounds(potX[0], potY[0], 1000, 250);
                text2.setBounds(potX[1], potY[1], 1000, 250);
                text3.setBounds(potX[2], potY[2], 1000, 250);

                //check text
                if (answer.getText().equals(text1.getText())) {
                    img_oong_b.setIcon(oong_b_dm);
                    potY[0] = -300;
                    score += 100;
                    scr.setText("SCORE : "+score + "");
                    if (speed > 40) {
                        speed--;
                    }
                    answer.setText("");
                }

                if (answer.getText().equals(text2.getText())) {
                    img_oong_b.setIcon(oong_b_dm);
                    potY[1] = -300;
                    score += 100;
                    scr.setText("SCORE : "+score + "");
                    if (speed > 40) {
                        speed--;
                    }
                    answer.setText("");
                }
                if (answer.getText().equals(text3.getText())) {
                    img_oong_b.setIcon(oong_b_dm);
                    potY[2] = -300;
                    score += 100;
                    scr.setText("SCORE : "+score + "");
                    if (speed > 40) {
                        speed--;
                    }
                    answer.setText("");
                }
                //change รูปอ๋องขาวที่โดนตีให้กับมาเป็นตัวเดิม
                if (potY[0] == -290 || potY[1] == -290 || potY[2] == -290) {
                    img_oong_b.setIcon(oong_b);
                }
                //text down floor to HP decrease
                if (potY[0] > 425) {
                    img_oong_w.setIcon(oong_w_dm);
                    potY[0] = -145;
                    potX[0] = getRandomNumberInRange(100, 700);
                    hp -= 1;
                }
                //change text
                if (potY[0] == -135) {
                    text1.setText(words[getRandomNumberInRange(0, 900)]);
                    img_oong_w.setIcon(oong_w);
                }
                //text down floor to HP decrease
                if (potY[1] > 425) {
                    img_oong_w.setIcon(oong_w_dm);
                    potY[1] = -145;
                    potX[1] = getRandomNumberInRange(100, 700);
                    hp -= 1;
                }
                //change text
                if (potY[1] == -135) {
                    text2.setText(words[getRandomNumberInRange(0, 900)]);
                    img_oong_w.setIcon(oong_w);
                }
                //text down floor to HP decrease
                if (potY[2] > 425) {
                    img_oong_w.setIcon(oong_w_dm);
                    potY[2] = -145;
                    potX[2] = getRandomNumberInRange(100, 700);
                    hp -= 1;
                }
                //change text
                if (potY[2] == -135) {
                    text3.setText(words[getRandomNumberInRange(0, 900)]);
                    img_oong_w.setIcon(oong_w);
                }
                if (hp == 2) {
                    img_HP1.setBounds(2000, 0, 64, 64);
                }
                if (hp == 1) {
                    img_HP2.setBounds(2000, 0, 64, 64);
                }
                if (hp == 0) {
                    endSCENE.setBounds(50, 150, 1000, 250);
                    btn_1.setBounds(355, 320, 215, 73);
                    btn_2.setBounds(525, 320, 215, 73);
                    img_HP3.setBounds(2000, 0, 64, 64);
                    check = false;
                    System.out.println(check);
                }

                potY[0] += 5;
                potY[1] += 5;
                potY[2] += 5;
            }

        } catch (Exception e) {
        }

        repaint();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btn_1) {
            check = true;
            System.out.println(check);

        }
        if (ae.getSource() == btn_2) {
            Menu menu = new Menu();
            Thread t = new Thread(menu);
            t.start();
            fr.dispose();
        }
    }

    private static int getRandomNumberInRange(int min, int max) {//เอาไว้สุ่มเลข
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");

        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static void setSpeed(int speed) {
        MyMap.speed = speed;
    }

}
