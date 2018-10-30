import java.math.*;

public class Problem20
{
    
    public static BigInteger sum(BigInteger n)
    {
        String num = n.toString();
        BigInteger sum = BigInteger.ZERO;
        
        for(int i = 0; i < num.length(); i++)
            sum = sum.add(new BigInteger(num.substring(i,i+1)));
        return sum;
    }
    
    public static BigInteger factorial(BigInteger n)
    {
        if(n.equals(BigInteger.ONE))
            return BigInteger.ONE;
        
        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }
}