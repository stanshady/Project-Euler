import java.math.*;

public class Problem16
{
    public static long sum(String n)
    {
        long sum = 0;
        for(int i = 0; i < n.length(); i++)
        {
            sum += Integer.parseInt(n.substring(i,i+1));
        }
        return sum;
    } 
    
    public static String create()
    {
        BigInteger two = BigInteger.ONE.add(BigInteger.ONE);
        BigInteger prod = BigInteger.ONE;
        for(int i = 0; i < 1000; i++)
            prod = prod.multiply(two);
        return prod.toString();
    }
}