
public class Problem3
{

    public static long findMax(long n)
    {
        long max = 0;
        long[] factors = new long[2];
        for(long i = 2; i * i <= n; i++)
        {
            if(n % i == 0)
            {
                factors[0] = i;
                factors[1] = n / i;
            }
            else 
                continue;
            if(isPrime(factors[0]) && factors[0] > max)
                max = factors[0];
            if(isPrime(factors[1]) && factors[1] > max)
                max = factors[1];  
        }
        return max;       
    }

    public static boolean isPrime(long n)
    {
        for(long i = 2; i <= Math.sqrt(n); i++)
        {
            if(n % i == 0)
                return false;
        }
        return true;
    }
}