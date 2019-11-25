
public class Main implements Commons {

    public static void main(String[] args) {
        Menu menu = new Menu();
        Thread t = new Thread(menu);
        t.start();

    }
}
