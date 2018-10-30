import java.math.*;

public class Problem25
{
    public static int findIndex(int n)
    {
        BigInteger f0 = BigInteger.ZERO;
        BigInteger f1 = BigInteger.ONE;
        int count = 1;
        
        while(f1.toString().length() < n)
        {
            BigInteger temp = new BigInteger(f0.toString());
            f0 = f1;
            f1 = f1.add(temp);
            count++;
        }
        
        return count;
    }
}