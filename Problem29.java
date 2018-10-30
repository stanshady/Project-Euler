import java.math.*;
import java.util.*;

public class Problem29
{
    public static int len(int aMax, int bMax)
    {
        ArrayList<BigInteger> nums = new ArrayList<BigInteger>();
        for(int a = 2; a <= aMax; a++)
        {
            BigInteger aBig = new BigInteger(String.valueOf(a));
            BigInteger result = new BigInteger(String.valueOf(a));
            
            for(int b = 2; b <= bMax; b++)
            {
                result = result.multiply(aBig);
                if(!nums.contains(result))
                    nums.add(result);
            }
        }
        return nums.size();
    }
   
}