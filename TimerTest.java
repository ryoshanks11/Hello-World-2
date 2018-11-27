package guitest;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest
{
    private int CurrentValue = 0;
    ArrayList<Integer> AmountList = new ArrayList<Integer>();
    Timer t = new Timer();
    
    public void timer() 
    {
        
        t.schedule(new TimerTask() 
        {
            @Override
            public void run() 
            { 
                //System.out.println(getValue(isDeposit(), randomValue()));
                CurrentValue=getValue(isDeposit(), randomValue());
                getCurrentValue();
                
                AmountList.add(CurrentValue);
            }
        }, 0, 5000); 
    }

    public static boolean isDeposit() 
    {
        Random r = new Random();
        boolean i = r.nextBoolean();
        return i;
    }
    
    public static int randomValue()
    {
        Random r = new Random();
        int value = 100 + r.nextInt(2000);
        return value;
    }
    
    public ArrayList getAmountList()
    {
        return AmountList;
    }
    
    public int getCurrentValue()
    {
        System.out.println(CurrentValue);
        return CurrentValue;
    }
    
    public Timer getTimer()
    {
        return t;
    }
    
    public void stopTimer()
    {
        t.cancel();
        t.purge();
    }
    
    public static int getValue(boolean isDeposit, int value)
    {
        if(isDeposit)
        {
            return value;
        }
        else
        {
            return (-1 * value);
        }
    }
}