import java.math.BigInteger;

public class Problem56
{
   
    public static int findMaxSum()
    {
        int max = 0;
        BigInteger bigA;
        BigInteger powA;
        
        for(int a = 1; a < 100; a++)
        {
            bigA = new BigInteger(Integer.toString(a));
            powA = BigInteger.ONE;
            
            for(int b = 1; b < 100; b++)
            {
                //pow() is WAY to slow
                powA = powA.multiply(bigA);
                max = Math.max(max, sumDigits(powA));
            }
        }
        
        return max;
    }
    
    public static int sumDigits(BigInteger big)
    {
        int sum = 0;
        String str = big.toString();
        
        for(int i = 0; i < str.length(); i++)
        {
            sum += Integer.parseInt(str.substring(i,i+1));
        }
        
        return sum;
    }
    
}
