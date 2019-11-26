
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FontTest {
    private Font pixelMplus;
    private int x = -168;

    public void init() throws FontFormatException {
        try {
            pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("src/font/VCR_OSD_MONO_1.001.ttf")).deriveFont(30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/font/VCR_OSD_MONO_1.001.ttf")));
        } 
        catch (IOException e) {
            
        }
        JFrame fr = new JFrame("TYPEALLDAY");
        JPanel p1 = new JPanel();
        JLabel header = new JLabel("HOW TO PLAY");
        header.setFont(pixelMplus);
        fr.setSize(500, 630);
        fr.add(header);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
        fr.setResizable(false);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) throws FontFormatException {
        FontTest fr = new FontTest();
        fr.init();
    }
}
