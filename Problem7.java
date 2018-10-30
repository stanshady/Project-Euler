//look in problem 10 for more prime stuff
public class Problem7
{
    public static int[] primes(int n)
    {
        int[] primes = new int[n];
        //use PNT * 1.2 for length of sieve
        int[] sieve = new int[(int)(1.2*n*Math.log(n))];
        for(int i = 0; i < sieve.length; i++)
        {
            sieve[i] = i;
        }

        //run sieve
        for(int i = 2; i < sieve.length; i++)
        {
            if(sieve[i] == 0)
                continue;
            for(int j = 2*i; j < sieve.length; j += i)
            {
                sieve[j] = 0;
            }
        }
        
        //fill primes
        int primeIndex = 0;
        for(int i = 0; i < sieve.length; i++)
        {
            if(primeIndex == n)
                break;
            if(sieve[i] == 0 || sieve[i] == 1)
                continue;
            primes[primeIndex] = sieve[i];
            primeIndex++;
        }
        return primes;
    }
}