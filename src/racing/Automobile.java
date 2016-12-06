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
import java.util.InputMismatchException;
public class Automobile extends Dice
{
    private int m_caryear=0, m_cargears=0, m_currentgear=0, m_currentSpeed=0;
    private String m_carmake="",m_carmodel="",m_carname="";
    private float m_distTraveled=0;
    private static int lastRoll=0;
    Dice myDice = new Dice();
    public Automobile()
    {}
    public Automobile(int year, String make, String model, String name, int numberofgears)
    {
        m_caryear = year;
        m_carmake = make;
        m_carmodel = model;
        m_carname = name;
        m_cargears = numberofgears;
        m_distTraveled = 0;
    }
    //Generates a random number between 1 and 6 more than once...
    public static int Throw(int dicecount)
    {
	int dicetotal=0;
	//rolls the dice in a loop for all rolls
	for(int count=0; count<dicecount; count++)
            dicetotal=dicetotal + Dice.Throw();
	lastRoll = dicetotal;
	return lastRoll;
    }	
    public void SetCycle(int cycle)
    {
        if(cycle<=m_cargears)
            m_currentgear=cycle;
        m_currentSpeed=m_currentgear *10;
        m_distTraveled += m_currentSpeed;
    }

    public String GetName()
    {
        return m_carname;
    }

    public int GetGear()
    {
        return m_currentgear;
    }

    public int GetSpeed()
    {
        return m_currentSpeed;
    }

    public float GetDistance()
    {
        return m_distTraveled;
    }

    private String carsound="";
    public void setSound() 
    {
        if(m_distTraveled<10)
            carsound="Prrr";
        else if (m_distTraveled>=10 && m_distTraveled<=100)
            carsound="Vroom";
        else
        {
            try
            {
                carsound="Sputter";
            }
            catch(Exception exception)
            {
                System.err.println("Your automobile is sputtering!");
            }
        }

    }

    public String getSound()
    {
        return carsound;
    }

    public String toString()
    {
        return m_carname + ": current gear= " + m_currentgear + " current speed = "+ m_currentSpeed + "car sound = " + carsound + "\t";
    }
}