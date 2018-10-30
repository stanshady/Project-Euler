
public class Problem10
{
    public static long primeSum(int n)
    {
        int[] primes = primes(n);
        long sum = 0;
        for(int i = 0; i < primes.length; i++)
            sum += primes[i];
        return sum;
    }
    
    //returns an array {0,1,...n-1} with nonprime
    //numbers (besides 1) set to 0 
    public static int[] sieve(int n)
    {
        int[] nums = new int[n];
        for(int i = 0; i < n; i++)
        {
            nums[i] = i;
        }
        
        for(int i = 2; i < n; i++)
        {
            if(nums[i] == 0 || nums[i] == 1)
                continue;
                
            for(int j = i + i; j < n; j += i)
            {
                nums[j] = 0;
            }
        }
        return nums;
    }
    
    //returns array of all primes < n
    public static int[] primes(int n)
    {
        int[] temp = sieve(n);
        int count = 0;
        for(int i = 0; i < temp.length; i++)
        {
            if(temp[i] != 0 && temp[i] != 1)
                count++;
        }
        int[] primes = new int[count];
        
        int primeIndex = 0;
        for(int i = 0; i < temp.length; i++)
        {
            if(temp[i] != 0 && temp[i] != 1)
            {
                primes[primeIndex] = temp[i];
                primeIndex++;
            }
        }
        return primes;
    }
}