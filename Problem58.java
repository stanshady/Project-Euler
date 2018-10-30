public class Problem58
{
    public static int[] primes = Algorithm.sieve(2200000);
    public static final int MAX_PRIME = primes[primes.length - 1];

    public static int findLessThan10()
    {
        int diagNum1 = 1;
        int diagNum2 = 1;
        int gap1 = 0;
        int gap2 = 0;
        int numPrimes = 0;
        int totalDiag = 1;
        int sideLen = 1;

        int iter = 0;
        while(true)
        {
            totalDiag += 4;
            sideLen += 2;
            
            gap1 += 2;
            diagNum1 += gap1;
            if(diagNum1 <= MAX_PRIME)
            {
                if(Algorithm.binSearch(primes,diagNum1) > -1)
                    numPrimes++;
            }
            else if(isPrime(diagNum1))
                numPrimes++;
            
            gap1 += 2;
            diagNum1 += gap1; 
            if(diagNum1 <= MAX_PRIME)
            {
                if(Algorithm.binSearch(primes,diagNum1) > -1)
                    numPrimes++;
            }
            else if(isPrime(diagNum1))
                numPrimes++;
                
            gap2 += 4;
            diagNum2 += gap2;
            if(diagNum2 <= MAX_PRIME)
            {
                if(Algorithm.binSearch(primes,diagNum2) > -1)
                    numPrimes++;
            }
            else if(isPrime(diagNum2))
                numPrimes++;
                
            diagNum2 += gap2;
            if(diagNum2 <= MAX_PRIME)
            {
                if(Algorithm.binSearch(primes,diagNum2) > -1)
                    numPrimes++;
            }
            else if(isPrime(diagNum2))
                numPrimes++;

            if((double) numPrimes / totalDiag < 0.1)       
            {
                System.out.println(diagNum2);
                return sideLen;
            }

            iter ++;
        }

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
