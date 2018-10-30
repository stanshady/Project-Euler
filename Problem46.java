
public class Problem46
{
    public static int[] primes = Algorithm.sieve(1000000);

    public static int find()
    {
        int n = 9;
        while(n < primes[primes.length - 1])
        {
            if(Algorithm.binSearch(primes,n) == -1 &&
            !isGoldbach(n))
                return n;
            n += 2;
        }
        return -1;    
    }
    
    public static boolean isGoldbach(int n)
    {
        int index = 0;
        boolean gold = false;
        while(n > primes[index] && !gold)
        {
            if(isSquare((n - primes[index]) / 2.0))
                gold = true;
            index++;
        }
        return gold;
    }

    public static boolean isSquare(double n)
    {
        int root = (int) Math.sqrt(n);
        return root * root == n;
    }
}