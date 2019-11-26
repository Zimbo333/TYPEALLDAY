
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import java.awt.event.KeyListener;

public class MyMap extends JPanel implements ActionListener, KeyListener, Commons, Runnable {
    
    private sprite sprite = new sprite();
    private HP health = new HP();
    private random random = new random();
    private endgame end = new endgame();
    private speed speed = new speed();
    private String[] backG = {"bg", "bg_1", "bg_2"}; //เอาไว้ randoms พื้นหลังตอนเปิดเกม
    private int i = random.getRandomNumberInRange(0, 2); //เลขที่ได้จาการ Random
    private int potX[] = {random.getRandomNumberInRange(100, 700), random.getRandomNumberInRange(100, 700), random.getRandomNumberInRange(100, 700), 525};
    static int potY[] = {-200, -400, -600};
    private int score = 0;
    private static JFrame fr;
    private ImageIcon bg;
    private JLabel text1, text2, text3, endSCENE, img_HP1, img_HP2, img_HP3, img_enemy, img_player, background_label, scr, answer;
    private JButton btn_retry, btn_menu;
    static MyMap Map;

    public MyMap() {
        fr = new JFrame();

        bg = new ImageIcon("src/images/" + backG[i] + ".jpg"); //รูปพื้นหลังที่สุ่มเสร็จแล้วเอามาเก็บในตัวแปร
        health.setImageHP(new ImageIcon("src/images/hp.gif"));
        end.setGame_over(new ImageIcon("src/images/game_over.png"));
        end.setImg_menu(new ImageIcon("src/images/menu.png"));
        end.setImg_retry(new ImageIcon("src/images/retry.png"));
        sprite.setPlayer(new ImageIcon("src/images/player.gif"));//รูป Player
        sprite.setPlayer_damaged(new ImageIcon("src/images/player_damage.gif"));//รูป Player โดนตี
        sprite.setEnemy(new ImageIcon("src/images/sprite_oong.gif"));//รูป Enemy
        sprite.setEnemy_damage(new ImageIcon("src/images/sprite_oong_dmg.png"));//รูป Enemy
        health.setHP(3);
        speed.setSpeed(100);
        text1 = new JLabel(words[random.getRandomNumberInRange(0, 978)]);
        text2 = new JLabel(words[random.getRandomNumberInRange(0, 978)]);
        text3 = new JLabel(words[random.getRandomNumberInRange(0, 978)]);
        scr = new JLabel("SCORE : " + score + "");//คะแนน
        background_label = new JLabel(bg);//เอารูปใส่JLabel game_over
        answer = new JLabel();
        endSCENE = new JLabel(end.getGame_over());
        img_HP1 = new JLabel(health.getImageHP());
        img_HP2 = new JLabel(health.getImageHP());
        img_HP3 = new JLabel(health.getImageHP());
        img_enemy = new JLabel(sprite.getEnemy());//เอารูปใส่JLabel
        img_player = new JLabel(sprite.getPlayer());//เอารูปใส่JLabel
        btn_retry = new JButton(end.getImg_retry());
        btn_menu = new JButton(end.getImg_menu());

        fr.setSize(1100, 650);//จัดขนาดของwindow

        fr.add(endSCENE);
        fr.add(btn_retry);
        fr.add(btn_menu);
        fr.add(text1);
        fr.add(text2);
        fr.add(text3);

        fr.add(img_HP1);
        fr.add(img_HP2);
        fr.add(img_HP3);

        fr.add(img_enemy);
        fr.add(img_player);
        fr.add(scr);
        fr.add(answer);
        fr.add(background_label);
//        endSCENE.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        text1.setForeground(Color.white);
        text1.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        text2.setForeground(Color.white);
        text2.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        text3.setForeground(Color.white);
        text3.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        answer.setForeground(new Color(46,127,6));
        answer.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        scr.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        scr.setForeground(new Color(228, 245, 255));

        answer.setBounds(potX[3], 450, 1000, 200); //setbound = ตำแหน่ง 
        scr.setBounds(10, 0, 300, 64);//จัดตำแหน่งรูปกับขนาด (x,y,width,height)
        img_HP1.setBounds(900, 0, 64, 64);//จัดตำแหน่งรูปกับขนาด (x,y,width,height)
        img_HP2.setBounds(950, 0, 64, 64);//จัดตำแหน่งรูปกับขนาด (x,y,width,height)
        img_HP3.setBounds(1000, 0, 64, 64);//จัดตำแหน่งรูปกับขนาด (x,y,width,height)
        btn_retry.setBounds(1000, 1000, 215, 73);//จัดตำแหน่งรูปกับขนาด (x,y,width,height)
        btn_menu.setBounds(1000, 1000, 215, 73);//จัดตำแหน่งรูปกับขนาด (x,y,width,height)
        endSCENE.setBounds(1000, 1000, 1000, 250);//จัดตำแหน่งรูปกับขนาด (x,y,width,height)
        img_enemy.setBounds(880, 350, 150, 250);//จัดตำแหน่งรูปกับขนาด (x,y,width,height)
        img_player.setBounds(50, 350, 150, 250);//จัดตำแหน่งรูปกับขนาด (x,y,width,height)

        btn_retry.setBorder(BorderFactory.createEmptyBorder()); //ทำให้ปุ่มไม่มีขอบ
        btn_retry.setContentAreaFilled(false);                  // ไม่มีพื้นหลังปุ่ม

        btn_menu.setBorder(BorderFactory.createEmptyBorder());//ทำให้ปุ่มไม่มีขอบ
        btn_menu.setContentAreaFilled(false);

        btn_retry.addActionListener(this);
        btn_menu.addActionListener(this);
        fr.addKeyListener(this);
        fr.setFocusable(true);
//        fr.add(meteor.paint());
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setResizable(false);
        fr.setLocationRelativeTo(null);//ทำให้ตอนรันโค้ดแล้วทำให้windowมาอยู่ตรงกลางจอ
    }


