
import javax.swing.ImageIcon;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author angrykombat
 */
public class sprite{
    private ImageIcon player,enemy,enemy_damage, player_damaged;

    public ImageIcon getEnemy_damage() {
        return enemy_damage;
    }

    public void setEnemy_damage(ImageIcon enemy_damage) {
        this.enemy_damage = enemy_damage;
    }

    public ImageIcon getPlayer_damaged() {
        return player_damaged;
    }

    public void setPlayer_damaged(ImageIcon player_damaged) {
        this.player_damaged = player_damaged;
    }

    public ImageIcon getEnemy() {
        return enemy;
    }

    public void setEnemy(ImageIcon enemy) {
        this.enemy = enemy;
    }

    public ImageIcon getPlayer() {
        return player;
    }

    public void setPlayer(ImageIcon player) {
        this.player = player;
    }






}
