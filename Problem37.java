
public class Problem37
{
    public static int[] primes = Algorithm.sieve(1000000);

    public static int sum()
    { 
        int count = 0;
        int sum = 0;
        int i = 4;
        
        while(count < 11)
        {
            if(isTruncatable(primes[i]))
            {   
                sum += primes[i];
                count++;
            }
            i++;
        }
        return sum;
    }

    public static boolean isTruncatable(int n)
    {
        int temp = n;
        int numDigits = 0;
        
        while(temp > 0)
        {
            //remove digits right to left
            if(Algorithm.binSearch(primes, temp) == -1)
                return false;
            temp /= 10;
            numDigits++;
        }  
            
        while(n > 0)
        {
            //remove digits left to right
            if(Algorithm.binSearch(primes, n) == -1)              
                return false;         
            n %= (int) Math.pow(10,numDigits - 1);
            numDigits--;
        }   
        return true;
    }

}
