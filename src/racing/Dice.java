/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racing;

/**
 *
 * @author uyen
 */
import java.util.Random;
public class Dice
{
    private static int lastRoll=0;
    static Random random = new Random();
	
    //Generates a random number between 1 and 6
    public static int Throw()
    {
	//rolls a random number
	lastRoll = (random.nextInt(6) +1);
	return lastRoll;
    }

    
}