    public void run() {
        try {
            while (health.getHP() != 0) {
                Thread.sleep(speed.getSpeed());
                text1.setBounds(potX[0], potY[0], 1000, 250);
                text2.setBounds(potX[1], potY[1], 1000, 250);
                text3.setBounds(potX[2], potY[2], 1000, 250);

                //check text
                if (answer.getText().equals(text1.getText())) {
                    img_enemy.setIcon(sprite.getEnemy_damage());
                    potY[0] = -300;
                    score += 100;
                    scr.setText("SCORE : " + score + "");
                    potX[3] = 525;
                    if (speed.getSpeed() > 40) {
                        speed.setSpeed(speed.getSpeed()-1);
                    }
                    answer.setText("");
                }

                if (answer.getText().equals(text2.getText())) {
                    img_enemy.setIcon(sprite.getEnemy_damage());
                    potY[1] = -300;
                    score += 100;
                    scr.setText("SCORE : " + score + "");
                    potX[3] = 525;
                    if (speed.getSpeed() > 40) {
                        speed.setSpeed(speed.getSpeed()-1);
                    }
                    answer.setText("");
                }
                if (answer.getText().equals(text3.getText())) {
                    img_enemy.setIcon(sprite.getEnemy_damage());
                    potY[2] = -300;
                    score += 100;
                    scr.setText("SCORE : " + score + "");
                    potX[3] = 525;
                    if (speed.getSpeed() > 40) {
                        speed.setSpeed(speed.getSpeed()-1);
                    }
                    answer.setText("");
                }
                //change รูปอ๋องขาวที่โดนตีให้กับมาเป็นตัวเดิม
                if (potY[0] == -290 || potY[1] == -290 || potY[2] == -290) {
                    img_enemy.setIcon(sprite.getEnemy());
                }
                //------TEXT1------
                //text down floor to HP decrease
                if (potY[0] > 425) {
                    img_player.setIcon(sprite.getPlayer_damaged());
                    potY[0] = -165;
                    potX[0] = random.getRandomNumberInRange(100, 700);
                    health.setHP(health.getHP() - 1);
                }
                //change text
                if (potY[0] == -155) {
                    text1.setText(words[random.getRandomNumberInRange(0, 978)]);
                    img_player.setIcon(sprite.getPlayer());
                }
                //------TEXT2------
                //text down floor to HP decrease
                if (potY[1] > 425) {
                    img_player.setIcon(sprite.getPlayer_damaged());
                    potY[1] = -165;
                    potX[1] = random.getRandomNumberInRange(100, 700);
                    health.setHP(health.getHP() - 1);
                }
                //change text
                if (potY[1] == -155) {
                    text2.setText(words[random.getRandomNumberInRange(0, 978)]);
                    img_player.setIcon(sprite.getPlayer());
                }
                //------TEXT3------
                //text down floor to HP decrease
                if (potY[2] > 425) {
                    img_player.setIcon(sprite.getPlayer_damaged());
                    potY[2] = -165;
                    potX[2] = random.getRandomNumberInRange(100, 700);
                    health.setHP(health.getHP() - 1);
                }
                //change text
                if (potY[2] == -155) {
                    text3.setText(words[random.getRandomNumberInRange(0, 978)]);
                    img_player.setIcon(sprite.getPlayer());
                }
                if (health.getHP() == 2) {
                    img_HP1.setBounds(2000, 0, 64, 64);
                }
                if (health.getHP() == 1) {
                    img_HP2.setBounds(2000, 0, 64, 64);
                }

                potY[0] += 5;
                potY[1] += 5;
                potY[2] += 5;
            }

        } catch (Exception e) {
        }
        if (health.getHP() == 0) {
            endSCENE.setBounds(50, 150, 1000, 250);
            btn_retry.setBounds(355, 320, 215, 73);
            btn_menu.setBounds(525, 320, 215, 73);
            img_HP3.setBounds(2000, 0, 64, 64);
        }

        repaint();
    }

    public void reset() {
        fr.dispose();
        Map = new MyMap();
        Thread t1 = new Thread(Map);
        t1.start();
        health.setHP(3);
        potY[0] = -200;
        potY[1] = -400;
        potY[2] = -600;
        i = random.getRandomNumberInRange(0, 2);
        img_HP1.setBounds(900, 0, 64, 64);
        img_HP2.setBounds(950, 0, 64, 64);
        img_HP3.setBounds(1000, 0, 64, 64);
        btn_retry.setBounds(1000, 1000, 215, 73);
        btn_menu.setBounds(1000, 1000, 215, 73);
        endSCENE.setBounds(1000, 1000, 1000, 250);
        img_player.setIcon(sprite.getPlayer());
        scr.setText("SCORE : " +score + "");
        potX[3] = 525;
        answer.setBounds(potX[3], 450, 500, 200);
        answer.setText("");
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btn_retry) {
            score = 0;
            fr.dispose();
            reset();
            
        }
        if (ae.getSource() == btn_menu) {
            score = 0;
            Menu menu = new Menu();
            Thread t = new Thread(menu);
            t.start();
            fr.dispose();
        }
    }
    @Override
    public void keyPressed(KeyEvent ke) {
        char ch;
        int c = ke.getKeyCode();

        if (c != 8 && c != 16) {
            ch = ke.getKeyChar();
            answer.setText(answer.getText() + "" + ch);
            potX[3] -= 10;
            answer.setBounds(potX[3], 450, 500, 200);
        } else if (c == 8) {
            answer.setText("");
            potX[3] = 525;
            answer.setBounds(potX[3], 450, 1000, 200);
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

}