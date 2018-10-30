import java.util.*;

public class Problem31
{

    public static int[] coins = {1,2,5,10,20,50,100,200};
    public static int target = 200;

    public static int countDynamic()
    {
        int[] ways = new int[target + 1];
        ways[0] = 1;
        for(int i = 0; i < coins.length; i++)        
        {
            for(int j = coins[i]; j <= target; j++)            
                ways[j] += ways[j - coins[i]];
            //System.out.println(Arrays.toString(ways));
        }        
        return ways[target];
    }

    public static int count(int target, int index)
    {
        if(target < 0 || index < 0)
            return 0;
        if(target == 0)
            return 1;
        return count(target, index - 1) + count(target - coins[index], index);
    }

    public static int count()
    {
        int count = 0;
        for(int d0 = 0; d0 < 2; d0++)
            for(int d1 = 0; d1 < 3; d1++)
                for(int d2 = 0; d2 < 5; d2++)
                    for(int d3 = 0; d3 < 11; d3++)
                        for(int d4 = 0; d4 < 21; d4++)
                            for(int d5 = 0; d5 < 41; d5++)
                                for(int d6 = 0; d6 < 101; d6++)
                                {
                                    if(d0*200 +
                                    d1*100 +
                                    d2*50 +
                                    d3*20 +
                                    d4*10 +
                                    d5*5 +
                                    d6*2 <= 200)
                                        count++;
                                }
        return count;    
    }
}