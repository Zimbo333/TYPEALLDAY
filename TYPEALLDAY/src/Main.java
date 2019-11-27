
import java.io.IOException;


public class Main implements Commons {

    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        Thread t = new Thread(menu);
        Music p = new Music();
        p.play();
        t.start();

    }
}
