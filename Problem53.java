import java.math.BigInteger;

public class Problem53
{
   
    public static int findCount()
    {
        int count = 0;
        
        for(int n = 1; n <= 100; n++)     
            count += countR(n);
            
        return count;
    }
    
    public static int countR(int n)
    {
        int count = 0;
        
        for(int r = 0; r <= n; r++)   
            if(nCr(n,r).compareTo(new BigInteger(Integer.toString(1000000))) > 0)
                count++;
        
        return count;
    }
     
    public static BigInteger nCr(int n, int r)
    {
        return factorial(n).divide(factorial(r).multiply(factorial(n - r)));
    }
    
    public static BigInteger factorial(int n)
    {
        if(n == 0)
            return BigInteger.ONE;
        else
            return new BigInteger(Integer.toString(n)).multiply(factorial(n-1));
    }
    
}
