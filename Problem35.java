
public class Problem35
{
    //999999 b/c 9's shift to 1st digit etc
    public static int[] primes = Algorithm.sieve(999999);

    public static int count()
    {
        int count = 0;
        for(int n : primes)
            if(shiftCheck(n))
                count++;
        return count;
    }

    public static boolean shiftCheck(int n)
    {
        int numDigits = 0;
        int temp = n;
        while(temp > 0)
        {
            numDigits++;
            temp /= 10;
        }

        int digit = n % 10;
        for(int i = 0; i < numDigits - 1; i++)
        {
            n = digit * (int) Math.pow(10, numDigits - 1) + n / 10;
            if(Algorithm.binSearch(primes, n) == -1)
                return false;
            digit = n % 10;
        }
        return true;
    }
}