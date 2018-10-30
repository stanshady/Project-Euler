import java.math.BigInteger;

public class Problem57
{

    public static int count()
    {
        int count = 0;
        BigRational frac = new BigRational(
                new BigInteger(Integer.toString(3)), new BigInteger(Integer.toString(2)));
                
        for(int i = 0; i < 1000; i++)
        {
            if(frac.getNumer().toString().length() > frac.getDenom().toString().length())
                count++;            
            frac = nextFrac(frac);
        }
        
        return count;
    }

    public static BigRational nextFrac(BigRational frac)
    {
        BigRational TWO = new BigRational(
            new BigInteger(Integer.toString(2)), BigInteger.ONE);
            
        BigRational top = frac.add(TWO);
        BigRational bottom = frac.add(BigRational.ONE);
        
        return top.divide(bottom);
    }
}
