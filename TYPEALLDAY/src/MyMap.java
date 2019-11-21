
import java.awt.*;
import static java.awt.BorderLayout.SOUTH;
import java.awt.event.*;
import java.text.AttributedCharacterIterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class MyMap extends JPanel implements KeyListener, Commons{

    static Toolkit tk = Toolkit.getDefaultToolkit();
    static int xSize = ((int) tk.getScreenSize().getWidth()); //ขนาดความกว้างตามขนาดจอของเราแนวนอน
    static int ySize = ((int) tk.getScreenSize().getHeight());//ขนาดความสูงตามขนาดจอของเราแนวตั้ง
    static String[] backG = {"bg", "bg_1", "bg_2"}; //เอาไว้ random พื้นหลังตอนเปิดเกม
    static String[] oong = {"sprite_oong-1", "sprite_oong-2"};
    static int i = getRandomNumberInRange(0, 2); //เลขที่ได้จาการ Random
    static int count, potX, potY;
    static JLabel test = new JLabel("Hello");

    public static void main(String[] args) {
        JFrame fr = new JFrame();
        ImageIcon bg = new ImageIcon("src/images/" + backG[i] + ".jpg"); //รูปพื้นหลังที่สุ่มเสร็จแล้วเอามาเก็บในตัวแปร
        ImageIcon oong_b = new ImageIcon("src/images/sprite_oong.gif");//รูปอ๋องดำ
        ImageIcon oong_w = new ImageIcon("src/images/sprite_white_oong.gif");//รูปอ๋องขาว
        JLabel img_oong_b = new JLabel(oong_b);//เอารูปใส่JLabel
        JLabel img_oong_w = new JLabel(oong_w);//เอารูปใส่JLabel
        JLabel bg_lb = new JLabel(bg);//เอารูปใส่JLabel

        fr.setSize((xSize / 2) + 300, (ySize / 2) + 200);//จัดขนาดของwindow

        JTextField txt1 = new JTextField(10);
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();

        //set layout
        p1.setLayout(new FlowLayout());
        p1.add(txt1);
        fr.add(img_oong_b);
        fr.add(img_oong_w);
        fr.add(bg_lb);
        img_oong_b.setBounds(900, 350, 150, 250);//จัดตำแหน่งรูปกับขนาด (x,y,w,h)
        img_oong_w.setBounds(50, 350, 150, 250);//จัดตำแหน่งรูปกับขนาด (x,y,w,h)
        fr.add(p1, BorderLayout.SOUTH);

        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setResizable(false);
        fr.setLocationRelativeTo(null);//ทำให้ตอนรันโค้ดแล้วทำให้windowมาอยู่ตรงกลางจอ
         int n = 8; // Number of threads 
        for (int i=0; i<8; i++) 
        { 
            Thread object = new Thread(new MultithreadingDemo());
            
            object.start(); 
        } 

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

    public void keyReleased(KeyEvent ke) {
    }

//    @Override
//    public void run() {
//        while (true) {
//            try {
//                Thread.sleep(50);
//                if (count == 1) {
//                    test.setLocation(potX + 5, potY);
//                }
//                if (count == 2) {
//                    test.setLocation(potX, potY + 5);
//                }
//                if (count == 3) {
//                    test.setLocation(potX - 5, potY);
//                }
//                if (count == 4) {
//                    test.setLocation(potX, potY - 5);
//                }
//                count++;
//                if (count == 5) {
//                    count = 1;
//                }
//
//            } catch (InterruptedException ex) {
//                Logger.getLogger(MyMap.class
//                        .getName()).log(Level.SEVERE, null, ex);
//            }
//        System.out.println(count);
//    }
//
//}
}
