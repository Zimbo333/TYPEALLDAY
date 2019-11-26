
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author angrykombat
 */
public class random {
        public int getRandomNumberInRange(int min, int max) {//เอาไว้สุ่มเลข
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");

        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
