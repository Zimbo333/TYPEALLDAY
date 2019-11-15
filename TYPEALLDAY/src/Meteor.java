import javax.swing.ImageIcon;
public class Meteor extends Sprite{
    public Meteor(int x, int y) {

        initMeteor(x, y);
    }
     private void initMeteor(int x, int y) {

        this.x = x;
        this.y = y;

//        bomb = new Bomb(x, y);

        String alienImg = "src/images/meteor.jpg";
        ImageIcon ii = new ImageIcon(alienImg);

        setImage(ii.getImage());
    }
}
