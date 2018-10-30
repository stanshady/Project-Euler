import java.util.*;
public class Problem47
{
    public static int[] primes = Algorithm.sieve(100000);

    public static int[] findConseq()
    {
        int[] ans = new int[4];
        int i = 0;
        int count = 0;
        int n = 2*3*5*7;
        while(count < 4)
        {
            if(countFactors(n, 4))
            {
                ans[i] = n;
                i++;
                count++;
            }
            else
            {
                count = 0;
                i = 0;
            }
            n++;
        }
        return ans;
    }

    public static boolean countFactors(int n, int size)
    {
        ArrayList<Integer> factors = new ArrayList<Integer>();
        int i = 0;
        while(n > 1)
        {
            while(n % primes[i] == 0)
            {
                if(!factors.contains(primes[i]))
                    factors.add(primes[i]);
                n /= primes[i];
            }
            i++;
        }
        return factors.size() == size;
    }
}
