import java.math.BigInteger;

public class Problem48
{
    public static BigInteger sum()
    {
        BigInteger sum = BigInteger.ZERO;
 
        for(int n = 1; n <= 1000; n++)  
            sum = sum.add(nToN(n));
    
        System.out.println(sum.mod(new BigInteger("10000000000")));
        return sum;
    }
    
    public static BigInteger nToN(int n)
    {
        BigInteger ans = BigInteger.ONE;
        BigInteger base = new BigInteger(Integer.toString(n));
        
        for(int i = 0; i < n; i++)
            ans = ans.multiply(base);   
            
        return ans;
    }
    
}
