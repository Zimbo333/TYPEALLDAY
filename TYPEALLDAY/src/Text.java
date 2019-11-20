/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author angrykombat
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Text implements KeyListener {

    private JLabel lb1, lb2;
    private JFrame fr;
    private int count = 0;
    private String txt2,space;

    public void init() {
        fr = new JFrame("test");
        lb1 = new JLabel("text");
        lb2 = new JLabel();
        lb1.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        lb2.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        fr.setLayout(new BorderLayout());
        fr.add(lb1, BorderLayout.CENTER);
        fr.add(lb2, BorderLayout.SOUTH);
        fr.setVisible(true);
        fr.setSize(200, 200);

        fr.addKeyListener((KeyListener) this);

    }

    public static void main(String[] args) {
        new Text().init();
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        char ch = ke.getKeyChar();
        String txt = lb1.getText();
        char arr[] = txt.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            space += " -";
        }
        
        if (ch == arr[count]) {
                txt2 = ("" + arr[count]);
                lb2.setText(lb2.getText() + txt2);
                count++;
            }
            
//        for (char c : arr) {
//            lb2.setText(lb2.getText() + "" + arr2[c] + arr3[c]);
//        }

    }
}
