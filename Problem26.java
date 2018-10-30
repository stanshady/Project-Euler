import java.util.*;

public class Problem26
{

    public static int max(int n)
    {
        int max = 1;
        int maxD = 0;
        for(int i = 1; i < n; i++)
        {
            int len = lenCycle(i);
            if (len > max)
            {
                max = len;
                maxD = i;
            }
        }
        return maxD;      
    }

    public static int lenCycle(int d)
    {
        ArrayList<Integer> remainders = new ArrayList<Integer>();
        int rem = (int) Math.pow(10, String.valueOf(d).length());

        while(!remainders.contains(rem))
        {
            if(rem % d == 0)
            {
                remainders.add(rem);
                break;
            }

            remainders.add(rem);
            rem = (rem % d) * 10;
        }
        return remainders.size();
    }
}